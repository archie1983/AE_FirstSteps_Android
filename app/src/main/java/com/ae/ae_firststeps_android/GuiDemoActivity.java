package com.ae.ae_firststeps_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class GuiDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_demo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Opens the CardViewActivity demo
     *
     * @param v
     */
    public void showCardView(View v) {
        Intent showCardViewActivity = new Intent(this, CardViewActivity.class);
        startActivity(showCardViewActivity);
    }

    /**
     * Opens the Master/Detail demo
     *
     * @param v
     */
    public void showMasterDetailDemo(View v) {
        Intent showMasterDetailDemo = new Intent(this, DishListActivity.class);
        startActivity(showMasterDetailDemo);
    }

    /**
     * Opens the Master/Detail demo
     *
     * @param v
     */
    public void showRecyclerViewDemo(View v) {
        Intent showRecyclerViewDemo = new Intent(this, RecyclerViewActivity.class);
        startActivity(showRecyclerViewDemo);
    }
}
