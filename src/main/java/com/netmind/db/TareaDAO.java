package com.netmind.db;

import java.util.List;

import com.netmind.models.TareaB;

public abstract class TareaDAO extends DAO {
	public abstract List<TareaB> getTarea(int cid);
}
