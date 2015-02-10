package th.co.imake.missconsult.assessment.service;

import java.util.List;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.model.McDegreeM;



public interface McDegreeService {
	public List<McDegreeM> selectAll(); 
	public Integer saveMcDegree(McDegreeM mcDegreeDTO);
	public int updateMcDegree(McDegreeM mcDegreeDTO) ;
	public int deleteMcDegree(McDegreeM mcDegreeDTO);
	public McDegreeM findMcDegreeById(Integer mcId);
	public List searchMcDegree(McDegreeM mcDegreeDTO, Paging paging);
}