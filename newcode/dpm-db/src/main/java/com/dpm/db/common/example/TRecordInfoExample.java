package com.dpm.db.common.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TRecordInfoExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;
	
	protected int limit;

	public TRecordInfoExample() {
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

		public Criteria andHosCodeIsNull() {
			addCriterion("HOS_CODE is null");
			return (Criteria) this;
		}

		public Criteria andHosCodeIsNotNull() {
			addCriterion("HOS_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andHosCodeEqualTo(String value) {
			addCriterion("HOS_CODE =", value, "hosCode");
			return (Criteria) this;
		}

		public Criteria andHosCodeNotEqualTo(String value) {
			addCriterion("HOS_CODE <>", value, "hosCode");
			return (Criteria) this;
		}

		public Criteria andHosCodeGreaterThan(String value) {
			addCriterion("HOS_CODE >", value, "hosCode");
			return (Criteria) this;
		}

		public Criteria andHosCodeGreaterThanOrEqualTo(String value) {
			addCriterion("HOS_CODE >=", value, "hosCode");
			return (Criteria) this;
		}

		public Criteria andHosCodeLessThan(String value) {
			addCriterion("HOS_CODE <", value, "hosCode");
			return (Criteria) this;
		}

		public Criteria andHosCodeLessThanOrEqualTo(String value) {
			addCriterion("HOS_CODE <=", value, "hosCode");
			return (Criteria) this;
		}

		public Criteria andHosCodeLike(String value) {
			addCriterion("HOS_CODE like", value, "hosCode");
			return (Criteria) this;
		}

		public Criteria andHosCodeNotLike(String value) {
			addCriterion("HOS_CODE not like", value, "hosCode");
			return (Criteria) this;
		}

		public Criteria andHosCodeIn(List<String> values) {
			addCriterion("HOS_CODE in", values, "hosCode");
			return (Criteria) this;
		}

		public Criteria andHosCodeNotIn(List<String> values) {
			addCriterion("HOS_CODE not in", values, "hosCode");
			return (Criteria) this;
		}

		public Criteria andHosCodeBetween(String value1, String value2) {
			addCriterion("HOS_CODE between", value1, value2, "hosCode");
			return (Criteria) this;
		}

		public Criteria andHosCodeNotBetween(String value1, String value2) {
			addCriterion("HOS_CODE not between", value1, value2, "hosCode");
			return (Criteria) this;
		}

		public Criteria andPatientIdIsNull() {
			addCriterion("PATIENT_ID is null");
			return (Criteria) this;
		}

		public Criteria andPatientIdIsNotNull() {
			addCriterion("PATIENT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPatientIdEqualTo(String value) {
			addCriterion("PATIENT_ID =", value, "patientId");
			return (Criteria) this;
		}

		public Criteria andPatientIdNotEqualTo(String value) {
			addCriterion("PATIENT_ID <>", value, "patientId");
			return (Criteria) this;
		}

		public Criteria andPatientIdGreaterThan(String value) {
			addCriterion("PATIENT_ID >", value, "patientId");
			return (Criteria) this;
		}

		public Criteria andPatientIdGreaterThanOrEqualTo(String value) {
			addCriterion("PATIENT_ID >=", value, "patientId");
			return (Criteria) this;
		}

		public Criteria andPatientIdLessThan(String value) {
			addCriterion("PATIENT_ID <", value, "patientId");
			return (Criteria) this;
		}

		public Criteria andPatientIdLessThanOrEqualTo(String value) {
			addCriterion("PATIENT_ID <=", value, "patientId");
			return (Criteria) this;
		}

		public Criteria andPatientIdLike(String value) {
			addCriterion("PATIENT_ID like", value, "patientId");
			return (Criteria) this;
		}

		public Criteria andPatientIdNotLike(String value) {
			addCriterion("PATIENT_ID not like", value, "patientId");
			return (Criteria) this;
		}

		public Criteria andPatientIdIn(List<String> values) {
			addCriterion("PATIENT_ID in", values, "patientId");
			return (Criteria) this;
		}

		public Criteria andPatientIdNotIn(List<String> values) {
			addCriterion("PATIENT_ID not in", values, "patientId");
			return (Criteria) this;
		}

		public Criteria andPatientIdBetween(String value1, String value2) {
			addCriterion("PATIENT_ID between", value1, value2, "patientId");
			return (Criteria) this;
		}

		public Criteria andPatientIdNotBetween(String value1, String value2) {
			addCriterion("PATIENT_ID not between", value1, value2, "patientId");
			return (Criteria) this;
		}

		public Criteria andInpNoIsNull() {
			addCriterion("INP_NO is null");
			return (Criteria) this;
		}

		public Criteria andInpNoIsNotNull() {
			addCriterion("INP_NO is not null");
			return (Criteria) this;
		}

		public Criteria andInpNoEqualTo(String value) {
			addCriterion("INP_NO =", value, "inpNo");
			return (Criteria) this;
		}

		public Criteria andInpNoNotEqualTo(String value) {
			addCriterion("INP_NO <>", value, "inpNo");
			return (Criteria) this;
		}

		public Criteria andInpNoGreaterThan(String value) {
			addCriterion("INP_NO >", value, "inpNo");
			return (Criteria) this;
		}

		public Criteria andInpNoGreaterThanOrEqualTo(String value) {
			addCriterion("INP_NO >=", value, "inpNo");
			return (Criteria) this;
		}

		public Criteria andInpNoLessThan(String value) {
			addCriterion("INP_NO <", value, "inpNo");
			return (Criteria) this;
		}

		public Criteria andInpNoLessThanOrEqualTo(String value) {
			addCriterion("INP_NO <=", value, "inpNo");
			return (Criteria) this;
		}

		public Criteria andInpNoLike(String value) {
			addCriterion("INP_NO like", value, "inpNo");
			return (Criteria) this;
		}

		public Criteria andInpNoNotLike(String value) {
			addCriterion("INP_NO not like", value, "inpNo");
			return (Criteria) this;
		}

		public Criteria andInpNoIn(List<String> values) {
			addCriterion("INP_NO in", values, "inpNo");
			return (Criteria) this;
		}

		public Criteria andInpNoNotIn(List<String> values) {
			addCriterion("INP_NO not in", values, "inpNo");
			return (Criteria) this;
		}

		public Criteria andInpNoBetween(String value1, String value2) {
			addCriterion("INP_NO between", value1, value2, "inpNo");
			return (Criteria) this;
		}

		public Criteria andInpNoNotBetween(String value1, String value2) {
			addCriterion("INP_NO not between", value1, value2, "inpNo");
			return (Criteria) this;
		}

		public Criteria andInpTimesIsNull() {
			addCriterion("INP_TIMES is null");
			return (Criteria) this;
		}

		public Criteria andInpTimesIsNotNull() {
			addCriterion("INP_TIMES is not null");
			return (Criteria) this;
		}

		public Criteria andInpTimesEqualTo(String value) {
			addCriterion("INP_TIMES =", value, "inpTimes");
			return (Criteria) this;
		}

		public Criteria andInpTimesNotEqualTo(String value) {
			addCriterion("INP_TIMES <>", value, "inpTimes");
			return (Criteria) this;
		}

		public Criteria andInpTimesGreaterThan(String value) {
			addCriterion("INP_TIMES >", value, "inpTimes");
			return (Criteria) this;
		}

		public Criteria andInpTimesGreaterThanOrEqualTo(String value) {
			addCriterion("INP_TIMES >=", value, "inpTimes");
			return (Criteria) this;
		}

		public Criteria andInpTimesLessThan(String value) {
			addCriterion("INP_TIMES <", value, "inpTimes");
			return (Criteria) this;
		}

		public Criteria andInpTimesLessThanOrEqualTo(String value) {
			addCriterion("INP_TIMES <=", value, "inpTimes");
			return (Criteria) this;
		}

		public Criteria andInpTimesLike(String value) {
			addCriterion("INP_TIMES like", value, "inpTimes");
			return (Criteria) this;
		}

		public Criteria andInpTimesNotLike(String value) {
			addCriterion("INP_TIMES not like", value, "inpTimes");
			return (Criteria) this;
		}

		public Criteria andInpTimesIn(List<String> values) {
			addCriterion("INP_TIMES in", values, "inpTimes");
			return (Criteria) this;
		}

		public Criteria andInpTimesNotIn(List<String> values) {
			addCriterion("INP_TIMES not in", values, "inpTimes");
			return (Criteria) this;
		}

		public Criteria andInpTimesBetween(String value1, String value2) {
			addCriterion("INP_TIMES between", value1, value2, "inpTimes");
			return (Criteria) this;
		}

		public Criteria andInpTimesNotBetween(String value1, String value2) {
			addCriterion("INP_TIMES not between", value1, value2, "inpTimes");
			return (Criteria) this;
		}

		public Criteria andAgeIsNull() {
			addCriterion("AGE is null");
			return (Criteria) this;
		}

		public Criteria andAgeIsNotNull() {
			addCriterion("AGE is not null");
			return (Criteria) this;
		}

		public Criteria andAgeEqualTo(String value) {
			addCriterion("AGE =", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeNotEqualTo(String value) {
			addCriterion("AGE <>", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeGreaterThan(String value) {
			addCriterion("AGE >", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeGreaterThanOrEqualTo(String value) {
			addCriterion("AGE >=", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeLessThan(String value) {
			addCriterion("AGE <", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeLessThanOrEqualTo(String value) {
			addCriterion("AGE <=", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeLike(String value) {
			addCriterion("AGE like", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeNotLike(String value) {
			addCriterion("AGE not like", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeIn(List<String> values) {
			addCriterion("AGE in", values, "age");
			return (Criteria) this;
		}

		public Criteria andAgeNotIn(List<String> values) {
			addCriterion("AGE not in", values, "age");
			return (Criteria) this;
		}

		public Criteria andAgeBetween(String value1, String value2) {
			addCriterion("AGE between", value1, value2, "age");
			return (Criteria) this;
		}

		public Criteria andAgeNotBetween(String value1, String value2) {
			addCriterion("AGE not between", value1, value2, "age");
			return (Criteria) this;
		}

		public Criteria andSexIsNull() {
			addCriterion("SEX is null");
			return (Criteria) this;
		}

		public Criteria andSexIsNotNull() {
			addCriterion("SEX is not null");
			return (Criteria) this;
		}

		public Criteria andSexEqualTo(String value) {
			addCriterion("SEX =", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotEqualTo(String value) {
			addCriterion("SEX <>", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThan(String value) {
			addCriterion("SEX >", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThanOrEqualTo(String value) {
			addCriterion("SEX >=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThan(String value) {
			addCriterion("SEX <", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThanOrEqualTo(String value) {
			addCriterion("SEX <=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLike(String value) {
			addCriterion("SEX like", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotLike(String value) {
			addCriterion("SEX not like", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexIn(List<String> values) {
			addCriterion("SEX in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotIn(List<String> values) {
			addCriterion("SEX not in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexBetween(String value1, String value2) {
			addCriterion("SEX between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotBetween(String value1, String value2) {
			addCriterion("SEX not between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andDeptCodeIsNull() {
			addCriterion("DEPT_CODE is null");
			return (Criteria) this;
		}

		public Criteria andDeptCodeIsNotNull() {
			addCriterion("DEPT_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andDeptCodeEqualTo(String value) {
			addCriterion("DEPT_CODE =", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeNotEqualTo(String value) {
			addCriterion("DEPT_CODE <>", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeGreaterThan(String value) {
			addCriterion("DEPT_CODE >", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_CODE >=", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeLessThan(String value) {
			addCriterion("DEPT_CODE <", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeLessThanOrEqualTo(String value) {
			addCriterion("DEPT_CODE <=", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeLike(String value) {
			addCriterion("DEPT_CODE like", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeNotLike(String value) {
			addCriterion("DEPT_CODE not like", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeIn(List<String> values) {
			addCriterion("DEPT_CODE in", values, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeNotIn(List<String> values) {
			addCriterion("DEPT_CODE not in", values, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeBetween(String value1, String value2) {
			addCriterion("DEPT_CODE between", value1, value2, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeNotBetween(String value1, String value2) {
			addCriterion("DEPT_CODE not between", value1, value2, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptNameIsNull() {
			addCriterion("DEPT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andDeptNameIsNotNull() {
			addCriterion("DEPT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andDeptNameEqualTo(String value) {
			addCriterion("DEPT_NAME =", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotEqualTo(String value) {
			addCriterion("DEPT_NAME <>", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameGreaterThan(String value) {
			addCriterion("DEPT_NAME >", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_NAME >=", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLessThan(String value) {
			addCriterion("DEPT_NAME <", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLessThanOrEqualTo(String value) {
			addCriterion("DEPT_NAME <=", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLike(String value) {
			addCriterion("DEPT_NAME like", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotLike(String value) {
			addCriterion("DEPT_NAME not like", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameIn(List<String> values) {
			addCriterion("DEPT_NAME in", values, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotIn(List<String> values) {
			addCriterion("DEPT_NAME not in", values, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameBetween(String value1, String value2) {
			addCriterion("DEPT_NAME between", value1, value2, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotBetween(String value1, String value2) {
			addCriterion("DEPT_NAME not between", value1, value2, "deptName");
			return (Criteria) this;
		}

		public Criteria andWardCodeIsNull() {
			addCriterion("WARD_CODE is null");
			return (Criteria) this;
		}

		public Criteria andWardCodeIsNotNull() {
			addCriterion("WARD_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andWardCodeEqualTo(String value) {
			addCriterion("WARD_CODE =", value, "wardCode");
			return (Criteria) this;
		}

		public Criteria andWardCodeNotEqualTo(String value) {
			addCriterion("WARD_CODE <>", value, "wardCode");
			return (Criteria) this;
		}

		public Criteria andWardCodeGreaterThan(String value) {
			addCriterion("WARD_CODE >", value, "wardCode");
			return (Criteria) this;
		}

		public Criteria andWardCodeGreaterThanOrEqualTo(String value) {
			addCriterion("WARD_CODE >=", value, "wardCode");
			return (Criteria) this;
		}

		public Criteria andWardCodeLessThan(String value) {
			addCriterion("WARD_CODE <", value, "wardCode");
			return (Criteria) this;
		}

		public Criteria andWardCodeLessThanOrEqualTo(String value) {
			addCriterion("WARD_CODE <=", value, "wardCode");
			return (Criteria) this;
		}

		public Criteria andWardCodeLike(String value) {
			addCriterion("WARD_CODE like", value, "wardCode");
			return (Criteria) this;
		}

		public Criteria andWardCodeNotLike(String value) {
			addCriterion("WARD_CODE not like", value, "wardCode");
			return (Criteria) this;
		}

		public Criteria andWardCodeIn(List<String> values) {
			addCriterion("WARD_CODE in", values, "wardCode");
			return (Criteria) this;
		}

		public Criteria andWardCodeNotIn(List<String> values) {
			addCriterion("WARD_CODE not in", values, "wardCode");
			return (Criteria) this;
		}

		public Criteria andWardCodeBetween(String value1, String value2) {
			addCriterion("WARD_CODE between", value1, value2, "wardCode");
			return (Criteria) this;
		}

		public Criteria andWardCodeNotBetween(String value1, String value2) {
			addCriterion("WARD_CODE not between", value1, value2, "wardCode");
			return (Criteria) this;
		}

		public Criteria andWardNameIsNull() {
			addCriterion("WARD_NAME is null");
			return (Criteria) this;
		}

		public Criteria andWardNameIsNotNull() {
			addCriterion("WARD_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andWardNameEqualTo(String value) {
			addCriterion("WARD_NAME =", value, "wardName");
			return (Criteria) this;
		}

		public Criteria andWardNameNotEqualTo(String value) {
			addCriterion("WARD_NAME <>", value, "wardName");
			return (Criteria) this;
		}

		public Criteria andWardNameGreaterThan(String value) {
			addCriterion("WARD_NAME >", value, "wardName");
			return (Criteria) this;
		}

		public Criteria andWardNameGreaterThanOrEqualTo(String value) {
			addCriterion("WARD_NAME >=", value, "wardName");
			return (Criteria) this;
		}

		public Criteria andWardNameLessThan(String value) {
			addCriterion("WARD_NAME <", value, "wardName");
			return (Criteria) this;
		}

		public Criteria andWardNameLessThanOrEqualTo(String value) {
			addCriterion("WARD_NAME <=", value, "wardName");
			return (Criteria) this;
		}

		public Criteria andWardNameLike(String value) {
			addCriterion("WARD_NAME like", value, "wardName");
			return (Criteria) this;
		}

		public Criteria andWardNameNotLike(String value) {
			addCriterion("WARD_NAME not like", value, "wardName");
			return (Criteria) this;
		}

		public Criteria andWardNameIn(List<String> values) {
			addCriterion("WARD_NAME in", values, "wardName");
			return (Criteria) this;
		}

		public Criteria andWardNameNotIn(List<String> values) {
			addCriterion("WARD_NAME not in", values, "wardName");
			return (Criteria) this;
		}

		public Criteria andWardNameBetween(String value1, String value2) {
			addCriterion("WARD_NAME between", value1, value2, "wardName");
			return (Criteria) this;
		}

		public Criteria andWardNameNotBetween(String value1, String value2) {
			addCriterion("WARD_NAME not between", value1, value2, "wardName");
			return (Criteria) this;
		}

		public Criteria andBedNoIsNull() {
			addCriterion("BED_NO is null");
			return (Criteria) this;
		}

		public Criteria andBedNoIsNotNull() {
			addCriterion("BED_NO is not null");
			return (Criteria) this;
		}

		public Criteria andBedNoEqualTo(String value) {
			addCriterion("BED_NO =", value, "bedNo");
			return (Criteria) this;
		}

		public Criteria andBedNoNotEqualTo(String value) {
			addCriterion("BED_NO <>", value, "bedNo");
			return (Criteria) this;
		}

		public Criteria andBedNoGreaterThan(String value) {
			addCriterion("BED_NO >", value, "bedNo");
			return (Criteria) this;
		}

		public Criteria andBedNoGreaterThanOrEqualTo(String value) {
			addCriterion("BED_NO >=", value, "bedNo");
			return (Criteria) this;
		}

		public Criteria andBedNoLessThan(String value) {
			addCriterion("BED_NO <", value, "bedNo");
			return (Criteria) this;
		}

		public Criteria andBedNoLessThanOrEqualTo(String value) {
			addCriterion("BED_NO <=", value, "bedNo");
			return (Criteria) this;
		}

		public Criteria andBedNoLike(String value) {
			addCriterion("BED_NO like", value, "bedNo");
			return (Criteria) this;
		}

		public Criteria andBedNoNotLike(String value) {
			addCriterion("BED_NO not like", value, "bedNo");
			return (Criteria) this;
		}

		public Criteria andBedNoIn(List<String> values) {
			addCriterion("BED_NO in", values, "bedNo");
			return (Criteria) this;
		}

		public Criteria andBedNoNotIn(List<String> values) {
			addCriterion("BED_NO not in", values, "bedNo");
			return (Criteria) this;
		}

		public Criteria andBedNoBetween(String value1, String value2) {
			addCriterion("BED_NO between", value1, value2, "bedNo");
			return (Criteria) this;
		}

		public Criteria andBedNoNotBetween(String value1, String value2) {
			addCriterion("BED_NO not between", value1, value2, "bedNo");
			return (Criteria) this;
		}

		public Criteria andDiagNoIsNull() {
			addCriterion("DIAG_NO is null");
			return (Criteria) this;
		}

		public Criteria andDiagNoIsNotNull() {
			addCriterion("DIAG_NO is not null");
			return (Criteria) this;
		}

		public Criteria andDiagNoEqualTo(String value) {
			addCriterion("DIAG_NO =", value, "diagNo");
			return (Criteria) this;
		}

		public Criteria andDiagNoNotEqualTo(String value) {
			addCriterion("DIAG_NO <>", value, "diagNo");
			return (Criteria) this;
		}

		public Criteria andDiagNoGreaterThan(String value) {
			addCriterion("DIAG_NO >", value, "diagNo");
			return (Criteria) this;
		}

		public Criteria andDiagNoGreaterThanOrEqualTo(String value) {
			addCriterion("DIAG_NO >=", value, "diagNo");
			return (Criteria) this;
		}

		public Criteria andDiagNoLessThan(String value) {
			addCriterion("DIAG_NO <", value, "diagNo");
			return (Criteria) this;
		}

		public Criteria andDiagNoLessThanOrEqualTo(String value) {
			addCriterion("DIAG_NO <=", value, "diagNo");
			return (Criteria) this;
		}

		public Criteria andDiagNoLike(String value) {
			addCriterion("DIAG_NO like", value, "diagNo");
			return (Criteria) this;
		}

		public Criteria andDiagNoNotLike(String value) {
			addCriterion("DIAG_NO not like", value, "diagNo");
			return (Criteria) this;
		}

		public Criteria andDiagNoIn(List<String> values) {
			addCriterion("DIAG_NO in", values, "diagNo");
			return (Criteria) this;
		}

		public Criteria andDiagNoNotIn(List<String> values) {
			addCriterion("DIAG_NO not in", values, "diagNo");
			return (Criteria) this;
		}

		public Criteria andDiagNoBetween(String value1, String value2) {
			addCriterion("DIAG_NO between", value1, value2, "diagNo");
			return (Criteria) this;
		}

		public Criteria andDiagNoNotBetween(String value1, String value2) {
			addCriterion("DIAG_NO not between", value1, value2, "diagNo");
			return (Criteria) this;
		}

		public Criteria andDiagNameIsNull() {
			addCriterion("DIAG_NAME is null");
			return (Criteria) this;
		}

		public Criteria andDiagNameIsNotNull() {
			addCriterion("DIAG_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andDiagNameEqualTo(String value) {
			addCriterion("DIAG_NAME =", value, "diagName");
			return (Criteria) this;
		}

		public Criteria andDiagNameNotEqualTo(String value) {
			addCriterion("DIAG_NAME <>", value, "diagName");
			return (Criteria) this;
		}

		public Criteria andDiagNameGreaterThan(String value) {
			addCriterion("DIAG_NAME >", value, "diagName");
			return (Criteria) this;
		}

		public Criteria andDiagNameGreaterThanOrEqualTo(String value) {
			addCriterion("DIAG_NAME >=", value, "diagName");
			return (Criteria) this;
		}

		public Criteria andDiagNameLessThan(String value) {
			addCriterion("DIAG_NAME <", value, "diagName");
			return (Criteria) this;
		}

		public Criteria andDiagNameLessThanOrEqualTo(String value) {
			addCriterion("DIAG_NAME <=", value, "diagName");
			return (Criteria) this;
		}

		public Criteria andDiagNameLike(String value) {
			addCriterion("DIAG_NAME like", value, "diagName");
			return (Criteria) this;
		}

		public Criteria andDiagNameNotLike(String value) {
			addCriterion("DIAG_NAME not like", value, "diagName");
			return (Criteria) this;
		}

		public Criteria andDiagNameIn(List<String> values) {
			addCriterion("DIAG_NAME in", values, "diagName");
			return (Criteria) this;
		}

		public Criteria andDiagNameNotIn(List<String> values) {
			addCriterion("DIAG_NAME not in", values, "diagName");
			return (Criteria) this;
		}

		public Criteria andDiagNameBetween(String value1, String value2) {
			addCriterion("DIAG_NAME between", value1, value2, "diagName");
			return (Criteria) this;
		}

		public Criteria andDiagNameNotBetween(String value1, String value2) {
			addCriterion("DIAG_NAME not between", value1, value2, "diagName");
			return (Criteria) this;
		}

		public Criteria andTalkTypeIsNull() {
			addCriterion("TALK_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTalkTypeIsNotNull() {
			addCriterion("TALK_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTalkTypeEqualTo(String value) {
			addCriterion("TALK_TYPE =", value, "talkType");
			return (Criteria) this;
		}

		public Criteria andTalkTypeNotEqualTo(String value) {
			addCriterion("TALK_TYPE <>", value, "talkType");
			return (Criteria) this;
		}

		public Criteria andTalkTypeGreaterThan(String value) {
			addCriterion("TALK_TYPE >", value, "talkType");
			return (Criteria) this;
		}

		public Criteria andTalkTypeGreaterThanOrEqualTo(String value) {
			addCriterion("TALK_TYPE >=", value, "talkType");
			return (Criteria) this;
		}

		public Criteria andTalkTypeLessThan(String value) {
			addCriterion("TALK_TYPE <", value, "talkType");
			return (Criteria) this;
		}

		public Criteria andTalkTypeLessThanOrEqualTo(String value) {
			addCriterion("TALK_TYPE <=", value, "talkType");
			return (Criteria) this;
		}

		public Criteria andTalkTypeLike(String value) {
			addCriterion("TALK_TYPE like", value, "talkType");
			return (Criteria) this;
		}

		public Criteria andTalkTypeNotLike(String value) {
			addCriterion("TALK_TYPE not like", value, "talkType");
			return (Criteria) this;
		}

		public Criteria andTalkTypeIn(List<String> values) {
			addCriterion("TALK_TYPE in", values, "talkType");
			return (Criteria) this;
		}

		public Criteria andTalkTypeNotIn(List<String> values) {
			addCriterion("TALK_TYPE not in", values, "talkType");
			return (Criteria) this;
		}

		public Criteria andTalkTypeBetween(String value1, String value2) {
			addCriterion("TALK_TYPE between", value1, value2, "talkType");
			return (Criteria) this;
		}

		public Criteria andTalkTypeNotBetween(String value1, String value2) {
			addCriterion("TALK_TYPE not between", value1, value2, "talkType");
			return (Criteria) this;
		}

		public Criteria andNarcoticIdIsNull() {
			addCriterion("NARCOTIC_ID is null");
			return (Criteria) this;
		}

		public Criteria andNarcoticIdIsNotNull() {
			addCriterion("NARCOTIC_ID is not null");
			return (Criteria) this;
		}

		public Criteria andNarcoticIdEqualTo(String value) {
			addCriterion("NARCOTIC_ID =", value, "narcoticId");
			return (Criteria) this;
		}

		public Criteria andNarcoticIdNotEqualTo(String value) {
			addCriterion("NARCOTIC_ID <>", value, "narcoticId");
			return (Criteria) this;
		}

		public Criteria andNarcoticIdGreaterThan(String value) {
			addCriterion("NARCOTIC_ID >", value, "narcoticId");
			return (Criteria) this;
		}

		public Criteria andNarcoticIdGreaterThanOrEqualTo(String value) {
			addCriterion("NARCOTIC_ID >=", value, "narcoticId");
			return (Criteria) this;
		}

		public Criteria andNarcoticIdLessThan(String value) {
			addCriterion("NARCOTIC_ID <", value, "narcoticId");
			return (Criteria) this;
		}

		public Criteria andNarcoticIdLessThanOrEqualTo(String value) {
			addCriterion("NARCOTIC_ID <=", value, "narcoticId");
			return (Criteria) this;
		}

		public Criteria andNarcoticIdLike(String value) {
			addCriterion("NARCOTIC_ID like", value, "narcoticId");
			return (Criteria) this;
		}

		public Criteria andNarcoticIdNotLike(String value) {
			addCriterion("NARCOTIC_ID not like", value, "narcoticId");
			return (Criteria) this;
		}

		public Criteria andNarcoticIdIn(List<String> values) {
			addCriterion("NARCOTIC_ID in", values, "narcoticId");
			return (Criteria) this;
		}

		public Criteria andNarcoticIdNotIn(List<String> values) {
			addCriterion("NARCOTIC_ID not in", values, "narcoticId");
			return (Criteria) this;
		}

		public Criteria andNarcoticIdBetween(String value1, String value2) {
			addCriterion("NARCOTIC_ID between", value1, value2, "narcoticId");
			return (Criteria) this;
		}

		public Criteria andNarcoticIdNotBetween(String value1, String value2) {
			addCriterion("NARCOTIC_ID not between", value1, value2, "narcoticId");
			return (Criteria) this;
		}

		public Criteria andOperationIsNull() {
			addCriterion("OPERATION is null");
			return (Criteria) this;
		}

		public Criteria andOperationIsNotNull() {
			addCriterion("OPERATION is not null");
			return (Criteria) this;
		}

		public Criteria andOperationEqualTo(String value) {
			addCriterion("OPERATION =", value, "operation");
			return (Criteria) this;
		}

		public Criteria andOperationNotEqualTo(String value) {
			addCriterion("OPERATION <>", value, "operation");
			return (Criteria) this;
		}

		public Criteria andOperationGreaterThan(String value) {
			addCriterion("OPERATION >", value, "operation");
			return (Criteria) this;
		}

		public Criteria andOperationGreaterThanOrEqualTo(String value) {
			addCriterion("OPERATION >=", value, "operation");
			return (Criteria) this;
		}

		public Criteria andOperationLessThan(String value) {
			addCriterion("OPERATION <", value, "operation");
			return (Criteria) this;
		}

		public Criteria andOperationLessThanOrEqualTo(String value) {
			addCriterion("OPERATION <=", value, "operation");
			return (Criteria) this;
		}

		public Criteria andOperationLike(String value) {
			addCriterion("OPERATION like", value, "operation");
			return (Criteria) this;
		}

		public Criteria andOperationNotLike(String value) {
			addCriterion("OPERATION not like", value, "operation");
			return (Criteria) this;
		}

		public Criteria andOperationIn(List<String> values) {
			addCriterion("OPERATION in", values, "operation");
			return (Criteria) this;
		}

		public Criteria andOperationNotIn(List<String> values) {
			addCriterion("OPERATION not in", values, "operation");
			return (Criteria) this;
		}

		public Criteria andOperationBetween(String value1, String value2) {
			addCriterion("OPERATION between", value1, value2, "operation");
			return (Criteria) this;
		}

		public Criteria andOperationNotBetween(String value1, String value2) {
			addCriterion("OPERATION not between", value1, value2, "operation");
			return (Criteria) this;
		}

		public Criteria andRecordNameIsNull() {
			addCriterion("RECORD_NAME is null");
			return (Criteria) this;
		}

		public Criteria andRecordNameIsNotNull() {
			addCriterion("RECORD_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andRecordNameEqualTo(String value) {
			addCriterion("RECORD_NAME =", value, "recordName");
			return (Criteria) this;
		}

		public Criteria andRecordNameNotEqualTo(String value) {
			addCriterion("RECORD_NAME <>", value, "recordName");
			return (Criteria) this;
		}

		public Criteria andRecordNameGreaterThan(String value) {
			addCriterion("RECORD_NAME >", value, "recordName");
			return (Criteria) this;
		}

		public Criteria andRecordNameGreaterThanOrEqualTo(String value) {
			addCriterion("RECORD_NAME >=", value, "recordName");
			return (Criteria) this;
		}

		public Criteria andRecordNameLessThan(String value) {
			addCriterion("RECORD_NAME <", value, "recordName");
			return (Criteria) this;
		}

		public Criteria andRecordNameLessThanOrEqualTo(String value) {
			addCriterion("RECORD_NAME <=", value, "recordName");
			return (Criteria) this;
		}

		public Criteria andRecordNameLike(String value) {
			addCriterion("RECORD_NAME like", value, "recordName");
			return (Criteria) this;
		}

		public Criteria andRecordNameNotLike(String value) {
			addCriterion("RECORD_NAME not like", value, "recordName");
			return (Criteria) this;
		}

		public Criteria andRecordNameIn(List<String> values) {
			addCriterion("RECORD_NAME in", values, "recordName");
			return (Criteria) this;
		}

		public Criteria andRecordNameNotIn(List<String> values) {
			addCriterion("RECORD_NAME not in", values, "recordName");
			return (Criteria) this;
		}

		public Criteria andRecordNameBetween(String value1, String value2) {
			addCriterion("RECORD_NAME between", value1, value2, "recordName");
			return (Criteria) this;
		}

		public Criteria andRecordNameNotBetween(String value1, String value2) {
			addCriterion("RECORD_NAME not between", value1, value2, "recordName");
			return (Criteria) this;
		}

		public Criteria andFoldPathIsNull() {
			addCriterion("FOLD_PATH is null");
			return (Criteria) this;
		}

		public Criteria andFoldPathIsNotNull() {
			addCriterion("FOLD_PATH is not null");
			return (Criteria) this;
		}

		public Criteria andFoldPathEqualTo(String value) {
			addCriterion("FOLD_PATH =", value, "foldPath");
			return (Criteria) this;
		}

		public Criteria andFoldPathNotEqualTo(String value) {
			addCriterion("FOLD_PATH <>", value, "foldPath");
			return (Criteria) this;
		}

		public Criteria andFoldPathGreaterThan(String value) {
			addCriterion("FOLD_PATH >", value, "foldPath");
			return (Criteria) this;
		}

		public Criteria andFoldPathGreaterThanOrEqualTo(String value) {
			addCriterion("FOLD_PATH >=", value, "foldPath");
			return (Criteria) this;
		}

		public Criteria andFoldPathLessThan(String value) {
			addCriterion("FOLD_PATH <", value, "foldPath");
			return (Criteria) this;
		}

		public Criteria andFoldPathLessThanOrEqualTo(String value) {
			addCriterion("FOLD_PATH <=", value, "foldPath");
			return (Criteria) this;
		}

		public Criteria andFoldPathLike(String value) {
			addCriterion("FOLD_PATH like", value, "foldPath");
			return (Criteria) this;
		}

		public Criteria andFoldPathNotLike(String value) {
			addCriterion("FOLD_PATH not like", value, "foldPath");
			return (Criteria) this;
		}

		public Criteria andFoldPathIn(List<String> values) {
			addCriterion("FOLD_PATH in", values, "foldPath");
			return (Criteria) this;
		}

		public Criteria andFoldPathNotIn(List<String> values) {
			addCriterion("FOLD_PATH not in", values, "foldPath");
			return (Criteria) this;
		}

		public Criteria andFoldPathBetween(String value1, String value2) {
			addCriterion("FOLD_PATH between", value1, value2, "foldPath");
			return (Criteria) this;
		}

		public Criteria andFoldPathNotBetween(String value1, String value2) {
			addCriterion("FOLD_PATH not between", value1, value2, "foldPath");
			return (Criteria) this;
		}

		public Criteria andUploadTimeIsNull() {
			addCriterion("UPLOAD_TIME is null");
			return (Criteria) this;
		}

		public Criteria andUploadTimeIsNotNull() {
			addCriterion("UPLOAD_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andUploadTimeEqualTo(Date value) {
			addCriterion("UPLOAD_TIME =", value, "uploadTime");
			return (Criteria) this;
		}

		public Criteria andUploadTimeNotEqualTo(Date value) {
			addCriterion("UPLOAD_TIME <>", value, "uploadTime");
			return (Criteria) this;
		}

		public Criteria andUploadTimeGreaterThan(Date value) {
			addCriterion("UPLOAD_TIME >", value, "uploadTime");
			return (Criteria) this;
		}

		public Criteria andUploadTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("UPLOAD_TIME >=", value, "uploadTime");
			return (Criteria) this;
		}

		public Criteria andUploadTimeLessThan(Date value) {
			addCriterion("UPLOAD_TIME <", value, "uploadTime");
			return (Criteria) this;
		}

		public Criteria andUploadTimeLessThanOrEqualTo(Date value) {
			addCriterion("UPLOAD_TIME <=", value, "uploadTime");
			return (Criteria) this;
		}

		public Criteria andUploadTimeIn(List<Date> values) {
			addCriterion("UPLOAD_TIME in", values, "uploadTime");
			return (Criteria) this;
		}

		public Criteria andUploadTimeNotIn(List<Date> values) {
			addCriterion("UPLOAD_TIME not in", values, "uploadTime");
			return (Criteria) this;
		}

		public Criteria andUploadTimeBetween(Date value1, Date value2) {
			addCriterion("UPLOAD_TIME between", value1, value2, "uploadTime");
			return (Criteria) this;
		}

		public Criteria andUploadTimeNotBetween(Date value1, Date value2) {
			addCriterion("UPLOAD_TIME not between", value1, value2, "uploadTime");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(String value) {
			addCriterion("USER_ID =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(String value) {
			addCriterion("USER_ID <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(String value) {
			addCriterion("USER_ID >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("USER_ID >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(String value) {
			addCriterion("USER_ID <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(String value) {
			addCriterion("USER_ID <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLike(String value) {
			addCriterion("USER_ID like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotLike(String value) {
			addCriterion("USER_ID not like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<String> values) {
			addCriterion("USER_ID in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<String> values) {
			addCriterion("USER_ID not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(String value1, String value2) {
			addCriterion("USER_ID between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(String value1, String value2) {
			addCriterion("USER_ID not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andTalkTimeIsNull() {
			addCriterion("TALK_TIME is null");
			return (Criteria) this;
		}

		public Criteria andTalkTimeIsNotNull() {
			addCriterion("TALK_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andTalkTimeEqualTo(Integer value) {
			addCriterion("TALK_TIME =", value, "talkTime");
			return (Criteria) this;
		}

		public Criteria andTalkTimeNotEqualTo(Integer value) {
			addCriterion("TALK_TIME <>", value, "talkTime");
			return (Criteria) this;
		}

		public Criteria andTalkTimeGreaterThan(Integer value) {
			addCriterion("TALK_TIME >", value, "talkTime");
			return (Criteria) this;
		}

		public Criteria andTalkTimeGreaterThanOrEqualTo(Integer value) {
			addCriterion("TALK_TIME >=", value, "talkTime");
			return (Criteria) this;
		}

		public Criteria andTalkTimeLessThan(Integer value) {
			addCriterion("TALK_TIME <", value, "talkTime");
			return (Criteria) this;
		}

		public Criteria andTalkTimeLessThanOrEqualTo(Integer value) {
			addCriterion("TALK_TIME <=", value, "talkTime");
			return (Criteria) this;
		}

		public Criteria andTalkTimeIn(List<Integer> values) {
			addCriterion("TALK_TIME in", values, "talkTime");
			return (Criteria) this;
		}

		public Criteria andTalkTimeNotIn(List<Integer> values) {
			addCriterion("TALK_TIME not in", values, "talkTime");
			return (Criteria) this;
		}

		public Criteria andTalkTimeBetween(Integer value1, Integer value2) {
			addCriterion("TALK_TIME between", value1, value2, "talkTime");
			return (Criteria) this;
		}

		public Criteria andTalkTimeNotBetween(Integer value1, Integer value2) {
			addCriterion("TALK_TIME not between", value1, value2, "talkTime");
			return (Criteria) this;
		}

		public Criteria andIsfinishedIsNull() {
			addCriterion("ISFINISHED is null");
			return (Criteria) this;
		}

		public Criteria andIsfinishedIsNotNull() {
			addCriterion("ISFINISHED is not null");
			return (Criteria) this;
		}

		public Criteria andIsfinishedEqualTo(String value) {
			addCriterion("ISFINISHED =", value, "isfinished");
			return (Criteria) this;
		}

		public Criteria andIsfinishedNotEqualTo(String value) {
			addCriterion("ISFINISHED <>", value, "isfinished");
			return (Criteria) this;
		}

		public Criteria andIsfinishedGreaterThan(String value) {
			addCriterion("ISFINISHED >", value, "isfinished");
			return (Criteria) this;
		}

		public Criteria andIsfinishedGreaterThanOrEqualTo(String value) {
			addCriterion("ISFINISHED >=", value, "isfinished");
			return (Criteria) this;
		}

		public Criteria andIsfinishedLessThan(String value) {
			addCriterion("ISFINISHED <", value, "isfinished");
			return (Criteria) this;
		}

		public Criteria andIsfinishedLessThanOrEqualTo(String value) {
			addCriterion("ISFINISHED <=", value, "isfinished");
			return (Criteria) this;
		}

		public Criteria andIsfinishedLike(String value) {
			addCriterion("ISFINISHED like", value, "isfinished");
			return (Criteria) this;
		}

		public Criteria andIsfinishedNotLike(String value) {
			addCriterion("ISFINISHED not like", value, "isfinished");
			return (Criteria) this;
		}

		public Criteria andIsfinishedIn(List<String> values) {
			addCriterion("ISFINISHED in", values, "isfinished");
			return (Criteria) this;
		}

		public Criteria andIsfinishedNotIn(List<String> values) {
			addCriterion("ISFINISHED not in", values, "isfinished");
			return (Criteria) this;
		}

		public Criteria andIsfinishedBetween(String value1, String value2) {
			addCriterion("ISFINISHED between", value1, value2, "isfinished");
			return (Criteria) this;
		}

		public Criteria andIsfinishedNotBetween(String value1, String value2) {
			addCriterion("ISFINISHED not between", value1, value2, "isfinished");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("CREATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("CREATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("CREATE_TIME =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("CREATE_TIME <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("CREATE_TIME >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("CREATE_TIME <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("CREATE_TIME in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("CREATE_TIME not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("CREATE_TIME between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("CREATE_TIME not between", value1, value2, "createTime");
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
	
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}