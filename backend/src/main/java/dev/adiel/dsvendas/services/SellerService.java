package dev.adiel.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.adiel.dsvendas.dtos.SellerDTO;
import dev.adiel.dsvendas.entities.Seller;
import dev.adiel.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;
	public List<SellerDTO> findAll() {
		List<Seller> result = repository.findAll();
		return result.stream().map(seller -> new SellerDTO(seller)).collect(Collectors.toList());
	}
}
