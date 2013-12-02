package com.github.cmput301w13t04.food.test.robotium;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.github.cmput301w13t04.food.R;
import com.github.cmput301w13t04.food.view.ActivityMain;
import com.jayway.android.robotium.solo.Solo;

import junit.framework.TestCase;

public class DeleteIngredientTest extends ActivityInstrumentationTestCase2<ActivityMain> {
	private Solo solo;
	
	public DeleteIngredientTest() {
		super(ActivityMain.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testDeleteIngredient() throws InterruptedException {
		solo.clickOnView(solo.getView(R.id.viewPantry));
		assertTrue(solo.waitForText("Ice cream"));
		solo.clickInList(0);
		solo.clickOnView(solo.getView(R.id.delete));
		//Sleep so the app has time to save before we check
		solo.sleep(10000);
		assertFalse(solo.waitForText("Ice cream"));
	}

	
}
