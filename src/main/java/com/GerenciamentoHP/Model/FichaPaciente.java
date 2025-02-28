package com.GerenciamentoHP.Model;

import java.time.LocalDate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_fichaPaciente")
@EntityListeners(AuditingEntityListener.class)
public class FichaPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer leito;

    private String plano;

    private String diagnostico;

    private LocalDate dataInternacao;

    @CreatedDate
    private LocalDate inicioAtendimento;

    private LocalDate fimAtendimento;

    private String usoO2;

    private LocalDate alta;

    private LocalDate obito;

    private String observacao;

    @ManyToOne
    @JsonIgnoreProperties("fichaPaciente")
    private PacientePerfil pacientePerfil;
}
