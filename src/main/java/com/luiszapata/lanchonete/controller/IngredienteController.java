package com.luiszapata.lanchonete.controller;

import com.luiszapata.lanchonete.model.Ingrediente;
import com.luiszapata.lanchonete.service.IngredienteService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/ingredientes")
@CrossOrigin(origins = "http://localhost:4200")
public class IngredienteController{

    private final IngredienteService ingredienteService;

    public IngredienteController(IngredienteService ingredienteService){
        this.ingredienteService = ingredienteService;

    }

    @GetMapping
    public List<Ingrediente> listar(){
        return ingredienteService.listarIngredientes();


    }

    @GetMapping("/{id}")
    public Ingrediente buscarId(@PathVariable Long id) {
        return ingredienteService.buscaId(id);
    }

    @GetMapping("/pesquisar")
    public List<Ingrediente> pesquisar(@RequestParam String texto) {
        return ingredienteService.pesquisar(texto);
    }

    @PostMapping
    public Ingrediente cadastrar(@RequestBody Ingrediente ingrediente){
        return ingredienteService.salvar(ingrediente);


    }


    @PutMapping("/{id}")
    public Ingrediente atualizar(@PathVariable Long id, @RequestBody Ingrediente ingrediente){
        return ingredienteService.atualizar(id, ingrediente);
    }


}



