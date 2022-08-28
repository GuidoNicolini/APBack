package com.apback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "datos_usuarios")
public class DatosUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	private String apellido;
	private String numeroTelefono;
	private String email;
	private String pais;
	private String provincia;
	private String ciudad;
	
	@Lob
	@Column(length = 1000)
	private String linkImagenPerfil;
	
	@Lob
	@Column(length = 1000)
	private String linkImagenPortada;
	
}
