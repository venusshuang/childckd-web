package childckd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpertExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpertExample() {
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

        public Criteria andKeshiIsNull() {
            addCriterion("keshi is null");
            return (Criteria) this;
        }

        public Criteria andKeshiIsNotNull() {
            addCriterion("keshi is not null");
            return (Criteria) this;
        }

        public Criteria andKeshiEqualTo(String value) {
            addCriterion("keshi =", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiNotEqualTo(String value) {
            addCriterion("keshi <>", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiGreaterThan(String value) {
            addCriterion("keshi >", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiGreaterThanOrEqualTo(String value) {
            addCriterion("keshi >=", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiLessThan(String value) {
            addCriterion("keshi <", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiLessThanOrEqualTo(String value) {
            addCriterion("keshi <=", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiLike(String value) {
            addCriterion("keshi like", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiNotLike(String value) {
            addCriterion("keshi not like", value, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiIn(List<String> values) {
            addCriterion("keshi in", values, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiNotIn(List<String> values) {
            addCriterion("keshi not in", values, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiBetween(String value1, String value2) {
            addCriterion("keshi between", value1, value2, "keshi");
            return (Criteria) this;
        }

        public Criteria andKeshiNotBetween(String value1, String value2) {
            addCriterion("keshi not between", value1, value2, "keshi");
            return (Criteria) this;
        }

        public Criteria andZhiwuIsNull() {
            addCriterion("zhiwu is null");
            return (Criteria) this;
        }

        public Criteria andZhiwuIsNotNull() {
            addCriterion("zhiwu is not null");
            return (Criteria) this;
        }

        public Criteria andZhiwuEqualTo(String value) {
            addCriterion("zhiwu =", value, "zhiwu");
            return (Criteria) this;
        }

        public Criteria andZhiwuNotEqualTo(String value) {
            addCriterion("zhiwu <>", value, "zhiwu");
            return (Criteria) this;
        }

        public Criteria andZhiwuGreaterThan(String value) {
            addCriterion("zhiwu >", value, "zhiwu");
            return (Criteria) this;
        }

        public Criteria andZhiwuGreaterThanOrEqualTo(String value) {
            addCriterion("zhiwu >=", value, "zhiwu");
            return (Criteria) this;
        }

        public Criteria andZhiwuLessThan(String value) {
            addCriterion("zhiwu <", value, "zhiwu");
            return (Criteria) this;
        }

        public Criteria andZhiwuLessThanOrEqualTo(String value) {
            addCriterion("zhiwu <=", value, "zhiwu");
            return (Criteria) this;
        }

        public Criteria andZhiwuLike(String value) {
            addCriterion("zhiwu like", value, "zhiwu");
            return (Criteria) this;
        }

        public Criteria andZhiwuNotLike(String value) {
            addCriterion("zhiwu not like", value, "zhiwu");
            return (Criteria) this;
        }

        public Criteria andZhiwuIn(List<String> values) {
            addCriterion("zhiwu in", values, "zhiwu");
            return (Criteria) this;
        }

        public Criteria andZhiwuNotIn(List<String> values) {
            addCriterion("zhiwu not in", values, "zhiwu");
            return (Criteria) this;
        }

        public Criteria andZhiwuBetween(String value1, String value2) {
            addCriterion("zhiwu between", value1, value2, "zhiwu");
            return (Criteria) this;
        }

        public Criteria andZhiwuNotBetween(String value1, String value2) {
            addCriterion("zhiwu not between", value1, value2, "zhiwu");
            return (Criteria) this;
        }

        public Criteria andChushengnianyueIsNull() {
            addCriterion("chushengnianyue is null");
            return (Criteria) this;
        }

        public Criteria andChushengnianyueIsNotNull() {
            addCriterion("chushengnianyue is not null");
            return (Criteria) this;
        }

        public Criteria andChushengnianyueEqualTo(Date value) {
            addCriterion("chushengnianyue =", value, "chushengnianyue");
            return (Criteria) this;
        }

        public Criteria andChushengnianyueNotEqualTo(Date value) {
            addCriterion("chushengnianyue <>", value, "chushengnianyue");
            return (Criteria) this;
        }

        public Criteria andChushengnianyueGreaterThan(Date value) {
            addCriterion("chushengnianyue >", value, "chushengnianyue");
            return (Criteria) this;
        }

        public Criteria andChushengnianyueGreaterThanOrEqualTo(Date value) {
            addCriterion("chushengnianyue >=", value, "chushengnianyue");
            return (Criteria) this;
        }

        public Criteria andChushengnianyueLessThan(Date value) {
            addCriterion("chushengnianyue <", value, "chushengnianyue");
            return (Criteria) this;
        }

        public Criteria andChushengnianyueLessThanOrEqualTo(Date value) {
            addCriterion("chushengnianyue <=", value, "chushengnianyue");
            return (Criteria) this;
        }

        public Criteria andChushengnianyueIn(List<Date> values) {
            addCriterion("chushengnianyue in", values, "chushengnianyue");
            return (Criteria) this;
        }

        public Criteria andChushengnianyueNotIn(List<Date> values) {
            addCriterion("chushengnianyue not in", values, "chushengnianyue");
            return (Criteria) this;
        }

        public Criteria andChushengnianyueBetween(Date value1, Date value2) {
            addCriterion("chushengnianyue between", value1, value2, "chushengnianyue");
            return (Criteria) this;
        }

        public Criteria andChushengnianyueNotBetween(Date value1, Date value2) {
            addCriterion("chushengnianyue not between", value1, value2, "chushengnianyue");
            return (Criteria) this;
        }

        public Criteria andJianjieIsNull() {
            addCriterion("jianjie is null");
            return (Criteria) this;
        }

        public Criteria andJianjieIsNotNull() {
            addCriterion("jianjie is not null");
            return (Criteria) this;
        }

        public Criteria andJianjieEqualTo(String value) {
            addCriterion("jianjie =", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieNotEqualTo(String value) {
            addCriterion("jianjie <>", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieGreaterThan(String value) {
            addCriterion("jianjie >", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieGreaterThanOrEqualTo(String value) {
            addCriterion("jianjie >=", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieLessThan(String value) {
            addCriterion("jianjie <", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieLessThanOrEqualTo(String value) {
            addCriterion("jianjie <=", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieLike(String value) {
            addCriterion("jianjie like", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieNotLike(String value) {
            addCriterion("jianjie not like", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieIn(List<String> values) {
            addCriterion("jianjie in", values, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieNotIn(List<String> values) {
            addCriterion("jianjie not in", values, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieBetween(String value1, String value2) {
            addCriterion("jianjie between", value1, value2, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieNotBetween(String value1, String value2) {
            addCriterion("jianjie not between", value1, value2, "jianjie");
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

        public Criteria andPicsrcIsNull() {
            addCriterion("picsrc is null");
            return (Criteria) this;
        }

        public Criteria andPicsrcIsNotNull() {
            addCriterion("picsrc is not null");
            return (Criteria) this;
        }

        public Criteria andPicsrcEqualTo(String value) {
            addCriterion("picsrc =", value, "picsrc");
            return (Criteria) this;
        }

        public Criteria andPicsrcNotEqualTo(String value) {
            addCriterion("picsrc <>", value, "picsrc");
            return (Criteria) this;
        }

        public Criteria andPicsrcGreaterThan(String value) {
            addCriterion("picsrc >", value, "picsrc");
            return (Criteria) this;
        }

        public Criteria andPicsrcGreaterThanOrEqualTo(String value) {
            addCriterion("picsrc >=", value, "picsrc");
            return (Criteria) this;
        }

        public Criteria andPicsrcLessThan(String value) {
            addCriterion("picsrc <", value, "picsrc");
            return (Criteria) this;
        }

        public Criteria andPicsrcLessThanOrEqualTo(String value) {
            addCriterion("picsrc <=", value, "picsrc");
            return (Criteria) this;
        }

        public Criteria andPicsrcLike(String value) {
            addCriterion("picsrc like", value, "picsrc");
            return (Criteria) this;
        }

        public Criteria andPicsrcNotLike(String value) {
            addCriterion("picsrc not like", value, "picsrc");
            return (Criteria) this;
        }

        public Criteria andPicsrcIn(List<String> values) {
            addCriterion("picsrc in", values, "picsrc");
            return (Criteria) this;
        }

        public Criteria andPicsrcNotIn(List<String> values) {
            addCriterion("picsrc not in", values, "picsrc");
            return (Criteria) this;
        }

        public Criteria andPicsrcBetween(String value1, String value2) {
            addCriterion("picsrc between", value1, value2, "picsrc");
            return (Criteria) this;
        }

        public Criteria andPicsrcNotBetween(String value1, String value2) {
            addCriterion("picsrc not between", value1, value2, "picsrc");
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