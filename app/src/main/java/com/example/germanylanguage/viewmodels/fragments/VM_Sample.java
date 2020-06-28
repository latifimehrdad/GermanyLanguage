package com.example.germanylanguage.viewmodels.fragments;

import android.content.Context;
import android.os.Handler;

import com.example.germanylanguage.models.MD_Sentence;
import com.example.germanylanguage.utilities.StaticValues;
import com.example.germanylanguage.viewmodels.VM_Primary;

import java.util.ArrayList;
import java.util.List;

public class VM_Sample extends VM_Primary {

    private Context context;
    private List<MD_Sentence> md_sentences;

    public VM_Sample(Context context) {//___________________________________________________________ VM_Sample
        this.context = context;
    }//_____________________________________________________________________________________________ VM_Sample


    public void GetSentenceFromDB(String Sentence) {//______________________________________________ GetSentenceFromDB
        if (md_sentences != null) {
            md_sentences.clear();
            md_sentences = null;
        }

        md_sentences = new ArrayList<>();

        if (Sentence == null)
            for (int i = 0; i < 10; i++)
                md_sentences.add(new MD_Sentence(i, "Sentence " + i, "جمله " + i, true));
        else
            for (int i = 0; i < 5; i++)
                md_sentences.add(new MD_Sentence(i, "Hello " + i, "سلام " + i, true));

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getPublishSubject().onNext(StaticValues.ML_GetSentenceDB);
            }
        }, 2000);

    }//_____________________________________________________________________________________________ GetSentenceFromDB


    public List<MD_Sentence> getMd_sentences() {//__________________________________________________ getMd_sentences
        return md_sentences;
    }//_____________________________________________________________________________________________ getMd_sentences
}
