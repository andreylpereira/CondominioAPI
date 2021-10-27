package com.senai.condominio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.condominio.model.morador.entity.Morador;
import com.senai.condominio.model.morador.service.MoradorService;

import javassist.NotFoundException;


@RestController
@RequestMapping(value = "/api")
public class MoradorController {
	
	@Autowired
	private MoradorService moradorService;
	
	@GetMapping("/moradores")
	public List<Morador> puxarTodosMoradores() {
		return moradorService.findAllMoradores();
	}
	
	@PostMapping("/moradores")
	public List<Morador> adicionarMorador(@RequestBody Morador morador) {
		return moradorService.addMorador(morador);
	}
	
	@DeleteMapping("/moradores/{moradorId}/")
	
	public void deleteMorador(@PathVariable Long moradorId) {
		moradorService.delMorador(moradorId);
	}
	
	@PutMapping("/moradores/{moradorId}/") 
	public void atualizarMorador(@PathVariable Long moradorId, @RequestBody Morador morador) {
		moradorService.putMorador(moradorId, morador);
	}
	
	@GetMapping("/moradores/{id}/")
	public Morador puxarMoradorPelaId(@PathVariable Long id) throws NotFoundException {
		return moradorService.findByMoradorId(id);
	}
	
}
