package com.dpm.db.common.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TModelDisplayParamExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TModelDisplayParamExample() {
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

		public Criteria andNameIsNull() {
			addCriterion("NAME is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("NAME is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("NAME =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("NAME <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("NAME >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("NAME >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("NAME <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("NAME <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("NAME like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("NAME not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("NAME in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("NAME not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("NAME between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("NAME not between", value1, value2, "name");
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

		public Criteria andDispayRateIsNull() {
			addCriterion("DISPAY_RATE is null");
			return (Criteria) this;
		}

		public Criteria andDispayRateIsNotNull() {
			addCriterion("DISPAY_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andDispayRateEqualTo(String value) {
			addCriterion("DISPAY_RATE =", value, "dispayRate");
			return (Criteria) this;
		}

		public Criteria andDispayRateNotEqualTo(String value) {
			addCriterion("DISPAY_RATE <>", value, "dispayRate");
			return (Criteria) this;
		}

		public Criteria andDispayRateGreaterThan(String value) {
			addCriterion("DISPAY_RATE >", value, "dispayRate");
			return (Criteria) this;
		}

		public Criteria andDispayRateGreaterThanOrEqualTo(String value) {
			addCriterion("DISPAY_RATE >=", value, "dispayRate");
			return (Criteria) this;
		}

		public Criteria andDispayRateLessThan(String value) {
			addCriterion("DISPAY_RATE <", value, "dispayRate");
			return (Criteria) this;
		}

		public Criteria andDispayRateLessThanOrEqualTo(String value) {
			addCriterion("DISPAY_RATE <=", value, "dispayRate");
			return (Criteria) this;
		}

		public Criteria andDispayRateLike(String value) {
			addCriterion("DISPAY_RATE like", value, "dispayRate");
			return (Criteria) this;
		}

		public Criteria andDispayRateNotLike(String value) {
			addCriterion("DISPAY_RATE not like", value, "dispayRate");
			return (Criteria) this;
		}

		public Criteria andDispayRateIn(List<String> values) {
			addCriterion("DISPAY_RATE in", values, "dispayRate");
			return (Criteria) this;
		}

		public Criteria andDispayRateNotIn(List<String> values) {
			addCriterion("DISPAY_RATE not in", values, "dispayRate");
			return (Criteria) this;
		}

		public Criteria andDispayRateBetween(String value1, String value2) {
			addCriterion("DISPAY_RATE between", value1, value2, "dispayRate");
			return (Criteria) this;
		}

		public Criteria andDispayRateNotBetween(String value1, String value2) {
			addCriterion("DISPAY_RATE not between", value1, value2, "dispayRate");
			return (Criteria) this;
		}

		public Criteria andXIsNull() {
			addCriterion("X is null");
			return (Criteria) this;
		}

		public Criteria andXIsNotNull() {
			addCriterion("X is not null");
			return (Criteria) this;
		}

		public Criteria andXEqualTo(BigDecimal value) {
			addCriterion("X =", value, "x");
			return (Criteria) this;
		}

		public Criteria andXNotEqualTo(BigDecimal value) {
			addCriterion("X <>", value, "x");
			return (Criteria) this;
		}

		public Criteria andXGreaterThan(BigDecimal value) {
			addCriterion("X >", value, "x");
			return (Criteria) this;
		}

		public Criteria andXGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("X >=", value, "x");
			return (Criteria) this;
		}

		public Criteria andXLessThan(BigDecimal value) {
			addCriterion("X <", value, "x");
			return (Criteria) this;
		}

		public Criteria andXLessThanOrEqualTo(BigDecimal value) {
			addCriterion("X <=", value, "x");
			return (Criteria) this;
		}

		public Criteria andXIn(List<BigDecimal> values) {
			addCriterion("X in", values, "x");
			return (Criteria) this;
		}

		public Criteria andXNotIn(List<BigDecimal> values) {
			addCriterion("X not in", values, "x");
			return (Criteria) this;
		}

		public Criteria andXBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("X between", value1, value2, "x");
			return (Criteria) this;
		}

		public Criteria andXNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("X not between", value1, value2, "x");
			return (Criteria) this;
		}

		public Criteria andYIsNull() {
			addCriterion("Y is null");
			return (Criteria) this;
		}

		public Criteria andYIsNotNull() {
			addCriterion("Y is not null");
			return (Criteria) this;
		}

		public Criteria andYEqualTo(BigDecimal value) {
			addCriterion("Y =", value, "y");
			return (Criteria) this;
		}

		public Criteria andYNotEqualTo(BigDecimal value) {
			addCriterion("Y <>", value, "y");
			return (Criteria) this;
		}

		public Criteria andYGreaterThan(BigDecimal value) {
			addCriterion("Y >", value, "y");
			return (Criteria) this;
		}

		public Criteria andYGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("Y >=", value, "y");
			return (Criteria) this;
		}

		public Criteria andYLessThan(BigDecimal value) {
			addCriterion("Y <", value, "y");
			return (Criteria) this;
		}

		public Criteria andYLessThanOrEqualTo(BigDecimal value) {
			addCriterion("Y <=", value, "y");
			return (Criteria) this;
		}

		public Criteria andYIn(List<BigDecimal> values) {
			addCriterion("Y in", values, "y");
			return (Criteria) this;
		}

		public Criteria andYNotIn(List<BigDecimal> values) {
			addCriterion("Y not in", values, "y");
			return (Criteria) this;
		}

		public Criteria andYBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("Y between", value1, value2, "y");
			return (Criteria) this;
		}

		public Criteria andYNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("Y not between", value1, value2, "y");
			return (Criteria) this;
		}

		public Criteria andZIsNull() {
			addCriterion("Z is null");
			return (Criteria) this;
		}

		public Criteria andZIsNotNull() {
			addCriterion("Z is not null");
			return (Criteria) this;
		}

		public Criteria andZEqualTo(BigDecimal value) {
			addCriterion("Z =", value, "z");
			return (Criteria) this;
		}

		public Criteria andZNotEqualTo(BigDecimal value) {
			addCriterion("Z <>", value, "z");
			return (Criteria) this;
		}

		public Criteria andZGreaterThan(BigDecimal value) {
			addCriterion("Z >", value, "z");
			return (Criteria) this;
		}

		public Criteria andZGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("Z >=", value, "z");
			return (Criteria) this;
		}

		public Criteria andZLessThan(BigDecimal value) {
			addCriterion("Z <", value, "z");
			return (Criteria) this;
		}

		public Criteria andZLessThanOrEqualTo(BigDecimal value) {
			addCriterion("Z <=", value, "z");
			return (Criteria) this;
		}

		public Criteria andZIn(List<BigDecimal> values) {
			addCriterion("Z in", values, "z");
			return (Criteria) this;
		}

		public Criteria andZNotIn(List<BigDecimal> values) {
			addCriterion("Z not in", values, "z");
			return (Criteria) this;
		}

		public Criteria andZBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("Z between", value1, value2, "z");
			return (Criteria) this;
		}

		public Criteria andZNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("Z not between", value1, value2, "z");
			return (Criteria) this;
		}

		public Criteria andRotationxIsNull() {
			addCriterion("ROTATIONX is null");
			return (Criteria) this;
		}

		public Criteria andRotationxIsNotNull() {
			addCriterion("ROTATIONX is not null");
			return (Criteria) this;
		}

		public Criteria andRotationxEqualTo(BigDecimal value) {
			addCriterion("ROTATIONX =", value, "rotationx");
			return (Criteria) this;
		}

		public Criteria andRotationxNotEqualTo(BigDecimal value) {
			addCriterion("ROTATIONX <>", value, "rotationx");
			return (Criteria) this;
		}

		public Criteria andRotationxGreaterThan(BigDecimal value) {
			addCriterion("ROTATIONX >", value, "rotationx");
			return (Criteria) this;
		}

		public Criteria andRotationxGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ROTATIONX >=", value, "rotationx");
			return (Criteria) this;
		}

		public Criteria andRotationxLessThan(BigDecimal value) {
			addCriterion("ROTATIONX <", value, "rotationx");
			return (Criteria) this;
		}

		public Criteria andRotationxLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ROTATIONX <=", value, "rotationx");
			return (Criteria) this;
		}

		public Criteria andRotationxIn(List<BigDecimal> values) {
			addCriterion("ROTATIONX in", values, "rotationx");
			return (Criteria) this;
		}

		public Criteria andRotationxNotIn(List<BigDecimal> values) {
			addCriterion("ROTATIONX not in", values, "rotationx");
			return (Criteria) this;
		}

		public Criteria andRotationxBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ROTATIONX between", value1, value2, "rotationx");
			return (Criteria) this;
		}

		public Criteria andRotationxNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ROTATIONX not between", value1, value2, "rotationx");
			return (Criteria) this;
		}

		public Criteria andRotationyIsNull() {
			addCriterion("ROTATIONY is null");
			return (Criteria) this;
		}

		public Criteria andRotationyIsNotNull() {
			addCriterion("ROTATIONY is not null");
			return (Criteria) this;
		}

		public Criteria andRotationyEqualTo(BigDecimal value) {
			addCriterion("ROTATIONY =", value, "rotationy");
			return (Criteria) this;
		}

		public Criteria andRotationyNotEqualTo(BigDecimal value) {
			addCriterion("ROTATIONY <>", value, "rotationy");
			return (Criteria) this;
		}

		public Criteria andRotationyGreaterThan(BigDecimal value) {
			addCriterion("ROTATIONY >", value, "rotationy");
			return (Criteria) this;
		}

		public Criteria andRotationyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ROTATIONY >=", value, "rotationy");
			return (Criteria) this;
		}

		public Criteria andRotationyLessThan(BigDecimal value) {
			addCriterion("ROTATIONY <", value, "rotationy");
			return (Criteria) this;
		}

		public Criteria andRotationyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ROTATIONY <=", value, "rotationy");
			return (Criteria) this;
		}

		public Criteria andRotationyIn(List<BigDecimal> values) {
			addCriterion("ROTATIONY in", values, "rotationy");
			return (Criteria) this;
		}

		public Criteria andRotationyNotIn(List<BigDecimal> values) {
			addCriterion("ROTATIONY not in", values, "rotationy");
			return (Criteria) this;
		}

		public Criteria andRotationyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ROTATIONY between", value1, value2, "rotationy");
			return (Criteria) this;
		}

		public Criteria andRotationyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ROTATIONY not between", value1, value2, "rotationy");
			return (Criteria) this;
		}

		public Criteria andRotationzIsNull() {
			addCriterion("ROTATIONZ is null");
			return (Criteria) this;
		}

		public Criteria andRotationzIsNotNull() {
			addCriterion("ROTATIONZ is not null");
			return (Criteria) this;
		}

		public Criteria andRotationzEqualTo(BigDecimal value) {
			addCriterion("ROTATIONZ =", value, "rotationz");
			return (Criteria) this;
		}

		public Criteria andRotationzNotEqualTo(BigDecimal value) {
			addCriterion("ROTATIONZ <>", value, "rotationz");
			return (Criteria) this;
		}

		public Criteria andRotationzGreaterThan(BigDecimal value) {
			addCriterion("ROTATIONZ >", value, "rotationz");
			return (Criteria) this;
		}

		public Criteria andRotationzGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ROTATIONZ >=", value, "rotationz");
			return (Criteria) this;
		}

		public Criteria andRotationzLessThan(BigDecimal value) {
			addCriterion("ROTATIONZ <", value, "rotationz");
			return (Criteria) this;
		}

		public Criteria andRotationzLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ROTATIONZ <=", value, "rotationz");
			return (Criteria) this;
		}

		public Criteria andRotationzIn(List<BigDecimal> values) {
			addCriterion("ROTATIONZ in", values, "rotationz");
			return (Criteria) this;
		}

		public Criteria andRotationzNotIn(List<BigDecimal> values) {
			addCriterion("ROTATIONZ not in", values, "rotationz");
			return (Criteria) this;
		}

		public Criteria andRotationzBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ROTATIONZ between", value1, value2, "rotationz");
			return (Criteria) this;
		}

		public Criteria andRotationzNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ROTATIONZ not between", value1, value2, "rotationz");
			return (Criteria) this;
		}

		public Criteria andScaleIsNull() {
			addCriterion("SCALE is null");
			return (Criteria) this;
		}

		public Criteria andScaleIsNotNull() {
			addCriterion("SCALE is not null");
			return (Criteria) this;
		}

		public Criteria andScaleEqualTo(BigDecimal value) {
			addCriterion("SCALE =", value, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleNotEqualTo(BigDecimal value) {
			addCriterion("SCALE <>", value, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleGreaterThan(BigDecimal value) {
			addCriterion("SCALE >", value, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SCALE >=", value, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleLessThan(BigDecimal value) {
			addCriterion("SCALE <", value, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SCALE <=", value, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleIn(List<BigDecimal> values) {
			addCriterion("SCALE in", values, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleNotIn(List<BigDecimal> values) {
			addCriterion("SCALE not in", values, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SCALE between", value1, value2, "scale");
			return (Criteria) this;
		}

		public Criteria andScaleNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SCALE not between", value1, value2, "scale");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNull() {
			addCriterion("DESCRIPTION is null");
			return (Criteria) this;
		}

		public Criteria andDescriptionIsNotNull() {
			addCriterion("DESCRIPTION is not null");
			return (Criteria) this;
		}

		public Criteria andDescriptionEqualTo(String value) {
			addCriterion("DESCRIPTION =", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotEqualTo(String value) {
			addCriterion("DESCRIPTION <>", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThan(String value) {
			addCriterion("DESCRIPTION >", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("DESCRIPTION >=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThan(String value) {
			addCriterion("DESCRIPTION <", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLessThanOrEqualTo(String value) {
			addCriterion("DESCRIPTION <=", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionLike(String value) {
			addCriterion("DESCRIPTION like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotLike(String value) {
			addCriterion("DESCRIPTION not like", value, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionIn(List<String> values) {
			addCriterion("DESCRIPTION in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotIn(List<String> values) {
			addCriterion("DESCRIPTION not in", values, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionBetween(String value1, String value2) {
			addCriterion("DESCRIPTION between", value1, value2, "description");
			return (Criteria) this;
		}

		public Criteria andDescriptionNotBetween(String value1, String value2) {
			addCriterion("DESCRIPTION not between", value1, value2, "description");
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