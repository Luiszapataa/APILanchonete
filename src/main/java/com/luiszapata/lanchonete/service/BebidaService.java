package com.luiszapata.lanchonete.service;

import com.luiszapata.lanchonete.model.Bebida;
import com.luiszapata.lanchonete.repository.BebidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BebidaService {

    private final BebidaRepository bebidaRepository;

    public BebidaService(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    public List<Bebida> listarBebidas(){
        return bebidaRepository .findAll();

    }


}
