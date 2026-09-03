package com.luiszapata.lanchonete.service;

import com.luiszapata.lanchonete.model.Hamburguer;
import com.luiszapata.lanchonete.model.Ingrediente;
import com.luiszapata.lanchonete.repository.HamburguerRepository;
import com.luiszapata.lanchonete.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HamburguerService {

    private final HamburguerRepository hamburguerRepository;

    private final IngredienteRepository ingredienteRepository;

    public HamburguerService(HamburguerRepository hamburguerRepository, IngredienteRepository ingredienteRepository) {
        this.hamburguerRepository = hamburguerRepository;
        this.ingredienteRepository = ingredienteRepository;


    }

    public List<Hamburguer> listarHamburgueres() {
        return hamburguerRepository.findAll();

    }

    public Hamburguer buscaId(Long id) {
        Optional<Hamburguer> hamburguerOptional = hamburguerRepository.findById(id);

        if (hamburguerOptional.isPresent()) {
            return hamburguerOptional.get();
        } else {
            throw new IllegalArgumentException("hamburger nao encontrado ");


        }


    }

    public Hamburguer salvar(Hamburguer hamburguer) {
        if (hamburguerRepository.existsByCodigo(hamburguer.getCodigo())) {

            throw new IllegalArgumentException("codigo ja existe ");

        }


        List<Ingrediente> listaCompleta = new ArrayList<>();


        for (Ingrediente item : hamburguer.getHamburguerIngrediente()) {
            Optional<Ingrediente> ingredienteOptional = ingredienteRepository.findById(item.getId());

            if (ingredienteOptional.isPresent()) {
                listaCompleta.add(ingredienteOptional.get());
            } else {
                throw new IllegalArgumentException("o ingrediente nao foi encontrado ");
            }

        }

        hamburguer.setHamburguerIngrediente(listaCompleta);

        return hamburguerRepository.save(hamburguer);

    }

    public Hamburguer atualizar(Long id, Hamburguer novoHamburguer) {

        Hamburguer hamburguerExistente = buscaId(id);

        hamburguerExistente.setCodigo(novoHamburguer.getCodigo());
        hamburguerExistente.setDescricao(novoHamburguer.getDescricao());
        hamburguerExistente.setValor(novoHamburguer.getValor());

        List<Ingrediente> listaCompleta = new ArrayList<>();

        for (Ingrediente item : novoHamburguer.getHamburguerIngrediente()) {

            Optional<Ingrediente> ingredienteOptional = ingredienteRepository.findById(item.getId());

            if (ingredienteOptional.isPresent()) {
                listaCompleta.add(ingredienteOptional.get());
            } else {
                throw new IllegalArgumentException("ingrediente nao encontrado ");
            }
        }

        hamburguerExistente.setHamburguerIngrediente(listaCompleta);

        return hamburguerRepository.save(hamburguerExistente);

    }

    public List<Hamburguer> pesquisar(String texto) {
        return hamburguerRepository.findByCodigoContainingOrDescricaoContaining(texto, texto);

    }
}