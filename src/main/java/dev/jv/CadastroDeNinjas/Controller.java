package dev.jv.CadastroDeNinjas;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/primeira")
    public String boasVindas(){
        return "Essa é a minha primeira rota com uma api rest";
    }

}
