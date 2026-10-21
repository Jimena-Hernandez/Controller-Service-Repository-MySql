package com.example.products.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public class RequestDiscountProduct {

    @NotNull
    @Min(1)
    @Max(100)
    Double percentage;


    
    public RequestDiscountProduct() {
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    
}
