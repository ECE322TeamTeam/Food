/**
 * 
 */
package com.github.cmput301w13t04.food.test.robotium;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.github.cmput301w13t04.food.R;
import com.github.cmput301w13t04.food.view.ActivityMain;
import com.jayway.android.robotium.solo.Solo;

/**
 * @author User
 *
 */
public class SearchTestIngredient extends ActivityInstrumentationTestCase2<ActivityMain> {


	private Solo solo;
	
	public SearchTestIngredient() {
		super(ActivityMain.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testSearchByIngredientResults() throws InterruptedException {
		solo.clickOnView(solo.getView(R.id.viewRecipe));
		//wait for action bar to materialize
		solo.sleep(10000);
		solo.clickOnView(solo.getView(R.id.searchRecipe));
		solo.clickOnView(solo.getView(R.id.button_search_by_ingredient));
		solo.clickInList(0);
		solo.clickOnView(solo.getView(R.id.searchIngredient));
		
		assertTrue(solo.waitForText("Apple Pie"));
		assertTrue(solo.waitForText("Apple Struddle"));
	}
	

	
	
	
	
	
	
	
	
	
	
	
}
