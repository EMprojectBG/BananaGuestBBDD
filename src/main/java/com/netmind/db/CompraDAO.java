package com.netmind.db;

import com.netmind.models.Compra;

public abstract class CompraDAO extends DAO {
	public abstract Compra getCompra(int cid);
	public abstract boolean delCompra(int cid);
	public abstract boolean insertCompra(Compra compra);
	public abstract boolean updateCompra(Compra compra);
}
