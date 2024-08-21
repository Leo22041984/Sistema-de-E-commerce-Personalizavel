package com.exemplo.ecommerce.controller;

import com.exemplo.ecommerce.model.Funcionario;
import com.exemplo.ecommerce.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

// Controladora com os métodos criados para entidade funcionário
@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro() {
        return "funcionarios/cadastrar"; // Abre a pagina com o formulário para fazer o cadastro dos dados dos funcionários
    }

    @PostMapping("/salvar")
    public String salvarFuncionario(@RequestParam String nome, @RequestParam String email,
                                    @RequestParam String senha, @RequestParam String cpf,
                                    @RequestParam String cargo) {
        Funcionario funcionario = new Funcionario(null, nome, email, senha, cpf, cargo);
        funcionarioService.salvar(funcionario);
        return "redirect:/funcionarios/cadastrar"; // Redireciona para a página de cadastro após salvar
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Funcionario funcionario = funcionarioService.buscarPorId(id);
        model.addAttribute("funcionario", funcionario);
        return "funcionarios/editar"; //  Abre a pagina para fazer a edição do dados dos funcionarios cadastrados no banco de dados 
    }

    @PostMapping("/editar/{id}")
    public String atualizarFuncionario(@PathVariable Long id, @RequestParam String nome, 
                                       @RequestParam String email, @RequestParam String senha, 
                                       @RequestParam String cpf, @RequestParam String cargo) {
        Funcionario funcionario = new Funcionario(id, nome, email, senha, cpf, cargo);
        funcionarioService.salvar(funcionario);
        return "redirect:/funcionarios/listar"; // Redireciona para a página de listagem após editar
    }

    @GetMapping("/deletar/{id}")
    public String deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletar(id);
        return "redirect:/funcionarios/listar"; // Redireciona para a página de listagem após deletar
    }
    
    @GetMapping("/listar")
    public String listarFuncionarios(Model model) {
        model.addAttribute("funcionarios", funcionarioService.listarTodos());
        return "funcionarios/listar"; // Abre a pagina com a lista dos funcionários cadastrados no banco de dados
    }
}
