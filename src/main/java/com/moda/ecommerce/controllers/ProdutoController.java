package com.moda.ecommerce.controllers;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moda.ecommerce.models.Produto;
import com.moda.ecommerce.repositories.ProdutoRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("")
	public ModelAndView getTodosProdutos() {
		ModelAndView model = new ModelAndView("create/createProduto");
		List<Produto> listaProduto = produtoRepository.findAll();
		model.addObject("listaProdutos", listaProduto);
		return model;
	}
	
	@GetMapping("/masculino")
	public ModelAndView getCategoriaMasculino() {
		ModelAndView model = new ModelAndView("index");
		List<Produto> listaProduto = produtoRepository.findAll();
		Stream<Produto> produtosMasculinos = listaProduto.stream().filter(produto -> produto.getCategoria() == 1);
		model.addObject("produtosFiltrados", produtosMasculinos);
		return model;
	}
	
	@GetMapping("/feminino")
	public ModelAndView getCategoriaFeminino() {
		ModelAndView model = new ModelAndView("index");
		List<Produto> listaProduto = produtoRepository.findAll();
		Stream<Produto> produtosFemininos = listaProduto.stream().filter(produto -> produto.getCategoria() == 2);
		model.addObject("produtosFiltrados", produtosFemininos);
		return model;
	}
	
	@GetMapping("/unissex")
	public ModelAndView getCategoriaUnissex() {
		ModelAndView model = new ModelAndView("index");
		List<Produto> listaProduto = produtoRepository.findAll();
		Stream<Produto> produtosUnissex = listaProduto.stream().filter(produto -> produto.getCategoria() == 3);
		model.addObject("produtosFiltrados", produtosUnissex);
		return model;
	}

	@PostMapping("/createProduto")
	public String create(@ModelAttribute("listaProdutos") Produto objProduto) {
		produtoRepository.save(objProduto);
		return "redirect:/";
	}

}
