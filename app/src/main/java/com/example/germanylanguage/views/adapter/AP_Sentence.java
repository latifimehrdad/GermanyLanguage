package com.example.germanylanguage.views.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.germanylanguage.R;
import com.example.germanylanguage.databinding.AdapterSentenceBinding;
import com.example.germanylanguage.models.MD_Sentence;
import com.example.germanylanguage.views.fragments.Sample;

import java.util.List;
import butterknife.ButterKnife;

public class AP_Sentence extends RecyclerView.Adapter<AP_Sentence.CustomHolder> {


    private LayoutInflater layoutInflater;
    private Context context;
    private List<MD_Sentence> md_sentences;
    private Sample sample;


    public AP_Sentence(Context context, List<MD_Sentence> md_sentences, Sample sample) {
        this.context = context;
        this.md_sentences = md_sentences;
        this.sample = sample;
    }


    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        return new AP_Sentence.CustomHolder(DataBindingUtil.inflate(layoutInflater, R.layout.adapter_sentence, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
        holder.bind(md_sentences.get(position), position);
    }

    @Override
    public int getItemCount() {
        return md_sentences.size();
    }

    public class CustomHolder extends RecyclerView.ViewHolder {
        AdapterSentenceBinding binding;

        public CustomHolder(AdapterSentenceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            View view = binding.getRoot();
            ButterKnife.bind(this, view);
        }

        public void bind(MD_Sentence item, final int position) {

            binding.setSentence(item);
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            binding.executePendingBindings();
        }
    }
}
