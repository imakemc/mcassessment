// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 5/27/2012 12:12:33 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   CommonForm.java

package th.co.imake.missconsult.assessment.form;

import java.io.Serializable;
import th.co.aoe.makedev.missconsult.xstream.common.Paging;

public class CommonForm
    implements Serializable
{

    public CommonForm()
    {
        paging = new Paging();
    }

    public int getPageCount()
    {
        return pageCount;
    }

    public void setPageCount(int pageCount)
    {
        this.pageCount = pageCount;
    }

    public Paging getPaging()
    {
        return paging;
    }

    public void setPaging(Paging paging)
    {
        this.paging = paging;
    }

    public String getMode()
    {
        return mode;
    }

    public void setMode(String mode)
    {
        this.mode = mode;
    }

    private static final long serialVersionUID = 1L;
    private String mode;
    private Paging paging;
    private int pageCount;
}
