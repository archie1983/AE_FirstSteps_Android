package com.ae.ae_firststeps_android;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * A fragment representing a single presentation screen for a "thing" selected in my recyclerview.
 * This fragment is contained in a {@link RecyclerViewActivity}
 */
public class MyRecyclerViewDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    ArrayList<MyRecyclerViewThing_TheActualThingToShow> thingsCollection;
    MyRecyclerViewThing_TheActualThingToShow chosenThing;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MyRecyclerViewDetailFragment() {
        /**
         * Creating the collection of things here is suboptimal, because this constuctor
         * may be called in trivial places (e.g. when rotating screen). It would be
         * better to have this collection static or even better it should actually be
         * a reference to a content provider.
         */
        thingsCollection = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            thingsCollection.add(new MyRecyclerViewThing_TheActualThingToShow(i,
                    "thing # " + i,
                    "@drawable/mochito"));
        }

        /**
         * adding the default one
         */
        thingsCollection.add(new MyRecyclerViewThing_TheActualThingToShow(99,
                "",
                ""));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            chosenThing = findThingByID(getArguments().getInt(ARG_ITEM_ID,99));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null && chosenThing != null) {
                appBarLayout.setTitle(chosenThing.getDescriptonOfThisThing());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**
         * AE: So we're taking a recyclerview_presentation_holder layout and inflating it into this view
         */
        View rootView = inflater.inflate(R.layout.recyclerview_presentation_holder, container, false);

        /**
         * Now once it's been inflated, we can access its components, one of which is a TextView
         * and is called: dish_detail. Once we have a handle
         * of that, we just set the text and it's done.
         */
        if (chosenThing != null) {
            ((TextView) rootView.findViewById(R.id.txtID)).setText(chosenThing.getIdOfThisThing());
            ((TextView) rootView.findViewById(R.id.txtContent)).setText(chosenThing.getDescriptonOfThisThing());
        }

        return rootView;
    }

    /**
     * Just a silly function for finding things by their ID in the arraylist of things.
     * I guess this can be replaced by a dataprovider call to make it more realistic.
     */
    private MyRecyclerViewThing_TheActualThingToShow findThingByID(int thingID) {
        for (MyRecyclerViewThing_TheActualThingToShow thing : thingsCollection) {
            if (thing.getIdOfThisThing() == thingID) {
                return thing;
            }
        }
        /**
         * if nothing matched
         */
        return null; //thingsCollection.get(thingsCollection.size() - 1);
    }
}
