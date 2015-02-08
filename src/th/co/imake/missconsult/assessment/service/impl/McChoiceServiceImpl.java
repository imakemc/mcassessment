package th.co.imake.missconsult.assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.domain.McChoice;
import th.co.imake.missconsult.assessment.repository.McChoiceRepository;
import th.co.imake.missconsult.assessment.service.McChoiceService;

@Service("mcChoiceService")
public class McChoiceServiceImpl implements McChoiceService{
	@Autowired
	private McChoiceRepository mcChoiceRepository;

	@Override
	public Integer saveMcChoice(McChoice mcChoice) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public int updateMcChoice(McChoice mcChoice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMcChoice(McChoice mcChoice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public McChoice findMcChoiceById(Integer mcId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List searchMcChoice(McChoice mcChoice, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}

}