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

import dao.IOccupationDao;
import Model.Occupation;
import Utilx.DBUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * Occupation entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Model.Occupation
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class OccupationDAO implements IOccupationDao {
	private static final Logger log = LoggerFactory
			.getLogger(OccupationDAO.class);
	// property constants
	public static final String OCCUPATIONNAME = "occupationname";
	public static final String SALARY = "salary";
	public static final String DESCRIPTION = "description";
	public static final String HEADCOUNT = "headcount";
	public static final String WORKCOUNT = "workcount";

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

	public void save(Occupation transientInstance) {
		log.debug("saving Occupation instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Occupation persistentInstance) {
		log.debug("deleting Occupation instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Occupation findById(java.lang.Integer id) {
		log.debug("getting Occupation instance with id: " + id);
		try {
			Occupation instance = (Occupation) getCurrentSession().get(
					"Model.Occupation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Occupation> findByExample(Occupation instance) {
		log.debug("finding Occupation instance by example");
		try {
			List<Occupation> results = (List<Occupation>) getCurrentSession()
					.createCriteria("Model.Occupation").add(create(instance))
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
		log.debug("finding Occupation instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Occupation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Occupation> findByOccupationname(Object occupationname) {
		return findByProperty(OCCUPATIONNAME, occupationname);
	}

	public List<Occupation> findBySalary(Object salary) {
		return findByProperty(SALARY, salary);
	}

	public List<Occupation> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List<Occupation> findByHeadcount(Object headcount) {
		return findByProperty(HEADCOUNT, headcount);
	}

	public List<Occupation> findByWorkcount(Object workcount) {
		return findByProperty(WORKCOUNT, workcount);
	}

	public List findAll() {
		log.debug("finding all Occupation instances");
		try {
			String queryString = "from Occupation";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Occupation merge(Occupation detachedInstance) {
		log.debug("merging Occupation instance");
		try {
			Occupation result = (Occupation) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Occupation instance) {
		log.debug("attaching dirty Occupation instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Occupation instance) {
		log.debug("attaching clean Occupation instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OccupationDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OccupationDAO) ctx.getBean("OccupationDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from Occupation where occupation_id="+id;
		db.update(sql);
		
	}
}