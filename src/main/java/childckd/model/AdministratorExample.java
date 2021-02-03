package childckd.model;

import java.util.ArrayList;
import java.util.List;

public class AdministratorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdministratorExample() {
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

        public Criteria andAdministratoridIsNull() {
            addCriterion("administratorid is null");
            return (Criteria) this;
        }

        public Criteria andAdministratoridIsNotNull() {
            addCriterion("administratorid is not null");
            return (Criteria) this;
        }

        public Criteria andAdministratoridEqualTo(String value) {
            addCriterion("administratorid =", value, "administratorid");
            return (Criteria) this;
        }

        public Criteria andAdministratoridNotEqualTo(String value) {
            addCriterion("administratorid <>", value, "administratorid");
            return (Criteria) this;
        }

        public Criteria andAdministratoridGreaterThan(String value) {
            addCriterion("administratorid >", value, "administratorid");
            return (Criteria) this;
        }

        public Criteria andAdministratoridGreaterThanOrEqualTo(String value) {
            addCriterion("administratorid >=", value, "administratorid");
            return (Criteria) this;
        }

        public Criteria andAdministratoridLessThan(String value) {
            addCriterion("administratorid <", value, "administratorid");
            return (Criteria) this;
        }

        public Criteria andAdministratoridLessThanOrEqualTo(String value) {
            addCriterion("administratorid <=", value, "administratorid");
            return (Criteria) this;
        }

        public Criteria andAdministratoridLike(String value) {
            addCriterion("administratorid like", value, "administratorid");
            return (Criteria) this;
        }

        public Criteria andAdministratoridNotLike(String value) {
            addCriterion("administratorid not like", value, "administratorid");
            return (Criteria) this;
        }

        public Criteria andAdministratoridIn(List<String> values) {
            addCriterion("administratorid in", values, "administratorid");
            return (Criteria) this;
        }

        public Criteria andAdministratoridNotIn(List<String> values) {
            addCriterion("administratorid not in", values, "administratorid");
            return (Criteria) this;
        }

        public Criteria andAdministratoridBetween(String value1, String value2) {
            addCriterion("administratorid between", value1, value2, "administratorid");
            return (Criteria) this;
        }

        public Criteria andAdministratoridNotBetween(String value1, String value2) {
            addCriterion("administratorid not between", value1, value2, "administratorid");
            return (Criteria) this;
        }

        public Criteria andZhanghaoIsNull() {
            addCriterion("zhanghao is null");
            return (Criteria) this;
        }

        public Criteria andZhanghaoIsNotNull() {
            addCriterion("zhanghao is not null");
            return (Criteria) this;
        }

        public Criteria andZhanghaoEqualTo(String value) {
            addCriterion("zhanghao =", value, "zhanghao");
            return (Criteria) this;
        }

        public Criteria andZhanghaoNotEqualTo(String value) {
            addCriterion("zhanghao <>", value, "zhanghao");
            return (Criteria) this;
        }

        public Criteria andZhanghaoGreaterThan(String value) {
            addCriterion("zhanghao >", value, "zhanghao");
            return (Criteria) this;
        }

        public Criteria andZhanghaoGreaterThanOrEqualTo(String value) {
            addCriterion("zhanghao >=", value, "zhanghao");
            return (Criteria) this;
        }

        public Criteria andZhanghaoLessThan(String value) {
            addCriterion("zhanghao <", value, "zhanghao");
            return (Criteria) this;
        }

        public Criteria andZhanghaoLessThanOrEqualTo(String value) {
            addCriterion("zhanghao <=", value, "zhanghao");
            return (Criteria) this;
        }

        public Criteria andZhanghaoLike(String value) {
            addCriterion("zhanghao like", value, "zhanghao");
            return (Criteria) this;
        }

        public Criteria andZhanghaoNotLike(String value) {
            addCriterion("zhanghao not like", value, "zhanghao");
            return (Criteria) this;
        }

        public Criteria andZhanghaoIn(List<String> values) {
            addCriterion("zhanghao in", values, "zhanghao");
            return (Criteria) this;
        }

        public Criteria andZhanghaoNotIn(List<String> values) {
            addCriterion("zhanghao not in", values, "zhanghao");
            return (Criteria) this;
        }

        public Criteria andZhanghaoBetween(String value1, String value2) {
            addCriterion("zhanghao between", value1, value2, "zhanghao");
            return (Criteria) this;
        }

        public Criteria andZhanghaoNotBetween(String value1, String value2) {
            addCriterion("zhanghao not between", value1, value2, "zhanghao");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNull() {
            addCriterion("roleid is null");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNotNull() {
            addCriterion("roleid is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidEqualTo(String value) {
            addCriterion("roleid =", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotEqualTo(String value) {
            addCriterion("roleid <>", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThan(String value) {
            addCriterion("roleid >", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThanOrEqualTo(String value) {
            addCriterion("roleid >=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThan(String value) {
            addCriterion("roleid <", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThanOrEqualTo(String value) {
            addCriterion("roleid <=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLike(String value) {
            addCriterion("roleid like", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotLike(String value) {
            addCriterion("roleid not like", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidIn(List<String> values) {
            addCriterion("roleid in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotIn(List<String> values) {
            addCriterion("roleid not in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidBetween(String value1, String value2) {
            addCriterion("roleid between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotBetween(String value1, String value2) {
            addCriterion("roleid not between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRolenameIsNull() {
            addCriterion("rolename is null");
            return (Criteria) this;
        }

        public Criteria andRolenameIsNotNull() {
            addCriterion("rolename is not null");
            return (Criteria) this;
        }

        public Criteria andRolenameEqualTo(String value) {
            addCriterion("rolename =", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotEqualTo(String value) {
            addCriterion("rolename <>", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameGreaterThan(String value) {
            addCriterion("rolename >", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameGreaterThanOrEqualTo(String value) {
            addCriterion("rolename >=", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameLessThan(String value) {
            addCriterion("rolename <", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameLessThanOrEqualTo(String value) {
            addCriterion("rolename <=", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameLike(String value) {
            addCriterion("rolename like", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotLike(String value) {
            addCriterion("rolename not like", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameIn(List<String> values) {
            addCriterion("rolename in", values, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotIn(List<String> values) {
            addCriterion("rolename not in", values, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameBetween(String value1, String value2) {
            addCriterion("rolename between", value1, value2, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotBetween(String value1, String value2) {
            addCriterion("rolename not between", value1, value2, "rolename");
            return (Criteria) this;
        }

        public Criteria andBeizhuIsNull() {
            addCriterion("beizhu is null");
            return (Criteria) this;
        }

        public Criteria andBeizhuIsNotNull() {
            addCriterion("beizhu is not null");
            return (Criteria) this;
        }

        public Criteria andBeizhuEqualTo(String value) {
            addCriterion("beizhu =", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotEqualTo(String value) {
            addCriterion("beizhu <>", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuGreaterThan(String value) {
            addCriterion("beizhu >", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuGreaterThanOrEqualTo(String value) {
            addCriterion("beizhu >=", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLessThan(String value) {
            addCriterion("beizhu <", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLessThanOrEqualTo(String value) {
            addCriterion("beizhu <=", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLike(String value) {
            addCriterion("beizhu like", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotLike(String value) {
            addCriterion("beizhu not like", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuIn(List<String> values) {
            addCriterion("beizhu in", values, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotIn(List<String> values) {
            addCriterion("beizhu not in", values, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuBetween(String value1, String value2) {
            addCriterion("beizhu between", value1, value2, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotBetween(String value1, String value2) {
            addCriterion("beizhu not between", value1, value2, "beizhu");
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