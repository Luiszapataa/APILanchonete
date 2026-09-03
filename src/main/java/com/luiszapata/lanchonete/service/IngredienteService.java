package com.luiszapata.lanchonete.service;

import com.luiszapata.lanchonete.model.Ingrediente;
import com.luiszapata.lanchonete.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public List<Ingrediente> listarIngredientes() {
        return ingredienteRepository.findAll();
    }

    public Ingrediente salvar(Ingrediente ingrediente) {
        if (ingredienteRepository.existsByCodigo(ingrediente.getCodigo())) {
            throw new IllegalArgumentException("codigo existente");
        } else {
            return ingredienteRepository.save(ingrediente);
        }
    }

    public Ingrediente buscaId(Long id) {
        Optional<Ingrediente> ingredienteOptional = ingredienteRepository.findById(id);

        if (ingredienteOptional.isPresent()) {
            return ingredienteOptional.get();
        } else {
            throw new IllegalArgumentException("ingrediente nao encontrado");
        }
    }

    public Ingrediente atualizar(Long id, Ingrediente novoIngrediente) {
        Ingrediente ingredienteExistente = buscaId(id);

        ingredienteExistente.setCodigo(novoIngrediente.getCodigo());
        ingredienteExistente.setDescricao(novoIngrediente.getDescricao());
        ingredienteExistente.setPrecoUnitario(novoIngrediente.getPrecoUnitario());
        ingredienteExistente.setItemAdicional(novoIngrediente.isItemAdicional());

        return ingredienteRepository.save(ingredienteExistente);
    }

    public List<Ingrediente> pesquisar(String texto) {
        return ingredienteRepository.findByCodigoContainingOrDescricaoContaining(texto, texto);
    }
}