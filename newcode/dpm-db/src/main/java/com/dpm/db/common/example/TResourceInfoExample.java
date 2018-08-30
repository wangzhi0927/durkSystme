package com.dpm.db.common.example;

import java.util.ArrayList;
import java.util.List;

public class TResourceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TResourceInfoExample() {
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

        public void addCriterion(String condition, Object value, String property) {
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

        public Criteria andResoNameIsNull() {
            addCriterion("RESO_NAME is null");
            return (Criteria) this;
        }

        public Criteria andResoNameIsNotNull() {
            addCriterion("RESO_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andResoNameEqualTo(String value) {
            addCriterion("RESO_NAME =", value, "resoName");
            return (Criteria) this;
        }

        public Criteria andResoNameNotEqualTo(String value) {
            addCriterion("RESO_NAME <>", value, "resoName");
            return (Criteria) this;
        }

        public Criteria andResoNameGreaterThan(String value) {
            addCriterion("RESO_NAME >", value, "resoName");
            return (Criteria) this;
        }

        public Criteria andResoNameGreaterThanOrEqualTo(String value) {
            addCriterion("RESO_NAME >=", value, "resoName");
            return (Criteria) this;
        }

        public Criteria andResoNameLessThan(String value) {
            addCriterion("RESO_NAME <", value, "resoName");
            return (Criteria) this;
        }

        public Criteria andResoNameLessThanOrEqualTo(String value) {
            addCriterion("RESO_NAME <=", value, "resoName");
            return (Criteria) this;
        }

        public Criteria andResoNameLike(String value) {
            addCriterion("RESO_NAME like", value, "resoName");
            return (Criteria) this;
        }

        public Criteria andResoNameNotLike(String value) {
            addCriterion("RESO_NAME not like", value, "resoName");
            return (Criteria) this;
        }

        public Criteria andResoNameIn(List<String> values) {
            addCriterion("RESO_NAME in", values, "resoName");
            return (Criteria) this;
        }

        public Criteria andResoNameNotIn(List<String> values) {
            addCriterion("RESO_NAME not in", values, "resoName");
            return (Criteria) this;
        }

        public Criteria andResoNameBetween(String value1, String value2) {
            addCriterion("RESO_NAME between", value1, value2, "resoName");
            return (Criteria) this;
        }

        public Criteria andResoNameNotBetween(String value1, String value2) {
            addCriterion("RESO_NAME not between", value1, value2, "resoName");
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

        public Criteria andPathIsNull() {
            addCriterion("PATH is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("PATH is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("PATH =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("PATH <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("PATH >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("PATH >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("PATH <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("PATH <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("PATH like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("PATH not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("PATH in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("PATH not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("PATH between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("PATH not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("SIZE is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Integer value) {
            addCriterion("SIZE =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Integer value) {
            addCriterion("SIZE <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Integer value) {
            addCriterion("SIZE >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SIZE >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Integer value) {
            addCriterion("SIZE <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Integer value) {
            addCriterion("SIZE <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Integer> values) {
            addCriterion("SIZE in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Integer> values) {
            addCriterion("SIZE not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Integer value1, Integer value2) {
            addCriterion("SIZE between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("SIZE not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("FILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("FILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("FILE_NAME =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("FILE_NAME <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("FILE_NAME >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_NAME >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("FILE_NAME <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("FILE_NAME <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("FILE_NAME like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("FILE_NAME not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("FILE_NAME in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("FILE_NAME not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("FILE_NAME between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("FILE_NAME not between", value1, value2, "fileName");
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

        public Criteria andDurationIsNull() {
            addCriterion("DURATION is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("DURATION is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("DURATION =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("DURATION <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("DURATION >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("DURATION >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("DURATION <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("DURATION <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("DURATION in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("DURATION not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("DURATION between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("DURATION not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDiseaseCodeIsNull() {
            addCriterion("DISEASE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseCodeIsNotNull() {
            addCriterion("DISEASE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseCodeEqualTo(String value) {
            addCriterion("DISEASE_CODE =", value, "diseaseCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCodeNotEqualTo(String value) {
            addCriterion("DISEASE_CODE <>", value, "diseaseCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCodeGreaterThan(String value) {
            addCriterion("DISEASE_CODE >", value, "diseaseCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DISEASE_CODE >=", value, "diseaseCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCodeLessThan(String value) {
            addCriterion("DISEASE_CODE <", value, "diseaseCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCodeLessThanOrEqualTo(String value) {
            addCriterion("DISEASE_CODE <=", value, "diseaseCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCodeLike(String value) {
            addCriterion("DISEASE_CODE like", value, "diseaseCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCodeNotLike(String value) {
            addCriterion("DISEASE_CODE not like", value, "diseaseCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCodeIn(List<String> values) {
            addCriterion("DISEASE_CODE in", values, "diseaseCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCodeNotIn(List<String> values) {
            addCriterion("DISEASE_CODE not in", values, "diseaseCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCodeBetween(String value1, String value2) {
            addCriterion("DISEASE_CODE between", value1, value2, "diseaseCode");
            return (Criteria) this;
        }

        public Criteria andDiseaseCodeNotBetween(String value1, String value2) {
            addCriterion("DISEASE_CODE not between", value1, value2, "diseaseCode");
            return (Criteria) this;
        }

        public Criteria andBindingIsNull() {
            addCriterion("BINDING is null");
            return (Criteria) this;
        }

        public Criteria andBindingIsNotNull() {
            addCriterion("BINDING is not null");
            return (Criteria) this;
        }

        public Criteria andBindingEqualTo(String value) {
            addCriterion("BINDING =", value, "binding");
            return (Criteria) this;
        }

        public Criteria andBindingNotEqualTo(String value) {
            addCriterion("BINDING <>", value, "binding");
            return (Criteria) this;
        }

        public Criteria andBindingGreaterThan(String value) {
            addCriterion("BINDING >", value, "binding");
            return (Criteria) this;
        }

        public Criteria andBindingGreaterThanOrEqualTo(String value) {
            addCriterion("BINDING >=", value, "binding");
            return (Criteria) this;
        }

        public Criteria andBindingLessThan(String value) {
            addCriterion("BINDING <", value, "binding");
            return (Criteria) this;
        }

        public Criteria andBindingLessThanOrEqualTo(String value) {
            addCriterion("BINDING <=", value, "binding");
            return (Criteria) this;
        }

        public Criteria andBindingLike(String value) {
            addCriterion("BINDING like", value, "binding");
            return (Criteria) this;
        }

        public Criteria andBindingNotLike(String value) {
            addCriterion("BINDING not like", value, "binding");
            return (Criteria) this;
        }

        public Criteria andBindingIn(List<String> values) {
            addCriterion("BINDING in", values, "binding");
            return (Criteria) this;
        }

        public Criteria andBindingNotIn(List<String> values) {
            addCriterion("BINDING not in", values, "binding");
            return (Criteria) this;
        }

        public Criteria andBindingBetween(String value1, String value2) {
            addCriterion("BINDING between", value1, value2, "binding");
            return (Criteria) this;
        }

        public Criteria andBindingNotBetween(String value1, String value2) {
            addCriterion("BINDING not between", value1, value2, "binding");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeIsNull() {
            addCriterion("BUSSINESS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeIsNotNull() {
            addCriterion("BUSSINESS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeEqualTo(String value) {
            addCriterion("BUSSINESS_TYPE =", value, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeNotEqualTo(String value) {
            addCriterion("BUSSINESS_TYPE <>", value, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeGreaterThan(String value) {
            addCriterion("BUSSINESS_TYPE >", value, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSSINESS_TYPE >=", value, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeLessThan(String value) {
            addCriterion("BUSSINESS_TYPE <", value, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeLessThanOrEqualTo(String value) {
            addCriterion("BUSSINESS_TYPE <=", value, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeLike(String value) {
            addCriterion("BUSSINESS_TYPE like", value, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeNotLike(String value) {
            addCriterion("BUSSINESS_TYPE not like", value, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeIn(List<String> values) {
            addCriterion("BUSSINESS_TYPE in", values, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeNotIn(List<String> values) {
            addCriterion("BUSSINESS_TYPE not in", values, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeBetween(String value1, String value2) {
            addCriterion("BUSSINESS_TYPE between", value1, value2, "bussinessType");
            return (Criteria) this;
        }

        public Criteria andBussinessTypeNotBetween(String value1, String value2) {
            addCriterion("BUSSINESS_TYPE not between", value1, value2, "bussinessType");
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

        public Criteria andOrganCodeIsNull() {
            addCriterion("ORGAN_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOrganCodeIsNotNull() {
            addCriterion("ORGAN_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrganCodeEqualTo(String value) {
            addCriterion("ORGAN_CODE =", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeNotEqualTo(String value) {
            addCriterion("ORGAN_CODE <>", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeGreaterThan(String value) {
            addCriterion("ORGAN_CODE >", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORGAN_CODE >=", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeLessThan(String value) {
            addCriterion("ORGAN_CODE <", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeLessThanOrEqualTo(String value) {
            addCriterion("ORGAN_CODE <=", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeLike(String value) {
            addCriterion("ORGAN_CODE like", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeNotLike(String value) {
            addCriterion("ORGAN_CODE not like", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeIn(List<String> values) {
            addCriterion("ORGAN_CODE in", values, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeNotIn(List<String> values) {
            addCriterion("ORGAN_CODE not in", values, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeBetween(String value1, String value2) {
            addCriterion("ORGAN_CODE between", value1, value2, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeNotBetween(String value1, String value2) {
            addCriterion("ORGAN_CODE not between", value1, value2, "organCode");
            return (Criteria) this;
        }

        public Criteria andRelIdIsNull() {
            addCriterion("REL_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelIdIsNotNull() {
            addCriterion("REL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelIdEqualTo(String value) {
            addCriterion("REL_ID =", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotEqualTo(String value) {
            addCriterion("REL_ID <>", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdGreaterThan(String value) {
            addCriterion("REL_ID >", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdGreaterThanOrEqualTo(String value) {
            addCriterion("REL_ID >=", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdLessThan(String value) {
            addCriterion("REL_ID <", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdLessThanOrEqualTo(String value) {
            addCriterion("REL_ID <=", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdLike(String value) {
            addCriterion("REL_ID like", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotLike(String value) {
            addCriterion("REL_ID not like", value, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdIn(List<String> values) {
            addCriterion("REL_ID in", values, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotIn(List<String> values) {
            addCriterion("REL_ID not in", values, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdBetween(String value1, String value2) {
            addCriterion("REL_ID between", value1, value2, "relId");
            return (Criteria) this;
        }

        public Criteria andRelIdNotBetween(String value1, String value2) {
            addCriterion("REL_ID not between", value1, value2, "relId");
            return (Criteria) this;
        }

        public Criteria andBoneTypeIsNull() {
            addCriterion("BONE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBoneTypeIsNotNull() {
            addCriterion("BONE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBoneTypeEqualTo(String value) {
            addCriterion("BONE_TYPE =", value, "boneType");
            return (Criteria) this;
        }

        public Criteria andBoneTypeNotEqualTo(String value) {
            addCriterion("BONE_TYPE <>", value, "boneType");
            return (Criteria) this;
        }

        public Criteria andBoneTypeGreaterThan(String value) {
            addCriterion("BONE_TYPE >", value, "boneType");
            return (Criteria) this;
        }

        public Criteria andBoneTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BONE_TYPE >=", value, "boneType");
            return (Criteria) this;
        }

        public Criteria andBoneTypeLessThan(String value) {
            addCriterion("BONE_TYPE <", value, "boneType");
            return (Criteria) this;
        }

        public Criteria andBoneTypeLessThanOrEqualTo(String value) {
            addCriterion("BONE_TYPE <=", value, "boneType");
            return (Criteria) this;
        }

        public Criteria andBoneTypeLike(String value) {
            addCriterion("BONE_TYPE like", value, "boneType");
            return (Criteria) this;
        }

        public Criteria andBoneTypeNotLike(String value) {
            addCriterion("BONE_TYPE not like", value, "boneType");
            return (Criteria) this;
        }

        public Criteria andBoneTypeIn(List<String> values) {
            addCriterion("BONE_TYPE in", values, "boneType");
            return (Criteria) this;
        }

        public Criteria andBoneTypeNotIn(List<String> values) {
            addCriterion("BONE_TYPE not in", values, "boneType");
            return (Criteria) this;
        }

        public Criteria andBoneTypeBetween(String value1, String value2) {
            addCriterion("BONE_TYPE between", value1, value2, "boneType");
            return (Criteria) this;
        }

        public Criteria andBoneTypeNotBetween(String value1, String value2) {
            addCriterion("BONE_TYPE not between", value1, value2, "boneType");
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