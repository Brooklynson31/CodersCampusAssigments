package net.javavideotutorials.assignment3.component;

import net.javavideotutorials.assignment3.AssemblyLine;

public class Frame implements Component, Runnable 
{

	private  boolean isbuilt=false;
	AssemblyLine assemblyLine = AssemblyLine.getInstance();
	
	public Frame ()
	{
	  assemblyLine.addComponentToBeBuilt(this);
	}
	
	@Override
	  public void build() 
	{
		  Thread t = new Thread(this);
		  t.start();
	 // TODO Auto-generated method stub
	 }
 
	@Override
  public void run() {
    // TODO Auto-generated method stub

	  System.out.println(getComponentType() + " " + "is being built");  
		try { 
		Thread.sleep(5000L);
	  }
	  catch (InterruptedException e) {
		  e.printStackTrace();
	  System.out.println(getComponentType() + " " + "Has been interrupted"); 
	  } 

		isbuilt=true;
		 assemblyLine.notifyComponentDoneAssembly(this);
  	} 
	// TODO Auto-generated catch block

	@Override
  public boolean isBuilt() {
	
	return isbuilt;
  }
  
@Override
  public String getComponentType() {
    // TODO Auto-generated method stub
    return "Frame";
  }

}
