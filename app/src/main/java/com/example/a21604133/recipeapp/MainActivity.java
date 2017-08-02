package com.example.a21604133.recipeapp;
/*
ALL REFERENCES

 */
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    protected ListView lvRecipes;
    protected ListAdapter adapter;
    SQLiteDatabase db;
    Cursor cursor;
    EditText et_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = (new DatabaseFile(this)).getWritableDatabase();
        lvRecipes = (ListView) findViewById(R.id.lvRecipes);
        et_db = (EditText) findViewById(R.id.enterIng);

        try {
            cursor = db.rawQuery("SELECT * FROM recipe3 ORDER BY title" + " ASC", null);
            adapter = new SimpleCursorAdapter(this, R.layout.activity_listview, cursor, new String[]{"title", "ingredient", "img"}, new int[]{
                    R.id.tv_nameListView, R.id.tvIngredients, R.id.imView});
            lvRecipes.setAdapter(adapter);
            lvRecipes.setTextFilterEnabled(true);

            lvRecipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {
                    detail(position);

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @SuppressWarnings("deprecation")

    public void search_db(View v) {
        String edit_db = et_db.getText().toString();
        cursor = db.rawQuery("SELECT * FROM recipe3 WHERE ingredient LIKE ?", new String[]{"%" + edit_db + "%"});
        adapter = new SimpleCursorAdapter(this, R.layout.activity_listview, cursor, new String[]{"title", "ingredient", "img"},
                new int[]{R.id.tv_nameListView, R.id.tvIngredients, R.id.imView});
        lvRecipes.setAdapter(adapter);
    }
    public void detail(int position) {

        int im = 0;
        String _id = "";
        String title = "";
        String ingredient= "";
        String description = "";

        if (cursor.moveToFirst()) {
            cursor.moveToPosition(position);
            im = cursor.getInt(cursor.getColumnIndex("img"));
            title = cursor.getString(cursor.getColumnIndex("title"));
            ingredient = cursor.getString(cursor.getColumnIndex("ingredient"));
            description = cursor.getString(cursor.getColumnIndex("description"));
        }

        Intent newintent = new Intent(this, RecActivity.class);
        newintent.putExtra("dataIM", im);
        newintent.putExtra("datatitle", title);
        newintent.putExtra("dataingredient", ingredient);
        newintent.putExtra("datadescription", description);
        setResult(RESULT_OK, newintent);
        startActivityForResult(newintent, 99);
    }


}