package com.dpm.db.common.example;

import java.util.ArrayList;
import java.util.List;

public class TOrganInfoExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TOrganInfoExample() {
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

		public Criteria andOrganNameIsNull() {
			addCriterion("ORGAN_NAME is null");
			return (Criteria) this;
		}

		public Criteria andOrganNameIsNotNull() {
			addCriterion("ORGAN_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andOrganNameEqualTo(String value) {
			addCriterion("ORGAN_NAME =", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameNotEqualTo(String value) {
			addCriterion("ORGAN_NAME <>", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameGreaterThan(String value) {
			addCriterion("ORGAN_NAME >", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameGreaterThanOrEqualTo(String value) {
			addCriterion("ORGAN_NAME >=", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameLessThan(String value) {
			addCriterion("ORGAN_NAME <", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameLessThanOrEqualTo(String value) {
			addCriterion("ORGAN_NAME <=", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameLike(String value) {
			addCriterion("ORGAN_NAME like", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameNotLike(String value) {
			addCriterion("ORGAN_NAME not like", value, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameIn(List<String> values) {
			addCriterion("ORGAN_NAME in", values, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameNotIn(List<String> values) {
			addCriterion("ORGAN_NAME not in", values, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameBetween(String value1, String value2) {
			addCriterion("ORGAN_NAME between", value1, value2, "organName");
			return (Criteria) this;
		}

		public Criteria andOrganNameNotBetween(String value1, String value2) {
			addCriterion("ORGAN_NAME not between", value1, value2, "organName");
			return (Criteria) this;
		}

		public Criteria andBelongIdIsNull() {
			addCriterion("BELONG_ID is null");
			return (Criteria) this;
		}

		public Criteria andBelongIdIsNotNull() {
			addCriterion("BELONG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBelongIdEqualTo(String value) {
			addCriterion("BELONG_ID =", value, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdNotEqualTo(String value) {
			addCriterion("BELONG_ID <>", value, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdGreaterThan(String value) {
			addCriterion("BELONG_ID >", value, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdGreaterThanOrEqualTo(String value) {
			addCriterion("BELONG_ID >=", value, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdLessThan(String value) {
			addCriterion("BELONG_ID <", value, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdLessThanOrEqualTo(String value) {
			addCriterion("BELONG_ID <=", value, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdLike(String value) {
			addCriterion("BELONG_ID like", value, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdNotLike(String value) {
			addCriterion("BELONG_ID not like", value, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdIn(List<String> values) {
			addCriterion("BELONG_ID in", values, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdNotIn(List<String> values) {
			addCriterion("BELONG_ID not in", values, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdBetween(String value1, String value2) {
			addCriterion("BELONG_ID between", value1, value2, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongIdNotBetween(String value1, String value2) {
			addCriterion("BELONG_ID not between", value1, value2, "belongId");
			return (Criteria) this;
		}

		public Criteria andBelongNameIsNull() {
			addCriterion("BELONG_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBelongNameIsNotNull() {
			addCriterion("BELONG_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBelongNameEqualTo(String value) {
			addCriterion("BELONG_NAME =", value, "belongName");
			return (Criteria) this;
		}

		public Criteria andBelongNameNotEqualTo(String value) {
			addCriterion("BELONG_NAME <>", value, "belongName");
			return (Criteria) this;
		}

		public Criteria andBelongNameGreaterThan(String value) {
			addCriterion("BELONG_NAME >", value, "belongName");
			return (Criteria) this;
		}

		public Criteria andBelongNameGreaterThanOrEqualTo(String value) {
			addCriterion("BELONG_NAME >=", value, "belongName");
			return (Criteria) this;
		}

		public Criteria andBelongNameLessThan(String value) {
			addCriterion("BELONG_NAME <", value, "belongName");
			return (Criteria) this;
		}

		public Criteria andBelongNameLessThanOrEqualTo(String value) {
			addCriterion("BELONG_NAME <=", value, "belongName");
			return (Criteria) this;
		}

		public Criteria andBelongNameLike(String value) {
			addCriterion("BELONG_NAME like", value, "belongName");
			return (Criteria) this;
		}

		public Criteria andBelongNameNotLike(String value) {
			addCriterion("BELONG_NAME not like", value, "belongName");
			return (Criteria) this;
		}

		public Criteria andBelongNameIn(List<String> values) {
			addCriterion("BELONG_NAME in", values, "belongName");
			return (Criteria) this;
		}

		public Criteria andBelongNameNotIn(List<String> values) {
			addCriterion("BELONG_NAME not in", values, "belongName");
			return (Criteria) this;
		}

		public Criteria andBelongNameBetween(String value1, String value2) {
			addCriterion("BELONG_NAME between", value1, value2, "belongName");
			return (Criteria) this;
		}

		public Criteria andBelongNameNotBetween(String value1, String value2) {
			addCriterion("BELONG_NAME not between", value1, value2, "belongName");
			return (Criteria) this;
		}

		public Criteria andOrganTypeIsNull() {
			addCriterion("ORGAN_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andOrganTypeIsNotNull() {
			addCriterion("ORGAN_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andOrganTypeEqualTo(String value) {
			addCriterion("ORGAN_TYPE =", value, "organType");
			return (Criteria) this;
		}

		public Criteria andOrganTypeNotEqualTo(String value) {
			addCriterion("ORGAN_TYPE <>", value, "organType");
			return (Criteria) this;
		}

		public Criteria andOrganTypeGreaterThan(String value) {
			addCriterion("ORGAN_TYPE >", value, "organType");
			return (Criteria) this;
		}

		public Criteria andOrganTypeGreaterThanOrEqualTo(String value) {
			addCriterion("ORGAN_TYPE >=", value, "organType");
			return (Criteria) this;
		}

		public Criteria andOrganTypeLessThan(String value) {
			addCriterion("ORGAN_TYPE <", value, "organType");
			return (Criteria) this;
		}

		public Criteria andOrganTypeLessThanOrEqualTo(String value) {
			addCriterion("ORGAN_TYPE <=", value, "organType");
			return (Criteria) this;
		}

		public Criteria andOrganTypeLike(String value) {
			addCriterion("ORGAN_TYPE like", value, "organType");
			return (Criteria) this;
		}

		public Criteria andOrganTypeNotLike(String value) {
			addCriterion("ORGAN_TYPE not like", value, "organType");
			return (Criteria) this;
		}

		public Criteria andOrganTypeIn(List<String> values) {
			addCriterion("ORGAN_TYPE in", values, "organType");
			return (Criteria) this;
		}

		public Criteria andOrganTypeNotIn(List<String> values) {
			addCriterion("ORGAN_TYPE not in", values, "organType");
			return (Criteria) this;
		}

		public Criteria andOrganTypeBetween(String value1, String value2) {
			addCriterion("ORGAN_TYPE between", value1, value2, "organType");
			return (Criteria) this;
		}

		public Criteria andOrganTypeNotBetween(String value1, String value2) {
			addCriterion("ORGAN_TYPE not between", value1, value2, "organType");
			return (Criteria) this;
		}

		public Criteria andParentCodeIsNull() {
			addCriterion("PARENT_CODE is null");
			return (Criteria) this;
		}

		public Criteria andParentCodeIsNotNull() {
			addCriterion("PARENT_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andParentCodeEqualTo(String value) {
			addCriterion("PARENT_CODE =", value, "parentCode");
			return (Criteria) this;
		}

		public Criteria andParentCodeNotEqualTo(String value) {
			addCriterion("PARENT_CODE <>", value, "parentCode");
			return (Criteria) this;
		}

		public Criteria andParentCodeGreaterThan(String value) {
			addCriterion("PARENT_CODE >", value, "parentCode");
			return (Criteria) this;
		}

		public Criteria andParentCodeGreaterThanOrEqualTo(String value) {
			addCriterion("PARENT_CODE >=", value, "parentCode");
			return (Criteria) this;
		}

		public Criteria andParentCodeLessThan(String value) {
			addCriterion("PARENT_CODE <", value, "parentCode");
			return (Criteria) this;
		}

		public Criteria andParentCodeLessThanOrEqualTo(String value) {
			addCriterion("PARENT_CODE <=", value, "parentCode");
			return (Criteria) this;
		}

		public Criteria andParentCodeLike(String value) {
			addCriterion("PARENT_CODE like", value, "parentCode");
			return (Criteria) this;
		}

		public Criteria andParentCodeNotLike(String value) {
			addCriterion("PARENT_CODE not like", value, "parentCode");
			return (Criteria) this;
		}

		public Criteria andParentCodeIn(List<String> values) {
			addCriterion("PARENT_CODE in", values, "parentCode");
			return (Criteria) this;
		}

		public Criteria andParentCodeNotIn(List<String> values) {
			addCriterion("PARENT_CODE not in", values, "parentCode");
			return (Criteria) this;
		}

		public Criteria andParentCodeBetween(String value1, String value2) {
			addCriterion("PARENT_CODE between", value1, value2, "parentCode");
			return (Criteria) this;
		}

		public Criteria andParentCodeNotBetween(String value1, String value2) {
			addCriterion("PARENT_CODE not between", value1, value2, "parentCode");
			return (Criteria) this;
		}

		public Criteria andTypeDefaultIsNull() {
			addCriterion("TYPE_DEFAULT is null");
			return (Criteria) this;
		}

		public Criteria andTypeDefaultIsNotNull() {
			addCriterion("TYPE_DEFAULT is not null");
			return (Criteria) this;
		}

		public Criteria andTypeDefaultEqualTo(String value) {
			addCriterion("TYPE_DEFAULT =", value, "typeDefault");
			return (Criteria) this;
		}

		public Criteria andTypeDefaultNotEqualTo(String value) {
			addCriterion("TYPE_DEFAULT <>", value, "typeDefault");
			return (Criteria) this;
		}

		public Criteria andTypeDefaultGreaterThan(String value) {
			addCriterion("TYPE_DEFAULT >", value, "typeDefault");
			return (Criteria) this;
		}

		public Criteria andTypeDefaultGreaterThanOrEqualTo(String value) {
			addCriterion("TYPE_DEFAULT >=", value, "typeDefault");
			return (Criteria) this;
		}

		public Criteria andTypeDefaultLessThan(String value) {
			addCriterion("TYPE_DEFAULT <", value, "typeDefault");
			return (Criteria) this;
		}

		public Criteria andTypeDefaultLessThanOrEqualTo(String value) {
			addCriterion("TYPE_DEFAULT <=", value, "typeDefault");
			return (Criteria) this;
		}

		public Criteria andTypeDefaultLike(String value) {
			addCriterion("TYPE_DEFAULT like", value, "typeDefault");
			return (Criteria) this;
		}

		public Criteria andTypeDefaultNotLike(String value) {
			addCriterion("TYPE_DEFAULT not like", value, "typeDefault");
			return (Criteria) this;
		}

		public Criteria andTypeDefaultIn(List<String> values) {
			addCriterion("TYPE_DEFAULT in", values, "typeDefault");
			return (Criteria) this;
		}

		public Criteria andTypeDefaultNotIn(List<String> values) {
			addCriterion("TYPE_DEFAULT not in", values, "typeDefault");
			return (Criteria) this;
		}

		public Criteria andTypeDefaultBetween(String value1, String value2) {
			addCriterion("TYPE_DEFAULT between", value1, value2, "typeDefault");
			return (Criteria) this;
		}

		public Criteria andTypeDefaultNotBetween(String value1, String value2) {
			addCriterion("TYPE_DEFAULT not between", value1, value2, "typeDefault");
			return (Criteria) this;
		}

		public Criteria andIconNameIsNull() {
			addCriterion("ICON_NAME is null");
			return (Criteria) this;
		}

		public Criteria andIconNameIsNotNull() {
			addCriterion("ICON_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andIconNameEqualTo(String value) {
			addCriterion("ICON_NAME =", value, "iconName");
			return (Criteria) this;
		}

		public Criteria andIconNameNotEqualTo(String value) {
			addCriterion("ICON_NAME <>", value, "iconName");
			return (Criteria) this;
		}

		public Criteria andIconNameGreaterThan(String value) {
			addCriterion("ICON_NAME >", value, "iconName");
			return (Criteria) this;
		}

		public Criteria andIconNameGreaterThanOrEqualTo(String value) {
			addCriterion("ICON_NAME >=", value, "iconName");
			return (Criteria) this;
		}

		public Criteria andIconNameLessThan(String value) {
			addCriterion("ICON_NAME <", value, "iconName");
			return (Criteria) this;
		}

		public Criteria andIconNameLessThanOrEqualTo(String value) {
			addCriterion("ICON_NAME <=", value, "iconName");
			return (Criteria) this;
		}

		public Criteria andIconNameLike(String value) {
			addCriterion("ICON_NAME like", value, "iconName");
			return (Criteria) this;
		}

		public Criteria andIconNameNotLike(String value) {
			addCriterion("ICON_NAME not like", value, "iconName");
			return (Criteria) this;
		}

		public Criteria andIconNameIn(List<String> values) {
			addCriterion("ICON_NAME in", values, "iconName");
			return (Criteria) this;
		}

		public Criteria andIconNameNotIn(List<String> values) {
			addCriterion("ICON_NAME not in", values, "iconName");
			return (Criteria) this;
		}

		public Criteria andIconNameBetween(String value1, String value2) {
			addCriterion("ICON_NAME between", value1, value2, "iconName");
			return (Criteria) this;
		}

		public Criteria andIconNameNotBetween(String value1, String value2) {
			addCriterion("ICON_NAME not between", value1, value2, "iconName");
			return (Criteria) this;
		}

		public Criteria andResIdIsNull() {
			addCriterion("RES_ID is null");
			return (Criteria) this;
		}

		public Criteria andResIdIsNotNull() {
			addCriterion("RES_ID is not null");
			return (Criteria) this;
		}

		public Criteria andResIdEqualTo(String value) {
			addCriterion("RES_ID =", value, "resId");
			return (Criteria) this;
		}

		public Criteria andResIdNotEqualTo(String value) {
			addCriterion("RES_ID <>", value, "resId");
			return (Criteria) this;
		}

		public Criteria andResIdGreaterThan(String value) {
			addCriterion("RES_ID >", value, "resId");
			return (Criteria) this;
		}

		public Criteria andResIdGreaterThanOrEqualTo(String value) {
			addCriterion("RES_ID >=", value, "resId");
			return (Criteria) this;
		}

		public Criteria andResIdLessThan(String value) {
			addCriterion("RES_ID <", value, "resId");
			return (Criteria) this;
		}

		public Criteria andResIdLessThanOrEqualTo(String value) {
			addCriterion("RES_ID <=", value, "resId");
			return (Criteria) this;
		}

		public Criteria andResIdLike(String value) {
			addCriterion("RES_ID like", value, "resId");
			return (Criteria) this;
		}

		public Criteria andResIdNotLike(String value) {
			addCriterion("RES_ID not like", value, "resId");
			return (Criteria) this;
		}

		public Criteria andResIdIn(List<String> values) {
			addCriterion("RES_ID in", values, "resId");
			return (Criteria) this;
		}

		public Criteria andResIdNotIn(List<String> values) {
			addCriterion("RES_ID not in", values, "resId");
			return (Criteria) this;
		}

		public Criteria andResIdBetween(String value1, String value2) {
			addCriterion("RES_ID between", value1, value2, "resId");
			return (Criteria) this;
		}

		public Criteria andResIdNotBetween(String value1, String value2) {
			addCriterion("RES_ID not between", value1, value2, "resId");
			return (Criteria) this;
		}

		public Criteria andRelResIdIsNull() {
			addCriterion("REL_RES_ID is null");
			return (Criteria) this;
		}

		public Criteria andRelResIdIsNotNull() {
			addCriterion("REL_RES_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRelResIdEqualTo(String value) {
			addCriterion("REL_RES_ID =", value, "relResId");
			return (Criteria) this;
		}

		public Criteria andRelResIdNotEqualTo(String value) {
			addCriterion("REL_RES_ID <>", value, "relResId");
			return (Criteria) this;
		}

		public Criteria andRelResIdGreaterThan(String value) {
			addCriterion("REL_RES_ID >", value, "relResId");
			return (Criteria) this;
		}

		public Criteria andRelResIdGreaterThanOrEqualTo(String value) {
			addCriterion("REL_RES_ID >=", value, "relResId");
			return (Criteria) this;
		}

		public Criteria andRelResIdLessThan(String value) {
			addCriterion("REL_RES_ID <", value, "relResId");
			return (Criteria) this;
		}

		public Criteria andRelResIdLessThanOrEqualTo(String value) {
			addCriterion("REL_RES_ID <=", value, "relResId");
			return (Criteria) this;
		}

		public Criteria andRelResIdLike(String value) {
			addCriterion("REL_RES_ID like", value, "relResId");
			return (Criteria) this;
		}

		public Criteria andRelResIdNotLike(String value) {
			addCriterion("REL_RES_ID not like", value, "relResId");
			return (Criteria) this;
		}

		public Criteria andRelResIdIn(List<String> values) {
			addCriterion("REL_RES_ID in", values, "relResId");
			return (Criteria) this;
		}

		public Criteria andRelResIdNotIn(List<String> values) {
			addCriterion("REL_RES_ID not in", values, "relResId");
			return (Criteria) this;
		}

		public Criteria andRelResIdBetween(String value1, String value2) {
			addCriterion("REL_RES_ID between", value1, value2, "relResId");
			return (Criteria) this;
		}

		public Criteria andRelResIdNotBetween(String value1, String value2) {
			addCriterion("REL_RES_ID not between", value1, value2, "relResId");
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