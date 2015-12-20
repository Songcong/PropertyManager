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

import dao.IFitmentDao;
import Model.Fitment;
import Utilx.DBUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * Fitment entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Model.Fitment
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class FitmentDAO implements IFitmentDao {
	private static final Logger log = LoggerFactory.getLogger(FitmentDAO.class);
	// property constants
	public static final String PLACE = "place";
	public static final String REMOVE = "remove";

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

	public void save(Fitment transientInstance) {
		log.debug("saving Fitment instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Fitment persistentInstance) {
		log.debug("deleting Fitment instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Fitment findById(java.lang.Integer id) {
		log.debug("getting Fitment instance with id: " + id);
		try {
			Fitment instance = (Fitment) getCurrentSession().get(
					"Model.Fitment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Fitment> findByExample(Fitment instance) {
		log.debug("finding Fitment instance by example");
		try {
			List<Fitment> results = (List<Fitment>) getCurrentSession()
					.createCriteria("Model.Fitment").add(create(instance))
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
		log.debug("finding Fitment instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Fitment as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Fitment> findByPlace(Object place) {
		return findByProperty(PLACE, place);
	}

	public List<Fitment> findByRemove(Object remove) {
		return findByProperty(REMOVE, remove);
	}

	public List findAll() {
		log.debug("finding all Fitment instances");
		try {
			String queryString = "from Fitment";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Fitment merge(Fitment detachedInstance) {
		log.debug("merging Fitment instance");
		try {
			Fitment result = (Fitment) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Fitment instance) {
		log.debug("attaching dirty Fitment instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Fitment instance) {
		log.debug("attaching clean Fitment instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FitmentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FitmentDAO) ctx.getBean("FitmentDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from Fitment where fitment_id="+id;
		db.update(sql);
		
	}
}