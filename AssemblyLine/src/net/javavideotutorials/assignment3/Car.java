package net.javavideotutorials.assignment3;

import java.util.ArrayList;
import java.util.List;
/*import components without having to implement Component interface and all its methods*/
import net.javavideotutorials.assignment3.component.Component;
import net.javavideotutorials.assignment3.component.Engine;
import net.javavideotutorials.assignment3.component.Frame;
import net.javavideotutorials.assignment3.component.Seat;
import net.javavideotutorials.assignment3.component.Tire;

public class Car  
{
	//create each component and how many is needed
	private Component engine;
	  private Component frame;
	  private List<Seat> seats = new ArrayList<Seat>(4);
	  private List<Tire> tires = new ArrayList<Tire>(4);
	
	  
  public Car ()
  {
    build();
  }
  
  /**
   * This is where you should piece together and build each component for the
   * car.
   */
  public void build()
  {
	  engine = new Engine();
	  frame = new Frame();
	 
	  seats.add(new Seat());
	    seats.add(new Seat());
	    seats.add(new Seat());
	    seats.add(new Seat());
	    seats.add(new Seat()); //5 seats need to be build
	    tires.add(new Tire());
	    tires.add(new Tire());
	    tires.add(new Tire());
	    tires.add(new Tire()); // 4 tires need to be built
	 
	 
	 
  }
  
  public Boolean isBuilt()
  {
	    boolean doneBuilding = true;
	    //add the completion of each component to the condition of doneBuilding being true
	    doneBuilding &= engine.isBuilt();
	    doneBuilding &= frame.isBuilt();
	    for (Seat seat : seats)
	    {
	      doneBuilding &= seat.isBuilt();
	    }
	    for (Tire tire : tires)
	    {
	      doneBuilding &= tire.isBuilt();
	    }
	        
	    return doneBuilding;
	  }
  }

