package dev.jv.CadastroDeNinjas.Missoes.Controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missao")
public class MissaoController {
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
    public String listarNinjas() {
        return "Missoes listadas!";
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
