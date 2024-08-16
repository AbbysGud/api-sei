/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.RestAPISEI.repository;

import com.springboot.RestAPISEI.entity.Lokasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ariq Bagus Sugiharto
 */
@Repository
public interface LokasiRepository extends JpaRepository<Lokasi, Integer> {
    
}
