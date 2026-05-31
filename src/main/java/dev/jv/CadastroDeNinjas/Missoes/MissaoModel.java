package dev.jv.CadastroDeNinjas.Missoes;

import dev.jv.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "tb_missoes")
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
