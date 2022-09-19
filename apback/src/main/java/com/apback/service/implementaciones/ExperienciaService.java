package com.apback.service.implementaciones;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apback.dto.request.ExperienciaDto;

import com.apback.model.Experiencia;
import com.apback.model.Persona;
import com.apback.repository.ExperienciaRepository;
import com.apback.repository.PersonaRepository;
import com.apback.service.interfaces.IExperienciaService;

@Service
public class ExperienciaService implements IExperienciaService {

	@Autowired
	private ExperienciaRepository experienciaRepository;

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ExperienciaDto getExperiencia(Integer id) {
		Experiencia experiencia = experienciaRepository.getReferenceById(id);

		ExperienciaDto experienciaDto = modelMapper.map(experiencia, ExperienciaDto.class);

		return experienciaDto;
	}

	@Override
	@Transactional
	public Boolean createExperiencia(ExperienciaDto experienciaDto, Integer id) {

		try {
			Experiencia experiencia = modelMapper.map(experienciaDto, Experiencia.class);
			Persona persona = personaRepository.getReferenceById(id);
			experiencia.setPersona(persona);
			experienciaRepository.save(experiencia);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public Boolean deleteExperiencia(Integer id) {
		try {
			experienciaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public Boolean updateExperiencia(ExperienciaDto experienciaDto, Integer id) {
		try {
			if (experienciaRepository.existsById(id)) {
				Experiencia experiencia = modelMapper.map(experienciaDto, Experiencia.class);
				experiencia.setId(id);
				experiencia.setPersona(experienciaRepository.getReferenceById(id).getPersona());
				experienciaRepository.save(experiencia);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<ExperienciaDto> getAllExperiencias() {
		List<Experiencia> experiencias = experienciaRepository.findAll();

		List<ExperienciaDto> experienciasDto = new ArrayList<>();

		for (Experiencia experiencia : experiencias) {

			ExperienciaDto experienciaDto = modelMapper.map(experiencia, ExperienciaDto.class);

			experienciasDto.add(experienciaDto);
		}

		return experienciasDto;
	}

}
