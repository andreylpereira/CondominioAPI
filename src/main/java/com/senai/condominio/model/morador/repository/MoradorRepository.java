package com.senai.condominio.model.morador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.condominio.model.morador.entity.Morador;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {


}
