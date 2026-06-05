package dev.jv.CadastroDeNinjas.Ninjas.Controller;


import org.springframework.web.bind.annotation.*;


// RestController é uma anotation para indicar que essa classe é um controller
@RestController
@RequestMapping
public class NinjaController {


    // ROTA QUE VOCÊ NECESSITA (GET, POST, PUT, PATCH,DELETE + Mappping
    @GetMapping("/primeira")
    public String boasVindas(){
        return "Essa é a minha primeira rota com uma api rest";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/ninja/adicionar")
    public String adicionarNinja() {
        return "Ninja criado!";
    }

    // Procurar Ninja por id (READ)
    @GetMapping("/ninja/listarID")
    public String listarPorId() {
        return "Ninja listado!";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/ninja/listar")
    public String listarNinjas() {
        return "Ninja listados!";
    }

    // Atualizar ninja (UPDATE)
    @PutMapping("/ninja/atualizar")
    public String atualizarNinja() {
        return "Ninja atualizado!";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/ninja/deletar")
    public String deletarNinja() {
        return "Ninja deletado!";
    }


}
