package net.javavideotutorials.assignment2.Structure;

public class Google implements Organization
{
	private Integer numEmployees;
	private String nameOfOrganization;
	
	
	
	
	public Google() 
	{
		this(0,"");
		
	}
	public Google(Integer numEmployees)
	{
		this(numEmployees,"");
	}
	public Google(String nameOfOrganization) {
		this(0,nameOfOrganization);
		// TODO Auto-generated constructor stub
	}

	public Google(Integer numEmployees, String nameOfOrganization)
	{
		this.numEmployees = numEmployees;
		this.nameOfOrganization = nameOfOrganization;
			}
	
	
	public Integer getNumberOfEmployees() {
		// TODO Auto-generated method stub
		return numEmployees;
	}

	public void setNumberOfEmployees(Integer numEmployees) {
		// TODO Auto-generated method stub
		this.numEmployees=numEmployees;
		
	}

	public void setnameOfOrganization(String nameOfOrganization) {
		// TODO Auto-generated method stub
		this.nameOfOrganization =nameOfOrganization;
	}
	public String getnameOfOrganization() {
		// TODO Auto-generated method stub
		return nameOfOrganization;
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
		Google other = (Google) obj;
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
