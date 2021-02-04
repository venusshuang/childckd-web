package childckd.model;

import java.util.Date;

public class Info {
    private String infoid;

    private String jianti;

    private String infotitle;

    private String infotitle2;

    private String summary;

    private String source;

    private String author;

    private Date addtime;

    private Date releasetime;

    private String imageurl;

    private String videourl;

    private String returnurl;

    private Integer clicknum;

    private Integer checkpass;

    private String infocontent;

    public String getInfoid() {
        return infoid;
    }

    public void setInfoid(String infoid) {
        this.infoid = infoid;
    }

    public String getJianti() {
        return jianti;
    }

    public void setJianti(String jianti) {
        this.jianti = jianti;
    }

    public String getInfotitle() {
        return infotitle;
    }

    public void setInfotitle(String infotitle) {
        this.infotitle = infotitle;
    }

    public String getInfotitle2() {
        return infotitle2;
    }

    public void setInfotitle2(String infotitle2) {
        this.infotitle2 = infotitle2;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getReturnurl() {
        return returnurl;
    }

    public void setReturnurl(String returnurl) {
        this.returnurl = returnurl;
    }

    public Integer getClicknum() {
        return clicknum;
    }

    public void setClicknum(Integer clicknum) {
        this.clicknum = clicknum;
    }

    public Integer getCheckpass() {
        return checkpass;
    }

    public void setCheckpass(Integer checkpass) {
        this.checkpass = checkpass;
    }

    public String getInfocontent() {
        return infocontent;
    }

    public void setInfocontent(String infocontent) {
        this.infocontent = infocontent;
    }
}