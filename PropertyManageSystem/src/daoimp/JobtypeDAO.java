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

import dao.IJobtypeDao;
import Model.Jobtype;
import Utilx.DBUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * Jobtype entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Model.Jobtype
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class JobtypeDAO implements IJobtypeDao {
	private static final Logger log = LoggerFactory.getLogger(JobtypeDAO.class);
	// property constants
	public static final String JOBNAME = "jobname";
	public static final String JOBINFO = "jobinfo";
	public static final String TOTALNUM = "totalnum";
	public static final String NOWNUM = "nownum";

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

	public void save(Jobtype transientInstance) {
		log.debug("saving Jobtype instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Jobtype persistentInstance) {
		log.debug("deleting Jobtype instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Jobtype findById(java.lang.Integer id) {
		log.debug("getting Jobtype instance with id: " + id);
		try {
			Jobtype instance = (Jobtype) getCurrentSession().get(
					"Model.Jobtype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Jobtype> findByExample(Jobtype instance) {
		log.debug("finding Jobtype instance by example");
		try {
			List<Jobtype> results = (List<Jobtype>) getCurrentSession()
					.createCriteria("Model.Jobtype").add(create(instance))
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
		log.debug("finding Jobtype instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Jobtype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Jobtype> findByJobname(Object jobname) {
		return findByProperty(JOBNAME, jobname);
	}

	public List<Jobtype> findByJobinfo(Object jobinfo) {
		return findByProperty(JOBINFO, jobinfo);
	}

	public List<Jobtype> findByTotalnum(Object totalnum) {
		return findByProperty(TOTALNUM, totalnum);
	}

	public List<Jobtype> findByNownum(Object nownum) {
		return findByProperty(NOWNUM, nownum);
	}

	public List findAll() {
		log.debug("finding all Jobtype instances");
		try {
			String queryString = "from Jobtype";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Jobtype merge(Jobtype detachedInstance) {
		log.debug("merging Jobtype instance");
		try {
			Jobtype result = (Jobtype) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Jobtype instance) {
		log.debug("attaching dirty Jobtype instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Jobtype instance) {
		log.debug("attaching clean Jobtype instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JobtypeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (JobtypeDAO) ctx.getBean("JobtypeDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from Jobtype where jobtype_id="+id;
		db.update(sql);
		
	}
}