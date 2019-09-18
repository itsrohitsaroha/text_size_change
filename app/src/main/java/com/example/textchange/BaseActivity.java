package com.example.textchange;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class BaseActivity extends Activity {
    @Override
    public void onStart() {
        super.onStart();

        // Enclose everything in a try block so we can just
        // use the default view if anything goes wrong.
        try {
            // Get the font size value from SharedPreferences.
            SharedPreferences settings =
                    getSharedPreferences("rohit_pref", Context.MODE_PRIVATE);

            // Get the font size option.  We use "FONT_SIZE" as the key.
            // Make sure to use this key when you set the value in SharedPreferences.
            // We specify "Medium" as the default value, if it does not exist.
            String fontSizePref = settings.getString("FONT_SIZE", "Large");

            // Select the proper theme ID.
            // These will correspond to your theme names as defined in themes.xml.
            int themeID = R.style.FontSizeMedium;
            if (fontSizePref == "Small") {
                themeID = R.style.FontSizeSmall;
                Toast.makeText(getApplicationContext(),"Large",Toast.LENGTH_SHORT);
            } else if (fontSizePref == "Large") {
                themeID = R.style.FontSizeLarge;
                Toast.makeText(getApplicationContext(),"Large",Toast.LENGTH_SHORT);
            } else if (fontSizePref == "Large") {
                themeID = R.style.FontSizeLarge;
                Toast.makeText(getApplicationContext(),"Large",Toast.LENGTH_SHORT);
            }

            // Set the theme for the activity.
            setTheme(themeID);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}