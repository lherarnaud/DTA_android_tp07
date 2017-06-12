package com.example.admin.dta_android_tp7;

/**
 * Created by admin on 12/06/2017.
 */

public class VraiFaux {

    private String question;
    private String purpose1;
    private String purpose2;
    private boolean answer;

    public VraiFaux(String question, String purpose1, String purpose2, boolean response) {
        setQuestion(question);
        setPurpose1(purpose1);
        setPurpose2(purpose2);
        setAnswer(answer);
    }


    public void setQuestion(String question) {
        this.question = question;
    }

    public void setPurpose1(String purpose1) {

        this.purpose1 = purpose1;
    }

    public void setPurpose2(String purpose2) {

        this.purpose2 = purpose2;
    }

    public void setAnswer(boolean answer)
    {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getPurpose1() {

        return purpose1;
    }

    public String getPurpose2() {

        return purpose2;
    }

    public boolean getAnswer() {
        return answer;
    }
}
