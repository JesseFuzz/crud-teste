package com.example.crudteste.repository;

import com.example.crudteste.entity.InstrumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentoRepository extends JpaRepository<InstrumentoEntity, Long> {

    List<InstrumentoEntity> findAllByMarca(String marca);

}
