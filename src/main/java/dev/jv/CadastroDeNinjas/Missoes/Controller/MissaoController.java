package dev.jv.CadastroDeNinjas.Missoes.Controller;


import dev.jv.CadastroDeNinjas.Missoes.MissaoDTO;
import dev.jv.CadastroDeNinjas.Missoes.MissaoModel;
import dev.jv.CadastroDeNinjas.Missoes.Service.MissaoService;
import dev.jv.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.jv.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarMissao(@RequestBody MissaoDTO missao) {
         missaoService.criarMissao(missao);

         return ResponseEntity.status(HttpStatus.CREATED).body("A missão foi criada.");
    }

    // Procurar Missao por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        MissaoDTO ninjaId = missaoService.listarMissoesPorId(id);

        if(ninjaId != null){
            return ResponseEntity.ok(ninjaId);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja não foi encontrado");
    }

    // Mostrar todas as Missoes (READ)
    @GetMapping("/listar")
    public List<MissaoDTO> listarNinjas() {
        return missaoService.listarMissoes();
    }

    // Atualizar Missao (UPDATE)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarNinja(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO) {
        if(missaoService.listarMissoesPorId(id) != null){
           MissaoDTO missao = missaoService.atualizarMissao(id, missaoDTO);
           return ResponseEntity.ok("Missão"+ missao.getNome()+", foi atualizada.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A missão não foi encontrada.");
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable Long id) {
        return missaoService.deletarMissaoPorId(id);
    }
}
