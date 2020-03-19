package com.controller;
import com.helper.JDBCHelper;
import com.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBQueries extends MultiActionController {

    public ModelAndView insertEmployee(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws SQLException {
        Connection connection = null;

        try {
            Employee employee = new Employee(httpServletRequest);
            connection = JDBCHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement( "INSERT INTO employeeTable(empName,empCity,empAge,empDept)VALUES(?,?,?,?)");
            preparedStatement.setString(1,employee.getEmpName());
            preparedStatement.setString(2,employee.getEmpCity());
            preparedStatement.setString(3,Integer.toString(employee.getEmpAge()));
            preparedStatement.setString(4,employee.getEmpDept());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCHelper.closeConnection(connection);
        }
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("data","insert process is field");
      return modelAndView;
    }

    public ModelAndView searchEmployee(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws SQLException {
        Connection connection = null;
        String employee = null;
        try {

            connection = JDBCHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employeeTable where empId=?");
            preparedStatement.setString(1,httpServletRequest.getParameter("empId"));
            ResultSet resultSet=preparedStatement.executeQuery();
           if(resultSet.next()) {
               employee = resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " "
                       + resultSet.getString(4) + " " + resultSet.getString(5);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCHelper.closeConnection(connection);
        }
        ModelAndView modelAndView = new  ModelAndView("result");
        modelAndView.addObject("data",employee);
        return modelAndView;
    }

    public ModelAndView updateEmployee(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws SQLException {
        Connection connection = null;

        try {

            connection = JDBCHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update employeeTable set empName=? where empId=?");
            preparedStatement.setString(1,httpServletRequest.getParameter("empName"));
            preparedStatement.setString(2,httpServletRequest.getParameter("empId"));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCHelper.closeConnection(connection);
        }
        ModelAndView modelAndView = new  ModelAndView("result");
        modelAndView.addObject("data","updating process complete");
        return modelAndView;
    }

    public ModelAndView deleteEmployee(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws SQLException {
        Connection connection = null;
        try {

            connection = JDBCHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from employeeTable where empId=?");
            preparedStatement.setString(1,httpServletRequest.getParameter("empId"));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCHelper.closeConnection(connection);
        }
        ModelAndView modelAndView = new  ModelAndView("result");
        modelAndView.addObject("data","delete from database");
        return modelAndView;
    }

    public ModelAndView readAllEmployee(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws SQLException {
        Connection connection = null;
        String employee = "";
        try {

            connection = JDBCHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employeeTable");
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()) {
                employee= employee+ resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " "
                        + resultSet.getString(4) + " " + resultSet.getString(5)+"</br>";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCHelper.closeConnection(connection);
        }
        ModelAndView modelAndView = new  ModelAndView("result");
        modelAndView.addObject("data",employee);
        return modelAndView;
    }

}
