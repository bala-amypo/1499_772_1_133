package com.example.demo.dto;

public class DemandForecastResponseDto {

    private Long productId;
    private Long storeId;
    private int predictedDemand;

    public DemandForecastResponseDto() {}

    public DemandForecastResponseDto(Long productId, Long storeId, int predictedDemand) {
        this.productId = productId;
        this.storeId = storeId;
        this.predictedDemand = predictedDemand;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public int getPredictedDemand() {
        return predictedDemand;
    }
}
