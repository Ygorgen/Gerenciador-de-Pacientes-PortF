package com.GerenciamentoHP.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.GerenciamentoHP.Model.Setor;
import com.GerenciamentoHP.Repository.PacientePerfilRepository;
import com.GerenciamentoHP.Repository.SetorRepository;

@Service
public class SetorService {

    @Autowired
    PacientePerfilRepository pacientePerfilRepository;

    @Autowired
    SetorRepository setorRepository;

    public Setor salvarSetor(Setor setor) {
        return setorRepository.save(setor);
    }

    public List<Setor> listarTodosSetores() {
        return setorRepository.findAll();
    }
}
