package net.javavideotutorials.assignment3.component;

import net.javavideotutorials.assignment3.AssemblyLine;

public class Engine implements Component, Runnable 
{

private  boolean isbuilt=false;
AssemblyLine assemblyLine = AssemblyLine.getInstance();
public Engine ()
{
  assemblyLine.addComponentToBeBuilt(this);
}
  @Override
  public void run() {
    // TODO Auto-generated method stub

	  System.out.println(getComponentType() + " " + "is being built");  
		try { 
		Thread.sleep(7000L);
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
  public void build() {
	  Thread t = new Thread(this);
	 // Thread t1 = new Thread("Thread 2 running");
	  t.start();



    // TODO Auto-generated method stub
	

  }

  @Override
  public boolean isBuilt() {
	
	return isbuilt;
  }

  @Override
  public String getComponentType() {
    // TODO Auto-generated method stub
	 
    return "Engine";
  }
  
}
