/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.RestAPISEI.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ariq Bagus Sugiharto
 */
@Entity
@Table(name = "lokasi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lokasi.findAll", query = "SELECT l FROM Lokasi l")
    , @NamedQuery(name = "Lokasi.findById", query = "SELECT l FROM Lokasi l WHERE l.id = :id")
    , @NamedQuery(name = "Lokasi.findByNamaLokasi", query = "SELECT l FROM Lokasi l WHERE l.namaLokasi = :namaLokasi")
    , @NamedQuery(name = "Lokasi.findByNegara", query = "SELECT l FROM Lokasi l WHERE l.negara = :negara")
    , @NamedQuery(name = "Lokasi.findByProvinsi", query = "SELECT l FROM Lokasi l WHERE l.provinsi = :provinsi")
    , @NamedQuery(name = "Lokasi.findByKota", query = "SELECT l FROM Lokasi l WHERE l.kota = :kota")
    , @NamedQuery(name = "Lokasi.findByCreatedAt", query = "SELECT l FROM Lokasi l WHERE l.createdAt = :createdAt")})
public class Lokasi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nama_lokasi")
    private String namaLokasi;
    @Size(max = 50)
    @Column(name = "negara")
    private String negara;
    @Size(max = 50)
    @Column(name = "provinsi")
    private String provinsi;
    @Size(max = 50)
    @Column(name = "kota")
    private String kota;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Lokasi() {
    }

    public Lokasi(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public void setNamaLokasi(String namaLokasi) {
        this.namaLokasi = namaLokasi;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lokasi)) {
            return false;
        }
        Lokasi other = (Lokasi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springboot.RestAPISEI.entity.Lokasi[ id=" + id + " ]";
    }
    
}
