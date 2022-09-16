package com.apback.service.implementaciones;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apback.dto.request.DatosUsuarioDto;
import com.apback.model.DatosUsuario;
import com.apback.repository.DatosUsuarioRepository;
import com.apback.service.interfaces.IDatosUsuarioService;

@Service
public class DatosUsuarioService implements IDatosUsuarioService {

	@Autowired
	private DatosUsuarioRepository datosUsuarioRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DatosUsuarioDto getDatosUsuario(Integer id) {

		DatosUsuario datosUsuario = datosUsuarioRepository.getReferenceById(id);

		DatosUsuarioDto datosUsuarioDto = modelMapper.map(datosUsuario, DatosUsuarioDto.class);

		return datosUsuarioDto;

	}

	@Override
	@Transactional
	public Boolean createDatosUsuario(DatosUsuarioDto datosUsuarioDto) {

		try {
			DatosUsuario datosUsuario = modelMapper.map(datosUsuarioDto, DatosUsuario.class);
			datosUsuarioRepository.save(datosUsuario);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	@Transactional
	public Boolean deleteDatosUsuario(Integer id) {

		try {
			datosUsuarioRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public Boolean updateDatosUsuario(DatosUsuarioDto datosUsuarioDto, Integer id) {

		try {

			if (datosUsuarioRepository.existsById(id)) {
				DatosUsuario datosUsuario = modelMapper.map(datosUsuarioDto, DatosUsuario.class);
				datosUsuario.setId(id);
				datosUsuarioRepository.save(datosUsuario);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}

	}

}
