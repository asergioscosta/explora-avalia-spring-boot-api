package com.exploraavalia.service;

import com.exploraavalia.model.entity.Viajante;
import com.exploraavalia.model.repository.ViajanteRepository;
import org.springframework.dao.DataIntegrityViolationException;
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

        if (viajante.getNome() == null || viajante.getNome().length() < 3 || viajante.getNome().isEmpty()) {
            throw new Exception("Nome deve ter pelo menos 3 caracteres.");
        }

        if (viajante.getDataNascimento() == null) {
            throw new Exception("Data de Nascimento inválida. Digite uma data de nascimento válida.");
        }

        if (viajante.getNivelExperiencia() == null || viajante.getNivelExperiencia() < 1 || viajante.getNivelExperiencia() > 5) {
            throw new Exception("Nível de Experiência inválido. O nível de experiência deve estar entre 1 e 5.");
        }

        if (viajante.getEmail() == null || viajante.getEmail().isEmpty()){
            throw new Exception("E-mail inválido. Digite um e-mail válido.");
        }

        if (viajante.getTelefone() == null) {
            throw new Exception("Telefone inválido. Digite um telefone válido.");
        }

        if (viajanteRepository.findByEmail(viajante.getEmail()).isPresent()) {
            throw new Exception("O email fornecido já está em uso.");
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
