package com.apback.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.apback.security.entity.Rol;
import com.apback.security.enums.RolNombre;
import com.apback.security.service.RolService;

@Component
public class CreateRoles implements CommandLineRunner{

	@Autowired
	RolService rolService;
	
	@Override
	public void run(String... args) throws Exception {
		
		Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
		Rol rolUser = new Rol(RolNombre.ROLE_USER);
		rolService.save(rolUser);
		rolService.save(rolAdmin);
	}

}
