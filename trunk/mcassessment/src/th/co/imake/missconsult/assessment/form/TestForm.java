// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 5/27/2012 12:13:51 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TestForm.java

package th.co.imake.missconsult.assessment.form;

import java.io.Serializable;

import th.co.aoe.makedev.missconsult.xstream.MissExam;
import th.co.aoe.makedev.missconsult.xstream.MissQuestion;

// Referenced classes of package th.co.aoe.makedev.missconsult.exam.form:
//            CommonForm

public class TestForm extends CommonForm
    implements Serializable
{

    public TestForm()
    {
    	missExam =new MissExam();
    	missQuestion=new MissQuestion();
    }

    private static final long serialVersionUID = 1L;
  /*  private String mcaStatus;
    private String mcaSeries;
    private String mcaUsername;
    private String mcaPassword;
    private String mcaCompanyName;*/
    private MissExam missExam;
    private MissQuestion missQuestion;
    private String modeQuestion;
    private String lang;
    
    //for search
    private String megId;
    private String meIdArray;
    
    
    
    private String mqIdArray;
    // for choice
    private String mcIdArray;// mcId1,mcId2
    private String mcIdNewArray; // mcId1@$@value1$$*$$mcId2@$@value2
    private String mcSize="0";
    
    private String megEmptyId;
    
    private String[] mqNos;
    private String[] mqIds;

	public MissExam getMissExam() {
		return missExam;
		
	}

	public void setMissExam(MissExam missExam) {
		this.missExam = missExam;
	}

	public String getMegId() {
		return megId;
	}

	public void setMegId(String megId) {
		this.megId = megId;
	}

	public String getMeIdArray() {
		return meIdArray;
	}

	public void setMeIdArray(String meIdArray) {
		this.meIdArray = meIdArray;
	}

	public MissQuestion getMissQuestion() {
		return missQuestion;
	}

	public void setMissQuestion(MissQuestion missQuestion) {
		this.missQuestion = missQuestion;
	}

	public String getModeQuestion() {
		return modeQuestion;
	}

	public void setModeQuestion(String modeQuestion) {
		this.modeQuestion = modeQuestion;
	}

	public String getMcIdArray() {
		return mcIdArray;
	}

	public String getMcIdNewArray() {
		return mcIdNewArray;
	}

	public void setMcIdNewArray(String mcIdNewArray) {
		this.mcIdNewArray = mcIdNewArray;
	}

	public void setMcIdArray(String mcIdArray) {
		this.mcIdArray = mcIdArray;
	}

	public String getMcSize() {
		return mcSize;
	}

	public void setMcSize(String mcSize) {
		this.mcSize = mcSize;
	}

	public String getMqIdArray() {
		return mqIdArray;
	}

	public void setMqIdArray(String mqIdArray) {
		this.mqIdArray = mqIdArray;
	}

	public String getMegEmptyId() {
		return megEmptyId;
	}

	public String[] getMqNos() {
		return mqNos;
	}

	public void setMqNos(String[] mqNos) {
		this.mqNos = mqNos;
	}

	public String[] getMqIds() {
		return mqIds;
	}

	public void setMqIds(String[] mqIds) {
		this.mqIds = mqIds;
	}

	public void setMegEmptyId(String megEmptyId) {
		this.megEmptyId = megEmptyId;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	 

	/*public String getMesIdArray() {
		return mesIdArray;
	}

	public void setMesIdArray(String mesIdArray) {
		this.mesIdArray = mesIdArray;
	}
    */
}
