package com.github.cmput301w13t04.food.test.robotium;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.github.cmput301w13t04.food.R;
import com.github.cmput301w13t04.food.view.ActivityMain;
import com.jayway.android.robotium.solo.Solo;

public class AddIngredientTest  extends ActivityInstrumentationTestCase2<ActivityMain> {

	private Solo solo;
	
	public AddIngredientTest() {
		super(ActivityMain.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testDisplayWhiteBox() throws InterruptedException {
		solo.clickOnView(solo.getView(R.id.viewPantry));
		solo.clickOnView(solo.getView(R.id.addIngredient));
		
		EditText name = (EditText) solo.getView(R.id.add_name);
		solo.clearEditText(name);
		solo.enterText(name, "Sugar6");
		
		EditText quantity = (EditText) solo.getView(R.id.add_quantity);
		solo.clearEditText(quantity);
		solo.enterText(quantity, "5");
		
		solo.clickOnView(solo.getView(R.id.update_ingredient));
		
		//Check the toast
		assertTrue(solo.waitForText("Added"));
		
		//Sleep so the app has time to save before it kills the app
		solo.sleep(5000);
	}
	
	@Override
	protected void tearDown() throws Exception{
		//solo.finishOpenedActivities();
	}
	
}
