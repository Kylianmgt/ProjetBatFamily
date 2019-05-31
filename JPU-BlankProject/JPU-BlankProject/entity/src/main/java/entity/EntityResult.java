package entity;

public class EntityResult extends Entity {
	private String diminutif;
	
	public EntityResult(String diminutif){
		
		this.setDiminutif(diminutif);
	}

	public String getDiminutif() {
		return diminutif;
	}

	public void setDiminutif(String diminutif) {
		this.diminutif = diminutif;
	}

}
