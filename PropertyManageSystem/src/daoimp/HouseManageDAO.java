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

import dao.IHouseManageDao;
import Model.HouseManage;
import Utilx.DBUtil;

/**
 	* A data access object (DAO) providing persistence and search support for HouseManage entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see Model.HouseManage
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class HouseManageDAO implements IHouseManageDao  {
	     private static final Logger log = LoggerFactory.getLogger(HouseManageDAO.class);
		//property constants
	public static final String LOCATION = "location";
	public static final String AREA = "area";
	public static final String SELLSTATE = "sellstate";
	public static final String RENTSTATE = "rentstate";
	public static final String FITMENTINFO = "fitmentinfo";



    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
       this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
     return sessionFactory.getCurrentSession(); 
    }
	protected void initDao() {
		//do nothing
	}
    
    public void save(HouseManage transientInstance) {
        log.debug("saving HouseManage instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(HouseManage persistentInstance) {
        log.debug("deleting HouseManage instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public HouseManage findById( java.lang.Integer id) {
        log.debug("getting HouseManage instance with id: " + id);
        try {
            HouseManage instance = (HouseManage) getCurrentSession()
                    .get("Model.HouseManage", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<HouseManage> findByExample(HouseManage instance) {
        log.debug("finding HouseManage instance by example");
        try {
            List<HouseManage> results = (List<HouseManage>) getCurrentSession() .createCriteria("Model.HouseManage").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding HouseManage instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from HouseManage as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<HouseManage> findByLocation(Object location
	) {
		return findByProperty(LOCATION, location
		);
	}
	
	public List<HouseManage> findByArea(Object area
	) {
		return findByProperty(AREA, area
		);
	}
	
	public List<HouseManage> findBySellstate(Object sellstate
	) {
		return findByProperty(SELLSTATE, sellstate
		);
	}
	
	public List<HouseManage> findByRentstate(Object rentstate
	) {
		return findByProperty(RENTSTATE, rentstate
		);
	}
	
	public List<HouseManage> findByFitmentinfo(Object fitmentinfo
	) {
		return findByProperty(FITMENTINFO, fitmentinfo
		);
	}
	

	public List findAll() {
		log.debug("finding all HouseManage instances");
		try {
			String queryString = "from HouseManage";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public HouseManage merge(HouseManage detachedInstance) {
        log.debug("merging HouseManage instance");
        try {
            HouseManage result = (HouseManage) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(HouseManage instance) {
        log.debug("attaching dirty HouseManage instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(HouseManage instance) {
        log.debug("attaching clean HouseManage instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static HouseManageDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (HouseManageDAO) ctx.getBean("HouseManageDAO");
	}
	public void deletebyid(int id){
		DBUtil db=new DBUtil();
		
		String sql="delete from HouseManage where house_id="+id;
		db.update(sql);
		
	}
}