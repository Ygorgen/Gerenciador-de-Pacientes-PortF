package com.GerenciamentoHP.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GerenciamentoHP.DTO.PacientePerfilDto;
import com.GerenciamentoHP.Model.PacientePerfil;
import com.GerenciamentoHP.Repository.PacientePerfilRepository;

@Service
public class PacientePerfilService {

    @Autowired
    private PacientePerfilRepository pacientePerfilRepository;

    public PacientePerfil salvarPaciente(PacientePerfilDto pacientePerfilDto) {

        PacientePerfil paciente = new PacientePerfil();
        paciente.setNome(pacientePerfilDto.nome());
        paciente.setRg(pacientePerfilDto.rg());
        paciente.setDataNascimento(pacientePerfilDto.dataNascimento());
        paciente.setPlano(pacientePerfilDto.plano());

        return pacientePerfilRepository.save(paciente);

    }

    public List<PacientePerfil> getAll() {
        return pacientePerfilRepository.findAll();
    }

    
    public Optional<PacientePerfil> findByAtendimento(Long atendimento){
        return pacientePerfilRepository.findById(atendimento);
    }

    
    public Optional<PacientePerfil> findByRg(Integer rg){
        return pacientePerfilRepository.findByrg(rg);
    }

}
