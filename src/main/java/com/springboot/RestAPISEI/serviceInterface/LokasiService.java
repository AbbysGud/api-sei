/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.RestAPISEI.serviceInterface;

import com.springboot.RestAPISEI.entity.Lokasi;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Ariq Bagus Sugiharto
 */
public interface LokasiService {
    Lokasi saveLokasi(Lokasi lokasi);
    List<Lokasi> getAllLokasi();
    Optional<Lokasi> getLokasiById(Integer id);
    Lokasi updateLokasi(Lokasi lokasi);
    void deleteLokasi(Integer id);
    
}
