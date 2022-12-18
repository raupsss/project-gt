package com.example.backend_ektp.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.backend_ektp.model.KartuKeluarga;
import com.example.backend_ektp.repository.IKartuKeluargaRepo;

@Repository
public class KartuKeluargaRepo implements IKartuKeluargaRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public KartuKeluarga addKK(KartuKeluarga kartuKeluarga) {

        String query = "INSERT INTO tb_kartu_keluarga(alamat, desa_kelurahan, kabupaten_kota, kecamatan, kode_pos, nomor_kk, provinsi, rt, rw)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, new Object[] {
                kartuKeluarga.getAlamat(), kartuKeluarga.getDesa_kelurahan(), kartuKeluarga.getKabupaten_kota(),
                kartuKeluarga.getKecamatan(), kartuKeluarga.getKode_pos(), kartuKeluarga.getNomor_kk(),
                kartuKeluarga.getProvinsi(), kartuKeluarga.getRt(), kartuKeluarga.getRw()
        });
        return kartuKeluarga;
    }

    @Override
    public List<KartuKeluarga> getAllKK() {

        String query = "SELECT * FROM tb_kartu_keluarga";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(KartuKeluarga.class));
    }

    @Override
    public KartuKeluarga updateKK(int id, KartuKeluarga kartuKeluarga) {

        String query = "UPDATE tb_kartu_keluarga SET alamat = ?, desa_kelurahan = ?, kabupaten_kota = ?, kecamatan = ?, kode_pos = ?, nomor_kk = ?, provinsi = ?, rt = ?, rw = ? WHERE id = ?";

        jdbcTemplate.update(query, new Object[] {
                kartuKeluarga.getAlamat(), kartuKeluarga.getDesa_kelurahan(), kartuKeluarga.getKabupaten_kota(),
                kartuKeluarga.getKecamatan(), kartuKeluarga.getKode_pos(), kartuKeluarga.getNomor_kk(),
                kartuKeluarga.getProvinsi(), kartuKeluarga.getRt(), kartuKeluarga.getRw(), id
        });
        return kartuKeluarga;
    }

    @Override
    public KartuKeluarga deleteKK(int id) {

        String query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";
        var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(KartuKeluarga.class), id);

        query = "DELETE FROM tb_kartu_keluarga WHERE id = ?";
        jdbcTemplate.update(query, id);

        return result;
    }

    @Override
    public KartuKeluarga getKK(int id) {

        String query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";

        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(KartuKeluarga.class), id);
    }

}
