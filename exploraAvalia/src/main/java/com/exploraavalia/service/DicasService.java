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

        if (dicas.getDescricao() == null || dicas.getDescricao().length() < 500) {
            throw new Exception("Descricão deve ter pelo menos 500 caracteres.");
        }

        if (dicas.getDestino() == null) {
            throw new Exception("Destino inválido. Digite um válido.");
        }

        if (dicas.getAvaliacao() == null || dicas.getAvaliacao() < 1 || dicas.getAvaliacao() < 5) {
            throw new Exception("Nível de avaliação inválido. Digite um número de 1 a 5");
        }

        if (dicas.getCustoMedioDia() == null) {
            throw new Exception("Custo médio inválido. Valor um válido.");
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


