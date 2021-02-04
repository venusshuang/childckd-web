package childckd.model;

import java.util.ArrayList;
import java.util.List;

public class ReferralExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReferralExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andReferralidIsNull() {
            addCriterion("referralid is null");
            return (Criteria) this;
        }

        public Criteria andReferralidIsNotNull() {
            addCriterion("referralid is not null");
            return (Criteria) this;
        }

        public Criteria andReferralidEqualTo(String value) {
            addCriterion("referralid =", value, "referralid");
            return (Criteria) this;
        }

        public Criteria andReferralidNotEqualTo(String value) {
            addCriterion("referralid <>", value, "referralid");
            return (Criteria) this;
        }

        public Criteria andReferralidGreaterThan(String value) {
            addCriterion("referralid >", value, "referralid");
            return (Criteria) this;
        }

        public Criteria andReferralidGreaterThanOrEqualTo(String value) {
            addCriterion("referralid >=", value, "referralid");
            return (Criteria) this;
        }

        public Criteria andReferralidLessThan(String value) {
            addCriterion("referralid <", value, "referralid");
            return (Criteria) this;
        }

        public Criteria andReferralidLessThanOrEqualTo(String value) {
            addCriterion("referralid <=", value, "referralid");
            return (Criteria) this;
        }

        public Criteria andReferralidLike(String value) {
            addCriterion("referralid like", value, "referralid");
            return (Criteria) this;
        }

        public Criteria andReferralidNotLike(String value) {
            addCriterion("referralid not like", value, "referralid");
            return (Criteria) this;
        }

        public Criteria andReferralidIn(List<String> values) {
            addCriterion("referralid in", values, "referralid");
            return (Criteria) this;
        }

        public Criteria andReferralidNotIn(List<String> values) {
            addCriterion("referralid not in", values, "referralid");
            return (Criteria) this;
        }

        public Criteria andReferralidBetween(String value1, String value2) {
            addCriterion("referralid between", value1, value2, "referralid");
            return (Criteria) this;
        }

        public Criteria andReferralidNotBetween(String value1, String value2) {
            addCriterion("referralid not between", value1, value2, "referralid");
            return (Criteria) this;
        }

        public Criteria andDoctoridIsNull() {
            addCriterion("doctorid is null");
            return (Criteria) this;
        }

        public Criteria andDoctoridIsNotNull() {
            addCriterion("doctorid is not null");
            return (Criteria) this;
        }

        public Criteria andDoctoridEqualTo(String value) {
            addCriterion("doctorid =", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotEqualTo(String value) {
            addCriterion("doctorid <>", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridGreaterThan(String value) {
            addCriterion("doctorid >", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridGreaterThanOrEqualTo(String value) {
            addCriterion("doctorid >=", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridLessThan(String value) {
            addCriterion("doctorid <", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridLessThanOrEqualTo(String value) {
            addCriterion("doctorid <=", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridLike(String value) {
            addCriterion("doctorid like", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotLike(String value) {
            addCriterion("doctorid not like", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridIn(List<String> values) {
            addCriterion("doctorid in", values, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotIn(List<String> values) {
            addCriterion("doctorid not in", values, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridBetween(String value1, String value2) {
            addCriterion("doctorid between", value1, value2, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotBetween(String value1, String value2) {
            addCriterion("doctorid not between", value1, value2, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctornameIsNull() {
            addCriterion("doctorname is null");
            return (Criteria) this;
        }

        public Criteria andDoctornameIsNotNull() {
            addCriterion("doctorname is not null");
            return (Criteria) this;
        }

        public Criteria andDoctornameEqualTo(String value) {
            addCriterion("doctorname =", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameNotEqualTo(String value) {
            addCriterion("doctorname <>", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameGreaterThan(String value) {
            addCriterion("doctorname >", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameGreaterThanOrEqualTo(String value) {
            addCriterion("doctorname >=", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameLessThan(String value) {
            addCriterion("doctorname <", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameLessThanOrEqualTo(String value) {
            addCriterion("doctorname <=", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameLike(String value) {
            addCriterion("doctorname like", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameNotLike(String value) {
            addCriterion("doctorname not like", value, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameIn(List<String> values) {
            addCriterion("doctorname in", values, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameNotIn(List<String> values) {
            addCriterion("doctorname not in", values, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameBetween(String value1, String value2) {
            addCriterion("doctorname between", value1, value2, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDoctornameNotBetween(String value1, String value2) {
            addCriterion("doctorname not between", value1, value2, "doctorname");
            return (Criteria) this;
        }

        public Criteria andDanweiIsNull() {
            addCriterion("danwei is null");
            return (Criteria) this;
        }

        public Criteria andDanweiIsNotNull() {
            addCriterion("danwei is not null");
            return (Criteria) this;
        }

        public Criteria andDanweiEqualTo(String value) {
            addCriterion("danwei =", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiNotEqualTo(String value) {
            addCriterion("danwei <>", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiGreaterThan(String value) {
            addCriterion("danwei >", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiGreaterThanOrEqualTo(String value) {
            addCriterion("danwei >=", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiLessThan(String value) {
            addCriterion("danwei <", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiLessThanOrEqualTo(String value) {
            addCriterion("danwei <=", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiLike(String value) {
            addCriterion("danwei like", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiNotLike(String value) {
            addCriterion("danwei not like", value, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiIn(List<String> values) {
            addCriterion("danwei in", values, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiNotIn(List<String> values) {
            addCriterion("danwei not in", values, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiBetween(String value1, String value2) {
            addCriterion("danwei between", value1, value2, "danwei");
            return (Criteria) this;
        }

        public Criteria andDanweiNotBetween(String value1, String value2) {
            addCriterion("danwei not between", value1, value2, "danwei");
            return (Criteria) this;
        }

        public Criteria andPatientnameIsNull() {
            addCriterion("patientname is null");
            return (Criteria) this;
        }

        public Criteria andPatientnameIsNotNull() {
            addCriterion("patientname is not null");
            return (Criteria) this;
        }

        public Criteria andPatientnameEqualTo(String value) {
            addCriterion("patientname =", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameNotEqualTo(String value) {
            addCriterion("patientname <>", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameGreaterThan(String value) {
            addCriterion("patientname >", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameGreaterThanOrEqualTo(String value) {
            addCriterion("patientname >=", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameLessThan(String value) {
            addCriterion("patientname <", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameLessThanOrEqualTo(String value) {
            addCriterion("patientname <=", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameLike(String value) {
            addCriterion("patientname like", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameNotLike(String value) {
            addCriterion("patientname not like", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameIn(List<String> values) {
            addCriterion("patientname in", values, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameNotIn(List<String> values) {
            addCriterion("patientname not in", values, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameBetween(String value1, String value2) {
            addCriterion("patientname between", value1, value2, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameNotBetween(String value1, String value2) {
            addCriterion("patientname not between", value1, value2, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientageIsNull() {
            addCriterion("patientage is null");
            return (Criteria) this;
        }

        public Criteria andPatientageIsNotNull() {
            addCriterion("patientage is not null");
            return (Criteria) this;
        }

        public Criteria andPatientageEqualTo(Integer value) {
            addCriterion("patientage =", value, "patientage");
            return (Criteria) this;
        }

        public Criteria andPatientageNotEqualTo(Integer value) {
            addCriterion("patientage <>", value, "patientage");
            return (Criteria) this;
        }

        public Criteria andPatientageGreaterThan(Integer value) {
            addCriterion("patientage >", value, "patientage");
            return (Criteria) this;
        }

        public Criteria andPatientageGreaterThanOrEqualTo(Integer value) {
            addCriterion("patientage >=", value, "patientage");
            return (Criteria) this;
        }

        public Criteria andPatientageLessThan(Integer value) {
            addCriterion("patientage <", value, "patientage");
            return (Criteria) this;
        }

        public Criteria andPatientageLessThanOrEqualTo(Integer value) {
            addCriterion("patientage <=", value, "patientage");
            return (Criteria) this;
        }

        public Criteria andPatientageIn(List<Integer> values) {
            addCriterion("patientage in", values, "patientage");
            return (Criteria) this;
        }

        public Criteria andPatientageNotIn(List<Integer> values) {
            addCriterion("patientage not in", values, "patientage");
            return (Criteria) this;
        }

        public Criteria andPatientageBetween(Integer value1, Integer value2) {
            addCriterion("patientage between", value1, value2, "patientage");
            return (Criteria) this;
        }

        public Criteria andPatientageNotBetween(Integer value1, Integer value2) {
            addCriterion("patientage not between", value1, value2, "patientage");
            return (Criteria) this;
        }

        public Criteria andZhusuIsNull() {
            addCriterion("zhusu is null");
            return (Criteria) this;
        }

        public Criteria andZhusuIsNotNull() {
            addCriterion("zhusu is not null");
            return (Criteria) this;
        }

        public Criteria andZhusuEqualTo(String value) {
            addCriterion("zhusu =", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuNotEqualTo(String value) {
            addCriterion("zhusu <>", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuGreaterThan(String value) {
            addCriterion("zhusu >", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuGreaterThanOrEqualTo(String value) {
            addCriterion("zhusu >=", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuLessThan(String value) {
            addCriterion("zhusu <", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuLessThanOrEqualTo(String value) {
            addCriterion("zhusu <=", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuLike(String value) {
            addCriterion("zhusu like", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuNotLike(String value) {
            addCriterion("zhusu not like", value, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuIn(List<String> values) {
            addCriterion("zhusu in", values, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuNotIn(List<String> values) {
            addCriterion("zhusu not in", values, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuBetween(String value1, String value2) {
            addCriterion("zhusu between", value1, value2, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhusuNotBetween(String value1, String value2) {
            addCriterion("zhusu not between", value1, value2, "zhusu");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiIsNull() {
            addCriterion("zhuangtai is null");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiIsNotNull() {
            addCriterion("zhuangtai is not null");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiEqualTo(Integer value) {
            addCriterion("zhuangtai =", value, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiNotEqualTo(Integer value) {
            addCriterion("zhuangtai <>", value, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiGreaterThan(Integer value) {
            addCriterion("zhuangtai >", value, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiGreaterThanOrEqualTo(Integer value) {
            addCriterion("zhuangtai >=", value, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiLessThan(Integer value) {
            addCriterion("zhuangtai <", value, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiLessThanOrEqualTo(Integer value) {
            addCriterion("zhuangtai <=", value, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiIn(List<Integer> values) {
            addCriterion("zhuangtai in", values, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiNotIn(List<Integer> values) {
            addCriterion("zhuangtai not in", values, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiBetween(Integer value1, Integer value2) {
            addCriterion("zhuangtai between", value1, value2, "zhuangtai");
            return (Criteria) this;
        }

        public Criteria andZhuangtaiNotBetween(Integer value1, Integer value2) {
            addCriterion("zhuangtai not between", value1, value2, "zhuangtai");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}