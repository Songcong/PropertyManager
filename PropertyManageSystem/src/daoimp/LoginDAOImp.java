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

import dao.LoginDao;
import Model.Login;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A data access object (DAO) providing persistence and search support for Login
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see Model.Login
 * @author MyEclipse Persistence Tools
 */
@Transactional

public class LoginDAOImp implements LoginDao {
	private static final Logger log = LoggerFactory.getLogger(LoginDAOImp.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";

	
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

	public void save(Login transientInstance) {
		log.debug("saving Login instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Login persistentInstance) {
		log.debug("deleting Login instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Login findById(java.lang.Integer id) {
		log.debug("getting Login instance with id: " + id);
		try {
			Login instance = (Login) getCurrentSession().get("Model.Login", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Login> findByExample(Login instance) {
		log.debug("finding Login instance by example");
		try {
			List<Login> results = (List<Login>) getCurrentSession()
					.createCriteria("Model.Login").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Login instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Login as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Login> findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List<Login> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findAll() {
		log.debug("finding all Login instances");
		try {
			String queryString = "from Login";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Login merge(Login detachedInstance) {
		log.debug("merging Login instance");
		try {
			Login result = (Login) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Login instance) {
		log.debug("attaching dirty Login instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Login instance) {
		log.debug("attaching clean Login instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LoginDAOImp getFromApplicationContext(ApplicationContext ctx) {
		return (LoginDAOImp) ctx.getBean("LoginDAO");
	}
	
	public List<Login> Login(Login login){
		
		//String str[]={login.getUsername(),login.getPassword()};
		 Query query = this.getCurrentSession().createQuery("from Login where username='"+login.getUsername()+"' and password='"+login.getPassword()+"'");
		 List find =query.list();
		return find;
	}
}