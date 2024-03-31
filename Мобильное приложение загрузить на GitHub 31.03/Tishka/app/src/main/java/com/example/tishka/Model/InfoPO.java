package com.example.tishka.Model;

public class InfoPO {
    private String info, pid, date, time;

    public InfoPO(){


    }

    public InfoPO(String info, String pid, String date, String time) {
        this.info = info;
        this.pid = pid;
        this.date = date;
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
