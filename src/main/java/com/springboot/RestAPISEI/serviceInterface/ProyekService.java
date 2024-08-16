/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.RestAPISEI.serviceInterface;

import com.springboot.RestAPISEI.entity.Proyek;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Ariq Bagus Sugiharto
 */
public interface ProyekService {
    Proyek saveProyek(Proyek proyek);
    List<Proyek> getAllProyek();
    Optional<Proyek> getProyekById(Integer id);
    Proyek updateProyek(Proyek proyek);
    void deleteProyek(Integer id);
}
