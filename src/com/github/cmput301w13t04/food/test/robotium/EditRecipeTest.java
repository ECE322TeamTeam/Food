package com.github.cmput301w13t04.food.test.robotium;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.github.cmput301w13t04.food.R;
import com.github.cmput301w13t04.food.view.ActivityMain;
import com.github.cmput301w13t04.food.view.ActivityViewRecipe;
import com.github.cmput301w13t04.food.view.ActivityViewRecipeList;
import com.jayway.android.robotium.solo.Solo;

public class EditRecipeTest extends ActivityInstrumentationTestCase2<ActivityMain> {
	private Solo solo;

	public EditRecipeTest() {
		super(ActivityMain.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testEditRecipe() throws InterruptedException {
		solo.clickOnView(solo.getView(R.id.viewRecipe));
		solo.clickInList(0);
		solo.clickOnView(solo.getView(R.id.edit_recipe));
		
		solo.clickOnText("DESCRIPTION");
		enterText(R.id.recipe_name, "Recipe 5");
		enterText(R.id.recipe_description, "A very tasty recipe");
		enterText(R.id.recipe_time, "15");
		
		solo.clickOnView(solo.getView(R.id.save_recipe));
		
		assertTrue(solo.searchText("Recipe 5"));

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
