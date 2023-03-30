package com.moda.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moda.ecommerce.models.Fornecedor;
import com.moda.ecommerce.repositories.FornecedorRepository;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@GetMapping("")
	public ModelAndView getTodosFornecedoresEAbrePaginaDeFornecedor() {
		ModelAndView model = new ModelAndView("create/createFornecedor");
		List<Fornecedor> listaFornecedor = fornecedorRepository.findAll();
		model.addObject("listaFornecedor", listaFornecedor);
		return model;
	}
	
	@PostMapping("/createFornecedor")
	public String create(Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
		return "redirect:/";
	}
}
