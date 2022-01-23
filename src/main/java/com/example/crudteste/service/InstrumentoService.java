package com.example.crudteste.service;

import com.example.crudteste.entity.InstrumentoEntity;
import com.example.crudteste.repository.InstrumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstrumentoService {

    @Autowired
    InstrumentoRepository instRepository;

    public List<InstrumentoEntity> listarInstrumentos(){
        //        for (int i = 0; i < instRepository.findAll().size(); i++) {
//            InstrumentoEntity instrumento = instrumentoEntityList.get(i);
//            instRepository.save(instrumento);
//        }
        return instRepository.findAll();

        //List<InstrumentoEntity> instrumentoRepository = instRepository.findAll();
        //return instrumentoRepository;
    }
    public InstrumentoEntity adicionarInst(InstrumentoEntity instrumento){
        return instRepository.save(instrumento);
    }

    public void deleteInst(Long id) {
        instRepository.deleteById(id);
    }

    public InstrumentoEntity updateInst(Long instId, String editMarca){
        InstrumentoEntity entity = instRepository.getById(instId);
        entity.setMarca(editMarca);
        InstrumentoEntity save = instRepository.save(entity);
        return save;
    }
}
