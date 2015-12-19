package daoimp;

import java.sql.Timestamp;
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

import dao.IExpdetailDao;
import Model.Expdetail;
import Utilx.DBUtil;

import javax.annotation.Resource;

/**
 * A data access object (DAO) providing persistence and search support for
 * Expdetail entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Model.Expdetail
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository("expdetailDAO")
public class ExpdetailDAO implements IExpdetailDao {
	private static final Logger log = LoggerFactory
			.getLogger(ExpdetailDAO.class);
	// property constants
	public static final String EXPENSEID = "expenseid";
	public static final String HOUSEID = "houseid";
	public static final String STATE = "state";
	public static final String CHARGEPEOPLE = "chargepeople";
	public static final String DELETED = "deleted";

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

	public void save(Expdetail transientInstance) {
		log.debug("saving Expdetail instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Expdetail persistentInstance) {
		log.debug("deleting Expdetail instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Expdetail findById(java.lang.Integer id) {
		log.debug("getting Expdetail instance with id: " + id);
		try {
			Expdetail instance = (Expdetail) getCurrentSession().get(
					"Model.Expdetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Expdetail> findByExample(Expdetail instance) {
		log.debug("finding Expdetail instance by example");
		try {
			List<Expdetail> results = (List<Expdetail>) getCurrentSession()
					.createCriteria("Model.Expdetail").add(create(instance))
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
		log.debug("finding Expdetail instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Expdetail as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Expdetail> findByExpenseid(Object expenseid) {
		return findByProperty(EXPENSEID, expenseid);
	}

	public List<Expdetail> findByHouseid(Object houseid) {
		return findByProperty(HOUSEID, houseid);
	}

	public List<Expdetail> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Expdetail> findByChargepeople(Object chargepeople) {
		return findByProperty(CHARGEPEOPLE, chargepeople);
	}

	public List<Expdetail> findByDeleted(Object deleted) {
		return findByProperty(DELETED, deleted);
	}

	public List findAll() {
		log.debug("finding all Expdetail instances");
		try {
			String queryString = "from Expdetail";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Expdetail merge(Expdetail detachedInstance) {
		log.debug("merging Expdetail instance");
		try {
			Expdetail result = (Expdetail) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Expdetail instance) {
		log.debug("attaching dirty Expdetail instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Expdetail instance) {
		log.debug("attaching clean Expdetail instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ExpdetailDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ExpdetailDAO) ctx.getBean("ExpdetailDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from Expdetail where expdetail_id="+id;
		db.update(sql);
		
	}
}