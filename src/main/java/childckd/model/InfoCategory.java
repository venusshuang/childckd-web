package childckd.model;

import java.util.Date;

public class InfoCategory {
    private String categoryid;

    private String parentcategoryid;

    private String categoryname;

    private String picurl;

    private Float score;

    private Date addtime;

    private Integer ordernum;

    private Integer allowdelete;

    private Integer allowtougao;

    private Integer isvalid;

    private String beizhu;

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getParentcategoryid() {
        return parentcategoryid;
    }

    public void setParentcategoryid(String parentcategoryid) {
        this.parentcategoryid = parentcategoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public Integer getAllowdelete() {
        return allowdelete;
    }

    public void setAllowdelete(Integer allowdelete) {
        this.allowdelete = allowdelete;
    }

    public Integer getAllowtougao() {
        return allowtougao;
    }

    public void setAllowtougao(Integer allowtougao) {
        this.allowtougao = allowtougao;
    }

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }
}