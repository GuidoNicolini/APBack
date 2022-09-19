package com.apback.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "personas")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(fetch = FetchType.LAZY,cascade = { CascadeType.ALL })
	private DatosUsuario datosUsuario;

	@OneToMany(mappedBy = "persona")
	private List<Experiencia> experiencias;

	@OneToMany(mappedBy = "persona")
	private List<Estudio> estudios;
	
	@OneToMany(mappedBy = "persona")
	private List<Habilidad> habilidades;

	@OneToMany(mappedBy = "persona")
	private List<Proyecto> proyectos;

}
