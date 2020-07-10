package org.vite.gateway.database.po.generated;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.vite.gateway.model.enums.CrossChainTransferState;

public class CrossChainTransferCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrossChainTransferCriteria() {
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

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Double value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Double value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Double value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Double value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Double value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Double> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Double> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Double value1, Double value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Double value1, Double value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andBlockchainSourceIsNull() {
            addCriterion("blockchain_source is null");
            return (Criteria) this;
        }

        public Criteria andBlockchainSourceIsNotNull() {
            addCriterion("blockchain_source is not null");
            return (Criteria) this;
        }

        public Criteria andBlockchainSourceEqualTo(String value) {
            addCriterion("blockchain_source =", value, "blockchainSource");
            return (Criteria) this;
        }

        public Criteria andBlockchainSourceNotEqualTo(String value) {
            addCriterion("blockchain_source <>", value, "blockchainSource");
            return (Criteria) this;
        }

        public Criteria andBlockchainSourceGreaterThan(String value) {
            addCriterion("blockchain_source >", value, "blockchainSource");
            return (Criteria) this;
        }

        public Criteria andBlockchainSourceGreaterThanOrEqualTo(String value) {
            addCriterion("blockchain_source >=", value, "blockchainSource");
            return (Criteria) this;
        }

        public Criteria andBlockchainSourceLessThan(String value) {
            addCriterion("blockchain_source <", value, "blockchainSource");
            return (Criteria) this;
        }

        public Criteria andBlockchainSourceLessThanOrEqualTo(String value) {
            addCriterion("blockchain_source <=", value, "blockchainSource");
            return (Criteria) this;
        }

        public Criteria andBlockchainSourceLike(String value) {
            addCriterion("blockchain_source like", value, "blockchainSource");
            return (Criteria) this;
        }

        public Criteria andBlockchainSourceNotLike(String value) {
            addCriterion("blockchain_source not like", value, "blockchainSource");
            return (Criteria) this;
        }

        public Criteria andBlockchainSourceIn(List<String> values) {
            addCriterion("blockchain_source in", values, "blockchainSource");
            return (Criteria) this;
        }

        public Criteria andBlockchainSourceNotIn(List<String> values) {
            addCriterion("blockchain_source not in", values, "blockchainSource");
            return (Criteria) this;
        }

        public Criteria andBlockchainSourceBetween(String value1, String value2) {
            addCriterion("blockchain_source between", value1, value2, "blockchainSource");
            return (Criteria) this;
        }

        public Criteria andBlockchainSourceNotBetween(String value1, String value2) {
            addCriterion("blockchain_source not between", value1, value2, "blockchainSource");
            return (Criteria) this;
        }

        public Criteria andTokenIdSourceIsNull() {
            addCriterion("token_id_source is null");
            return (Criteria) this;
        }

        public Criteria andTokenIdSourceIsNotNull() {
            addCriterion("token_id_source is not null");
            return (Criteria) this;
        }

        public Criteria andTokenIdSourceEqualTo(String value) {
            addCriterion("token_id_source =", value, "tokenIdSource");
            return (Criteria) this;
        }

        public Criteria andTokenIdSourceNotEqualTo(String value) {
            addCriterion("token_id_source <>", value, "tokenIdSource");
            return (Criteria) this;
        }

        public Criteria andTokenIdSourceGreaterThan(String value) {
            addCriterion("token_id_source >", value, "tokenIdSource");
            return (Criteria) this;
        }

        public Criteria andTokenIdSourceGreaterThanOrEqualTo(String value) {
            addCriterion("token_id_source >=", value, "tokenIdSource");
            return (Criteria) this;
        }

        public Criteria andTokenIdSourceLessThan(String value) {
            addCriterion("token_id_source <", value, "tokenIdSource");
            return (Criteria) this;
        }

        public Criteria andTokenIdSourceLessThanOrEqualTo(String value) {
            addCriterion("token_id_source <=", value, "tokenIdSource");
            return (Criteria) this;
        }

        public Criteria andTokenIdSourceLike(String value) {
            addCriterion("token_id_source like", value, "tokenIdSource");
            return (Criteria) this;
        }

        public Criteria andTokenIdSourceNotLike(String value) {
            addCriterion("token_id_source not like", value, "tokenIdSource");
            return (Criteria) this;
        }

        public Criteria andTokenIdSourceIn(List<String> values) {
            addCriterion("token_id_source in", values, "tokenIdSource");
            return (Criteria) this;
        }

        public Criteria andTokenIdSourceNotIn(List<String> values) {
            addCriterion("token_id_source not in", values, "tokenIdSource");
            return (Criteria) this;
        }

        public Criteria andTokenIdSourceBetween(String value1, String value2) {
            addCriterion("token_id_source between", value1, value2, "tokenIdSource");
            return (Criteria) this;
        }

        public Criteria andTokenIdSourceNotBetween(String value1, String value2) {
            addCriterion("token_id_source not between", value1, value2, "tokenIdSource");
            return (Criteria) this;
        }

        public Criteria andHashSourceIsNull() {
            addCriterion("hash_source is null");
            return (Criteria) this;
        }

        public Criteria andHashSourceIsNotNull() {
            addCriterion("hash_source is not null");
            return (Criteria) this;
        }

        public Criteria andHashSourceEqualTo(String value) {
            addCriterion("hash_source =", value, "hashSource");
            return (Criteria) this;
        }

        public Criteria andHashSourceNotEqualTo(String value) {
            addCriterion("hash_source <>", value, "hashSource");
            return (Criteria) this;
        }

        public Criteria andHashSourceGreaterThan(String value) {
            addCriterion("hash_source >", value, "hashSource");
            return (Criteria) this;
        }

        public Criteria andHashSourceGreaterThanOrEqualTo(String value) {
            addCriterion("hash_source >=", value, "hashSource");
            return (Criteria) this;
        }

        public Criteria andHashSourceLessThan(String value) {
            addCriterion("hash_source <", value, "hashSource");
            return (Criteria) this;
        }

        public Criteria andHashSourceLessThanOrEqualTo(String value) {
            addCriterion("hash_source <=", value, "hashSource");
            return (Criteria) this;
        }

        public Criteria andHashSourceLike(String value) {
            addCriterion("hash_source like", value, "hashSource");
            return (Criteria) this;
        }

        public Criteria andHashSourceNotLike(String value) {
            addCriterion("hash_source not like", value, "hashSource");
            return (Criteria) this;
        }

        public Criteria andHashSourceIn(List<String> values) {
            addCriterion("hash_source in", values, "hashSource");
            return (Criteria) this;
        }

        public Criteria andHashSourceNotIn(List<String> values) {
            addCriterion("hash_source not in", values, "hashSource");
            return (Criteria) this;
        }

        public Criteria andHashSourceBetween(String value1, String value2) {
            addCriterion("hash_source between", value1, value2, "hashSource");
            return (Criteria) this;
        }

        public Criteria andHashSourceNotBetween(String value1, String value2) {
            addCriterion("hash_source not between", value1, value2, "hashSource");
            return (Criteria) this;
        }

        public Criteria andFromAddressSourceIsNull() {
            addCriterion("from_address_source is null");
            return (Criteria) this;
        }

        public Criteria andFromAddressSourceIsNotNull() {
            addCriterion("from_address_source is not null");
            return (Criteria) this;
        }

        public Criteria andFromAddressSourceEqualTo(String value) {
            addCriterion("from_address_source =", value, "fromAddressSource");
            return (Criteria) this;
        }

        public Criteria andFromAddressSourceNotEqualTo(String value) {
            addCriterion("from_address_source <>", value, "fromAddressSource");
            return (Criteria) this;
        }

        public Criteria andFromAddressSourceGreaterThan(String value) {
            addCriterion("from_address_source >", value, "fromAddressSource");
            return (Criteria) this;
        }

        public Criteria andFromAddressSourceGreaterThanOrEqualTo(String value) {
            addCriterion("from_address_source >=", value, "fromAddressSource");
            return (Criteria) this;
        }

        public Criteria andFromAddressSourceLessThan(String value) {
            addCriterion("from_address_source <", value, "fromAddressSource");
            return (Criteria) this;
        }

        public Criteria andFromAddressSourceLessThanOrEqualTo(String value) {
            addCriterion("from_address_source <=", value, "fromAddressSource");
            return (Criteria) this;
        }

        public Criteria andFromAddressSourceLike(String value) {
            addCriterion("from_address_source like", value, "fromAddressSource");
            return (Criteria) this;
        }

        public Criteria andFromAddressSourceNotLike(String value) {
            addCriterion("from_address_source not like", value, "fromAddressSource");
            return (Criteria) this;
        }

        public Criteria andFromAddressSourceIn(List<String> values) {
            addCriterion("from_address_source in", values, "fromAddressSource");
            return (Criteria) this;
        }

        public Criteria andFromAddressSourceNotIn(List<String> values) {
            addCriterion("from_address_source not in", values, "fromAddressSource");
            return (Criteria) this;
        }

        public Criteria andFromAddressSourceBetween(String value1, String value2) {
            addCriterion("from_address_source between", value1, value2, "fromAddressSource");
            return (Criteria) this;
        }

        public Criteria andFromAddressSourceNotBetween(String value1, String value2) {
            addCriterion("from_address_source not between", value1, value2, "fromAddressSource");
            return (Criteria) this;
        }

        public Criteria andToAddressSourceIsNull() {
            addCriterion("to_address_source is null");
            return (Criteria) this;
        }

        public Criteria andToAddressSourceIsNotNull() {
            addCriterion("to_address_source is not null");
            return (Criteria) this;
        }

        public Criteria andToAddressSourceEqualTo(String value) {
            addCriterion("to_address_source =", value, "toAddressSource");
            return (Criteria) this;
        }

        public Criteria andToAddressSourceNotEqualTo(String value) {
            addCriterion("to_address_source <>", value, "toAddressSource");
            return (Criteria) this;
        }

        public Criteria andToAddressSourceGreaterThan(String value) {
            addCriterion("to_address_source >", value, "toAddressSource");
            return (Criteria) this;
        }

        public Criteria andToAddressSourceGreaterThanOrEqualTo(String value) {
            addCriterion("to_address_source >=", value, "toAddressSource");
            return (Criteria) this;
        }

        public Criteria andToAddressSourceLessThan(String value) {
            addCriterion("to_address_source <", value, "toAddressSource");
            return (Criteria) this;
        }

        public Criteria andToAddressSourceLessThanOrEqualTo(String value) {
            addCriterion("to_address_source <=", value, "toAddressSource");
            return (Criteria) this;
        }

        public Criteria andToAddressSourceLike(String value) {
            addCriterion("to_address_source like", value, "toAddressSource");
            return (Criteria) this;
        }

        public Criteria andToAddressSourceNotLike(String value) {
            addCriterion("to_address_source not like", value, "toAddressSource");
            return (Criteria) this;
        }

        public Criteria andToAddressSourceIn(List<String> values) {
            addCriterion("to_address_source in", values, "toAddressSource");
            return (Criteria) this;
        }

        public Criteria andToAddressSourceNotIn(List<String> values) {
            addCriterion("to_address_source not in", values, "toAddressSource");
            return (Criteria) this;
        }

        public Criteria andToAddressSourceBetween(String value1, String value2) {
            addCriterion("to_address_source between", value1, value2, "toAddressSource");
            return (Criteria) this;
        }

        public Criteria andToAddressSourceNotBetween(String value1, String value2) {
            addCriterion("to_address_source not between", value1, value2, "toAddressSource");
            return (Criteria) this;
        }

        public Criteria andMemoSourceIsNull() {
            addCriterion("memo_source is null");
            return (Criteria) this;
        }

        public Criteria andMemoSourceIsNotNull() {
            addCriterion("memo_source is not null");
            return (Criteria) this;
        }

        public Criteria andMemoSourceEqualTo(String value) {
            addCriterion("memo_source =", value, "memoSource");
            return (Criteria) this;
        }

        public Criteria andMemoSourceNotEqualTo(String value) {
            addCriterion("memo_source <>", value, "memoSource");
            return (Criteria) this;
        }

        public Criteria andMemoSourceGreaterThan(String value) {
            addCriterion("memo_source >", value, "memoSource");
            return (Criteria) this;
        }

        public Criteria andMemoSourceGreaterThanOrEqualTo(String value) {
            addCriterion("memo_source >=", value, "memoSource");
            return (Criteria) this;
        }

        public Criteria andMemoSourceLessThan(String value) {
            addCriterion("memo_source <", value, "memoSource");
            return (Criteria) this;
        }

        public Criteria andMemoSourceLessThanOrEqualTo(String value) {
            addCriterion("memo_source <=", value, "memoSource");
            return (Criteria) this;
        }

        public Criteria andMemoSourceLike(String value) {
            addCriterion("memo_source like", value, "memoSource");
            return (Criteria) this;
        }

        public Criteria andMemoSourceNotLike(String value) {
            addCriterion("memo_source not like", value, "memoSource");
            return (Criteria) this;
        }

        public Criteria andMemoSourceIn(List<String> values) {
            addCriterion("memo_source in", values, "memoSource");
            return (Criteria) this;
        }

        public Criteria andMemoSourceNotIn(List<String> values) {
            addCriterion("memo_source not in", values, "memoSource");
            return (Criteria) this;
        }

        public Criteria andMemoSourceBetween(String value1, String value2) {
            addCriterion("memo_source between", value1, value2, "memoSource");
            return (Criteria) this;
        }

        public Criteria andMemoSourceNotBetween(String value1, String value2) {
            addCriterion("memo_source not between", value1, value2, "memoSource");
            return (Criteria) this;
        }

        public Criteria andFeeSourceIsNull() {
            addCriterion("fee_source is null");
            return (Criteria) this;
        }

        public Criteria andFeeSourceIsNotNull() {
            addCriterion("fee_source is not null");
            return (Criteria) this;
        }

        public Criteria andFeeSourceEqualTo(Double value) {
            addCriterion("fee_source =", value, "feeSource");
            return (Criteria) this;
        }

        public Criteria andFeeSourceNotEqualTo(Double value) {
            addCriterion("fee_source <>", value, "feeSource");
            return (Criteria) this;
        }

        public Criteria andFeeSourceGreaterThan(Double value) {
            addCriterion("fee_source >", value, "feeSource");
            return (Criteria) this;
        }

        public Criteria andFeeSourceGreaterThanOrEqualTo(Double value) {
            addCriterion("fee_source >=", value, "feeSource");
            return (Criteria) this;
        }

        public Criteria andFeeSourceLessThan(Double value) {
            addCriterion("fee_source <", value, "feeSource");
            return (Criteria) this;
        }

        public Criteria andFeeSourceLessThanOrEqualTo(Double value) {
            addCriterion("fee_source <=", value, "feeSource");
            return (Criteria) this;
        }

        public Criteria andFeeSourceIn(List<Double> values) {
            addCriterion("fee_source in", values, "feeSource");
            return (Criteria) this;
        }

        public Criteria andFeeSourceNotIn(List<Double> values) {
            addCriterion("fee_source not in", values, "feeSource");
            return (Criteria) this;
        }

        public Criteria andFeeSourceBetween(Double value1, Double value2) {
            addCriterion("fee_source between", value1, value2, "feeSource");
            return (Criteria) this;
        }

        public Criteria andFeeSourceNotBetween(Double value1, Double value2) {
            addCriterion("fee_source not between", value1, value2, "feeSource");
            return (Criteria) this;
        }

        public Criteria andConfirmationsSourceIsNull() {
            addCriterion("confirmations_source is null");
            return (Criteria) this;
        }

        public Criteria andConfirmationsSourceIsNotNull() {
            addCriterion("confirmations_source is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmationsSourceEqualTo(Long value) {
            addCriterion("confirmations_source =", value, "confirmationsSource");
            return (Criteria) this;
        }

        public Criteria andConfirmationsSourceNotEqualTo(Long value) {
            addCriterion("confirmations_source <>", value, "confirmationsSource");
            return (Criteria) this;
        }

        public Criteria andConfirmationsSourceGreaterThan(Long value) {
            addCriterion("confirmations_source >", value, "confirmationsSource");
            return (Criteria) this;
        }

        public Criteria andConfirmationsSourceGreaterThanOrEqualTo(Long value) {
            addCriterion("confirmations_source >=", value, "confirmationsSource");
            return (Criteria) this;
        }

        public Criteria andConfirmationsSourceLessThan(Long value) {
            addCriterion("confirmations_source <", value, "confirmationsSource");
            return (Criteria) this;
        }

        public Criteria andConfirmationsSourceLessThanOrEqualTo(Long value) {
            addCriterion("confirmations_source <=", value, "confirmationsSource");
            return (Criteria) this;
        }

        public Criteria andConfirmationsSourceIn(List<Long> values) {
            addCriterion("confirmations_source in", values, "confirmationsSource");
            return (Criteria) this;
        }

        public Criteria andConfirmationsSourceNotIn(List<Long> values) {
            addCriterion("confirmations_source not in", values, "confirmationsSource");
            return (Criteria) this;
        }

        public Criteria andConfirmationsSourceBetween(Long value1, Long value2) {
            addCriterion("confirmations_source between", value1, value2, "confirmationsSource");
            return (Criteria) this;
        }

        public Criteria andConfirmationsSourceNotBetween(Long value1, Long value2) {
            addCriterion("confirmations_source not between", value1, value2, "confirmationsSource");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeSourceIsNull() {
            addCriterion("transaction_time_source is null");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeSourceIsNotNull() {
            addCriterion("transaction_time_source is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeSourceEqualTo(Date value) {
            addCriterion("transaction_time_source =", value, "transactionTimeSource");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeSourceNotEqualTo(Date value) {
            addCriterion("transaction_time_source <>", value, "transactionTimeSource");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeSourceGreaterThan(Date value) {
            addCriterion("transaction_time_source >", value, "transactionTimeSource");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeSourceGreaterThanOrEqualTo(Date value) {
            addCriterion("transaction_time_source >=", value, "transactionTimeSource");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeSourceLessThan(Date value) {
            addCriterion("transaction_time_source <", value, "transactionTimeSource");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeSourceLessThanOrEqualTo(Date value) {
            addCriterion("transaction_time_source <=", value, "transactionTimeSource");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeSourceIn(List<Date> values) {
            addCriterion("transaction_time_source in", values, "transactionTimeSource");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeSourceNotIn(List<Date> values) {
            addCriterion("transaction_time_source not in", values, "transactionTimeSource");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeSourceBetween(Date value1, Date value2) {
            addCriterion("transaction_time_source between", value1, value2, "transactionTimeSource");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeSourceNotBetween(Date value1, Date value2) {
            addCriterion("transaction_time_source not between", value1, value2, "transactionTimeSource");
            return (Criteria) this;
        }

        public Criteria andBlockchainDestIsNull() {
            addCriterion("blockchain_dest is null");
            return (Criteria) this;
        }

        public Criteria andBlockchainDestIsNotNull() {
            addCriterion("blockchain_dest is not null");
            return (Criteria) this;
        }

        public Criteria andBlockchainDestEqualTo(String value) {
            addCriterion("blockchain_dest =", value, "blockchainDest");
            return (Criteria) this;
        }

        public Criteria andBlockchainDestNotEqualTo(String value) {
            addCriterion("blockchain_dest <>", value, "blockchainDest");
            return (Criteria) this;
        }

        public Criteria andBlockchainDestGreaterThan(String value) {
            addCriterion("blockchain_dest >", value, "blockchainDest");
            return (Criteria) this;
        }

        public Criteria andBlockchainDestGreaterThanOrEqualTo(String value) {
            addCriterion("blockchain_dest >=", value, "blockchainDest");
            return (Criteria) this;
        }

        public Criteria andBlockchainDestLessThan(String value) {
            addCriterion("blockchain_dest <", value, "blockchainDest");
            return (Criteria) this;
        }

        public Criteria andBlockchainDestLessThanOrEqualTo(String value) {
            addCriterion("blockchain_dest <=", value, "blockchainDest");
            return (Criteria) this;
        }

        public Criteria andBlockchainDestLike(String value) {
            addCriterion("blockchain_dest like", value, "blockchainDest");
            return (Criteria) this;
        }

        public Criteria andBlockchainDestNotLike(String value) {
            addCriterion("blockchain_dest not like", value, "blockchainDest");
            return (Criteria) this;
        }

        public Criteria andBlockchainDestIn(List<String> values) {
            addCriterion("blockchain_dest in", values, "blockchainDest");
            return (Criteria) this;
        }

        public Criteria andBlockchainDestNotIn(List<String> values) {
            addCriterion("blockchain_dest not in", values, "blockchainDest");
            return (Criteria) this;
        }

        public Criteria andBlockchainDestBetween(String value1, String value2) {
            addCriterion("blockchain_dest between", value1, value2, "blockchainDest");
            return (Criteria) this;
        }

        public Criteria andBlockchainDestNotBetween(String value1, String value2) {
            addCriterion("blockchain_dest not between", value1, value2, "blockchainDest");
            return (Criteria) this;
        }

        public Criteria andTokenIdDestIsNull() {
            addCriterion("token_id_dest is null");
            return (Criteria) this;
        }

        public Criteria andTokenIdDestIsNotNull() {
            addCriterion("token_id_dest is not null");
            return (Criteria) this;
        }

        public Criteria andTokenIdDestEqualTo(String value) {
            addCriterion("token_id_dest =", value, "tokenIdDest");
            return (Criteria) this;
        }

        public Criteria andTokenIdDestNotEqualTo(String value) {
            addCriterion("token_id_dest <>", value, "tokenIdDest");
            return (Criteria) this;
        }

        public Criteria andTokenIdDestGreaterThan(String value) {
            addCriterion("token_id_dest >", value, "tokenIdDest");
            return (Criteria) this;
        }

        public Criteria andTokenIdDestGreaterThanOrEqualTo(String value) {
            addCriterion("token_id_dest >=", value, "tokenIdDest");
            return (Criteria) this;
        }

        public Criteria andTokenIdDestLessThan(String value) {
            addCriterion("token_id_dest <", value, "tokenIdDest");
            return (Criteria) this;
        }

        public Criteria andTokenIdDestLessThanOrEqualTo(String value) {
            addCriterion("token_id_dest <=", value, "tokenIdDest");
            return (Criteria) this;
        }

        public Criteria andTokenIdDestLike(String value) {
            addCriterion("token_id_dest like", value, "tokenIdDest");
            return (Criteria) this;
        }

        public Criteria andTokenIdDestNotLike(String value) {
            addCriterion("token_id_dest not like", value, "tokenIdDest");
            return (Criteria) this;
        }

        public Criteria andTokenIdDestIn(List<String> values) {
            addCriterion("token_id_dest in", values, "tokenIdDest");
            return (Criteria) this;
        }

        public Criteria andTokenIdDestNotIn(List<String> values) {
            addCriterion("token_id_dest not in", values, "tokenIdDest");
            return (Criteria) this;
        }

        public Criteria andTokenIdDestBetween(String value1, String value2) {
            addCriterion("token_id_dest between", value1, value2, "tokenIdDest");
            return (Criteria) this;
        }

        public Criteria andTokenIdDestNotBetween(String value1, String value2) {
            addCriterion("token_id_dest not between", value1, value2, "tokenIdDest");
            return (Criteria) this;
        }

        public Criteria andHashDestIsNull() {
            addCriterion("hash_dest is null");
            return (Criteria) this;
        }

        public Criteria andHashDestIsNotNull() {
            addCriterion("hash_dest is not null");
            return (Criteria) this;
        }

        public Criteria andHashDestEqualTo(String value) {
            addCriterion("hash_dest =", value, "hashDest");
            return (Criteria) this;
        }

        public Criteria andHashDestNotEqualTo(String value) {
            addCriterion("hash_dest <>", value, "hashDest");
            return (Criteria) this;
        }

        public Criteria andHashDestGreaterThan(String value) {
            addCriterion("hash_dest >", value, "hashDest");
            return (Criteria) this;
        }

        public Criteria andHashDestGreaterThanOrEqualTo(String value) {
            addCriterion("hash_dest >=", value, "hashDest");
            return (Criteria) this;
        }

        public Criteria andHashDestLessThan(String value) {
            addCriterion("hash_dest <", value, "hashDest");
            return (Criteria) this;
        }

        public Criteria andHashDestLessThanOrEqualTo(String value) {
            addCriterion("hash_dest <=", value, "hashDest");
            return (Criteria) this;
        }

        public Criteria andHashDestLike(String value) {
            addCriterion("hash_dest like", value, "hashDest");
            return (Criteria) this;
        }

        public Criteria andHashDestNotLike(String value) {
            addCriterion("hash_dest not like", value, "hashDest");
            return (Criteria) this;
        }

        public Criteria andHashDestIn(List<String> values) {
            addCriterion("hash_dest in", values, "hashDest");
            return (Criteria) this;
        }

        public Criteria andHashDestNotIn(List<String> values) {
            addCriterion("hash_dest not in", values, "hashDest");
            return (Criteria) this;
        }

        public Criteria andHashDestBetween(String value1, String value2) {
            addCriterion("hash_dest between", value1, value2, "hashDest");
            return (Criteria) this;
        }

        public Criteria andHashDestNotBetween(String value1, String value2) {
            addCriterion("hash_dest not between", value1, value2, "hashDest");
            return (Criteria) this;
        }

        public Criteria andFromAddressDestIsNull() {
            addCriterion("from_address_dest is null");
            return (Criteria) this;
        }

        public Criteria andFromAddressDestIsNotNull() {
            addCriterion("from_address_dest is not null");
            return (Criteria) this;
        }

        public Criteria andFromAddressDestEqualTo(String value) {
            addCriterion("from_address_dest =", value, "fromAddressDest");
            return (Criteria) this;
        }

        public Criteria andFromAddressDestNotEqualTo(String value) {
            addCriterion("from_address_dest <>", value, "fromAddressDest");
            return (Criteria) this;
        }

        public Criteria andFromAddressDestGreaterThan(String value) {
            addCriterion("from_address_dest >", value, "fromAddressDest");
            return (Criteria) this;
        }

        public Criteria andFromAddressDestGreaterThanOrEqualTo(String value) {
            addCriterion("from_address_dest >=", value, "fromAddressDest");
            return (Criteria) this;
        }

        public Criteria andFromAddressDestLessThan(String value) {
            addCriterion("from_address_dest <", value, "fromAddressDest");
            return (Criteria) this;
        }

        public Criteria andFromAddressDestLessThanOrEqualTo(String value) {
            addCriterion("from_address_dest <=", value, "fromAddressDest");
            return (Criteria) this;
        }

        public Criteria andFromAddressDestLike(String value) {
            addCriterion("from_address_dest like", value, "fromAddressDest");
            return (Criteria) this;
        }

        public Criteria andFromAddressDestNotLike(String value) {
            addCriterion("from_address_dest not like", value, "fromAddressDest");
            return (Criteria) this;
        }

        public Criteria andFromAddressDestIn(List<String> values) {
            addCriterion("from_address_dest in", values, "fromAddressDest");
            return (Criteria) this;
        }

        public Criteria andFromAddressDestNotIn(List<String> values) {
            addCriterion("from_address_dest not in", values, "fromAddressDest");
            return (Criteria) this;
        }

        public Criteria andFromAddressDestBetween(String value1, String value2) {
            addCriterion("from_address_dest between", value1, value2, "fromAddressDest");
            return (Criteria) this;
        }

        public Criteria andFromAddressDestNotBetween(String value1, String value2) {
            addCriterion("from_address_dest not between", value1, value2, "fromAddressDest");
            return (Criteria) this;
        }

        public Criteria andToAddressDestIsNull() {
            addCriterion("to_address_dest is null");
            return (Criteria) this;
        }

        public Criteria andToAddressDestIsNotNull() {
            addCriterion("to_address_dest is not null");
            return (Criteria) this;
        }

        public Criteria andToAddressDestEqualTo(String value) {
            addCriterion("to_address_dest =", value, "toAddressDest");
            return (Criteria) this;
        }

        public Criteria andToAddressDestNotEqualTo(String value) {
            addCriterion("to_address_dest <>", value, "toAddressDest");
            return (Criteria) this;
        }

        public Criteria andToAddressDestGreaterThan(String value) {
            addCriterion("to_address_dest >", value, "toAddressDest");
            return (Criteria) this;
        }

        public Criteria andToAddressDestGreaterThanOrEqualTo(String value) {
            addCriterion("to_address_dest >=", value, "toAddressDest");
            return (Criteria) this;
        }

        public Criteria andToAddressDestLessThan(String value) {
            addCriterion("to_address_dest <", value, "toAddressDest");
            return (Criteria) this;
        }

        public Criteria andToAddressDestLessThanOrEqualTo(String value) {
            addCriterion("to_address_dest <=", value, "toAddressDest");
            return (Criteria) this;
        }

        public Criteria andToAddressDestLike(String value) {
            addCriterion("to_address_dest like", value, "toAddressDest");
            return (Criteria) this;
        }

        public Criteria andToAddressDestNotLike(String value) {
            addCriterion("to_address_dest not like", value, "toAddressDest");
            return (Criteria) this;
        }

        public Criteria andToAddressDestIn(List<String> values) {
            addCriterion("to_address_dest in", values, "toAddressDest");
            return (Criteria) this;
        }

        public Criteria andToAddressDestNotIn(List<String> values) {
            addCriterion("to_address_dest not in", values, "toAddressDest");
            return (Criteria) this;
        }

        public Criteria andToAddressDestBetween(String value1, String value2) {
            addCriterion("to_address_dest between", value1, value2, "toAddressDest");
            return (Criteria) this;
        }

        public Criteria andToAddressDestNotBetween(String value1, String value2) {
            addCriterion("to_address_dest not between", value1, value2, "toAddressDest");
            return (Criteria) this;
        }

        public Criteria andMemoDestIsNull() {
            addCriterion("memo_dest is null");
            return (Criteria) this;
        }

        public Criteria andMemoDestIsNotNull() {
            addCriterion("memo_dest is not null");
            return (Criteria) this;
        }

        public Criteria andMemoDestEqualTo(String value) {
            addCriterion("memo_dest =", value, "memoDest");
            return (Criteria) this;
        }

        public Criteria andMemoDestNotEqualTo(String value) {
            addCriterion("memo_dest <>", value, "memoDest");
            return (Criteria) this;
        }

        public Criteria andMemoDestGreaterThan(String value) {
            addCriterion("memo_dest >", value, "memoDest");
            return (Criteria) this;
        }

        public Criteria andMemoDestGreaterThanOrEqualTo(String value) {
            addCriterion("memo_dest >=", value, "memoDest");
            return (Criteria) this;
        }

        public Criteria andMemoDestLessThan(String value) {
            addCriterion("memo_dest <", value, "memoDest");
            return (Criteria) this;
        }

        public Criteria andMemoDestLessThanOrEqualTo(String value) {
            addCriterion("memo_dest <=", value, "memoDest");
            return (Criteria) this;
        }

        public Criteria andMemoDestLike(String value) {
            addCriterion("memo_dest like", value, "memoDest");
            return (Criteria) this;
        }

        public Criteria andMemoDestNotLike(String value) {
            addCriterion("memo_dest not like", value, "memoDest");
            return (Criteria) this;
        }

        public Criteria andMemoDestIn(List<String> values) {
            addCriterion("memo_dest in", values, "memoDest");
            return (Criteria) this;
        }

        public Criteria andMemoDestNotIn(List<String> values) {
            addCriterion("memo_dest not in", values, "memoDest");
            return (Criteria) this;
        }

        public Criteria andMemoDestBetween(String value1, String value2) {
            addCriterion("memo_dest between", value1, value2, "memoDest");
            return (Criteria) this;
        }

        public Criteria andMemoDestNotBetween(String value1, String value2) {
            addCriterion("memo_dest not between", value1, value2, "memoDest");
            return (Criteria) this;
        }

        public Criteria andFeeDestIsNull() {
            addCriterion("fee_dest is null");
            return (Criteria) this;
        }

        public Criteria andFeeDestIsNotNull() {
            addCriterion("fee_dest is not null");
            return (Criteria) this;
        }

        public Criteria andFeeDestEqualTo(Double value) {
            addCriterion("fee_dest =", value, "feeDest");
            return (Criteria) this;
        }

        public Criteria andFeeDestNotEqualTo(Double value) {
            addCriterion("fee_dest <>", value, "feeDest");
            return (Criteria) this;
        }

        public Criteria andFeeDestGreaterThan(Double value) {
            addCriterion("fee_dest >", value, "feeDest");
            return (Criteria) this;
        }

        public Criteria andFeeDestGreaterThanOrEqualTo(Double value) {
            addCriterion("fee_dest >=", value, "feeDest");
            return (Criteria) this;
        }

        public Criteria andFeeDestLessThan(Double value) {
            addCriterion("fee_dest <", value, "feeDest");
            return (Criteria) this;
        }

        public Criteria andFeeDestLessThanOrEqualTo(Double value) {
            addCriterion("fee_dest <=", value, "feeDest");
            return (Criteria) this;
        }

        public Criteria andFeeDestIn(List<Double> values) {
            addCriterion("fee_dest in", values, "feeDest");
            return (Criteria) this;
        }

        public Criteria andFeeDestNotIn(List<Double> values) {
            addCriterion("fee_dest not in", values, "feeDest");
            return (Criteria) this;
        }

        public Criteria andFeeDestBetween(Double value1, Double value2) {
            addCriterion("fee_dest between", value1, value2, "feeDest");
            return (Criteria) this;
        }

        public Criteria andFeeDestNotBetween(Double value1, Double value2) {
            addCriterion("fee_dest not between", value1, value2, "feeDest");
            return (Criteria) this;
        }

        public Criteria andConfirmationsDestIsNull() {
            addCriterion("confirmations_dest is null");
            return (Criteria) this;
        }

        public Criteria andConfirmationsDestIsNotNull() {
            addCriterion("confirmations_dest is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmationsDestEqualTo(Long value) {
            addCriterion("confirmations_dest =", value, "confirmationsDest");
            return (Criteria) this;
        }

        public Criteria andConfirmationsDestNotEqualTo(Long value) {
            addCriterion("confirmations_dest <>", value, "confirmationsDest");
            return (Criteria) this;
        }

        public Criteria andConfirmationsDestGreaterThan(Long value) {
            addCriterion("confirmations_dest >", value, "confirmationsDest");
            return (Criteria) this;
        }

        public Criteria andConfirmationsDestGreaterThanOrEqualTo(Long value) {
            addCriterion("confirmations_dest >=", value, "confirmationsDest");
            return (Criteria) this;
        }

        public Criteria andConfirmationsDestLessThan(Long value) {
            addCriterion("confirmations_dest <", value, "confirmationsDest");
            return (Criteria) this;
        }

        public Criteria andConfirmationsDestLessThanOrEqualTo(Long value) {
            addCriterion("confirmations_dest <=", value, "confirmationsDest");
            return (Criteria) this;
        }

        public Criteria andConfirmationsDestIn(List<Long> values) {
            addCriterion("confirmations_dest in", values, "confirmationsDest");
            return (Criteria) this;
        }

        public Criteria andConfirmationsDestNotIn(List<Long> values) {
            addCriterion("confirmations_dest not in", values, "confirmationsDest");
            return (Criteria) this;
        }

        public Criteria andConfirmationsDestBetween(Long value1, Long value2) {
            addCriterion("confirmations_dest between", value1, value2, "confirmationsDest");
            return (Criteria) this;
        }

        public Criteria andConfirmationsDestNotBetween(Long value1, Long value2) {
            addCriterion("confirmations_dest not between", value1, value2, "confirmationsDest");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeDestIsNull() {
            addCriterion("transaction_time_dest is null");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeDestIsNotNull() {
            addCriterion("transaction_time_dest is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeDestEqualTo(Date value) {
            addCriterion("transaction_time_dest =", value, "transactionTimeDest");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeDestNotEqualTo(Date value) {
            addCriterion("transaction_time_dest <>", value, "transactionTimeDest");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeDestGreaterThan(Date value) {
            addCriterion("transaction_time_dest >", value, "transactionTimeDest");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeDestGreaterThanOrEqualTo(Date value) {
            addCriterion("transaction_time_dest >=", value, "transactionTimeDest");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeDestLessThan(Date value) {
            addCriterion("transaction_time_dest <", value, "transactionTimeDest");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeDestLessThanOrEqualTo(Date value) {
            addCriterion("transaction_time_dest <=", value, "transactionTimeDest");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeDestIn(List<Date> values) {
            addCriterion("transaction_time_dest in", values, "transactionTimeDest");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeDestNotIn(List<Date> values) {
            addCriterion("transaction_time_dest not in", values, "transactionTimeDest");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeDestBetween(Date value1, Date value2) {
            addCriterion("transaction_time_dest between", value1, value2, "transactionTimeDest");
            return (Criteria) this;
        }

        public Criteria andTransactionTimeDestNotBetween(Date value1, Date value2) {
            addCriterion("transaction_time_dest not between", value1, value2, "transactionTimeDest");
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

        public Criteria andStateEqualTo(CrossChainTransferState value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(CrossChainTransferState value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(CrossChainTransferState value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(CrossChainTransferState value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(CrossChainTransferState value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(CrossChainTransferState value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(CrossChainTransferState value) {
            addCriterion("`state` like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(CrossChainTransferState value) {
            addCriterion("`state` not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<CrossChainTransferState> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<CrossChainTransferState> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(CrossChainTransferState value1, CrossChainTransferState value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(CrossChainTransferState value1, CrossChainTransferState value2) {
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