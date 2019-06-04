package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Entity;
import entity.EntityPosition;

abstract class DAOEntity<E extends Entity> {

	private final Connection connection;

	public DAOEntity(final Connection connection) throws SQLException {
		this.connection = connection;
	}
	
	protected Connection getConnection() {
		return this.connection;
	}
	public abstract boolean create(E entity);
	public abstract boolean delete(E entity);
	public abstract boolean update(E entity);
	public abstract ArrayList<EntityPosition> find(int id);
	public abstract E find(String code);

}
