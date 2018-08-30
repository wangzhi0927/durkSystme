package com.dpm.db.common.example;

import java.util.ArrayList;
import java.util.List;

public class TDictDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TDictDetailExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDictCodeIsNull() {
            addCriterion("DICT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDictCodeIsNotNull() {
            addCriterion("DICT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDictCodeEqualTo(String value) {
            addCriterion("DICT_CODE =", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotEqualTo(String value) {
            addCriterion("DICT_CODE <>", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeGreaterThan(String value) {
            addCriterion("DICT_CODE >", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_CODE >=", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLessThan(String value) {
            addCriterion("DICT_CODE <", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLessThanOrEqualTo(String value) {
            addCriterion("DICT_CODE <=", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLike(String value) {
            addCriterion("DICT_CODE like", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotLike(String value) {
            addCriterion("DICT_CODE not like", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeIn(List<String> values) {
            addCriterion("DICT_CODE in", values, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotIn(List<String> values) {
            addCriterion("DICT_CODE not in", values, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeBetween(String value1, String value2) {
            addCriterion("DICT_CODE between", value1, value2, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotBetween(String value1, String value2) {
            addCriterion("DICT_CODE not between", value1, value2, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictNameIsNull() {
            addCriterion("DICT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDictNameIsNotNull() {
            addCriterion("DICT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDictNameEqualTo(String value) {
            addCriterion("DICT_NAME =", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotEqualTo(String value) {
            addCriterion("DICT_NAME <>", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameGreaterThan(String value) {
            addCriterion("DICT_NAME >", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_NAME >=", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameLessThan(String value) {
            addCriterion("DICT_NAME <", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameLessThanOrEqualTo(String value) {
            addCriterion("DICT_NAME <=", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameLike(String value) {
            addCriterion("DICT_NAME like", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotLike(String value) {
            addCriterion("DICT_NAME not like", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameIn(List<String> values) {
            addCriterion("DICT_NAME in", values, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotIn(List<String> values) {
            addCriterion("DICT_NAME not in", values, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameBetween(String value1, String value2) {
            addCriterion("DICT_NAME between", value1, value2, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotBetween(String value1, String value2) {
            addCriterion("DICT_NAME not between", value1, value2, "dictName");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("COMMENT is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("COMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("COMMENT =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("COMMENT <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("COMMENT >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("COMMENT >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("COMMENT <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("COMMENT <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("COMMENT like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("COMMENT not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("COMMENT in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("COMMENT not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("COMMENT between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("COMMENT not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andSnIsNull() {
            addCriterion("SN is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("SN is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(Integer value) {
            addCriterion("SN =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(Integer value) {
            addCriterion("SN <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(Integer value) {
            addCriterion("SN >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(Integer value) {
            addCriterion("SN >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(Integer value) {
            addCriterion("SN <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(Integer value) {
            addCriterion("SN <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<Integer> values) {
            addCriterion("SN in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<Integer> values) {
            addCriterion("SN not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(Integer value1, Integer value2) {
            addCriterion("SN between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(Integer value1, Integer value2) {
            addCriterion("SN not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("PARENT_ID =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("PARENT_ID <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("PARENT_ID >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ID >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("PARENT_ID <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ID <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("PARENT_ID like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("PARENT_ID not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("PARENT_ID in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("PARENT_ID not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("PARENT_ID between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_ID not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andPCodeIsNull() {
            addCriterion("P_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPCodeIsNotNull() {
            addCriterion("P_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPCodeEqualTo(String value) {
            addCriterion("P_CODE =", value, "pCode");
            return (Criteria) this;
        }

        public Criteria andPCodeNotEqualTo(String value) {
            addCriterion("P_CODE <>", value, "pCode");
            return (Criteria) this;
        }

        public Criteria andPCodeGreaterThan(String value) {
            addCriterion("P_CODE >", value, "pCode");
            return (Criteria) this;
        }

        public Criteria andPCodeGreaterThanOrEqualTo(String value) {
            addCriterion("P_CODE >=", value, "pCode");
            return (Criteria) this;
        }

        public Criteria andPCodeLessThan(String value) {
            addCriterion("P_CODE <", value, "pCode");
            return (Criteria) this;
        }

        public Criteria andPCodeLessThanOrEqualTo(String value) {
            addCriterion("P_CODE <=", value, "pCode");
            return (Criteria) this;
        }

        public Criteria andPCodeLike(String value) {
            addCriterion("P_CODE like", value, "pCode");
            return (Criteria) this;
        }

        public Criteria andPCodeNotLike(String value) {
            addCriterion("P_CODE not like", value, "pCode");
            return (Criteria) this;
        }

        public Criteria andPCodeIn(List<String> values) {
            addCriterion("P_CODE in", values, "pCode");
            return (Criteria) this;
        }

        public Criteria andPCodeNotIn(List<String> values) {
            addCriterion("P_CODE not in", values, "pCode");
            return (Criteria) this;
        }

        public Criteria andPCodeBetween(String value1, String value2) {
            addCriterion("P_CODE between", value1, value2, "pCode");
            return (Criteria) this;
        }

        public Criteria andPCodeNotBetween(String value1, String value2) {
            addCriterion("P_CODE not between", value1, value2, "pCode");
            return (Criteria) this;
        }

        public Criteria andFCodeIsNull() {
            addCriterion("F_CODE is null");
            return (Criteria) this;
        }

        public Criteria andFCodeIsNotNull() {
            addCriterion("F_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andFCodeEqualTo(String value) {
            addCriterion("F_CODE =", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeNotEqualTo(String value) {
            addCriterion("F_CODE <>", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeGreaterThan(String value) {
            addCriterion("F_CODE >", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeGreaterThanOrEqualTo(String value) {
            addCriterion("F_CODE >=", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeLessThan(String value) {
            addCriterion("F_CODE <", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeLessThanOrEqualTo(String value) {
            addCriterion("F_CODE <=", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeLike(String value) {
            addCriterion("F_CODE like", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeNotLike(String value) {
            addCriterion("F_CODE not like", value, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeIn(List<String> values) {
            addCriterion("F_CODE in", values, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeNotIn(List<String> values) {
            addCriterion("F_CODE not in", values, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeBetween(String value1, String value2) {
            addCriterion("F_CODE between", value1, value2, "fCode");
            return (Criteria) this;
        }

        public Criteria andFCodeNotBetween(String value1, String value2) {
            addCriterion("F_CODE not between", value1, value2, "fCode");
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