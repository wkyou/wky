package com.wang.dao.model;

import java.util.ArrayList;
import java.util.List;

public class TWxFwhXcxPatientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TWxFwhXcxPatientExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUnionidIsNull() {
            addCriterion("unionid is null");
            return (Criteria) this;
        }

        public Criteria andUnionidIsNotNull() {
            addCriterion("unionid is not null");
            return (Criteria) this;
        }

        public Criteria andUnionidEqualTo(String value) {
            addCriterion("unionid =", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotEqualTo(String value) {
            addCriterion("unionid <>", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidGreaterThan(String value) {
            addCriterion("unionid >", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidGreaterThanOrEqualTo(String value) {
            addCriterion("unionid >=", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidLessThan(String value) {
            addCriterion("unionid <", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidLessThanOrEqualTo(String value) {
            addCriterion("unionid <=", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidLike(String value) {
            addCriterion("unionid like", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotLike(String value) {
            addCriterion("unionid not like", value, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidIn(List<String> values) {
            addCriterion("unionid in", values, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotIn(List<String> values) {
            addCriterion("unionid not in", values, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidBetween(String value1, String value2) {
            addCriterion("unionid between", value1, value2, "unionid");
            return (Criteria) this;
        }

        public Criteria andUnionidNotBetween(String value1, String value2) {
            addCriterion("unionid not between", value1, value2, "unionid");
            return (Criteria) this;
        }

        public Criteria andFwhOpenidIsNull() {
            addCriterion("fwh_openid is null");
            return (Criteria) this;
        }

        public Criteria andFwhOpenidIsNotNull() {
            addCriterion("fwh_openid is not null");
            return (Criteria) this;
        }

        public Criteria andFwhOpenidEqualTo(String value) {
            addCriterion("fwh_openid =", value, "fwhOpenid");
            return (Criteria) this;
        }

        public Criteria andFwhOpenidNotEqualTo(String value) {
            addCriterion("fwh_openid <>", value, "fwhOpenid");
            return (Criteria) this;
        }

        public Criteria andFwhOpenidGreaterThan(String value) {
            addCriterion("fwh_openid >", value, "fwhOpenid");
            return (Criteria) this;
        }

        public Criteria andFwhOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("fwh_openid >=", value, "fwhOpenid");
            return (Criteria) this;
        }

        public Criteria andFwhOpenidLessThan(String value) {
            addCriterion("fwh_openid <", value, "fwhOpenid");
            return (Criteria) this;
        }

        public Criteria andFwhOpenidLessThanOrEqualTo(String value) {
            addCriterion("fwh_openid <=", value, "fwhOpenid");
            return (Criteria) this;
        }

        public Criteria andFwhOpenidLike(String value) {
            addCriterion("fwh_openid like", value, "fwhOpenid");
            return (Criteria) this;
        }

        public Criteria andFwhOpenidNotLike(String value) {
            addCriterion("fwh_openid not like", value, "fwhOpenid");
            return (Criteria) this;
        }

        public Criteria andFwhOpenidIn(List<String> values) {
            addCriterion("fwh_openid in", values, "fwhOpenid");
            return (Criteria) this;
        }

        public Criteria andFwhOpenidNotIn(List<String> values) {
            addCriterion("fwh_openid not in", values, "fwhOpenid");
            return (Criteria) this;
        }

        public Criteria andFwhOpenidBetween(String value1, String value2) {
            addCriterion("fwh_openid between", value1, value2, "fwhOpenid");
            return (Criteria) this;
        }

        public Criteria andFwhOpenidNotBetween(String value1, String value2) {
            addCriterion("fwh_openid not between", value1, value2, "fwhOpenid");
            return (Criteria) this;
        }

        public Criteria andFwhSubscribeIsNull() {
            addCriterion("fwh_subscribe is null");
            return (Criteria) this;
        }

        public Criteria andFwhSubscribeIsNotNull() {
            addCriterion("fwh_subscribe is not null");
            return (Criteria) this;
        }

        public Criteria andFwhSubscribeEqualTo(Integer value) {
            addCriterion("fwh_subscribe =", value, "fwhSubscribe");
            return (Criteria) this;
        }

        public Criteria andFwhSubscribeNotEqualTo(Integer value) {
            addCriterion("fwh_subscribe <>", value, "fwhSubscribe");
            return (Criteria) this;
        }

        public Criteria andFwhSubscribeGreaterThan(Integer value) {
            addCriterion("fwh_subscribe >", value, "fwhSubscribe");
            return (Criteria) this;
        }

        public Criteria andFwhSubscribeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fwh_subscribe >=", value, "fwhSubscribe");
            return (Criteria) this;
        }

        public Criteria andFwhSubscribeLessThan(Integer value) {
            addCriterion("fwh_subscribe <", value, "fwhSubscribe");
            return (Criteria) this;
        }

        public Criteria andFwhSubscribeLessThanOrEqualTo(Integer value) {
            addCriterion("fwh_subscribe <=", value, "fwhSubscribe");
            return (Criteria) this;
        }

        public Criteria andFwhSubscribeIn(List<Integer> values) {
            addCriterion("fwh_subscribe in", values, "fwhSubscribe");
            return (Criteria) this;
        }

        public Criteria andFwhSubscribeNotIn(List<Integer> values) {
            addCriterion("fwh_subscribe not in", values, "fwhSubscribe");
            return (Criteria) this;
        }

        public Criteria andFwhSubscribeBetween(Integer value1, Integer value2) {
            addCriterion("fwh_subscribe between", value1, value2, "fwhSubscribe");
            return (Criteria) this;
        }

        public Criteria andFwhSubscribeNotBetween(Integer value1, Integer value2) {
            addCriterion("fwh_subscribe not between", value1, value2, "fwhSubscribe");
            return (Criteria) this;
        }

        public Criteria andXcxOpenidIsNull() {
            addCriterion("xcx_openid is null");
            return (Criteria) this;
        }

        public Criteria andXcxOpenidIsNotNull() {
            addCriterion("xcx_openid is not null");
            return (Criteria) this;
        }

        public Criteria andXcxOpenidEqualTo(String value) {
            addCriterion("xcx_openid =", value, "xcxOpenid");
            return (Criteria) this;
        }

        public Criteria andXcxOpenidNotEqualTo(String value) {
            addCriterion("xcx_openid <>", value, "xcxOpenid");
            return (Criteria) this;
        }

        public Criteria andXcxOpenidGreaterThan(String value) {
            addCriterion("xcx_openid >", value, "xcxOpenid");
            return (Criteria) this;
        }

        public Criteria andXcxOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("xcx_openid >=", value, "xcxOpenid");
            return (Criteria) this;
        }

        public Criteria andXcxOpenidLessThan(String value) {
            addCriterion("xcx_openid <", value, "xcxOpenid");
            return (Criteria) this;
        }

        public Criteria andXcxOpenidLessThanOrEqualTo(String value) {
            addCriterion("xcx_openid <=", value, "xcxOpenid");
            return (Criteria) this;
        }

        public Criteria andXcxOpenidLike(String value) {
            addCriterion("xcx_openid like", value, "xcxOpenid");
            return (Criteria) this;
        }

        public Criteria andXcxOpenidNotLike(String value) {
            addCriterion("xcx_openid not like", value, "xcxOpenid");
            return (Criteria) this;
        }

        public Criteria andXcxOpenidIn(List<String> values) {
            addCriterion("xcx_openid in", values, "xcxOpenid");
            return (Criteria) this;
        }

        public Criteria andXcxOpenidNotIn(List<String> values) {
            addCriterion("xcx_openid not in", values, "xcxOpenid");
            return (Criteria) this;
        }

        public Criteria andXcxOpenidBetween(String value1, String value2) {
            addCriterion("xcx_openid between", value1, value2, "xcxOpenid");
            return (Criteria) this;
        }

        public Criteria andXcxOpenidNotBetween(String value1, String value2) {
            addCriterion("xcx_openid not between", value1, value2, "xcxOpenid");
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