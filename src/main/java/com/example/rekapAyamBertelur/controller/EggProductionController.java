package com.example.rekapAyamBertelur.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rekapAyamBertelur.dto.reponse.keuntunganResponse;
import com.example.rekapAyamBertelur.model.EggProduction;
import com.example.rekapAyamBertelur.services.EggProductionService;

@RestController
@RequestMapping("/api/egg")
public class EggProductionController {

    private final EggProductionService eggProductionService;

    @Autowired
    public EggProductionController(EggProductionService eggProductionService) {
        this.eggProductionService = eggProductionService;
    }

    @PostMapping("/record")
    public ResponseEntity<EggProduction> recordEggProduction(@RequestBody EggProduction eggProduction) {
        eggProductionService.recordEggProduction(eggProduction);
        return ResponseEntity.ok(eggProduction);
       
    }

    @GetMapping("/summary")
    public ResponseEntity<?> getKeuntunganTelur() {

        if(eggProductionService.getJumlahAyam() == 0) {
            return ResponseEntity.badRequest().body("Belum ada data yang dimasukkan");
        } else {
            keuntunganResponse keuntunganResponse = new keuntunganResponse();
            keuntunganResponse.setJumlahAyam(eggProductionService.getJumlahAyam());
            keuntunganResponse.setJumlahTelur(eggProductionService.getJumlahTelur());
            keuntunganResponse.setHargaTelur(eggProductionService.getHargaTelur());
            keuntunganResponse.setKeuntunganTelur(eggProductionService.getKeuntunganTelur());
            return ResponseEntity.ok(keuntunganResponse);
            
        }
        
    }
}
