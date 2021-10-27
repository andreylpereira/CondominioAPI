package com.senai.condominio.model.morador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.senai.condominio.model.morador.entity.Morador;
import com.senai.condominio.model.morador.repository.MoradorRepository;

@Service
public class MoradorService {

	@Autowired
	private MoradorRepository moradorRepository;

	public List<Morador> findAllMoradores() {
		return moradorRepository.findAll();
	}

	public Morador findByMoradorId(@PathVariable Long id) {
		Optional<Morador> optMorador = moradorRepository.findById(id);
		return optMorador.get();
	}

	public List<Morador> addMorador(@RequestBody Morador morador) {

		morador.getAnimais().forEach(animal -> animal.setMorador(morador));
		morador.getVeiculos().forEach(veiculo -> veiculo.setMorador(morador));

		moradorRepository.save(morador);
		return moradorRepository.findAll();

	}

	public void delMorador(@PathVariable Long moradorId) {
		moradorRepository.deleteById(moradorId);
	}

	public void putMorador(@PathVariable Long moradorId, @RequestBody Morador morador) {

		morador.getAnimais().forEach(animal -> animal.setMorador(morador));
		morador.getVeiculos().forEach(veiculo -> veiculo.setMorador(morador));

		moradorRepository.save(morador);

	}
}
