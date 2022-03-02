package com.ailatrieuphu.object;

import java.util.ArrayList;

public class Answer {
    private int idQuestion = -1, levelQs;
    private String noiDung,dapAnDung,str_answer_fail;
    private ArrayList<String> arrDapAnSai;

    public int getLevelQs() {
        return levelQs;
    }

    public String getStr_answer_fail() {
        return str_answer_fail;
    }

    public void setStr_answer_fail(String str_answer_fail) {
        this.str_answer_fail = str_answer_fail;
    }

    public void setLevelQs(int levelQs) {
        this.levelQs = levelQs;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public ArrayList<String> getArrDapAnSai() {
        return arrDapAnSai;
    }

    public void setArrDapAnSai(ArrayList<String> arrDapAnSai) {
        this.arrDapAnSai = arrDapAnSai;
    }

    public void setArrDapAnSai(String dapAnSai) {//dapan1&dapan2&dâpn3
        String arrS[]=dapAnSai.split("&"); // split string get value add arr
        this.arrDapAnSai = new ArrayList<>();
        for (String s : arrS){
            arrDapAnSai.add(s);
        }
    }
}
