package com.dpm.db.common.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class TPatientTalkExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TPatientTalkExample() {
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

		public Criteria andTalkNameIsNull() {
			addCriterion("TALK_NAME is null");
			return (Criteria) this;
		}

		public Criteria andTalkNameIsNotNull() {
			addCriterion("TALK_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andTalkNameEqualTo(String value) {
			addCriterion("TALK_NAME =", value, "talkName");
			return (Criteria) this;
		}

		public Criteria andTalkNameNotEqualTo(String value) {
			addCriterion("TALK_NAME <>", value, "talkName");
			return (Criteria) this;
		}

		public Criteria andTalkNameGreaterThan(String value) {
			addCriterion("TALK_NAME >", value, "talkName");
			return (Criteria) this;
		}

		public Criteria andTalkNameGreaterThanOrEqualTo(String value) {
			addCriterion("TALK_NAME >=", value, "talkName");
			return (Criteria) this;
		}

		public Criteria andTalkNameLessThan(String value) {
			addCriterion("TALK_NAME <", value, "talkName");
			return (Criteria) this;
		}

		public Criteria andTalkNameLessThanOrEqualTo(String value) {
			addCriterion("TALK_NAME <=", value, "talkName");
			return (Criteria) this;
		}

		public Criteria andTalkNameLike(String value) {
			addCriterion("TALK_NAME like", value, "talkName");
			return (Criteria) this;
		}

		public Criteria andTalkNameNotLike(String value) {
			addCriterion("TALK_NAME not like", value, "talkName");
			return (Criteria) this;
		}

		public Criteria andTalkNameIn(List<String> values) {
			addCriterion("TALK_NAME in", values, "talkName");
			return (Criteria) this;
		}

		public Criteria andTalkNameNotIn(List<String> values) {
			addCriterion("TALK_NAME not in", values, "talkName");
			return (Criteria) this;
		}

		public Criteria andTalkNameBetween(String value1, String value2) {
			addCriterion("TALK_NAME between", value1, value2, "talkName");
			return (Criteria) this;
		}

		public Criteria andTalkNameNotBetween(String value1, String value2) {
			addCriterion("TALK_NAME not between", value1, value2, "talkName");
			return (Criteria) this;
		}

		public Criteria andRelationshipIdIsNull() {
			addCriterion("RELATIONSHIP_ID is null");
			return (Criteria) this;
		}

		public Criteria andRelationshipIdIsNotNull() {
			addCriterion("RELATIONSHIP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRelationshipIdEqualTo(String value) {
			addCriterion("RELATIONSHIP_ID =", value, "relationshipId");
			return (Criteria) this;
		}

		public Criteria andRelationshipIdNotEqualTo(String value) {
			addCriterion("RELATIONSHIP_ID <>", value, "relationshipId");
			return (Criteria) this;
		}

		public Criteria andRelationshipIdGreaterThan(String value) {
			addCriterion("RELATIONSHIP_ID >", value, "relationshipId");
			return (Criteria) this;
		}

		public Criteria andRelationshipIdGreaterThanOrEqualTo(String value) {
			addCriterion("RELATIONSHIP_ID >=", value, "relationshipId");
			return (Criteria) this;
		}

		public Criteria andRelationshipIdLessThan(String value) {
			addCriterion("RELATIONSHIP_ID <", value, "relationshipId");
			return (Criteria) this;
		}

		public Criteria andRelationshipIdLessThanOrEqualTo(String value) {
			addCriterion("RELATIONSHIP_ID <=", value, "relationshipId");
			return (Criteria) this;
		}

		public Criteria andRelationshipIdLike(String value) {
			addCriterion("RELATIONSHIP_ID like", value, "relationshipId");
			return (Criteria) this;
		}

		public Criteria andRelationshipIdNotLike(String value) {
			addCriterion("RELATIONSHIP_ID not like", value, "relationshipId");
			return (Criteria) this;
		}

		public Criteria andRelationshipIdIn(List<String> values) {
			addCriterion("RELATIONSHIP_ID in", values, "relationshipId");
			return (Criteria) this;
		}

		public Criteria andRelationshipIdNotIn(List<String> values) {
			addCriterion("RELATIONSHIP_ID not in", values, "relationshipId");
			return (Criteria) this;
		}

		public Criteria andRelationshipIdBetween(String value1, String value2) {
			addCriterion("RELATIONSHIP_ID between", value1, value2, "relationshipId");
			return (Criteria) this;
		}

		public Criteria andRelationshipIdNotBetween(String value1, String value2) {
			addCriterion("RELATIONSHIP_ID not between", value1, value2, "relationshipId");
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

		public Criteria andIdNoIsNull() {
			addCriterion("ID_NO is null");
			return (Criteria) this;
		}

		public Criteria andIdNoIsNotNull() {
			addCriterion("ID_NO is not null");
			return (Criteria) this;
		}

		public Criteria andIdNoEqualTo(String value) {
			addCriterion("ID_NO =", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoNotEqualTo(String value) {
			addCriterion("ID_NO <>", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoGreaterThan(String value) {
			addCriterion("ID_NO >", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoGreaterThanOrEqualTo(String value) {
			addCriterion("ID_NO >=", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoLessThan(String value) {
			addCriterion("ID_NO <", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoLessThanOrEqualTo(String value) {
			addCriterion("ID_NO <=", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoLike(String value) {
			addCriterion("ID_NO like", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoNotLike(String value) {
			addCriterion("ID_NO not like", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoIn(List<String> values) {
			addCriterion("ID_NO in", values, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoNotIn(List<String> values) {
			addCriterion("ID_NO not in", values, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoBetween(String value1, String value2) {
			addCriterion("ID_NO between", value1, value2, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoNotBetween(String value1, String value2) {
			addCriterion("ID_NO not between", value1, value2, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdFilePathIsNull() {
			addCriterion("ID_FILE_PATH is null");
			return (Criteria) this;
		}

		public Criteria andIdFilePathIsNotNull() {
			addCriterion("ID_FILE_PATH is not null");
			return (Criteria) this;
		}

		public Criteria andIdFilePathEqualTo(String value) {
			addCriterion("ID_FILE_PATH =", value, "idFilePath");
			return (Criteria) this;
		}

		public Criteria andIdFilePathNotEqualTo(String value) {
			addCriterion("ID_FILE_PATH <>", value, "idFilePath");
			return (Criteria) this;
		}

		public Criteria andIdFilePathGreaterThan(String value) {
			addCriterion("ID_FILE_PATH >", value, "idFilePath");
			return (Criteria) this;
		}

		public Criteria andIdFilePathGreaterThanOrEqualTo(String value) {
			addCriterion("ID_FILE_PATH >=", value, "idFilePath");
			return (Criteria) this;
		}

		public Criteria andIdFilePathLessThan(String value) {
			addCriterion("ID_FILE_PATH <", value, "idFilePath");
			return (Criteria) this;
		}

		public Criteria andIdFilePathLessThanOrEqualTo(String value) {
			addCriterion("ID_FILE_PATH <=", value, "idFilePath");
			return (Criteria) this;
		}

		public Criteria andIdFilePathLike(String value) {
			addCriterion("ID_FILE_PATH like", value, "idFilePath");
			return (Criteria) this;
		}

		public Criteria andIdFilePathNotLike(String value) {
			addCriterion("ID_FILE_PATH not like", value, "idFilePath");
			return (Criteria) this;
		}

		public Criteria andIdFilePathIn(List<String> values) {
			addCriterion("ID_FILE_PATH in", values, "idFilePath");
			return (Criteria) this;
		}

		public Criteria andIdFilePathNotIn(List<String> values) {
			addCriterion("ID_FILE_PATH not in", values, "idFilePath");
			return (Criteria) this;
		}

		public Criteria andIdFilePathBetween(String value1, String value2) {
			addCriterion("ID_FILE_PATH between", value1, value2, "idFilePath");
			return (Criteria) this;
		}

		public Criteria andIdFilePathNotBetween(String value1, String value2) {
			addCriterion("ID_FILE_PATH not between", value1, value2, "idFilePath");
			return (Criteria) this;
		}

		public Criteria andIdFileNameIsNull() {
			addCriterion("ID_FILE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andIdFileNameIsNotNull() {
			addCriterion("ID_FILE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andIdFileNameEqualTo(String value) {
			addCriterion("ID_FILE_NAME =", value, "idFileName");
			return (Criteria) this;
		}

		public Criteria andIdFileNameNotEqualTo(String value) {
			addCriterion("ID_FILE_NAME <>", value, "idFileName");
			return (Criteria) this;
		}

		public Criteria andIdFileNameGreaterThan(String value) {
			addCriterion("ID_FILE_NAME >", value, "idFileName");
			return (Criteria) this;
		}

		public Criteria andIdFileNameGreaterThanOrEqualTo(String value) {
			addCriterion("ID_FILE_NAME >=", value, "idFileName");
			return (Criteria) this;
		}

		public Criteria andIdFileNameLessThan(String value) {
			addCriterion("ID_FILE_NAME <", value, "idFileName");
			return (Criteria) this;
		}

		public Criteria andIdFileNameLessThanOrEqualTo(String value) {
			addCriterion("ID_FILE_NAME <=", value, "idFileName");
			return (Criteria) this;
		}

		public Criteria andIdFileNameLike(String value) {
			addCriterion("ID_FILE_NAME like", value, "idFileName");
			return (Criteria) this;
		}

		public Criteria andIdFileNameNotLike(String value) {
			addCriterion("ID_FILE_NAME not like", value, "idFileName");
			return (Criteria) this;
		}

		public Criteria andIdFileNameIn(List<String> values) {
			addCriterion("ID_FILE_NAME in", values, "idFileName");
			return (Criteria) this;
		}

		public Criteria andIdFileNameNotIn(List<String> values) {
			addCriterion("ID_FILE_NAME not in", values, "idFileName");
			return (Criteria) this;
		}

		public Criteria andIdFileNameBetween(String value1, String value2) {
			addCriterion("ID_FILE_NAME between", value1, value2, "idFileName");
			return (Criteria) this;
		}

		public Criteria andIdFileNameNotBetween(String value1, String value2) {
			addCriterion("ID_FILE_NAME not between", value1, value2, "idFileName");
			return (Criteria) this;
		}

		public Criteria andRecordIdIsNull() {
			addCriterion("RECORD_ID is null");
			return (Criteria) this;
		}

		public Criteria andRecordIdIsNotNull() {
			addCriterion("RECORD_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRecordIdEqualTo(String value) {
			addCriterion("RECORD_ID =", value, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdNotEqualTo(String value) {
			addCriterion("RECORD_ID <>", value, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdGreaterThan(String value) {
			addCriterion("RECORD_ID >", value, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdGreaterThanOrEqualTo(String value) {
			addCriterion("RECORD_ID >=", value, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdLessThan(String value) {
			addCriterion("RECORD_ID <", value, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdLessThanOrEqualTo(String value) {
			addCriterion("RECORD_ID <=", value, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdLike(String value) {
			addCriterion("RECORD_ID like", value, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdNotLike(String value) {
			addCriterion("RECORD_ID not like", value, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdIn(List<String> values) {
			addCriterion("RECORD_ID in", values, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdNotIn(List<String> values) {
			addCriterion("RECORD_ID not in", values, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdBetween(String value1, String value2) {
			addCriterion("RECORD_ID between", value1, value2, "recordId");
			return (Criteria) this;
		}

		public Criteria andRecordIdNotBetween(String value1, String value2) {
			addCriterion("RECORD_ID not between", value1, value2, "recordId");
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
}