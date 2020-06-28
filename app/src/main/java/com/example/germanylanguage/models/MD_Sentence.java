package com.example.germanylanguage.models;

public class MD_Sentence {

    private Integer Id;

    private String Sentence;

    private String Translate;

    private boolean Free;

    public MD_Sentence(Integer id, String sentence, String translate, boolean free) {
        Id = id;
        Sentence = sentence;
        Translate = translate;
        Free = free;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getSentence() {
        return Sentence;
    }

    public void setSentence(String sentence) {
        Sentence = sentence;
    }

    public String getTranslate() {
        return Translate;
    }

    public void setTranslate(String translate) {
        Translate = translate;
    }

    public boolean isFree() {
        return Free;
    }

    public void setFree(boolean free) {
        Free = free;
    }
}
