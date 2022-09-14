package com.apback.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaRespuestaAdminDto {

	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	
}
