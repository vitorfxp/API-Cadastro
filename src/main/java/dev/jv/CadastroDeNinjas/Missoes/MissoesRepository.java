package dev.jv.CadastroDeNinjas.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA é uma abstração do springboot no java quando precisamos fazer querys/lidar com banco de dados.
// JPA é basicamente um facilitador  jpa<(qual classe o jpa vai querer que orm fique escaneando),(tipo do id )>

public interface MissoesRepository extends JpaRepository<MissaoModel, Long> {

}
