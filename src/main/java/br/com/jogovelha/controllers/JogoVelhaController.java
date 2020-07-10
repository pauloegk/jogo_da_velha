package br.com.jogovelha.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jogovelha.dto.BodyDTO;
import br.com.jogovelha.services.JogoVelhaService;

@RestController
@RequestMapping("jogovelha")
public class JogoVelhaController {

	@Autowired
	private JogoVelhaService service;

	@PostMapping()
	private ResponseEntity<?> isVelha(@RequestBody @Valid BodyDTO body) {

		if (body.getJogo() == null || body.getJogo().length == 0) {
			return ResponseEntity.badRequest().build();
		}

		boolean velha = service.isVelha(body.getJogo());

		if (velha) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
