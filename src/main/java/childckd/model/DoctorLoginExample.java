package childckd.model;

import java.util.ArrayList;
import java.util.List;

public class DoctorLoginExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoctorLoginExample() {
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

        public Criteria andLoginnameIsNull() {
            addCriterion("loginname is null");
            return (Criteria) this;
        }

        public Criteria andLoginnameIsNotNull() {
            addCriterion("loginname is not null");
            return (Criteria) this;
        }

        public Criteria andLoginnameEqualTo(String value) {
            addCriterion("loginname =", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotEqualTo(String value) {
            addCriterion("loginname <>", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThan(String value) {
            addCriterion("loginname >", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThanOrEqualTo(String value) {
            addCriterion("loginname >=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThan(String value) {
            addCriterion("loginname <", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThanOrEqualTo(String value) {
            addCriterion("loginname <=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLike(String value) {
            addCriterion("loginname like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotLike(String value) {
            addCriterion("loginname not like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameIn(List<String> values) {
            addCriterion("loginname in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotIn(List<String> values) {
            addCriterion("loginname not in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameBetween(String value1, String value2) {
            addCriterion("loginname between", value1, value2, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotBetween(String value1, String value2) {
            addCriterion("loginname not between", value1, value2, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginpasswordIsNull() {
            addCriterion("loginpassword is null");
            return (Criteria) this;
        }

        public Criteria andLoginpasswordIsNotNull() {
            addCriterion("loginpassword is not null");
            return (Criteria) this;
        }

        public Criteria andLoginpasswordEqualTo(String value) {
            addCriterion("loginpassword =", value, "loginpassword");
            return (Criteria) this;
        }

        public Criteria andLoginpasswordNotEqualTo(String value) {
            addCriterion("loginpassword <>", value, "loginpassword");
            return (Criteria) this;
        }

        public Criteria andLoginpasswordGreaterThan(String value) {
            addCriterion("loginpassword >", value, "loginpassword");
            return (Criteria) this;
        }

        public Criteria andLoginpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("loginpassword >=", value, "loginpassword");
            return (Criteria) this;
        }

        public Criteria andLoginpasswordLessThan(String value) {
            addCriterion("loginpassword <", value, "loginpassword");
            return (Criteria) this;
        }

        public Criteria andLoginpasswordLessThanOrEqualTo(String value) {
            addCriterion("loginpassword <=", value, "loginpassword");
            return (Criteria) this;
        }

        public Criteria andLoginpasswordLike(String value) {
            addCriterion("loginpassword like", value, "loginpassword");
            return (Criteria) this;
        }

        public Criteria andLoginpasswordNotLike(String value) {
            addCriterion("loginpassword not like", value, "loginpassword");
            return (Criteria) this;
        }

        public Criteria andLoginpasswordIn(List<String> values) {
            addCriterion("loginpassword in", values, "loginpassword");
            return (Criteria) this;
        }

        public Criteria andLoginpasswordNotIn(List<String> values) {
            addCriterion("loginpassword not in", values, "loginpassword");
            return (Criteria) this;
        }

        public Criteria andLoginpasswordBetween(String value1, String value2) {
            addCriterion("loginpassword between", value1, value2, "loginpassword");
            return (Criteria) this;
        }

        public Criteria andLoginpasswordNotBetween(String value1, String value2) {
            addCriterion("loginpassword not between", value1, value2, "loginpassword");
            return (Criteria) this;
        }

        public Criteria andShoujihaoIsNull() {
            addCriterion("shoujihao is null");
            return (Criteria) this;
        }

        public Criteria andShoujihaoIsNotNull() {
            addCriterion("shoujihao is not null");
            return (Criteria) this;
        }

        public Criteria andShoujihaoEqualTo(String value) {
            addCriterion("shoujihao =", value, "shoujihao");
            return (Criteria) this;
        }

        public Criteria andShoujihaoNotEqualTo(String value) {
            addCriterion("shoujihao <>", value, "shoujihao");
            return (Criteria) this;
        }

        public Criteria andShoujihaoGreaterThan(String value) {
            addCriterion("shoujihao >", value, "shoujihao");
            return (Criteria) this;
        }

        public Criteria andShoujihaoGreaterThanOrEqualTo(String value) {
            addCriterion("shoujihao >=", value, "shoujihao");
            return (Criteria) this;
        }

        public Criteria andShoujihaoLessThan(String value) {
            addCriterion("shoujihao <", value, "shoujihao");
            return (Criteria) this;
        }

        public Criteria andShoujihaoLessThanOrEqualTo(String value) {
            addCriterion("shoujihao <=", value, "shoujihao");
            return (Criteria) this;
        }

        public Criteria andShoujihaoLike(String value) {
            addCriterion("shoujihao like", value, "shoujihao");
            return (Criteria) this;
        }

        public Criteria andShoujihaoNotLike(String value) {
            addCriterion("shoujihao not like", value, "shoujihao");
            return (Criteria) this;
        }

        public Criteria andShoujihaoIn(List<String> values) {
            addCriterion("shoujihao in", values, "shoujihao");
            return (Criteria) this;
        }

        public Criteria andShoujihaoNotIn(List<String> values) {
            addCriterion("shoujihao not in", values, "shoujihao");
            return (Criteria) this;
        }

        public Criteria andShoujihaoBetween(String value1, String value2) {
            addCriterion("shoujihao between", value1, value2, "shoujihao");
            return (Criteria) this;
        }

        public Criteria andShoujihaoNotBetween(String value1, String value2) {
            addCriterion("shoujihao not between", value1, value2, "shoujihao");
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