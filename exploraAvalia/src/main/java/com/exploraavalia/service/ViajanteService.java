package com.exploraavalia.service;

import com.exploraavalia.model.entity.Viajante;
import com.exploraavalia.model.repository.ViajanteRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ViajanteService {

    private ViajanteRepository viajanteRepository;

    public ViajanteService(ViajanteRepository viajanteRepository){
        this.viajanteRepository = viajanteRepository;
    }

    public List<Viajante> findAll(){
        return viajanteRepository.findAll();
    }

    public Viajante findById(Long id) throws Exception {

        Optional<Viajante> viajante = viajanteRepository.findById(id);

        if (!viajante.isPresent()) {
            throw new Exception("Viajante não encontrado");
        }

        return viajante.get();
    }

    public Viajante save(Viajante viajante) throws Exception {

        if (viajante.getNome() == null || viajante.getNome().length() < 3) {
            throw new Exception("Nome deve ter pelo menos 3 caracteres.");
        }

        viajante.setDataNascimento(new Date());
        return viajanteRepository.save(viajante);
    }

    public Viajante delete(Long id) throws Exception {
        Optional<Viajante> viajante = viajanteRepository.findById(id);

        if (!viajante.isPresent()) {
            throw new Exception("Viajante não encontrado");
        }

        viajanteRepository.delete(viajante.get());
        return viajante.get();
    }

        public Long count(){
        return viajanteRepository.count();
    }
}
