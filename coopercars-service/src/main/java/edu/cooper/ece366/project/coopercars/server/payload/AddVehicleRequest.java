package edu.cooper.ece366.project.coopercars.server.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


//Eric
//simple class that works with API when creating a new Vehicle object
public class AddVehicleRequest {
    @NotBlank
    private String VIN;

    @NotBlank
    private String dealerPrice;

    @NotBlank
    private String salePrice;

    @NotBlank
    private String mileage;

    @NotBlank
    private String status;

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

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}