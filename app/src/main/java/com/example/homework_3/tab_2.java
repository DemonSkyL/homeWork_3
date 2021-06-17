package com.example.homework_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class tab_2 extends Fragment {
    private pet[] mPets = {
            new pet("A", R.drawable.cat),
            new pet("B", R.drawable.cat),
            new pet("C", R.drawable.cat),
            new pet("D", R.drawable.cat),
    };
    private List<pet> petList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.tab_2, null);

        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                petList.add(mPets[i]);
            } else {
                petList.add(mPets[i - 5]);
            }
        }
        RecyclerView rl = (RecyclerView) view.findViewById(R.id.rl);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        rl.setLayoutManager(layoutManager);
        petAdapter adapter = new petAdapter(petList);
        rl.setAdapter(adapter);

        return view;

    }


}
