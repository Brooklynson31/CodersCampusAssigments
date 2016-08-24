package net.javavideotutorials.assignment2.Human;

import java.util.Date;

import net.javavideotutorials.assignment2.Structure.Organization;



public abstract class Person 
{
	Employee employees;
	 Boolean value= new Boolean(false);
  public abstract String getName();
  public abstract String getSex();
  public abstract Date getBirthday();
  public abstract String getJobTitle();
  public abstract Organization getOrganization();
  
  public abstract void setName(String name);
  public abstract void setSex(String sex);
  public abstract void setBirthday(Date birthdate);
  public abstract void setJobTitle(String jobtitle);
  public abstract void setOrganization(Organization organization);


  @Override
  public String toString() {
	  return "Name: " +getName() + ", Sex: " + getSex() + "\n" + "Job Title: " + getJobTitle() + ", Organization: " +getOrganization();
  }
} 
  
 /* Attempt at overriding the equals class without generating the IDE supplied 
  * @Override
  public boolean equals(Object obj)
 
  {
	
	  if(obj instanceof Employee)
	  {
		  Employee person = (Employee) obj;
		  if (person.employees == this.employees)
		  {
			  value = true;
		  }
		  else if (person.employees != this.employees){
			 
			  value = false;
		  }
		
	  }
	  return value;

	  }
}*/
