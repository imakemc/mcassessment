package th.co.imake.missconsult.assessment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.domain.McDegree;
import th.co.imake.missconsult.assessment.dto.McDegreeDTO;
import th.co.imake.missconsult.assessment.repository.McDegreeRepository;
import th.co.imake.missconsult.assessment.service.McDegreeService;

@Service("mcDegreeService")
public class McDegreeServiceImpl implements McDegreeService {
	@Autowired
	private McDegreeRepository mcDegreeRepository;

	private McDegree initObjectDomain() {
		return new McDegree();
	}

	private McDegreeDTO initObjectDTO() {
		return new McDegreeDTO();
	}

	@Override
	public List<McDegreeDTO> selectAll() {
		// TODO Auto-generated method stub
		List<McDegree> list = mcDegreeRepository.selectAll();
		List<McDegreeDTO> listDTO = null;
		if (list != null) {
			listDTO = new ArrayList<McDegreeDTO>(list.size());
			for (McDegree mcDegree : list) {
				McDegreeDTO mcDegreeDTO = initObjectDTO();
				BeanUtils.copyProperties(mcDegree, mcDegreeDTO);
				listDTO.add(mcDegreeDTO);
			}
		}
		return listDTO;
	}

	@Override
	public Integer saveMcDegree(McDegreeDTO mcDegreeDTO) {
		// TODO Auto-generated method stub
		McDegree mcDegree = initObjectDomain();
		BeanUtils.copyProperties(mcDegreeDTO, mcDegree);
		return mcDegreeRepository.saveMcDegree(mcDegree);
	}

	@Override
	public int updateMcDegree(McDegreeDTO mcDegreeDTO) {
		// TODO Auto-generated method stub
		McDegree mcDegree = initObjectDomain();
		BeanUtils.copyProperties(mcDegreeDTO, mcDegree);
		return mcDegreeRepository.updateMcDegree(mcDegree);
	}

	@Override
	public int deleteMcDegree(McDegreeDTO mcDegreeDTO) {
		// TODO Auto-generated method stub
		McDegree mcDegree = initObjectDomain();
		BeanUtils.copyProperties(mcDegreeDTO, mcDegree);
		return mcDegreeRepository.deleteMcDegree(mcDegree);

	}

	@Override
	public McDegreeDTO findMcDegreeById(Integer mcId) {
		// TODO Auto-generated method stub
		McDegree mcDegree =  mcDegreeRepository.findMcDegreeById(mcId);
		McDegreeDTO mcDegreeDTO = initObjectDTO();
		BeanUtils.copyProperties(mcDegree, mcDegreeDTO);
		return mcDegreeDTO;
	}

	@Override
	public List searchMcDegree(McDegreeDTO mcDegreeDTO, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}
}