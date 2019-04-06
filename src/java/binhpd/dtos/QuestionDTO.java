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
public class QuestionDTO implements Serializable{
    private int questionID, quizID;
    private String detail, optionA, optionB, optionC, optionD, answer, resourceCode;
    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public QuestionDTO(int questionID, int quizID, String detail, String optionA, String optionB, String optionC, String optionD, String answer, String resourceCode) {
        this.questionID = questionID;
        this.quizID = quizID;
        this.detail = detail;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.resourceCode = resourceCode;
    }

    public QuestionDTO(int quizID, String detail, String optionA, String optionB, String optionC, String optionD, String answer, String resourceCode) {
        this.quizID = quizID;
        this.detail = detail;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.resourceCode = resourceCode;
    }
    
}
