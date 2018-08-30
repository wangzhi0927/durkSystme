package com.dpm.db.common.example;

import java.util.ArrayList;
import java.util.List;

public class TCaseInfoExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TCaseInfoExample() {
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

		public Criteria andCaseNameIsNull() {
			addCriterion("CASE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andCaseNameIsNotNull() {
			addCriterion("CASE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andCaseNameEqualTo(String value) {
			addCriterion("CASE_NAME =", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameNotEqualTo(String value) {
			addCriterion("CASE_NAME <>", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameGreaterThan(String value) {
			addCriterion("CASE_NAME >", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameGreaterThanOrEqualTo(String value) {
			addCriterion("CASE_NAME >=", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameLessThan(String value) {
			addCriterion("CASE_NAME <", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameLessThanOrEqualTo(String value) {
			addCriterion("CASE_NAME <=", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameLike(String value) {
			addCriterion("CASE_NAME like", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameNotLike(String value) {
			addCriterion("CASE_NAME not like", value, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameIn(List<String> values) {
			addCriterion("CASE_NAME in", values, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameNotIn(List<String> values) {
			addCriterion("CASE_NAME not in", values, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameBetween(String value1, String value2) {
			addCriterion("CASE_NAME between", value1, value2, "caseName");
			return (Criteria) this;
		}

		public Criteria andCaseNameNotBetween(String value1, String value2) {
			addCriterion("CASE_NAME not between", value1, value2, "caseName");
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

		public Criteria andResourceIdIsNull() {
			addCriterion("RESOURCE_ID is null");
			return (Criteria) this;
		}

		public Criteria andResourceIdIsNotNull() {
			addCriterion("RESOURCE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andResourceIdEqualTo(String value) {
			addCriterion("RESOURCE_ID =", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdNotEqualTo(String value) {
			addCriterion("RESOURCE_ID <>", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdGreaterThan(String value) {
			addCriterion("RESOURCE_ID >", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdGreaterThanOrEqualTo(String value) {
			addCriterion("RESOURCE_ID >=", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdLessThan(String value) {
			addCriterion("RESOURCE_ID <", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdLessThanOrEqualTo(String value) {
			addCriterion("RESOURCE_ID <=", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdLike(String value) {
			addCriterion("RESOURCE_ID like", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdNotLike(String value) {
			addCriterion("RESOURCE_ID not like", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdIn(List<String> values) {
			addCriterion("RESOURCE_ID in", values, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdNotIn(List<String> values) {
			addCriterion("RESOURCE_ID not in", values, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdBetween(String value1, String value2) {
			addCriterion("RESOURCE_ID between", value1, value2, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdNotBetween(String value1, String value2) {
			addCriterion("RESOURCE_ID not between", value1, value2, "resourceId");
			return (Criteria) this;
		}

		public Criteria andContentIsNull() {
			addCriterion("CONTENT is null");
			return (Criteria) this;
		}

		public Criteria andContentIsNotNull() {
			addCriterion("CONTENT is not null");
			return (Criteria) this;
		}

		public Criteria andContentEqualTo(String value) {
			addCriterion("CONTENT =", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotEqualTo(String value) {
			addCriterion("CONTENT <>", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThan(String value) {
			addCriterion("CONTENT >", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentGreaterThanOrEqualTo(String value) {
			addCriterion("CONTENT >=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThan(String value) {
			addCriterion("CONTENT <", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLessThanOrEqualTo(String value) {
			addCriterion("CONTENT <=", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentLike(String value) {
			addCriterion("CONTENT like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotLike(String value) {
			addCriterion("CONTENT not like", value, "content");
			return (Criteria) this;
		}

		public Criteria andContentIn(List<String> values) {
			addCriterion("CONTENT in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotIn(List<String> values) {
			addCriterion("CONTENT not in", values, "content");
			return (Criteria) this;
		}

		public Criteria andContentBetween(String value1, String value2) {
			addCriterion("CONTENT between", value1, value2, "content");
			return (Criteria) this;
		}

		public Criteria andContentNotBetween(String value1, String value2) {
			addCriterion("CONTENT not between", value1, value2, "content");
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

		public Criteria andSubheadIsNull() {
			addCriterion("SUBHEAD is null");
			return (Criteria) this;
		}

		public Criteria andSubheadIsNotNull() {
			addCriterion("SUBHEAD is not null");
			return (Criteria) this;
		}

		public Criteria andSubheadEqualTo(String value) {
			addCriterion("SUBHEAD =", value, "subhead");
			return (Criteria) this;
		}

		public Criteria andSubheadNotEqualTo(String value) {
			addCriterion("SUBHEAD <>", value, "subhead");
			return (Criteria) this;
		}

		public Criteria andSubheadGreaterThan(String value) {
			addCriterion("SUBHEAD >", value, "subhead");
			return (Criteria) this;
		}

		public Criteria andSubheadGreaterThanOrEqualTo(String value) {
			addCriterion("SUBHEAD >=", value, "subhead");
			return (Criteria) this;
		}

		public Criteria andSubheadLessThan(String value) {
			addCriterion("SUBHEAD <", value, "subhead");
			return (Criteria) this;
		}

		public Criteria andSubheadLessThanOrEqualTo(String value) {
			addCriterion("SUBHEAD <=", value, "subhead");
			return (Criteria) this;
		}

		public Criteria andSubheadLike(String value) {
			addCriterion("SUBHEAD like", value, "subhead");
			return (Criteria) this;
		}

		public Criteria andSubheadNotLike(String value) {
			addCriterion("SUBHEAD not like", value, "subhead");
			return (Criteria) this;
		}

		public Criteria andSubheadIn(List<String> values) {
			addCriterion("SUBHEAD in", values, "subhead");
			return (Criteria) this;
		}

		public Criteria andSubheadNotIn(List<String> values) {
			addCriterion("SUBHEAD not in", values, "subhead");
			return (Criteria) this;
		}

		public Criteria andSubheadBetween(String value1, String value2) {
			addCriterion("SUBHEAD between", value1, value2, "subhead");
			return (Criteria) this;
		}

		public Criteria andSubheadNotBetween(String value1, String value2) {
			addCriterion("SUBHEAD not between", value1, value2, "subhead");
			return (Criteria) this;
		}

		public Criteria andIcfDiseaseIsNull() {
			addCriterion("ICF_DISEASE is null");
			return (Criteria) this;
		}

		public Criteria andIcfDiseaseIsNotNull() {
			addCriterion("ICF_DISEASE is not null");
			return (Criteria) this;
		}

		public Criteria andIcfDiseaseEqualTo(String value) {
			addCriterion("ICF_DISEASE =", value, "icfDisease");
			return (Criteria) this;
		}

		public Criteria andIcfDiseaseNotEqualTo(String value) {
			addCriterion("ICF_DISEASE <>", value, "icfDisease");
			return (Criteria) this;
		}

		public Criteria andIcfDiseaseGreaterThan(String value) {
			addCriterion("ICF_DISEASE >", value, "icfDisease");
			return (Criteria) this;
		}

		public Criteria andIcfDiseaseGreaterThanOrEqualTo(String value) {
			addCriterion("ICF_DISEASE >=", value, "icfDisease");
			return (Criteria) this;
		}

		public Criteria andIcfDiseaseLessThan(String value) {
			addCriterion("ICF_DISEASE <", value, "icfDisease");
			return (Criteria) this;
		}

		public Criteria andIcfDiseaseLessThanOrEqualTo(String value) {
			addCriterion("ICF_DISEASE <=", value, "icfDisease");
			return (Criteria) this;
		}

		public Criteria andIcfDiseaseLike(String value) {
			addCriterion("ICF_DISEASE like", value, "icfDisease");
			return (Criteria) this;
		}

		public Criteria andIcfDiseaseNotLike(String value) {
			addCriterion("ICF_DISEASE not like", value, "icfDisease");
			return (Criteria) this;
		}

		public Criteria andIcfDiseaseIn(List<String> values) {
			addCriterion("ICF_DISEASE in", values, "icfDisease");
			return (Criteria) this;
		}

		public Criteria andIcfDiseaseNotIn(List<String> values) {
			addCriterion("ICF_DISEASE not in", values, "icfDisease");
			return (Criteria) this;
		}

		public Criteria andIcfDiseaseBetween(String value1, String value2) {
			addCriterion("ICF_DISEASE between", value1, value2, "icfDisease");
			return (Criteria) this;
		}

		public Criteria andIcfDiseaseNotBetween(String value1, String value2) {
			addCriterion("ICF_DISEASE not between", value1, value2, "icfDisease");
			return (Criteria) this;
		}

		public Criteria andIcfCureIsNull() {
			addCriterion("ICF_CURE is null");
			return (Criteria) this;
		}

		public Criteria andIcfCureIsNotNull() {
			addCriterion("ICF_CURE is not null");
			return (Criteria) this;
		}

		public Criteria andIcfCureEqualTo(String value) {
			addCriterion("ICF_CURE =", value, "icfCure");
			return (Criteria) this;
		}

		public Criteria andIcfCureNotEqualTo(String value) {
			addCriterion("ICF_CURE <>", value, "icfCure");
			return (Criteria) this;
		}

		public Criteria andIcfCureGreaterThan(String value) {
			addCriterion("ICF_CURE >", value, "icfCure");
			return (Criteria) this;
		}

		public Criteria andIcfCureGreaterThanOrEqualTo(String value) {
			addCriterion("ICF_CURE >=", value, "icfCure");
			return (Criteria) this;
		}

		public Criteria andIcfCureLessThan(String value) {
			addCriterion("ICF_CURE <", value, "icfCure");
			return (Criteria) this;
		}

		public Criteria andIcfCureLessThanOrEqualTo(String value) {
			addCriterion("ICF_CURE <=", value, "icfCure");
			return (Criteria) this;
		}

		public Criteria andIcfCureLike(String value) {
			addCriterion("ICF_CURE like", value, "icfCure");
			return (Criteria) this;
		}

		public Criteria andIcfCureNotLike(String value) {
			addCriterion("ICF_CURE not like", value, "icfCure");
			return (Criteria) this;
		}

		public Criteria andIcfCureIn(List<String> values) {
			addCriterion("ICF_CURE in", values, "icfCure");
			return (Criteria) this;
		}

		public Criteria andIcfCureNotIn(List<String> values) {
			addCriterion("ICF_CURE not in", values, "icfCure");
			return (Criteria) this;
		}

		public Criteria andIcfCureBetween(String value1, String value2) {
			addCriterion("ICF_CURE between", value1, value2, "icfCure");
			return (Criteria) this;
		}

		public Criteria andIcfCureNotBetween(String value1, String value2) {
			addCriterion("ICF_CURE not between", value1, value2, "icfCure");
			return (Criteria) this;
		}

		public Criteria andIcfPatientIsNull() {
			addCriterion("ICF_PATIENT is null");
			return (Criteria) this;
		}

		public Criteria andIcfPatientIsNotNull() {
			addCriterion("ICF_PATIENT is not null");
			return (Criteria) this;
		}

		public Criteria andIcfPatientEqualTo(String value) {
			addCriterion("ICF_PATIENT =", value, "icfPatient");
			return (Criteria) this;
		}

		public Criteria andIcfPatientNotEqualTo(String value) {
			addCriterion("ICF_PATIENT <>", value, "icfPatient");
			return (Criteria) this;
		}

		public Criteria andIcfPatientGreaterThan(String value) {
			addCriterion("ICF_PATIENT >", value, "icfPatient");
			return (Criteria) this;
		}

		public Criteria andIcfPatientGreaterThanOrEqualTo(String value) {
			addCriterion("ICF_PATIENT >=", value, "icfPatient");
			return (Criteria) this;
		}

		public Criteria andIcfPatientLessThan(String value) {
			addCriterion("ICF_PATIENT <", value, "icfPatient");
			return (Criteria) this;
		}

		public Criteria andIcfPatientLessThanOrEqualTo(String value) {
			addCriterion("ICF_PATIENT <=", value, "icfPatient");
			return (Criteria) this;
		}

		public Criteria andIcfPatientLike(String value) {
			addCriterion("ICF_PATIENT like", value, "icfPatient");
			return (Criteria) this;
		}

		public Criteria andIcfPatientNotLike(String value) {
			addCriterion("ICF_PATIENT not like", value, "icfPatient");
			return (Criteria) this;
		}

		public Criteria andIcfPatientIn(List<String> values) {
			addCriterion("ICF_PATIENT in", values, "icfPatient");
			return (Criteria) this;
		}

		public Criteria andIcfPatientNotIn(List<String> values) {
			addCriterion("ICF_PATIENT not in", values, "icfPatient");
			return (Criteria) this;
		}

		public Criteria andIcfPatientBetween(String value1, String value2) {
			addCriterion("ICF_PATIENT between", value1, value2, "icfPatient");
			return (Criteria) this;
		}

		public Criteria andIcfPatientNotBetween(String value1, String value2) {
			addCriterion("ICF_PATIENT not between", value1, value2, "icfPatient");
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