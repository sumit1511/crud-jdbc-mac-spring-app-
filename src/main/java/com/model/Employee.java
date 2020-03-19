package com.model;

import javax.servlet.http.HttpServletRequest;

public class Employee {
    private String empName;
    private String empCity;
    private int empAge;
    private String empDept;
    public Employee(HttpServletRequest httpServletRequest)
    {
        empName= httpServletRequest.getParameter("empName");
        empCity= httpServletRequest.getParameter("empCity");
        empAge= Integer.parseInt(httpServletRequest.getParameter("empAge"));
        empDept= httpServletRequest.getParameter("empDept");
    }


    public String getEmpName() {
        return empName;
    }

    public String getEmpCity() {
        return empCity;
    }

    public int getEmpAge() {
        return empAge;
    }

    public String getEmpDept() {
        return empDept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", empName='" + empName + '\'' +
                ", empCity='" + empCity + '\'' +
                ", empAge=" + empAge +
                ", empDept='" + empDept + '\'' +
                '}';
    }
}
