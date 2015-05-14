package th.co.imake.missconsult.assessment.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.co.imake.missconsult.assessment.domain.McChoice;
import th.co.imake.missconsult.assessment.model.McChoiceM;

@Repository("mcChoiceRepository")
@Transactional(propagation = Propagation.REQUIRED)
public class McChoiceRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public Integer insertAll(McChoice mcChoice){
		Integer record = 0;
		   String sql = " \n INSERT INTO  mc_choice ( "
				   +"  MC_ID ,  "
				   +"  MQ_ID ,  "
				   +"  MC_SCORE ,  "
				   +"  MC_TEXT  "
				   +"  ) VALUES ( "
				   +"  ?,  "
				   +"  ?,  "
				   +"  ?,  "
				   +"  ?) ";
		   
		   try{
		   Query query = entityManager.createNativeQuery(sql);
		   int i=1;
		   query.setParameter(i++, mcChoice.getMcId());
		   query.setParameter(i++, mcChoice.getMcQuestion().getMqId());
		   query.setParameter(i++, mcChoice.getMcScore());
		   query.setParameter(i++, mcChoice.getMcText());
		   record = query.executeUpdate();
		   }catch(Exception exception){
			   exception.printStackTrace();
			   
		   }
		   return record;
	}
	
	public List<McChoiceM> selectByMqId(Integer mqid){
		String sql = "\n SELECT "
//				+ " * "
				+ " MC_ID \n"
				+ " ,MQ_ID \n"
				+ " ,MC_SCORE \n"
				+ " ,MC_TEXT \n"
				+ " FROM mc_choice \n"
				+ " WHERE \n"
				+ " MQ_ID=? \n";
		System.out.println(sql);
		Query query = entityManager.createNativeQuery(sql,McChoice.class);
		query.setParameter(1, mqid);
		 List<McChoiceM>  list = (List<McChoiceM>) query.getResultList();
		return list;
	}
	
	public McChoice selectByMcId(Integer mcid){
		String sql = "\n SELECT "
				//				+ " * "
				+ " MC_ID \n"
				+ " ,MQ_ID \n"
				+ " ,MC_SCORE \n"
				+ " ,MC_TEXT \n"
				+ " FROM mc_choice \n"
				+ " WHERE \n"
				+ " MC_ID=? \n";
		System.out.println(sql);
		Query query = entityManager.createNativeQuery(sql,McChoice.class);
		query.setParameter(1, mcid);
		query.setMaxResults(1);
//		List<McChoiceM>  Choices = (List<McChoiceM>) query.getResultList();
		McChoice  Choices =  (McChoice) query.getSingleResult();
		return Choices;
	}
	
	public Integer DeleteByMcId(Integer mcid){
		String sql = "\n DELETE "
				+ " FROM mc_choice \n"
				+ " WHERE \n"
				+ " MC_ID=? \n";
		Integer record = 0;
		System.out.println(sql);
		try{
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, mcid);
		record = query.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return record;
	}
	
	public Integer update(McChoice mcChoice){
		String sql = "\n UPDATE "
				+ "  mc_choice \n"
				+ " SET \n"
				+ " MC_ID=?"
				+ " ,MQ_ID=?"
				+ " ,MC_SCORE =?"
				+ " ,MC_TEXT=? \n"
				+ " WHERE \n"
				+ " MC_ID=? \n";
		Integer record = 0;
		System.out.println(sql);
		try{
			Query query = entityManager.createNativeQuery(sql);
			int i=1;
			query.setParameter(i++, mcChoice.getMcId());
			query.setParameter(i++, mcChoice.getMcQuestion().getMqId());
			query.setParameter(i++, mcChoice.getMcScore());
			query.setParameter(i++, mcChoice.getMcText());
			record = query.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return record;
	}
	
}