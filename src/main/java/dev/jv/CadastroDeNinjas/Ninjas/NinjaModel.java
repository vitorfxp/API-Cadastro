package dev.jv.CadastroDeNinjas.Ninjas;

import dev.jv.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;

import java.util.List;


// transforma uma classe em uma tabela do banco de dados
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Nivel nivel;
    private int idade;

    // Muitos ninjas para uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Chave estrangeira
    private MissaoModel missoes;

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public NinjaModel() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
