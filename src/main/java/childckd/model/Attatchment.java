package childckd.model;

import java.util.Date;

public class Attatchment {
    private String attatchmentid;

    private String ownerid;

    private String filename;

    private String url;

    private Date shangchuanshijian;

    private Integer zhuangtai;

    public String getAttatchmentid() {
        return attatchmentid;
    }

    public void setAttatchmentid(String attatchmentid) {
        this.attatchmentid = attatchmentid;
    }

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getShangchuanshijian() {
        return shangchuanshijian;
    }

    public void setShangchuanshijian(Date shangchuanshijian) {
        this.shangchuanshijian = shangchuanshijian;
    }

    public Integer getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(Integer zhuangtai) {
        this.zhuangtai = zhuangtai;
    }
}