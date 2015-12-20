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

import dao.IHouseOwnerManageDao;
import Model.HouseOwnerManage;
import Utilx.DBUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * HouseOwnerManage entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Model.HouseOwnerManage
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class HouseOwnerManageDAO implements IHouseOwnerManageDao {
	private static final Logger log = LoggerFactory
			.getLogger(HouseOwnerManageDAO.class);
	// property constants
	public static final String HOUSEID = "houseid";
	public static final String NAME = "name";
	public static final String SEX = "sex";
	public static final String DOCUMENTATION = "documentation";
	public static final String ORIGIN = "origin";
	public static final String RENTSTATE = "rentstate";

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

	public void save(HouseOwnerManage transientInstance) {
		log.debug("saving HouseOwnerManage instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(HouseOwnerManage persistentInstance) {
		log.debug("deleting HouseOwnerManage instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HouseOwnerManage findById(java.lang.Integer id) {
		log.debug("getting HouseOwnerManage instance with id: " + id);
		try {
			HouseOwnerManage instance = (HouseOwnerManage) getCurrentSession()
					.get("Model.HouseOwnerManage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<HouseOwnerManage> findByExample(HouseOwnerManage instance) {
		log.debug("finding HouseOwnerManage instance by example");
		try {
			List<HouseOwnerManage> results = (List<HouseOwnerManage>) getCurrentSession()
					.createCriteria("Model.HouseOwnerManage")
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
		log.debug("finding HouseOwnerManage instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from HouseOwnerManage as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<HouseOwnerManage> findByHouseid(Object houseid) {
		return findByProperty(HOUSEID, houseid);
	}

	public List<HouseOwnerManage> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<HouseOwnerManage> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<HouseOwnerManage> findByDocumentation(Object documentation) {
		return findByProperty(DOCUMENTATION, documentation);
	}

	public List<HouseOwnerManage> findByOrigin(Object origin) {
		return findByProperty(ORIGIN, origin);
	}

	public List<HouseOwnerManage> findByRentstate(Object rentstate) {
		return findByProperty(RENTSTATE, rentstate);
	}

	public List findAll() {
		log.debug("finding all HouseOwnerManage instances");
		try {
			String queryString = "from HouseOwnerManage";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public HouseOwnerManage merge(HouseOwnerManage detachedInstance) {
		log.debug("merging HouseOwnerManage instance");
		try {
			HouseOwnerManage result = (HouseOwnerManage) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(HouseOwnerManage instance) {
		log.debug("attaching dirty HouseOwnerManage instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HouseOwnerManage instance) {
		log.debug("attaching clean HouseOwnerManage instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static HouseOwnerManageDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (HouseOwnerManageDAO) ctx.getBean("HouseOwnerManageDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from HouseOwnerManage where manage_id="+id;
		db.update(sql);
		
	}
}