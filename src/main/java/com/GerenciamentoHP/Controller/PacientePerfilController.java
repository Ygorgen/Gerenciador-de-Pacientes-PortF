package com.GerenciamentoHP.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.GerenciamentoHP.DTO.PacientePerfilDto;
import com.GerenciamentoHP.Model.PacientePerfil;
import com.GerenciamentoHP.Service.PacientePerfilService;

@RestController
@RequestMapping("/pacientes-perfil")
public class PacientePerfilController {

    @Autowired
    private PacientePerfilService pacientePerfilService;

    @PostMapping("/cadastro")
    public ResponseEntity <PacientePerfil> criarPaciente(@RequestBody PacientePerfilDto pacientePerfilDto){
        PacientePerfil pacienteSalvo = pacientePerfilService.salvarPaciente(pacientePerfilDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);

    }

    @GetMapping
    public List <PacientePerfil> findAll(){
        return pacientePerfilService.getAll();
    }

    @GetMapping("/{atendimento}")
    public ResponseEntity<PacientePerfil> findByAtendimento(@PathVariable Long atendimento) {
        Optional<PacientePerfil> paciente = pacientePerfilService.findByAtendimento(atendimento);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/rg/{rg}")
    public ResponseEntity<PacientePerfil> findByRg(@PathVariable Integer rg){
        Optional <PacientePerfil> paciente = pacientePerfilService.findByRg(rg);
        return paciente.map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.notFound().build());

    }

}
