package com.produtos.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.demo.model.entity.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos,Integer>{
    
}
