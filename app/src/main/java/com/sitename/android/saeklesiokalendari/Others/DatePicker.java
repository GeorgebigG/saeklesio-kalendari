package com.sitename.android.saeklesiokalendari.Others;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

/**
 * Created by George on 3/21/2017.
 */

public class DatePicker extends DialogFragment {
    private int year, month, day;

    public DatePicker(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        DatePickerDialog dialog = new DatePickerDialog(getActivity(), dateSetListener, year, month, day);

        return dialog;
    }

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
            DatePicker.this.year = year;
            DatePicker.this.month = month;
            DatePicker.this.day = day;

            // TODO: DASAMTAVREBELIA...
        }
    };
}