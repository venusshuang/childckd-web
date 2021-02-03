package childckd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InfoExample() {
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

        public Criteria andInfoidIsNull() {
            addCriterion("infoid is null");
            return (Criteria) this;
        }

        public Criteria andInfoidIsNotNull() {
            addCriterion("infoid is not null");
            return (Criteria) this;
        }

        public Criteria andInfoidEqualTo(String value) {
            addCriterion("infoid =", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidNotEqualTo(String value) {
            addCriterion("infoid <>", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidGreaterThan(String value) {
            addCriterion("infoid >", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidGreaterThanOrEqualTo(String value) {
            addCriterion("infoid >=", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidLessThan(String value) {
            addCriterion("infoid <", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidLessThanOrEqualTo(String value) {
            addCriterion("infoid <=", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidLike(String value) {
            addCriterion("infoid like", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidNotLike(String value) {
            addCriterion("infoid not like", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidIn(List<String> values) {
            addCriterion("infoid in", values, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidNotIn(List<String> values) {
            addCriterion("infoid not in", values, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidBetween(String value1, String value2) {
            addCriterion("infoid between", value1, value2, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidNotBetween(String value1, String value2) {
            addCriterion("infoid not between", value1, value2, "infoid");
            return (Criteria) this;
        }

        public Criteria andJiantiIsNull() {
            addCriterion("jianti is null");
            return (Criteria) this;
        }

        public Criteria andJiantiIsNotNull() {
            addCriterion("jianti is not null");
            return (Criteria) this;
        }

        public Criteria andJiantiEqualTo(String value) {
            addCriterion("jianti =", value, "jianti");
            return (Criteria) this;
        }

        public Criteria andJiantiNotEqualTo(String value) {
            addCriterion("jianti <>", value, "jianti");
            return (Criteria) this;
        }

        public Criteria andJiantiGreaterThan(String value) {
            addCriterion("jianti >", value, "jianti");
            return (Criteria) this;
        }

        public Criteria andJiantiGreaterThanOrEqualTo(String value) {
            addCriterion("jianti >=", value, "jianti");
            return (Criteria) this;
        }

        public Criteria andJiantiLessThan(String value) {
            addCriterion("jianti <", value, "jianti");
            return (Criteria) this;
        }

        public Criteria andJiantiLessThanOrEqualTo(String value) {
            addCriterion("jianti <=", value, "jianti");
            return (Criteria) this;
        }

        public Criteria andJiantiLike(String value) {
            addCriterion("jianti like", value, "jianti");
            return (Criteria) this;
        }

        public Criteria andJiantiNotLike(String value) {
            addCriterion("jianti not like", value, "jianti");
            return (Criteria) this;
        }

        public Criteria andJiantiIn(List<String> values) {
            addCriterion("jianti in", values, "jianti");
            return (Criteria) this;
        }

        public Criteria andJiantiNotIn(List<String> values) {
            addCriterion("jianti not in", values, "jianti");
            return (Criteria) this;
        }

        public Criteria andJiantiBetween(String value1, String value2) {
            addCriterion("jianti between", value1, value2, "jianti");
            return (Criteria) this;
        }

        public Criteria andJiantiNotBetween(String value1, String value2) {
            addCriterion("jianti not between", value1, value2, "jianti");
            return (Criteria) this;
        }

        public Criteria andInfotitleIsNull() {
            addCriterion("infotitle is null");
            return (Criteria) this;
        }

        public Criteria andInfotitleIsNotNull() {
            addCriterion("infotitle is not null");
            return (Criteria) this;
        }

        public Criteria andInfotitleEqualTo(String value) {
            addCriterion("infotitle =", value, "infotitle");
            return (Criteria) this;
        }

        public Criteria andInfotitleNotEqualTo(String value) {
            addCriterion("infotitle <>", value, "infotitle");
            return (Criteria) this;
        }

        public Criteria andInfotitleGreaterThan(String value) {
            addCriterion("infotitle >", value, "infotitle");
            return (Criteria) this;
        }

        public Criteria andInfotitleGreaterThanOrEqualTo(String value) {
            addCriterion("infotitle >=", value, "infotitle");
            return (Criteria) this;
        }

        public Criteria andInfotitleLessThan(String value) {
            addCriterion("infotitle <", value, "infotitle");
            return (Criteria) this;
        }

        public Criteria andInfotitleLessThanOrEqualTo(String value) {
            addCriterion("infotitle <=", value, "infotitle");
            return (Criteria) this;
        }

        public Criteria andInfotitleLike(String value) {
            addCriterion("infotitle like", value, "infotitle");
            return (Criteria) this;
        }

        public Criteria andInfotitleNotLike(String value) {
            addCriterion("infotitle not like", value, "infotitle");
            return (Criteria) this;
        }

        public Criteria andInfotitleIn(List<String> values) {
            addCriterion("infotitle in", values, "infotitle");
            return (Criteria) this;
        }

        public Criteria andInfotitleNotIn(List<String> values) {
            addCriterion("infotitle not in", values, "infotitle");
            return (Criteria) this;
        }

        public Criteria andInfotitleBetween(String value1, String value2) {
            addCriterion("infotitle between", value1, value2, "infotitle");
            return (Criteria) this;
        }

        public Criteria andInfotitleNotBetween(String value1, String value2) {
            addCriterion("infotitle not between", value1, value2, "infotitle");
            return (Criteria) this;
        }

        public Criteria andInfotitle2IsNull() {
            addCriterion("infotitle2 is null");
            return (Criteria) this;
        }

        public Criteria andInfotitle2IsNotNull() {
            addCriterion("infotitle2 is not null");
            return (Criteria) this;
        }

        public Criteria andInfotitle2EqualTo(String value) {
            addCriterion("infotitle2 =", value, "infotitle2");
            return (Criteria) this;
        }

        public Criteria andInfotitle2NotEqualTo(String value) {
            addCriterion("infotitle2 <>", value, "infotitle2");
            return (Criteria) this;
        }

        public Criteria andInfotitle2GreaterThan(String value) {
            addCriterion("infotitle2 >", value, "infotitle2");
            return (Criteria) this;
        }

        public Criteria andInfotitle2GreaterThanOrEqualTo(String value) {
            addCriterion("infotitle2 >=", value, "infotitle2");
            return (Criteria) this;
        }

        public Criteria andInfotitle2LessThan(String value) {
            addCriterion("infotitle2 <", value, "infotitle2");
            return (Criteria) this;
        }

        public Criteria andInfotitle2LessThanOrEqualTo(String value) {
            addCriterion("infotitle2 <=", value, "infotitle2");
            return (Criteria) this;
        }

        public Criteria andInfotitle2Like(String value) {
            addCriterion("infotitle2 like", value, "infotitle2");
            return (Criteria) this;
        }

        public Criteria andInfotitle2NotLike(String value) {
            addCriterion("infotitle2 not like", value, "infotitle2");
            return (Criteria) this;
        }

        public Criteria andInfotitle2In(List<String> values) {
            addCriterion("infotitle2 in", values, "infotitle2");
            return (Criteria) this;
        }

        public Criteria andInfotitle2NotIn(List<String> values) {
            addCriterion("infotitle2 not in", values, "infotitle2");
            return (Criteria) this;
        }

        public Criteria andInfotitle2Between(String value1, String value2) {
            addCriterion("infotitle2 between", value1, value2, "infotitle2");
            return (Criteria) this;
        }

        public Criteria andInfotitle2NotBetween(String value1, String value2) {
            addCriterion("infotitle2 not between", value1, value2, "infotitle2");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addtime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIsNull() {
            addCriterion("releasetime is null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIsNotNull() {
            addCriterion("releasetime is not null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeEqualTo(Date value) {
            addCriterion("releasetime =", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotEqualTo(Date value) {
            addCriterion("releasetime <>", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThan(Date value) {
            addCriterion("releasetime >", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("releasetime >=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThan(Date value) {
            addCriterion("releasetime <", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThanOrEqualTo(Date value) {
            addCriterion("releasetime <=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIn(List<Date> values) {
            addCriterion("releasetime in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotIn(List<Date> values) {
            addCriterion("releasetime not in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeBetween(Date value1, Date value2) {
            addCriterion("releasetime between", value1, value2, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotBetween(Date value1, Date value2) {
            addCriterion("releasetime not between", value1, value2, "releasetime");
            return (Criteria) this;
        }

        public Criteria andImageurlIsNull() {
            addCriterion("imageurl is null");
            return (Criteria) this;
        }

        public Criteria andImageurlIsNotNull() {
            addCriterion("imageurl is not null");
            return (Criteria) this;
        }

        public Criteria andImageurlEqualTo(String value) {
            addCriterion("imageurl =", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotEqualTo(String value) {
            addCriterion("imageurl <>", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlGreaterThan(String value) {
            addCriterion("imageurl >", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlGreaterThanOrEqualTo(String value) {
            addCriterion("imageurl >=", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLessThan(String value) {
            addCriterion("imageurl <", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLessThanOrEqualTo(String value) {
            addCriterion("imageurl <=", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlLike(String value) {
            addCriterion("imageurl like", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotLike(String value) {
            addCriterion("imageurl not like", value, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlIn(List<String> values) {
            addCriterion("imageurl in", values, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotIn(List<String> values) {
            addCriterion("imageurl not in", values, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlBetween(String value1, String value2) {
            addCriterion("imageurl between", value1, value2, "imageurl");
            return (Criteria) this;
        }

        public Criteria andImageurlNotBetween(String value1, String value2) {
            addCriterion("imageurl not between", value1, value2, "imageurl");
            return (Criteria) this;
        }

        public Criteria andVideourlIsNull() {
            addCriterion("videourl is null");
            return (Criteria) this;
        }

        public Criteria andVideourlIsNotNull() {
            addCriterion("videourl is not null");
            return (Criteria) this;
        }

        public Criteria andVideourlEqualTo(String value) {
            addCriterion("videourl =", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotEqualTo(String value) {
            addCriterion("videourl <>", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlGreaterThan(String value) {
            addCriterion("videourl >", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlGreaterThanOrEqualTo(String value) {
            addCriterion("videourl >=", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlLessThan(String value) {
            addCriterion("videourl <", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlLessThanOrEqualTo(String value) {
            addCriterion("videourl <=", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlLike(String value) {
            addCriterion("videourl like", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotLike(String value) {
            addCriterion("videourl not like", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlIn(List<String> values) {
            addCriterion("videourl in", values, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotIn(List<String> values) {
            addCriterion("videourl not in", values, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlBetween(String value1, String value2) {
            addCriterion("videourl between", value1, value2, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotBetween(String value1, String value2) {
            addCriterion("videourl not between", value1, value2, "videourl");
            return (Criteria) this;
        }

        public Criteria andReturnurlIsNull() {
            addCriterion("returnurl is null");
            return (Criteria) this;
        }

        public Criteria andReturnurlIsNotNull() {
            addCriterion("returnurl is not null");
            return (Criteria) this;
        }

        public Criteria andReturnurlEqualTo(String value) {
            addCriterion("returnurl =", value, "returnurl");
            return (Criteria) this;
        }

        public Criteria andReturnurlNotEqualTo(String value) {
            addCriterion("returnurl <>", value, "returnurl");
            return (Criteria) this;
        }

        public Criteria andReturnurlGreaterThan(String value) {
            addCriterion("returnurl >", value, "returnurl");
            return (Criteria) this;
        }

        public Criteria andReturnurlGreaterThanOrEqualTo(String value) {
            addCriterion("returnurl >=", value, "returnurl");
            return (Criteria) this;
        }

        public Criteria andReturnurlLessThan(String value) {
            addCriterion("returnurl <", value, "returnurl");
            return (Criteria) this;
        }

        public Criteria andReturnurlLessThanOrEqualTo(String value) {
            addCriterion("returnurl <=", value, "returnurl");
            return (Criteria) this;
        }

        public Criteria andReturnurlLike(String value) {
            addCriterion("returnurl like", value, "returnurl");
            return (Criteria) this;
        }

        public Criteria andReturnurlNotLike(String value) {
            addCriterion("returnurl not like", value, "returnurl");
            return (Criteria) this;
        }

        public Criteria andReturnurlIn(List<String> values) {
            addCriterion("returnurl in", values, "returnurl");
            return (Criteria) this;
        }

        public Criteria andReturnurlNotIn(List<String> values) {
            addCriterion("returnurl not in", values, "returnurl");
            return (Criteria) this;
        }

        public Criteria andReturnurlBetween(String value1, String value2) {
            addCriterion("returnurl between", value1, value2, "returnurl");
            return (Criteria) this;
        }

        public Criteria andReturnurlNotBetween(String value1, String value2) {
            addCriterion("returnurl not between", value1, value2, "returnurl");
            return (Criteria) this;
        }

        public Criteria andClicknumIsNull() {
            addCriterion("clicknum is null");
            return (Criteria) this;
        }

        public Criteria andClicknumIsNotNull() {
            addCriterion("clicknum is not null");
            return (Criteria) this;
        }

        public Criteria andClicknumEqualTo(Integer value) {
            addCriterion("clicknum =", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumNotEqualTo(Integer value) {
            addCriterion("clicknum <>", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumGreaterThan(Integer value) {
            addCriterion("clicknum >", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumGreaterThanOrEqualTo(Integer value) {
            addCriterion("clicknum >=", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumLessThan(Integer value) {
            addCriterion("clicknum <", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumLessThanOrEqualTo(Integer value) {
            addCriterion("clicknum <=", value, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumIn(List<Integer> values) {
            addCriterion("clicknum in", values, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumNotIn(List<Integer> values) {
            addCriterion("clicknum not in", values, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumBetween(Integer value1, Integer value2) {
            addCriterion("clicknum between", value1, value2, "clicknum");
            return (Criteria) this;
        }

        public Criteria andClicknumNotBetween(Integer value1, Integer value2) {
            addCriterion("clicknum not between", value1, value2, "clicknum");
            return (Criteria) this;
        }

        public Criteria andCheckpassIsNull() {
            addCriterion("checkpass is null");
            return (Criteria) this;
        }

        public Criteria andCheckpassIsNotNull() {
            addCriterion("checkpass is not null");
            return (Criteria) this;
        }

        public Criteria andCheckpassEqualTo(Integer value) {
            addCriterion("checkpass =", value, "checkpass");
            return (Criteria) this;
        }

        public Criteria andCheckpassNotEqualTo(Integer value) {
            addCriterion("checkpass <>", value, "checkpass");
            return (Criteria) this;
        }

        public Criteria andCheckpassGreaterThan(Integer value) {
            addCriterion("checkpass >", value, "checkpass");
            return (Criteria) this;
        }

        public Criteria andCheckpassGreaterThanOrEqualTo(Integer value) {
            addCriterion("checkpass >=", value, "checkpass");
            return (Criteria) this;
        }

        public Criteria andCheckpassLessThan(Integer value) {
            addCriterion("checkpass <", value, "checkpass");
            return (Criteria) this;
        }

        public Criteria andCheckpassLessThanOrEqualTo(Integer value) {
            addCriterion("checkpass <=", value, "checkpass");
            return (Criteria) this;
        }

        public Criteria andCheckpassIn(List<Integer> values) {
            addCriterion("checkpass in", values, "checkpass");
            return (Criteria) this;
        }

        public Criteria andCheckpassNotIn(List<Integer> values) {
            addCriterion("checkpass not in", values, "checkpass");
            return (Criteria) this;
        }

        public Criteria andCheckpassBetween(Integer value1, Integer value2) {
            addCriterion("checkpass between", value1, value2, "checkpass");
            return (Criteria) this;
        }

        public Criteria andCheckpassNotBetween(Integer value1, Integer value2) {
            addCriterion("checkpass not between", value1, value2, "checkpass");
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