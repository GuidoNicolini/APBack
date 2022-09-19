package com.apback.service.implementaciones;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apback.dto.request.HabilidadDto;
import com.apback.model.Habilidad;
import com.apback.model.Persona;
import com.apback.repository.HabilidadRepository;
import com.apback.repository.PersonaRepository;
import com.apback.service.interfaces.IHabilidadService;

@Service
public class HabilidadService implements IHabilidadService {

	@Autowired
	private HabilidadRepository habilidadRepository;

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public HabilidadDto getHabilidad(Integer id) {
		Habilidad habilidad = habilidadRepository.getReferenceById(id);

		HabilidadDto habilidadDto = modelMapper.map(habilidad, HabilidadDto.class);

		return habilidadDto;
	}

	@Override
	@Transactional
	public Boolean createHabilidad(HabilidadDto habilidadDto, Integer id) {
		try {
			Habilidad habilidad = modelMapper.map(habilidadDto, Habilidad.class);
			Persona persona = personaRepository.getReferenceById(id);
			habilidad.setPersona(persona);
			habilidadRepository.save(habilidad);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public Boolean deleteHabilidad(Integer id) {
		try {
			habilidadRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public Boolean updateHabilidad(HabilidadDto habilidadDto, Integer id) {
		try {
			if (habilidadRepository.existsById(id)) {
				Habilidad habilidad = modelMapper.map(habilidadDto, Habilidad.class);
				habilidad.setId(id);
				habilidad.setPersona(habilidadRepository.getReferenceById(id).getPersona());
				habilidadRepository.save(habilidad);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<HabilidadDto> getAllHabilidades() {
		List<Habilidad> habilidades = habilidadRepository.findAll();

		List<HabilidadDto> habilidadesDto = new ArrayList<>();

		for (Habilidad habilidad : habilidades) {

			HabilidadDto habilidadDto = modelMapper.map(habilidad, HabilidadDto.class);

			habilidadesDto.add(habilidadDto);
		}

		return habilidadesDto;
	}

}
