package com.example.backend_ektp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_kartu_keluarga")

public class KartuKeluarga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String alamat;
    private String desa_kelurahan;
    private String kabupaten_kota;
    private String kecamatan;
    private int kode_pos;

    @Column(unique = true)
    private long nomor_kk;
    
    private String provinsi;
    private int rt;
    private int rw;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getDesa_kelurahan() {
        return desa_kelurahan;
    }
    public void setDesa_kelurahan(String desa_kelurahan) {
        this.desa_kelurahan = desa_kelurahan;
    }
    public String getKabupaten_kota() {
        return kabupaten_kota;
    }
    public void setKabupaten_kota(String kabupaten_kota) {
        this.kabupaten_kota = kabupaten_kota;
    }
    public String getKecamatan() {
        return kecamatan;
    }
    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }
    public int getKode_pos() {
        return kode_pos;
    }
    public void setKode_pos(int kode_pos) {
        this.kode_pos = kode_pos;
    }
    public long getNomor_kk() {
        return nomor_kk;
    }
    public void setNomor_kk(long nomor_kk) {
        this.nomor_kk = nomor_kk;
    }
    public String getProvinsi() {
        return provinsi;
    }
    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }
    public int getRt() {
        return rt;
    }
    public void setRt(int rt) {
        this.rt = rt;
    }
    public int getRw() {
        return rw;
    }
    public void setRw(int rw) {
        this.rw = rw;
    }

    


}
