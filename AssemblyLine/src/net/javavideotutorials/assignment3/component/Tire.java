package net.javavideotutorials.assignment3.component;

import net.javavideotutorials.assignment3.AssemblyLine;

public class Tire implements Component, Runnable 
{
AssemblyLine assemblyLine = AssemblyLine.getInstance();
			public Tire ()
			{
			  assemblyLine.addComponentToBeBuilt(this);
			}
public boolean isbuilt = false;

  @Override
  public void run() {
	
	    System.out.println(getComponentType() + " " + "is being Built");
	    try {
			 
			Thread.sleep(2000);
		  }
		  catch (InterruptedException e) {
			  e.printStackTrace();
		  System.out.println(getComponentType() + " " + "Has been interrupted"); 
		  }
	    isbuilt=true;
	    assemblyLine.notifyComponentDoneAssembly(this);
    // TODO Auto-generated method stub
    
  }

  @Override
  public void build() {
	  //for(int i=0;i<4;i++) {	
		  Thread t = new Thread(this);
		  t.start();
	
	//}
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
    return "Tire";
  }
  

}
