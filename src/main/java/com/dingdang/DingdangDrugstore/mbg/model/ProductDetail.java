package com.dingdang.DingdangDrugstore.mbg.model;

import java.io.Serializable;

public class ProductDetail implements Serializable {
    private Long id;

    private Long productId;

    private String productSn;

    private String commonName;

    private String productName;

    private String ingredients;

    private String taboo;

    private String indication;

    private String dosage;

    private String properties;

    private String packingSpecification;

    private String adverseReations;

    private String storageCondition;

    private String vaildPeriod;

    private String percautions;

    private String pregnantReminder;

    private String youngReminder;

    private String oldReminder;

    private String interaction;

    private String approvalNumber;

    private String manufacturer;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getTaboo() {
        return taboo;
    }

    public void setTaboo(String taboo) {
        this.taboo = taboo;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getPackingSpecification() {
        return packingSpecification;
    }

    public void setPackingSpecification(String packingSpecification) {
        this.packingSpecification = packingSpecification;
    }

    public String getAdverseReations() {
        return adverseReations;
    }

    public void setAdverseReations(String adverseReations) {
        this.adverseReations = adverseReations;
    }

    public String getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }

    public String getVaildPeriod() {
        return vaildPeriod;
    }

    public void setVaildPeriod(String vaildPeriod) {
        this.vaildPeriod = vaildPeriod;
    }

    public String getPercautions() {
        return percautions;
    }

    public void setPercautions(String percautions) {
        this.percautions = percautions;
    }

    public String getPregnantReminder() {
        return pregnantReminder;
    }

    public void setPregnantReminder(String pregnantReminder) {
        this.pregnantReminder = pregnantReminder;
    }

    public String getYoungReminder() {
        return youngReminder;
    }

    public void setYoungReminder(String youngReminder) {
        this.youngReminder = youngReminder;
    }

    public String getOldReminder() {
        return oldReminder;
    }

    public void setOldReminder(String oldReminder) {
        this.oldReminder = oldReminder;
    }

    public String getInteraction() {
        return interaction;
    }

    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", productSn=").append(productSn);
        sb.append(", commonName=").append(commonName);
        sb.append(", productName=").append(productName);
        sb.append(", ingredients=").append(ingredients);
        sb.append(", taboo=").append(taboo);
        sb.append(", indication=").append(indication);
        sb.append(", dosage=").append(dosage);
        sb.append(", properties=").append(properties);
        sb.append(", packingSpecification=").append(packingSpecification);
        sb.append(", adverseReations=").append(adverseReations);
        sb.append(", storageCondition=").append(storageCondition);
        sb.append(", vaildPeriod=").append(vaildPeriod);
        sb.append(", percautions=").append(percautions);
        sb.append(", pregnantReminder=").append(pregnantReminder);
        sb.append(", youngReminder=").append(youngReminder);
        sb.append(", oldReminder=").append(oldReminder);
        sb.append(", interaction=").append(interaction);
        sb.append(", approvalNumber=").append(approvalNumber);
        sb.append(", manufacturer=").append(manufacturer);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}