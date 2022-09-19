package com.apback.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apback.dto.request.DatosUsuarioDto;
import com.apback.repository.DatosUsuarioRepository;
import com.apback.service.implementaciones.DatosUsuarioService;
import com.apback.service.interfaces.IDatosUsuarioService;

@RestController
@RequestMapping("/datos")
public class DatosUsuarioController {

	@Autowired
	private IDatosUsuarioService datosUsuarioService;

	@Autowired
	private DatosUsuarioRepository datosUsuarioRepository;

	@GetMapping("/{id}")
	@PreAuthorize("permitAll()")
	public ResponseEntity<DatosUsuarioDto> getDatosUsuario(@PathVariable Integer id) {

		if (datosUsuarioRepository.existsById(id)) {

			DatosUsuarioDto datosUsuarioDto = datosUsuarioService.getDatosUsuario(id);

			return ResponseEntity.ok(datosUsuarioDto);
		} else {

			return ResponseEntity.notFound().build();

		}
	}

	/**
	 * @PutMapping @PreAuthorize("hasRole('ROLE_ADMIN')") public
	 *             ResponseEntity<String> createDatosUsuario(@RequestBody
	 *             DatosUsuarioDto datosUsuarioDto) {
	 * 
	 *             try { Boolean respuesta =
	 *             datosUsuarioService.createDatosUsuario(datosUsuarioDto); if
	 *             (respuesta) {
	 * 
	 *             return ResponseEntity.ok("Datos cargados con exito"); } else {
	 *             return ResponseEntity.badRequest().body("No se han cargado los
	 *             datos"); } } catch (Exception e) { return
	 *             ResponseEntity.badRequest().body("No se han cargado los datos");
	 *             } }
	 **/

	/**
	 * @DeleteMapping("/{id}") @PreAuthorize("hasRole('ROLE_ADMIN')") public
	 * ResponseEntity<String> deleteDatosUsuario(@PathVariable Integer id) {
	 * 
	 * try { Boolean respuesta = datosUsuarioService.deleteDatosUsuario(id); if
	 * (respuesta) {
	 * 
	 * return ResponseEntity.ok("Datos borrados con exito"); } else { return
	 * ResponseEntity.badRequest().body("No se han borrado los datos"); } } catch
	 * (Exception e) { return ResponseEntity.badRequest().body("No se han borrado
	 * los datos"); } }
	 * 
	 **/
	
	@PatchMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> updateDatosUsuario(@Valid @RequestBody DatosUsuarioDto datosUsuarioDto,
			@PathVariable Integer id) {

		try {
			Boolean respuesta = datosUsuarioService.updateDatosUsuario(datosUsuarioDto, id);
			if (respuesta) {

				return ResponseEntity.ok("Datos actualizados con exito");
			} else {
				return ResponseEntity.badRequest().body("No se han actualizado los datos");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("No se han actualizado los datos");
		}
	}

}
