package com.helper;
public class JDBCConstants {


    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";    // these variable should be static and final and if we take static we can not read from property file
                                                                             // because if we use @value those variable init at object creation time so before creating object if we use
                                                                            // it will give null value
    public static final String URL         = "jdbc:mysql://localhost:3306/Employee";
    public static final String USERNAME    = "root";
    public static final String PASSWORD    = "root";
}
