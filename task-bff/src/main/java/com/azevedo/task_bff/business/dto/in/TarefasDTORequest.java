package com.azevedo.task_bff.business.dto.in;


import com.azevedo.task_bff.business.enums.StatusNotificacaoEnum;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTORequest {

    private String nomeTarefa;
    private String descricao;
    private Instant dataEvento;

}
