package childckd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminPermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminPermissionExample() {
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

        public Criteria andApidIsNull() {
            addCriterion("apid is null");
            return (Criteria) this;
        }

        public Criteria andApidIsNotNull() {
            addCriterion("apid is not null");
            return (Criteria) this;
        }

        public Criteria andApidEqualTo(String value) {
            addCriterion("apid =", value, "apid");
            return (Criteria) this;
        }

        public Criteria andApidNotEqualTo(String value) {
            addCriterion("apid <>", value, "apid");
            return (Criteria) this;
        }

        public Criteria andApidGreaterThan(String value) {
            addCriterion("apid >", value, "apid");
            return (Criteria) this;
        }

        public Criteria andApidGreaterThanOrEqualTo(String value) {
            addCriterion("apid >=", value, "apid");
            return (Criteria) this;
        }

        public Criteria andApidLessThan(String value) {
            addCriterion("apid <", value, "apid");
            return (Criteria) this;
        }

        public Criteria andApidLessThanOrEqualTo(String value) {
            addCriterion("apid <=", value, "apid");
            return (Criteria) this;
        }

        public Criteria andApidLike(String value) {
            addCriterion("apid like", value, "apid");
            return (Criteria) this;
        }

        public Criteria andApidNotLike(String value) {
            addCriterion("apid not like", value, "apid");
            return (Criteria) this;
        }

        public Criteria andApidIn(List<String> values) {
            addCriterion("apid in", values, "apid");
            return (Criteria) this;
        }

        public Criteria andApidNotIn(List<String> values) {
            addCriterion("apid not in", values, "apid");
            return (Criteria) this;
        }

        public Criteria andApidBetween(String value1, String value2) {
            addCriterion("apid between", value1, value2, "apid");
            return (Criteria) this;
        }

        public Criteria andApidNotBetween(String value1, String value2) {
            addCriterion("apid not between", value1, value2, "apid");
            return (Criteria) this;
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

        public Criteria andPermissionidIsNull() {
            addCriterion("permissionid is null");
            return (Criteria) this;
        }

        public Criteria andPermissionidIsNotNull() {
            addCriterion("permissionid is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionidEqualTo(String value) {
            addCriterion("permissionid =", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidNotEqualTo(String value) {
            addCriterion("permissionid <>", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidGreaterThan(String value) {
            addCriterion("permissionid >", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidGreaterThanOrEqualTo(String value) {
            addCriterion("permissionid >=", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidLessThan(String value) {
            addCriterion("permissionid <", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidLessThanOrEqualTo(String value) {
            addCriterion("permissionid <=", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidLike(String value) {
            addCriterion("permissionid like", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidNotLike(String value) {
            addCriterion("permissionid not like", value, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidIn(List<String> values) {
            addCriterion("permissionid in", values, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidNotIn(List<String> values) {
            addCriterion("permissionid not in", values, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidBetween(String value1, String value2) {
            addCriterion("permissionid between", value1, value2, "permissionid");
            return (Criteria) this;
        }

        public Criteria andPermissionidNotBetween(String value1, String value2) {
            addCriterion("permissionid not between", value1, value2, "permissionid");
            return (Criteria) this;
        }

        public Criteria andChuangjianshijianIsNull() {
            addCriterion("chuangjianshijian is null");
            return (Criteria) this;
        }

        public Criteria andChuangjianshijianIsNotNull() {
            addCriterion("chuangjianshijian is not null");
            return (Criteria) this;
        }

        public Criteria andChuangjianshijianEqualTo(Date value) {
            addCriterion("chuangjianshijian =", value, "chuangjianshijian");
            return (Criteria) this;
        }

        public Criteria andChuangjianshijianNotEqualTo(Date value) {
            addCriterion("chuangjianshijian <>", value, "chuangjianshijian");
            return (Criteria) this;
        }

        public Criteria andChuangjianshijianGreaterThan(Date value) {
            addCriterion("chuangjianshijian >", value, "chuangjianshijian");
            return (Criteria) this;
        }

        public Criteria andChuangjianshijianGreaterThanOrEqualTo(Date value) {
            addCriterion("chuangjianshijian >=", value, "chuangjianshijian");
            return (Criteria) this;
        }

        public Criteria andChuangjianshijianLessThan(Date value) {
            addCriterion("chuangjianshijian <", value, "chuangjianshijian");
            return (Criteria) this;
        }

        public Criteria andChuangjianshijianLessThanOrEqualTo(Date value) {
            addCriterion("chuangjianshijian <=", value, "chuangjianshijian");
            return (Criteria) this;
        }

        public Criteria andChuangjianshijianIn(List<Date> values) {
            addCriterion("chuangjianshijian in", values, "chuangjianshijian");
            return (Criteria) this;
        }

        public Criteria andChuangjianshijianNotIn(List<Date> values) {
            addCriterion("chuangjianshijian not in", values, "chuangjianshijian");
            return (Criteria) this;
        }

        public Criteria andChuangjianshijianBetween(Date value1, Date value2) {
            addCriterion("chuangjianshijian between", value1, value2, "chuangjianshijian");
            return (Criteria) this;
        }

        public Criteria andChuangjianshijianNotBetween(Date value1, Date value2) {
            addCriterion("chuangjianshijian not between", value1, value2, "chuangjianshijian");
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