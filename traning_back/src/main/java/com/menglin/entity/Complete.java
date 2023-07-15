package com.menglin.entity;

public class Complete {
    private Integer employee_id;
    private Integer traning_id;
    private Integer complete;

    public Integer getEmployee_id() {
        return employee_id;
    }

    @Override
    public String toString() {
        return "Complete{" +
                "employee_id=" + employee_id +
                ", traning_id=" + traning_id +
                ", complete=" + complete +
                '}';
    }

    public Complete() {
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public Integer getTraning_id() {
        return traning_id;
    }

    public void setTraning_id(Integer traning_id) {
        this.traning_id = traning_id;
    }

    public Integer getComplete() {
        return complete;
    }

    public void setComplete(Integer complete) {
        this.complete = complete;
    }

    public Complete(Integer employee_id, Integer traning_id, Integer complete) {
        this.employee_id = employee_id;
        this.traning_id = traning_id;
        this.complete = complete;
    }
}
