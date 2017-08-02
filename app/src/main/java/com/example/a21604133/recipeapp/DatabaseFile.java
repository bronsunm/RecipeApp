package com.example.a21604133.recipeapp;
/*
ALL REFERENCES
https://developer.android.com/training/search/search.html
https://developer.android.com/guide/topics/search/search-dialog.html#ReceivingTheQuery
http://androiddhina.blogspot.co.nz/2015/04/insert-value-in-database-using-sqlite.html
https://developer.android.com/reference/android/content/ContentValues.html
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.id;

/**
 * Created by 21604133 on 24/06/2017.
 */


public class DatabaseFile extends SQLiteOpenHelper {
    final static String DB_Name2 = "db_recipe";

    public DatabaseFile(Context context) {
        super(context, DB_Name2, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS recipe3(_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, ingredient TEXT, description TEXT, img BLOB)";
        db.execSQL(sql);

        ContentValues values = new ContentValues();

        values.put("_id", "1");
        values.put("title", "Schezwan Sauce");
        values.put("ingredient", "chilli flakes, dried red chillies, spring onion greens,chopped fine/celery/coriander stem, garlic cloves, 1 small tomato pureed,black pepper powder,sugar, Salt to taste");
        values.put("description","Heat sesame oil in a kadai till smoking point. Add the chilli flakes and saute well for 3-5 minutes. Next add the crushed ginger-garlic.Saute till the raw smell goes off.Next add the chopped/blended tomato and mix well.Add spring onion greens and mix well/ Add salt,sugar,vinegar and pepper powder.Saute well till the sauce thickens leaves the side of the kadai an starts to ooze out oil.Store schezwan sauce airtight in refrigerator. ");
        values.put("img", R.drawable.img01);
        db.insert("recipe3", "_id", values);

        values.put("_id", "2");
        values.put("title", " Slow-Cooked Country Chicken");
        values.put("ingredient", " Chicken Pieces, Butter, Olive Oil, Rashers Streaky Bacon, roughly chopped, Onion,Garlic, Mushrooms, Crushed Tomatoes");
        values.put("description"," Top the vegetables with the chicken pieces and add the tomatoes, stock and parsley.Cook on low for 8 hours, or high for 4 hours. Remove the chicken from the cooker and keep warm. Make a smooth paste from the cornflour and water and stir the paste into the chicken juices. Cover the cooker and cook for 15 minutes on high so that the juices thicken. Serve the chicken drizzled with the thickened juices.");
        values.put("img", R.drawable.img02);
        db.insert("recipe3", "_id", values);

        values.put("_id", "3");
        values.put("title", " Bread Cutlet");
        values.put("ingredient", "boiled potatoes, green chili, ginger piece, boiled peas, red chili powder, garam masala powder, dry mange powder, mustard seed, oil, curry leaves, slices of bread");
        values.put("description"," When the mixture gets slightly cold start making small round balls it and keep them aside. Now take water in the wide bowl and dip a single bread slice into it just enough, that the bread gets wet and then immediately take them out and with a hand press, drain out the excess water from the bread slice. While still holding the pressed bread slice, place a potato ball in the center of the slice and let it cover the ball evenly. Then with a light hand press the ball flat and smooth out the edges. Prepare the balls of the remianing bread slices and keep aside. Now heat oil for frying in a heavy bottomed pan, when the oil is smoky hot slow down the heat and fry two bread cutlet at a time. Then on medium flame fry them till golden in color from all sides.");
        values.put("img", R.drawable.img03);
        db.insert("recipe3", "_id", values);

        values.put("_id", "4");
        values.put("title", " Grilled Cheese Rolls");
        values.put("ingredient", "slices sandwich bread, slices American cheese, tablespoon butter");
        values.put("description"," Lay out pieces of sandwich bread on a flat surface. Use a rolling pin to flatten. Then, if desired, use a knife to cut the crusts off of each piece of flattened bread. Place a slice of cheese on top of each slice of bread, then roll up tightly. Meanwhile, heat 2 tablespoons butter in a skillet over medium heat until melted. Place the grilled cheese rolls (about 3 at a time) seam-side down in the skillet, and cook on all sides until the bread is toasted and the cheese is melted. You can press the rolls down with a spatula to be sure that they do not unfold while cooking.Remove and repeat with the remaining sandwiches, adding more melted butter if necessary. Heat soup according to package directions for dipping sauce and serve immediately.");
        values.put("img", R.drawable.img04);
        db.insert("recipe3", "_id", values);

        values.put("_id", "5");
        values.put("title", " Bacon Cheeseburger Pasta");
        values.put("ingredient", "macaroni, diced bacon, ground beef, onions, chili powder, salt");
        values.put("description"," Cook the macaroni according to the package instructions and drain it. Replace the pasta in the pot and mix in ½ stick of the butter. Cook the bacon in a large skillet until crispy then mix in the ground beef and onions and cook. Mix in the chili powder, salt and pepper and cook for 5 more minutes. Mix in the tomato sauce and chopped tomatoes until well combined then stir in the warm macaroni with the shredded cheese and parmesan cheese. Cook the mixture over low heat and enjoy!.");
        values.put("img", R.drawable.img05);
        db.insert("recipe3", "_id", values);

        values.put("_id", "6");
        values.put("title", "Crab Shack Crab Cakes");
        values.put("ingredient", "egg yolks, mayonnaise, lemon juice, black pepper, dijon mustard, blackening seasoning, crushed red pepper flakes, crab meat");
        values.put("description"," In a large bowl, mix all of the ingredients together until well combined then make into 4 oz patties. Place some flour in a large bowl and coat the patties then fry in hot oil until golden brown. Enjoy! Simple, easy and delicious! This crab meat patties are so delicious, I love having them hot or warm with some rice and a veggies salad! Try them and let me know what you think.");
        values.put("img", R.drawable.img06);
        db.insert("recipe3", "_id", values);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS recipe3");
        onCreate(db);

    }

}