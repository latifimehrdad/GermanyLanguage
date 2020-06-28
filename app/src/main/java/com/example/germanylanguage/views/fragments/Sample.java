package com.example.germanylanguage.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.germanylanguage.R;
import com.example.germanylanguage.databinding.FragmentHomeBinding;
import com.example.germanylanguage.databinding.FragmentSampleBinding;
import com.example.germanylanguage.utilities.StaticValues;
import com.example.germanylanguage.viewmodels.fragments.VM_Home;
import com.example.germanylanguage.viewmodels.fragments.VM_Sample;
import com.example.germanylanguage.views.adapter.AP_Sentence;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class Sample extends FragmentPrimary implements FragmentPrimary.GetMessageFromObservable {

    private NavController navController;
    private VM_Sample vm_sample;
    private CompositeDisposable compositeDisposable;
    private AP_Sentence ap_sentence;

    @BindView(R.id.EditTextSentence)
    EditText EditTextSentence;

    @BindView(R.id.ImageViewCloseSuggestion)
    ImageView ImageViewCloseSuggestion;

    @BindView(R.id.RecyclerViewSentence)
    RecyclerView RecyclerViewSentence;

    @BindView(R.id.RecyclerViewSuggestion)
    RecyclerView RecyclerViewSuggestion;



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
            SetOnClick();
            RecyclerViewSuggestion.setVisibility(View.GONE);
            EditTextSentence.requestFocus();
            EditTextDestinationChange();
            vm_sample.GetSentenceFromDB(null);
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

        if (action == StaticValues.ML_GetSentenceDB) {
            SetSuggestionAdapter();
            return;
        }
    }//_____________________________________________________________________________________________ GetMessageFromObservable


    private void EditTextDestinationChange() {//____________________________________________________ EditTextDestinationChange

        if (compositeDisposable != null) {
            compositeDisposable.dispose();
            compositeDisposable = null;
        }
        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RxTextView.textChangeEvents(EditTextSentence)
                .skipInitialValue()
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(searchContactsTextWatcher()));

    }//_____________________________________________________________________________________________ EditTextDestinationChange



    private DisposableObserver<TextViewTextChangeEvent> searchContactsTextWatcher() {//_____________ Start searchContactsTextWatcher
        return new DisposableObserver<TextViewTextChangeEvent>() {
            @Override
            public void onNext(TextViewTextChangeEvent textViewTextChangeEvent) {
                if (EditTextSentence.getText().toString().length() == 0)
                    vm_sample.GetSentenceFromDB(null);
                else
                    vm_sample.GetSentenceFromDB(EditTextSentence.getText().toString());

            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {

            }
        };
    }//_____________________________________________________________________________________________ End searchContactsTextWatcher


    private void SetOnClick() {//___________________________________________________________________ SetOnClick

        ImageViewCloseSuggestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextSentence.getText().clear();
                RecyclerViewSuggestion.setVisibility(View.GONE);
            }
        });

    }//_____________________________________________________________________________________________ SetOnClick



    private void SetSuggestionAdapter() {//_________________________________________________________ SetSuggestionAdapter
        ap_sentence = new AP_Sentence(getContext(), vm_sample.getMd_sentences(),Sample.this);
        RecyclerViewSentence.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        RecyclerViewSentence.setAdapter(ap_sentence);
    }//_____________________________________________________________________________________________ SetSuggestionAdapter

}
