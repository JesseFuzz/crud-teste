package com.example.crudteste.service;

import com.example.crudteste.entity.InstrumentoEntity;
import com.example.crudteste.repository.InstrumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstrumentoService {

    @Autowired
    InstrumentoRepository instRepository;

    public List<InstrumentoEntity> listarInstrumentos() {
        //        for (int i = 0; i < instRepository.findAll().size(); i++) {
//            InstrumentoEntity instrumento = instrumentoEntityList.get(i);
//            instRepository.save(instrumento);
//        }
        return instRepository.findAll();

        //List<InstrumentoEntity> instrumentoRepository = instRepository.findAll();
        //return instrumentoRepository;
    }

    public ResponseEntity<InstrumentoEntity> adicionarInst(InstrumentoEntity instrumento) {
        if (null == instrumento.getDescricao()) {
            return new ResponseEntity<>(HttpStatus.valueOf(400));
        }
        return new ResponseEntity<>(instRepository.save(instrumento), HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteInst(Long id) {
        if (instRepository.existsById(id)) {
            instRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("O ID ".concat(id.toString()).concat(" não existe! "),HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<InstrumentoEntity> updateInst(Long instId, String editMarca) {
        /*  Condicional que verifica se existe alguma entidade no banco de dados com esse Id    */
        if(instRepository.existsById(instId)){
            if(!editMarca.isBlank() || !editMarca.isEmpty()){

                InstrumentoEntity entity = instRepository.getById(instId);
                entity.setMarca(editMarca);
                return new ResponseEntity<>(instRepository.save(entity), HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
