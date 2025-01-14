package com.india.cpgram.utils;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

/**
 * Utility class for displaying Snackbars globally.
 */
public class SnackbarUtil {

    /**
     * Show a basic Snackbar.
     *
     * @param context   The context where the Snackbar will appear (usually Activity or Fragment).
     * @param message   The message to display in the Snackbar.
     * @param duration  Duration for which the Snackbar will be shown.
     */
    public static void showSnackbar(Context context, String message, int duration) {
        showSnackbar(context, message, duration, null, null, Color.BLACK, Color.WHITE);
    }

    /**
     * Show a Snackbar with optional action.
     *
     * @param context   The context where the Snackbar will appear (usually Activity or Fragment).
     * @param message   The message to display in the Snackbar.
     * @param duration  Duration for which the Snackbar will be shown.
     * @param actionText Action text for the Snackbar (e.g., "UNDO"). If null, no action button.
     * @param actionListener Action listener for the action button.
     */
    public static void showSnackbar(Context context, String message, int duration,
                                    String actionText, View.OnClickListener actionListener) {
        showSnackbar(context, message, duration, actionText, actionListener, Color.BLACK, Color.WHITE);
    }

    /**
     * Show a fully customizable Snackbar.
     *
     * @param context          The context where the Snackbar will appear (usually Activity or Fragment).
     * @param message          The message to display in the Snackbar.
     * @param duration         Duration for which the Snackbar will be shown.
     * @param actionText       Action text for the Snackbar (e.g., "UNDO"). If null, no action button.
     * @param actionListener   Action listener for the action button.
     * @param backgroundColor  Background color of the Snackbar.
     * @param textColor        Text color for the Snackbar.
     */
    public static void showSnackbar(Context context, String message, int duration,
                                    String actionText, View.OnClickListener actionListener,
                                    int backgroundColor, int textColor) {

        // Find the root view to attach the Snackbar
        View rootView = ((android.app.Activity) context).findViewById(android.R.id.content);

        // Create the Snackbar
        Snackbar snackbar = Snackbar.make(rootView, message, duration);

        // Customize Snackbar's background color
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(backgroundColor);

        // Customize Snackbar's text color
        TextView textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(textColor);

        // Add action if needed
        if (actionText != null && actionListener != null) {
            snackbar.setAction(actionText, actionListener);
            snackbar.setActionTextColor(Color.YELLOW);  // Custom color for action text
        }

        // Show the Snackbar
        snackbar.show();
    }

    public static void showSnackbar(Context context, String message,
                                    int backgroundColor, int textColor) {

        // Find the root view to attach the Snackbar
        View rootView = ((android.app.Activity) context).findViewById(android.R.id.content);

        // Create the Snackbar
        Snackbar snackbar = Snackbar.make(rootView, message, Snackbar.LENGTH_LONG);

        // Customize Snackbar's background color
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(backgroundColor);

        // Customize Snackbar's text color
        TextView textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(textColor);

        // Show the Snackbar
        snackbar.show();
    }
}
