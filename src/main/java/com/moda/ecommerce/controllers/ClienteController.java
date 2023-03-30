package com.moda.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moda.ecommerce.models.Cliente;
import com.moda.ecommerce.repositories.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("")
	public String sendToCliente() {
		return "create/createCliente";
	}
	
	@PostMapping("/createCliente")
	public String create(Cliente cliente) {
		clienteRepository.save(cliente);
		return "redirect:/";
	}
}
