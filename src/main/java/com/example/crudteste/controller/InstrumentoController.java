package com.example.crudteste.controller;

import com.example.crudteste.entity.InstrumentoEntity;
import com.example.crudteste.service.InstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequestMapping("/instrumento")
public class InstrumentoController {

    @Autowired
    InstrumentoService instrumentoService;

    @GetMapping
    public List<InstrumentoEntity> getInstrumento() {
        return instrumentoService.listarInstrumentos();
    }

    @PostMapping("/cadastro")
    public InstrumentoEntity adicionarInstrumento(@RequestBody InstrumentoEntity body /*variavel*/) {
        return instrumentoService.adicionarInst(body);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInst(@PathVariable("id") Long instId /*variavel*/) {
        instrumentoService.deleteInst(instId);
    }
    @PutMapping("/edit/{id}")
    public void updateInst(@PathVariable("id") Long instId,
                           @RequestParam(name = "marca") String editMarca){
        /**
         * updateInst, metodo que criei no InstrumentoService para fazer a regra de negocio
         */
        instrumentoService.updateInst(instId, editMarca);

                                                //instrumentoService pois eu vou continuar (regra de negócio) no service
                                                //e updateInst foi criado lá no service com ALT + enter pois não existia
                                                //criei duas variaveis editMarca e instId pra armazenar o value buscando pela key e id respectivamente
    }
}
