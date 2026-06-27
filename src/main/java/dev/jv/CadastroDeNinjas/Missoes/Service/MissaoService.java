package dev.jv.CadastroDeNinjas.Missoes.Service;


import dev.jv.CadastroDeNinjas.Missoes.MissaoDTO;
import dev.jv.CadastroDeNinjas.Missoes.MissaoMapper;
import dev.jv.CadastroDeNinjas.Missoes.MissaoModel;
import dev.jv.CadastroDeNinjas.Missoes.MissoesRepository;
import dev.jv.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {
    private MissoesRepository missoesRepository;
    private MissaoMapper missaoMapper;

    public MissaoService(MissoesRepository missoesRepository, MissaoMapper missaoMapper) {
        this.missoesRepository = missoesRepository;
        this.missaoMapper = missaoMapper;
    }

    public List<MissaoDTO> listarMissoes() {
        List<MissaoModel> missoes =  missoesRepository.findAll();

        return missoes.stream().map(missao -> missaoMapper.map(missao)).collect(Collectors.toList());
    }

    public MissaoDTO listarMissoesPorId(Long id) {
        Optional<MissaoModel> missaoId = missoesRepository.findById(id);
        return missaoId.map(missao -> missaoMapper.map(missao)).orElse(null);
    }

    public MissaoDTO criarMissao(MissaoDTO missaoDTO) {
        MissaoModel missao = missaoMapper.map(missaoDTO);
        missao = missoesRepository.save(missao);
        return missaoMapper.map(missao);
    }

    public MissaoDTO atualizarMissao(Long id, MissaoDTO missaoDTO){
        Optional<MissaoModel> missaoExiste  = missoesRepository.findById(id);
        if (missaoExiste.isPresent()){
            MissaoModel missao = missaoMapper.map(missaoDTO);
            missao.setId(id);
            missao = missoesRepository.save(missao);
            return missaoMapper.map(missao);
        }
        return null;
    }

    public String deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
        return "Missão deletada!";
    }
}
