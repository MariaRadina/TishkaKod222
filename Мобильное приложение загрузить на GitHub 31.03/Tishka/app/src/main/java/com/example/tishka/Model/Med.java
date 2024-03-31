package com.example.tishka.Model;

public class Med {
    private String name,kol, zak, prod, postav, srokgodn;
    public Med(){

    }

    public Med(String name, String kol, String zak, String prod, String postav, String srokgodn) {
        this.name = name;
        this.kol = kol;
        this.zak = zak;
        this.prod = prod;
        this.postav = postav;
        this.srokgodn = srokgodn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKol() {
        return kol;
    }

    public void setKol(String kol) {
        this.kol = kol;
    }

    public String getZak() {
        return zak;
    }

    public void setZak(String zak) {
        this.zak = zak;
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

    public String getPostav() {
        return postav;
    }

    public void setPostav(String postav) {
        this.postav = postav;
    }

    public String getSrokgodn() {
        return srokgodn;
    }

    public void setSrokgodn(String srokgodn) {
        this.srokgodn = srokgodn;
    }
}
