package com.fempowerfit.FPF.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fempowerfit.FPF.Model.Suplemento;

public interface SuplementoRepository extends JpaRepository<Suplemento, Long> {

    @Query("SELECT s FROM Suplementacao s ORDER BY s.suplementacao.tipo")
    Page<Suplemento> findByTipoIgnoreCase(String tipo, Pageable pageable);    
}
