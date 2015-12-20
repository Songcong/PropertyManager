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
import org.springframework.transaction.annotation.Transactional;

import dao.IUtilityDamageDao;
import Model.UtilityDamage;
import Utilx.DBUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * UtilityDamage entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Model.UtilityDamage
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UtilityDamageDAO implements IUtilityDamageDao{
	private static final Logger log = LoggerFactory
			.getLogger(UtilityDamageDAO.class);
	// property constants
	public static final String UTILITYID = "utilityid";
	public static final String USECONDITION = "usecondition";
	public static final String DAMAGECONDITION = "damagecondition";

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

	public void save(UtilityDamage transientInstance) {
		log.debug("saving UtilityDamage instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UtilityDamage persistentInstance) {
		log.debug("deleting UtilityDamage instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UtilityDamage findById(java.lang.Integer id) {
		log.debug("getting UtilityDamage instance with id: " + id);
		try {
			UtilityDamage instance = (UtilityDamage) getCurrentSession().get(
					"Model.UtilityDamage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<UtilityDamage> findByExample(UtilityDamage instance) {
		log.debug("finding UtilityDamage instance by example");
		try {
			List<UtilityDamage> results = (List<UtilityDamage>) getCurrentSession()
					.createCriteria("Model.UtilityDamage")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding UtilityDamage instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UtilityDamage as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<UtilityDamage> findByUtilityid(Object utilityid) {
		return findByProperty(UTILITYID, utilityid);
	}

	public List<UtilityDamage> findByUsecondition(Object usecondition) {
		return findByProperty(USECONDITION, usecondition);
	}

	public List<UtilityDamage> findByDamagecondition(Object damagecondition) {
		return findByProperty(DAMAGECONDITION, damagecondition);
	}

	public List findAll() {
		log.debug("finding all UtilityDamage instances");
		try {
			String queryString = "from UtilityDamage";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UtilityDamage merge(UtilityDamage detachedInstance) {
		log.debug("merging UtilityDamage instance");
		try {
			UtilityDamage result = (UtilityDamage) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UtilityDamage instance) {
		log.debug("attaching dirty UtilityDamage instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UtilityDamage instance) {
		log.debug("attaching clean UtilityDamage instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UtilityDamageDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UtilityDamageDAO) ctx.getBean("UtilityDamageDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from UtilityDamage where utilitydamageid="+id;
		db.update(sql);
		
	}
}