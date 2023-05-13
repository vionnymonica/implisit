package com.example.implicit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Button website,location, share;
    EditText edit_website, edit_location, edit_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        website = findViewById(R.id.open_website_button);
        location = findViewById(R.id.location_button);
        share = findViewById(R.id.share_text_button);
        edit_website = findViewById(R.id.website_edit_text);
        edit_location = findViewById(R.id.location_edit_text);
        edit_share = findViewById(R.id.share_edit_text);


        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = edit_website.getText().toString();
                Uri webPage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
                if (intent.resolveActivity(getPackageManager()) !=null) {
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "can't handle this Intent!");
                }
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = edit_location.getText().toString();
                Uri addressUri = Uri.parse("geo:0,0?q="+location);
                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
                if(intent.resolveActivity(getPackageManager()) !=null){
                    startActivity(intent);
                }else{
                    Log.d("implicitIntents","can't handle this Intent!");
                }
            }
        });


    }
}