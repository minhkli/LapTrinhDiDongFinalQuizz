package com.example.quizzfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quizzfinal.databinding.FragmentPlayBinding;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

public class PlayFragment extends Fragment {
    FragmentPlayBinding binding;
    RecyclerView recyclerView;
    SendDataHome sendDataHome;
    List<Subjects> list = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPlayBinding.inflate(inflater, container, false);
        recyclerView = binding.recycler;

        Subjects subject = new Subjects("ĐỊA LÝ", R.drawable.img_geography);
        Subjects subject1 = new Subjects("TOÁN HỌC", R.drawable._378413);
        Subjects subject2 = new Subjects("HÓA HỌC", R.drawable.img_chem);
        Subjects subject3 = new Subjects("LỊCH SỬ", R.drawable.img_history);

        list.clear();
        list.add(subject);
        list.add(subject1);
        list.add(subject2);
        list.add(subject3);

        SubjectsAdapter adapterSubjects = new SubjectsAdapter(getContext(), list, sendDataHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapterSubjects);


        return binding.getRoot();
    }
}