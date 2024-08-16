package com.springboot.RestAPISEI.controller;

import com.springboot.RestAPISEI.entity.Proyek;
import com.springboot.RestAPISEI.entity.ApiResponse;
import com.springboot.RestAPISEI.serviceInterface.ProyekService;
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
@RequestMapping(value = "/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @PostMapping(value = "")
    public ResponseEntity<ApiResponse> saveProyek(@RequestBody Proyek proyek) {
        try {
            proyek.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            proyekService.saveProyek(proyek);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse("success", "Input Data Proyek Berhasil."));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse("error", "Error ketika input data proyek."));
        }
    }
    
    @GetMapping(value = "")
    public ResponseEntity<ApiResponse> getProyek() {
        try {
            List<Proyek> proyekList = proyekService.getAllProyek();
            return ResponseEntity.ok(new ApiResponse("success", "Data retrieved successfully.", proyekList));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse("error", "Error retrieving data."));
        }
    }
    
    @PutMapping(value = "")
    public ResponseEntity<ApiResponse> updateProyek(@RequestBody Proyek updatedProyek) {
        try {
            Optional<Proyek> cekProyek = proyekService.getProyekById(updatedProyek.getId());
            if (cekProyek.isPresent()) {
                Proyek curProyek = cekProyek.get();

                curProyek.setNamaProyek(updatedProyek.getNamaProyek());
                curProyek.setClient(updatedProyek.getClient());
                curProyek.setTglMulai(updatedProyek.getTglMulai());
                curProyek.setTglSelesai(updatedProyek.getTglSelesai());
                curProyek.setPimpinanProyek(updatedProyek.getPimpinanProyek());
                curProyek.setKeterangan(updatedProyek.getKeterangan());
                curProyek.setLokasiId(updatedProyek.getLokasiId());

                proyekService.saveProyek(curProyek);
                
                return ResponseEntity.ok(new ApiResponse("success", "Update Data Proyek dengan Nama Proyek " + updatedProyek.getNamaProyek() + " Berhasil.", curProyek));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("error", "Data proyek tidak ditemukan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse("error", "Error ketika update data proyek."));
        }
    }
    
    @DeleteMapping(value = "")
    public ResponseEntity<ApiResponse> deleteProyek(@RequestBody Proyek deletedProyek) {
        try {
            Optional<Proyek> cekProyek = proyekService.getProyekById(deletedProyek.getId());
            if (cekProyek.isPresent()) {
                Proyek curProyek = cekProyek.get();
                
                proyekService.deleteProyek(curProyek.getId());
                
                return ResponseEntity.ok(new ApiResponse("success", "Delete Data Proyek dengan Nama Proyek " + deletedProyek.getNamaProyek() + " Berhasil."));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse("error", "Data proyek tidak ditemukan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse("error", "Error ketika delete data proyek."));
        }
    }
}
