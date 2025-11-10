package com.example.mycalculator;

import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void testOnCreate_initializesViews() {
        MainActivity activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();

        TextView textView = activity.findViewById(R.id.textview_input_display);
        Button button0 = activity.findViewById(R.id.btn0);

        assertNotNull(textView);
        assertNotNull(button0);
        assertEquals("", textView.getText().toString());
    }

    @Test
    public void testOnClick_addsNumber() {
        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class).create().start();
        MainActivity activity = controller.get();

        Button button2 = activity.findViewById(R.id.btn2);
        TextView textView = activity.findViewById(R.id.textview_input_display);

        // Simulate button click
        button2.performClick();

        assertEquals("2", textView.getText().toString());
    }

    @Test
    public void testOnClick_clearDisplay() {
        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class).create().start();
        MainActivity activity = controller.get();

        TextView textView = activity.findViewById(R.id.textview_input_display);
        textView.setText("123");

        Button clearButton = activity.findViewById(R.id.btn_clear);
        clearButton.performClick();

        assertEquals("", textView.getText().toString());
    }
}
