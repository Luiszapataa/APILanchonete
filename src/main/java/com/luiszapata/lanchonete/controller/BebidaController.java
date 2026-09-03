package com.luiszapata.lanchonete.controller;

import com.luiszapata.lanchonete.model.Bebida;
import com.luiszapata.lanchonete.service.BebidaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @RequestMapping("/bebidas")
    public class BebidaController{
        private final BebidaService bebidaService;

        public BebidaController (BebidaService bebidaService){
            this.bebidaService = bebidaService;
        }

        @GetMapping
        public List<Bebida> listar(){
            return bebidaService.listarBebidas();
        }

        @GetMapping("/{id}")
        public Bebida buscarId(@PathVariable Long id){
            return bebidaService.buscaId(id);
        }

        @GetMapping("/pesquisar")
        public List<Bebida> pesquisar (@RequestParam String texto){
            return bebidaService.pesquisar(texto);
        }

        @PostMapping
        public Bebida cadastrar (@RequestBody Bebida bebida){
            return bebidaService.salvar(bebida);
        }

        @PutMapping("/{id}")
        public Bebida atualizar(@PathVariable Long id, @RequestBody Bebida bebida){
            return bebidaService.atualizar(id, bebida);

        }
    }

