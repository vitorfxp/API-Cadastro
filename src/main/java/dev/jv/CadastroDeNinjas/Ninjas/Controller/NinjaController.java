package dev.jv.CadastroDeNinjas.Ninjas.Controller;


import dev.jv.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.jv.CadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// RestController é uma anotation para indicar que essa classe é um controller
@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // ROTA QUE VOCÊ NECESSITA (GET, POST, PUT, PATCH,DELETE + Mappping
    @GetMapping("/primeira")
    public String boasVindas() {
        return "Essa é a minha primeira rota com uma api rest";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/adicionar")
    public NinjaModel adicionarNinja(@RequestBody NinjaModel ninjaModel) {
        return ninjaService.criarNinja(ninjaModel);
    }

    // Procurar Ninja por id (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarPorId(id);
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Atualizar ninja (UPDATE)
    @PutMapping("/atualizar/{id}")
    public NinjaModel atualizarNinja(@PathVariable Long id,@RequestBody NinjaModel ninja) {
        return ninjaService.atualizarNinja(id, ninja);
    }


    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable Long id) {
        return ninjaService.deletarNinja(id);
    }


}
