package model;

import java.sql.SQLException;

public class maintest {

	public static void main(String[] args) throws SQLException {
		DAOLevel dao =new DAOLevel();
	
		dao.getEntity(1);
		

	}

}
