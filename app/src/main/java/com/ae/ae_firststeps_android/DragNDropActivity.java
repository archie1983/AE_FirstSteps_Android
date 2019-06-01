package com.ae.ae_firststeps_android;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.content.ClipData;
import android.content.ClipDescription;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class DragNDropActivity extends AppCompatActivity {

    ImageView img;
    String msg = "AE: ";
    boolean blnDropped = false;
    //private android.widget.RelativeLayout.LayoutParams layoutParams;
    //private android.view.ViewGroup.LayoutParams layoutParams;
    private android.support.constraint.ConstraintLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_ndrop);
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

        img=(ImageView)findViewById(R.id.imgDragNDrop);

        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence)v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(),mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img);

                //v.startDrag(dragData,myShadow,null,0);
                v.startDragAndDrop(dragData,myShadow,null,0);
                blnDropped = false;
                return true;
            }
        });

        img.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch(event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_STARTED");
                        //layoutParams = (RelativeLayout.LayoutParams)v.getLayoutParams();
                        layoutParams = (android.support.constraint.ConstraintLayout.LayoutParams)v.getLayoutParams();

                        // Do nothing
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        int x_cord = (int) event.getX();
                        int y_cord = (int) event.getY();
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED. X=" + x_cord + " Y=" + y_cord);
                        break;

                    case DragEvent.ACTION_DRAG_EXITED :
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY();
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED. X=" + x_cord + " Y=" + y_cord);
                        //layoutParams.leftMargin = x_cord;
                        //layoutParams.topMargin = y_cord;
                        //layoutParams.
                        //v.setLayoutParams(layoutParams);
                        break;

                    case DragEvent.ACTION_DRAG_LOCATION  :
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY();

                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION. X=" + x_cord + " Y=" + y_cord);
                        break;

                    case DragEvent.ACTION_DRAG_ENDED   :
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY();
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED. X=" + x_cord + " Y=" + y_cord);;
                        if (!blnDropped) {
                            layoutParams.leftMargin = x_cord;
                            layoutParams.topMargin = y_cord;
                            v.setLayoutParams(layoutParams);
                            blnDropped = true;
                        }

                        // Do nothing
                        break;

                    case DragEvent.ACTION_DROP:
                        //x_cord = (int) event.getX() - (v.getWidth() / 2);
                        //y_cord = (int) event.getY() - (v.getHeight() / 2);
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY();
                        Log.d(msg, "ACTION_DROP event. X=" + x_cord + " Y=" + y_cord);
                        if (!blnDropped) {
                            layoutParams.leftMargin = x_cord;
                            layoutParams.topMargin = y_cord;
                            v.setLayoutParams(layoutParams);
                            blnDropped = true;
                        }

                        //img.setVisibility(View.VISIBLE);

                        // Do nothing
                        break;
                    default: break;
                }
                return true;
            }
        });

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(img);

                    //img.startDrag(data, shadowBuilder, img, 0);
                    v.startDragAndDrop(data,shadowBuilder,null,0);
                    //img.setVisibility(View.INVISIBLE);
                    blnDropped = false;
                    return true;
                } else {
                    return false;
                }
            }
        });
    }
}
