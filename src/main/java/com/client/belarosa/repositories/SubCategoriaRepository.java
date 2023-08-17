package com.client.belarosa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.belarosa.domain.SubCategoria;

@Repository
public interface SubCategoriaRepository extends JpaRepository <SubCategoria, Integer> {

}
