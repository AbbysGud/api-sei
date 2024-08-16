/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.RestAPISEI.serviceImplementation;

import com.springboot.RestAPISEI.entity.Proyek;
import com.springboot.RestAPISEI.repository.ProyekRepository;
import com.springboot.RestAPISEI.serviceInterface.ProyekService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ariq Bagus Sugiharto
 */
@Service
public class ProyekServiceImpl implements ProyekService {
    
    @Autowired
    private ProyekRepository proyekRepo;

    @Override
    public Proyek saveProyek(Proyek proyek) {
        return proyekRepo.save(proyek);
    }

    @Override
    public List<Proyek> getAllProyek() {
        return proyekRepo.findAll();
    }

    @Override
    public Optional<Proyek> getProyekById(Integer id) {
        return proyekRepo.findById(id);
    }

    @Override
    public Proyek updateProyek(Proyek proyek) {
        return proyekRepo.save(proyek);
    }

    @Override
    public void deleteProyek(Integer id) {
        proyekRepo.deleteById(id);
    }
    
}
