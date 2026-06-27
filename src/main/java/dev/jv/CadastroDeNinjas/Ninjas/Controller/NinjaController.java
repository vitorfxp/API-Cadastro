package dev.jv.CadastroDeNinjas.Ninjas.Controller;


import dev.jv.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.jv.CadastroDeNinjas.Ninjas.Service.NinjaService;
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

    // ROTA QUE VOCÊ NECESSITA (GET, POST, PUT, PATCH,DELETE + Mappping
    @GetMapping("/primeira")
    public String boasVindas() {
        return "Essa é a minha primeira rota com uma api rest";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarNinja(@RequestBody NinjaDTO ninja) {

         ninjaService.criarNinja(ninja);

        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso!");
    }

    // Procurar Ninja por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id) {
         NinjaDTO ninjaId = ninjaService.listarPorId(id);

         if(ninjaId != null){
            return ResponseEntity.ok(ninjaId);
         }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja não foi encontrado.");
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Atualizar ninja (UPDATE)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarNinja(@PathVariable Long id,@RequestBody NinjaDTO ninja) {
        if (ninjaService.listarPorId(id) != null){
            NinjaDTO ninjaDTO = ninjaService.atualizarNinja(id, ninja);
            return ResponseEntity.ok("Ninja: "+ ninjaDTO.getNome()+",foi atualizado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja não foi encontrado");
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {

        if (ninjaService.listarPorId(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja foi deletado com sucesso!");
        }
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja não foi encontrado");

    }


}
