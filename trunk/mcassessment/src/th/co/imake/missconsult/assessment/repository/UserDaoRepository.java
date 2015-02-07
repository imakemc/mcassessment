package th.co.imake.missconsult.assessment.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Repository("userDaoRepository")
@Transactional(propagation = Propagation.REQUIRED)
public class UserDaoRepository {
	 
	private static final String SELECT_QUERY = "select p from Aoe p";
	 
	@PersistenceContext
	private EntityManager entityManager;
	 
	public EntityManager getEntityManager() {
	return entityManager;
	}
	 
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	/*public void insert(co.th.imake.domain.Aoe aoe) {
		entityManager.persist(aoe);
		}
	public List<co.th.imake.domain.Aoe> selectAll() {
	Query query = entityManager.createQuery(SELECT_QUERY);
	List<co.th.imake.domain.Aoe> users = (List<co.th.imake.domain.Aoe>) query.getResultList();
	return users;
	}*/
}
