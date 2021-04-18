/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author hongl
 */
public class HoaDon {
    private int idHoaDon;
    private String ngay;
    private String loai;
    private float tong;

    public HoaDon() {
    }

    public HoaDon(int idHoaDon, String ngay, String loai, float tong) {
        this.idHoaDon = idHoaDon;
        this.ngay = ngay;
        this.loai = loai;
        this.tong = tong;
    }

    public HoaDon(String ngay, float tong) {
        this.ngay = ngay;
        this.tong = tong;
    }
    
    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public float getTong() {
        return tong;
    }

    public void setTong(float tong) {
        this.tong = tong;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "idHoaDon=" + idHoaDon + ", ngay=" + ngay + ", loai=" + loai + ", tong=" + tong + '}';
    }

    
}
