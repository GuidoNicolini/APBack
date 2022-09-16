package com.apback.service.implementaciones;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apback.dto.request.EstudioDto;
import com.apback.model.Estudio;
import com.apback.repository.EstudioRepository;
import com.apback.service.interfaces.IEstudioService;

@Service
public class EstudioService implements IEstudioService {

	@Autowired
	private EstudioRepository estudioRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EstudioDto getEstudio(Integer id) {

		Estudio estudio = estudioRepository.getReferenceById(id);
		
		EstudioDto estudioDto = modelMapper.map(estudio, EstudioDto.class);
				
		return estudioDto;		
	}

	@Override
	@Transactional
	public Boolean createEstudio(EstudioDto estudioDto) {

		try {
			Estudio estudio = modelMapper.map(estudioDto, Estudio.class);
			estudioRepository.save(estudio);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	@Transactional
	public Boolean deleteEstudio(Integer id) {
		try {
			estudioRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public Boolean updateEstudio(EstudioDto estudioDto, Integer id) {
		try {
			if (estudioRepository.existsById(id)) {
				Estudio estudio = modelMapper.map(estudioDto, Estudio.class);
				estudio.setId(id);
				estudioRepository.save(estudio);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
