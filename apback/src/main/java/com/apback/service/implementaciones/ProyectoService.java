package com.apback.service.implementaciones;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apback.dto.request.ProyectoDto;
import com.apback.model.Persona;
import com.apback.model.Proyecto;
import com.apback.repository.PersonaRepository;
import com.apback.repository.ProyectoRepository;
import com.apback.service.interfaces.IProyectoService;

@Service
public class ProyectoService implements IProyectoService {

	@Autowired
	private ProyectoRepository proyectoRepository;

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProyectoDto getProyecto(Integer id) {
		Proyecto proyecto = proyectoRepository.getReferenceById(id);

		ProyectoDto proyectodto = modelMapper.map(proyecto, ProyectoDto.class);

		return proyectodto;
	}

	@Override
	@Transactional
	public Boolean createProyecto(ProyectoDto proyectoDto, Integer id) {
		try {
			Proyecto proyecto = modelMapper.map(proyectoDto, Proyecto.class);
			Persona persona = personaRepository.getReferenceById(id);
			proyecto.setPersona(persona);
			proyectoRepository.save(proyecto);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public Boolean deleteProyecto(Integer id) {
		try {
			proyectoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public Boolean updateProyecto(ProyectoDto proyectoDto, Integer id) {
		try {
			if (proyectoRepository.existsById(id)) {
				Proyecto proyecto = modelMapper.map(proyectoDto, Proyecto.class);
				proyecto.setId(id);
				proyecto.setPersona(proyectoRepository.getReferenceById(id).getPersona());
				proyectoRepository.save(proyecto);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<ProyectoDto> getAllProyectos() {
		List<Proyecto> proyectos = proyectoRepository.findAll();

		List<ProyectoDto> proyectosDto = new ArrayList<>();

		for (Proyecto proyecto : proyectos) {

			ProyectoDto proyectoDto = modelMapper.map(proyecto, ProyectoDto.class);

			proyectosDto.add(proyectoDto);
		}

		return proyectosDto;
	}

}
