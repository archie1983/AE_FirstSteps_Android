package com.ae.ae_firststeps_android;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ae.ae_firststeps_android.dummy.DummyContent;

/**
 * A fragment representing a single Dish detail screen.
 * This fragment is either contained in a {@link DishListActivity}
 * in two-pane mode (on tablets) or a {@link DishDetailActivity}
 * on handsets.
 */
public class DishDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DishDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**
         * AE: So we're taking a dish_detail layout and inflating it into this view
         */
        View rootView = inflater.inflate(R.layout.dish_detail, container, false);

        /**
         * Now once it's been inflated, we can access its components, one of which is a TextView
         * and (imo stupidly) is called the same as the layout: dish_detail. Once we have a handle
         * of that, we just set the text and it's done.
         */
        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.dish_detail)).setText(mItem.details);
        }

        return rootView;
    }
}
