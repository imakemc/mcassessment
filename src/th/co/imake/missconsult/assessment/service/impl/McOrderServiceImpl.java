package th.co.imake.missconsult.assessment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.repository.McOrderRepository;
import th.co.imake.missconsult.assessment.service.McOrderService;
@Service("mcOrderService")
public class McOrderServiceImpl implements McOrderService{
	@Autowired
	private McOrderRepository mcOrderRepository;
}