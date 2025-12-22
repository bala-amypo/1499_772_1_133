package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DemandForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Store store;

    private LocalDate forecastDate;
    private Integer predictedDemand;
    private Double confidenceScore;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    public LocalDate getForecastDate() {
        return forecastDate;
    }
    public void setForecastDate(LocalDate forecastDate) {
        this.forecastDate = forecastDate;
    }
    public Integer getPredictedDemand() {
        return predictedDemand;
    }
    public void setPredictedDemand(Integer predictedDemand) {
        this.predictedDemand = predictedDemand;
    }
    public Double getConfidenceScore() {
        return confidenceScore;
    }
    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }
    public DemandForecast() {
    }
    public DemandForecast(Long id, Product product, Store store, LocalDate forecastDate, Integer predictedDemand,
            Double confidenceScore) {
        this.id = id;
        this.product = product;
        this.store = store;
        this.forecastDate = forecastDate;
        this.predictedDemand = predictedDemand;
        this.confidenceScore = confidenceScore;
    }

    
}
