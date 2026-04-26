package com.azevedo.task_bff.insfrastructure.client;


import com.azevedo.task_bff.business.dto.in.TarefasDTORequest;
import com.azevedo.task_bff.business.dto.out.TarefasDTOResponse;
import com.azevedo.task_bff.business.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@FeignClient(name = "task-scheduler-service", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping("/tarefas")
    TarefasDTOResponse salvaTarefa(@RequestBody TarefasDTORequest dto,
                                   @RequestHeader("Authorization") String token);


    @GetMapping("/tarefas/eventos")
    List<TarefasDTOResponse> buscaListaDeTarefasPorPeriodo(@RequestParam Instant dataInicial,
                                                           @RequestParam Instant dataFinal,
                                                           @RequestHeader("Authorization") String token);


    @GetMapping("/tarefas")
    List<TarefasDTOResponse> buscaTarefasPorEmail(@RequestHeader("Authorization") String token);


    @DeleteMapping("/tarefas")
    void deletaTarefaPorId(@RequestParam("id") String id,
                           @RequestHeader("Authorization") String token);


    @PatchMapping("/tarefas")
    TarefasDTOResponse alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                               @RequestParam("id") String id,
                                               @RequestHeader("Authorization") String token);


    @PutMapping("/tarefas")
    TarefasDTOResponse updateTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestParam("id") String id,
                                     @RequestHeader("Authorization") String token);

}
