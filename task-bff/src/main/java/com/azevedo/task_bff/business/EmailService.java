package com.azevedo.task_bff.business;

import com.azevedo.task_bff.business.dto.out.TarefasDTOResponse;
import com.azevedo.task_bff.insfrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient client;

    public void enviaEmail(TarefasDTOResponse dto) {
        client.enviarEmail(dto);
    }


}