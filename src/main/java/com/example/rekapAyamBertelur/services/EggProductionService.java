package com.example.rekapAyamBertelur.services;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.example.rekapAyamBertelur.model.EggProduction;

@Service
public class EggProductionService {

    private List<EggProduction> eggProductions = new ArrayList<>();
    private int keuntunganTelur;
    private int jumlahAyam;
    private int jumlahTelur;
    private int hargaTelur = 5000;

    public void recordEggProduction(EggProduction eggProduction) {
        eggProductions.add(eggProduction);
        keuntunganTelur += keuntunganTelur(eggProduction.getJumlahTelur(), eggProduction.getHargaTelur());
        jumlahAyam += eggProduction.getJumlahAyam();
        jumlahTelur += eggProduction.getJumlahTelur();

        
    }

    public int keuntunganTelur(int jumlahTelur, int hargaTelur) {
        return jumlahTelur * hargaTelur;
    }
 
    public int getKeuntunganTelur() {
        return keuntunganTelur;
    }

    public int getJumlahAyam() {
        return jumlahAyam;
    }

    public int getJumlahTelur() {
        return jumlahTelur;
    }

    public int getHargaTelur() {
        return hargaTelur;
    }

 
}
