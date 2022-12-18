package com.example.backend_ektp.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.backend_ektp.model.AnggotaKeluarga;
import com.example.backend_ektp.repository.IAnggotaKeluargaRepo;

@Repository
public class AnggotaKeluargaRepo implements IAnggotaKeluargaRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public AnggotaKeluarga addAnggota(AnggotaKeluarga anggotaKeluarga) {

        String query = "INSERT INTO tb_anggota_keluarga(agama, id_kk, jenis_kelamin, kepala_keluarga, nama, nik, pendidikan, tanggal_lahir, tempat_lahir)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, new Object[] {
                anggotaKeluarga.getAgama(), anggotaKeluarga.getId_kk(), anggotaKeluarga.getJenis_kelamin(),
                anggotaKeluarga.getKepala_keluarga(), anggotaKeluarga.getNama(), anggotaKeluarga.getNik(),
                anggotaKeluarga.getPendidikan(), anggotaKeluarga.getTanggal_lahir(), anggotaKeluarga.getTempat_lahir()
        });
        return anggotaKeluarga;
    }

    @Override
    public List<AnggotaKeluarga> getAllAnggota() {

        String query = "SELECT * FROM tb_anggota_keluarga";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class));
    }

    @Override
    public AnggotaKeluarga updateAnggota(int id, AnggotaKeluarga anggotaKeluarga) {

        String query = "UPDATE tb_anggota_keluarga SET agama = ?, id_kk = ?, jenis_kelamin = ?, kepala_keluarga = ?, nama = ?, nik = ?, pendidikan = ?, tanggal_lahir = ?, tempat_lahir = ? WHERE id = ?";

        jdbcTemplate.update(query, new Object[] {
                anggotaKeluarga.getAgama(), anggotaKeluarga.getId_kk(), anggotaKeluarga.getJenis_kelamin(),
                anggotaKeluarga.getKepala_keluarga(), anggotaKeluarga.getNama(), anggotaKeluarga.getNik(),
                anggotaKeluarga.getPendidikan(), anggotaKeluarga.getTanggal_lahir(), anggotaKeluarga.getTempat_lahir(),
                id
        });
        return anggotaKeluarga;
    }

    @Override
    public AnggotaKeluarga deleteAnggota(int id) {

        String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
        var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class), id);

        query = "DELETE FROM tb_anggota_keluarga WHERE id = ?";
        jdbcTemplate.update(query, id);
        return result;
    }

    @Override
    public AnggotaKeluarga getAnggota(int id) {

        String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class), id);
    }

    @Override
    public List<AnggotaKeluarga> getIdKK(String id_kk) {

        String query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class), id_kk);
    }

    @Override
    public List<AnggotaKeluarga> deleteAllAnggota(String id_kk) {

        String query = "SELECT * FROM tb_anggota_keluarga WHERE id_kk = ?";
        var result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(AnggotaKeluarga.class), id_kk);

        query = "DELETE FROM tb_anggota_keluarga WHERE id_kk = ?";
        jdbcTemplate.update(query, id_kk);

        return result;

    }

}
