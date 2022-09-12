package com.apback.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatosUsuarioDto {
	
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	private String numeroTelefono;
	@NotBlank
	private String email;
	private String pais;
	private String provincia;
	private String ciudad;
	
	private String linkImagenPerfil;
	private String linkImagenPortada;

}
