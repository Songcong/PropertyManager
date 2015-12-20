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
import org.springframework.transaction.annotation.Transactional;

import dao.IPublicUtilityManageDao;
import Model.PublicUtilityManage;
import Utilx.DBUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * PublicUtilityManage entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Model.PublicUtilityManage
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class PublicUtilityManageDAO implements IPublicUtilityManageDao {
	private static final Logger log = LoggerFactory
			.getLogger(PublicUtilityManageDAO.class);
	// property constants
	public static final String UTILITYID = "utilityid";
	public static final String PRINCIPAL = "principal";
	public static final String LOCATION = "location";
	public static final String UTILITYMANAGEINFO = "utilitymanageinfo";

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

	public void save(PublicUtilityManage transientInstance) {
		log.debug("saving PublicUtilityManage instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PublicUtilityManage persistentInstance) {
		log.debug("deleting PublicUtilityManage instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PublicUtilityManage findById(java.lang.Integer id) {
		log.debug("getting PublicUtilityManage instance with id: " + id);
		try {
			PublicUtilityManage instance = (PublicUtilityManage) getCurrentSession()
					.get("Model.PublicUtilityManage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PublicUtilityManage> findByExample(PublicUtilityManage instance) {
		log.debug("finding PublicUtilityManage instance by example");
		try {
			List<PublicUtilityManage> results = (List<PublicUtilityManage>) getCurrentSession()
					.createCriteria("Model.PublicUtilityManage")
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
		log.debug("finding PublicUtilityManage instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PublicUtilityManage as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PublicUtilityManage> findByUtilityid(Object utilityid) {
		return findByProperty(UTILITYID, utilityid);
	}

	public List<PublicUtilityManage> findByPrincipal(Object principal) {
		return findByProperty(PRINCIPAL, principal);
	}

	public List<PublicUtilityManage> findByLocation(Object location) {
		return findByProperty(LOCATION, location);
	}

	public List<PublicUtilityManage> findByUtilitymanageinfo(
			Object utilitymanageinfo) {
		return findByProperty(UTILITYMANAGEINFO, utilitymanageinfo);
	}

	public List findAll() {
		log.debug("finding all PublicUtilityManage instances");
		try {
			String queryString = "from PublicUtilityManage";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PublicUtilityManage merge(PublicUtilityManage detachedInstance) {
		log.debug("merging PublicUtilityManage instance");
		try {
			PublicUtilityManage result = (PublicUtilityManage) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PublicUtilityManage instance) {
		log.debug("attaching dirty PublicUtilityManage instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PublicUtilityManage instance) {
		log.debug("attaching clean PublicUtilityManage instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PublicUtilityManageDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PublicUtilityManageDAO) ctx.getBean("PublicUtilityManageDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from PublicUtilityManage where utility_manage_id="+id;
		db.update(sql);
		
	}
}