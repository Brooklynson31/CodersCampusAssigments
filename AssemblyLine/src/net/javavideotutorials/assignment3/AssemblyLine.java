package net.javavideotutorials.assignment3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import net.javavideotutorials.assignment3.component.Component;

public class AssemblyLine implements Runnable
{
	private final int MAX_CAPACITY_OF_ASSEMBLY_LINE = 3;
  private Queue<Component> neededPartsQueue = new LinkedList<Component>();
  protected List<Component> componentsBeingBuilt = new ArrayList<Component>();
  private List<Car> carsBuilt = new ArrayList<Car>();
  public boolean assemblyLineWorking = false;
  private static  AssemblyLine INSTANCE;
  
  private AssemblyLine() //private constructor so no one else can instantiate the class
  {
	
  }
  /**
   * This method should return the single instance of the AssemblyLine object.
   * @return the Singleton instance of the <code>AssemblyLine</code> object
   */
  public static AssemblyLine getInstance() //instantiate lazily
  {
	  if(INSTANCE == null){ //if INSTANCE is null, create new Instance, else return the value of the Instance
		   INSTANCE = new AssemblyLine();
		  
	  }
    return INSTANCE;
  }
  
  /**
   * This method should be used to start the process of building a car.  Remember that
   * each new Car should be built on a new Thread.
   */
  public void buildCar()
  {
	  
	  
	  //start run method in the assembly method when new Car thread is started
	  Thread buildCarthread = new Thread(AssemblyLine.getInstance());
	  buildCarthread.start();
	  assemblyLineWorking = true;
  }
  
  /**
   * This method is used to start building a Component.  If the assembly line has room
   * to build a <code>Component</code>, then construction can start immediately, if the assembly line
   * is already at maximum capacity (3 <code>Components</code>), then this <code>Component</code> should be placed
   * on the <code>neededPartsQueue</code>. 
   * @param component to be built
   */
  public synchronized void addComponentToBeBuilt(Component component)
  {
    assemblyLineWorking = true;
    if (component == null)
    {
      System.out.println("YOU'RE INSERTING A NULL COMPONENT INTO THE QUEUE!");
    }
    if (componentsBeingBuilt.size() < MAX_CAPACITY_OF_ASSEMBLY_LINE) // if assembly line has less than 3 components
    {  componentsBeingBuilt.add(component); //add componenet to assembly line
      component.build();
    }
    else
    {
      neededPartsQueue.add(component); //wait until there are less than 3 componenets on assembly line
    }
  }


  /**
   * This method should remove the completed component from the ArrayList
   * of components being built.  It should also pull the next component to 
   * be built from the Queue of parts that are waiting to be built.  If there
   * are no more Components to build, then the assembly line should be marked
   * as no longer working.
   * @param component to remove from assembly line
   */

  public synchronized void notifyComponentDoneAssembly(Component component) //Synchronize locks thread access so other must wait until process is done
  {
    System.out.println("Removing " + component.getComponentType()); 
    componentsBeingBuilt.remove(component);
    System.out.println(componentsBeingBuilt.size() + " Components currently being built.");
    Component nextComponent = neededPartsQueue.poll(); //removes part at front of queue from needed part places it as next component on assebmly line
    if (nextComponent != null) //as long as parts are still needed 
      addComponentToBeBuilt(nextComponent);
   else
    {
      System.out.println("Next component in queue is null, queue size is: " + neededPartsQueue.size());
    } 
    if (componentsBeingBuilt.size() == 0 && neededPartsQueue.size() == 0) //if no parts being built or parts needed queue
    {
      System.out.println("Assembly line has stopped.");
      assemblyLineWorking = false; //stop assembly line since all building is complete
    }
    
  }


  /**
   * This method should return a list of all successfully built cars
   * @return list of all cars built
   */
  public List<Car> getCarsBuilt() 
  {
    return carsBuilt;
  }

  public void setCarsBuilt(List<Car> carsBuilt) 
  {
    this.carsBuilt = carsBuilt;
  }

  @Override
  public void run() {
    // TODO Auto-generated method stub
	    System.out.println("Starting to build car.");
	    Car car = new Car();
	    car.build();
	    while (!car.isBuilt())
	    {
	      
	    }
	    carsBuilt.add(car);
	    System.out.println("Done building car " + carsBuilt.size() + ".");
	    
	  }
  }
  

