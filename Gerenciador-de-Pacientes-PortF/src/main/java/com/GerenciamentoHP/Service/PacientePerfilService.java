package com.GerenciamentoHP.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.GerenciamentoHP.DTO.PacientePerfilDto;
import com.GerenciamentoHP.Model.PacientePerfil;
import com.GerenciamentoHP.Repository.PacientePerfilRepository;
import com.GerenciamentoHP.Repository.SetorRepository;

@Service
public class PacientePerfilService {

    @Autowired
    private PacientePerfilRepository pacientePerfilRepository;

    @Autowired
    SetorRepository setorRepository;

    public PacientePerfil salvarPerfil(PacientePerfilDto pacientePerfilDto) {
        PacientePerfil paciente = pacientePerfilDto.mapearPacientePerfil();

        Optional<PacientePerfil> pacienteExistente = pacientePerfilRepository.findByrg(paciente.getRg());

        if (pacienteExistente.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Paciente Já Cadastrado");
        }

        return pacientePerfilRepository.save(paciente);
    }

    public List<PacientePerfil> getAll() {
        return pacientePerfilRepository.findAll();
    }

    public Optional<PacientePerfil> findByRg(Integer rg) {
        return pacientePerfilRepository.findByrg(rg);
    }

    public ResponseEntity<PacientePerfil> atualizarPacientePerfil(PacientePerfil pacientePerfil) {
        if (pacientePerfil.getAtendimento() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        return pacientePerfilRepository.findById(pacientePerfil.getAtendimento())
                .map(existente -> {
                   
                    existente.setSetor(pacientePerfil.getSetor());
                   
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(pacientePerfilRepository.save(existente));
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
