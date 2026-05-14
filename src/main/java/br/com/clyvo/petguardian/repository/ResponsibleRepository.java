package br.com.clyvo.petguardian.repository;

import br.com.clyvo.petguardian.entity.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibleRepository extends JpaRepository<Responsible, Long> {

}