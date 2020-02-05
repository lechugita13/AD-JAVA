package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
	@GetMapping("/saludar")
	public String saludar() {
		return "Hola soc Guillem";
	}
	@GetMapping("/obtenerPersona")
	public Persona obtenerPersona() {
		return new Persona("Guillem","Clar",23);
	}
}
