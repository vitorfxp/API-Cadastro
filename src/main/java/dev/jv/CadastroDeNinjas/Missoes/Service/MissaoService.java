package dev.jv.CadastroDeNinjas.Missoes.Service;


import dev.jv.CadastroDeNinjas.Missoes.MissaoModel;
import dev.jv.CadastroDeNinjas.Missoes.MissoesRepository;
import dev.jv.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {
    private MissoesRepository missoesRepository;

    public MissaoService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissaoModel> listarMissoes() {return missoesRepository.findAll();}

    public MissaoModel listarMissoesPorId(Long id) {
        Optional<MissaoModel> missaoModel = missoesRepository.findById(id);
        return missaoModel.orElse(null);
    }
}
