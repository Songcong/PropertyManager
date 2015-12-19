package daoimp;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.IExpensetypeDao;
import Model.Expensetype;
import Utilx.DBUtil;

import javax.annotation.Resource;

/**
 * A data access object (DAO) providing persistence and search support for
 * Expensetype entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Model.Expensetype
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository("expensetypeDAO")
public class ExpensetypeDAO implements IExpensetypeDao {
	private static final Logger log = LoggerFactory
			.getLogger(ExpensetypeDAO.class);
	// property constants
	public static final String STAN_ID = "stanId";
	public static final String EXPENSENAME = "expensename";
	public static final String CHARSTANID = "charstanid";
	public static final String EXPENSEINFO = "expenseinfo";

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Expensetype transientInstance) {
		log.debug("saving Expensetype instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Expensetype persistentInstance) {
		log.debug("deleting Expensetype instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Expensetype findById(java.lang.Integer id) {
		log.debug("getting Expensetype instance with id: " + id);
		try {
			Expensetype instance = (Expensetype) getCurrentSession().get(
					"Model.Expensetype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Expensetype> findByExample(Expensetype instance) {
		log.debug("finding Expensetype instance by example");
		try {
			List<Expensetype> results = (List<Expensetype>) getCurrentSession()
					.createCriteria("Model.Expensetype").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Expensetype instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Expensetype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Expensetype> findByStanId(Object stanId) {
		return findByProperty(STAN_ID, stanId);
	}

	public List<Expensetype> findByExpensename(Object expensename) {
		return findByProperty(EXPENSENAME, expensename);
	}

	public List<Expensetype> findByCharstanid(Object charstanid) {
		return findByProperty(CHARSTANID, charstanid);
	}

	public List<Expensetype> findByExpenseinfo(Object expenseinfo) {
		return findByProperty(EXPENSEINFO, expenseinfo);
	}

	public List findAll() {
		log.debug("finding all Expensetype instances");
		try {
			String queryString = "from Expensetype";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Expensetype merge(Expensetype detachedInstance) {
		log.debug("merging Expensetype instance");
		try {
			Expensetype result = (Expensetype) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Expensetype instance) {
		log.debug("attaching dirty Expensetype instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Expensetype instance) {
		log.debug("attaching clean Expensetype instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ExpensetypeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ExpensetypeDAO) ctx.getBean("ExpensetypeDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from Expensetype where expense_id="+id;
		db.update(sql);
		
	}
}