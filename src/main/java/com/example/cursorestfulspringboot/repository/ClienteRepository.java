package com.example.cursorestfulspringboot.repository;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import com.example.cursorestfulspringboot.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteRepository {

    private List<Cliente> clientes;
    private int nextId;

    @PostConstruct
    public void init() {
        Cliente c1 = new Cliente();
        c1.getCod(1);
        c1.setNome("Jose");
        c1.setDesc("Chuteira");
        c1.setValor(150.0);
        c1.setPedido(1254);

        clientes = new ArrayList<Cliente>();
        clientes.add(c1);
        nextId = 2;
        
    }

    public List<Cliente> getAllClientes(){
        return clientes;
    }
    
    public Cliente getClienteById(int id){
        for (Cliente aux : clientes) {
            if(aux.getId() == id){
                return aux;
            }
        }

        return null;
    }

	public Cliente salvar(Cliente cliente) {
        cliente.setId(nextId++);
        clientes.add(cliente);
        return cliente;
	}

	public void remove(Cliente cli) {
        clientes.remove(cli);
	}

	public Cliente update(Cliente cliente) {
        
        Cliente aux = getClienteById(cliente.getId());
        
        if(aux != null){
            aux.setEndereco(cliente.getEndereco());
            aux.setNome(cliente.getNome());
            aux.setSaldo(cliente.getSaldo());
        }

        return aux;

	}

	

}





