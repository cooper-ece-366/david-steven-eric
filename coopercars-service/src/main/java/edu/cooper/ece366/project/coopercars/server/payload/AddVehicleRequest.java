package edu.cooper.ece366.project.coopercars.server.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AddVehicleRequest {
    @NotBlank
    private String VIN;

    @NotBlank
    private String dealerPrice;

    @NotBlank
    private String salePrice;

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getDealerPrice() {
        return dealerPrice;
    }

    public void setDealerPrice(String dealerPrice) {
        this.dealerPrice = dealerPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }
}