package dev.jv.CadastroDeNinjas.Ninjas.Service;

import dev.jv.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.jv.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel listarPorId (Long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    public NinjaModel criarNinja(NinjaModel ninja){
            return ninjaRepository.save(ninja);
    }

    public NinjaModel atualizarNinja (Long id ,NinjaModel ninja){
        if (ninjaRepository.existsById(id)){
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        }
        return null;
    }

    public String deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
        return "O ninja foi deletado com sucesso";
    }


}
