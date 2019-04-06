/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khangndn.user.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import khangndn.daos.AccountDAO;
import khangndn.dtos.AccountDTO;
import khangndn.dtos.AccountErrorObject;

/**
 *
 * @author KHANG NGUYEN
 */
public class InsertController extends HttpServlet {
    private static final String ERROR= "error.jsp";
    private static final String SUCCESS="login.jsp";
    private static final String INVALID="sign_up.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         request.setCharacterEncoding("UTF-8");
        String url=ERROR;
        try {
            String username= request.getParameter("txtUsername");
            String password= request.getParameter("txtPassword");
            String confirm= request.getParameter("txtConfirm");
            String fullname= request.getParameter("txtFullname");
            String phone= request.getParameter("txtPhone");
            String email= request.getParameter("txtEmail");
            String school= request.getParameter("txtSchool");
            String className= request.getParameter("txtClass");
            AccountErrorObject errorObj= new AccountErrorObject();
            AccountDTO dto = new AccountDTO(username, fullname, phone, email,school,className);
            dto.setPassword(password);            
            dto.setStatus("true");
            AccountDAO dao = new AccountDAO();
                if(dao.insert(dto))
                {
                    url=SUCCESS;
                }else
                {
                    request.setAttribute("ERROR", "Insert failed");
                }
            
        } catch (Exception e) {
            if(e.getMessage().contains("duplicate"))
            {
                 url = INVALID;
                 AccountErrorObject errorObject= new AccountErrorObject();
                  errorObject.setUsernameError("Username existed!!!");
                 request.setAttribute("INVALID", errorObject);
            }else
                log("ERROR at InsertController: "+e.getMessage());
        }finally
        {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
