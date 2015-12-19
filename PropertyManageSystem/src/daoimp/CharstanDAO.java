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

import dao.ICharstanDao;
import Model.Charstan;
import Utilx.DBUtil;

import javax.annotation.Resource;

/**
 * A data access object (DAO) providing persistence and search support for
 * Charstan entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Model.Charstan
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository("charstanDAO")
public class CharstanDAO implements ICharstanDao {
	private static final Logger log = LoggerFactory
			.getLogger(CharstanDAO.class);
	// property constants
	public static final String EXPDETAIL_ID = "expdetailId";
	public static final String DESCRIPTION = "description";

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

	public void save(Charstan transientInstance) {
		log.debug("saving Charstan instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Charstan persistentInstance) {
		log.debug("deleting Charstan instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Charstan findById(java.lang.Integer id) {
		log.debug("getting Charstan instance with id: " + id);
		try {
			Charstan instance = (Charstan) getCurrentSession().get(
					"Model.Charstan", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Charstan> findByExample(Charstan instance) {
		log.debug("finding Charstan instance by example");
		try {
			List<Charstan> results = (List<Charstan>) getCurrentSession()
					.createCriteria("Model.Charstan").add(create(instance))
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
		log.debug("finding Charstan instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Charstan as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Charstan> findByExpdetailId(Object expdetailId) {
		return findByProperty(EXPDETAIL_ID, expdetailId);
	}

	public List<Charstan> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all Charstan instances");
		try {
			String queryString = "from Charstan";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Charstan merge(Charstan detachedInstance) {
		log.debug("merging Charstan instance");
		try {
			Charstan result = (Charstan) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Charstan instance) {
		log.debug("attaching dirty Charstan instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Charstan instance) {
		log.debug("attaching clean Charstan instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CharstanDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CharstanDAO) ctx.getBean("CharstanDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from Charstan where stan_id="+id;
		db.update(sql);
		
	}
}