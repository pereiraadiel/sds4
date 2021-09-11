package dev.adiel.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.adiel.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
