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

import dao.IUtilityDetailDao;
import Model.UtilityDetail;
import Utilx.DBUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * UtilityDetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Model.UtilityDetail
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UtilityDetailDAO implements IUtilityDetailDao {
	private static final Logger log = LoggerFactory
			.getLogger(UtilityDetailDAO.class);
	// property constants
	public static final String UTILITY_MANAGE_ID = "utilityManageId";
	public static final String UTILITYINFO = "utilityinfo";
	public static final String BUYPLACE = "buyplace";
	public static final String BUYINFO = "buyinfo";
	public static final String USERINFO = "userinfo";
	public static final String FLAG = "flag";

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

	public void save(UtilityDetail transientInstance) {
		log.debug("saving UtilityDetail instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UtilityDetail persistentInstance) {
		log.debug("deleting UtilityDetail instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UtilityDetail findById(java.lang.Integer id) {
		log.debug("getting UtilityDetail instance with id: " + id);
		try {
			UtilityDetail instance = (UtilityDetail) getCurrentSession().get(
					"Model.UtilityDetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<UtilityDetail> findByExample(UtilityDetail instance) {
		log.debug("finding UtilityDetail instance by example");
		try {
			List<UtilityDetail> results = (List<UtilityDetail>) getCurrentSession()
					.createCriteria("Model.UtilityDetail")
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
		log.debug("finding UtilityDetail instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UtilityDetail as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<UtilityDetail> findByUtilityManageId(Object utilityManageId) {
		return findByProperty(UTILITY_MANAGE_ID, utilityManageId);
	}

	public List<UtilityDetail> findByUtilityinfo(Object utilityinfo) {
		return findByProperty(UTILITYINFO, utilityinfo);
	}

	public List<UtilityDetail> findByBuyplace(Object buyplace) {
		return findByProperty(BUYPLACE, buyplace);
	}

	public List<UtilityDetail> findByBuyinfo(Object buyinfo) {
		return findByProperty(BUYINFO, buyinfo);
	}

	public List<UtilityDetail> findByUserinfo(Object userinfo) {
		return findByProperty(USERINFO, userinfo);
	}

	public List<UtilityDetail> findByFlag(Object flag) {
		return findByProperty(FLAG, flag);
	}

	public List findAll() {
		log.debug("finding all UtilityDetail instances");
		try {
			String queryString = "from UtilityDetail";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UtilityDetail merge(UtilityDetail detachedInstance) {
		log.debug("merging UtilityDetail instance");
		try {
			UtilityDetail result = (UtilityDetail) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UtilityDetail instance) {
		log.debug("attaching dirty UtilityDetail instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UtilityDetail instance) {
		log.debug("attaching clean UtilityDetail instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UtilityDetailDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UtilityDetailDAO) ctx.getBean("UtilityDetailDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from UtilityDetail where utility_id="+id;
		db.update(sql);
		
	}
}