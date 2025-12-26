package com.example.demo.dto;

public class DemandForecastRequestDto {

    private Long productId;
    private Long storeId;

    public DemandForecastRequestDto() {}

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
