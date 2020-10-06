package com.example.cursorestfulspringboot.service;

import com.example.cursorestfulspringboot.dto.ClienteDTO;
import com.example.cursorestfulspringboot.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    public Cliente fromDTO(ClienteDTO dto){
        Cliente cliente = new Cliente();
        
        cliente.setEndereco(dto.getEndereco());
        cliente.setNome(dto.getNome());

        return cliente;
    }

}
