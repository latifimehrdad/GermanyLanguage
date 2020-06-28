package com.example.germanylanguage.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.germanylanguage.R;
import com.example.germanylanguage.databinding.FragmentHomeBinding;
import com.example.germanylanguage.viewmodels.fragments.VM_Home;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home extends FragmentPrimary implements FragmentPrimary.GetMessageFromObservable {

    private VM_Home vm_home;
    private NavController navController;

    @BindView(R.id.LinearLayoutSample)
    LinearLayout LinearLayoutSample;

    @BindView(R.id.LinearLayoutChallenge)
    LinearLayout LinearLayoutChallenge;


    public Home() {//_______________________________________________________________________________ Home

    }//_____________________________________________________________________________________________ Home



    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {//__________________________________________________________ onCreateView
        if (getView() == null) {
            FragmentHomeBinding binding = DataBindingUtil.inflate(
                    inflater, R.layout.fragment_home, container, false);
            vm_home = new VM_Home(getContext());
            binding.setHome(vm_home);
            setView(binding.getRoot());
            ButterKnife.bind(this, getView());
            SetOnClick();
        }
        return getView();
    }//_____________________________________________________________________________________________ onCreateView



    @Override
    public void onStart() {//_______________________________________________________________________ onStart
        super.onStart();
        setGetMessageFromObservable(Home.this, vm_home.getPublishSubject());
        navController = Navigation.findNavController(getView());
    }//_____________________________________________________________________________________________ onStart



    @Override
    public void GetMessageFromObservable(Byte action) {//___________________________________________ GetMessageFromObservable

    }//_____________________________________________________________________________________________ GetMessageFromObservable



    private void SetOnClick() {//___________________________________________________________________ SetOnClick

        LinearLayoutSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_home_to_sample);
            }
        });

        LinearLayoutChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_home_to_challenge);
            }
        });

    }//_____________________________________________________________________________________________ SetOnClick

}
