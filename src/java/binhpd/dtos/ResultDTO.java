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
public class ResultDTO implements Serializable{
    private int resultID, quizID, second;
    private String username;
    private float mark;

    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public ResultDTO(int resultID, int quizID, int second, String username, float mark) {
        this.resultID = resultID;
        this.quizID = quizID;
        this.second = second;
        this.username = username;
        this.mark = mark;
    }

    public ResultDTO(int quizID, int second, String username, float mark) {
        this.quizID = quizID;
        this.second = second;
        this.username = username;
        this.mark = mark;
    }
    
}
