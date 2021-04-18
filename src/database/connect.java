package database;


import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class connect {

    public static Connection con;

    public static Connection getConnect() {
        try {
            String databaseURL = "jdbc:mysql://localhost:3306/quanlynhahang";
            String userName = "root";
            String passWord = "";
            con = DriverManager.getConnection(databaseURL, userName, passWord);
//            System.out.println("Ket Noi Thanh Cong");
        } catch (Exception e) {
//            System.out.println("Ket Noi Khong Thanh Cong");
        }
        return con;
    }
}
