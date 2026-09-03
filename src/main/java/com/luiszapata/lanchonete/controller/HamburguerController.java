package com.luiszapata.lanchonete.controller;



import com.luiszapata.lanchonete.model.Hamburguer;
import com.luiszapata.lanchonete.service.HamburguerService;
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
@RequestMapping("/hamburgueres")
public class HamburguerController {

    private final HamburguerService hamburguerService;

    public HamburguerController(HamburguerService hamburguerService) {

        this.hamburguerService = hamburguerService;

    }

    @GetMapping
    public List<Hamburguer> listar(){
        return hamburguerService.listarHamburgueres ();

    }

    @GetMapping("/{id}")
    public Hamburguer buscarId(@PathVariable Long id){
        return hamburguerService.buscaId(id);

    }

    @GetMapping("/pesquisar")
    public List<Hamburguer> pesquisar(@RequestParam String texto){
        return hamburguerService.pesquisar(texto);

    }


    @PostMapping
    public Hamburguer cadastrar(@RequestBody Hamburguer hamburguer){
        return hamburguerService.salvar(hamburguer);

    }

    @PutMapping("/{id}")
    public Hamburguer atualizar(@PathVariable Long id, @RequestBody Hamburguer hamburguer){
        return hamburguerService.atualizar(id, hamburguer);

    }



}




