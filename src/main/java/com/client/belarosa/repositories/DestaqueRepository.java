package com.client.belarosa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.client.belarosa.domain.Destaque;
import com.client.belarosa.domain.Produto;

@Repository
public interface DestaqueRepository extends JpaRepository <Destaque, Integer> {
	@Query("SELECT DISTINCT obj FROM Destaque obj WHERE obj.nome LIKE %:nome%")
	Page<Destaque> findByFirstNameIgnoreCase ( @Param("nome") String nome, Pageable pageRequest);	
}
