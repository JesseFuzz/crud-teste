package com.example.crudteste.controller;

import com.example.crudteste.entity.InstrumentoEntity;
import com.example.crudteste.service.InstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequestMapping("/instrumento")
public class InstrumentoController {

    @Autowired
    InstrumentoService instrumentoService;

    @GetMapping
    public ResponseEntity<List<InstrumentoEntity>> getInstrumento() {
        return new ResponseEntity<List<InstrumentoEntity>>(instrumentoService.listarInstrumentos(), HttpStatus.OK);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<InstrumentoEntity> adicionarInstrumento(@RequestBody InstrumentoEntity body /*variavel*/) {
        return instrumentoService.adicionarInst(body);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInst(@PathVariable("id") Long instId /*variavel*/) throws ChangeSetPersister.NotFoundException {
        return instrumentoService.deleteInst(instId);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<InstrumentoEntity> updateInst(@PathVariable("id") Long instId,
                                                        @RequestParam(required = false, name = "marca") String editMarca) {
        /**
         * updateInst, metodo que criei no InstrumentoService para fazer a regra de negocio
         */
        if (null != editMarca)
            return instrumentoService.updateInst(instId, editMarca);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        //instrumentoService pois eu vou continuar (regra de negócio) no service
        //criei duas variaveis editMarca e instId pra armazenar o value buscando pela key e id respectivamente
    }
}
