package dev.jv.CadastroDeNinjas.Missoes;


import dev.jv.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.jv.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {

    public MissaoModel map(MissaoDTO missaoDTO){
        MissaoModel missaoModel = new MissaoModel();
        missaoModel.setId(missaoDTO.getId());
        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setDescricao(missaoDTO.getDescricao());
        missaoModel.setRank(missaoDTO.getRank());
        missaoModel.setNinjas(missaoDTO.getNinjas());


        return missaoModel;
    }

    public MissaoDTO map(MissaoModel missaoModel){
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(missaoModel.getId());
        missaoDTO.setNome(missaoModel.getNome());
        missaoDTO.setDescricao(missaoModel.getDescricao());
        missaoDTO.setRank(missaoModel.getRank());
        missaoDTO.setNinjas(missaoModel.getNinjas());

        return missaoDTO;
    }


}
