package com.azevedo.task_bff.insfrastructure.client;


import com.azevedo.task_bff.business.dto.in.EnderecoDTORequest;
import com.azevedo.task_bff.business.dto.in.LoginRequestDTO;
import com.azevedo.task_bff.business.dto.in.TelefoneDTORequest;
import com.azevedo.task_bff.business.dto.in.UsuarioDTORequest;
import com.azevedo.task_bff.business.dto.out.EnderecoDTOResponse;
import com.azevedo.task_bff.business.dto.out.TelefoneDTOResponse;
import com.azevedo.task_bff.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @PostMapping("/usuario")
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);


    @PostMapping("/usuario/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);


    @DeleteMapping("/usuario/{email}")
    void deleteUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping("/usuario")
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                            @RequestHeader("Authorization") String token);

    @PutMapping("/usuario/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/usuario/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/usuario/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/usuario/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestHeader("Authorization") String token);

}
