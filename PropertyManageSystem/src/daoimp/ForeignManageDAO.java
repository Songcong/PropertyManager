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

import dao.IForeignManageDao;
import Model.ForeignManage;
import Utilx.DBUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * ForeignManage entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Model.ForeignManage
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ForeignManageDAO implements IForeignManageDao {
	private static final Logger log = LoggerFactory
			.getLogger(ForeignManageDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String SEX = "sex";
	public static final String PHONE = "phone";
	public static final String DOCUMENTATION = "documentation";
	public static final String FAMILY = "family";
	public static final String LIVEINFORMATION = "liveinformation";
	public static final String ORIGIN = "origin";

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

	public void save(ForeignManage transientInstance) {
		log.debug("saving ForeignManage instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ForeignManage persistentInstance) {
		log.debug("deleting ForeignManage instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ForeignManage findById(java.lang.Integer id) {
		log.debug("getting ForeignManage instance with id: " + id);
		try {
			ForeignManage instance = (ForeignManage) getCurrentSession().get(
					"Model.ForeignManage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ForeignManage> findByExample(ForeignManage instance) {
		log.debug("finding ForeignManage instance by example");
		try {
			List<ForeignManage> results = (List<ForeignManage>) getCurrentSession()
					.createCriteria("Model.ForeignManage")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ForeignManage instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ForeignManage as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ForeignManage> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<ForeignManage> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<ForeignManage> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<ForeignManage> findByDocumentation(Object documentation) {
		return findByProperty(DOCUMENTATION, documentation);
	}

	public List<ForeignManage> findByFamily(Object family) {
		return findByProperty(FAMILY, family);
	}

	public List<ForeignManage> findByLiveinformation(Object liveinformation) {
		return findByProperty(LIVEINFORMATION, liveinformation);
	}

	public List<ForeignManage> findByOrigin(Object origin) {
		return findByProperty(ORIGIN, origin);
	}

	public List findAll() {
		log.debug("finding all ForeignManage instances");
		try {
			String queryString = "from ForeignManage";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ForeignManage merge(ForeignManage detachedInstance) {
		log.debug("merging ForeignManage instance");
		try {
			ForeignManage result = (ForeignManage) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ForeignManage instance) {
		log.debug("attaching dirty ForeignManage instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ForeignManage instance) {
		log.debug("attaching clean ForeignManage instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ForeignManageDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ForeignManageDAO) ctx.getBean("ForeignManageDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from ForeignManage where foreign_id="+id;
		db.update(sql);
		
	}
}