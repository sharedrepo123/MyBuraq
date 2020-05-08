package com.example.navigation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import com.example.navigation.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public HomeFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        ImageSlider imageSlider =(ImageSlider) root.findViewById(R.id.slider);
        List<SlideModel> slideModels= new ArrayList<>();

        slideModels.add(new  SlideModel(R.drawable.img1,"Get to a Masjid!\n" + "Namaz is an obligation towards Almighty God"));
        slideModels.add(new SlideModel(R.drawable.img2,"Namaz is Momin's Miraj\n" + "Ride to Miraj is Buraq"));
        slideModels.add(new SlideModel(R.drawable.img3,"All Muslims are Brothers\n" + "Help one get there in time for Prayer"));
        slideModels.add(new SlideModel(R.drawable.img4,"Lets get to a masjid\n" + "Salat is one of the five pillars of Islam"));
        slideModels.add(new SlideModel(R.drawable.img5,"Help save the environment\n" + "Travel together in a Jamat"));

        imageSlider.setImageList(slideModels,true);
        return root;




    }


}