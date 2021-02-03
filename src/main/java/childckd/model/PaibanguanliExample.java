package childckd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaibanguanliExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaibanguanliExample() {
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

        public Criteria andPaibanidIsNull() {
            addCriterion("paibanid is null");
            return (Criteria) this;
        }

        public Criteria andPaibanidIsNotNull() {
            addCriterion("paibanid is not null");
            return (Criteria) this;
        }

        public Criteria andPaibanidEqualTo(String value) {
            addCriterion("paibanid =", value, "paibanid");
            return (Criteria) this;
        }

        public Criteria andPaibanidNotEqualTo(String value) {
            addCriterion("paibanid <>", value, "paibanid");
            return (Criteria) this;
        }

        public Criteria andPaibanidGreaterThan(String value) {
            addCriterion("paibanid >", value, "paibanid");
            return (Criteria) this;
        }

        public Criteria andPaibanidGreaterThanOrEqualTo(String value) {
            addCriterion("paibanid >=", value, "paibanid");
            return (Criteria) this;
        }

        public Criteria andPaibanidLessThan(String value) {
            addCriterion("paibanid <", value, "paibanid");
            return (Criteria) this;
        }

        public Criteria andPaibanidLessThanOrEqualTo(String value) {
            addCriterion("paibanid <=", value, "paibanid");
            return (Criteria) this;
        }

        public Criteria andPaibanidLike(String value) {
            addCriterion("paibanid like", value, "paibanid");
            return (Criteria) this;
        }

        public Criteria andPaibanidNotLike(String value) {
            addCriterion("paibanid not like", value, "paibanid");
            return (Criteria) this;
        }

        public Criteria andPaibanidIn(List<String> values) {
            addCriterion("paibanid in", values, "paibanid");
            return (Criteria) this;
        }

        public Criteria andPaibanidNotIn(List<String> values) {
            addCriterion("paibanid not in", values, "paibanid");
            return (Criteria) this;
        }

        public Criteria andPaibanidBetween(String value1, String value2) {
            addCriterion("paibanid between", value1, value2, "paibanid");
            return (Criteria) this;
        }

        public Criteria andPaibanidNotBetween(String value1, String value2) {
            addCriterion("paibanid not between", value1, value2, "paibanid");
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

        public Criteria andPaibanriqiIsNull() {
            addCriterion("paibanriqi is null");
            return (Criteria) this;
        }

        public Criteria andPaibanriqiIsNotNull() {
            addCriterion("paibanriqi is not null");
            return (Criteria) this;
        }

        public Criteria andPaibanriqiEqualTo(Date value) {
            addCriterion("paibanriqi =", value, "paibanriqi");
            return (Criteria) this;
        }

        public Criteria andPaibanriqiNotEqualTo(Date value) {
            addCriterion("paibanriqi <>", value, "paibanriqi");
            return (Criteria) this;
        }

        public Criteria andPaibanriqiGreaterThan(Date value) {
            addCriterion("paibanriqi >", value, "paibanriqi");
            return (Criteria) this;
        }

        public Criteria andPaibanriqiGreaterThanOrEqualTo(Date value) {
            addCriterion("paibanriqi >=", value, "paibanriqi");
            return (Criteria) this;
        }

        public Criteria andPaibanriqiLessThan(Date value) {
            addCriterion("paibanriqi <", value, "paibanriqi");
            return (Criteria) this;
        }

        public Criteria andPaibanriqiLessThanOrEqualTo(Date value) {
            addCriterion("paibanriqi <=", value, "paibanriqi");
            return (Criteria) this;
        }

        public Criteria andPaibanriqiIn(List<Date> values) {
            addCriterion("paibanriqi in", values, "paibanriqi");
            return (Criteria) this;
        }

        public Criteria andPaibanriqiNotIn(List<Date> values) {
            addCriterion("paibanriqi not in", values, "paibanriqi");
            return (Criteria) this;
        }

        public Criteria andPaibanriqiBetween(Date value1, Date value2) {
            addCriterion("paibanriqi between", value1, value2, "paibanriqi");
            return (Criteria) this;
        }

        public Criteria andPaibanriqiNotBetween(Date value1, Date value2) {
            addCriterion("paibanriqi not between", value1, value2, "paibanriqi");
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

        public Criteria andShengyuhaoshuIsNull() {
            addCriterion("shengyuhaoshu is null");
            return (Criteria) this;
        }

        public Criteria andShengyuhaoshuIsNotNull() {
            addCriterion("shengyuhaoshu is not null");
            return (Criteria) this;
        }

        public Criteria andShengyuhaoshuEqualTo(Integer value) {
            addCriterion("shengyuhaoshu =", value, "shengyuhaoshu");
            return (Criteria) this;
        }

        public Criteria andShengyuhaoshuNotEqualTo(Integer value) {
            addCriterion("shengyuhaoshu <>", value, "shengyuhaoshu");
            return (Criteria) this;
        }

        public Criteria andShengyuhaoshuGreaterThan(Integer value) {
            addCriterion("shengyuhaoshu >", value, "shengyuhaoshu");
            return (Criteria) this;
        }

        public Criteria andShengyuhaoshuGreaterThanOrEqualTo(Integer value) {
            addCriterion("shengyuhaoshu >=", value, "shengyuhaoshu");
            return (Criteria) this;
        }

        public Criteria andShengyuhaoshuLessThan(Integer value) {
            addCriterion("shengyuhaoshu <", value, "shengyuhaoshu");
            return (Criteria) this;
        }

        public Criteria andShengyuhaoshuLessThanOrEqualTo(Integer value) {
            addCriterion("shengyuhaoshu <=", value, "shengyuhaoshu");
            return (Criteria) this;
        }

        public Criteria andShengyuhaoshuIn(List<Integer> values) {
            addCriterion("shengyuhaoshu in", values, "shengyuhaoshu");
            return (Criteria) this;
        }

        public Criteria andShengyuhaoshuNotIn(List<Integer> values) {
            addCriterion("shengyuhaoshu not in", values, "shengyuhaoshu");
            return (Criteria) this;
        }

        public Criteria andShengyuhaoshuBetween(Integer value1, Integer value2) {
            addCriterion("shengyuhaoshu between", value1, value2, "shengyuhaoshu");
            return (Criteria) this;
        }

        public Criteria andShengyuhaoshuNotBetween(Integer value1, Integer value2) {
            addCriterion("shengyuhaoshu not between", value1, value2, "shengyuhaoshu");
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