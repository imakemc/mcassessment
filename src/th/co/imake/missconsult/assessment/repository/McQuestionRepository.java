package th.co.imake.missconsult.assessment.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.co.imake.missconsult.assessment.domain.McQuestion;
import th.co.imake.missconsult.assessment.model.McQuestionM;
@Repository("mcQuestionRepository")
@Transactional(propagation = Propagation.REQUIRED)
public class McQuestionRepository  {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<McQuestionM> selectAllByMeId(Integer meid) {

		String sql = "\n SELECT \n"
				+ " MQ_ID ,\n"
				+ " ME_ID ,\n"
				+ " MQ_NAME_THAI ,\n"
				+ " MA_NAME_ENG \n"
//				+ " * "
				+ " FROM mc_question \n"
				+ " WHERE \n"
				+ " ME_ID=? \n";
		System.out.println(sql);
		Query query = entityManager.createNativeQuery(sql ,McQuestion.class);
		query.setParameter(1, meid);;
		List<McQuestionM> mcQuestionMs =(List<McQuestionM>) query.getResultList();
		
		return mcQuestionMs;
	}
	
	public Integer insertAll(McQuestion mcQuestion){
		Integer record = 0;
		Integer id = -1;
		   String sql = "  INSERT INTO  mc_question ( "
//				   +"  MQ_ID ,  "
				   +"  ME_ID ,  "
				   +"  MQ_NAME_THAI ,  "
				   +"  MA_NAME_ENG  "
				   +"  ) VALUES ( "
//				   +"  ?,  "
				   +"  ?,  "
				   +"  ?,  "
				   +"  ?) ";
		   
		   try{
			  System.out.println(sql);
		   Query query = entityManager.createNativeQuery(sql);
		   int i=1;
		   query.setParameter(i++, mcQuestion.getMcEvaluation().getMeId());
		   query.setParameter(i++, mcQuestion.getMqNameThai());
		   query.setParameter(i++, mcQuestion.getMaNameEng());
		   record = query.executeUpdate();
		   if(record>0){
				query = entityManager.createNativeQuery(" SELECT LAST_INSERT_ID()");
				List<Integer> list = query.getResultList();
				if(list!=null && !list.isEmpty()){
					String srt = ""+list.get(0);
					id =  Integer.parseInt(srt);
				}
		   }
		   }catch(Exception exception){
			   exception.printStackTrace();
			   
		   }
		   return id;
	}
	
	public Integer deleteByMqId(Integer mqid){
		Integer record = 0;
		String sql = "\n DELETE \n"
					+ " FROM \n"
					+ " mc_question  \n"
					+ " WHERE \n"
					+ " MQ_ID=? \n";
		System.out.println(sql);
		try{
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter(1, mqid);
			record = query.executeUpdate();
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return record;
	}
	
	
}