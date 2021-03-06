

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.anyOf;

public class Tests {

	RouletteWheel sut;
	List<RouletteNumber> testRouletteWheel = new ArrayList<RouletteNumber>();
@Before
public void init(){
	 sut = new RouletteWheel();
	 testRouletteWheel = sut.makeRouletteWheel();

}

@Test 
public void test_size_of_RouletteWheel(){
	//ArrayList<RouletteNumber> testRouletteWheel = sut.makeRouletteWheel();

	assertThat(testRouletteWheel.size(), is(38));
}

@Test
@SuppressWarnings("unused")
public void test_that_evens_are_black(){

	RouletteColors blacktestColor = RouletteColors.Black;
	assertThat(testRouletteWheel.get(2).getColor(), is(RouletteColors.Black));
}
@Test
@SuppressWarnings("unused")
public void test_that_odds_are_red(){
	RouletteColors redtestColor = RouletteColors.Red;
	assertThat(testRouletteWheel.get(1).getColor(), is(RouletteColors.Red));
}
@Test
@SuppressWarnings("unused")
public void test_that_0_and_38__are_green(){
	RouletteColors greentestColor = RouletteColors.Green;
	assertThat(testRouletteWheel.get(0).getColor(), is(RouletteColors.Green));
	assertThat(testRouletteWheel.get(testRouletteWheel.size()-1).getColor(), is(RouletteColors.Green));
}

@Test
public void test_that_RouletteWheel_is_returning_proper_RouletteNumber_object(){
	RouletteNumber testRouletteNumberobject = new RouletteNumber(5,RouletteColors.Red);
	
	Integer testRouletteNum = testRouletteNumberobject.getRouletteNumber();
	RouletteColors testRouletteColor = testRouletteNumberobject.getColor();
	
	Integer testWheelNum = testRouletteWheel.get(5).getRouletteNumber();
	RouletteColors testWheelColor = testRouletteWheel.get(5).getColor();
	
	assertThat(testRouletteNumberobject.getRouletteNumber().equals(testRouletteWheel.get(5).getRouletteNumber()),is(true));
	assertThat(testRouletteNumberobject.getColor().equals(testRouletteWheel.get(5).getColor()),is(true));

	//maybe asserition should be based on any spin as long as integer or color
	assertThat(testWheelNum.equals(testRouletteNum),is(true));
	assertThat(testWheelColor.equals(testRouletteColor),is(true));

}
@Test
public void test_that_entire_wheel_is_populated_correctly(){
	Integer index = 0;
//	for(int index=0;index<testRouletteWheel.size();index++ ){
//		
//	}
	for(RouletteNumber rouletteIndex:testRouletteWheel){
		if(index == 0 || index == 37){
			assertThat(rouletteIndex.getColor(),is(RouletteColors.Green));
		}
		else {
				if ((index % 2) == 0){
					assertThat(rouletteIndex.getColor(), is(RouletteColors.Black));
				}
				if((index %2) == 1){
					assertThat(rouletteIndex.getColor(),is(RouletteColors.Red));
				}
			}
		index++;
	}
}

@Test
public void test_that_spinning_wheel_returns_RouletteNumber_object_(){
	//spin wheel will have to take the wheel as a parameter
	RouletteNumber testSpinResult = sut.spinWheel(testRouletteWheel);
	int maxValue = testRouletteWheel.size()-1;
	int minValue = 0;
	
	assertThat(testSpinResult.getColor(), anyOf(is(RouletteColors.Black), is(RouletteColors.Green), is(RouletteColors.Red)));
	assertTrue(testSpinResult.getRouletteNumber() < maxValue && testSpinResult.getRouletteNumber() > minValue);
}


@Test
public void test_that_game_runs(){
	int trialSpins = 50;
	RouletteColors trialColor = RouletteColors.Green;


	boolean result = sut.playGame(trialSpins, trialColor, testRouletteWheel);
	
	assertThat(result, is (true));
	
	}

@Test
public void get_total_amount_needed_after_10000_spins(){
	
}

}
