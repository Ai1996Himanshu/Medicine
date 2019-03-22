package com.arya.medicine;

public class med_detail {
    public  String user;
    public String detail;
    public String manData;
    public String expData;
    public String bNo;
    public String quantity;
    public String medUrl;
    public String billUrl;

    public med_detail() {
    }

    public med_detail(String user, String detail, String manData, String expData, String bNo, String quantity, String medUrl, String billUrl) {
        this.user = user;
        this.detail = detail;
        this.manData = manData;
        this.expData = expData;
        this.bNo = bNo;
        this.quantity = quantity;
        this.medUrl = medUrl;
        this.billUrl = billUrl;
    }
}
