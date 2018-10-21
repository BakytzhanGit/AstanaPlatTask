package com.example.bakytzhan.astanaplattask;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Response")
public class PlacesResp {

    @Element(name="ErrMsg")
    private String errMsg;

    @ElementList(name="PostPoint", inline=true)
    @Path("PostPoints")
    public List<SinglePlace> placeList;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public List<SinglePlace> getPlaceList() {
        return placeList;
    }

    public void setArticleList(List<SinglePlace> placeList) {
        this.placeList = placeList;
    }


}