package com.github.cmput301w13t04.food.test.robotium;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.github.cmput301w13t04.food.R;
import com.github.cmput301w13t04.food.view.ActivityMain;
import com.github.cmput301w13t04.food.view.ActivityViewRecipe;
import com.github.cmput301w13t04.food.view.ActivityViewRecipeList;
import com.jayway.android.robotium.solo.Solo;

public class DeleteRecipeTest extends ActivityInstrumentationTestCase2<ActivityMain> {
	private Solo solo;

	public DeleteRecipeTest() {
		super(ActivityMain.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testDeleteRecipe() throws InterruptedException {
		solo.clickOnView(solo.getView(R.id.viewRecipe));
		solo.clickLongOnText("Recipe 1");
		solo.clickOnView(solo.getView(android.R.id.button1));
		
		assertFalse(solo.searchText("Recipe 1"));
	}

	@Override
	protected void tearDown() throws Exception {
		// solo.finishOpenedActivities();
	}
}
