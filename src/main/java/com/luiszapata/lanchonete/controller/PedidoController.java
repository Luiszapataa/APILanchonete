package com.luiszapata.lanchonete.controller;


import com.luiszapata.lanchonete.model.Pedido;
import com.luiszapata.lanchonete.service.PedidoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @RequestMapping("/pedidos")
    public class PedidoController{

        private final PedidoService pedidoService;

        public PedidoController(PedidoService pedidoService) {
            this.pedidoService = pedidoService;

        }

        @GetMapping
        public List<Pedido>listar(){
            return pedidoService.listarPedidos();

        }

        @GetMapping("/{id}")
        public Pedido buscarId(@PathVariable Long id){
            return pedidoService.buscarId(id);
        }

        @GetMapping("/pesquisar")
        public List<Pedido>pesquisar(@RequestParam String texto ){
            return pedidoService.pesquisar(texto);
        }

        @PostMapping
        public Pedido cadastrar(@RequestBody Pedido pedido){
            return pedidoService.salvar(pedido);
        }
    }
