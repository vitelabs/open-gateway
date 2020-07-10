package org.vite.gateway.database.po.generated;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.vite.gateway.model.enums.DepositState;
import org.vite.gateway.model.enums.WithdrawState;

public class TokenInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TokenInfoCriteria() {
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

        public Criteria andOriginTokenIdIsNull() {
            addCriterion("origin_token_id is null");
            return (Criteria) this;
        }

        public Criteria andOriginTokenIdIsNotNull() {
            addCriterion("origin_token_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriginTokenIdEqualTo(String value) {
            addCriterion("origin_token_id =", value, "originTokenId");
            return (Criteria) this;
        }

        public Criteria andOriginTokenIdNotEqualTo(String value) {
            addCriterion("origin_token_id <>", value, "originTokenId");
            return (Criteria) this;
        }

        public Criteria andOriginTokenIdGreaterThan(String value) {
            addCriterion("origin_token_id >", value, "originTokenId");
            return (Criteria) this;
        }

        public Criteria andOriginTokenIdGreaterThanOrEqualTo(String value) {
            addCriterion("origin_token_id >=", value, "originTokenId");
            return (Criteria) this;
        }

        public Criteria andOriginTokenIdLessThan(String value) {
            addCriterion("origin_token_id <", value, "originTokenId");
            return (Criteria) this;
        }

        public Criteria andOriginTokenIdLessThanOrEqualTo(String value) {
            addCriterion("origin_token_id <=", value, "originTokenId");
            return (Criteria) this;
        }

        public Criteria andOriginTokenIdLike(String value) {
            addCriterion("origin_token_id like", value, "originTokenId");
            return (Criteria) this;
        }

        public Criteria andOriginTokenIdNotLike(String value) {
            addCriterion("origin_token_id not like", value, "originTokenId");
            return (Criteria) this;
        }

        public Criteria andOriginTokenIdIn(List<String> values) {
            addCriterion("origin_token_id in", values, "originTokenId");
            return (Criteria) this;
        }

        public Criteria andOriginTokenIdNotIn(List<String> values) {
            addCriterion("origin_token_id not in", values, "originTokenId");
            return (Criteria) this;
        }

        public Criteria andOriginTokenIdBetween(String value1, String value2) {
            addCriterion("origin_token_id between", value1, value2, "originTokenId");
            return (Criteria) this;
        }

        public Criteria andOriginTokenIdNotBetween(String value1, String value2) {
            addCriterion("origin_token_id not between", value1, value2, "originTokenId");
            return (Criteria) this;
        }

        public Criteria andMappingTokenIdIsNull() {
            addCriterion("mapping_token_id is null");
            return (Criteria) this;
        }

        public Criteria andMappingTokenIdIsNotNull() {
            addCriterion("mapping_token_id is not null");
            return (Criteria) this;
        }

        public Criteria andMappingTokenIdEqualTo(String value) {
            addCriterion("mapping_token_id =", value, "mappingTokenId");
            return (Criteria) this;
        }

        public Criteria andMappingTokenIdNotEqualTo(String value) {
            addCriterion("mapping_token_id <>", value, "mappingTokenId");
            return (Criteria) this;
        }

        public Criteria andMappingTokenIdGreaterThan(String value) {
            addCriterion("mapping_token_id >", value, "mappingTokenId");
            return (Criteria) this;
        }

        public Criteria andMappingTokenIdGreaterThanOrEqualTo(String value) {
            addCriterion("mapping_token_id >=", value, "mappingTokenId");
            return (Criteria) this;
        }

        public Criteria andMappingTokenIdLessThan(String value) {
            addCriterion("mapping_token_id <", value, "mappingTokenId");
            return (Criteria) this;
        }

        public Criteria andMappingTokenIdLessThanOrEqualTo(String value) {
            addCriterion("mapping_token_id <=", value, "mappingTokenId");
            return (Criteria) this;
        }

        public Criteria andMappingTokenIdLike(String value) {
            addCriterion("mapping_token_id like", value, "mappingTokenId");
            return (Criteria) this;
        }

        public Criteria andMappingTokenIdNotLike(String value) {
            addCriterion("mapping_token_id not like", value, "mappingTokenId");
            return (Criteria) this;
        }

        public Criteria andMappingTokenIdIn(List<String> values) {
            addCriterion("mapping_token_id in", values, "mappingTokenId");
            return (Criteria) this;
        }

        public Criteria andMappingTokenIdNotIn(List<String> values) {
            addCriterion("mapping_token_id not in", values, "mappingTokenId");
            return (Criteria) this;
        }

        public Criteria andMappingTokenIdBetween(String value1, String value2) {
            addCriterion("mapping_token_id between", value1, value2, "mappingTokenId");
            return (Criteria) this;
        }

        public Criteria andMappingTokenIdNotBetween(String value1, String value2) {
            addCriterion("mapping_token_id not between", value1, value2, "mappingTokenId");
            return (Criteria) this;
        }

        public Criteria andTokenNameIsNull() {
            addCriterion("token_name is null");
            return (Criteria) this;
        }

        public Criteria andTokenNameIsNotNull() {
            addCriterion("token_name is not null");
            return (Criteria) this;
        }

        public Criteria andTokenNameEqualTo(String value) {
            addCriterion("token_name =", value, "tokenName");
            return (Criteria) this;
        }

        public Criteria andTokenNameNotEqualTo(String value) {
            addCriterion("token_name <>", value, "tokenName");
            return (Criteria) this;
        }

        public Criteria andTokenNameGreaterThan(String value) {
            addCriterion("token_name >", value, "tokenName");
            return (Criteria) this;
        }

        public Criteria andTokenNameGreaterThanOrEqualTo(String value) {
            addCriterion("token_name >=", value, "tokenName");
            return (Criteria) this;
        }

        public Criteria andTokenNameLessThan(String value) {
            addCriterion("token_name <", value, "tokenName");
            return (Criteria) this;
        }

        public Criteria andTokenNameLessThanOrEqualTo(String value) {
            addCriterion("token_name <=", value, "tokenName");
            return (Criteria) this;
        }

        public Criteria andTokenNameLike(String value) {
            addCriterion("token_name like", value, "tokenName");
            return (Criteria) this;
        }

        public Criteria andTokenNameNotLike(String value) {
            addCriterion("token_name not like", value, "tokenName");
            return (Criteria) this;
        }

        public Criteria andTokenNameIn(List<String> values) {
            addCriterion("token_name in", values, "tokenName");
            return (Criteria) this;
        }

        public Criteria andTokenNameNotIn(List<String> values) {
            addCriterion("token_name not in", values, "tokenName");
            return (Criteria) this;
        }

        public Criteria andTokenNameBetween(String value1, String value2) {
            addCriterion("token_name between", value1, value2, "tokenName");
            return (Criteria) this;
        }

        public Criteria andTokenNameNotBetween(String value1, String value2) {
            addCriterion("token_name not between", value1, value2, "tokenName");
            return (Criteria) this;
        }

        public Criteria andDepositStateIsNull() {
            addCriterion("deposit_state is null");
            return (Criteria) this;
        }

        public Criteria andDepositStateIsNotNull() {
            addCriterion("deposit_state is not null");
            return (Criteria) this;
        }

        public Criteria andDepositStateEqualTo(DepositState value) {
            addCriterion("deposit_state =", value, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateNotEqualTo(DepositState value) {
            addCriterion("deposit_state <>", value, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateGreaterThan(DepositState value) {
            addCriterion("deposit_state >", value, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateGreaterThanOrEqualTo(DepositState value) {
            addCriterion("deposit_state >=", value, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateLessThan(DepositState value) {
            addCriterion("deposit_state <", value, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateLessThanOrEqualTo(DepositState value) {
            addCriterion("deposit_state <=", value, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateLike(DepositState value) {
            addCriterion("deposit_state like", value, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateNotLike(DepositState value) {
            addCriterion("deposit_state not like", value, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateIn(List<DepositState> values) {
            addCriterion("deposit_state in", values, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateNotIn(List<DepositState> values) {
            addCriterion("deposit_state not in", values, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateBetween(DepositState value1, DepositState value2) {
            addCriterion("deposit_state between", value1, value2, "depositState");
            return (Criteria) this;
        }

        public Criteria andDepositStateNotBetween(DepositState value1, DepositState value2) {
            addCriterion("deposit_state not between", value1, value2, "depositState");
            return (Criteria) this;
        }

        public Criteria andWithdrawStateIsNull() {
            addCriterion("withdraw_state is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawStateIsNotNull() {
            addCriterion("withdraw_state is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawStateEqualTo(WithdrawState value) {
            addCriterion("withdraw_state =", value, "withdrawState");
            return (Criteria) this;
        }

        public Criteria andWithdrawStateNotEqualTo(WithdrawState value) {
            addCriterion("withdraw_state <>", value, "withdrawState");
            return (Criteria) this;
        }

        public Criteria andWithdrawStateGreaterThan(WithdrawState value) {
            addCriterion("withdraw_state >", value, "withdrawState");
            return (Criteria) this;
        }

        public Criteria andWithdrawStateGreaterThanOrEqualTo(WithdrawState value) {
            addCriterion("withdraw_state >=", value, "withdrawState");
            return (Criteria) this;
        }

        public Criteria andWithdrawStateLessThan(WithdrawState value) {
            addCriterion("withdraw_state <", value, "withdrawState");
            return (Criteria) this;
        }

        public Criteria andWithdrawStateLessThanOrEqualTo(WithdrawState value) {
            addCriterion("withdraw_state <=", value, "withdrawState");
            return (Criteria) this;
        }

        public Criteria andWithdrawStateLike(WithdrawState value) {
            addCriterion("withdraw_state like", value, "withdrawState");
            return (Criteria) this;
        }

        public Criteria andWithdrawStateNotLike(WithdrawState value) {
            addCriterion("withdraw_state not like", value, "withdrawState");
            return (Criteria) this;
        }

        public Criteria andWithdrawStateIn(List<WithdrawState> values) {
            addCriterion("withdraw_state in", values, "withdrawState");
            return (Criteria) this;
        }

        public Criteria andWithdrawStateNotIn(List<WithdrawState> values) {
            addCriterion("withdraw_state not in", values, "withdrawState");
            return (Criteria) this;
        }

        public Criteria andWithdrawStateBetween(WithdrawState value1, WithdrawState value2) {
            addCriterion("withdraw_state between", value1, value2, "withdrawState");
            return (Criteria) this;
        }

        public Criteria andWithdrawStateNotBetween(WithdrawState value1, WithdrawState value2) {
            addCriterion("withdraw_state not between", value1, value2, "withdrawState");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountIsNull() {
            addCriterion("min_deposit_amount is null");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountIsNotNull() {
            addCriterion("min_deposit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountEqualTo(Double value) {
            addCriterion("min_deposit_amount =", value, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountNotEqualTo(Double value) {
            addCriterion("min_deposit_amount <>", value, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountGreaterThan(Double value) {
            addCriterion("min_deposit_amount >", value, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("min_deposit_amount >=", value, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountLessThan(Double value) {
            addCriterion("min_deposit_amount <", value, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountLessThanOrEqualTo(Double value) {
            addCriterion("min_deposit_amount <=", value, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountIn(List<Double> values) {
            addCriterion("min_deposit_amount in", values, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountNotIn(List<Double> values) {
            addCriterion("min_deposit_amount not in", values, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountBetween(Double value1, Double value2) {
            addCriterion("min_deposit_amount between", value1, value2, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinDepositAmountNotBetween(Double value1, Double value2) {
            addCriterion("min_deposit_amount not between", value1, value2, "minDepositAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountIsNull() {
            addCriterion("min_withdraw_amount is null");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountIsNotNull() {
            addCriterion("min_withdraw_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountEqualTo(Double value) {
            addCriterion("min_withdraw_amount =", value, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountNotEqualTo(Double value) {
            addCriterion("min_withdraw_amount <>", value, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountGreaterThan(Double value) {
            addCriterion("min_withdraw_amount >", value, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("min_withdraw_amount >=", value, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountLessThan(Double value) {
            addCriterion("min_withdraw_amount <", value, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountLessThanOrEqualTo(Double value) {
            addCriterion("min_withdraw_amount <=", value, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountIn(List<Double> values) {
            addCriterion("min_withdraw_amount in", values, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountNotIn(List<Double> values) {
            addCriterion("min_withdraw_amount not in", values, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountBetween(Double value1, Double value2) {
            addCriterion("min_withdraw_amount between", value1, value2, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMinWithdrawAmountNotBetween(Double value1, Double value2) {
            addCriterion("min_withdraw_amount not between", value1, value2, "minWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountIsNull() {
            addCriterion("max_withdraw_amount is null");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountIsNotNull() {
            addCriterion("max_withdraw_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountEqualTo(Double value) {
            addCriterion("max_withdraw_amount =", value, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountNotEqualTo(Double value) {
            addCriterion("max_withdraw_amount <>", value, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountGreaterThan(Double value) {
            addCriterion("max_withdraw_amount >", value, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("max_withdraw_amount >=", value, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountLessThan(Double value) {
            addCriterion("max_withdraw_amount <", value, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountLessThanOrEqualTo(Double value) {
            addCriterion("max_withdraw_amount <=", value, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountIn(List<Double> values) {
            addCriterion("max_withdraw_amount in", values, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountNotIn(List<Double> values) {
            addCriterion("max_withdraw_amount not in", values, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountBetween(Double value1, Double value2) {
            addCriterion("max_withdraw_amount between", value1, value2, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andMaxWithdrawAmountNotBetween(Double value1, Double value2) {
            addCriterion("max_withdraw_amount not between", value1, value2, "maxWithdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeIsNull() {
            addCriterion("withdraw_fee is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeIsNotNull() {
            addCriterion("withdraw_fee is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeEqualTo(Double value) {
            addCriterion("withdraw_fee =", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeNotEqualTo(Double value) {
            addCriterion("withdraw_fee <>", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeGreaterThan(Double value) {
            addCriterion("withdraw_fee >", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("withdraw_fee >=", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeLessThan(Double value) {
            addCriterion("withdraw_fee <", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeLessThanOrEqualTo(Double value) {
            addCriterion("withdraw_fee <=", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeIn(List<Double> values) {
            addCriterion("withdraw_fee in", values, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeNotIn(List<Double> values) {
            addCriterion("withdraw_fee not in", values, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeBetween(Double value1, Double value2) {
            addCriterion("withdraw_fee between", value1, value2, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeNotBetween(Double value1, Double value2) {
            addCriterion("withdraw_fee not between", value1, value2, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andOriginPollPointerIsNull() {
            addCriterion("origin_poll_pointer is null");
            return (Criteria) this;
        }

        public Criteria andOriginPollPointerIsNotNull() {
            addCriterion("origin_poll_pointer is not null");
            return (Criteria) this;
        }

        public Criteria andOriginPollPointerEqualTo(String value) {
            addCriterion("origin_poll_pointer =", value, "originPollPointer");
            return (Criteria) this;
        }

        public Criteria andOriginPollPointerNotEqualTo(String value) {
            addCriterion("origin_poll_pointer <>", value, "originPollPointer");
            return (Criteria) this;
        }

        public Criteria andOriginPollPointerGreaterThan(String value) {
            addCriterion("origin_poll_pointer >", value, "originPollPointer");
            return (Criteria) this;
        }

        public Criteria andOriginPollPointerGreaterThanOrEqualTo(String value) {
            addCriterion("origin_poll_pointer >=", value, "originPollPointer");
            return (Criteria) this;
        }

        public Criteria andOriginPollPointerLessThan(String value) {
            addCriterion("origin_poll_pointer <", value, "originPollPointer");
            return (Criteria) this;
        }

        public Criteria andOriginPollPointerLessThanOrEqualTo(String value) {
            addCriterion("origin_poll_pointer <=", value, "originPollPointer");
            return (Criteria) this;
        }

        public Criteria andOriginPollPointerLike(String value) {
            addCriterion("origin_poll_pointer like", value, "originPollPointer");
            return (Criteria) this;
        }

        public Criteria andOriginPollPointerNotLike(String value) {
            addCriterion("origin_poll_pointer not like", value, "originPollPointer");
            return (Criteria) this;
        }

        public Criteria andOriginPollPointerIn(List<String> values) {
            addCriterion("origin_poll_pointer in", values, "originPollPointer");
            return (Criteria) this;
        }

        public Criteria andOriginPollPointerNotIn(List<String> values) {
            addCriterion("origin_poll_pointer not in", values, "originPollPointer");
            return (Criteria) this;
        }

        public Criteria andOriginPollPointerBetween(String value1, String value2) {
            addCriterion("origin_poll_pointer between", value1, value2, "originPollPointer");
            return (Criteria) this;
        }

        public Criteria andOriginPollPointerNotBetween(String value1, String value2) {
            addCriterion("origin_poll_pointer not between", value1, value2, "originPollPointer");
            return (Criteria) this;
        }

        public Criteria andMappingPollPointerIsNull() {
            addCriterion("mapping_poll_pointer is null");
            return (Criteria) this;
        }

        public Criteria andMappingPollPointerIsNotNull() {
            addCriterion("mapping_poll_pointer is not null");
            return (Criteria) this;
        }

        public Criteria andMappingPollPointerEqualTo(String value) {
            addCriterion("mapping_poll_pointer =", value, "mappingPollPointer");
            return (Criteria) this;
        }

        public Criteria andMappingPollPointerNotEqualTo(String value) {
            addCriterion("mapping_poll_pointer <>", value, "mappingPollPointer");
            return (Criteria) this;
        }

        public Criteria andMappingPollPointerGreaterThan(String value) {
            addCriterion("mapping_poll_pointer >", value, "mappingPollPointer");
            return (Criteria) this;
        }

        public Criteria andMappingPollPointerGreaterThanOrEqualTo(String value) {
            addCriterion("mapping_poll_pointer >=", value, "mappingPollPointer");
            return (Criteria) this;
        }

        public Criteria andMappingPollPointerLessThan(String value) {
            addCriterion("mapping_poll_pointer <", value, "mappingPollPointer");
            return (Criteria) this;
        }

        public Criteria andMappingPollPointerLessThanOrEqualTo(String value) {
            addCriterion("mapping_poll_pointer <=", value, "mappingPollPointer");
            return (Criteria) this;
        }

        public Criteria andMappingPollPointerLike(String value) {
            addCriterion("mapping_poll_pointer like", value, "mappingPollPointer");
            return (Criteria) this;
        }

        public Criteria andMappingPollPointerNotLike(String value) {
            addCriterion("mapping_poll_pointer not like", value, "mappingPollPointer");
            return (Criteria) this;
        }

        public Criteria andMappingPollPointerIn(List<String> values) {
            addCriterion("mapping_poll_pointer in", values, "mappingPollPointer");
            return (Criteria) this;
        }

        public Criteria andMappingPollPointerNotIn(List<String> values) {
            addCriterion("mapping_poll_pointer not in", values, "mappingPollPointer");
            return (Criteria) this;
        }

        public Criteria andMappingPollPointerBetween(String value1, String value2) {
            addCriterion("mapping_poll_pointer between", value1, value2, "mappingPollPointer");
            return (Criteria) this;
        }

        public Criteria andMappingPollPointerNotBetween(String value1, String value2) {
            addCriterion("mapping_poll_pointer not between", value1, value2, "mappingPollPointer");
            return (Criteria) this;
        }

        public Criteria andOriginPollTimeIsNull() {
            addCriterion("origin_poll_time is null");
            return (Criteria) this;
        }

        public Criteria andOriginPollTimeIsNotNull() {
            addCriterion("origin_poll_time is not null");
            return (Criteria) this;
        }

        public Criteria andOriginPollTimeEqualTo(Date value) {
            addCriterion("origin_poll_time =", value, "originPollTime");
            return (Criteria) this;
        }

        public Criteria andOriginPollTimeNotEqualTo(Date value) {
            addCriterion("origin_poll_time <>", value, "originPollTime");
            return (Criteria) this;
        }

        public Criteria andOriginPollTimeGreaterThan(Date value) {
            addCriterion("origin_poll_time >", value, "originPollTime");
            return (Criteria) this;
        }

        public Criteria andOriginPollTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("origin_poll_time >=", value, "originPollTime");
            return (Criteria) this;
        }

        public Criteria andOriginPollTimeLessThan(Date value) {
            addCriterion("origin_poll_time <", value, "originPollTime");
            return (Criteria) this;
        }

        public Criteria andOriginPollTimeLessThanOrEqualTo(Date value) {
            addCriterion("origin_poll_time <=", value, "originPollTime");
            return (Criteria) this;
        }

        public Criteria andOriginPollTimeIn(List<Date> values) {
            addCriterion("origin_poll_time in", values, "originPollTime");
            return (Criteria) this;
        }

        public Criteria andOriginPollTimeNotIn(List<Date> values) {
            addCriterion("origin_poll_time not in", values, "originPollTime");
            return (Criteria) this;
        }

        public Criteria andOriginPollTimeBetween(Date value1, Date value2) {
            addCriterion("origin_poll_time between", value1, value2, "originPollTime");
            return (Criteria) this;
        }

        public Criteria andOriginPollTimeNotBetween(Date value1, Date value2) {
            addCriterion("origin_poll_time not between", value1, value2, "originPollTime");
            return (Criteria) this;
        }

        public Criteria andMappingPollTimeIsNull() {
            addCriterion("mapping_poll_time is null");
            return (Criteria) this;
        }

        public Criteria andMappingPollTimeIsNotNull() {
            addCriterion("mapping_poll_time is not null");
            return (Criteria) this;
        }

        public Criteria andMappingPollTimeEqualTo(Date value) {
            addCriterion("mapping_poll_time =", value, "mappingPollTime");
            return (Criteria) this;
        }

        public Criteria andMappingPollTimeNotEqualTo(Date value) {
            addCriterion("mapping_poll_time <>", value, "mappingPollTime");
            return (Criteria) this;
        }

        public Criteria andMappingPollTimeGreaterThan(Date value) {
            addCriterion("mapping_poll_time >", value, "mappingPollTime");
            return (Criteria) this;
        }

        public Criteria andMappingPollTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mapping_poll_time >=", value, "mappingPollTime");
            return (Criteria) this;
        }

        public Criteria andMappingPollTimeLessThan(Date value) {
            addCriterion("mapping_poll_time <", value, "mappingPollTime");
            return (Criteria) this;
        }

        public Criteria andMappingPollTimeLessThanOrEqualTo(Date value) {
            addCriterion("mapping_poll_time <=", value, "mappingPollTime");
            return (Criteria) this;
        }

        public Criteria andMappingPollTimeIn(List<Date> values) {
            addCriterion("mapping_poll_time in", values, "mappingPollTime");
            return (Criteria) this;
        }

        public Criteria andMappingPollTimeNotIn(List<Date> values) {
            addCriterion("mapping_poll_time not in", values, "mappingPollTime");
            return (Criteria) this;
        }

        public Criteria andMappingPollTimeBetween(Date value1, Date value2) {
            addCriterion("mapping_poll_time between", value1, value2, "mappingPollTime");
            return (Criteria) this;
        }

        public Criteria andMappingPollTimeNotBetween(Date value1, Date value2) {
            addCriterion("mapping_poll_time not between", value1, value2, "mappingPollTime");
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