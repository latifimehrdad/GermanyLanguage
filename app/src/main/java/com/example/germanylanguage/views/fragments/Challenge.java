package com.example.germanylanguage.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.germanylanguage.R;
import com.example.germanylanguage.databinding.FragmentChallengeBinding;
import com.example.germanylanguage.databinding.FragmentSampleBinding;
import com.example.germanylanguage.viewmodels.fragments.VM_Challenge;
import com.example.germanylanguage.viewmodels.fragments.VM_Sample;

import butterknife.ButterKnife;

public class Challenge extends FragmentPrimary implements FragmentPrimary.GetMessageFromObservable {

    private NavController navController;
    private VM_Challenge vm_challenge;


    public Challenge() {//__________________________________________________________________________ Challenge
    }//_____________________________________________________________________________________________ Challenge

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {//__________________________________________________________ onCreateView
        if (getView() == null) {
            FragmentChallengeBinding binding = DataBindingUtil.inflate(
                    inflater, R.layout.fragment_challenge, container, false);
            vm_challenge = new VM_Challenge(getContext());
            binding.setChallenge(vm_challenge);
            setView(binding.getRoot());
            ButterKnife.bind(this, getView());
        }
        return getView();
    }//_____________________________________________________________________________________________ onCreateView



    @Override
    public void onStart() {//_______________________________________________________________________ onStart
        super.onStart();
        setGetMessageFromObservable(Challenge.this, vm_challenge.getPublishSubject());
        navController = Navigation.findNavController(getView());
    }//_____________________________________________________________________________________________ onStart



    @Override
    public void GetMessageFromObservable(Byte action) {//___________________________________________ GetMessageFromObservable

    }//_____________________________________________________________________________________________ GetMessageFromObservable

}
