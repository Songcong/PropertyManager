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

import dao.IFamilyDetailDao;
import Model.FamilyDetail;
import Utilx.DBUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * FamilyDetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Model.FamilyDetail
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class FamilyDetailDAO implements IFamilyDetailDao {
	private static final Logger log = LoggerFactory
			.getLogger(FamilyDetailDAO.class);
	// property constants
	public static final String FOREIGN_ID = "foreignId";
	public static final String NAME = "name";
	public static final String SEX = "sex";
	public static final String RELATION = "relation";
	public static final String HEALTH = "health";

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

	public void save(FamilyDetail transientInstance) {
		log.debug("saving FamilyDetail instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(FamilyDetail persistentInstance) {
		log.debug("deleting FamilyDetail instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FamilyDetail findById(java.lang.Integer id) {
		log.debug("getting FamilyDetail instance with id: " + id);
		try {
			FamilyDetail instance = (FamilyDetail) getCurrentSession().get(
					"Model.FamilyDetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<FamilyDetail> findByExample(FamilyDetail instance) {
		log.debug("finding FamilyDetail instance by example");
		try {
			List<FamilyDetail> results = (List<FamilyDetail>) getCurrentSession()
					.createCriteria("Model.FamilyDetail").add(create(instance))
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
		log.debug("finding FamilyDetail instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from FamilyDetail as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<FamilyDetail> findByForeignId(Object foreignId) {
		return findByProperty(FOREIGN_ID, foreignId);
	}

	public List<FamilyDetail> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<FamilyDetail> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<FamilyDetail> findByRelation(Object relation) {
		return findByProperty(RELATION, relation);
	}

	public List<FamilyDetail> findByHealth(Object health) {
		return findByProperty(HEALTH, health);
	}

	public List findAll() {
		log.debug("finding all FamilyDetail instances");
		try {
			String queryString = "from FamilyDetail";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public FamilyDetail merge(FamilyDetail detachedInstance) {
		log.debug("merging FamilyDetail instance");
		try {
			FamilyDetail result = (FamilyDetail) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FamilyDetail instance) {
		log.debug("attaching dirty FamilyDetail instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FamilyDetail instance) {
		log.debug("attaching clean FamilyDetail instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FamilyDetailDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (FamilyDetailDAO) ctx.getBean("FamilyDetailDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from FamilyDetail where family_id="+id;
		db.update(sql);
		
	}
}