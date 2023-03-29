package com.moda.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moda.ecommerce.models.Categoria;
import com.moda.ecommerce.repositories.CategoriaRepository;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping("")
	public String getCategorias() {
		return "create/createCategoria";
	}
	
	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}
	
	@PostMapping("/create")
	public String create(Categoria categoria) {
		categoriaRepository.save(categoria);
		return "redirect:/categoria/index";
	}
}
