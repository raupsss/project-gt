package com.example.backend_ektp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_ektp.model.AnggotaKeluarga;
import com.example.backend_ektp.service.IAnggotaKeluargaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/anggotaKeluarga")

public class AnggotaKeluargaController {

    @Autowired
    IAnggotaKeluargaService anggotaKeluargaService;

    @PostMapping("/addAnggota")
    public AnggotaKeluarga addAnggota(@RequestBody AnggotaKeluarga anggotaKeluarga) {
        return anggotaKeluargaService.addAnggota(anggotaKeluarga);
    }

    @GetMapping("/getAllAnggota")
    public List<AnggotaKeluarga> getAllAnggota() {
        return anggotaKeluargaService.getAllAnggota();
    }

    @PutMapping("/updateAnggota/{id}")
    public AnggotaKeluarga updateAnggota(@PathVariable int id, @RequestBody AnggotaKeluarga anggotaKeluarga) {
        return anggotaKeluargaService.updateAnggota(id, anggotaKeluarga);
    }

    @DeleteMapping("/deleteAnggota/{id}")
    public AnggotaKeluarga deleteAnggota(@PathVariable int id) {
        return anggotaKeluargaService.deleteAnggota(id);
    }

    @GetMapping("/getAnggota/{id}")
    public AnggotaKeluarga getAnggota(@PathVariable int id) {
        return anggotaKeluargaService.getAnggota(id);
    }

    @GetMapping("/getIdKK/{id_kk}")
    public List<AnggotaKeluarga> getIdKK(@PathVariable String id_kk) {
        return anggotaKeluargaService.getIdKK(id_kk);
    }

    @DeleteMapping("/deleteAllAnggota/{id_kk}")
    public List<AnggotaKeluarga> deleteAllAnggota(@PathVariable String id_kk){
        return anggotaKeluargaService.deleteAllAnggota(id_kk);
    }

}
