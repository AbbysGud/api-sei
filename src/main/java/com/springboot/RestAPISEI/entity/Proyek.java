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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "proyek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyek.findAll", query = "SELECT p FROM Proyek p")
    , @NamedQuery(name = "Proyek.findById", query = "SELECT p FROM Proyek p WHERE p.id = :id")
    , @NamedQuery(name = "Proyek.findByNamaProyek", query = "SELECT p FROM Proyek p WHERE p.namaProyek = :namaProyek")
    , @NamedQuery(name = "Proyek.findByClient", query = "SELECT p FROM Proyek p WHERE p.client = :client")
    , @NamedQuery(name = "Proyek.findByTglMulai", query = "SELECT p FROM Proyek p WHERE p.tglMulai = :tglMulai")
    , @NamedQuery(name = "Proyek.findByTglSelesai", query = "SELECT p FROM Proyek p WHERE p.tglSelesai = :tglSelesai")
    , @NamedQuery(name = "Proyek.findByPimpinanProyek", query = "SELECT p FROM Proyek p WHERE p.pimpinanProyek = :pimpinanProyek")
    , @NamedQuery(name = "Proyek.findByCreatedAt", query = "SELECT p FROM Proyek p WHERE p.createdAt = :createdAt")})
public class Proyek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nama_proyek")
    private String namaProyek;
    @Size(max = 50)
    @Column(name = "client")
    private String client;
    @Column(name = "tgl_mulai")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglMulai;
    @Column(name = "tgl_selesai")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglSelesai;
    @Size(max = 50)
    @Column(name = "pimpinan_proyek")
    private String pimpinanProyek;
    @Lob
    @Size(max = 65535)
    @Column(name = "keterangan")
    private String keterangan;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "lokasi_id", referencedColumnName = "id")
    @ManyToOne
    private Lokasi lokasiId;

    public Proyek() {
    }

    public Proyek(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaProyek() {
        return namaProyek;
    }

    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getTglMulai() {
        return tglMulai;
    }

    public void setTglMulai(Date tglMulai) {
        this.tglMulai = tglMulai;
    }

    public Date getTglSelesai() {
        return tglSelesai;
    }

    public void setTglSelesai(Date tglSelesai) {
        this.tglSelesai = tglSelesai;
    }

    public String getPimpinanProyek() {
        return pimpinanProyek;
    }

    public void setPimpinanProyek(String pimpinanProyek) {
        this.pimpinanProyek = pimpinanProyek;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Lokasi getLokasiId() {
        return lokasiId;
    }

    public void setLokasiId(Lokasi lokasiId) {
        this.lokasiId = lokasiId;
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
        if (!(object instanceof Proyek)) {
            return false;
        }
        Proyek other = (Proyek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.springboot.RestAPISEI.entity.Proyek[ id=" + id + " ]";
    }
    
}
