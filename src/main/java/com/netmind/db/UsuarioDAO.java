package com.netmind.db;

import com.netmind.models.UsuarioB;

public abstract class UsuarioDAO extends DAO {
	public abstract UsuarioB getUsuario(String email, String password);
	public abstract UsuarioB getUsuario(int uid);
}
