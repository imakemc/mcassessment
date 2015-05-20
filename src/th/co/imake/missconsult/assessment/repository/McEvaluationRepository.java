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
	
	public List<McEvaluationM> selectByMdId(Integer mdid){
		String sql = " SELECT "
//				+ " * "
				+ " MCDG.ME_ID \n"
				+ " ,MCDG.ME_NAME \n"
				+ " ,MCDG.MC_EVALUATIONcol \n"
				+ " ,MCDG.MC_INTRO \n"
				+ " FROM MC_EVALUATION AS MCDG \n"
				+ " WHERE \n"
				+ " MCDG.ME_ID=? \n";
		System.out.println(sql);
		Query query = entityManager.createNativeQuery(sql,McEvaluation.class);
		query.setParameter(1, mdid);
		 List<McEvaluationM>  list = (List<McEvaluationM>) query.getResultList();
		return list;
	}
	
	public Integer deleteByMeId(Integer meid){
		Integer record = 0;
		String sql = " DELETE "
					+ " FROM \n"
					+ " MC_EVALUATION  \n"
					+ " WHERE \n"
					+ " ME_ID=? \n";
		System.out.println(sql);
		try{
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter(1, meid);
			record = query.executeUpdate();
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return record;
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
			int count = query.executeUpdate();
			query = entityManager.createNativeQuery(" SELECT LAST_INSERT_ID()");
			List<Integer> list = query.getResultList();
			if(count >0 && list!=null && !list.isEmpty()){
				System.out.println(""+list.get(0));
				String srt = ""+list.get(0);
				id =  Integer.parseInt(srt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
//	public Integer getLastId(){
//		Integer count =  0;
//		String sql = " SELECT LAST_INSERT_ID(); ";
//		try {
//			System.out.println(sql);
////			entityManager.persist(evaluation);
//			Query query = entityManager.createNativeQuery(sql);
//			count = query.executeUpdate();
////			count=1;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return count;
//	}
	
}