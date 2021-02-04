package childckd.model;

public class Referral {
    private String referralid;

    private String doctorid;

    private String doctorname;

    private String danwei;

    private String patientname;

    private Integer patientage;

    private String zhusu;

    private Integer zhuangtai;

    public String getReferralid() {
        return referralid;
    }

    public void setReferralid(String referralid) {
        this.referralid = referralid;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public Integer getPatientage() {
        return patientage;
    }

    public void setPatientage(Integer patientage) {
        this.patientage = patientage;
    }

    public String getZhusu() {
        return zhusu;
    }

    public void setZhusu(String zhusu) {
        this.zhusu = zhusu;
    }

    public Integer getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(Integer zhuangtai) {
        this.zhuangtai = zhuangtai;
    }
}