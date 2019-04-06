/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.daos;

import binhpd.dtos.AnswerDTO;
import binhpd.dtos.ResultDTO;
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
public class AnswerDAO implements Serializable{
        Connection conn;
    PreparedStatement preStm;
    ResultSet rs;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public boolean insertAnswer(AnswerDTO dto) throws Exception {
        boolean check=false;
        String url = "Insert into Answer(QuestionID, ResultID, Answer) values(?,?,?)";
        try {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(url, PreparedStatement.RETURN_GENERATED_KEYS);
            preStm.setInt(1, dto.getQuestionID());
            preStm.setInt(2, dto.getResultID());
            preStm.setNString(4, dto.getAnswer());
            check = preStm.executeUpdate()>0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<AnswerDTO> selectAnswer(int resultID) throws Exception {
        List<AnswerDTO> result;

        int answerID = 0;
        int questionID = 0;
        String answer=null;
        AnswerDTO dto = null;
        try {
            String sql = "Select AnswerID, QuestionID, Answer From Answer where ResultID = ?";

            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, resultID);
            rs = preStm.executeQuery();
            result = new ArrayList<>();

            while (rs.next()) {
                answerID = rs.getInt("AnswerID");
                questionID = rs.getInt("QuestionID");
                answer = rs.getNString("Answer");
                dto=new AnswerDTO(answerID, resultID, questionID, answer);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
