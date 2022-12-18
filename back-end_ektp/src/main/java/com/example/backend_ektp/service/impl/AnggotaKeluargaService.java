package com.example.backend_ektp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_ektp.model.AnggotaKeluarga;
import com.example.backend_ektp.repository.IAnggotaKeluargaRepo;
import com.example.backend_ektp.service.IAnggotaKeluargaService;

@Service
public class AnggotaKeluargaService implements IAnggotaKeluargaService {

    @Autowired
    IAnggotaKeluargaRepo anggotaKeluargaRepo;

    @Override
    public AnggotaKeluarga addAnggota(AnggotaKeluarga anggotaKeluarga) {

        return anggotaKeluargaRepo.addAnggota(anggotaKeluarga);
    }

    @Override
    public List<AnggotaKeluarga> getAllAnggota() {

        return anggotaKeluargaRepo.getAllAnggota();
    }

    @Override
    public AnggotaKeluarga updateAnggota(int id, AnggotaKeluarga anggotaKeluarga) {

        return anggotaKeluargaRepo.updateAnggota(id, anggotaKeluarga);
    }

    @Override
    public AnggotaKeluarga deleteAnggota(int id) {

        return anggotaKeluargaRepo.deleteAnggota(id);
    }

    @Override
    public AnggotaKeluarga getAnggota(int id) {

        return anggotaKeluargaRepo.getAnggota(id);
    }

    @Override
    public List<AnggotaKeluarga> getIdKK(String id_kk) {

        return anggotaKeluargaRepo.getIdKK(id_kk);
    }

    @Override
    public List<AnggotaKeluarga> deleteAllAnggota(String id_kk) {

        return anggotaKeluargaRepo.deleteAllAnggota(id_kk);
    }

}
