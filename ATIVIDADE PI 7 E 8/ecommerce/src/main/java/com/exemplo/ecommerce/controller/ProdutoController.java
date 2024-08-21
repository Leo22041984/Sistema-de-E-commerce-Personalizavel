package com.exemplo.ecommerce.controller;

import com.exemplo.ecommerce.model.Produto;
import com.exemplo.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Controladora com os métodos da entidade Produtos
@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoService.listarTodos();
        model.addAttribute("produtos", produtos);
        return "produtos/listar"; // Abre a pagina com a lísta de produtos disponiveis cadastrados no banco de dados
    }

    @GetMapping("/novo")
    public String novoProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "produtos/formulario"; // Abre a pagina com o formulário para fazer o cadastro de um novo produto no banco de dados
    }

    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute Produto produto) {
        produtoService.salvar(produto);
        return "redirect:/produtos"; // Redireciona para a página de produtos após salvar
    }

    @GetMapping("/editar/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        Produto produto = produtoService.buscarPorId(id);
        if (produto != null) {
            model.addAttribute("produto", produto);
            return "produtos/formulario";
        }
        return "redirect:/produtos"; // Redireciona para a página de produtos após editar e salvar
    }

    @GetMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable Long id) {
        produtoService.deletar(id);
        return "redirect:/produtos"; // Redireciona para a página de produtos após deletar
    }
}
