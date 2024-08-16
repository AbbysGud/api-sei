package com.springboot.RestAPISEI.controller;

import com.springboot.RestAPISEI.entity.Lokasi;
import com.springboot.RestAPISEI.entity.ApiResponse;
import com.springboot.RestAPISEI.serviceInterface.LokasiService;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ariq Bagus Sugiharto
 */
@RestController
@RequestMapping(value = "/lokasi")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @PostMapping(value = "")
    public ResponseEntity<ApiResponse> saveLokasi(@RequestBody Lokasi lokasi) {
        try {
            lokasi.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            lokasiService.saveLokasi(lokasi);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse("success", "Input Data Lokasi Berhasil."));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse("error", "Error ketika input data lokasi."));
        }
    }
    
    @GetMapping(value = "")
    public ResponseEntity<ApiResponse> getLokasi() {
        try {
            List<Lokasi> lokasiList = lokasiService.getAllLokasi();
            return ResponseEntity.ok(new ApiResponse("success", "Data retrieved successfully.", lokasiList));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse("error", "Error retrieving data."));
        }
    }
    
    @PutMapping(value = "")
    public ResponseEntity<ApiResponse> updateLokasi(@RequestBody Lokasi updatedLokasi) {
        try {
            Optional<Lokasi> cekLokasi = lokasiService.getLokasiById(updatedLokasi.getId());
            if (cekLokasi.isPresent()) {
                Lokasi curLokasi = cekLokasi.get();

                curLokasi.setNamaLokasi(updatedLokasi.getNamaLokasi());
                curLokasi.setNegara(updatedLokasi.getNegara());
                curLokasi.setProvinsi(updatedLokasi.getProvinsi());
                curLokasi.setKota(updatedLokasi.getKota());

                lokasiService.saveLokasi(curLokasi);
                
                return ResponseEntity.ok(new ApiResponse("success", "Update Data Lokasi dengan Nama Lokasi " + updatedLokasi.getNamaLokasi() + " Berhasil.", curLokasi));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("error", "Data lokasi tidak ditemukan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse("error", "Error ketika update data lokasi."));
        }
    }
    
    @DeleteMapping(value = "")
    public ResponseEntity<ApiResponse> deleteLokasi(@RequestBody Lokasi deletedLokasi) {
        try {
            Optional<Lokasi> cekLokasi = lokasiService.getLokasiById(deletedLokasi.getId());
            if (cekLokasi.isPresent()) {
                Lokasi curLokasi = cekLokasi.get();

                lokasiService.deleteLokasi(curLokasi.getId());
                
                return ResponseEntity.ok(new ApiResponse("success", "Delete Data Lokasi dengan Nama Lokasi " + deletedLokasi.getNamaLokasi() + " Berhasil."));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("error", "Data lokasi tidak ditemukan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse("error", "Error ketika delete data lokasi."));
        }
    }
}
