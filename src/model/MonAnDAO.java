/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import database.connect;
import view.frmMain;

/**
 *
 * @author PC
 */
public class MonAnDAO {
    public static PreparedStatement prepare;
    private ArrayList<MonAn> list = new ArrayList<>();
    //Them mon an
    public void AddMonAn(MonAn f) throws SQLException {
        String command = "INSERT INTO qlmonan values(?,?,?)";
        try {

            prepare = connect.con.prepareStatement(command);
            prepare.setInt(1, f.getIdMonAn());
            prepare.setString(2, f.getTenMon());
            prepare.setDouble(3, f.getGia());
            prepare.execute();
            JOptionPane.showMessageDialog(null, "Them Thanh Cong");
        } catch (HeadlessException | SQLException e) {
        }
    }
   // Tra ve chuoi mon an
    public ArrayList<MonAn> Show() {
        return list;
    }
    //Hien thi tat ca mon an
    public ArrayList<MonAn> ShowAll() throws SQLException {
        list.clear();
        Connection conn = connect.getConnect();
        Statement st = null;
        ResultSet rs = null;

        String sql = "select * from qlmonan ORDER BY idMon";
        st = conn.createStatement();
        rs = st.executeQuery(sql);

        while (rs.next()) {
            MonAn f = new MonAn();
            f.setIdMonAn(rs.getInt("idMon"));
            f.setTenMon((rs.getString("tenMon")));
            f.setGia((rs.getFloat("gia")));
            list.add(f);
        }
        return list;
    }
   
    //Xoa mon an
    public  void deleteFood(int id){
        String sql="DELETE FROM qlmonan WHERE idMon=?";
        try{
            prepare=connect.getConnect().prepareStatement(sql);
            prepare.setInt(1, id);
            prepare.execute();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Xóa món ăn thất bại!");
        }
    }
    //Cap nhat mon an
    public void updateFood(MonAn ma){
        String sql="UPDATE `qlmonan` SET `tenMon` = ?, `gia` = ? WHERE `qlmonan`.`idMon` = ?;";
        try{
            prepare=connect.getConnect().prepareStatement(sql);
            prepare.setString(1, ma.getTenMon());
            prepare.setFloat(2, ma.getGia());
            prepare.setInt(3, ma.getIdMonAn());
            prepare.execute();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Chỉnh sửa món ăn thất bại!");
        }
    }
    //Kiem tra mon an da ton tai hay chua
   
  
    //Tao su kien them mon an
    
   
}
