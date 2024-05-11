package com.exploraavalia.service;

import com.exploraavalia.model.entity.Dicas;
import com.exploraavalia.model.repository.DicasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DicasService {

    private DicasRepository dicasRepository;

    public DicasService(DicasRepository dicasRepository){
        this.dicasRepository = dicasRepository;
    }

    public List<Dicas> findAll(){
        return dicasRepository.findAll();
    }

    public Dicas findById(Long id) throws Exception {

        Optional<Dicas> dicas = dicasRepository.findById(id);

        if (!dicas.isPresent()) {
            throw new Exception("Dicas não encontrado");
        }

        return dicas.get();
    }

    public Dicas save(Dicas dicas) throws Exception {

            if (dicas.getDestino() == null) {
                throw new Exception("Destino inválido. Por favor, insira um destino válido.");
            }

            if (dicas.getCategorias() == null) {
                throw new Exception("Categoria inválida. Por favor, insira uma categoria válida.");
            }

            if (dicas.getDescricao() == null || dicas.getDescricao().length() < 20) {
                throw new Exception("Descrição inválida. A descrição deve ter pelo menos 20 caracteres.");
            }

            if (dicas.getTitulo() == null || dicas.getTitulo().length() < 10) {
                throw new Exception("Título inválido. O título deve ter pelo menos 10 caracteres.");
            }

            if (dicas.getAvaliacao() == null || dicas.getAvaliacao() < 1 || dicas.getAvaliacao() > 5) {
                throw new Exception("Nível de avaliação inválido. Insira um valor de avaliação entre 1 e 5.");
            }

            if (dicas.getCustoMedioDia() == null) {
                throw new Exception("Custo médio inválido. Insira um valor válido para o custo médio.");
            }

        return dicasRepository.save(dicas);
    }

    public Dicas delete(Long id) throws Exception {
        Optional<Dicas> dicas = dicasRepository.findById(id);

        if (!dicas.isPresent()) {
            throw new Exception("Dicas não encontrado");
        }

        dicasRepository.delete(dicas.get());
        return dicas.get();
    }

    public Long count(){
        return dicasRepository.count();
    }
}


