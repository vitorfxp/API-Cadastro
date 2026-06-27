package dev.jv.CadastroDeNinjas.Ninjas;

import dev.jv.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


// transforma uma classe em uma tabela do banco de dados
@Entity
@Table(name = "tb_cadastro")
// Isso vem da dependência Lombok
@NoArgsConstructor // Construtor sem nenhum argumento
@AllArgsConstructor // Construtor com todos os argumentos
@Data // Cria getters e setters
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    @Column(name = "aldeia")
    private String aldeia;
    
    private int idade;
    // Muitos ninjas para uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Chave estrangeira
    private MissaoModel missoes;

    @Column(name = "habilidadeEspecial")
    private String habilidadeEspecial;

}
