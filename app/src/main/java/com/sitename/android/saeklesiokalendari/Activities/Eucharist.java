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

public class Eucharist extends Fragment implements AdapterView.OnItemClickListener {

    private ListView list;
    private Intent intent;
    String[] eucharists;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_eucharist, container, false);

        eucharists = new String[] {"იესო ქრისტე", "წმინდა ნიკოლოზი", "წმინდა გიორგი"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_expandable_list_item_1, eucharists);

        list = (ListView) v.findViewById(R.id.eucharist_list_view);
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
                Options.topics = new String[] { eucharists[position] };
                Options.storys = new String[] { getActivity().getResources().getString(R.string.Jesus_story) };
                startActivity(intent);
                break;

            case 1:
                Options.topics = new String[] { eucharists[position] };
                Options.storys = new String[] { getActivity().getResources().getString(R.string.Nikoloz_story) };
                startActivity(intent);
                break;

            case 2:
                Options.topics = new String[] { eucharists[position] };
                Options.storys = new String[] { getActivity().getResources().getString(R.string.Georges_story) };
                startActivity(intent);
                break;
        }
    }
}
