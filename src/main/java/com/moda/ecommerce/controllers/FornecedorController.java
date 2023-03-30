package com.moda.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moda.ecommerce.models.Fornecedor;
import com.moda.ecommerce.repositories.FornecedorRepository;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@GetMapping("")
	public String sendToCategorias() {
		return "create/createFornecedor";
	}
	
	@PostMapping("/createFornecedor")
	public String create(Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
		return "redirect:/";
	}
}
