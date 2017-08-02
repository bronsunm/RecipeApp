package com.example.a21604133.recipeapp;

/*
ALL REFERENCES

https://stackoverflow.com/questions/13663768/android-development-make-button-open-new-screen

 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RecActivity extends Activity {
	ImageView imView;
	TextView tv_nameName, tv_Ingredients, tv_Decsription, id;
	int dataInt;
	Button b, cd;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipe);

		Intent anotherIntent = getIntent();
		dataInt = anotherIntent.getIntExtra("dataIM", 0);
		String dataInt_Name = anotherIntent.getStringExtra("datatitle");
		String dataInt_Ingredient = anotherIntent.getStringExtra("dataingredient");
		String dataInt_Description = anotherIntent.getStringExtra("datadescription");

		imView = (ImageView) findViewById(R.id.iv_detail);
        tv_nameName = (TextView) findViewById(R.id.tvtitle);
		tv_Ingredients = (TextView) findViewById(R.id.tvIngredients);
		tv_Decsription = (TextView) findViewById(R.id.tvDecsription);

		imView.setImageResource(dataInt);
		tv_nameName.setText(dataInt_Name);
		tv_Ingredients.setText(dataInt_Ingredient);
		tv_Decsription.setText(dataInt_Description);

		b = (Button)findViewById(R.id.buttonSearch1);
        cd = (Button)findViewById(R.id.camerabutton);

        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(RecActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        cd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent j = new Intent(RecActivity.this, CameraActivity.class);
                startActivity(j);
            }
        });

	}



}