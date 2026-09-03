package com.luiszapata.lanchonete.service;

import com.luiszapata.lanchonete.model.*;
import com.luiszapata.lanchonete.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


    @Service
    public class PedidoService{

        private final PedidoRepository pedidoRepository;
        private final HamburguerRepository hamburguerRepository;
        private final BebidaRepository bebidaRepository;

        public PedidoService(PedidoRepository pedidoRepository, HamburguerRepository hamburguerRepository, BebidaRepository bebidaRepository){
            this.bebidaRepository = bebidaRepository;
            this.pedidoRepository = pedidoRepository;
            this.hamburguerRepository = hamburguerRepository;

        }

        public List<Pedido> listarPedidos(){
            return pedidoRepository.findAll();

        }

        public Pedido buscarId(Long id){
            Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

            if (pedidoOptional.isPresent()){
                return pedidoOptional.get();

            } else {
                throw new IllegalArgumentException("pedido nao encontrado ");

            }
        }

        public Pedido salvar(Pedido pedido){
            if(pedidoRepository.existsByCodigo(pedido.getCodigo())){
                throw new IllegalArgumentException("esse codigo ja existe ");


            }

            return  pedidoRepository.save(pedido);
        }

    }

