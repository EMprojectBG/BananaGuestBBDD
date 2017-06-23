package com.netmind.db;

import com.netmind.models.UsuarioB;

public abstract class UsuarioDAO extends DAO {
	public abstract UsuarioB getUsuario(String email, String password);
	public abstract UsuarioB getUsuario(int uid);
	public abstract boolean delUsuario(int uid);
	public abstract boolean insertUsuario(UsuarioB user);
	public abstract boolean updateUsuario(UsuarioB user);
}
