package pilot.cs262.calvin.edu.knightrank;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class ActivitySelection extends AppCompatActivity {

    //Class variables.
    private static final String LOG_TAG =
            ActivitySelection.class.getSimpleName();

    // For use with shared preferences.
    private static final String PLACEHOLDER1 = "";

    // Share preferences file.
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "pilot.cs262.calvin.edu.knightrank";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        // my_child_toolbar is defined in the layout file
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        // Set shared preferences component.
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // Placeholder code as example of how to restore values to UI components from shared preferences.
        //username_main.setText(mPreferences.getString(USER_NAME, ""));
        //password_main.setText(mPreferences.getString(USER_PASSWORD, ""));
    }

    /**
     * Method for button click that launches the activity.
     *
     * @param view as stated
     */
    public void launchActivity(View view) {

        Intent intent = new Intent(this, ActivityRankings.class);

        startActivity(intent);

        Log.d(LOG_TAG, "Button clicked!");
    }

    /**
     * Method currently called to store values to shared preferences file.
     */
    @Override
    public void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();

        preferencesEditor.putString(PLACEHOLDER1, "Placeholder text");

        preferencesEditor.apply();
    }
}
