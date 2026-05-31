package dev.jv.CadastroDeNinjas.Missoes;

import dev.jv.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "tb_missoes")
// Isso vem da dependência Lombok
@NoArgsConstructor // Construtor sem nenhum argumento
@AllArgsConstructor // Construtor com todos os argumentos
@Data // Cria getters e setters
public class MissaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Rank rank;
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;
}
