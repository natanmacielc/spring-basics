package br.com.dev.spring.essentials.domain.repository;

import br.com.dev.spring.essentials.domain.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}
