/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.RestAPISEI.serviceImplementation;

import com.springboot.RestAPISEI.entity.Lokasi;
import com.springboot.RestAPISEI.repository.LokasiRepository;
import com.springboot.RestAPISEI.serviceInterface.LokasiService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ariq Bagus Sugiharto
 */
@Service
public class LokasiServiceImpl implements LokasiService {
    
    @Autowired
    private LokasiRepository lokasiRepo;

    @Override
    public Lokasi saveLokasi(Lokasi lokasi) {
        return lokasiRepo.save(lokasi);
    }

    @Override
    public List<Lokasi> getAllLokasi() {
        return lokasiRepo.findAll();
    }

    @Override
    public Optional<Lokasi> getLokasiById(Integer id) {
        return lokasiRepo.findById(id);
    }

    @Override
    public Lokasi updateLokasi(Lokasi lokasi) {
        return lokasiRepo.save(lokasi);
    }

    @Override
    public void deleteLokasi(Integer id) {
        lokasiRepo.deleteById(id);
    }
  
    
}
