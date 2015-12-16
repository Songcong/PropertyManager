package daoimp;

import java.util.List;

import javax.annotation.Resource;

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

import dao.IUserinfoDao;
import Model.Userinfo;
import Utilx.DBUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Model.Userinfo
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository("userinfoDAO")
public class UserinfoDAO implements IUserinfoDao {
	private static final Logger log = LoggerFactory
			.getLogger(UserinfoDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String REALNAME = "realname";
	public static final String SEX = "sex";
	public static final String TELNUMBER = "telnumber";
	public static final String EMAIL = "email";
	public static final String ADDRESS = "address";
	public static final String TAG = "tag";

	@Resource(name="sessionFactory")
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

	public void save(Userinfo transientInstance) {
		log.debug("saving Userinfo instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userinfo persistentInstance) {
		log.debug("deleting Userinfo instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	public Userinfo findById(java.lang.Integer id) {
		log.debug("getting Userinfo instance with id: " + id);
		try {
			Userinfo instance = (Userinfo) getCurrentSession().get(
					"Model.Userinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Userinfo> findByExample(Userinfo instance) {
		log.debug("finding Userinfo instance by example");
		try {
			List<Userinfo> results = (List<Userinfo>) getCurrentSession()
					.createCriteria("Model.Userinfo").add(create(instance))
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
		log.debug("finding Userinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Userinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Userinfo> findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List<Userinfo> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<Userinfo> findByRealname(Object realname) {
		return findByProperty(REALNAME, realname);
	}

	public List<Userinfo> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<Userinfo> findByTelnumber(Object telnumber) {
		return findByProperty(TELNUMBER, telnumber);
	}

	public List<Userinfo> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<Userinfo> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Userinfo> findByTag(Object tag) {
		return findByProperty(TAG, tag);
	}

	public List findAll() {
		log.debug("finding all Userinfo instances");
		try {
			String queryString = "from Userinfo";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userinfo merge(Userinfo detachedInstance) {
		log.debug("merging Userinfo instance");
		try {
			Userinfo result = (Userinfo) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userinfo instance) {
		log.debug("attaching dirty Userinfo instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userinfo instance) {
		log.debug("attaching clean Userinfo instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserinfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserinfoDAO) ctx.getBean("UserinfoDAO");
	}
	
	public List<Userinfo> Login(Userinfo userinfo){
		
		//String str[]={login.getUsername(),login.getPassword()};
		 Query query = this.getCurrentSession().createQuery("from Userinfo where username='"+userinfo.getUsername()+"' and password='"+userinfo.getPassword()+"'");
		 List find =query.list();
		return find;
	}
	
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from Userinfo where userid="+id;
		db.update(sql);
		
	}
	
}