package br.com.saude.coletiva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.saude.coletiva.model.UnidadeUrgenciaEmergencia;

@Repository
public interface UnidadeUrgenciaEmergenciaRepository extends JpaRepository<UnidadeUrgenciaEmergencia, Long>{

}
