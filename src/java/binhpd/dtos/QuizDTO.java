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
public class QuizDTO implements Serializable{
    private int id, questions,seconds;
    private String description, difficulty, name, category, status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getQuestions() {
        return questions;
    }

    public void setQuestions(int questions) {
        this.questions = questions;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public QuizDTO(int id, String description, String difficulty, int questions, int seconds, String name, String category, String status) {
        this.id = id;
        this.description = description;
        this.difficulty = difficulty;
        this.questions = questions;
        this.seconds = seconds;
        this.name = name;
        this.category = category;
        this.status = status;
    }

    public QuizDTO(int id, String description, String difficulty, int questions, int seconds, String name, String category) {
        this.id = id;
        this.description = description;
        this.difficulty = difficulty;
        this.questions = questions;
        this.seconds = seconds;
        this.name = name;
        this.category = category;
    }

    public QuizDTO(String description, String difficulty, int questions, int seconds, String name, String category) {
        this.description = description;
        this.difficulty = difficulty;
        this.questions = questions;
        this.seconds = seconds;
        this.name = name;
        this.category = category;
    }
    
}
