package th.co.imake.missconsult.assessment.service;

import java.util.List;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.model.McSeriesM;


public interface McSeriesService{
	public List<McSeriesM> selectAll();
	public Integer saveMcSeries(McSeriesM mcSeriesDTO);
	public int updateMcSeries(McSeriesM mcSeriesDTO);
	public int deleteMcSeries(McSeriesM mcSeriesDTO);
	public List searchMcSeries(McSeriesM mcSeriesDTO, Paging paging);
}