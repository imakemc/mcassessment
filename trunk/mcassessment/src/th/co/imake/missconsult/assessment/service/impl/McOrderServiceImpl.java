package th.co.imake.missconsult.assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.model.McOrderM;
import th.co.imake.missconsult.assessment.repository.McOrderRepository;
import th.co.imake.missconsult.assessment.service.McOrderService;
@Service("mcOrderService")
public class McOrderServiceImpl implements McOrderService{
	@Autowired
	private McOrderRepository mcOrderRepository;

	@Override
	public List<McOrderM> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer saveMcOrder(McOrderM mcOrderDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMcOrder(McOrderM mcOrderDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMcOrder(McOrderM mcOrderDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List searchMcOrder(McOrderM mcOrderDTO, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}
	
}