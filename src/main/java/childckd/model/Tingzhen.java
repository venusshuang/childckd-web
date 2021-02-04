package childckd.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Tingzhen {
    private String tingzhenid;

    private String expertid;

    private String name;

    private Date starttime;

    private Date endtime;

    private Integer isam;

    private Integer ispm;

    private Integer zhuangtai;

    public String getTingzhenid() {
        return tingzhenid;
    }

    public void setTingzhenid(String tingzhenid) {
        this.tingzhenid = tingzhenid;
    }

    public String getExpertid() {
        return expertid;
    }

    public void setExpertid(String expertid) {
        this.expertid = expertid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getIsam() {
        return isam;
    }

    public void setIsam(Integer isam) {
        this.isam = isam;
    }

    public Integer getIspm() {
        return ispm;
    }

    public void setIspm(Integer ispm) {
        this.ispm = ispm;
    }

    public Integer getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(Integer zhuangtai) {
        this.zhuangtai = zhuangtai;
    }
}