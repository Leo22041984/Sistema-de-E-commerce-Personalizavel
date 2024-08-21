package com.exemplo.ecommerce.service;

import com.exemplo.ecommerce.model.Funcionario;
import com.exemplo.ecommerce.repository.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    //Serviço para salvar um funcionário no banco de dados  
    public void salvar(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }
    //Serviço para fazer a busca dos funcionários através do ID
    public Funcionario buscarPorId(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado"));
    }
    //Serviço para deletar os funcionários cadastrado através do ID
    public void deletar(Long id) {
        funcionarioRepository.deleteById(id);
    }
    //Serviço para listar todos os funcionários existentes
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }
}
