package com.client.belarosa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.belarosa.domain.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository <Imagem, Integer> {

}
