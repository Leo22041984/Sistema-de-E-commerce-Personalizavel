package com.exemplo.ecommerce.service;

import com.exemplo.ecommerce.model.Produto;
import com.exemplo.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
   
    //Serviço para listar todos os produtos existentes 
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }
    //Serviço para salvar ou atualizar um produto no banco de dados
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto); 
    }
    //Serviço para fazer uma busca por Id de um produto no banco de dados
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
    //Serviço para deletar um produto cadastrado no banco de dados 
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
    //Serviço para fazer uma busca de um produto no banco de dados por categoria
    public List<Produto> buscarPorCategoria(String categoria) {
        return produtoRepository.findByCategoria(categoria);
    }
}
