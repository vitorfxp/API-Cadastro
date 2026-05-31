package dev.jv.CadastroDeNinjas;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// RestController é uma anotation para indicar que essa classe é um controller
@RestController
@RequestMapping
public class NinjaController {


    // ROTA QUE VOCÊ NECESSITA (GET, POST, PUT, PATCH,DELETE + Mappping
    @GetMapping("/primeira")
    public String boasVindas(){
        return "Essa é a minha primeira rota com uma api rest";
    }

}
