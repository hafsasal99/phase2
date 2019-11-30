package com.Model;

public class shopfriendly {
    private String company;
    private String description;
    private int carbonFootprint;

    public shopfriendly(String company, String description, int carbonFootprint) {
        this.company = company;
        this.description = description;
        this.carbonFootprint = carbonFootprint;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCarbonFootprint() {
        return carbonFootprint;
    }

    public void setCarbonFootprint(int carbonFootprint) {
        this.carbonFootprint = carbonFootprint;
    }
}
