package com.example.demo.dto;

public class InventoryResponseDTO {

    private Long productId;
    private Long storeId;
    private int quantity;

    public InventoryResponseDTO() {}

    public InventoryResponseDTO(Long productId, Long storeId, int quantity) {
        this.productId = productId;
        this.storeId = storeId;
        this.quantity = quantity;
    }

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
