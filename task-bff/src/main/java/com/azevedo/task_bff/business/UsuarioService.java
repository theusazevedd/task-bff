package com.azevedo.task_bff.business;

import com.azevedo.task_bff.business.dto.in.EnderecoDTORequest;
import com.azevedo.task_bff.business.dto.in.LoginRequestDTO;
import com.azevedo.task_bff.business.dto.in.TelefoneDTORequest;
import com.azevedo.task_bff.business.dto.in.UsuarioDTORequest;
import com.azevedo.task_bff.business.dto.out.EnderecoDTOResponse;
import com.azevedo.task_bff.business.dto.out.TelefoneDTOResponse;
import com.azevedo.task_bff.business.dto.out.UsuarioDTOResponse;
import com.azevedo.task_bff.insfrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {
        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO usuarioDTO) {
        return client.login(usuarioDTO);
    }

    public UsuarioDTOResponse buscaUsuarioPorEmail(String email, String token) {
        return client.buscaUsuarioPorEmail(email, token);

    }

    public void deletaUsuarioPorEmail(String email, String token) {
        client.deleteUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto) {
        return client.atualizaDadosUsuario(dto, token);

    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token) {
        return client.atualizaEndereco(enderecoDTO, idEndereco, token);

    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest telefoneDTO, String token) {
        return client.atualizaTelefone(telefoneDTO, idTelefone, token);

    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto) {
        return client.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto) {
        return client.cadastraTelefone(dto, token);
    }


}
