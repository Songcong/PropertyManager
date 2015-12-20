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

import dao.IServiceDao;
import Model.Service;
import Utilx.DBUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * Service entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Model.Service
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ServiceDAO implements IServiceDao{
	private static final Logger log = LoggerFactory.getLogger(ServiceDAO.class);
	// property constants
	public static final String FACILITYPRO = "facilitypro";
	public static final String PLACE = "place";
	public static final String ISSOLVE = "issolve";
	public static final String SOLVEPEOPLE = "solvepeople";
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

	public void save(Service transientInstance) {
		log.debug("saving Service instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Service persistentInstance) {
		log.debug("deleting Service instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Service findById(java.lang.Integer id) {
		log.debug("getting Service instance with id: " + id);
		try {
			Service instance = (Service) getCurrentSession().get(
					"Model.Service", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Service> findByExample(Service instance) {
		log.debug("finding Service instance by example");
		try {
			List<Service> results = (List<Service>) getCurrentSession()
					.createCriteria("Model.Service").add(create(instance))
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
		log.debug("finding Service instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Service as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Service> findByFacilitypro(Object facilitypro) {
		return findByProperty(FACILITYPRO, facilitypro);
	}

	public List<Service> findByPlace(Object place) {
		return findByProperty(PLACE, place);
	}

	public List<Service> findByIssolve(Object issolve) {
		return findByProperty(ISSOLVE, issolve);
	}

	public List<Service> findBySolvepeople(Object solvepeople) {
		return findByProperty(SOLVEPEOPLE, solvepeople);
	}

	public List<Service> findByDeleted(Object deleted) {
		return findByProperty(DELETED, deleted);
	}

	public List findAll() {
		log.debug("finding all Service instances");
		try {
			String queryString = "from Service";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Service merge(Service detachedInstance) {
		log.debug("merging Service instance");
		try {
			Service result = (Service) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Service instance) {
		log.debug("attaching dirty Service instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Service instance) {
		log.debug("attaching clean Service instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ServiceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ServiceDAO) ctx.getBean("ServiceDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from Service where service_id="+id;
		db.update(sql);
		
	}
}