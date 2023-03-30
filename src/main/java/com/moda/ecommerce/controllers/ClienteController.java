package com.moda.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.moda.ecommerce.models.Cliente;
import com.moda.ecommerce.repositories.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("")
	public ModelAndView getTodosClientesEAbrePaginaDeCliente() {
		ModelAndView model = new ModelAndView("create/createCliente");
		List<Cliente> listaCliente = clienteRepository.findAll();
		model.addObject("listaCliente", listaCliente);
		return model;
	}

	@PostMapping("/createCliente")
	public String create(Cliente cliente) {
		clienteRepository.save(cliente);
		return "redirect:/";
	}
}
