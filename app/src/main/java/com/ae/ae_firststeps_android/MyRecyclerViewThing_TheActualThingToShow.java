package com.ae.ae_firststeps_android;

/**
 * A class describing the actual thing that we want to display in the recyclerview presentation
 * fragment, once an item is selected in the left hand row.
 *
 * Basically an object of this class should contain data, that needs to be loaded into
 * the recyclervew_presentation_holder.xml after we've clicked on an item represented
 * in one of the recycler_view_row.xml rows.
 */
public class MyRecyclerViewThing_TheActualThingToShow {
    private int idOfThisThing = 99;
    private String descriptonOfThisThing = "Just some thing";
    private int imageResource = R.drawable.dragndrop;

    public String getDescriptonOfThisThing() {
        return descriptonOfThisThing;
    }

    public int getImageResource() {
        return imageResource;
    }

    public MyRecyclerViewThing_TheActualThingToShow(int idOfThisThing,
                                                    String descriptonOfThisThing,
                                                    int imageResource) {
        if (idOfThisThing < 99) {
            this.descriptonOfThisThing = descriptonOfThisThing;
            this.idOfThisThing = idOfThisThing;
            this.imageResource = imageResource;
        }
    }

    public int getIdOfThisThing() {
        return idOfThisThing;
    }
}
