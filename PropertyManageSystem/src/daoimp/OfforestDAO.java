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

import dao.IOfforestDao;
import Model.Offorest;
import Utilx.DBUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * Offorest entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Model.Offorest
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class OfforestDAO implements IOfforestDao {
	private static final Logger log = LoggerFactory
			.getLogger(OfforestDAO.class);
	// property constants
	public static final String AFFORESTPLACE = "afforestplace";
	public static final String PEOPLE = "people";
	public static final String DELETED = "deleted";

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

	public void save(Offorest transientInstance) {
		log.debug("saving Offorest instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Offorest persistentInstance) {
		log.debug("deleting Offorest instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Offorest findById(java.lang.Integer id) {
		log.debug("getting Offorest instance with id: " + id);
		try {
			Offorest instance = (Offorest) getCurrentSession().get(
					"Model.Offorest", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Offorest> findByExample(Offorest instance) {
		log.debug("finding Offorest instance by example");
		try {
			List<Offorest> results = (List<Offorest>) getCurrentSession()
					.createCriteria("Model.Offorest").add(create(instance))
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
		log.debug("finding Offorest instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Offorest as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Offorest> findByAfforestplace(Object afforestplace) {
		return findByProperty(AFFORESTPLACE, afforestplace);
	}

	public List<Offorest> findByPeople(Object people) {
		return findByProperty(PEOPLE, people);
	}

	public List<Offorest> findByDeleted(Object deleted) {
		return findByProperty(DELETED, deleted);
	}

	public List findAll() {
		log.debug("finding all Offorest instances");
		try {
			String queryString = "from Offorest";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Offorest merge(Offorest detachedInstance) {
		log.debug("merging Offorest instance");
		try {
			Offorest result = (Offorest) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Offorest instance) {
		log.debug("attaching dirty Offorest instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Offorest instance) {
		log.debug("attaching clean Offorest instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OfforestDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OfforestDAO) ctx.getBean("OfforestDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from Offorest where afforest_id="+id;
		db.update(sql);
		
	}
}