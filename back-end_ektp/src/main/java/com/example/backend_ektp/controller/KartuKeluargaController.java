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

import com.example.backend_ektp.model.KartuKeluarga;
import com.example.backend_ektp.service.IKartuKeluargaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/kartuKeluarga")

public class KartuKeluargaController {

    @Autowired
    IKartuKeluargaService kartuKeluargaService;

    @PostMapping("/addKK")
    public KartuKeluarga addKK(@RequestBody KartuKeluarga kartuKeluarga) {
        return kartuKeluargaService.addKK(kartuKeluarga);
    }

    @GetMapping("/getAllKK")
    public List<KartuKeluarga> getAllKK() {
        return kartuKeluargaService.getAllKK();
    }

    @PutMapping("/updateKK/{id}")
    public KartuKeluarga updateKK(@PathVariable int id, @RequestBody KartuKeluarga kartuKeluarga) {
        return kartuKeluargaService.updateKK(id, kartuKeluarga);
    }

    @DeleteMapping("/deleteKK/{id}")
    public KartuKeluarga deleteKK(@PathVariable int id) {
        return kartuKeluargaService.deleteKK(id);
    }

    @GetMapping("/getKK/{id}")
    public KartuKeluarga getKK(@PathVariable int id) {
        return kartuKeluargaService.getKK(id);
    }

}
