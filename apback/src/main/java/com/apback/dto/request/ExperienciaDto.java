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
public class ExperienciaDto {
	
	@NotBlank
	private String empresa;

	@NotBlank
	private String puesto;
	
	private String descripcion;


}
