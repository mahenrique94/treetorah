package br.com.matheuscastiglioni.treetorah.models;

import java.io.Serializable;

public class Reforestation implements Serializable {

    private String id;
    private Integer year;
    private String state;
    private Integer treesCutted;
    private Integer volume;

    public Reforestation() {}

    public Reforestation(int year, String state, int treesCutted, int volume) {
        this.year = year;
        this.state = state;
        this.treesCutted = treesCutted;
        this.volume = volume;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Integer getTreesCutted() {
        return treesCutted;
    }
    public void setTreesCutted(Integer treesCutted) {
        this.treesCutted = treesCutted;
    }
    public Integer getVolume() {
        return volume;
    }
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getTreesToReplace() {
        return this.getVolume() * 6;
    }

    public Double getValueToPay() {
        return this.getTreesCutted() * 0.75;
    }

}
