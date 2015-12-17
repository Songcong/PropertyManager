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

import dao.ICarmanageDao;
import Model.Carmanage;
import Utilx.DBUtil;
import javax.annotation.Resource;

/**
 * A data access object (DAO) providing persistence and search support for
 * Carmanage entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Model.Carmanage
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository("carmanageDAO")
public class CarmanageDAO implements ICarmanageDao {
	private static final Logger log = LoggerFactory
			.getLogger(CarmanageDAO.class);
	// property constants
	public static final String CARID = "carid";
	public static final String COST = "cost";
	public static final String PARTID = "partid";

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

	public void save(Carmanage transientInstance) {
		log.debug("saving Carmanage instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Carmanage persistentInstance) {
		log.debug("deleting Carmanage instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Carmanage findById(java.lang.Integer id) {
		log.debug("getting Carmanage instance with id: " + id);
		try {
			Carmanage instance = (Carmanage) getCurrentSession().get(
					"Model.Carmanage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Carmanage> findByExample(Carmanage instance) {
		log.debug("finding Carmanage instance by example");
		try {
			List<Carmanage> results = (List<Carmanage>) getCurrentSession()
					.createCriteria("Model.Carmanage").add(create(instance))
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
		log.debug("finding Carmanage instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Carmanage as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Carmanage> findByCarid(Object carid) {
		return findByProperty(CARID, carid);
	}

	public List<Carmanage> findByCost(Object cost) {
		return findByProperty(COST, cost);
	}

	public List<Carmanage> findByPartid(Object partid) {
		return findByProperty(PARTID, partid);
	}

	public List findAll() {
		log.debug("finding all Carmanage instances");
		try {
			String queryString = "from Carmanage";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Carmanage merge(Carmanage detachedInstance) {
		log.debug("merging Carmanage instance");
		try {
			Carmanage result = (Carmanage) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Carmanage instance) {
		log.debug("attaching dirty Carmanage instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Carmanage instance) {
		log.debug("attaching clean Carmanage instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CarmanageDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CarmanageDAO) ctx.getBean("CarmanageDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from  Carmanage where carmanageid="+id;
		db.update(sql);
		
	}
}