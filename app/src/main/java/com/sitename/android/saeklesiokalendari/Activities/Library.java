package com.sitename.android.saeklesiokalendari.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sitename.android.saeklesiokalendari.R;

public class Library extends Fragment implements AdapterView.OnItemClickListener {

    private ListView list;
    private Intent intent;
    String[] libraries;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_library, container, false);

        ((Toolbar) v.findViewById(R.id.library_toolbar)).setBackgroundColor(Daily.TOOLBAR_COLOR);

        libraries = new String[] {"1 თავი", "2 თავი", "3 თავი"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_expandable_list_item_1, libraries);

        list = (ListView) v.findViewById(R.id.library_options);
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
                Options.topics = new String[] { libraries[position] };
                Options.storys = new String[] { getActivity().getResources().getString(R.string.chapter_1) };
                startActivity(intent);
                break;

            case 1:
                Options.topics = new String[] { libraries[position] };
                Options.storys = new String[] { getActivity().getResources().getString(R.string.chapter_2) };
                startActivity(intent);
                break;

            case 2:
                Options.topics = new String[] { libraries[position] };
                Options.storys = new String[] { getActivity().getResources().getString(R.string.chapter_3) };
                startActivity(intent);
                break;
        }
    }
}
