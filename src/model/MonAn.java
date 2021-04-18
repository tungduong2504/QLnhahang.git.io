/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hongl
 */
public class MonAn implements Comparable<MonAn>{
    private int idMonAn;
    private String tenMon;
    private float gia;

    public MonAn() {
    }

    public MonAn(int idMonAn, String tenMon, float gia) {
        this.idMonAn = idMonAn;
        this.tenMon = tenMon;
        this.gia = gia;
    }

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "MonAn{" + "idMonAn=" + idMonAn + ", tenMon=" + tenMon + ", gia=" + gia + '}';
    }
   //Sap xep id mon an
    @Override
    public int compareTo(MonAn o) {
         return idMonAn-(o.idMonAn);
    }
    
}
