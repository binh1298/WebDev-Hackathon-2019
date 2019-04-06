/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhpd.daos;

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
public class ResultDAO implements Serializable {

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

    public int insertResult(ResultDTO dto) throws Exception {
        int id = 0;
        String url = "Insert into Result(Username, QuizID, Mark, Second) values(?,?,?,?) Select @@IDENTITY as ResultID";
        try {
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(url, PreparedStatement.RETURN_GENERATED_KEYS);
            preStm.setString(1, dto.getUsername());
            preStm.setInt(2, dto.getQuizID());
            preStm.setFloat(3, dto.getMark());
            preStm.setInt(4, dto.getSecond());
            preStm.executeUpdate();
            rs = preStm.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt("ResultID");
            }
        } finally {
            closeConnection();
        }
        return id;
    }

    public List<ResultDTO> selectResult(String username) throws Exception {
        List<ResultDTO> result;

        int resultId = 0;
        int quizID = 0;
        int second = 0;
        float mark = 0;
        ResultDTO dto = null;
        try {
            String sql = "Select ResultID, QuizID, Mark, Second From Result where Username = ?";

            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            result = new ArrayList<>();

            while (rs.next()) {
                resultId = rs.getInt("ResultID");
                quizID = rs.getInt("QuizID");
                mark = rs.getFloat("Mark");
                second = rs.getInt("Second");
                dto = new ResultDTO(resultId, quizID, second, username, mark);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
