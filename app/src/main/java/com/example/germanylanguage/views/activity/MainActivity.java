package com.example.germanylanguage.views.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.example.germanylanguage.R;
import com.example.germanylanguage.databinding.ActivityMainBinding;
import com.example.germanylanguage.viewmodels.acitivy.VM_Main;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private VM_Main vm_main;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//__________________________________________ onCreate
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        vm_main = new VM_Main(this);
        binding.setMain(vm_main);
        ButterKnife.bind(this);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    }//_____________________________________________________________________________________________ onCreate
}
