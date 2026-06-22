package dev.jv.CadastroDeNinjas.Ninjas.Service;

import dev.jv.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.jv.CadastroDeNinjas.Ninjas.NinjaMapper;
import dev.jv.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.jv.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public  List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream().map(ninja -> ninjaMapper.map(ninja)).collect(Collectors.toList());
    }


    public NinjaDTO listarPorId (Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninja -> ninjaMapper.map(ninja)).orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
            NinjaModel ninja = ninjaMapper.map(ninjaDTO);
            ninja = ninjaRepository.save(ninja);
            return ninjaMapper.map(ninja);
    }

    public NinjaDTO atualizarNinja (Long id ,NinjaDTO ninja){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninja);
            ninjaAtualizado.setId(id);
            ninjaAtualizado = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaAtualizado);
        }
        return null;
    }

    public String deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
        return "O ninja foi deletado com sucesso";
    }


}
