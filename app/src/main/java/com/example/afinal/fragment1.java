package com.example.afinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment1 extends Fragment {
    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    String montNames;

    @BindView(R.id.editTextTextPersonName2)
    EditText nameEditText;

    ArrayList<String> usersItems = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        ButterKnife.bind(this, view);


        usersItems.add("asd");

        recyclerView = view.findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new RecyclerAdapter(view.getContext(), usersItems);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }

    @OnClick(R.id.saveBtn)
    public void save() {
        usersItems.add(nameEditText.getText().toString());
        adapter.notifyDataSetChanged();
    }
}