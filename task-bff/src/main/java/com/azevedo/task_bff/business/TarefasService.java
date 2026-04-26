package com.azevedo.task_bff.business;

import com.azevedo.task_bff.business.dto.in.TarefasDTORequest;
import com.azevedo.task_bff.business.dto.out.TarefasDTOResponse;
import com.azevedo.task_bff.business.enums.StatusNotificacaoEnum;
import com.azevedo.task_bff.insfrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient client;

    public TarefasDTOResponse gravarTarefa(String token, TarefasDTORequest dto) {
        return client.salvaTarefa(dto, token);
    }

    public List<TarefasDTOResponse> buscaTarefasAgendasPorPeriodo(Instant dataInicial, Instant dataFinal, String token) {
        return client.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscaTarefasPorEmail(String token) {
        return client.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {
        client.deletaTarefaPorId(id, token);
    }

    public TarefasDTOResponse alteraStatus(StatusNotificacaoEnum status, String id, String token) {
       return client.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest dto, String id, String token) {
        return client.updateTarefas(dto, id, token);

    }


}