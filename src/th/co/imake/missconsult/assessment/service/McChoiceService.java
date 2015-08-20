package th.co.imake.missconsult.assessment.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.domain.McChoice;


public interface McChoiceService {
	/*
	public Long saveMissAccount(MissAccount transientInstance) throws DataAccessException;
	public int updateMissAccount(MissAccount transientInstance,String section) throws DataAccessException ;
	public th.co.aoe.makedev.missconsult.xstream.MissAccount refill(Long maId,Long refill) throws DataAccessException ;		
	public int updateMissAccountLogo(MissAccount transientInstance,String section) throws DataAccessException ;
	public int deleteMissAccount(MissAccount persistentInstance) throws DataAccessException ;	
	public th.co.aoe.makedev.missconsult.xstream.MissAccount findMissAccountById(Long maId)throws DataAccessException  ;
	public List<th.co.aoe.makedev.missconsult.xstream.MissSery> listMissAccountSeriesMapByMaId(Long maId)throws DataAccessException  ;
	@SuppressWarnings("rawtypes")
	public  List searchMissAccount(MissAccount persistentInstance,String maContactName,String[] meIds,	Pagging pagging)throws DataAccessException  ;
	*/
	public Integer saveMcChoice(th.co.imake.missconsult.assessment.domain.McChoice mcChoice);
//	public int updateMcChoice(th.co.imake.missconsult.assessment.domain.McChoice mcChoice); 
//	public th.co.imake.missconsult.assessment.domain.McChoice findMcChoiceById(Integer mcId);
//	public  List searchMcChoice(th.co.imake.missconsult.assessment.domain.McChoice  mcChoice,Paging paging);
	public int updateMcChoiceByMcid(List<McChoice> mcChoiceList);
	public int deleteMcChoice(List<McChoice> mcChoiceList);
	public int deleteMcChoiceAll(String[][] choicesDelete);
	public McChoice findMcChoiceByMcId(Integer mcId);
	public List<th.co.imake.missconsult.assessment.model.McChoiceM> findMcChoiceByMqId(Integer mqid);
	public int updateAddMcChoice(String[][] choices,String questionId);
}