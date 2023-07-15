package com.menglin.entity;

public class Employee {
    private int employee_id;
    private String employee_name;
    private int employee_age;
    private int traning_id;
    private String employee_address;
    private String employee_phone;
    private String employee_sex;

    private Boolean isComplete;

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    public int getTraning_id() {
        return traning_id;
    }

    public void setTraning_id(int traning_id) {
        this.traning_id = traning_id;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_sex() {
        return employee_sex;
    }

    public void setEmployee_sex(String employee_sex) {
        this.employee_sex = employee_sex;
    }

    public int getEmployee_id() {
        return employee_id;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", employee_name='" + employee_name + '\'' +
                ", employee_age=" + employee_age +
                ", traning_id=" + traning_id +
                ", employee_address='" + employee_address + '\'' +
                ", employee_phone='" + employee_phone + '\'' +
                ", employee_sex='" + employee_sex + '\'' +
                '}';
    }


    public Employee(int employee_id, String employee_name, int employee_age, int traning_id, String employee_address, String employee_phone, String employee_sex) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_age = employee_age;
        this.traning_id = traning_id;
        this.employee_address = employee_address;
        this.employee_phone = employee_phone;
        this.employee_sex = employee_sex;
    }
}
