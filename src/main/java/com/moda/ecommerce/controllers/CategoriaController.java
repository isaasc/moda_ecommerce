package com.moda.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.moda.ecommerce.repositories.CategoriaRepository;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
}
