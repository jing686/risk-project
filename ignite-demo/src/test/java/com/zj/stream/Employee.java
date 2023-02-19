package com.zj.stream;

import com.alibaba.fastjson.JSON;

public class Employee {
    //姓名
    private String name;
    //年龄
    private Integer age;
    //性别
    private String sex;
    //薪资
    private Double salary;
    //住址
    private String address;
    //工作地
    private String baseAddress;
    //职位
    private String position;
    //主管
    private Employee employee;

    public Employee(String name, Integer age, String sex, Double salary, String address, String baseAddress, String position, Employee employee) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
        this.address = address;
        this.baseAddress = baseAddress;
        this.position = position;
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}