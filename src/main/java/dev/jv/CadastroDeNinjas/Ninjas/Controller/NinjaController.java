package dev.jv.CadastroDeNinjas.Ninjas.Controller;


import dev.jv.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.jv.CadastroDeNinjas.Ninjas.Service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// RestController é uma anotation para indicar que essa classe é um controller
@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @Operation(
            summary = "Adicionar ninja",
            description = "Cria um novo ninja no sistema com os dados fornecidos no corpo da requisição"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarNinja(@RequestBody NinjaDTO ninja) {
        ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso!");
    }

    @Operation(
            summary = "Buscar ninja por ID",
            description = "Retorna os dados de um ninja específico com base no ID informado"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
        NinjaDTO ninjaId = ninjaService.listarPorId(id);

        if (ninjaId != null) {
            return ResponseEntity.ok(ninjaId);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja não foi encontrado.");
    }

    @Operation(
            summary = "Listar todos os ninjas",
            description = "Retorna uma lista com todos os ninjas cadastrados no sistema"
    )
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @Operation(
            summary = "Atualizar ninja",
            description = "Atualiza os dados de um ninja existente com base no ID informado"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        if (ninjaService.listarPorId(id) != null) {
            NinjaDTO ninjaDTO = ninjaService.atualizarNinja(id, ninja);
            return ResponseEntity.ok("Ninja: " + ninjaDTO.getNome() + ",foi atualizado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja não foi encontrado");
    }

    @Operation(
            summary = "Deletar ninja",
            description = "Remove permanentemente um ninja do sistema com base no ID informado"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {

        if (ninjaService.listarPorId(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja foi deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja não foi encontrado");

    }


}
