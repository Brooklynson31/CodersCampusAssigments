package net.javavideotutorials.assignment2.Human;


import java.util.Date;

import net.javavideotutorials.assignment2.Structure.Organization;



public  class Employee extends Person 
{
	 public 	String name;
	   public String sex;
	   public String jobtitle;
	   public Organization organization;
	   public Date birthdate;
	
	  public Employee() 
	{
		this("","",null);
	}
	public Employee(String name)
	{
		this(name,"",null);
	}
	public Employee(String name, String sex)
	{
		this(name,sex,null);
	}
	public Employee(String name, String sex, Date birthdate)
	{
		this.name = name;
		this.sex = sex;
		this.birthdate = birthdate;
	}

	public  void setName(String name) {
		this.name=name;
		
	}
	public String getName() {
		
		return name;
	}
	public  void setSex(String sex) {
		
		this.sex=sex;
	}
	public String getSex() {
		
		return sex;
	}
	public void setJobTitle(String jobtitle)
	{
		this.jobtitle=jobtitle;
	}
	public String getJobTitle()
	{
		return jobtitle;
	}

	@Override
	public void setBirthday(Date birthdate) {
		// TODO Auto-generated method stub
		this.birthdate=birthdate;
	}
	@Override
	public Date getBirthday() {
		// TODO Auto-generated method stub
		return birthdate;
	}
	public void setOrganization(Organization organization) {
		this.organization=organization;
	
		// TODO Auto-generated method stub
		
	}
	public Organization getOrganization()
	{
	
		return organization;

	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
		Employee other = (Employee) obj;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}
	
	

	
}

