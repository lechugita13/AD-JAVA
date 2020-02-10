package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class PersonaController {

		@Autowired
		private PersonaRepository personaRepository;
		
		@GetMapping("/personas")
		public List<Persona>getPersonas(){
			return (List<Persona>)personaRepository.findAll();
		}
		@PostMapping("personasadd")
		public Persona crearPersona(@RequestBody Persona persona) {
			return personaRepository.save(persona);
		}
		
}
