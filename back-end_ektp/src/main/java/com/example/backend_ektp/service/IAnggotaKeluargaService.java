package com.example.backend_ektp.service;

import java.util.List;

import com.example.backend_ektp.model.AnggotaKeluarga;

public interface IAnggotaKeluargaService {

    public AnggotaKeluarga addAnggota(AnggotaKeluarga anggotaKeluarga);

    public List<AnggotaKeluarga> getAllAnggota();

    public AnggotaKeluarga updateAnggota(int id, AnggotaKeluarga anggotaKeluarga);

    public AnggotaKeluarga deleteAnggota(int id);

    public AnggotaKeluarga getAnggota(int id);

    public List<AnggotaKeluarga> getIdKK(String id_kk);

    public List<AnggotaKeluarga> deleteAllAnggota(String id_kk);

}
