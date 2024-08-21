package com.exemplo.ecommerce.controller;

import com.exemplo.ecommerce.model.Cliente;
import com.exemplo.ecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

//Controladora para os metodos criados para entidade cliente
@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro() {
        return "clientes/cadastrar"; // Abre o formulário para fazer o cadastro dos dados do cliente
    }

    @PostMapping("/salvar")
    public String salvarCliente(@RequestParam String nome, @RequestParam String email,
                                @RequestParam String senha, @RequestParam String cpf,
                                @RequestParam String endereco) {
        Cliente cliente = new Cliente(null, nome, email, senha, cpf, endereco);
        clienteService.salvar(cliente);
        
        return "redirect:/clientes/cadastrar"; // Redireciona para a página de cadastro após salvar
    }
    
     @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.buscarPorId(id);
        model.addAttribute("cliente", cliente);
        return "clientes/editar"; // Abre a pagina para fazer a edição dos dados do cliente
    }

    @PostMapping("/editar/{id}")
    public String atualizarCliente(@PathVariable Long id, @RequestParam String nome, 
                                   @RequestParam String email, @RequestParam String senha, 
                                   @RequestParam String cpf, @RequestParam String endereco) {
        Cliente cliente = new Cliente(id, nome, email, senha, cpf, endereco);
        clienteService.salvar(cliente);
        return "redirect:/clientes/listar"; // Redireciona para a página de listagem após editar
    }

    @GetMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable Long id) {
        clienteService.deletar(id);
        return "redirect:/clientes/listar"; // Redireciona para a página de listagem após deletar
    }
    
    @GetMapping("/listar")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        return "clientes/listar"; // Abre a pagina com a listagem dos clientes cadastrados no banco de dados
    }
}
