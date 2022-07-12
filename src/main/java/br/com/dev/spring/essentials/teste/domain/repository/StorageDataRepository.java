package br.com.dev.spring.essentials.teste.domain.repository;

import br.com.dev.spring.essentials.teste.domain.entities.StorageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageDataRepository extends JpaRepository<StorageData, Long> {
}
