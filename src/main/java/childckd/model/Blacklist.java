package childckd.model;

import java.util.Date;

public class Blacklist {
    private String blacklistid;

    private String roles;

    private String userid;

    private String name;

    private String dept;

    private String shoujihao;

    private Date chuangjianshijian;

    private Integer zhuangtai;

    public String getBlacklistid() {
        return blacklistid;
    }

    public void setBlacklistid(String blacklistid) {
        this.blacklistid = blacklistid;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getShoujihao() {
        return shoujihao;
    }

    public void setShoujihao(String shoujihao) {
        this.shoujihao = shoujihao;
    }

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
}