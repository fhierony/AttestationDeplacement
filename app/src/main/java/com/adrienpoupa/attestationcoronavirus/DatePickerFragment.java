package com.adrienpoupa.attestationcoronavirus;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), dateSetListener, year, month, day);

        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

        double diff = System.currentTimeMillis() - 568025136000.0;
        datePickerDialog.getDatePicker().setMaxDate((long) diff);
        datePickerDialog.getDatePicker().getTouchables().get( 0 ).performClick();

        return datePickerDialog;
    }

    private DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    String date = day + " " + new DateFormatSymbols().getMonths()[month] + " " + year;
                    ((CreateAttestationActivity) getActivity()).setDate(date);
                }
            };
}
