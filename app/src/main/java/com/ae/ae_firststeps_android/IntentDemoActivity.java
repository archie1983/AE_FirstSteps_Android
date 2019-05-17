package com.ae.ae_firststeps_android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class IntentDemoActivity extends AppCompatActivity {

    Button btnStartBrowser,
            btnStartPhone,
            btnStartBrowsingWithLaunchAction,
            btnExceptionalCondition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_demo);
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

        btnStartBrowser = (Button)findViewById(R.id.btnStartBrowser);
        btnStartBrowser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://www.reddit.com"));
                startActivity(i);
            }
        });

        btnStartPhone = (Button)findViewById(R.id.btnStartPhone);
        btnStartPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("tel:23597"));
                startActivity(i);
            }
        });

        btnStartBrowsingWithLaunchAction = (Button)findViewById(R.id.btnStartBrowsingWithLaunchAction);
        btnStartBrowsingWithLaunchAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Refer to AndroifManifest.xml for what activity is filtering for this action of the intent.
                 */
                Intent i = new Intent("com.ae.ae_firststeps_android.LAUNCH",Uri.parse("http://www.reddit.com"));
                startActivity(i);
            }
        });

        btnExceptionalCondition = (Button)findViewById(R.id.btnExceptionalCondition);
        btnExceptionalCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * This will fail because neither the action has got an intent filter in the AndroidManifest,
                 * nor there is a data section for "https" scheme in the intent filter in AndroidManifest.
                 */
                Intent i = new Intent("this.doesnt.exist.LAUNCH", Uri.parse("https://www.reddit.com"));
                startActivity(i);
            }
        });
    }

}
