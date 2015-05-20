package th.co.imake.missconsult.assessment.repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.co.imake.missconsult.assessment.domain.McEvaluation;
import th.co.imake.missconsult.assessment.model.McEvaluationM;
@Repository("mcEvaluationRepository")
@Transactional(propagation = Propagation.REQUIRED)
public class McEvaluationRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<McEvaluationM> selectAll(){
		String sql = " SELECT "
				+ " * "
//				+ " mcd.MD_ID"
//				+ " ,mcd.MD_NAME"
//				+ " ,mcdg.MDG_ID "
//				+ " ,mcdg.MDG_NAME "
//				+ " ,mcdg.MDG_ASSESSOR "
				+ " FROM MC_EVALUATION ";
		System.out.println(sql);
		Query query = entityManager.createNativeQuery(sql,McEvaluation.class);
		 List<McEvaluationM>  list = (List<McEvaluationM>) query.getResultList();
		return list;
	}
	
	public Integer insertAll(McEvaluation evaluation){
		Integer id =  -1;
		String sql = "INSERT INTO "
				+ " MC_EVALUATION ( "
//				+ " ME_ID, "
				+ " ME_NAME,  "
				+ " MC_EVALUATIONcol, "
				+ " MC_INTRO "
				+ " ) "
				+ " VALUES ( "
//				+ " NULL ,"
				+ " ?,"
				+ " ?, " 
				+ " ?); ";
//		+ " '"+((evaluation.getMeName()==null)?"":evaluation.getMeName())+"',"
//		+ " '"+((evaluation.getMC_EVALUATIONcol()==null)?"":evaluation.getMC_EVALUATIONcol())+"', " 
//		+ " '"+((evaluation.getMcIntro()==null)?"":evaluation.getMcIntro())+"')";
//				+ " SELECT LAST_INSERT_ID(); ";
		try {
			System.out.println(sql);
//			entityManager.persist(evaluation);
//			Query query = entityManager.createNativeQuery(sql, McEvaluation.class);
			Query query = entityManager.createNativeQuery(sql);
			int i =1;
			query.setParameter(i++, evaluation.getMeName());
			query.setParameter(i++, evaluation.getMC_EVALUATIONcol());
			query.setParameter(i++, evaluation.getMcIntro());
//			System.out.println(query.toString());
			id = query.executeUpdate();
			query = entityManager.createNativeQuery(" SELECT LAST_INSERT_ID()");
			List<Integer> list = query.getResultList();
			
//			count = query.getFirstResult();
//			McEvaluation mcEvaluation = query.getFirstResult();
//			entityManager.persist(evaluation);
//			entityManager.flush();
			if(list!=null && !list.isEmpty()){
				System.out.println(""+list.get(0));
				String srt = ""+list.get(0);
				id =  Integer.parseInt(srt);
			}
//			count=1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public Integer getLastId(){
		Integer count =  0;
		String sql = " SELECT LAST_INSERT_ID(); ";
		try {
			System.out.println(sql);
//			entityManager.persist(evaluation);
			Query query = entityManager.createNativeQuery(sql);
			count = query.executeUpdate();
//			count=1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
}