package childckd.model;

import java.util.Date;

public class Permission {
    private String permissionid;

    private String fatherid;

    private String permisssionname;

    private String url;

    private Integer paixuhao;

    private String beizhu;

    private Date chuangjianshijian;

    private Integer zhuangtai;

    public String getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(String permissionid) {
        this.permissionid = permissionid;
    }

    public String getFatherid() {
        return fatherid;
    }

    public void setFatherid(String fatherid) {
        this.fatherid = fatherid;
    }

    public String getPermisssionname() {
        return permisssionname;
    }

    public void setPermisssionname(String permisssionname) {
        this.permisssionname = permisssionname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPaixuhao() {
        return paixuhao;
    }

    public void setPaixuhao(Integer paixuhao) {
        this.paixuhao = paixuhao;
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
}