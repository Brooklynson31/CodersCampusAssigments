package net.javavideotutorials.assignment2.Structure;

public class Microsoft implements Organization
{
	private Integer numEmployees;
	private String nameOfOrganization;
	
	
	
	
	public Microsoft() 
	{
		this(0,"");
	}
	public Microsoft(Integer numEmployees)
	{
		this(numEmployees,"");
		
	}
	public Microsoft(String nameOfOrganization) {
		this(0,nameOfOrganization);
		// TODO Auto-generated constructor stub
	}
	
	public Microsoft(Integer numEmployees, String nameOfOrganization)
	{
		this.numEmployees = numEmployees;
		this.nameOfOrganization = nameOfOrganization;
		
	}
	
	
	@Override
	public Integer getNumberOfEmployees() {
		// TODO Auto-generated method stub
		return numEmployees;
	}


	@Override
	public void setNumberOfEmployees(Integer numEmployees) {
		// TODO Auto-generated method stub
		numEmployees=this.numEmployees;
		
	}

	@Override
	public String getnameOfOrganization() {
		// TODO Auto-generated method stub
		return nameOfOrganization;
	}
	@Override
	public void setnameOfOrganization(String nameOfOrganization) {
		// TODO Auto-generated method stub
		this.nameOfOrganization =nameOfOrganization;
	}


	@Override
	  public  String toString() {
		  
		  return getnameOfOrganization();
	  }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameOfOrganization == null) ? 0 : nameOfOrganization.hashCode());
		result = prime * result + ((numEmployees == null) ? 0 : numEmployees.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Microsoft other = (Microsoft) obj;
		if (nameOfOrganization == null) {
			if (other.nameOfOrganization != null)
				return false;
		} else if (!nameOfOrganization.equals(other.nameOfOrganization))
			return false;
		if (numEmployees == null) {
			if (other.numEmployees != null)
				return false;
		} else if (!numEmployees.equals(other.numEmployees))
			return false;
		return true;
	}
	
  
}
