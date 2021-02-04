package childckd.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class News {
    private String newsid;

    private String fajianren;

    private String fajianrenname;

    private String shoujianren;

    private String shoujianrenname;

    private String neirong;

    private Integer newstype;

    private Date chuangjianshijian;

    private Integer zhuangtai;

    private String ownerid;

    public String getNewsid() {
        return newsid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public String getFajianren() {
        return fajianren;
    }

    public void setFajianren(String fajianren) {
        this.fajianren = fajianren;
    }

    public String getFajianrenname() {
        return fajianrenname;
    }

    public void setFajianrenname(String fajianrenname) {
        this.fajianrenname = fajianrenname;
    }

    public String getShoujianren() {
        return shoujianren;
    }

    public void setShoujianren(String shoujianren) {
        this.shoujianren = shoujianren;
    }

    public String getShoujianrenname() {
        return shoujianrenname;
    }

    public void setShoujianrenname(String shoujianrenname) {
        this.shoujianrenname = shoujianrenname;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    public Integer getNewstype() {
        return newstype;
    }

    public void setNewstype(Integer newstype) {
        this.newstype = newstype;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")//页面写入数据库时格式化
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getChuangjianshijian() {
        return chuangjianshijian;
    }

    public void setChuangjianshijian(Date chuangjianshijian) {
        this.chuangjianshijian = chuangjianshijian;
    }

    public Integer getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(Integer zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }
}