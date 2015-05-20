package th.co.imake.missconsult.assessment.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import th.co.imake.missconsult.assessment.domain.McDegreeGroup;
import th.co.imake.missconsult.assessment.form.McDegreeGroupForm;
@Repository("mcDegreeGroupRepository")
@Transactional(propagation = Propagation.REQUIRED)
public class McDegreeGroupRepository  {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<McDegreeGroup> getAllByDegreeId(Integer DegreeId) {
		List<McDegreeGroup> result ;
		String sql = "SELECT * FROM MC_DEGREE_GROUP WHERE 1=1 ";
		if(DegreeId != null)
			sql+= " AND MD_ID="+DegreeId ;
		Query qry = entityManager.createNativeQuery(sql, McDegreeGroup.class);
		result = qry.getResultList();
		return result;
	}
	
	public List<McDegreeGroup> getAllByDegreeGroupId(Integer degreeGroupId) {
		List<McDegreeGroup> result ;
		String sql = "SELECT * FROM MC_DEGREE_GROUP WHERE 1=1 ";
		if(degreeGroupId != null)
			sql+= " AND MDG_ID="+degreeGroupId ;
		Query qry = entityManager.createNativeQuery(sql, McDegreeGroup.class);
		result = qry.getResultList();
		return result;
	}
	
	public Integer insertMcDegreeGroupByDegreeId(McDegreeGroup degreeGroup) {
		Integer result =0;
		try{
			String sql = " INSERT INTO  "+
					" MC_DEGREE_GROUP ( "+
//					" MDG_ID, "+
					" MD_ID, " +
					" MDG_NAME, " +
					" MDG_ASSESSOR)   "+
					" VALUES (  " +
//					" ,  " +
					" "+degreeGroup.getMcdegree().getMdId()+", " +
					" '"+degreeGroup.getMdgName()+"', " +
					" "+degreeGroup.getMdgAssessor()+" )";
			entityManager.createNativeQuery(sql).executeUpdate();
//			entityManager.persist(degreeGroup);
			result=1;
		}catch( Exception x){
			x.printStackTrace();
//			return result;
		}
		return result ;
	}
	
	public Integer updateMcDegreeGroupByDegreeGroupId(McDegreeGroup degreeGroup) {
		Integer result =0;
		try{
			String sql = " UPDATE   "+
					" MC_DEGREE_GROUP "+
					" SET  "+ 
//					" MDG_ID, "+
					" MD_ID = "+degreeGroup.getMcdegree().getMdId()+", " +
					" MDG_NAME ='"+degreeGroup.getMdgName()+"', " +
					" MDG_ASSESSOR ="+degreeGroup.getMdgAssessor()+" "+
					" WHERE  " +
					" MDG_ID =" +degreeGroup.getMdgId() ;
			System.out.println(sql);
			entityManager.createNativeQuery(sql).executeUpdate();
			result=1;
		}catch( Exception x){
			x.printStackTrace();
//			return result;
		}
		return result ;
	}
	
	public Integer deleteMcDegreeGroupByDegreeGroupId(McDegreeGroup degreeGroup) {
		Integer result =0;
		try{
			String sql = " DELETE  FROM "+
					" MC_DEGREE_GROUP "+
					 "WHERE "+
					" MDG_ID =" +degreeGroup.getMdgId() ;
			System.out.println(sql);
			entityManager.createNativeQuery(sql).executeUpdate();
			result=1;
		}catch( Exception x){
			x.printStackTrace();
//			return result;
		}
		return result ;
	}
	
	
	
}