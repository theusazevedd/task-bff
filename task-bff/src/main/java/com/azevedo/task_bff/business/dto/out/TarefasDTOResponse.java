package com.azevedo.task_bff.business.dto.out;


import com.azevedo.task_bff.business.enums.StatusNotificacaoEnum;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTOResponse {

    private String id;
    private String nomeTarefa;
    private String descricao;
    private Instant dataCriacao;
    private Instant dataEvento;
    private String emailUsuario;
    private Instant dataAlteracao;
    private StatusNotificacaoEnum status;
}
