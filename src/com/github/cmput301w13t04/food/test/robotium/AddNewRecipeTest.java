package com.github.cmput301w13t04.food.test.robotium;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.github.cmput301w13t04.food.R;
import com.github.cmput301w13t04.food.view.ActivityMain;
import com.github.cmput301w13t04.food.view.ActivityViewRecipe;
import com.github.cmput301w13t04.food.view.ActivityViewRecipeList;
import com.jayway.android.robotium.solo.Solo;

public class AddNewRecipeTest extends ActivityInstrumentationTestCase2<ActivityMain> {
	private Solo solo;

	public AddNewRecipeTest() {
		super(ActivityMain.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testAddRecipe() throws InterruptedException {
		solo.clickOnView(solo.getView(R.id.viewRecipe));
		solo.clickOnText("Add Recipe");
		solo.clickOnText("DESCRIPTION");
		
		enterText(R.id.recipe_name, "Recipe 1");
		enterText(R.id.recipe_description, "A tasty recipe");
		enterText(R.id.recipe_time, "15");
		
		solo.clickOnText("INGREDIENTS");
		solo.clickOnText("Add Ingredient");
		enterText(R.id.add_name, "Ingredient 1");
		enterText(R.id.add_quantity, "5");
		enterText(R.id.add_description, "A tasty ingredient");
		solo.clickOnText("Update Ingredient");
		
		solo.clickOnText("STEPS");
		solo.clickOnText("Add Step");
		enterText(R.id.step_name, "Step 1");
		enterText(R.id.step_description, "Do something");
		solo.clickOnText("Update Step");
		
		solo.clickOnView(solo.getView(R.id.save_recipe));
		
		assertTrue(solo.searchText("Recipe 1"));

	}
	
	public void enterText(int editView, String text) {
		EditText edit = (EditText) solo.getView(editView);
		solo.clearEditText(edit);
		solo.enterText(edit, text);
	}

	@Override
	protected void tearDown() throws Exception {
		// solo.finishOpenedActivities();
	}
}
