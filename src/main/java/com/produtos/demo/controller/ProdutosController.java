package com.produtos.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.demo.model.dto.ProdutosDTO;
import com.produtos.demo.service.ProdutosService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("")
public class ProdutosController {
    @Autowired
    ProdutosService produtosService;

    @GetMapping("/buscar")
    public ResponseEntity<List<ProdutosDTO>> BuscarProdutos(){
        List<ProdutosDTO> produtosDTO = produtosService.BuscarProdutos();
        return new ResponseEntity<>(produtosDTO, HttpStatus.OK);
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<ProdutosDTO> BuscaPorId(@PathVariable int id){
        ProdutosDTO produtosDTO = produtosService.BuscaPorId(id);
        return new ResponseEntity<ProdutosDTO>(produtosDTO, HttpStatus.OK);
    }

    @PostMapping("/criar")
    public ResponseEntity<ProdutosDTO> AdicionarProdutos(@RequestBody ProdutosDTO produtosDTO){
        produtosDTO = produtosService.AdicionarProdutos(produtosDTO);
        return new ResponseEntity<ProdutosDTO>(produtosDTO, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ProdutosDTO> AtualizarPorId(@PathVariable int id, @RequestBody ProdutosDTO produtosDTO){
        produtosDTO = produtosService.AtualizarPorId(id, produtosDTO);
        return new ResponseEntity<ProdutosDTO>(produtosDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> ExcluirProdutosPorId(@PathVariable int id){
        produtosService.ExcluirProdutosPorId(id);
        return new ResponseEntity<>("deletado com sucesso", HttpStatus.NO_CONTENT);
    }
    }
    
    
    

