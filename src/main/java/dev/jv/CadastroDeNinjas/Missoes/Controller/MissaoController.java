package dev.jv.CadastroDeNinjas.Missoes.Controller;


import dev.jv.CadastroDeNinjas.Missoes.MissaoModel;
import dev.jv.CadastroDeNinjas.Missoes.Service.MissaoService;
import dev.jv.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    // Criar Missao (CREATE)
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criada!";
    }

    // Procurar Missao por id (READ)
    @GetMapping("/listarID")
    public String listarPorId() {
        return "Missao listada!";
    }

    // Mostrar todas as Missoes (READ)
    @GetMapping("/listar")
    public List<MissaoModel> listarNinjas() {
        return missaoService.listarMissoes();
    }

    // Atualizar Missao (UPDATE)
    @PutMapping("/atualizar")
    public String atualizarNinja() {
        return "Missao atualizada!";
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/deletar")
    public String deletarNinja() {
        return "Missao deletada!";
    }
}
