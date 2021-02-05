package childckd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleExample() {
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

        public Criteria andDisplaynameIsNull() {
            addCriterion("displayname is null");
            return (Criteria) this;
        }

        public Criteria andDisplaynameIsNotNull() {
            addCriterion("displayname is not null");
            return (Criteria) this;
        }

        public Criteria andDisplaynameEqualTo(String value) {
            addCriterion("displayname =", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotEqualTo(String value) {
            addCriterion("displayname <>", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameGreaterThan(String value) {
            addCriterion("displayname >", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameGreaterThanOrEqualTo(String value) {
            addCriterion("displayname >=", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameLessThan(String value) {
            addCriterion("displayname <", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameLessThanOrEqualTo(String value) {
            addCriterion("displayname <=", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameLike(String value) {
            addCriterion("displayname like", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotLike(String value) {
            addCriterion("displayname not like", value, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameIn(List<String> values) {
            addCriterion("displayname in", values, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotIn(List<String> values) {
            addCriterion("displayname not in", values, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameBetween(String value1, String value2) {
            addCriterion("displayname between", value1, value2, "displayname");
            return (Criteria) this;
        }

        public Criteria andDisplaynameNotBetween(String value1, String value2) {
            addCriterion("displayname not between", value1, value2, "displayname");
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

        public Criteria andChuangjianrenidIsNull() {
            addCriterion("chuangjianrenid is null");
            return (Criteria) this;
        }

        public Criteria andChuangjianrenidIsNotNull() {
            addCriterion("chuangjianrenid is not null");
            return (Criteria) this;
        }

        public Criteria andChuangjianrenidEqualTo(String value) {
            addCriterion("chuangjianrenid =", value, "chuangjianrenid");
            return (Criteria) this;
        }

        public Criteria andChuangjianrenidNotEqualTo(String value) {
            addCriterion("chuangjianrenid <>", value, "chuangjianrenid");
            return (Criteria) this;
        }

        public Criteria andChuangjianrenidGreaterThan(String value) {
            addCriterion("chuangjianrenid >", value, "chuangjianrenid");
            return (Criteria) this;
        }

        public Criteria andChuangjianrenidGreaterThanOrEqualTo(String value) {
            addCriterion("chuangjianrenid >=", value, "chuangjianrenid");
            return (Criteria) this;
        }

        public Criteria andChuangjianrenidLessThan(String value) {
            addCriterion("chuangjianrenid <", value, "chuangjianrenid");
            return (Criteria) this;
        }

        public Criteria andChuangjianrenidLessThanOrEqualTo(String value) {
            addCriterion("chuangjianrenid <=", value, "chuangjianrenid");
            return (Criteria) this;
        }

        public Criteria andChuangjianrenidLike(String value) {
            addCriterion("chuangjianrenid like", value, "chuangjianrenid");
            return (Criteria) this;
        }

        public Criteria andChuangjianrenidNotLike(String value) {
            addCriterion("chuangjianrenid not like", value, "chuangjianrenid");
            return (Criteria) this;
        }

        public Criteria andChuangjianrenidIn(List<String> values) {
            addCriterion("chuangjianrenid in", values, "chuangjianrenid");
            return (Criteria) this;
        }

        public Criteria andChuangjianrenidNotIn(List<String> values) {
            addCriterion("chuangjianrenid not in", values, "chuangjianrenid");
            return (Criteria) this;
        }

        public Criteria andChuangjianrenidBetween(String value1, String value2) {
            addCriterion("chuangjianrenid between", value1, value2, "chuangjianrenid");
            return (Criteria) this;
        }

        public Criteria andChuangjianrenidNotBetween(String value1, String value2) {
            addCriterion("chuangjianrenid not between", value1, value2, "chuangjianrenid");
            return (Criteria) this;
        }

        public Criteria andParentroleidIsNull() {
            addCriterion("parentroleid is null");
            return (Criteria) this;
        }

        public Criteria andParentroleidIsNotNull() {
            addCriterion("parentroleid is not null");
            return (Criteria) this;
        }

        public Criteria andParentroleidEqualTo(String value) {
            addCriterion("parentroleid =", value, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidNotEqualTo(String value) {
            addCriterion("parentroleid <>", value, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidGreaterThan(String value) {
            addCriterion("parentroleid >", value, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidGreaterThanOrEqualTo(String value) {
            addCriterion("parentroleid >=", value, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidLessThan(String value) {
            addCriterion("parentroleid <", value, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidLessThanOrEqualTo(String value) {
            addCriterion("parentroleid <=", value, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidLike(String value) {
            addCriterion("parentroleid like", value, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidNotLike(String value) {
            addCriterion("parentroleid not like", value, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidIn(List<String> values) {
            addCriterion("parentroleid in", values, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidNotIn(List<String> values) {
            addCriterion("parentroleid not in", values, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidBetween(String value1, String value2) {
            addCriterion("parentroleid between", value1, value2, "parentroleid");
            return (Criteria) this;
        }

        public Criteria andParentroleidNotBetween(String value1, String value2) {
            addCriterion("parentroleid not between", value1, value2, "parentroleid");
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