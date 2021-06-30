package com.dingdang.DingdangDrugstore.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductDetailExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductSnIsNull() {
            addCriterion("product_sn is null");
            return (Criteria) this;
        }

        public Criteria andProductSnIsNotNull() {
            addCriterion("product_sn is not null");
            return (Criteria) this;
        }

        public Criteria andProductSnEqualTo(String value) {
            addCriterion("product_sn =", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnNotEqualTo(String value) {
            addCriterion("product_sn <>", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnGreaterThan(String value) {
            addCriterion("product_sn >", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnGreaterThanOrEqualTo(String value) {
            addCriterion("product_sn >=", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnLessThan(String value) {
            addCriterion("product_sn <", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnLessThanOrEqualTo(String value) {
            addCriterion("product_sn <=", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnLike(String value) {
            addCriterion("product_sn like", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnNotLike(String value) {
            addCriterion("product_sn not like", value, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnIn(List<String> values) {
            addCriterion("product_sn in", values, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnNotIn(List<String> values) {
            addCriterion("product_sn not in", values, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnBetween(String value1, String value2) {
            addCriterion("product_sn between", value1, value2, "productSn");
            return (Criteria) this;
        }

        public Criteria andProductSnNotBetween(String value1, String value2) {
            addCriterion("product_sn not between", value1, value2, "productSn");
            return (Criteria) this;
        }

        public Criteria andCommonNameIsNull() {
            addCriterion("common_name is null");
            return (Criteria) this;
        }

        public Criteria andCommonNameIsNotNull() {
            addCriterion("common_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommonNameEqualTo(String value) {
            addCriterion("common_name =", value, "commonName");
            return (Criteria) this;
        }

        public Criteria andCommonNameNotEqualTo(String value) {
            addCriterion("common_name <>", value, "commonName");
            return (Criteria) this;
        }

        public Criteria andCommonNameGreaterThan(String value) {
            addCriterion("common_name >", value, "commonName");
            return (Criteria) this;
        }

        public Criteria andCommonNameGreaterThanOrEqualTo(String value) {
            addCriterion("common_name >=", value, "commonName");
            return (Criteria) this;
        }

        public Criteria andCommonNameLessThan(String value) {
            addCriterion("common_name <", value, "commonName");
            return (Criteria) this;
        }

        public Criteria andCommonNameLessThanOrEqualTo(String value) {
            addCriterion("common_name <=", value, "commonName");
            return (Criteria) this;
        }

        public Criteria andCommonNameLike(String value) {
            addCriterion("common_name like", value, "commonName");
            return (Criteria) this;
        }

        public Criteria andCommonNameNotLike(String value) {
            addCriterion("common_name not like", value, "commonName");
            return (Criteria) this;
        }

        public Criteria andCommonNameIn(List<String> values) {
            addCriterion("common_name in", values, "commonName");
            return (Criteria) this;
        }

        public Criteria andCommonNameNotIn(List<String> values) {
            addCriterion("common_name not in", values, "commonName");
            return (Criteria) this;
        }

        public Criteria andCommonNameBetween(String value1, String value2) {
            addCriterion("common_name between", value1, value2, "commonName");
            return (Criteria) this;
        }

        public Criteria andCommonNameNotBetween(String value1, String value2) {
            addCriterion("common_name not between", value1, value2, "commonName");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andIngredientsIsNull() {
            addCriterion("ingredients is null");
            return (Criteria) this;
        }

        public Criteria andIngredientsIsNotNull() {
            addCriterion("ingredients is not null");
            return (Criteria) this;
        }

        public Criteria andIngredientsEqualTo(String value) {
            addCriterion("ingredients =", value, "ingredients");
            return (Criteria) this;
        }

        public Criteria andIngredientsNotEqualTo(String value) {
            addCriterion("ingredients <>", value, "ingredients");
            return (Criteria) this;
        }

        public Criteria andIngredientsGreaterThan(String value) {
            addCriterion("ingredients >", value, "ingredients");
            return (Criteria) this;
        }

        public Criteria andIngredientsGreaterThanOrEqualTo(String value) {
            addCriterion("ingredients >=", value, "ingredients");
            return (Criteria) this;
        }

        public Criteria andIngredientsLessThan(String value) {
            addCriterion("ingredients <", value, "ingredients");
            return (Criteria) this;
        }

        public Criteria andIngredientsLessThanOrEqualTo(String value) {
            addCriterion("ingredients <=", value, "ingredients");
            return (Criteria) this;
        }

        public Criteria andIngredientsLike(String value) {
            addCriterion("ingredients like", value, "ingredients");
            return (Criteria) this;
        }

        public Criteria andIngredientsNotLike(String value) {
            addCriterion("ingredients not like", value, "ingredients");
            return (Criteria) this;
        }

        public Criteria andIngredientsIn(List<String> values) {
            addCriterion("ingredients in", values, "ingredients");
            return (Criteria) this;
        }

        public Criteria andIngredientsNotIn(List<String> values) {
            addCriterion("ingredients not in", values, "ingredients");
            return (Criteria) this;
        }

        public Criteria andIngredientsBetween(String value1, String value2) {
            addCriterion("ingredients between", value1, value2, "ingredients");
            return (Criteria) this;
        }

        public Criteria andIngredientsNotBetween(String value1, String value2) {
            addCriterion("ingredients not between", value1, value2, "ingredients");
            return (Criteria) this;
        }

        public Criteria andTabooIsNull() {
            addCriterion("taboo is null");
            return (Criteria) this;
        }

        public Criteria andTabooIsNotNull() {
            addCriterion("taboo is not null");
            return (Criteria) this;
        }

        public Criteria andTabooEqualTo(String value) {
            addCriterion("taboo =", value, "taboo");
            return (Criteria) this;
        }

        public Criteria andTabooNotEqualTo(String value) {
            addCriterion("taboo <>", value, "taboo");
            return (Criteria) this;
        }

        public Criteria andTabooGreaterThan(String value) {
            addCriterion("taboo >", value, "taboo");
            return (Criteria) this;
        }

        public Criteria andTabooGreaterThanOrEqualTo(String value) {
            addCriterion("taboo >=", value, "taboo");
            return (Criteria) this;
        }

        public Criteria andTabooLessThan(String value) {
            addCriterion("taboo <", value, "taboo");
            return (Criteria) this;
        }

        public Criteria andTabooLessThanOrEqualTo(String value) {
            addCriterion("taboo <=", value, "taboo");
            return (Criteria) this;
        }

        public Criteria andTabooLike(String value) {
            addCriterion("taboo like", value, "taboo");
            return (Criteria) this;
        }

        public Criteria andTabooNotLike(String value) {
            addCriterion("taboo not like", value, "taboo");
            return (Criteria) this;
        }

        public Criteria andTabooIn(List<String> values) {
            addCriterion("taboo in", values, "taboo");
            return (Criteria) this;
        }

        public Criteria andTabooNotIn(List<String> values) {
            addCriterion("taboo not in", values, "taboo");
            return (Criteria) this;
        }

        public Criteria andTabooBetween(String value1, String value2) {
            addCriterion("taboo between", value1, value2, "taboo");
            return (Criteria) this;
        }

        public Criteria andTabooNotBetween(String value1, String value2) {
            addCriterion("taboo not between", value1, value2, "taboo");
            return (Criteria) this;
        }

        public Criteria andIndicationIsNull() {
            addCriterion("indication is null");
            return (Criteria) this;
        }

        public Criteria andIndicationIsNotNull() {
            addCriterion("indication is not null");
            return (Criteria) this;
        }

        public Criteria andIndicationEqualTo(String value) {
            addCriterion("indication =", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationNotEqualTo(String value) {
            addCriterion("indication <>", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationGreaterThan(String value) {
            addCriterion("indication >", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationGreaterThanOrEqualTo(String value) {
            addCriterion("indication >=", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationLessThan(String value) {
            addCriterion("indication <", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationLessThanOrEqualTo(String value) {
            addCriterion("indication <=", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationLike(String value) {
            addCriterion("indication like", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationNotLike(String value) {
            addCriterion("indication not like", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationIn(List<String> values) {
            addCriterion("indication in", values, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationNotIn(List<String> values) {
            addCriterion("indication not in", values, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationBetween(String value1, String value2) {
            addCriterion("indication between", value1, value2, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationNotBetween(String value1, String value2) {
            addCriterion("indication not between", value1, value2, "indication");
            return (Criteria) this;
        }

        public Criteria andDosageIsNull() {
            addCriterion("dosage is null");
            return (Criteria) this;
        }

        public Criteria andDosageIsNotNull() {
            addCriterion("dosage is not null");
            return (Criteria) this;
        }

        public Criteria andDosageEqualTo(String value) {
            addCriterion("dosage =", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageNotEqualTo(String value) {
            addCriterion("dosage <>", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageGreaterThan(String value) {
            addCriterion("dosage >", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageGreaterThanOrEqualTo(String value) {
            addCriterion("dosage >=", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageLessThan(String value) {
            addCriterion("dosage <", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageLessThanOrEqualTo(String value) {
            addCriterion("dosage <=", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageLike(String value) {
            addCriterion("dosage like", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageNotLike(String value) {
            addCriterion("dosage not like", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageIn(List<String> values) {
            addCriterion("dosage in", values, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageNotIn(List<String> values) {
            addCriterion("dosage not in", values, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageBetween(String value1, String value2) {
            addCriterion("dosage between", value1, value2, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageNotBetween(String value1, String value2) {
            addCriterion("dosage not between", value1, value2, "dosage");
            return (Criteria) this;
        }

        public Criteria andPropertiesIsNull() {
            addCriterion("properties is null");
            return (Criteria) this;
        }

        public Criteria andPropertiesIsNotNull() {
            addCriterion("properties is not null");
            return (Criteria) this;
        }

        public Criteria andPropertiesEqualTo(String value) {
            addCriterion("properties =", value, "properties");
            return (Criteria) this;
        }

        public Criteria andPropertiesNotEqualTo(String value) {
            addCriterion("properties <>", value, "properties");
            return (Criteria) this;
        }

        public Criteria andPropertiesGreaterThan(String value) {
            addCriterion("properties >", value, "properties");
            return (Criteria) this;
        }

        public Criteria andPropertiesGreaterThanOrEqualTo(String value) {
            addCriterion("properties >=", value, "properties");
            return (Criteria) this;
        }

        public Criteria andPropertiesLessThan(String value) {
            addCriterion("properties <", value, "properties");
            return (Criteria) this;
        }

        public Criteria andPropertiesLessThanOrEqualTo(String value) {
            addCriterion("properties <=", value, "properties");
            return (Criteria) this;
        }

        public Criteria andPropertiesLike(String value) {
            addCriterion("properties like", value, "properties");
            return (Criteria) this;
        }

        public Criteria andPropertiesNotLike(String value) {
            addCriterion("properties not like", value, "properties");
            return (Criteria) this;
        }

        public Criteria andPropertiesIn(List<String> values) {
            addCriterion("properties in", values, "properties");
            return (Criteria) this;
        }

        public Criteria andPropertiesNotIn(List<String> values) {
            addCriterion("properties not in", values, "properties");
            return (Criteria) this;
        }

        public Criteria andPropertiesBetween(String value1, String value2) {
            addCriterion("properties between", value1, value2, "properties");
            return (Criteria) this;
        }

        public Criteria andPropertiesNotBetween(String value1, String value2) {
            addCriterion("properties not between", value1, value2, "properties");
            return (Criteria) this;
        }

        public Criteria andPackingSpecificationIsNull() {
            addCriterion("packing_specification is null");
            return (Criteria) this;
        }

        public Criteria andPackingSpecificationIsNotNull() {
            addCriterion("packing_specification is not null");
            return (Criteria) this;
        }

        public Criteria andPackingSpecificationEqualTo(String value) {
            addCriterion("packing_specification =", value, "packingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackingSpecificationNotEqualTo(String value) {
            addCriterion("packing_specification <>", value, "packingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackingSpecificationGreaterThan(String value) {
            addCriterion("packing_specification >", value, "packingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackingSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("packing_specification >=", value, "packingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackingSpecificationLessThan(String value) {
            addCriterion("packing_specification <", value, "packingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackingSpecificationLessThanOrEqualTo(String value) {
            addCriterion("packing_specification <=", value, "packingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackingSpecificationLike(String value) {
            addCriterion("packing_specification like", value, "packingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackingSpecificationNotLike(String value) {
            addCriterion("packing_specification not like", value, "packingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackingSpecificationIn(List<String> values) {
            addCriterion("packing_specification in", values, "packingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackingSpecificationNotIn(List<String> values) {
            addCriterion("packing_specification not in", values, "packingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackingSpecificationBetween(String value1, String value2) {
            addCriterion("packing_specification between", value1, value2, "packingSpecification");
            return (Criteria) this;
        }

        public Criteria andPackingSpecificationNotBetween(String value1, String value2) {
            addCriterion("packing_specification not between", value1, value2, "packingSpecification");
            return (Criteria) this;
        }

        public Criteria andAdverseReationsIsNull() {
            addCriterion("adverse_reations is null");
            return (Criteria) this;
        }

        public Criteria andAdverseReationsIsNotNull() {
            addCriterion("adverse_reations is not null");
            return (Criteria) this;
        }

        public Criteria andAdverseReationsEqualTo(String value) {
            addCriterion("adverse_reations =", value, "adverseReations");
            return (Criteria) this;
        }

        public Criteria andAdverseReationsNotEqualTo(String value) {
            addCriterion("adverse_reations <>", value, "adverseReations");
            return (Criteria) this;
        }

        public Criteria andAdverseReationsGreaterThan(String value) {
            addCriterion("adverse_reations >", value, "adverseReations");
            return (Criteria) this;
        }

        public Criteria andAdverseReationsGreaterThanOrEqualTo(String value) {
            addCriterion("adverse_reations >=", value, "adverseReations");
            return (Criteria) this;
        }

        public Criteria andAdverseReationsLessThan(String value) {
            addCriterion("adverse_reations <", value, "adverseReations");
            return (Criteria) this;
        }

        public Criteria andAdverseReationsLessThanOrEqualTo(String value) {
            addCriterion("adverse_reations <=", value, "adverseReations");
            return (Criteria) this;
        }

        public Criteria andAdverseReationsLike(String value) {
            addCriterion("adverse_reations like", value, "adverseReations");
            return (Criteria) this;
        }

        public Criteria andAdverseReationsNotLike(String value) {
            addCriterion("adverse_reations not like", value, "adverseReations");
            return (Criteria) this;
        }

        public Criteria andAdverseReationsIn(List<String> values) {
            addCriterion("adverse_reations in", values, "adverseReations");
            return (Criteria) this;
        }

        public Criteria andAdverseReationsNotIn(List<String> values) {
            addCriterion("adverse_reations not in", values, "adverseReations");
            return (Criteria) this;
        }

        public Criteria andAdverseReationsBetween(String value1, String value2) {
            addCriterion("adverse_reations between", value1, value2, "adverseReations");
            return (Criteria) this;
        }

        public Criteria andAdverseReationsNotBetween(String value1, String value2) {
            addCriterion("adverse_reations not between", value1, value2, "adverseReations");
            return (Criteria) this;
        }

        public Criteria andStorageConditionIsNull() {
            addCriterion("storage_condition is null");
            return (Criteria) this;
        }

        public Criteria andStorageConditionIsNotNull() {
            addCriterion("storage_condition is not null");
            return (Criteria) this;
        }

        public Criteria andStorageConditionEqualTo(String value) {
            addCriterion("storage_condition =", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionNotEqualTo(String value) {
            addCriterion("storage_condition <>", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionGreaterThan(String value) {
            addCriterion("storage_condition >", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionGreaterThanOrEqualTo(String value) {
            addCriterion("storage_condition >=", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionLessThan(String value) {
            addCriterion("storage_condition <", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionLessThanOrEqualTo(String value) {
            addCriterion("storage_condition <=", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionLike(String value) {
            addCriterion("storage_condition like", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionNotLike(String value) {
            addCriterion("storage_condition not like", value, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionIn(List<String> values) {
            addCriterion("storage_condition in", values, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionNotIn(List<String> values) {
            addCriterion("storage_condition not in", values, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionBetween(String value1, String value2) {
            addCriterion("storage_condition between", value1, value2, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andStorageConditionNotBetween(String value1, String value2) {
            addCriterion("storage_condition not between", value1, value2, "storageCondition");
            return (Criteria) this;
        }

        public Criteria andVaildPeriodIsNull() {
            addCriterion("vaild_period is null");
            return (Criteria) this;
        }

        public Criteria andVaildPeriodIsNotNull() {
            addCriterion("vaild_period is not null");
            return (Criteria) this;
        }

        public Criteria andVaildPeriodEqualTo(String value) {
            addCriterion("vaild_period =", value, "vaildPeriod");
            return (Criteria) this;
        }

        public Criteria andVaildPeriodNotEqualTo(String value) {
            addCriterion("vaild_period <>", value, "vaildPeriod");
            return (Criteria) this;
        }

        public Criteria andVaildPeriodGreaterThan(String value) {
            addCriterion("vaild_period >", value, "vaildPeriod");
            return (Criteria) this;
        }

        public Criteria andVaildPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("vaild_period >=", value, "vaildPeriod");
            return (Criteria) this;
        }

        public Criteria andVaildPeriodLessThan(String value) {
            addCriterion("vaild_period <", value, "vaildPeriod");
            return (Criteria) this;
        }

        public Criteria andVaildPeriodLessThanOrEqualTo(String value) {
            addCriterion("vaild_period <=", value, "vaildPeriod");
            return (Criteria) this;
        }

        public Criteria andVaildPeriodLike(String value) {
            addCriterion("vaild_period like", value, "vaildPeriod");
            return (Criteria) this;
        }

        public Criteria andVaildPeriodNotLike(String value) {
            addCriterion("vaild_period not like", value, "vaildPeriod");
            return (Criteria) this;
        }

        public Criteria andVaildPeriodIn(List<String> values) {
            addCriterion("vaild_period in", values, "vaildPeriod");
            return (Criteria) this;
        }

        public Criteria andVaildPeriodNotIn(List<String> values) {
            addCriterion("vaild_period not in", values, "vaildPeriod");
            return (Criteria) this;
        }

        public Criteria andVaildPeriodBetween(String value1, String value2) {
            addCriterion("vaild_period between", value1, value2, "vaildPeriod");
            return (Criteria) this;
        }

        public Criteria andVaildPeriodNotBetween(String value1, String value2) {
            addCriterion("vaild_period not between", value1, value2, "vaildPeriod");
            return (Criteria) this;
        }

        public Criteria andPercautionsIsNull() {
            addCriterion("percautions is null");
            return (Criteria) this;
        }

        public Criteria andPercautionsIsNotNull() {
            addCriterion("percautions is not null");
            return (Criteria) this;
        }

        public Criteria andPercautionsEqualTo(String value) {
            addCriterion("percautions =", value, "percautions");
            return (Criteria) this;
        }

        public Criteria andPercautionsNotEqualTo(String value) {
            addCriterion("percautions <>", value, "percautions");
            return (Criteria) this;
        }

        public Criteria andPercautionsGreaterThan(String value) {
            addCriterion("percautions >", value, "percautions");
            return (Criteria) this;
        }

        public Criteria andPercautionsGreaterThanOrEqualTo(String value) {
            addCriterion("percautions >=", value, "percautions");
            return (Criteria) this;
        }

        public Criteria andPercautionsLessThan(String value) {
            addCriterion("percautions <", value, "percautions");
            return (Criteria) this;
        }

        public Criteria andPercautionsLessThanOrEqualTo(String value) {
            addCriterion("percautions <=", value, "percautions");
            return (Criteria) this;
        }

        public Criteria andPercautionsLike(String value) {
            addCriterion("percautions like", value, "percautions");
            return (Criteria) this;
        }

        public Criteria andPercautionsNotLike(String value) {
            addCriterion("percautions not like", value, "percautions");
            return (Criteria) this;
        }

        public Criteria andPercautionsIn(List<String> values) {
            addCriterion("percautions in", values, "percautions");
            return (Criteria) this;
        }

        public Criteria andPercautionsNotIn(List<String> values) {
            addCriterion("percautions not in", values, "percautions");
            return (Criteria) this;
        }

        public Criteria andPercautionsBetween(String value1, String value2) {
            addCriterion("percautions between", value1, value2, "percautions");
            return (Criteria) this;
        }

        public Criteria andPercautionsNotBetween(String value1, String value2) {
            addCriterion("percautions not between", value1, value2, "percautions");
            return (Criteria) this;
        }

        public Criteria andPregnantReminderIsNull() {
            addCriterion("pregnant_reminder is null");
            return (Criteria) this;
        }

        public Criteria andPregnantReminderIsNotNull() {
            addCriterion("pregnant_reminder is not null");
            return (Criteria) this;
        }

        public Criteria andPregnantReminderEqualTo(String value) {
            addCriterion("pregnant_reminder =", value, "pregnantReminder");
            return (Criteria) this;
        }

        public Criteria andPregnantReminderNotEqualTo(String value) {
            addCriterion("pregnant_reminder <>", value, "pregnantReminder");
            return (Criteria) this;
        }

        public Criteria andPregnantReminderGreaterThan(String value) {
            addCriterion("pregnant_reminder >", value, "pregnantReminder");
            return (Criteria) this;
        }

        public Criteria andPregnantReminderGreaterThanOrEqualTo(String value) {
            addCriterion("pregnant_reminder >=", value, "pregnantReminder");
            return (Criteria) this;
        }

        public Criteria andPregnantReminderLessThan(String value) {
            addCriterion("pregnant_reminder <", value, "pregnantReminder");
            return (Criteria) this;
        }

        public Criteria andPregnantReminderLessThanOrEqualTo(String value) {
            addCriterion("pregnant_reminder <=", value, "pregnantReminder");
            return (Criteria) this;
        }

        public Criteria andPregnantReminderLike(String value) {
            addCriterion("pregnant_reminder like", value, "pregnantReminder");
            return (Criteria) this;
        }

        public Criteria andPregnantReminderNotLike(String value) {
            addCriterion("pregnant_reminder not like", value, "pregnantReminder");
            return (Criteria) this;
        }

        public Criteria andPregnantReminderIn(List<String> values) {
            addCriterion("pregnant_reminder in", values, "pregnantReminder");
            return (Criteria) this;
        }

        public Criteria andPregnantReminderNotIn(List<String> values) {
            addCriterion("pregnant_reminder not in", values, "pregnantReminder");
            return (Criteria) this;
        }

        public Criteria andPregnantReminderBetween(String value1, String value2) {
            addCriterion("pregnant_reminder between", value1, value2, "pregnantReminder");
            return (Criteria) this;
        }

        public Criteria andPregnantReminderNotBetween(String value1, String value2) {
            addCriterion("pregnant_reminder not between", value1, value2, "pregnantReminder");
            return (Criteria) this;
        }

        public Criteria andYoungReminderIsNull() {
            addCriterion("young_reminder is null");
            return (Criteria) this;
        }

        public Criteria andYoungReminderIsNotNull() {
            addCriterion("young_reminder is not null");
            return (Criteria) this;
        }

        public Criteria andYoungReminderEqualTo(String value) {
            addCriterion("young_reminder =", value, "youngReminder");
            return (Criteria) this;
        }

        public Criteria andYoungReminderNotEqualTo(String value) {
            addCriterion("young_reminder <>", value, "youngReminder");
            return (Criteria) this;
        }

        public Criteria andYoungReminderGreaterThan(String value) {
            addCriterion("young_reminder >", value, "youngReminder");
            return (Criteria) this;
        }

        public Criteria andYoungReminderGreaterThanOrEqualTo(String value) {
            addCriterion("young_reminder >=", value, "youngReminder");
            return (Criteria) this;
        }

        public Criteria andYoungReminderLessThan(String value) {
            addCriterion("young_reminder <", value, "youngReminder");
            return (Criteria) this;
        }

        public Criteria andYoungReminderLessThanOrEqualTo(String value) {
            addCriterion("young_reminder <=", value, "youngReminder");
            return (Criteria) this;
        }

        public Criteria andYoungReminderLike(String value) {
            addCriterion("young_reminder like", value, "youngReminder");
            return (Criteria) this;
        }

        public Criteria andYoungReminderNotLike(String value) {
            addCriterion("young_reminder not like", value, "youngReminder");
            return (Criteria) this;
        }

        public Criteria andYoungReminderIn(List<String> values) {
            addCriterion("young_reminder in", values, "youngReminder");
            return (Criteria) this;
        }

        public Criteria andYoungReminderNotIn(List<String> values) {
            addCriterion("young_reminder not in", values, "youngReminder");
            return (Criteria) this;
        }

        public Criteria andYoungReminderBetween(String value1, String value2) {
            addCriterion("young_reminder between", value1, value2, "youngReminder");
            return (Criteria) this;
        }

        public Criteria andYoungReminderNotBetween(String value1, String value2) {
            addCriterion("young_reminder not between", value1, value2, "youngReminder");
            return (Criteria) this;
        }

        public Criteria andOldReminderIsNull() {
            addCriterion("old_reminder is null");
            return (Criteria) this;
        }

        public Criteria andOldReminderIsNotNull() {
            addCriterion("old_reminder is not null");
            return (Criteria) this;
        }

        public Criteria andOldReminderEqualTo(String value) {
            addCriterion("old_reminder =", value, "oldReminder");
            return (Criteria) this;
        }

        public Criteria andOldReminderNotEqualTo(String value) {
            addCriterion("old_reminder <>", value, "oldReminder");
            return (Criteria) this;
        }

        public Criteria andOldReminderGreaterThan(String value) {
            addCriterion("old_reminder >", value, "oldReminder");
            return (Criteria) this;
        }

        public Criteria andOldReminderGreaterThanOrEqualTo(String value) {
            addCriterion("old_reminder >=", value, "oldReminder");
            return (Criteria) this;
        }

        public Criteria andOldReminderLessThan(String value) {
            addCriterion("old_reminder <", value, "oldReminder");
            return (Criteria) this;
        }

        public Criteria andOldReminderLessThanOrEqualTo(String value) {
            addCriterion("old_reminder <=", value, "oldReminder");
            return (Criteria) this;
        }

        public Criteria andOldReminderLike(String value) {
            addCriterion("old_reminder like", value, "oldReminder");
            return (Criteria) this;
        }

        public Criteria andOldReminderNotLike(String value) {
            addCriterion("old_reminder not like", value, "oldReminder");
            return (Criteria) this;
        }

        public Criteria andOldReminderIn(List<String> values) {
            addCriterion("old_reminder in", values, "oldReminder");
            return (Criteria) this;
        }

        public Criteria andOldReminderNotIn(List<String> values) {
            addCriterion("old_reminder not in", values, "oldReminder");
            return (Criteria) this;
        }

        public Criteria andOldReminderBetween(String value1, String value2) {
            addCriterion("old_reminder between", value1, value2, "oldReminder");
            return (Criteria) this;
        }

        public Criteria andOldReminderNotBetween(String value1, String value2) {
            addCriterion("old_reminder not between", value1, value2, "oldReminder");
            return (Criteria) this;
        }

        public Criteria andInteractionIsNull() {
            addCriterion("interaction is null");
            return (Criteria) this;
        }

        public Criteria andInteractionIsNotNull() {
            addCriterion("interaction is not null");
            return (Criteria) this;
        }

        public Criteria andInteractionEqualTo(String value) {
            addCriterion("interaction =", value, "interaction");
            return (Criteria) this;
        }

        public Criteria andInteractionNotEqualTo(String value) {
            addCriterion("interaction <>", value, "interaction");
            return (Criteria) this;
        }

        public Criteria andInteractionGreaterThan(String value) {
            addCriterion("interaction >", value, "interaction");
            return (Criteria) this;
        }

        public Criteria andInteractionGreaterThanOrEqualTo(String value) {
            addCriterion("interaction >=", value, "interaction");
            return (Criteria) this;
        }

        public Criteria andInteractionLessThan(String value) {
            addCriterion("interaction <", value, "interaction");
            return (Criteria) this;
        }

        public Criteria andInteractionLessThanOrEqualTo(String value) {
            addCriterion("interaction <=", value, "interaction");
            return (Criteria) this;
        }

        public Criteria andInteractionLike(String value) {
            addCriterion("interaction like", value, "interaction");
            return (Criteria) this;
        }

        public Criteria andInteractionNotLike(String value) {
            addCriterion("interaction not like", value, "interaction");
            return (Criteria) this;
        }

        public Criteria andInteractionIn(List<String> values) {
            addCriterion("interaction in", values, "interaction");
            return (Criteria) this;
        }

        public Criteria andInteractionNotIn(List<String> values) {
            addCriterion("interaction not in", values, "interaction");
            return (Criteria) this;
        }

        public Criteria andInteractionBetween(String value1, String value2) {
            addCriterion("interaction between", value1, value2, "interaction");
            return (Criteria) this;
        }

        public Criteria andInteractionNotBetween(String value1, String value2) {
            addCriterion("interaction not between", value1, value2, "interaction");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberIsNull() {
            addCriterion("approval_number is null");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberIsNotNull() {
            addCriterion("approval_number is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberEqualTo(String value) {
            addCriterion("approval_number =", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotEqualTo(String value) {
            addCriterion("approval_number <>", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberGreaterThan(String value) {
            addCriterion("approval_number >", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberGreaterThanOrEqualTo(String value) {
            addCriterion("approval_number >=", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberLessThan(String value) {
            addCriterion("approval_number <", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberLessThanOrEqualTo(String value) {
            addCriterion("approval_number <=", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberLike(String value) {
            addCriterion("approval_number like", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotLike(String value) {
            addCriterion("approval_number not like", value, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberIn(List<String> values) {
            addCriterion("approval_number in", values, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotIn(List<String> values) {
            addCriterion("approval_number not in", values, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberBetween(String value1, String value2) {
            addCriterion("approval_number between", value1, value2, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andApprovalNumberNotBetween(String value1, String value2) {
            addCriterion("approval_number not between", value1, value2, "approvalNumber");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
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