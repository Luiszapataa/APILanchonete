package com.luiszapata.lanchonete.service;

import com.luiszapata.lanchonete.model.Bebida;
import com.luiszapata.lanchonete.repository.BebidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BebidaService {

    private final BebidaRepository bebidaRepository;

    public BebidaService(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    public List<Bebida> listarBebidas(){
        return bebidaRepository .findAll();

    }

    public Bebida salvar(Bebida bebida){
        if (bebidaRepository.existsByCodigo(bebida.getCodigo())){
            throw new IllegalArgumentException("codigo existente");

        } else {
            return bebidaRepository .save(bebida);
        }
    }

    public Bebida buscaId(Long id){
        Optional<Bebida> bebidaOptional = bebidaRepository.findById(id);

        if (bebidaOptional.isPresent()){
            return bebidaOptional.get();
        } else {
            throw new IllegalArgumentException("bebdida nao encontrada");
        }
    }

    public Bebida atualizar (Long id, Bebida novaBebida){
        Bebida bebidaExistente = buscaId(id);


        bebidaExistente.setCodigo(novaBebida.getCodigo());
        bebidaExistente.setDescricao(novaBebida.getDescricao());
        bebidaExistente.setPrecoUnitario(novaBebida.getPrecoUnitario());
        bebidaExistente.setContemAcucar(novaBebida.isContemAcucar());

        return bebidaRepository.save(bebidaExistente);
    }

}
