package dev.adiel.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.adiel.dsvendas.dtos.SaleDTO;
import dev.adiel.dsvendas.dtos.SaleSumDTO;
import dev.adiel.dsvendas.entities.Sale;
import dev.adiel.dsvendas.repositories.SaleRepository;
import dev.adiel.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly= true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll(); // armazenar em memoria pra evitar muitas consultas ao DB
		Page<Sale> result = repository.findAll(pageable);
		return result.map(sale -> new SaleDTO(sale));
	}
	
	@Transactional(readOnly= true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
}
