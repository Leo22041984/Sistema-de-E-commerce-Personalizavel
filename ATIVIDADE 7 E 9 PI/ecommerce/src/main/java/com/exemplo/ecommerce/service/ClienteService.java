package com.exemplo.ecommerce.service;

import com.exemplo.ecommerce.model.Cliente;
import com.exemplo.ecommerce.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    //Serviço para salvar um cliente no banco de dados 
    public void salvar(Cliente cliente) {
        clienteRepository.save(cliente);
    }
    //Serviço para fazer a busca dos clientes através do ID 
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    }
    //Serviço para deletar os clientes cadastrado através do ID 
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
    //Serviço para listar todos os clientes existentes 
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
}

