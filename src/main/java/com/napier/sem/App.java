package com.napier.sem;

import com.napier.sem.driver.DBDriverMysql;

import java.sql.SQLOutput;

public class App {
    private static final String DB_URL = "jdbc:mysql://db:3306/world?useSSL=false";
    private static final String DB_PASSWORD = "semcoursework";

    public static void main(String[] args) {
        DBDriverMysql db = new DBDriverMysql(DB_URL, DB_PASSWORD);

        db.connect();
        db.disconnect();
    }

}