package com.produtos.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.demo.model.dto.ProdutosDTO;
import com.produtos.demo.model.entity.Produtos;
import com.produtos.demo.repository.ProdutosRepository;

@Service

public class ProdutosService {
    @Autowired
    ProdutosRepository repository;
    public List<ProdutosDTO> BuscarProdutos(){
        List<Produtos> produtos = repository.findAll();
        List<ProdutosDTO> produtosDTOs = new ArrayList<>();
        for(Produtos produto:produtos){
            ProdutosDTO produtosDTO = new ProdutosDTO();
            produtosDTO.setId(produto.getId());
            produtosDTO.setNome(produto.getNome());
            produtosDTO.setPeso(produto.getPeso());
            produtosDTO.setPreco(produto.getPreco());
            produtosDTO.setQuantidade(produto.getQuantidade());
            produtosDTO.setDescricao(produto.getDescricao());
            produtosDTO.setCategoria(produto.getCategoria());
            produtosDTOs.add(produtosDTO);
        }
    return produtosDTOs;
    }

    public ProdutosDTO BuscaPorId(int id){
        Optional<Produtos> produtos = repository.findById(id);
        if(produtos.isEmpty()){
            System.out.println("nao existe esse id");
            return null;
        }else{
            ProdutosDTO produtosDTO = new ProdutosDTO();
            produtosDTO.setId(produtos.get().getId());
            produtosDTO.setCategoria(produtos.get().getCategoria());
            produtosDTO.setDescricao(produtos.get().getDescricao());
            produtosDTO.setNome(produtos.get().getNome());
            produtosDTO.setPeso(produtos.get().getPeso());
            produtosDTO.setPreco(produtos.get().getPreco());
            produtosDTO.setQuantidade(produtos.get().getQuantidade());
            return produtosDTO;
        }
    }
    
    public ProdutosDTO AdicionarProdutos(ProdutosDTO produtosDTO){
        Produtos produtos = new Produtos();
        produtos.setNome(produtosDTO.getNome());
        produtos.setPeso(produtosDTO.getPeso());
        produtos.setQuantidade(produtosDTO.getQuantidade());
        produtos.setCategoria(produtosDTO.getCategoria());
        produtos.setDescricao(produtosDTO.getDescricao());
        produtos.setPreco(produtosDTO.getPreco());
        produtos = repository.save(produtos);
        produtosDTO.setId(produtos.getId());
        return produtosDTO;
    }

    public void ExcluirProdutosPorId(int id){
        Optional<Produtos> produtos = repository.findById(id);
        if(produtos.isEmpty()){
            System.out.println("nao existe esse id");
        }else{
            repository.deleteById(id);
        }
    }

    public ProdutosDTO AtualizarPorId(int id, ProdutosDTO produtosDTO){
        Optional<Produtos> produtos = repository.findById(id);
        if(produtos.isEmpty()){
            System.out.println("nao existe esse id");
            return null;
        }else{
            Produtos produto = new Produtos();
            produto.setId(id);
            produto.setNome(produtosDTO.getNome());
            produto.setPeso(produtosDTO.getPeso());
            produto.setQuantidade(produtosDTO.getQuantidade());
            produto.setCategoria(produtosDTO.getCategoria());
            produto.setDescricao(produtosDTO.getDescricao());
            produto.setPreco(produtosDTO.getPreco());
            produto = repository.save(produto);
            produtosDTO.setId(id);
            return produtosDTO;
        }
    }

    
}
