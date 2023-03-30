package com.moda.ecommerce.controllers;

import java.util.List;

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
	public ModelAndView getTodosCategoriasEAbrePaginaDeCategoria() {
		ModelAndView model = new ModelAndView("create/createCategoria");
		List<Categoria> listaCategoria = categoriaRepository.findAll();
		model.addObject("listaCategoria", listaCategoria);
		return model;
	}

	@PostMapping("/createCategoria")
	public String create(Categoria categoria) {
		categoriaRepository.save(categoria);
		return "redirect:/";
	}
}
