package dev.jv.CadastroDeNinjas.Missoes.Service;


import dev.jv.CadastroDeNinjas.Missoes.MissaoModel;
import dev.jv.CadastroDeNinjas.Missoes.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {
    private MissoesRepository missoesRepository;

    public MissaoService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissaoModel> listarMissoes() {return missoesRepository.findAll();};
}
