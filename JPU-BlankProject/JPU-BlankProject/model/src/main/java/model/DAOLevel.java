package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Entity;
import entity.EntityPosition;
import entity.EntityResult;
import model.DBConnection;




public class DAOLevel extends DAOEntity<EntityPosition>{




	
	
	public DAOLevel(final Connection connection) throws SQLException {
		super(connection);
		
		}
	
	
	@Override
	public ArrayList<EntityPosition> find( final int id_level){
		
		ArrayList<EntityPosition> Tab = new ArrayList<EntityPosition>();
		
		try {
			final String sql = "{call getMap(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id_level);
			call.execute();			
			final ResultSet resultSet = call.getResultSet();			
				while(resultSet.next()){				
					Tab.add(new EntityPosition(resultSet.getString("D"), resultSet.getInt("X"), resultSet.getInt("Y")));			
					}				
				return Tab;
			
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	
	
	
	@Override
	public boolean create(EntityPosition entity) {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public boolean delete(EntityPosition entity) {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public boolean update(EntityPosition entity) {
		// TODO Auto-generated method stub
		return false;
	}





	@Override
	public EntityPosition find(String code) {
		// TODO Auto-generated method stub
		return null;
	}
  
}









	