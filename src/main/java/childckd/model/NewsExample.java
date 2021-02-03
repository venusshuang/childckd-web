package childckd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewsExample() {
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

        public Criteria andNewsidIsNull() {
            addCriterion("newsid is null");
            return (Criteria) this;
        }

        public Criteria andNewsidIsNotNull() {
            addCriterion("newsid is not null");
            return (Criteria) this;
        }

        public Criteria andNewsidEqualTo(String value) {
            addCriterion("newsid =", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotEqualTo(String value) {
            addCriterion("newsid <>", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidGreaterThan(String value) {
            addCriterion("newsid >", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidGreaterThanOrEqualTo(String value) {
            addCriterion("newsid >=", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidLessThan(String value) {
            addCriterion("newsid <", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidLessThanOrEqualTo(String value) {
            addCriterion("newsid <=", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidLike(String value) {
            addCriterion("newsid like", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotLike(String value) {
            addCriterion("newsid not like", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidIn(List<String> values) {
            addCriterion("newsid in", values, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotIn(List<String> values) {
            addCriterion("newsid not in", values, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidBetween(String value1, String value2) {
            addCriterion("newsid between", value1, value2, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotBetween(String value1, String value2) {
            addCriterion("newsid not between", value1, value2, "newsid");
            return (Criteria) this;
        }

        public Criteria andFajianrenIsNull() {
            addCriterion("fajianren is null");
            return (Criteria) this;
        }

        public Criteria andFajianrenIsNotNull() {
            addCriterion("fajianren is not null");
            return (Criteria) this;
        }

        public Criteria andFajianrenEqualTo(String value) {
            addCriterion("fajianren =", value, "fajianren");
            return (Criteria) this;
        }

        public Criteria andFajianrenNotEqualTo(String value) {
            addCriterion("fajianren <>", value, "fajianren");
            return (Criteria) this;
        }

        public Criteria andFajianrenGreaterThan(String value) {
            addCriterion("fajianren >", value, "fajianren");
            return (Criteria) this;
        }

        public Criteria andFajianrenGreaterThanOrEqualTo(String value) {
            addCriterion("fajianren >=", value, "fajianren");
            return (Criteria) this;
        }

        public Criteria andFajianrenLessThan(String value) {
            addCriterion("fajianren <", value, "fajianren");
            return (Criteria) this;
        }

        public Criteria andFajianrenLessThanOrEqualTo(String value) {
            addCriterion("fajianren <=", value, "fajianren");
            return (Criteria) this;
        }

        public Criteria andFajianrenLike(String value) {
            addCriterion("fajianren like", value, "fajianren");
            return (Criteria) this;
        }

        public Criteria andFajianrenNotLike(String value) {
            addCriterion("fajianren not like", value, "fajianren");
            return (Criteria) this;
        }

        public Criteria andFajianrenIn(List<String> values) {
            addCriterion("fajianren in", values, "fajianren");
            return (Criteria) this;
        }

        public Criteria andFajianrenNotIn(List<String> values) {
            addCriterion("fajianren not in", values, "fajianren");
            return (Criteria) this;
        }

        public Criteria andFajianrenBetween(String value1, String value2) {
            addCriterion("fajianren between", value1, value2, "fajianren");
            return (Criteria) this;
        }

        public Criteria andFajianrenNotBetween(String value1, String value2) {
            addCriterion("fajianren not between", value1, value2, "fajianren");
            return (Criteria) this;
        }

        public Criteria andFajianrennameIsNull() {
            addCriterion("fajianrenname is null");
            return (Criteria) this;
        }

        public Criteria andFajianrennameIsNotNull() {
            addCriterion("fajianrenname is not null");
            return (Criteria) this;
        }

        public Criteria andFajianrennameEqualTo(String value) {
            addCriterion("fajianrenname =", value, "fajianrenname");
            return (Criteria) this;
        }

        public Criteria andFajianrennameNotEqualTo(String value) {
            addCriterion("fajianrenname <>", value, "fajianrenname");
            return (Criteria) this;
        }

        public Criteria andFajianrennameGreaterThan(String value) {
            addCriterion("fajianrenname >", value, "fajianrenname");
            return (Criteria) this;
        }

        public Criteria andFajianrennameGreaterThanOrEqualTo(String value) {
            addCriterion("fajianrenname >=", value, "fajianrenname");
            return (Criteria) this;
        }

        public Criteria andFajianrennameLessThan(String value) {
            addCriterion("fajianrenname <", value, "fajianrenname");
            return (Criteria) this;
        }

        public Criteria andFajianrennameLessThanOrEqualTo(String value) {
            addCriterion("fajianrenname <=", value, "fajianrenname");
            return (Criteria) this;
        }

        public Criteria andFajianrennameLike(String value) {
            addCriterion("fajianrenname like", value, "fajianrenname");
            return (Criteria) this;
        }

        public Criteria andFajianrennameNotLike(String value) {
            addCriterion("fajianrenname not like", value, "fajianrenname");
            return (Criteria) this;
        }

        public Criteria andFajianrennameIn(List<String> values) {
            addCriterion("fajianrenname in", values, "fajianrenname");
            return (Criteria) this;
        }

        public Criteria andFajianrennameNotIn(List<String> values) {
            addCriterion("fajianrenname not in", values, "fajianrenname");
            return (Criteria) this;
        }

        public Criteria andFajianrennameBetween(String value1, String value2) {
            addCriterion("fajianrenname between", value1, value2, "fajianrenname");
            return (Criteria) this;
        }

        public Criteria andFajianrennameNotBetween(String value1, String value2) {
            addCriterion("fajianrenname not between", value1, value2, "fajianrenname");
            return (Criteria) this;
        }

        public Criteria andShoujianrenIsNull() {
            addCriterion("shoujianren is null");
            return (Criteria) this;
        }

        public Criteria andShoujianrenIsNotNull() {
            addCriterion("shoujianren is not null");
            return (Criteria) this;
        }

        public Criteria andShoujianrenEqualTo(String value) {
            addCriterion("shoujianren =", value, "shoujianren");
            return (Criteria) this;
        }

        public Criteria andShoujianrenNotEqualTo(String value) {
            addCriterion("shoujianren <>", value, "shoujianren");
            return (Criteria) this;
        }

        public Criteria andShoujianrenGreaterThan(String value) {
            addCriterion("shoujianren >", value, "shoujianren");
            return (Criteria) this;
        }

        public Criteria andShoujianrenGreaterThanOrEqualTo(String value) {
            addCriterion("shoujianren >=", value, "shoujianren");
            return (Criteria) this;
        }

        public Criteria andShoujianrenLessThan(String value) {
            addCriterion("shoujianren <", value, "shoujianren");
            return (Criteria) this;
        }

        public Criteria andShoujianrenLessThanOrEqualTo(String value) {
            addCriterion("shoujianren <=", value, "shoujianren");
            return (Criteria) this;
        }

        public Criteria andShoujianrenLike(String value) {
            addCriterion("shoujianren like", value, "shoujianren");
            return (Criteria) this;
        }

        public Criteria andShoujianrenNotLike(String value) {
            addCriterion("shoujianren not like", value, "shoujianren");
            return (Criteria) this;
        }

        public Criteria andShoujianrenIn(List<String> values) {
            addCriterion("shoujianren in", values, "shoujianren");
            return (Criteria) this;
        }

        public Criteria andShoujianrenNotIn(List<String> values) {
            addCriterion("shoujianren not in", values, "shoujianren");
            return (Criteria) this;
        }

        public Criteria andShoujianrenBetween(String value1, String value2) {
            addCriterion("shoujianren between", value1, value2, "shoujianren");
            return (Criteria) this;
        }

        public Criteria andShoujianrenNotBetween(String value1, String value2) {
            addCriterion("shoujianren not between", value1, value2, "shoujianren");
            return (Criteria) this;
        }

        public Criteria andShoujianrennameIsNull() {
            addCriterion("shoujianrenname is null");
            return (Criteria) this;
        }

        public Criteria andShoujianrennameIsNotNull() {
            addCriterion("shoujianrenname is not null");
            return (Criteria) this;
        }

        public Criteria andShoujianrennameEqualTo(String value) {
            addCriterion("shoujianrenname =", value, "shoujianrenname");
            return (Criteria) this;
        }

        public Criteria andShoujianrennameNotEqualTo(String value) {
            addCriterion("shoujianrenname <>", value, "shoujianrenname");
            return (Criteria) this;
        }

        public Criteria andShoujianrennameGreaterThan(String value) {
            addCriterion("shoujianrenname >", value, "shoujianrenname");
            return (Criteria) this;
        }

        public Criteria andShoujianrennameGreaterThanOrEqualTo(String value) {
            addCriterion("shoujianrenname >=", value, "shoujianrenname");
            return (Criteria) this;
        }

        public Criteria andShoujianrennameLessThan(String value) {
            addCriterion("shoujianrenname <", value, "shoujianrenname");
            return (Criteria) this;
        }

        public Criteria andShoujianrennameLessThanOrEqualTo(String value) {
            addCriterion("shoujianrenname <=", value, "shoujianrenname");
            return (Criteria) this;
        }

        public Criteria andShoujianrennameLike(String value) {
            addCriterion("shoujianrenname like", value, "shoujianrenname");
            return (Criteria) this;
        }

        public Criteria andShoujianrennameNotLike(String value) {
            addCriterion("shoujianrenname not like", value, "shoujianrenname");
            return (Criteria) this;
        }

        public Criteria andShoujianrennameIn(List<String> values) {
            addCriterion("shoujianrenname in", values, "shoujianrenname");
            return (Criteria) this;
        }

        public Criteria andShoujianrennameNotIn(List<String> values) {
            addCriterion("shoujianrenname not in", values, "shoujianrenname");
            return (Criteria) this;
        }

        public Criteria andShoujianrennameBetween(String value1, String value2) {
            addCriterion("shoujianrenname between", value1, value2, "shoujianrenname");
            return (Criteria) this;
        }

        public Criteria andShoujianrennameNotBetween(String value1, String value2) {
            addCriterion("shoujianrenname not between", value1, value2, "shoujianrenname");
            return (Criteria) this;
        }

        public Criteria andNeirongIsNull() {
            addCriterion("neirong is null");
            return (Criteria) this;
        }

        public Criteria andNeirongIsNotNull() {
            addCriterion("neirong is not null");
            return (Criteria) this;
        }

        public Criteria andNeirongEqualTo(String value) {
            addCriterion("neirong =", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotEqualTo(String value) {
            addCriterion("neirong <>", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongGreaterThan(String value) {
            addCriterion("neirong >", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongGreaterThanOrEqualTo(String value) {
            addCriterion("neirong >=", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongLessThan(String value) {
            addCriterion("neirong <", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongLessThanOrEqualTo(String value) {
            addCriterion("neirong <=", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongLike(String value) {
            addCriterion("neirong like", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotLike(String value) {
            addCriterion("neirong not like", value, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongIn(List<String> values) {
            addCriterion("neirong in", values, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotIn(List<String> values) {
            addCriterion("neirong not in", values, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongBetween(String value1, String value2) {
            addCriterion("neirong between", value1, value2, "neirong");
            return (Criteria) this;
        }

        public Criteria andNeirongNotBetween(String value1, String value2) {
            addCriterion("neirong not between", value1, value2, "neirong");
            return (Criteria) this;
        }

        public Criteria andNewstypeIsNull() {
            addCriterion("newstype is null");
            return (Criteria) this;
        }

        public Criteria andNewstypeIsNotNull() {
            addCriterion("newstype is not null");
            return (Criteria) this;
        }

        public Criteria andNewstypeEqualTo(Integer value) {
            addCriterion("newstype =", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeNotEqualTo(Integer value) {
            addCriterion("newstype <>", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeGreaterThan(Integer value) {
            addCriterion("newstype >", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("newstype >=", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeLessThan(Integer value) {
            addCriterion("newstype <", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeLessThanOrEqualTo(Integer value) {
            addCriterion("newstype <=", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeIn(List<Integer> values) {
            addCriterion("newstype in", values, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeNotIn(List<Integer> values) {
            addCriterion("newstype not in", values, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeBetween(Integer value1, Integer value2) {
            addCriterion("newstype between", value1, value2, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeNotBetween(Integer value1, Integer value2) {
            addCriterion("newstype not between", value1, value2, "newstype");
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

        public Criteria andOwneridIsNull() {
            addCriterion("ownerid is null");
            return (Criteria) this;
        }

        public Criteria andOwneridIsNotNull() {
            addCriterion("ownerid is not null");
            return (Criteria) this;
        }

        public Criteria andOwneridEqualTo(String value) {
            addCriterion("ownerid =", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotEqualTo(String value) {
            addCriterion("ownerid <>", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThan(String value) {
            addCriterion("ownerid >", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThanOrEqualTo(String value) {
            addCriterion("ownerid >=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThan(String value) {
            addCriterion("ownerid <", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThanOrEqualTo(String value) {
            addCriterion("ownerid <=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLike(String value) {
            addCriterion("ownerid like", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotLike(String value) {
            addCriterion("ownerid not like", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridIn(List<String> values) {
            addCriterion("ownerid in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotIn(List<String> values) {
            addCriterion("ownerid not in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridBetween(String value1, String value2) {
            addCriterion("ownerid between", value1, value2, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotBetween(String value1, String value2) {
            addCriterion("ownerid not between", value1, value2, "ownerid");
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