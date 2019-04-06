/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.dtos;

import java.io.Serializable;

/**
 *
 * @author KHANG NGUYEN
 */
public class AnswerDTO implements Serializable{
    private int answerID, resultID, questionID;
    private String answer;

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public AnswerDTO(int answerID, int resultID, int questionID, String answer) {
        this.answerID = answerID;
        this.resultID = resultID;
        this.questionID = questionID;
        this.answer = answer;
    }

    public AnswerDTO(int resultID, int questionID, String answer) {
        this.resultID = resultID;
        this.questionID = questionID;
        this.answer = answer;
    }
    
}
