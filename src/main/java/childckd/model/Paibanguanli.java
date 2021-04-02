package childckd.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Paibanguanli {
    private String paibanid;

    private String expertid;

    private String name;

    private String guahaoleibie;

    private Date paibanriqi;

    private String shangxiawu;

    private Integer xianhaoshu;

    private Integer shengyuhaoshu;

    private Float jiage;

    private Integer zhuangtai;

    private String jiahaobingzhong;

    private Integer jiahaoshu;

    public String getPaibanid() {
        return paibanid;
    }

    public void setPaibanid(String paibanid) {
        this.paibanid = paibanid;
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

    public String getGuahaoleibie() {
        return guahaoleibie;
    }

    public void setGuahaoleibie(String guahaoleibie) {
        this.guahaoleibie = guahaoleibie;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getPaibanriqi() {
        return paibanriqi;
    }

    public void setPaibanriqi(Date paibanriqi) {
        this.paibanriqi = paibanriqi;
    }

    public String getShangxiawu() {
        return shangxiawu;
    }

    public void setShangxiawu(String shangxiawu) {
        this.shangxiawu = shangxiawu;
    }

    public Integer getXianhaoshu() {
        return xianhaoshu;
    }

    public void setXianhaoshu(Integer xianhaoshu) {
        this.xianhaoshu = xianhaoshu;
    }

    public Integer getShengyuhaoshu() {
        return shengyuhaoshu;
    }

    public void setShengyuhaoshu(Integer shengyuhaoshu) {
        this.shengyuhaoshu = shengyuhaoshu;
    }

    public Float getJiage() {
        return jiage;
    }

    public void setJiage(Float jiage) {
        this.jiage = jiage;
    }

    public Integer getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(Integer zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public String getJiahaobingzhong() {
        return jiahaobingzhong;
    }

    public void setJiahaobingzhong(String jiahaobingzhong) {
        this.jiahaobingzhong = jiahaobingzhong;
    }

    public Integer getJiahaoshu() {
        return jiahaoshu;
    }

    public void setJiahaoshu(Integer jiahaoshu) {
        this.jiahaoshu = jiahaoshu;
    }
}