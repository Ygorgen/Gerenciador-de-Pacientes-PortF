package com.GerenciamentoHP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.GerenciamentoHP.Model.Setor;
import com.GerenciamentoHP.Service.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @PostMapping
    public ResponseEntity<Setor>registrarSetor(@RequestBody Setor setor){
        Setor setorCadastro = setorService.salvarSetor(setor);
        return ResponseEntity.status(HttpStatus.CREATED).body(setorCadastro);
    }

}
