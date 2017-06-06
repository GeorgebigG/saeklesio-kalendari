package com.sitename.android.saeklesiokalendari.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sitename.android.saeklesiokalendari.R;

public class Prayers extends Fragment implements AdapterView.OnItemClickListener {

    ListView list;
    Intent intent;
    String[] prays;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_prayers, container, false);

        prays = new String[] {"დილის ლოცვანი", "სამწმიდაობის ტროპარნი", "და ლოცვა სამებისადმი"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_expandable_list_item_1, prays);

        list = (ListView) v.findViewById(R.id.prayer_list);
        list.setAdapter(adapter);

        intent = new Intent(getActivity(), Options.class);

        list.setOnItemClickListener(this);

        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position)
        {
            case 0:
                Options.topics = new String[] { prays[position] };
                Options.storys = new String[] { getActivity().getResources().getString(R.string.morning_prayers) };
                startActivity(intent);
                break;

            case 1:
                Options.topics = new String[] { prays[position] };
                Options.storys = new String[] { getActivity().getResources().getString(R.string.prayers_1) };
                startActivity(intent);
                break;

            case 2:
                Options.topics = new String[] { prays[position] };
                Options.storys = new String[] { getActivity().getResources().getString(R.string.prayers_2) };
                startActivity(intent);
                break;
        }
    }
}
