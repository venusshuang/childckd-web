package childckd.model;

import java.util.Date;

public class Expert {
    private String expertid;

    private String name;

    private String danwei;

    private String keshi;

    private String zhiwu;

    private Date chushengnianyue;

    private String jianjie;

    private Integer zhuangtai;

    private String picsrc;

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

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public String getKeshi() {
        return keshi;
    }

    public void setKeshi(String keshi) {
        this.keshi = keshi;
    }

    public String getZhiwu() {
        return zhiwu;
    }

    public void setZhiwu(String zhiwu) {
        this.zhiwu = zhiwu;
    }

    public Date getChushengnianyue() {
        return chushengnianyue;
    }

    public void setChushengnianyue(Date chushengnianyue) {
        this.chushengnianyue = chushengnianyue;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    public Integer getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(Integer zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public String getPicsrc() {
        return picsrc;
    }

    public void setPicsrc(String picsrc) {
        this.picsrc = picsrc;
    }
}