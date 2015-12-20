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

import dao.IStaffinfoDao;
import Model.Staffinfo;
import Utilx.DBUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * Staffinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Model.Staffinfo
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class StaffinfoDAO implements IStaffinfoDao {
	private static final Logger log = LoggerFactory
			.getLogger(StaffinfoDAO.class);
	// property constants
	public static final String OCCUPATION_ID = "occupationId";
	public static final String REALNAME = "realname";
	public static final String SEX = "sex";
	public static final String ADDRESS = "address";
	public static final String EMAIL = "email";
	public static final String OCCUPATIONID = "occupationid";
	public static final String WORKSTATE = "workstate";

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

	public void save(Staffinfo transientInstance) {
		log.debug("saving Staffinfo instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Staffinfo persistentInstance) {
		log.debug("deleting Staffinfo instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Staffinfo findById(java.lang.Integer id) {
		log.debug("getting Staffinfo instance with id: " + id);
		try {
			Staffinfo instance = (Staffinfo) getCurrentSession().get(
					"Model.Staffinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Staffinfo> findByExample(Staffinfo instance) {
		log.debug("finding Staffinfo instance by example");
		try {
			List<Staffinfo> results = (List<Staffinfo>) getCurrentSession()
					.createCriteria("Model.Staffinfo").add(create(instance))
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
		log.debug("finding Staffinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Staffinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Staffinfo> findByOccupationId(Object occupationId) {
		return findByProperty(OCCUPATION_ID, occupationId);
	}

	public List<Staffinfo> findByRealname(Object realname) {
		return findByProperty(REALNAME, realname);
	}

	public List<Staffinfo> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<Staffinfo> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Staffinfo> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<Staffinfo> findByOccupationid(Object occupationid) {
		return findByProperty(OCCUPATIONID, occupationid);
	}

	public List<Staffinfo> findByWorkstate(Object workstate) {
		return findByProperty(WORKSTATE, workstate);
	}

	public List findAll() {
		log.debug("finding all Staffinfo instances");
		try {
			String queryString = "from Staffinfo";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Staffinfo merge(Staffinfo detachedInstance) {
		log.debug("merging Staffinfo instance");
		try {
			Staffinfo result = (Staffinfo) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Staffinfo instance) {
		log.debug("attaching dirty Staffinfo instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Staffinfo instance) {
		log.debug("attaching clean Staffinfo instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StaffinfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StaffinfoDAO) ctx.getBean("StaffinfoDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from Staffinfo where staff_id="+id;
		db.update(sql);
		
	}
}