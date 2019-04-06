/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.daos;

import binhpd.dtos.QuestionDTO;
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
public class QuestionDAO implements Serializable{
    Connection conn;
    PreparedStatement preStm;
    ResultSet rs;
    private void closeConnection() throws Exception
    {
        if(rs!= null) rs.close();
        if(preStm!=null) preStm.close();
        if(conn!=null) conn.close();
    }
    private boolean insertQuestion(QuestionDTO dto) throws Exception
    {
        boolean check = false;
        String url = "Insert into Question(QuizID, QuestionDetail, OptionA, OptionB, OptionC, OptionD, Answer, ResourceCode) values(?,?,?,?,?,?,?,?)";
        try
        {
            conn=MyConnection.getMyConnection();
            preStm=conn.prepareStatement(url);
            preStm.setInt(1, dto.getQuizID());
            preStm.setString(2, dto.getDetail());
            preStm.setString(3, dto.getOptionA());
            preStm.setString(4, dto.getOptionB());
            preStm.setString(5, dto.getOptionC());
            preStm.setString(6, dto.getOptionD());
            preStm.setString(7, dto.getAnswer());
            preStm.setString(8, dto.getResourceCode());
            check=preStm.executeUpdate()>0;
        }
        finally
        {
            closeConnection();
        }
        return check;
    }
    public List<QuestionDTO> selectQuiz(int quizID) throws Exception {
        List<QuestionDTO> result;

        int questionID = 0;
        String detail = null;
        String optionA = null;
        String optionB = null;
        String optionC = null;
        String optionD = null;
        String answer = null;
        String resource = null;
        QuestionDTO dto = null;
        try {
            String sql = "Select QuestionID, QuestionDetail, OptionA, OptionB, OptionC, OptionD, Answer,ResourceCode From Question where QuizID = ?";

            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, quizID);
            rs = preStm.executeQuery();
            result = new ArrayList<>();

            while (rs.next()) {
                questionID = rs.getInt("QuestionID");
                detail = rs.getNString("QuestionDetail");
                optionA = rs.getNString("OptionA");
                optionB = rs.getNString("OptionB");
                optionC = rs.getNString("OptionC");
                optionD=rs.getNString("OptionD");
                answer=rs.getNString("Answer");
                resource=rs.getNString("ResourceCode");
                dto = new QuestionDTO(questionID, quizID, detail, optionA, optionB, optionC, optionD, answer, resource);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
