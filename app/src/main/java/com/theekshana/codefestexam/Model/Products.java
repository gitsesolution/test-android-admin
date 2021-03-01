package com.theekshana.codefestexam.Model;

public class Products {

    String ProName;
    String ProImage;
    String ProDis;
    String ProPrice;

    public Products(String proName, String proImage, String proDis, String proPrice) {
        ProName = proName;
        ProImage = proImage;
        ProDis = proDis;
        ProPrice = proPrice;
    }

    public Products() {
    }

    public String getProName() {
        return ProName;
    }

    public void setProName(String proName) {
        ProName = proName;
    }

    public String getProImage() {
        return ProImage;
    }

    public void setProImage(String proImage) {
        ProImage = proImage;
    }

    public String getProDis() {
        return ProDis;
    }

    public void setProDis(String proDis) {
        ProDis = proDis;
    }

    public String getProPrice() {
        return ProPrice;
    }

    public void setProPrice(String proPrice) {
        ProPrice = proPrice;
    }
}
