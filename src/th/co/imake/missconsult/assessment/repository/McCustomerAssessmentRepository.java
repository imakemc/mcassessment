package th.co.imake.missconsult.assessment.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("mcCustomerAssessmentRepository")
@Transactional(propagation = Propagation.REQUIRED)
public class McCustomerAssessmentRepository {
	@PersistenceContext
	private EntityManager entityManager;
}