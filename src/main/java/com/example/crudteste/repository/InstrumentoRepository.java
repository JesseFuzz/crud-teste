package com.example.crudteste.repository;

import com.example.crudteste.entity.InstrumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentoRepository extends JpaRepository<InstrumentoEntity, Long> {

    @Override
    List<InstrumentoEntity> findAll();

    List<InstrumentoEntity> findAllByMarca(String marca);

    @Override
    List<InstrumentoEntity> findAllById(Iterable<Long> Long);
}
