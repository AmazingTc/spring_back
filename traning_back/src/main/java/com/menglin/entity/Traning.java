package com.menglin.entity;

public class Traning {
    private int id;
    private int traning_id;
    private String traning_program;
    private String traning_data;
    private int traning_personnum;
    private String traning_address;
    @Override
    public String toString() {
        return "Traning{" +
                "id=" + id +
                ", traning_id=" + traning_id +
                ", traning_program='" + traning_program + '\'' +
                ", traning_data='" + traning_data + '\'' +
                ", traning_personnum=" + traning_personnum +
                ", traning_address='" + traning_address + '\'' +
                '}';
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getTraning_id() {
        return traning_id;
    }
    public void setTraning_id(int traning_id) {
        this.traning_id = traning_id;
    }
    public String getTraning_program() {
        return traning_program;
    }
    public void setTraning_program(String traning_program) {
        this.traning_program = traning_program;
    }
    public String getTraning_data() {
        return traning_data;
    }
    public void setTraning_data(String traning_data) {
        this.traning_data = traning_data;
    }
    public int getTraning_personnum() {
        return traning_personnum;
    }
    public void setTraning_personnum(int traning_personnum) {
        this.traning_personnum = traning_personnum;
    }
    public String getTraning_address() {
        return traning_address;
    }
    public void setTraning_address(String traning_address) {
        this.traning_address = traning_address;
    }
    public Traning() {
    }
    public Traning(int id, int traning_id, String traning_program, String traning_data, int traning_personnum, String traning_address) {
        this.id = id;
        this.traning_id = traning_id;
        this.traning_program = traning_program;
        this.traning_data = traning_data;
        this.traning_personnum = traning_personnum;
        this.traning_address = traning_address;
    }
}
