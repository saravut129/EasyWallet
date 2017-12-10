package com.example.easywallet;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.easywallet.adapter.HomePageAdapter;
import com.example.easywallet.db.DBHelper;
import com.example.easywallet.model.ListItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mButton1;
    private Button mButton2;
    private ListView mListView;
    public static ArrayList<ListItem> aList = new ArrayList<>();
    private static ArrayList<ListItem> mList = aList;
    private HomePageAdapter mAdapter;

    private DBHelper mHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelper = new DBHelper(this);
        mDb = mHelper.getReadableDatabase(); //<<< ปิดตรงนี้ Run ได้ เปิดแล้ว Run ไม่ได้

        loadDataFromDb();

        mAdapter = new HomePageAdapter(
                this,
                R.layout.item,
                mList
        );
        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);
        mListView = (ListView) findViewById(R.id.listView2);

        mListView.setAdapter(mAdapter);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddListActivity.class);
                startActivity(intent);
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddList2Activity.class);
                startActivity(intent);
            }
        });

    }

    private void loadDataFromDb() {
        Cursor cursor = mDb.query(
                DBHelper.TABLE_NAME_ONE,
                null,
                null,
                null,
                null,
                null,
                null
        );

        aList.clear();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(DBHelper.COL_ID));
            String details = cursor.getString(cursor.getColumnIndex(DBHelper.COL_DETAILS));
            int amount = cursor.getInt(cursor.getColumnIndex(DBHelper.COL_AMOUNT));
            String picture = cursor.getString(cursor.getColumnIndex(DBHelper.COL_PICTURE));

            ListItem item = new ListItem(id, details, amount, picture);
            aList.add(item);
        }

    }
}
