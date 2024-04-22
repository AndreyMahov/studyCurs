package org.mahov.streamApi;

public class StockBlock {
    private Integer amount;
    private Integer purchaseYear;

    public StockBlock(Integer amount, Integer purchaseYear) {
        this.amount = amount;
        this.purchaseYear = purchaseYear;
    }

    public StockBlock() {
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPurchaseYear() {
        return purchaseYear;
    }

    public void setPurchaseYear(Integer purchaseYear) {
        this.purchaseYear = purchaseYear;
    }
}
