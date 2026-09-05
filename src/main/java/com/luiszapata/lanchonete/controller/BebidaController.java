package com.luiszapata.lanchonete.controller;


import com.luiszapata.lanchonete.model.Bebida;
import com.luiszapata.lanchonete.service.BebidaService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

    @RestController
    @CrossOrigin(origins = "http://localhost:4200")
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

