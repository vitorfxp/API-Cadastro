package dev.jv.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setAldeia(ninjaDTO.getAldeia());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());
        ninjaModel.setNivel(ninjaDTO.getNivel());
        ninjaModel.setHabilidadeEspecial(ninjaDTO.getHabilidadeEspecial());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setAldeia(ninjaModel.getAldeia());
        ninjaDTO.setNivel(ninjaModel.getNivel());
        ninjaDTO.setHabilidadeEspecial(ninjaModel.getHabilidadeEspecial());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());

        return ninjaDTO;
    }

}
