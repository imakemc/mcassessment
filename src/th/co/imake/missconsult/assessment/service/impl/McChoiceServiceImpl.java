package th.co.imake.missconsult.assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.aoe.makedev.missconsult.xstream.common.Paging;
import th.co.imake.missconsult.assessment.domain.McChoice;
import th.co.imake.missconsult.assessment.domain.McQuestion;
import th.co.imake.missconsult.assessment.model.McChoiceM;
import th.co.imake.missconsult.assessment.repository.McChoiceRepository;
import th.co.imake.missconsult.assessment.service.McChoiceService;

@Service("mcChoiceService")
public class McChoiceServiceImpl implements McChoiceService{
	@Autowired
	private McChoiceRepository mcChoiceRepository;

	@Override
	public Integer saveMcChoice(McChoice mcChoice) {
		return mcChoiceRepository.insertAll(mcChoice);
	}

//	@Override
//	public int updateMcChoice(McChoice mcChoice) {
//		
//		return 0;
//	}
	
	@Override
	public int updateMcChoiceByMcid(List<McChoice> mcChoiceList) {
		int success = 0;
		try{
			for(int i=0;i<mcChoiceList.size();i++){
				McChoice mcChoice =  mcChoiceRepository.selectByMcId(mcChoiceList.get(i).getMcId());
				mcChoice.setMcScore(mcChoiceList.get(i).getMcScore());
				mcChoice.setMcText(mcChoiceList.get(i).getMcText());
				int record = mcChoiceRepository.update(mcChoice);
				if(record>0)
					System.out.println("##UpdateMcChoiceByMcid : "+mcChoiceList.get(i).getMcId() +" success ");
				else
					System.out.println("##UpdateMcChoiceByMcid : "+mcChoiceList.get(i).getMcId() +" fail ");
			}
			success = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public int deleteMcChoice(List<McChoice> mcChoiceList) {
		int success = 0;
		try{
			for(int i=0;i<mcChoiceList.size();i++){
				int record = mcChoiceRepository.DeleteByMcId(mcChoiceList.get(i).getMcId());
				if(record>0)
					System.out.println("##DeleteeMcChoiceByMcid : "+mcChoiceList.get(i).getMcId() +" success ");
				else
					System.out.println("##DeleteeMcChoiceByMcid : "+mcChoiceList.get(i).getMcId() +" fail ");
			}
			success = 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public McChoice findMcChoiceByMcId(Integer mcId) {
		return mcChoiceRepository.selectByMcId(mcId);
	}
	
	@Override
	public List<McChoiceM> findMcChoiceByMqId(Integer mqid) {
		return mcChoiceRepository.selectByMqId(mqid);
	}

	@Override
	public int updateAddMcChoice(String[][] choices,String questionId) {
		McChoice mcChoice = new McChoice();
		int record = 0;
		for (int i = 0; i < choices.length; i++) {
			 mcChoice = new McChoice();
			 McQuestion mcQuestion = new McQuestion();
			 String[] choice = choices[i];
			 if(null==choice[0] || "".equalsIgnoreCase(choice[0].trim())){
				 System.out.println("##Add new  Choice qid : "+ questionId);
				 mcChoice.setMcScore(Integer.parseInt(choice[2]));
				 mcChoice.setMcText(choice[1]);
				 mcQuestion.setMqId(Integer.parseInt(questionId));
				 mcChoice.setMcQuestion(mcQuestion);
				 record += mcChoiceRepository.insertAll(mcChoice);
			 }else{
				 System.out.println("##Update Choice qid : "+questionId+" cid : "+choice[0]);
				 mcChoice.setMcId(Integer.parseInt(choice[0]));
				 mcChoice.setMcScore(Integer.parseInt(choice[2]));
				 mcChoice.setMcText(choice[1]);
				 mcQuestion.setMqId(Integer.parseInt(questionId));
				 record += mcChoiceRepository.update(mcChoice);
			 }
			
		}
		return record;
	}



}