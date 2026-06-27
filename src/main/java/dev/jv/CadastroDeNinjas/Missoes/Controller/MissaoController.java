package dev.jv.CadastroDeNinjas.Missoes.Controller;


import dev.jv.CadastroDeNinjas.Missoes.MissaoDTO;
import dev.jv.CadastroDeNinjas.Missoes.MissaoModel;
import dev.jv.CadastroDeNinjas.Missoes.Service.MissaoService;
import dev.jv.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.jv.CadastroDeNinjas.Ninjas.NinjaModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(
            summary = "Cria uma nova missão",
            description = "Cria uma nova missão no sistema com os dados fornecidos no corpo da requisição"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "A missão foi criada."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissaoDTO missao) {
         missaoService.criarMissao(missao);

         return ResponseEntity.status(HttpStatus.CREATED).body("A missão foi criada.");
    }

    @Operation(
            summary = "Lista uma missão especifica ",
            description = "Lista uma missão no sistema com o id fornecido e comparando no banco."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna o ninja pelo id cadastrado no sistema."),
            @ApiResponse(responseCode = "404", description = "A missão não foi encontrada")
    })
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        MissaoDTO ninjaId = missaoService.listarMissoesPorId(id);

        if(ninjaId != null){
            return ResponseEntity.ok(ninjaId);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A missão não foi encontrada");
    }

    @Operation(
            summary = "Lista todas as missões",
            description = "Lista missões no sistema com os dados fornecidos no banco de dados"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna os ninjas cadastrados no sistema."),
    })
    @GetMapping("/listar")
    public List<MissaoDTO> listarNinjas() {
        return missaoService.listarMissoes();
    }

    @Operation(
            summary = "Atualiza uma missão em específico",
            description = "Atualiza a missão com os dados fornecidos no corpo da requisição"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna os ninjas cadastrados no sistema."),
            @ApiResponse(responseCode = "404", description = "O ninja não foi encontrado")
    })
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarNinja(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO) {
        if(missaoService.listarMissoesPorId(id) != null){
           MissaoDTO missao = missaoService.atualizarMissao(id, missaoDTO);
           return ResponseEntity.ok("Missão"+ missao.getNome()+", foi atualizada.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A missão não foi encontrada.");
    }

    @Operation(
            summary = "Deletar missão",
            description = "Remove permanentemente uma missão do sistema com base no ID informado"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Missão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Missão não encontrada")
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {

        if (missaoService.listarMissoesPorId(id) != null) {
            missaoService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missão deletada com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão não encontrada");

    }
}
