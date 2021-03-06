package th.co.imake.missconsult.assessment.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("roleTypeRepository")
@Transactional(propagation = Propagation.REQUIRED)
public class RoleTypeRepository {
	@PersistenceContext
	private EntityManager entityManager;

}