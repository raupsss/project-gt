package com.example.backend_ektp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_ektp.model.KartuKeluarga;
import com.example.backend_ektp.repository.IKartuKeluargaRepo;
import com.example.backend_ektp.service.IKartuKeluargaService;

@Service
public class KartuKeluargaService implements IKartuKeluargaService {

    @Autowired
    IKartuKeluargaRepo kartuKeluargaRepo;

    @Override
    public KartuKeluarga addKK(KartuKeluarga kartuKeluarga) {

        return kartuKeluargaRepo.addKK(kartuKeluarga);
    }

    @Override
    public List<KartuKeluarga> getAllKK() {

        return kartuKeluargaRepo.getAllKK();
    }

    @Override
    public KartuKeluarga updateKK(int id, KartuKeluarga kartuKeluarga) {

        return kartuKeluargaRepo.updateKK(id, kartuKeluarga);
    }

    @Override
    public KartuKeluarga deleteKK(int id) {

        return kartuKeluargaRepo.deleteKK(id);
    }

    @Override
    public KartuKeluarga getKK(int id) {

        return kartuKeluargaRepo.getKK(id);
    }

}
