package th.co.imake.missconsult.assessment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.domain.McDegree;
import th.co.imake.missconsult.assessment.model.McDegreeM;
import th.co.imake.missconsult.assessment.repository.McDegreeGroupRepository;
import th.co.imake.missconsult.assessment.repository.McDegreeRepository;
import th.co.imake.missconsult.assessment.service.McDegreeService;

@Service("mcDegreeService")
public class McDegreeServiceImpl implements McDegreeService {
	@Autowired
	private McDegreeRepository mcDegreeRepository;
	@Autowired
	private McDegreeGroupRepository mcDegreeGroupRepository;

	private McDegree initObjectDomain() {
		return new McDegree();
	}

	private McDegreeM initObjectDTO() {
		return new McDegreeM();
	}

	@Override
	public List<McDegreeM> selectAll() {
		// TODO Auto-generated method stub
		List<McDegree> list = mcDegreeRepository.selectAll();
		List<McDegreeM> listDTO = null;
		if (list != null) {
			listDTO = new ArrayList<McDegreeM>(list.size());
			for (McDegree mcDegree : list) {
				McDegreeM mcDegreeDTO = initObjectDTO();
				BeanUtils.copyProperties(mcDegree, mcDegreeDTO);
				listDTO.add(mcDegreeDTO);
			}
		}
		return listDTO;
	}
	
	@Override
	public List<McDegreeM> selectAllGroup() {
		List<McDegree> list = mcDegreeRepository.selectAll();
		List<McDegreeM> listDTO = null;
		if (list != null) {
			listDTO = new ArrayList<McDegreeM>(list.size());
			for (McDegree mcDegree : list) {
				McDegreeM mcDegreeDTO = initObjectDTO();
				BeanUtils.copyProperties(mcDegree, mcDegreeDTO);
				mcDegreeDTO.setMcDegreeGroups(mcDegreeGroupRepository.getAllByDegreeId(mcDegreeDTO.getMdId()));
				listDTO.add(mcDegreeDTO);
			}
		}
		return listDTO;
	}

	@Override
	public Integer saveMcDegree(McDegreeM mcDegreeDTO) {
		// TODO Auto-generated method stub
		McDegree mcDegree = initObjectDomain();
		BeanUtils.copyProperties(mcDegreeDTO, mcDegree);
		return mcDegreeRepository.saveMcDegree(mcDegree);
	}

	@Override
	public int updateMcDegree(McDegreeM mcDegreeDTO) {
		// TODO Auto-generated method stub
		McDegree mcDegree = initObjectDomain();
		BeanUtils.copyProperties(mcDegreeDTO, mcDegree);
		return mcDegreeRepository.updateMcDegree(mcDegree);
	}

	@Override
	public int deleteMcDegree(McDegreeM mcDegreeDTO) {
		// TODO Auto-generated method stub
		McDegree mcDegree = initObjectDomain();
		BeanUtils.copyProperties(mcDegreeDTO, mcDegree);
		return mcDegreeRepository.deleteMcDegree(mcDegree);

	}

	@Override
	public McDegreeM findMcDegreeById(Integer mcId) {
		// TODO Auto-generated method stub
		McDegree mcDegree =  mcDegreeRepository.findMcDegreeById(mcId);
		McDegreeM mcDegreeDTO = initObjectDTO();
		BeanUtils.copyProperties(mcDegree, mcDegreeDTO);
		return mcDegreeDTO;
	}

	@Override
	public List searchMcDegree(McDegreeM mcDegreeDTO, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public McDegreeM findMcDegreeM(String mdName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}