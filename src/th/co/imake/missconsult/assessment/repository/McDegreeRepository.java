package th.co.imake.missconsult.assessment.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.domain.McDegree;
import th.co.imake.missconsult.assessment.model.McDegreeM;

@Repository("mcDegreeRepository")
@Transactional(propagation = Propagation.REQUIRED)
public class McDegreeRepository {
	private static final String SELECT_QUERY = "select p from McDegree p";
	@PersistenceContext
	private EntityManager entityManager;

	public List<McDegree> selectAll() {
		Query query = entityManager.createQuery(SELECT_QUERY,McDegree.class);
//		List<McDegree> list = (List<McDegree>) query.getResultList();
		List<McDegree> list = query.getResultList();

		return list;
	}
	public List<McDegreeM> selectAllGroup() {
		String sql = " SELECT MCD.MD_ID"
				+ " ,MCD.MD_NAME"
				+ " ,MCDG.MDG_ID "
				+ " ,MCDG.MDG_NAME "
				+ " ,MCDG.MDG_ASSESSOR "
				+ " FROM MC_DEGREE MCD "
				+ " ,MC_DEGREE_GROUP MCDG "
				+ " WHERE "
				+ " MCD.MD_ID=MCDG.MD_ID";
		Query query = entityManager.createNativeQuery(sql);
//		List<McDegree> users = (List<McDegree>) query.getResultList();
		List<McDegreeM> list =(List<McDegreeM>) query.getResultList();
//		for(int i=0 ;i<list.size();i++){
//			list.get(i).getMcDegreeGroups();
//		}
		return list;
	}

	public Integer saveMcDegree(McDegree mcDegree) {
		entityManager.persist(mcDegree);
		return 1;
		/*
		 * Session session=entityManager.getCurrentSession(); Long returnId =
		 * null; try{ Object obj = session.save(transientInstance);
		 * 
		 * if(obj!=null){ MissChoicePK pk = (MissChoicePK)obj; returnId
		 * =pk.getMcNo();//(Long) obj; } } finally { if (session != null) {
		 * session = null; } } return returnId;
		 */

	}

	public int updateMcDegree(McDegree mcDegree) {
		entityManager.merge(mcDegree);
		return 1;
	}

	public int deleteMcDegree(McDegree mcDegree) {
		entityManager.remove(mcDegree);
		return 1;
	}

	public McDegree findMcDegreeById(Integer mcId) {
		return entityManager.find(McDegree.class, mcId);
	}

	public List searchMcDegree(McDegree mcDegree, Paging paging) {
		return null;
	}
}