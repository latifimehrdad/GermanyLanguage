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
import com.example.germanylanguage.databinding.FragmentHomeBinding;
import com.example.germanylanguage.databinding.FragmentSampleBinding;
import com.example.germanylanguage.viewmodels.fragments.VM_Home;
import com.example.germanylanguage.viewmodels.fragments.VM_Sample;

import butterknife.ButterKnife;

public class Sample extends FragmentPrimary implements FragmentPrimary.GetMessageFromObservable {

    private NavController navController;
    private VM_Sample vm_sample;


    public Sample() {//_____________________________________________________________________________ Sample
    }//_____________________________________________________________________________________________ Sample

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {//__________________________________________________________ onCreateView
        if (getView() == null) {
            FragmentSampleBinding binding = DataBindingUtil.inflate(
                    inflater, R.layout.fragment_sample, container, false);
            vm_sample = new VM_Sample(getContext());
            binding.setSample(vm_sample);
            setView(binding.getRoot());
            ButterKnife.bind(this, getView());
        }
        return getView();
    }//_____________________________________________________________________________________________ onCreateView



    @Override
    public void onStart() {//_______________________________________________________________________ onStart
        super.onStart();
        setGetMessageFromObservable(Sample.this, vm_sample.getPublishSubject());
        navController = Navigation.findNavController(getView());
    }//_____________________________________________________________________________________________ onStart



    @Override
    public void GetMessageFromObservable(Byte action) {//___________________________________________ GetMessageFromObservable

    }//_____________________________________________________________________________________________ GetMessageFromObservable

}
