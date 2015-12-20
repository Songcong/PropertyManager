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

import dao.IChartDao;
import Model.Chart;
import Utilx.DBUtil;

/**
 * A data access object (DAO) providing persistence and search support for Chart
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see Model.Chart
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ChartDAO implements IChartDao {
	private static final Logger log = LoggerFactory.getLogger(ChartDAO.class);
	// property constants
	public static final String CONVOBJID = "convobjid";
	public static final String CONVOBJNAME = "convobjname";
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String CONVERSATION = "conversation";
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

	public void save(Chart transientInstance) {
		log.debug("saving Chart instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Chart persistentInstance) {
		log.debug("deleting Chart instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Chart findById(java.lang.Integer id) {
		log.debug("getting Chart instance with id: " + id);
		try {
			Chart instance = (Chart) getCurrentSession().get("Model.Chart", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Chart> findByExample(Chart instance) {
		log.debug("finding Chart instance by example");
		try {
			List<Chart> results = (List<Chart>) getCurrentSession()
					.createCriteria("Model.Chart").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Chart instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Chart as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Chart> findByConvobjid(Object convobjid) {
		return findByProperty(CONVOBJID, convobjid);
	}

	public List<Chart> findByConvobjname(Object convobjname) {
		return findByProperty(CONVOBJNAME, convobjname);
	}

	public List<Chart> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List<Chart> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List<Chart> findByConversation(Object conversation) {
		return findByProperty(CONVERSATION, conversation);
	}

	public List<Chart> findByDeleted(Object deleted) {
		return findByProperty(DELETED, deleted);
	}

	public List findAll() {
		log.debug("finding all Chart instances");
		try {
			String queryString = "from Chart";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Chart merge(Chart detachedInstance) {
		log.debug("merging Chart instance");
		try {
			Chart result = (Chart) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Chart instance) {
		log.debug("attaching dirty Chart instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Chart instance) {
		log.debug("attaching clean Chart instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ChartDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ChartDAO) ctx.getBean("ChartDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from Chart where chart_id="+id;
		db.update(sql);
		
	}
}