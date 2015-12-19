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

import dao.IStallDao;
import Model.Stall;
import Utilx.DBUtil;

import javax.annotation.Resource;

/**
 * A data access object (DAO) providing persistence and search support for Stall
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see Model.Stall
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository("stallDAO")
public class StallDAO implements IStallDao {
	private static final Logger log = LoggerFactory.getLogger(StallDAO.class);
	// property constants
	public static final String LOCATION = "location";
	public static final String ISUSED = "isused";
	public static final String ISUSE = "isuse";

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

	public void save(Stall transientInstance) {
		log.debug("saving Stall instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Stall persistentInstance) {
		log.debug("deleting Stall instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Stall findById(java.lang.Integer id) {
		log.debug("getting Stall instance with id: " + id);
		try {
			Stall instance = (Stall) getCurrentSession().get("Model.Stall", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Stall> findByExample(Stall instance) {
		log.debug("finding Stall instance by example");
		try {
			List<Stall> results = (List<Stall>) getCurrentSession()
					.createCriteria("Model.Stall").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Stall instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Stall as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Stall> findByLocation(Object location) {
		return findByProperty(LOCATION, location);
	}

	public List<Stall> findByIsused(Object isused) {
		return findByProperty(ISUSED, isused);
	}

	public List<Stall> findByIsuse(Object isuse) {
		return findByProperty(ISUSE, isuse);
	}

	public List findAll() {
		log.debug("finding all Stall instances");
		try {
			String queryString = "from Stall";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Stall merge(Stall detachedInstance) {
		log.debug("merging Stall instance");
		try {
			Stall result = (Stall) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Stall instance) {
		log.debug("attaching dirty Stall instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Stall instance) {
		log.debug("attaching clean Stall instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StallDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StallDAO) ctx.getBean("StallDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from Stall where stall_id="+id;
		db.update(sql);
		
	}
}