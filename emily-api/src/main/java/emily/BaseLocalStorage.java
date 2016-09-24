package emily;

import android.content.Context;

/**
 * A base interface for the user-defined LocalStorage to extend.
 * <p>
 * Created by szantogabor on 24/09/16.
 */
public interface BaseLocalStorage {
    /**
     * Clears all the saved data in {@link android.content.SharedPreferences}.
     */
    void clearAllData();

    /**
     * Saves all the data. This method is useful if a change occurs in the
     * LocalStorage to a custom object, that does not have a direct
     * setter associated with it.
     * <p>
     * So let's say you have a User object, and its firstName property
     * changes, then you need to call the save method to make sure this
     * change will be persisted in SharedPreferences properly.
     */
    void save();

    /**
     * @return Returns the {@link Context} given in the constructor.
     */
    Context getContext();
}