package com.azevedo.task_bff.insfrastructure.client;


import com.azevedo.task_bff.business.dto.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping("/email")
    void enviarEmail(@RequestBody TarefasDTOResponse dto);

}
