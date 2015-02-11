package th.co.imake.missconsult.assessment.service;

import java.util.List;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.model.McOrderM;


public interface McOrderService {
	public List<McOrderM> selectAll();
	public Integer saveMcOrder(McOrderM mcOrderDTO);
	public int updateMcOrder(McOrderM mcOrderDTO);
	public int deleteMcOrder(McOrderM mcOrderDTO);
	public List searchMcOrder(McOrderM mcOrderDTO, Paging paging);
}