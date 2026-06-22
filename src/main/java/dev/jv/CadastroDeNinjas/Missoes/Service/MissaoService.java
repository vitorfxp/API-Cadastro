package dev.jv.CadastroDeNinjas.Missoes.Service;


import dev.jv.CadastroDeNinjas.Missoes.MissaoDTO;
import dev.jv.CadastroDeNinjas.Missoes.MissaoMapper;
import dev.jv.CadastroDeNinjas.Missoes.MissaoModel;
import dev.jv.CadastroDeNinjas.Missoes.MissoesRepository;
import dev.jv.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {
    private MissoesRepository missoesRepository;
    private MissaoMapper missaoMapper;

    public MissaoService(MissoesRepository missoesRepository, MissaoMapper missaoMapper) {
        this.missoesRepository = missoesRepository;
        this.missaoMapper = missaoMapper;
    }

    public List<MissaoModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    public MissaoModel listarMissoesPorId(Long id) {
        Optional<MissaoModel> missaoModel = missoesRepository.findById(id);
        return missaoModel.orElse(null);
    }

    public MissaoDTO criarMissao(MissaoDTO missaoDTO) {
        MissaoModel missao = missaoMapper.map(missaoDTO);
        missao = missoesRepository.save(missao);
        return missaoMapper.map(missao);
    }

    public MissaoModel atualizarMissao(Long id, MissaoModel missao){
        if (missoesRepository.existsById(id)){
            missao.setId(id);
            return missoesRepository.save(missao);
        }
        return null;
    }

    public String deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
        return "Missão deletada!";
    }
}
