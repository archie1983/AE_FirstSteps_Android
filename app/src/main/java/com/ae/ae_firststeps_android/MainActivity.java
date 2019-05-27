package com.ae.ae_firststeps_android;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String msg = "AE: ";

    private AEReceiver myRunTimeReceiver = new AEReceiver() {
      @Override
      public void onReceive(Context context, Intent intent) {
          // TODO: This method is called when the BroadcastReceiver is receiving
          // an Intent broadcast.
          //throw new UnsupportedOperationException("Not yet implemented");
          Toast.makeText(context, "com.ae.CUSTOM_INTENT received.", Toast.LENGTH_LONG).show();
      }
    };

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        Log.d(msg, "The onCreate() Event");
    }

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.ae.CUSTOM_INTENT");
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        this.registerReceiver(myRunTimeReceiver,filter);
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
        this.unregisterReceiver(myRunTimeReceiver);
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeTextColour(View v) {
        EditText txtEditText = (EditText) findViewById(R.id.txtEditText);
        txtEditText.setTextColor(getResources().getColor(R.color.opaque_blue));
    }

    public void startService(View v) {
        startService(new Intent(getBaseContext(), AEService.class));
    }

    public void stopService(View v) {
        stopService(new Intent(getBaseContext(), AEService.class));
    }

    public void sendCustomIntent(View v) {
        Intent intent = new Intent();
        intent.setAction("com.ae.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    /**
     * Opens the DB demo activity
     *
     * @param v
     */
    public void showDBDemo(View v) {
        Intent showDBActivity = new Intent(this, DBActivity.class);
        startActivity(showDBActivity);
    }

    /**
     * Opens the Intent demo activity
     *
     * @param v
     */
    public void showIntentDemo(View v) {
        Intent showIntentDemotActivity = new Intent(this, IntentDemoActivity.class);
        startActivity(showIntentDemotActivity);
    }

    /**
     * Opens the Intent demo activity
     *
     * @param v
     */
    public void showCustomComponentDemo(View v) {
        Intent showCustomComponentActivity = new Intent(this, CustomComponentActivity.class);
        startActivity(showCustomComponentActivity);
    }
}
