package com.github.cmput301w13t04.food.test.robotium;

import android.test.ActivityInstrumentationTestCase2;

import com.github.cmput301w13t04.food.R;
import com.github.cmput301w13t04.food.view.ActivityMain;
import com.jayway.android.robotium.solo.Solo;

public class SearchTestUser extends ActivityInstrumentationTestCase2<ActivityMain> {
	private Solo solo;
	
	public SearchTestUser() {
		super(ActivityMain.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	
	public void testSearchByUserResults() throws InterruptedException {
		solo = new Solo(getInstrumentation(), getActivity());
		
		solo.clickOnView(solo.getView(R.id.viewRecipe));
		//wait for action bar to materialize
		solo.sleep(10000);
		solo.clickOnView(solo.getView(R.id.searchRecipe));
		solo.clickOnView(solo.getView(R.id.button_search_by_user));
		
		solo.enterText(0, "abc");
		solo.clickOnView(solo.getView(android.R.id.button1));
		
		assertTrue(solo.waitForText("Test1"));
	}
	
}
