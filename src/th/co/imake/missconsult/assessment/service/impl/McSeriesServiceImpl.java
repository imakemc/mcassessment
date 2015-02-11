package th.co.imake.missconsult.assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.model.McSeriesM;
import th.co.imake.missconsult.assessment.repository.McSeryRepository;
import th.co.imake.missconsult.assessment.service.McSeriesService;
@Service("mcSeryService")
public class McSeriesServiceImpl implements McSeriesService{
	@Autowired
	private McSeryRepository mcSeryRepository;

	@Override
	public List<McSeriesM> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer saveMcSeries(McSeriesM mcSeriesDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMcSeries(McSeriesM mcSeriesDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMcSeries(McSeriesM mcSeriesDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List searchMcSeries(McSeriesM mcSeriesDTO, Paging paging) {
		// TODO Auto-generated method stub
		return null;
	}
}