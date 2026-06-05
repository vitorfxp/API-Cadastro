package dev.jv.CadastroDeNinjas.Missoes.Controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissaoController {
    // Criar Missao (CREATE)
    @PostMapping("/missao/criar")
    public String criarMissao() {
        return "Missão criada!";
    }

    // Procurar Missao por id (READ)
    @GetMapping("/missao/listarID")
    public String listarPorId() {
        return "Missao listada!";
    }

    // Mostrar todas as Missoes (READ)
    @GetMapping("/missao/listar")
    public String listarNinjas() {
        return "Missoes listadas!";
    }

    // Atualizar Missao (UPDATE)
    @PutMapping("/missao/atualizar")
    public String atualizarNinja() {
        return "Missao atualizada!";
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/missao/deletar")
    public String deletarNinja() {
        return "Missao deletada!";
    }
}
