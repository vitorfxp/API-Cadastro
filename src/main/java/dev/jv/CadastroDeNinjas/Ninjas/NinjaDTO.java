package dev.jv.CadastroDeNinjas.Ninjas;

import dev.jv.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class  NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private Nivel nivel;
    private String aldeia;
    private int idade;
    private MissaoModel missoes;
    private String habilidadeEspecial;

}
