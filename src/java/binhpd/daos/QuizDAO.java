/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.daos;

import binhpd.dtos.QuizDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import khangndn.db.MyConnection;

/**
 *
 * @author KHANG NGUYEN
 */
public class QuizDAO implements Serializable{
    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;
    private void closeConnection() throws Exception
    {
        if(rs!= null) rs.close();
        if(preStm!=null) preStm.close();
        if(conn!=null) conn.close();
    }
    private int insertQuiz(QuizDTO dto) throws Exception
    {
        int id = 0;
        String url = "Insert into Quiz(Description, Difficulty, Questions, Seconds, Name, Category, Status) values(?,?,?,?,?,?,?) Select @@IDENTITY as QuizID";
        try
        {
            conn=MyConnection.getMyConnection();
            preStm=conn.prepareStatement(url, PreparedStatement.RETURN_GENERATED_KEYS);
            preStm.setString(1, dto.getDescription());
            preStm.setString(2, dto.getDifficulty());
            preStm.setInt(3, dto.getQuestions());
            preStm.setInt(4, dto.getSeconds());
            preStm.setString(5, dto.getName());
            preStm.setString(6, dto.getCategory());
            preStm.setString(7, "true");
            preStm.executeUpdate();
            rs = preStm.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt("QuizID");
            }
        }
        finally
        {
            closeConnection();
        }
        return id;
    }
    public List<QuizDTO> selectQuiz() throws Exception {
        List<QuizDTO> result;

        int id = 0;
        String des = null;
        String difficulty = null;
        String name = null;
        String category = null;
        int question = 0;
        int second = 0;
        QuizDTO dto = null;
        try {
            String sql = "Select QuizID, Description, Difficulty, Questions, Seconds, Name, Category From Quiz where Status = ?";

            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "true");
            rs = preStm.executeQuery();
            result = new ArrayList<>();

            while (rs.next()) {
                id = rs.getInt("QuizID");
                des = rs.getNString("Description");
                difficulty = rs.getNString("Difficulty");
                name = rs.getNString("Name");
                category = rs.getNString("Category");
                second=rs.getInt("Seconds");
                question=rs.getInt("Questions");
                dto = new QuizDTO(id, des, difficulty, question, second, name, category);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
