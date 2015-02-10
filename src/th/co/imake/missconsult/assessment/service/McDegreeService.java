package th.co.imake.missconsult.assessment.service;

import java.util.List;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.model.McDegreeDTO;



public interface McDegreeService {
	public List<McDegreeDTO> selectAll(); 
	public Integer saveMcDegree(McDegreeDTO mcDegreeDTO);
	public int updateMcDegree(McDegreeDTO mcDegreeDTO) ;
	public int deleteMcDegree(McDegreeDTO mcDegreeDTO);
	public McDegreeDTO findMcDegreeById(Integer mcId);
	public List searchMcDegree(McDegreeDTO mcDegreeDTO, Paging paging);
}