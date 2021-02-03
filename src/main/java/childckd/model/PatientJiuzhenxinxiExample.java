package childckd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientJiuzhenxinxiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PatientJiuzhenxinxiExample() {
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

        public Criteria andJiuzhenxinxiidIsNull() {
            addCriterion("jiuzhenxinxiid is null");
            return (Criteria) this;
        }

        public Criteria andJiuzhenxinxiidIsNotNull() {
            addCriterion("jiuzhenxinxiid is not null");
            return (Criteria) this;
        }

        public Criteria andJiuzhenxinxiidEqualTo(String value) {
            addCriterion("jiuzhenxinxiid =", value, "jiuzhenxinxiid");
            return (Criteria) this;
        }

        public Criteria andJiuzhenxinxiidNotEqualTo(String value) {
            addCriterion("jiuzhenxinxiid <>", value, "jiuzhenxinxiid");
            return (Criteria) this;
        }

        public Criteria andJiuzhenxinxiidGreaterThan(String value) {
            addCriterion("jiuzhenxinxiid >", value, "jiuzhenxinxiid");
            return (Criteria) this;
        }

        public Criteria andJiuzhenxinxiidGreaterThanOrEqualTo(String value) {
            addCriterion("jiuzhenxinxiid >=", value, "jiuzhenxinxiid");
            return (Criteria) this;
        }

        public Criteria andJiuzhenxinxiidLessThan(String value) {
            addCriterion("jiuzhenxinxiid <", value, "jiuzhenxinxiid");
            return (Criteria) this;
        }

        public Criteria andJiuzhenxinxiidLessThanOrEqualTo(String value) {
            addCriterion("jiuzhenxinxiid <=", value, "jiuzhenxinxiid");
            return (Criteria) this;
        }

        public Criteria andJiuzhenxinxiidLike(String value) {
            addCriterion("jiuzhenxinxiid like", value, "jiuzhenxinxiid");
            return (Criteria) this;
        }

        public Criteria andJiuzhenxinxiidNotLike(String value) {
            addCriterion("jiuzhenxinxiid not like", value, "jiuzhenxinxiid");
            return (Criteria) this;
        }

        public Criteria andJiuzhenxinxiidIn(List<String> values) {
            addCriterion("jiuzhenxinxiid in", values, "jiuzhenxinxiid");
            return (Criteria) this;
        }

        public Criteria andJiuzhenxinxiidNotIn(List<String> values) {
            addCriterion("jiuzhenxinxiid not in", values, "jiuzhenxinxiid");
            return (Criteria) this;
        }

        public Criteria andJiuzhenxinxiidBetween(String value1, String value2) {
            addCriterion("jiuzhenxinxiid between", value1, value2, "jiuzhenxinxiid");
            return (Criteria) this;
        }

        public Criteria andJiuzhenxinxiidNotBetween(String value1, String value2) {
            addCriterion("jiuzhenxinxiid not between", value1, value2, "jiuzhenxinxiid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
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

        public Criteria andShenfenzhenghaomaIsNull() {
            addCriterion("shenfenzhenghaoma is null");
            return (Criteria) this;
        }

        public Criteria andShenfenzhenghaomaIsNotNull() {
            addCriterion("shenfenzhenghaoma is not null");
            return (Criteria) this;
        }

        public Criteria andShenfenzhenghaomaEqualTo(String value) {
            addCriterion("shenfenzhenghaoma =", value, "shenfenzhenghaoma");
            return (Criteria) this;
        }

        public Criteria andShenfenzhenghaomaNotEqualTo(String value) {
            addCriterion("shenfenzhenghaoma <>", value, "shenfenzhenghaoma");
            return (Criteria) this;
        }

        public Criteria andShenfenzhenghaomaGreaterThan(String value) {
            addCriterion("shenfenzhenghaoma >", value, "shenfenzhenghaoma");
            return (Criteria) this;
        }

        public Criteria andShenfenzhenghaomaGreaterThanOrEqualTo(String value) {
            addCriterion("shenfenzhenghaoma >=", value, "shenfenzhenghaoma");
            return (Criteria) this;
        }

        public Criteria andShenfenzhenghaomaLessThan(String value) {
            addCriterion("shenfenzhenghaoma <", value, "shenfenzhenghaoma");
            return (Criteria) this;
        }

        public Criteria andShenfenzhenghaomaLessThanOrEqualTo(String value) {
            addCriterion("shenfenzhenghaoma <=", value, "shenfenzhenghaoma");
            return (Criteria) this;
        }

        public Criteria andShenfenzhenghaomaLike(String value) {
            addCriterion("shenfenzhenghaoma like", value, "shenfenzhenghaoma");
            return (Criteria) this;
        }

        public Criteria andShenfenzhenghaomaNotLike(String value) {
            addCriterion("shenfenzhenghaoma not like", value, "shenfenzhenghaoma");
            return (Criteria) this;
        }

        public Criteria andShenfenzhenghaomaIn(List<String> values) {
            addCriterion("shenfenzhenghaoma in", values, "shenfenzhenghaoma");
            return (Criteria) this;
        }

        public Criteria andShenfenzhenghaomaNotIn(List<String> values) {
            addCriterion("shenfenzhenghaoma not in", values, "shenfenzhenghaoma");
            return (Criteria) this;
        }

        public Criteria andShenfenzhenghaomaBetween(String value1, String value2) {
            addCriterion("shenfenzhenghaoma between", value1, value2, "shenfenzhenghaoma");
            return (Criteria) this;
        }

        public Criteria andShenfenzhenghaomaNotBetween(String value1, String value2) {
            addCriterion("shenfenzhenghaoma not between", value1, value2, "shenfenzhenghaoma");
            return (Criteria) this;
        }

        public Criteria andXingbieIsNull() {
            addCriterion("xingbie is null");
            return (Criteria) this;
        }

        public Criteria andXingbieIsNotNull() {
            addCriterion("xingbie is not null");
            return (Criteria) this;
        }

        public Criteria andXingbieEqualTo(String value) {
            addCriterion("xingbie =", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotEqualTo(String value) {
            addCriterion("xingbie <>", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieGreaterThan(String value) {
            addCriterion("xingbie >", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieGreaterThanOrEqualTo(String value) {
            addCriterion("xingbie >=", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieLessThan(String value) {
            addCriterion("xingbie <", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieLessThanOrEqualTo(String value) {
            addCriterion("xingbie <=", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieLike(String value) {
            addCriterion("xingbie like", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotLike(String value) {
            addCriterion("xingbie not like", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieIn(List<String> values) {
            addCriterion("xingbie in", values, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotIn(List<String> values) {
            addCriterion("xingbie not in", values, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieBetween(String value1, String value2) {
            addCriterion("xingbie between", value1, value2, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotBetween(String value1, String value2) {
            addCriterion("xingbie not between", value1, value2, "xingbie");
            return (Criteria) this;
        }

        public Criteria andZhuyaozhengzhuangIsNull() {
            addCriterion("zhuyaozhengzhuang is null");
            return (Criteria) this;
        }

        public Criteria andZhuyaozhengzhuangIsNotNull() {
            addCriterion("zhuyaozhengzhuang is not null");
            return (Criteria) this;
        }

        public Criteria andZhuyaozhengzhuangEqualTo(String value) {
            addCriterion("zhuyaozhengzhuang =", value, "zhuyaozhengzhuang");
            return (Criteria) this;
        }

        public Criteria andZhuyaozhengzhuangNotEqualTo(String value) {
            addCriterion("zhuyaozhengzhuang <>", value, "zhuyaozhengzhuang");
            return (Criteria) this;
        }

        public Criteria andZhuyaozhengzhuangGreaterThan(String value) {
            addCriterion("zhuyaozhengzhuang >", value, "zhuyaozhengzhuang");
            return (Criteria) this;
        }

        public Criteria andZhuyaozhengzhuangGreaterThanOrEqualTo(String value) {
            addCriterion("zhuyaozhengzhuang >=", value, "zhuyaozhengzhuang");
            return (Criteria) this;
        }

        public Criteria andZhuyaozhengzhuangLessThan(String value) {
            addCriterion("zhuyaozhengzhuang <", value, "zhuyaozhengzhuang");
            return (Criteria) this;
        }

        public Criteria andZhuyaozhengzhuangLessThanOrEqualTo(String value) {
            addCriterion("zhuyaozhengzhuang <=", value, "zhuyaozhengzhuang");
            return (Criteria) this;
        }

        public Criteria andZhuyaozhengzhuangLike(String value) {
            addCriterion("zhuyaozhengzhuang like", value, "zhuyaozhengzhuang");
            return (Criteria) this;
        }

        public Criteria andZhuyaozhengzhuangNotLike(String value) {
            addCriterion("zhuyaozhengzhuang not like", value, "zhuyaozhengzhuang");
            return (Criteria) this;
        }

        public Criteria andZhuyaozhengzhuangIn(List<String> values) {
            addCriterion("zhuyaozhengzhuang in", values, "zhuyaozhengzhuang");
            return (Criteria) this;
        }

        public Criteria andZhuyaozhengzhuangNotIn(List<String> values) {
            addCriterion("zhuyaozhengzhuang not in", values, "zhuyaozhengzhuang");
            return (Criteria) this;
        }

        public Criteria andZhuyaozhengzhuangBetween(String value1, String value2) {
            addCriterion("zhuyaozhengzhuang between", value1, value2, "zhuyaozhengzhuang");
            return (Criteria) this;
        }

        public Criteria andZhuyaozhengzhuangNotBetween(String value1, String value2) {
            addCriterion("zhuyaozhengzhuang not between", value1, value2, "zhuyaozhengzhuang");
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

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andLianxidizhiIsNull() {
            addCriterion("lianxidizhi is null");
            return (Criteria) this;
        }

        public Criteria andLianxidizhiIsNotNull() {
            addCriterion("lianxidizhi is not null");
            return (Criteria) this;
        }

        public Criteria andLianxidizhiEqualTo(String value) {
            addCriterion("lianxidizhi =", value, "lianxidizhi");
            return (Criteria) this;
        }

        public Criteria andLianxidizhiNotEqualTo(String value) {
            addCriterion("lianxidizhi <>", value, "lianxidizhi");
            return (Criteria) this;
        }

        public Criteria andLianxidizhiGreaterThan(String value) {
            addCriterion("lianxidizhi >", value, "lianxidizhi");
            return (Criteria) this;
        }

        public Criteria andLianxidizhiGreaterThanOrEqualTo(String value) {
            addCriterion("lianxidizhi >=", value, "lianxidizhi");
            return (Criteria) this;
        }

        public Criteria andLianxidizhiLessThan(String value) {
            addCriterion("lianxidizhi <", value, "lianxidizhi");
            return (Criteria) this;
        }

        public Criteria andLianxidizhiLessThanOrEqualTo(String value) {
            addCriterion("lianxidizhi <=", value, "lianxidizhi");
            return (Criteria) this;
        }

        public Criteria andLianxidizhiLike(String value) {
            addCriterion("lianxidizhi like", value, "lianxidizhi");
            return (Criteria) this;
        }

        public Criteria andLianxidizhiNotLike(String value) {
            addCriterion("lianxidizhi not like", value, "lianxidizhi");
            return (Criteria) this;
        }

        public Criteria andLianxidizhiIn(List<String> values) {
            addCriterion("lianxidizhi in", values, "lianxidizhi");
            return (Criteria) this;
        }

        public Criteria andLianxidizhiNotIn(List<String> values) {
            addCriterion("lianxidizhi not in", values, "lianxidizhi");
            return (Criteria) this;
        }

        public Criteria andLianxidizhiBetween(String value1, String value2) {
            addCriterion("lianxidizhi between", value1, value2, "lianxidizhi");
            return (Criteria) this;
        }

        public Criteria andLianxidizhiNotBetween(String value1, String value2) {
            addCriterion("lianxidizhi not between", value1, value2, "lianxidizhi");
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

        public Criteria andBingzhongIsNull() {
            addCriterion("bingzhong is null");
            return (Criteria) this;
        }

        public Criteria andBingzhongIsNotNull() {
            addCriterion("bingzhong is not null");
            return (Criteria) this;
        }

        public Criteria andBingzhongEqualTo(String value) {
            addCriterion("bingzhong =", value, "bingzhong");
            return (Criteria) this;
        }

        public Criteria andBingzhongNotEqualTo(String value) {
            addCriterion("bingzhong <>", value, "bingzhong");
            return (Criteria) this;
        }

        public Criteria andBingzhongGreaterThan(String value) {
            addCriterion("bingzhong >", value, "bingzhong");
            return (Criteria) this;
        }

        public Criteria andBingzhongGreaterThanOrEqualTo(String value) {
            addCriterion("bingzhong >=", value, "bingzhong");
            return (Criteria) this;
        }

        public Criteria andBingzhongLessThan(String value) {
            addCriterion("bingzhong <", value, "bingzhong");
            return (Criteria) this;
        }

        public Criteria andBingzhongLessThanOrEqualTo(String value) {
            addCriterion("bingzhong <=", value, "bingzhong");
            return (Criteria) this;
        }

        public Criteria andBingzhongLike(String value) {
            addCriterion("bingzhong like", value, "bingzhong");
            return (Criteria) this;
        }

        public Criteria andBingzhongNotLike(String value) {
            addCriterion("bingzhong not like", value, "bingzhong");
            return (Criteria) this;
        }

        public Criteria andBingzhongIn(List<String> values) {
            addCriterion("bingzhong in", values, "bingzhong");
            return (Criteria) this;
        }

        public Criteria andBingzhongNotIn(List<String> values) {
            addCriterion("bingzhong not in", values, "bingzhong");
            return (Criteria) this;
        }

        public Criteria andBingzhongBetween(String value1, String value2) {
            addCriterion("bingzhong between", value1, value2, "bingzhong");
            return (Criteria) this;
        }

        public Criteria andBingzhongNotBetween(String value1, String value2) {
            addCriterion("bingzhong not between", value1, value2, "bingzhong");
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