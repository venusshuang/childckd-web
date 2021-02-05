package childckd.model;

import java.util.Date;

public class Role {
    private String roleid;

    private String rolename;

    private String displayname;

    private String beizhu;

    private Date chuangjianshijian;

    private Integer zhuangtai;

    private String chuangjianrenid;

    private String parentroleid;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
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

    public String getChuangjianrenid() {
        return chuangjianrenid;
    }

    public void setChuangjianrenid(String chuangjianrenid) {
        this.chuangjianrenid = chuangjianrenid;
    }

    public String getParentroleid() {
        return parentroleid;
    }

    public void setParentroleid(String parentroleid) {
        this.parentroleid = parentroleid;
    }
}