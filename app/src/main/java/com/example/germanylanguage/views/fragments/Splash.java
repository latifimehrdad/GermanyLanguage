package com.example.germanylanguage.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.germanylanguage.R;
import com.example.germanylanguage.databinding.FragmentSplashBinding;
import com.example.germanylanguage.utilities.StaticValues;
import com.example.germanylanguage.viewmodels.fragments.VM_Splash;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Splash extends FragmentPrimary implements FragmentPrimary.GetMessageFromObservable {


    private VM_Splash vm_splash;
    private NavController navController;

    @BindView(R.id.ImageViewSplash)
    ImageView ImageViewSplash;


    public Splash() {//_____________________________________________________________________________ Splash

    }//_____________________________________________________________________________________________ Splash


    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {//__________________________________________________________ onCreateView
        if (getView() == null) {
            FragmentSplashBinding binding = DataBindingUtil.inflate(
                    inflater, R.layout.fragment_splash, container, false);
            vm_splash = new VM_Splash(getContext());
            binding.setSplash(vm_splash);
            setView(binding.getRoot());
            ButterKnife.bind(this, getView());
        }
        return getView();
    }//_____________________________________________________________________________________________ onCreateView


    @Override
    public void onStart() {//_______________________________________________________________________ onStart
        super.onStart();
        setGetMessageFromObservable(Splash.this, vm_splash.getPublishSubject());
        navController = Navigation.findNavController(getView());
        StartAnimationSplash();
        vm_splash.GetDataFromServer();
    }//_____________________________________________________________________________________________ onStart


    private void StartAnimationSplash() {//_________________________________________________________ StartAnimationSplash
        ImageViewSplash.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.bounce));
    }//_____________________________________________________________________________________________ StartAnimationSplash


    @Override
    public void GetMessageFromObservable(Byte action) {//___________________________________________ GetMessageFromObservable

        if (action == StaticValues.ML_GotoHome) {
            navController.navigate(R.id.action_splash_to_home2);
        }
    }//_____________________________________________________________________________________________ GetMessageFromObservable
}
