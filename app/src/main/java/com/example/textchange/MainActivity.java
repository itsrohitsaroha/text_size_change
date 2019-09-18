package com.example.textchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    SharedPreferences pref;
    SharedPreferences.Editor editor;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTheme(getSavedTheme());
        TextView tv =(TextView)findViewById(R.id.tvId);
        tv.setText("Rohit Saroha");
        Button b1=(Button)findViewById(R.id.b1);
        Button b2=(Button)findViewById(R.id.b2);
        Button b3=(Button)findViewById(R.id.button2);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTheme(R.style.FontSizeLarge);
            }
        });


        pref = getSharedPreferences("rohit_pref", Context.MODE_PRIVATE); // 0 - for private mode
        editor = pref.edit();


          b1.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View view) {
                  editor.putString("FONT_SIZE", "Small");

                  editor.commit();
                  recreate();
              }
          });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editor.putString("FONT_SIZE", "Large");
                editor.commit();
                recreate();
            }
        });

        Log.i("pref","");




    }

    private int getSavedTheme() {
        Log.i("pref","call-----------------");

        SharedPreferences settings =
                getSharedPreferences("rohit_pref", Context.MODE_PRIVATE);

        // Get the font size option.  We use "FONT_SIZE" as the key.
        // Make sure to use this key when you set the value in SharedPreferences.
        // We specify "Medium" as the default value, if it does not exist.
        String fontSizePref = settings.getString("FONT_SIZE", "Large");
        Log.i("pref","call-------------------");
        // Select the proper theme ID.
        // These will correspond to your theme names as defined in themes.xml.
        int themeID = R.style.FontSizeMedium;
        if (fontSizePref == "Small") {
            themeID = R.style.FontSizeSmall;
            Toast.makeText(getApplicationContext(),"Large",Toast.LENGTH_SHORT);
        } else if (fontSizePref == "Large") {
            themeID = R.style.FontSizeLarge;
            Toast.makeText(getApplicationContext(),"Large",Toast.LENGTH_SHORT);
            Log.i("pref","large-------------------");
        } else if (fontSizePref == "Large") {
            themeID = R.style.FontSizeLarge;
            Toast.makeText(getApplicationContext(),"Large",Toast.LENGTH_SHORT);
        }
        return themeID;
    }



}
