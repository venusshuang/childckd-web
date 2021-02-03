package childckd.model;

public class PatientLogin {
    private String userid;

    private String loginname;

    private String loginpassword;

    private String shoujihao;

    private String name;

    private Integer zhuangtai;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginpassword() {
        return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword;
    }

    public String getShoujihao() {
        return shoujihao;
    }

    public void setShoujihao(String shoujihao) {
        this.shoujihao = shoujihao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(Integer zhuangtai) {
        this.zhuangtai = zhuangtai;
    }
}