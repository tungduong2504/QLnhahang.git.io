/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.toedter.calendar.JDateChooser;
import database.connect;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author hongl
 */
public class HoaDonDao {

    public static PreparedStatement prepare;
    ResultSet rs;
    private ArrayList<HoaDon> list = new ArrayList<>();

    //Them hoa don
    public void AddHoaDon(int dem, HoaDon h, int maID) throws SQLException {
//        `idhoadon`, `idmon`(idhoadon,`ngay`, `loai`, `tong`,idmon) 
        String command = "INSERT INTO `hoadon` (`idhoadon`, `ngay`, `loai`, `tong`, `idmon`) VALUES (?, ?, ?, ?, ?);";
        try {
            prepare = connect.con.prepareStatement(command);
            prepare.setInt(1, dem);
            prepare.setString(2, h.getNgay());
            prepare.setString(3, h.getLoai());
            prepare.setFloat(4, h.getTong());
            prepare.setInt(5, maID);
            prepare.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Them Khong Thanh Cong!" + e);
        }

    }

    public int layMaTheoTen(String s) throws Exception {
        int maMon = 0;
        String command = "Select idMon from qlmonan where tenMon = ?";
        try {
            prepare = connect.con.prepareStatement(command);
            prepare.setString(1, s);
            rs = prepare.executeQuery();
            //prepare.execute();
            JOptionPane.showMessageDialog(null, "Them Thanh Cong^^");
            while (rs.next()) {
                maMon = rs.getInt("idMon");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Them Khong Thanh Cong!" + e);
        }
        return maMon;
    }
    //Xu ly thong ke 

    public ArrayList<HoaDon> ThongKe() throws SQLException {
        list.clear();
        Connection conn = connect.getConnect();
        Statement st = null;
        ResultSet rs = null;

        String sql = " SELECT idhoadon, tong, ngay FROM `hoadon` ORDER BY idhoadon";
        st = conn.createStatement();
        rs = st.executeQuery(sql);

        while (rs.next()) {
            HoaDon h = new HoaDon();
            h.setIdHoaDon(rs.getInt("idhoadon"));
            h.setTong(rs.getFloat("tong"));
            h.setNgay(rs.getString("ngay"));
            list.add(h);
        }
        return list;
    }

    //Lay thong tin chi tiet hoa don

    public ArrayList<HoaDon> ChiTietHoaDon() throws SQLException {
        list.clear();
        Connection conn = connect.getConnect();
        Statement st = null;
        ResultSet rs = null;

        String sql = " SELECT idhoadon, ngay, loai, tong FROM `hoadon` ORDER BY idhoadon";
        st = conn.createStatement();
        rs = st.executeQuery(sql);

        while (rs.next()) {
            HoaDon h = new HoaDon();
            h.setIdHoaDon(rs.getInt("idhoadon"));
            h.setNgay(rs.getString("ngay"));
            h.setLoai(rs.getString("loai"));
            h.setTong(rs.getFloat("tong"));
            list.add(h);
        }
        return list;
    }

    public ArrayList<HoaDon> ChiTietHoaDonTimKiem(String id) throws SQLException {
        list.clear();
        Connection conn = connect.getConnect();
        Statement st = null;
        ResultSet rs = null;

        String sql = " SELECT idhoadon, ngay, loai, tong FROM `hoadon` WHERE idhoadon = " + id + "";
        st = conn.createStatement();
        rs = st.executeQuery(sql);

        while (rs.next()) {
            HoaDon h = new HoaDon();
            h.setIdHoaDon(rs.getInt("idhoadon"));
            h.setNgay(rs.getString("ngay"));
            h.setLoai(rs.getString("loai"));
            h.setTong(rs.getFloat("tong"));
            list.add(h);
        }
        return list;
    }

    //Thong ke theo ngay

    public ArrayList<HoaDon> ThongKeTheoNgay(String date1,String date2) throws SQLException {
        list.clear();
        Connection conn = connect.getConnect();
        Statement st = null;
        ResultSet rs = null;

        String sql = " SELECT idhoadon,tong,ngay FROM hoadon WHERE ngay BETWEEN '"+date1+"' AND '"+date2+"' ORDER BY idhoadon";
        st = conn.createStatement();
        rs = st.executeQuery(sql);

        while (rs.next()) {
            HoaDon h = new HoaDon();
            h.setIdHoaDon(rs.getInt("idhoadon"));
            h.setTong(rs.getFloat("tong"));
            h.setNgay(rs.getString("ngay"));
            list.add(h);
        }
        return list;
    }

    public Iterable<HoaDon> ThongKeTheoNgay(JDateChooser dTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<MonAn> ReadTableByFile(String path) throws FileNotFoundException, IOException {
        ArrayList<MonAn> mm = new ArrayList<>();
        File f = new File(path);
        FileReader fD = new FileReader(f);
        BufferedReader bR = new BufferedReader(fD);
        String line;
        String[] value;
        while ((line = bR.readLine()) != null) {
            int i = 0;
            value = line.split("@");
            MonAn item = new MonAn(i, value[0], Float.parseFloat(value[1]));
            mm.add(item);
        }
        fD.close();
        return mm;
    }

    public void WriteTable(String path, ArrayList<MonAn> writeList) throws IOException {

        File f = new File(path);
        FileWriter fD = new FileWriter(f);
        for (MonAn writeList1 : writeList) {
            fD.write(writeList1.getTenMon() + "@" + writeList1.getGia() + "\n");
        }

        fD.close();
    }

    public void ClearFile(String path) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(path);
        writer.print("");
        writer.close();
    }
}
