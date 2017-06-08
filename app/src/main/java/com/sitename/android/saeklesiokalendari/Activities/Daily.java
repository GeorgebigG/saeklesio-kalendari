package com.sitename.android.saeklesiokalendari.Activities;

import android.app.DatePickerDialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sitename.android.saeklesiokalendari.Others.DatePicker;
import com.sitename.android.saeklesiokalendari.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Daily extends Fragment implements View.OnClickListener {

    public static int year = 0;
    public static int month = 0;
    public static int day = 0;
    private static TextView monthDate;
    private static TextView dayDate;
    public static Calendar main_calendar = Calendar.getInstance();

    private ImageView image;

    private TextView title;

    private static Map<String, String> translator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_daily, container, false);

        makeTranslator();

        monthDate = (TextView) v.findViewById(R.id.month);
        dayDate = (TextView) v.findViewById(R.id.day);
        title = (TextView) v.findViewById(R.id.daily_title);
        title.setText(getResources().getString(R.string.cminda_nikolozi_title));

        image = (ImageView) v.findViewById(R.id.daily_image);
        setDate();

        v.findViewById(R.id.yesterday).setOnClickListener(this);
        v.findViewById(R.id.tomorrow).setOnClickListener(this);

        v.findViewById(R.id.d_pref).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {FirstPage.settingButtonClicked();}
        });
        v.findViewById(R.id.calendar).setOnClickListener(this);

        return v;
    }

    private static void makeTranslator() {
        translator = new HashMap<String, String>();
        translator.put("Sunday",    "კვირა");
        translator.put("Monday",    "ორშაბათი");
        translator.put("Tuesday",   "სამშაბათი");
        translator.put("Wednesday", "ოთხშაბათი");
        translator.put("Thursday",  "ხუთშაბათი");
        translator.put("Friday",    "პარასკევი");
        translator.put("Saturday",  "შაბათი");

        translator.put("January",   "იანვარი");
        translator.put("February",  "თებერვალი");
        translator.put("March",     "მარტი");
        translator.put("April",     "აპრილი");
        translator.put("May",       "მაისი");
        translator.put("June",      "ივნისი");
        translator.put("July",      "ივლისი");
        translator.put("August",    "აგვისტო");
        translator.put("September", "სექტემბერი");
        translator.put("October",   "ოქტომბერი");
        translator.put("November",  "ნოემბერი");
        translator.put("December",  "დეკემბერი");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calendar:
                setLocale("ka");
                DatePicker picker = new DatePicker(year, month, day);
                picker.show(getActivity().getFragmentManager().beginTransaction(), "");
                break;

            case R.id.yesterday:
                main_calendar.add(Calendar.DAY_OF_MONTH, -1);
                setDate();
                break;

            case R.id.tomorrow:
                main_calendar.add(Calendar.DAY_OF_MONTH, 1);
                setDate();
                break;

            default:
                break;
        }
    }

    private void setLocale(String lang) {
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();

        Locale myLocale = new Locale(lang);
        conf.locale = myLocale;

        res.updateConfiguration(conf, dm);
    }

    public static void setDate() {
        day = main_calendar.get(Calendar.DAY_OF_MONTH);
        month = main_calendar.get(Calendar.MONTH);
        year = main_calendar.get(Calendar.YEAR);

        DateFormat formater = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        String s = formater.format(main_calendar.getTime());
        String dayName = translator.get(s.split(",")[0]);
        String monthName = translator.get(s.split(" ")[1]);

        monthDate.setText(monthName
//                        + "\n" + new SimpleDateFormat("d").format(main_calendar.getTime()) + "\n" + dayName + "\n" + new SimpleDateFormat("yyyy").format(main_calendar.getTime())
        );

        dayDate.setText(new SimpleDateFormat("dd").format(main_calendar.getTime()));
    }
}












