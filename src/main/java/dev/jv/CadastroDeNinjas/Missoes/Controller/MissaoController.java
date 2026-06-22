package dev.jv.CadastroDeNinjas.Missoes.Controller;


import dev.jv.CadastroDeNinjas.Missoes.MissaoDTO;
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
    public MissaoDTO criarMissao(@RequestBody MissaoDTO missao) {
        return missaoService.criarMissao(missao);
    }

    // Procurar Missao por id (READ)
    @GetMapping("/listar/{id}")
    public MissaoModel listarPorId(@PathVariable Long id) {
        return missaoService.listarMissoesPorId(id);
    }

    // Mostrar todas as Missoes (READ)
    @GetMapping("/listar")
    public List<MissaoModel> listarNinjas() {
        return missaoService.listarMissoes();
    }

    // Atualizar Missao (UPDATE)
    @PutMapping("/atualizar/{id}")
    public MissaoModel atualizarNinja(@PathVariable Long id, @RequestBody MissaoModel missaoModel) {
        return missaoService.atualizarMissao(id, missaoModel);
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable Long id) {
        return missaoService.deletarMissaoPorId(id);
    }
}
