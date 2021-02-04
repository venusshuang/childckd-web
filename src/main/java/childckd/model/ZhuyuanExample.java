package childckd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZhuyuanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZhuyuanExample() {
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

        public Criteria andZhuyuanidIsNull() {
            addCriterion("zhuyuanid is null");
            return (Criteria) this;
        }

        public Criteria andZhuyuanidIsNotNull() {
            addCriterion("zhuyuanid is not null");
            return (Criteria) this;
        }

        public Criteria andZhuyuanidEqualTo(String value) {
            addCriterion("zhuyuanid =", value, "zhuyuanid");
            return (Criteria) this;
        }

        public Criteria andZhuyuanidNotEqualTo(String value) {
            addCriterion("zhuyuanid <>", value, "zhuyuanid");
            return (Criteria) this;
        }

        public Criteria andZhuyuanidGreaterThan(String value) {
            addCriterion("zhuyuanid >", value, "zhuyuanid");
            return (Criteria) this;
        }

        public Criteria andZhuyuanidGreaterThanOrEqualTo(String value) {
            addCriterion("zhuyuanid >=", value, "zhuyuanid");
            return (Criteria) this;
        }

        public Criteria andZhuyuanidLessThan(String value) {
            addCriterion("zhuyuanid <", value, "zhuyuanid");
            return (Criteria) this;
        }

        public Criteria andZhuyuanidLessThanOrEqualTo(String value) {
            addCriterion("zhuyuanid <=", value, "zhuyuanid");
            return (Criteria) this;
        }

        public Criteria andZhuyuanidLike(String value) {
            addCriterion("zhuyuanid like", value, "zhuyuanid");
            return (Criteria) this;
        }

        public Criteria andZhuyuanidNotLike(String value) {
            addCriterion("zhuyuanid not like", value, "zhuyuanid");
            return (Criteria) this;
        }

        public Criteria andZhuyuanidIn(List<String> values) {
            addCriterion("zhuyuanid in", values, "zhuyuanid");
            return (Criteria) this;
        }

        public Criteria andZhuyuanidNotIn(List<String> values) {
            addCriterion("zhuyuanid not in", values, "zhuyuanid");
            return (Criteria) this;
        }

        public Criteria andZhuyuanidBetween(String value1, String value2) {
            addCriterion("zhuyuanid between", value1, value2, "zhuyuanid");
            return (Criteria) this;
        }

        public Criteria andZhuyuanidNotBetween(String value1, String value2) {
            addCriterion("zhuyuanid not between", value1, value2, "zhuyuanid");
            return (Criteria) this;
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

        public Criteria andXingmingIsNull() {
            addCriterion("xingming is null");
            return (Criteria) this;
        }

        public Criteria andXingmingIsNotNull() {
            addCriterion("xingming is not null");
            return (Criteria) this;
        }

        public Criteria andXingmingEqualTo(String value) {
            addCriterion("xingming =", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingNotEqualTo(String value) {
            addCriterion("xingming <>", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingGreaterThan(String value) {
            addCriterion("xingming >", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingGreaterThanOrEqualTo(String value) {
            addCriterion("xingming >=", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingLessThan(String value) {
            addCriterion("xingming <", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingLessThanOrEqualTo(String value) {
            addCriterion("xingming <=", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingLike(String value) {
            addCriterion("xingming like", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingNotLike(String value) {
            addCriterion("xingming not like", value, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingIn(List<String> values) {
            addCriterion("xingming in", values, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingNotIn(List<String> values) {
            addCriterion("xingming not in", values, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingBetween(String value1, String value2) {
            addCriterion("xingming between", value1, value2, "xingming");
            return (Criteria) this;
        }

        public Criteria andXingmingNotBetween(String value1, String value2) {
            addCriterion("xingming not between", value1, value2, "xingming");
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

        public Criteria andShenhejieguoIsNull() {
            addCriterion("shenhejieguo is null");
            return (Criteria) this;
        }

        public Criteria andShenhejieguoIsNotNull() {
            addCriterion("shenhejieguo is not null");
            return (Criteria) this;
        }

        public Criteria andShenhejieguoEqualTo(Integer value) {
            addCriterion("shenhejieguo =", value, "shenhejieguo");
            return (Criteria) this;
        }

        public Criteria andShenhejieguoNotEqualTo(Integer value) {
            addCriterion("shenhejieguo <>", value, "shenhejieguo");
            return (Criteria) this;
        }

        public Criteria andShenhejieguoGreaterThan(Integer value) {
            addCriterion("shenhejieguo >", value, "shenhejieguo");
            return (Criteria) this;
        }

        public Criteria andShenhejieguoGreaterThanOrEqualTo(Integer value) {
            addCriterion("shenhejieguo >=", value, "shenhejieguo");
            return (Criteria) this;
        }

        public Criteria andShenhejieguoLessThan(Integer value) {
            addCriterion("shenhejieguo <", value, "shenhejieguo");
            return (Criteria) this;
        }

        public Criteria andShenhejieguoLessThanOrEqualTo(Integer value) {
            addCriterion("shenhejieguo <=", value, "shenhejieguo");
            return (Criteria) this;
        }

        public Criteria andShenhejieguoIn(List<Integer> values) {
            addCriterion("shenhejieguo in", values, "shenhejieguo");
            return (Criteria) this;
        }

        public Criteria andShenhejieguoNotIn(List<Integer> values) {
            addCriterion("shenhejieguo not in", values, "shenhejieguo");
            return (Criteria) this;
        }

        public Criteria andShenhejieguoBetween(Integer value1, Integer value2) {
            addCriterion("shenhejieguo between", value1, value2, "shenhejieguo");
            return (Criteria) this;
        }

        public Criteria andShenhejieguoNotBetween(Integer value1, Integer value2) {
            addCriterion("shenhejieguo not between", value1, value2, "shenhejieguo");
            return (Criteria) this;
        }

        public Criteria andShenheyijianIsNull() {
            addCriterion("shenheyijian is null");
            return (Criteria) this;
        }

        public Criteria andShenheyijianIsNotNull() {
            addCriterion("shenheyijian is not null");
            return (Criteria) this;
        }

        public Criteria andShenheyijianEqualTo(String value) {
            addCriterion("shenheyijian =", value, "shenheyijian");
            return (Criteria) this;
        }

        public Criteria andShenheyijianNotEqualTo(String value) {
            addCriterion("shenheyijian <>", value, "shenheyijian");
            return (Criteria) this;
        }

        public Criteria andShenheyijianGreaterThan(String value) {
            addCriterion("shenheyijian >", value, "shenheyijian");
            return (Criteria) this;
        }

        public Criteria andShenheyijianGreaterThanOrEqualTo(String value) {
            addCriterion("shenheyijian >=", value, "shenheyijian");
            return (Criteria) this;
        }

        public Criteria andShenheyijianLessThan(String value) {
            addCriterion("shenheyijian <", value, "shenheyijian");
            return (Criteria) this;
        }

        public Criteria andShenheyijianLessThanOrEqualTo(String value) {
            addCriterion("shenheyijian <=", value, "shenheyijian");
            return (Criteria) this;
        }

        public Criteria andShenheyijianLike(String value) {
            addCriterion("shenheyijian like", value, "shenheyijian");
            return (Criteria) this;
        }

        public Criteria andShenheyijianNotLike(String value) {
            addCriterion("shenheyijian not like", value, "shenheyijian");
            return (Criteria) this;
        }

        public Criteria andShenheyijianIn(List<String> values) {
            addCriterion("shenheyijian in", values, "shenheyijian");
            return (Criteria) this;
        }

        public Criteria andShenheyijianNotIn(List<String> values) {
            addCriterion("shenheyijian not in", values, "shenheyijian");
            return (Criteria) this;
        }

        public Criteria andShenheyijianBetween(String value1, String value2) {
            addCriterion("shenheyijian between", value1, value2, "shenheyijian");
            return (Criteria) this;
        }

        public Criteria andShenheyijianNotBetween(String value1, String value2) {
            addCriterion("shenheyijian not between", value1, value2, "shenheyijian");
            return (Criteria) this;
        }

        public Criteria andShenheshijianIsNull() {
            addCriterion("shenheshijian is null");
            return (Criteria) this;
        }

        public Criteria andShenheshijianIsNotNull() {
            addCriterion("shenheshijian is not null");
            return (Criteria) this;
        }

        public Criteria andShenheshijianEqualTo(Date value) {
            addCriterion("shenheshijian =", value, "shenheshijian");
            return (Criteria) this;
        }

        public Criteria andShenheshijianNotEqualTo(Date value) {
            addCriterion("shenheshijian <>", value, "shenheshijian");
            return (Criteria) this;
        }

        public Criteria andShenheshijianGreaterThan(Date value) {
            addCriterion("shenheshijian >", value, "shenheshijian");
            return (Criteria) this;
        }

        public Criteria andShenheshijianGreaterThanOrEqualTo(Date value) {
            addCriterion("shenheshijian >=", value, "shenheshijian");
            return (Criteria) this;
        }

        public Criteria andShenheshijianLessThan(Date value) {
            addCriterion("shenheshijian <", value, "shenheshijian");
            return (Criteria) this;
        }

        public Criteria andShenheshijianLessThanOrEqualTo(Date value) {
            addCriterion("shenheshijian <=", value, "shenheshijian");
            return (Criteria) this;
        }

        public Criteria andShenheshijianIn(List<Date> values) {
            addCriterion("shenheshijian in", values, "shenheshijian");
            return (Criteria) this;
        }

        public Criteria andShenheshijianNotIn(List<Date> values) {
            addCriterion("shenheshijian not in", values, "shenheshijian");
            return (Criteria) this;
        }

        public Criteria andShenheshijianBetween(Date value1, Date value2) {
            addCriterion("shenheshijian between", value1, value2, "shenheshijian");
            return (Criteria) this;
        }

        public Criteria andShenheshijianNotBetween(Date value1, Date value2) {
            addCriterion("shenheshijian not between", value1, value2, "shenheshijian");
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