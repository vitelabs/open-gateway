package org.vite.gateway.database.po.generated;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.vite.gateway.model.enums.DepositAddressState;

public class DepositAddressCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepositAddressCriteria() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOriginBlockchainIsNull() {
            addCriterion("origin_blockchain is null");
            return (Criteria) this;
        }

        public Criteria andOriginBlockchainIsNotNull() {
            addCriterion("origin_blockchain is not null");
            return (Criteria) this;
        }

        public Criteria andOriginBlockchainEqualTo(String value) {
            addCriterion("origin_blockchain =", value, "originBlockchain");
            return (Criteria) this;
        }

        public Criteria andOriginBlockchainNotEqualTo(String value) {
            addCriterion("origin_blockchain <>", value, "originBlockchain");
            return (Criteria) this;
        }

        public Criteria andOriginBlockchainGreaterThan(String value) {
            addCriterion("origin_blockchain >", value, "originBlockchain");
            return (Criteria) this;
        }

        public Criteria andOriginBlockchainGreaterThanOrEqualTo(String value) {
            addCriterion("origin_blockchain >=", value, "originBlockchain");
            return (Criteria) this;
        }

        public Criteria andOriginBlockchainLessThan(String value) {
            addCriterion("origin_blockchain <", value, "originBlockchain");
            return (Criteria) this;
        }

        public Criteria andOriginBlockchainLessThanOrEqualTo(String value) {
            addCriterion("origin_blockchain <=", value, "originBlockchain");
            return (Criteria) this;
        }

        public Criteria andOriginBlockchainLike(String value) {
            addCriterion("origin_blockchain like", value, "originBlockchain");
            return (Criteria) this;
        }

        public Criteria andOriginBlockchainNotLike(String value) {
            addCriterion("origin_blockchain not like", value, "originBlockchain");
            return (Criteria) this;
        }

        public Criteria andOriginBlockchainIn(List<String> values) {
            addCriterion("origin_blockchain in", values, "originBlockchain");
            return (Criteria) this;
        }

        public Criteria andOriginBlockchainNotIn(List<String> values) {
            addCriterion("origin_blockchain not in", values, "originBlockchain");
            return (Criteria) this;
        }

        public Criteria andOriginBlockchainBetween(String value1, String value2) {
            addCriterion("origin_blockchain between", value1, value2, "originBlockchain");
            return (Criteria) this;
        }

        public Criteria andOriginBlockchainNotBetween(String value1, String value2) {
            addCriterion("origin_blockchain not between", value1, value2, "originBlockchain");
            return (Criteria) this;
        }

        public Criteria andOriginAddressIsNull() {
            addCriterion("origin_address is null");
            return (Criteria) this;
        }

        public Criteria andOriginAddressIsNotNull() {
            addCriterion("origin_address is not null");
            return (Criteria) this;
        }

        public Criteria andOriginAddressEqualTo(String value) {
            addCriterion("origin_address =", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressNotEqualTo(String value) {
            addCriterion("origin_address <>", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressGreaterThan(String value) {
            addCriterion("origin_address >", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressGreaterThanOrEqualTo(String value) {
            addCriterion("origin_address >=", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressLessThan(String value) {
            addCriterion("origin_address <", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressLessThanOrEqualTo(String value) {
            addCriterion("origin_address <=", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressLike(String value) {
            addCriterion("origin_address like", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressNotLike(String value) {
            addCriterion("origin_address not like", value, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressIn(List<String> values) {
            addCriterion("origin_address in", values, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressNotIn(List<String> values) {
            addCriterion("origin_address not in", values, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressBetween(String value1, String value2) {
            addCriterion("origin_address between", value1, value2, "originAddress");
            return (Criteria) this;
        }

        public Criteria andOriginAddressNotBetween(String value1, String value2) {
            addCriterion("origin_address not between", value1, value2, "originAddress");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMappingBlockchainIsNull() {
            addCriterion("mapping_blockchain is null");
            return (Criteria) this;
        }

        public Criteria andMappingBlockchainIsNotNull() {
            addCriterion("mapping_blockchain is not null");
            return (Criteria) this;
        }

        public Criteria andMappingBlockchainEqualTo(String value) {
            addCriterion("mapping_blockchain =", value, "mappingBlockchain");
            return (Criteria) this;
        }

        public Criteria andMappingBlockchainNotEqualTo(String value) {
            addCriterion("mapping_blockchain <>", value, "mappingBlockchain");
            return (Criteria) this;
        }

        public Criteria andMappingBlockchainGreaterThan(String value) {
            addCriterion("mapping_blockchain >", value, "mappingBlockchain");
            return (Criteria) this;
        }

        public Criteria andMappingBlockchainGreaterThanOrEqualTo(String value) {
            addCriterion("mapping_blockchain >=", value, "mappingBlockchain");
            return (Criteria) this;
        }

        public Criteria andMappingBlockchainLessThan(String value) {
            addCriterion("mapping_blockchain <", value, "mappingBlockchain");
            return (Criteria) this;
        }

        public Criteria andMappingBlockchainLessThanOrEqualTo(String value) {
            addCriterion("mapping_blockchain <=", value, "mappingBlockchain");
            return (Criteria) this;
        }

        public Criteria andMappingBlockchainLike(String value) {
            addCriterion("mapping_blockchain like", value, "mappingBlockchain");
            return (Criteria) this;
        }

        public Criteria andMappingBlockchainNotLike(String value) {
            addCriterion("mapping_blockchain not like", value, "mappingBlockchain");
            return (Criteria) this;
        }

        public Criteria andMappingBlockchainIn(List<String> values) {
            addCriterion("mapping_blockchain in", values, "mappingBlockchain");
            return (Criteria) this;
        }

        public Criteria andMappingBlockchainNotIn(List<String> values) {
            addCriterion("mapping_blockchain not in", values, "mappingBlockchain");
            return (Criteria) this;
        }

        public Criteria andMappingBlockchainBetween(String value1, String value2) {
            addCriterion("mapping_blockchain between", value1, value2, "mappingBlockchain");
            return (Criteria) this;
        }

        public Criteria andMappingBlockchainNotBetween(String value1, String value2) {
            addCriterion("mapping_blockchain not between", value1, value2, "mappingBlockchain");
            return (Criteria) this;
        }

        public Criteria andMappingAddressIsNull() {
            addCriterion("mapping_address is null");
            return (Criteria) this;
        }

        public Criteria andMappingAddressIsNotNull() {
            addCriterion("mapping_address is not null");
            return (Criteria) this;
        }

        public Criteria andMappingAddressEqualTo(String value) {
            addCriterion("mapping_address =", value, "mappingAddress");
            return (Criteria) this;
        }

        public Criteria andMappingAddressNotEqualTo(String value) {
            addCriterion("mapping_address <>", value, "mappingAddress");
            return (Criteria) this;
        }

        public Criteria andMappingAddressGreaterThan(String value) {
            addCriterion("mapping_address >", value, "mappingAddress");
            return (Criteria) this;
        }

        public Criteria andMappingAddressGreaterThanOrEqualTo(String value) {
            addCriterion("mapping_address >=", value, "mappingAddress");
            return (Criteria) this;
        }

        public Criteria andMappingAddressLessThan(String value) {
            addCriterion("mapping_address <", value, "mappingAddress");
            return (Criteria) this;
        }

        public Criteria andMappingAddressLessThanOrEqualTo(String value) {
            addCriterion("mapping_address <=", value, "mappingAddress");
            return (Criteria) this;
        }

        public Criteria andMappingAddressLike(String value) {
            addCriterion("mapping_address like", value, "mappingAddress");
            return (Criteria) this;
        }

        public Criteria andMappingAddressNotLike(String value) {
            addCriterion("mapping_address not like", value, "mappingAddress");
            return (Criteria) this;
        }

        public Criteria andMappingAddressIn(List<String> values) {
            addCriterion("mapping_address in", values, "mappingAddress");
            return (Criteria) this;
        }

        public Criteria andMappingAddressNotIn(List<String> values) {
            addCriterion("mapping_address not in", values, "mappingAddress");
            return (Criteria) this;
        }

        public Criteria andMappingAddressBetween(String value1, String value2) {
            addCriterion("mapping_address between", value1, value2, "mappingAddress");
            return (Criteria) this;
        }

        public Criteria andMappingAddressNotBetween(String value1, String value2) {
            addCriterion("mapping_address not between", value1, value2, "mappingAddress");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(DepositAddressState value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(DepositAddressState value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(DepositAddressState value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(DepositAddressState value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(DepositAddressState value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(DepositAddressState value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(DepositAddressState value) {
            addCriterion("`state` like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(DepositAddressState value) {
            addCriterion("`state` not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<DepositAddressState> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<DepositAddressState> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(DepositAddressState value1, DepositAddressState value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(DepositAddressState value1, DepositAddressState value2) {
            addCriterion("`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNull() {
            addCriterion("utime is null");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNotNull() {
            addCriterion("utime is not null");
            return (Criteria) this;
        }

        public Criteria andUtimeEqualTo(Date value) {
            addCriterion("utime =", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotEqualTo(Date value) {
            addCriterion("utime <>", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThan(Date value) {
            addCriterion("utime >", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("utime >=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThan(Date value) {
            addCriterion("utime <", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThanOrEqualTo(Date value) {
            addCriterion("utime <=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeIn(List<Date> values) {
            addCriterion("utime in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotIn(List<Date> values) {
            addCriterion("utime not in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeBetween(Date value1, Date value2) {
            addCriterion("utime between", value1, value2, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotBetween(Date value1, Date value2) {
            addCriterion("utime not between", value1, value2, "utime");
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