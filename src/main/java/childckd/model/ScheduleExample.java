package childckd.model;

import java.util.ArrayList;
import java.util.List;

public class ScheduleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScheduleExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andXingqiIsNull() {
            addCriterion("xingqi is null");
            return (Criteria) this;
        }

        public Criteria andXingqiIsNotNull() {
            addCriterion("xingqi is not null");
            return (Criteria) this;
        }

        public Criteria andXingqiEqualTo(Integer value) {
            addCriterion("xingqi =", value, "xingqi");
            return (Criteria) this;
        }

        public Criteria andXingqiNotEqualTo(Integer value) {
            addCriterion("xingqi <>", value, "xingqi");
            return (Criteria) this;
        }

        public Criteria andXingqiGreaterThan(Integer value) {
            addCriterion("xingqi >", value, "xingqi");
            return (Criteria) this;
        }

        public Criteria andXingqiGreaterThanOrEqualTo(Integer value) {
            addCriterion("xingqi >=", value, "xingqi");
            return (Criteria) this;
        }

        public Criteria andXingqiLessThan(Integer value) {
            addCriterion("xingqi <", value, "xingqi");
            return (Criteria) this;
        }

        public Criteria andXingqiLessThanOrEqualTo(Integer value) {
            addCriterion("xingqi <=", value, "xingqi");
            return (Criteria) this;
        }

        public Criteria andXingqiIn(List<Integer> values) {
            addCriterion("xingqi in", values, "xingqi");
            return (Criteria) this;
        }

        public Criteria andXingqiNotIn(List<Integer> values) {
            addCriterion("xingqi not in", values, "xingqi");
            return (Criteria) this;
        }

        public Criteria andXingqiBetween(Integer value1, Integer value2) {
            addCriterion("xingqi between", value1, value2, "xingqi");
            return (Criteria) this;
        }

        public Criteria andXingqiNotBetween(Integer value1, Integer value2) {
            addCriterion("xingqi not between", value1, value2, "xingqi");
            return (Criteria) this;
        }

        public Criteria andShangxiawuIsNull() {
            addCriterion("shangxiawu is null");
            return (Criteria) this;
        }

        public Criteria andShangxiawuIsNotNull() {
            addCriterion("shangxiawu is not null");
            return (Criteria) this;
        }

        public Criteria andShangxiawuEqualTo(String value) {
            addCriterion("shangxiawu =", value, "shangxiawu");
            return (Criteria) this;
        }

        public Criteria andShangxiawuNotEqualTo(String value) {
            addCriterion("shangxiawu <>", value, "shangxiawu");
            return (Criteria) this;
        }

        public Criteria andShangxiawuGreaterThan(String value) {
            addCriterion("shangxiawu >", value, "shangxiawu");
            return (Criteria) this;
        }

        public Criteria andShangxiawuGreaterThanOrEqualTo(String value) {
            addCriterion("shangxiawu >=", value, "shangxiawu");
            return (Criteria) this;
        }

        public Criteria andShangxiawuLessThan(String value) {
            addCriterion("shangxiawu <", value, "shangxiawu");
            return (Criteria) this;
        }

        public Criteria andShangxiawuLessThanOrEqualTo(String value) {
            addCriterion("shangxiawu <=", value, "shangxiawu");
            return (Criteria) this;
        }

        public Criteria andShangxiawuLike(String value) {
            addCriterion("shangxiawu like", value, "shangxiawu");
            return (Criteria) this;
        }

        public Criteria andShangxiawuNotLike(String value) {
            addCriterion("shangxiawu not like", value, "shangxiawu");
            return (Criteria) this;
        }

        public Criteria andShangxiawuIn(List<String> values) {
            addCriterion("shangxiawu in", values, "shangxiawu");
            return (Criteria) this;
        }

        public Criteria andShangxiawuNotIn(List<String> values) {
            addCriterion("shangxiawu not in", values, "shangxiawu");
            return (Criteria) this;
        }

        public Criteria andShangxiawuBetween(String value1, String value2) {
            addCriterion("shangxiawu between", value1, value2, "shangxiawu");
            return (Criteria) this;
        }

        public Criteria andShangxiawuNotBetween(String value1, String value2) {
            addCriterion("shangxiawu not between", value1, value2, "shangxiawu");
            return (Criteria) this;
        }

        public Criteria andZhuanjiaxingmingIsNull() {
            addCriterion("zhuanjiaxingming is null");
            return (Criteria) this;
        }

        public Criteria andZhuanjiaxingmingIsNotNull() {
            addCriterion("zhuanjiaxingming is not null");
            return (Criteria) this;
        }

        public Criteria andZhuanjiaxingmingEqualTo(String value) {
            addCriterion("zhuanjiaxingming =", value, "zhuanjiaxingming");
            return (Criteria) this;
        }

        public Criteria andZhuanjiaxingmingNotEqualTo(String value) {
            addCriterion("zhuanjiaxingming <>", value, "zhuanjiaxingming");
            return (Criteria) this;
        }

        public Criteria andZhuanjiaxingmingGreaterThan(String value) {
            addCriterion("zhuanjiaxingming >", value, "zhuanjiaxingming");
            return (Criteria) this;
        }

        public Criteria andZhuanjiaxingmingGreaterThanOrEqualTo(String value) {
            addCriterion("zhuanjiaxingming >=", value, "zhuanjiaxingming");
            return (Criteria) this;
        }

        public Criteria andZhuanjiaxingmingLessThan(String value) {
            addCriterion("zhuanjiaxingming <", value, "zhuanjiaxingming");
            return (Criteria) this;
        }

        public Criteria andZhuanjiaxingmingLessThanOrEqualTo(String value) {
            addCriterion("zhuanjiaxingming <=", value, "zhuanjiaxingming");
            return (Criteria) this;
        }

        public Criteria andZhuanjiaxingmingLike(String value) {
            addCriterion("zhuanjiaxingming like", value, "zhuanjiaxingming");
            return (Criteria) this;
        }

        public Criteria andZhuanjiaxingmingNotLike(String value) {
            addCriterion("zhuanjiaxingming not like", value, "zhuanjiaxingming");
            return (Criteria) this;
        }

        public Criteria andZhuanjiaxingmingIn(List<String> values) {
            addCriterion("zhuanjiaxingming in", values, "zhuanjiaxingming");
            return (Criteria) this;
        }

        public Criteria andZhuanjiaxingmingNotIn(List<String> values) {
            addCriterion("zhuanjiaxingming not in", values, "zhuanjiaxingming");
            return (Criteria) this;
        }

        public Criteria andZhuanjiaxingmingBetween(String value1, String value2) {
            addCriterion("zhuanjiaxingming between", value1, value2, "zhuanjiaxingming");
            return (Criteria) this;
        }

        public Criteria andZhuanjiaxingmingNotBetween(String value1, String value2) {
            addCriterion("zhuanjiaxingming not between", value1, value2, "zhuanjiaxingming");
            return (Criteria) this;
        }

        public Criteria andGuahaoleibieIsNull() {
            addCriterion("guahaoleibie is null");
            return (Criteria) this;
        }

        public Criteria andGuahaoleibieIsNotNull() {
            addCriterion("guahaoleibie is not null");
            return (Criteria) this;
        }

        public Criteria andGuahaoleibieEqualTo(String value) {
            addCriterion("guahaoleibie =", value, "guahaoleibie");
            return (Criteria) this;
        }

        public Criteria andGuahaoleibieNotEqualTo(String value) {
            addCriterion("guahaoleibie <>", value, "guahaoleibie");
            return (Criteria) this;
        }

        public Criteria andGuahaoleibieGreaterThan(String value) {
            addCriterion("guahaoleibie >", value, "guahaoleibie");
            return (Criteria) this;
        }

        public Criteria andGuahaoleibieGreaterThanOrEqualTo(String value) {
            addCriterion("guahaoleibie >=", value, "guahaoleibie");
            return (Criteria) this;
        }

        public Criteria andGuahaoleibieLessThan(String value) {
            addCriterion("guahaoleibie <", value, "guahaoleibie");
            return (Criteria) this;
        }

        public Criteria andGuahaoleibieLessThanOrEqualTo(String value) {
            addCriterion("guahaoleibie <=", value, "guahaoleibie");
            return (Criteria) this;
        }

        public Criteria andGuahaoleibieLike(String value) {
            addCriterion("guahaoleibie like", value, "guahaoleibie");
            return (Criteria) this;
        }

        public Criteria andGuahaoleibieNotLike(String value) {
            addCriterion("guahaoleibie not like", value, "guahaoleibie");
            return (Criteria) this;
        }

        public Criteria andGuahaoleibieIn(List<String> values) {
            addCriterion("guahaoleibie in", values, "guahaoleibie");
            return (Criteria) this;
        }

        public Criteria andGuahaoleibieNotIn(List<String> values) {
            addCriterion("guahaoleibie not in", values, "guahaoleibie");
            return (Criteria) this;
        }

        public Criteria andGuahaoleibieBetween(String value1, String value2) {
            addCriterion("guahaoleibie between", value1, value2, "guahaoleibie");
            return (Criteria) this;
        }

        public Criteria andGuahaoleibieNotBetween(String value1, String value2) {
            addCriterion("guahaoleibie not between", value1, value2, "guahaoleibie");
            return (Criteria) this;
        }

        public Criteria andXianhaoshuIsNull() {
            addCriterion("xianhaoshu is null");
            return (Criteria) this;
        }

        public Criteria andXianhaoshuIsNotNull() {
            addCriterion("xianhaoshu is not null");
            return (Criteria) this;
        }

        public Criteria andXianhaoshuEqualTo(Integer value) {
            addCriterion("xianhaoshu =", value, "xianhaoshu");
            return (Criteria) this;
        }

        public Criteria andXianhaoshuNotEqualTo(Integer value) {
            addCriterion("xianhaoshu <>", value, "xianhaoshu");
            return (Criteria) this;
        }

        public Criteria andXianhaoshuGreaterThan(Integer value) {
            addCriterion("xianhaoshu >", value, "xianhaoshu");
            return (Criteria) this;
        }

        public Criteria andXianhaoshuGreaterThanOrEqualTo(Integer value) {
            addCriterion("xianhaoshu >=", value, "xianhaoshu");
            return (Criteria) this;
        }

        public Criteria andXianhaoshuLessThan(Integer value) {
            addCriterion("xianhaoshu <", value, "xianhaoshu");
            return (Criteria) this;
        }

        public Criteria andXianhaoshuLessThanOrEqualTo(Integer value) {
            addCriterion("xianhaoshu <=", value, "xianhaoshu");
            return (Criteria) this;
        }

        public Criteria andXianhaoshuIn(List<Integer> values) {
            addCriterion("xianhaoshu in", values, "xianhaoshu");
            return (Criteria) this;
        }

        public Criteria andXianhaoshuNotIn(List<Integer> values) {
            addCriterion("xianhaoshu not in", values, "xianhaoshu");
            return (Criteria) this;
        }

        public Criteria andXianhaoshuBetween(Integer value1, Integer value2) {
            addCriterion("xianhaoshu between", value1, value2, "xianhaoshu");
            return (Criteria) this;
        }

        public Criteria andXianhaoshuNotBetween(Integer value1, Integer value2) {
            addCriterion("xianhaoshu not between", value1, value2, "xianhaoshu");
            return (Criteria) this;
        }

        public Criteria andJiageIsNull() {
            addCriterion("jiage is null");
            return (Criteria) this;
        }

        public Criteria andJiageIsNotNull() {
            addCriterion("jiage is not null");
            return (Criteria) this;
        }

        public Criteria andJiageEqualTo(Float value) {
            addCriterion("jiage =", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageNotEqualTo(Float value) {
            addCriterion("jiage <>", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageGreaterThan(Float value) {
            addCriterion("jiage >", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageGreaterThanOrEqualTo(Float value) {
            addCriterion("jiage >=", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageLessThan(Float value) {
            addCriterion("jiage <", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageLessThanOrEqualTo(Float value) {
            addCriterion("jiage <=", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageIn(List<Float> values) {
            addCriterion("jiage in", values, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageNotIn(List<Float> values) {
            addCriterion("jiage not in", values, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageBetween(Float value1, Float value2) {
            addCriterion("jiage between", value1, value2, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageNotBetween(Float value1, Float value2) {
            addCriterion("jiage not between", value1, value2, "jiage");
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