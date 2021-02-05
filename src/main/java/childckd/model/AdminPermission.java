package childckd.model;

import java.util.Date;

public class AdminPermission {
    private String apid;

    private String administratorid;

    private String permissionid;

    private Date chuangjianshijian;

    private String beizhu;

    private Integer zhuangtai;

    public String getApid() {
        return apid;
    }

    public void setApid(String apid) {
        this.apid = apid;
    }

    public String getAdministratorid() {
        return administratorid;
    }

    public void setAdministratorid(String administratorid) {
        this.administratorid = administratorid;
    }

    public String getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(String permissionid) {
        this.permissionid = permissionid;
    }

    public Date getChuangjianshijian() {
        return chuangjianshijian;
    }

    public void setChuangjianshijian(Date chuangjianshijian) {
        this.chuangjianshijian = chuangjianshijian;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public Integer getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(Integer zhuangtai) {
        this.zhuangtai = zhuangtai;
    }
}