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
    private String imagePath = "@drawable/dragndrop";

    public String getDescriptonOfThisThing() {
        return descriptonOfThisThing;
    }

    public String getImagePath() {
        return imagePath;
    }

    public MyRecyclerViewThing_TheActualThingToShow(int idOfThisThing,
                                                    String descriptonOfThisThing,
                                                    String imagePath) {
        if (idOfThisThing < 99) {
            this.descriptonOfThisThing = descriptonOfThisThing;
            this.idOfThisThing = idOfThisThing;
            this.imagePath = imagePath;
        }
    }

    public int getIdOfThisThing() {
        return idOfThisThing;
    }
}
