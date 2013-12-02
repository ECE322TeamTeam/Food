package com.github.cmput301w13t04.food.test.robotium;

import java.util.List;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.ListView;

import com.github.cmput301w13t04.food.R;
import com.github.cmput301w13t04.food.view.ActivityMain;
import com.github.cmput301w13t04.food.view.ActivityViewRecipe;
import com.jayway.android.robotium.solo.Solo;

public class ViewRecipeTest extends ActivityInstrumentationTestCase2<ActivityMain> {
	private Solo solo;
	
	public ViewRecipeTest() {
		super(ActivityMain.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testViewRecipe() throws InterruptedException {
		solo.clickOnView(solo.getView(R.id.viewRecipe));
		solo.clickOnText("Recipe 1");
		assertTrue(solo.searchText("A tasty recipe"));
		
		solo.clickOnText("INGREDIENTS"); 
		assertTrue(solo.searchText("Ingredient 1"));
		
		solo.clickOnText("STEPS");
		assertTrue(solo.searchText("Step 1"));
		
	}
	
	@Override
	protected void tearDown() throws Exception{
		//solo.finishOpenedActivities();
	}
}
