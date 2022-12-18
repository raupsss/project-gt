package com.example.backend_ektp.service;

import java.util.List;

import com.example.backend_ektp.model.KartuKeluarga;

public interface IKartuKeluargaService {

    public KartuKeluarga addKK(KartuKeluarga kartuKeluarga);

    public List<KartuKeluarga> getAllKK();

    public KartuKeluarga updateKK(int id, KartuKeluarga kartuKeluarga);

    public KartuKeluarga deleteKK(int id);

    public KartuKeluarga getKK(int id);

}
