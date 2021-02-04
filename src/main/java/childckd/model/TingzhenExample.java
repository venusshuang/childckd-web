package childckd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TingzhenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TingzhenExample() {
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

        public Criteria andTingzhenidIsNull() {
            addCriterion("tingzhenid is null");
            return (Criteria) this;
        }

        public Criteria andTingzhenidIsNotNull() {
            addCriterion("tingzhenid is not null");
            return (Criteria) this;
        }

        public Criteria andTingzhenidEqualTo(String value) {
            addCriterion("tingzhenid =", value, "tingzhenid");
            return (Criteria) this;
        }

        public Criteria andTingzhenidNotEqualTo(String value) {
            addCriterion("tingzhenid <>", value, "tingzhenid");
            return (Criteria) this;
        }

        public Criteria andTingzhenidGreaterThan(String value) {
            addCriterion("tingzhenid >", value, "tingzhenid");
            return (Criteria) this;
        }

        public Criteria andTingzhenidGreaterThanOrEqualTo(String value) {
            addCriterion("tingzhenid >=", value, "tingzhenid");
            return (Criteria) this;
        }

        public Criteria andTingzhenidLessThan(String value) {
            addCriterion("tingzhenid <", value, "tingzhenid");
            return (Criteria) this;
        }

        public Criteria andTingzhenidLessThanOrEqualTo(String value) {
            addCriterion("tingzhenid <=", value, "tingzhenid");
            return (Criteria) this;
        }

        public Criteria andTingzhenidLike(String value) {
            addCriterion("tingzhenid like", value, "tingzhenid");
            return (Criteria) this;
        }

        public Criteria andTingzhenidNotLike(String value) {
            addCriterion("tingzhenid not like", value, "tingzhenid");
            return (Criteria) this;
        }

        public Criteria andTingzhenidIn(List<String> values) {
            addCriterion("tingzhenid in", values, "tingzhenid");
            return (Criteria) this;
        }

        public Criteria andTingzhenidNotIn(List<String> values) {
            addCriterion("tingzhenid not in", values, "tingzhenid");
            return (Criteria) this;
        }

        public Criteria andTingzhenidBetween(String value1, String value2) {
            addCriterion("tingzhenid between", value1, value2, "tingzhenid");
            return (Criteria) this;
        }

        public Criteria andTingzhenidNotBetween(String value1, String value2) {
            addCriterion("tingzhenid not between", value1, value2, "tingzhenid");
            return (Criteria) this;
        }

        public Criteria andExpertidIsNull() {
            addCriterion("expertid is null");
            return (Criteria) this;
        }

        public Criteria andExpertidIsNotNull() {
            addCriterion("expertid is not null");
            return (Criteria) this;
        }

        public Criteria andExpertidEqualTo(String value) {
            addCriterion("expertid =", value, "expertid");
            return (Criteria) this;
        }

        public Criteria andExpertidNotEqualTo(String value) {
            addCriterion("expertid <>", value, "expertid");
            return (Criteria) this;
        }

        public Criteria andExpertidGreaterThan(String value) {
            addCriterion("expertid >", value, "expertid");
            return (Criteria) this;
        }

        public Criteria andExpertidGreaterThanOrEqualTo(String value) {
            addCriterion("expertid >=", value, "expertid");
            return (Criteria) this;
        }

        public Criteria andExpertidLessThan(String value) {
            addCriterion("expertid <", value, "expertid");
            return (Criteria) this;
        }

        public Criteria andExpertidLessThanOrEqualTo(String value) {
            addCriterion("expertid <=", value, "expertid");
            return (Criteria) this;
        }

        public Criteria andExpertidLike(String value) {
            addCriterion("expertid like", value, "expertid");
            return (Criteria) this;
        }

        public Criteria andExpertidNotLike(String value) {
            addCriterion("expertid not like", value, "expertid");
            return (Criteria) this;
        }

        public Criteria andExpertidIn(List<String> values) {
            addCriterion("expertid in", values, "expertid");
            return (Criteria) this;
        }

        public Criteria andExpertidNotIn(List<String> values) {
            addCriterion("expertid not in", values, "expertid");
            return (Criteria) this;
        }

        public Criteria andExpertidBetween(String value1, String value2) {
            addCriterion("expertid between", value1, value2, "expertid");
            return (Criteria) this;
        }

        public Criteria andExpertidNotBetween(String value1, String value2) {
            addCriterion("expertid not between", value1, value2, "expertid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andIsamIsNull() {
            addCriterion("isam is null");
            return (Criteria) this;
        }

        public Criteria andIsamIsNotNull() {
            addCriterion("isam is not null");
            return (Criteria) this;
        }

        public Criteria andIsamEqualTo(Integer value) {
            addCriterion("isam =", value, "isam");
            return (Criteria) this;
        }

        public Criteria andIsamNotEqualTo(Integer value) {
            addCriterion("isam <>", value, "isam");
            return (Criteria) this;
        }

        public Criteria andIsamGreaterThan(Integer value) {
            addCriterion("isam >", value, "isam");
            return (Criteria) this;
        }

        public Criteria andIsamGreaterThanOrEqualTo(Integer value) {
            addCriterion("isam >=", value, "isam");
            return (Criteria) this;
        }

        public Criteria andIsamLessThan(Integer value) {
            addCriterion("isam <", value, "isam");
            return (Criteria) this;
        }

        public Criteria andIsamLessThanOrEqualTo(Integer value) {
            addCriterion("isam <=", value, "isam");
            return (Criteria) this;
        }

        public Criteria andIsamIn(List<Integer> values) {
            addCriterion("isam in", values, "isam");
            return (Criteria) this;
        }

        public Criteria andIsamNotIn(List<Integer> values) {
            addCriterion("isam not in", values, "isam");
            return (Criteria) this;
        }

        public Criteria andIsamBetween(Integer value1, Integer value2) {
            addCriterion("isam between", value1, value2, "isam");
            return (Criteria) this;
        }

        public Criteria andIsamNotBetween(Integer value1, Integer value2) {
            addCriterion("isam not between", value1, value2, "isam");
            return (Criteria) this;
        }

        public Criteria andIspmIsNull() {
            addCriterion("ispm is null");
            return (Criteria) this;
        }

        public Criteria andIspmIsNotNull() {
            addCriterion("ispm is not null");
            return (Criteria) this;
        }

        public Criteria andIspmEqualTo(Integer value) {
            addCriterion("ispm =", value, "ispm");
            return (Criteria) this;
        }

        public Criteria andIspmNotEqualTo(Integer value) {
            addCriterion("ispm <>", value, "ispm");
            return (Criteria) this;
        }

        public Criteria andIspmGreaterThan(Integer value) {
            addCriterion("ispm >", value, "ispm");
            return (Criteria) this;
        }

        public Criteria andIspmGreaterThanOrEqualTo(Integer value) {
            addCriterion("ispm >=", value, "ispm");
            return (Criteria) this;
        }

        public Criteria andIspmLessThan(Integer value) {
            addCriterion("ispm <", value, "ispm");
            return (Criteria) this;
        }

        public Criteria andIspmLessThanOrEqualTo(Integer value) {
            addCriterion("ispm <=", value, "ispm");
            return (Criteria) this;
        }

        public Criteria andIspmIn(List<Integer> values) {
            addCriterion("ispm in", values, "ispm");
            return (Criteria) this;
        }

        public Criteria andIspmNotIn(List<Integer> values) {
            addCriterion("ispm not in", values, "ispm");
            return (Criteria) this;
        }

        public Criteria andIspmBetween(Integer value1, Integer value2) {
            addCriterion("ispm between", value1, value2, "ispm");
            return (Criteria) this;
        }

        public Criteria andIspmNotBetween(Integer value1, Integer value2) {
            addCriterion("ispm not between", value1, value2, "ispm");
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