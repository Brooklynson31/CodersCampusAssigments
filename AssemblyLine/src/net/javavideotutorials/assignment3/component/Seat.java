package net.javavideotutorials.assignment3.component;

import net.javavideotutorials.assignment3.AssemblyLine;

public class Seat implements Component, Runnable 
{
	AssemblyLine assemblyLine = AssemblyLine.getInstance();
	private  boolean isbuilt=false;
	
	public Seat ()
	{
	  assemblyLine.addComponentToBeBuilt(this); //allows assembly line class to add to assembly line	  
	}
	
  @Override
  public void run() {

	    System.out.println(getComponentType() + " " + "is being Built");
	    try {
	    	for (int i=0;i<5;i++) { //four threads for a single tire
			Thread.sleep(600);
	    	}
	    } catch (InterruptedException e) {
			  e.printStackTrace();
		  System.out.println(getComponentType() + " " + "Has been interrupted"); 
		  }
		isbuilt=true; //stop condition for building componenet
		assemblyLine.notifyComponentDoneAssembly(this); //notifies assebly line component is done building and can be removed
		// TODO Auto-generated method stub
  }

  @Override
  public void build() { //begins building process in run once called
	Thread t= new Thread(this); 
	t.start();
	    // TODO Auto-generated method stub
    }

  @Override
  public boolean isBuilt() {
		return isbuilt;
		 // TODO Auto-generated method stub
  
  }

  @Override
  public String getComponentType() {
    // TODO Auto-generated method stub
    return "Seat";
  }
  

}
