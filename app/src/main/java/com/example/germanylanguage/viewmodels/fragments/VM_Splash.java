package com.example.germanylanguage.viewmodels.fragments;

import android.content.Context;
import android.os.Handler;

import com.example.germanylanguage.utilities.StaticValues;
import com.example.germanylanguage.viewmodels.VM_Primary;

public class VM_Splash extends VM_Primary {

    private Context context;

    public VM_Splash(Context context) {//___________________________________________________________ VM_Splash
        this.context = context;
    }//_____________________________________________________________________________________________ VM_Splash


    public void GetDataFromServer() {//_____________________________________________________________ GetDataFromServer

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getPublishSubject().onNext(StaticValues.ML_GotoHome);
            }
        }, 2000);


    }//_____________________________________________________________________________________________ GetDataFromServer
}
