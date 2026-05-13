package br.com.clyvo.petguardian.repository;

import br.com.clyvo.petguardian.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
