/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.BillDAO;
import dal.OrdersDAO;
import dal.PhoneDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Bill;
import model.Orders;
import model.Phone;

/**
 *
 * @author PC
 */
public class ShowBServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowBServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShowBServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String bill = request.getParameter("billID");
        int billID = Integer.parseInt(bill);
        
        BillDAO bd = new BillDAO();
        OrdersDAO od = new OrdersDAO();
        PhoneDAO pd = new PhoneDAO();
        List<Orders> lbo = od.getAllByBid(billID);
        List<Phone> lbp = pd.getAll();
        
        for(Orders o:lbo){
            o.setPrice(editPrice(o.getPrice()));
        }
        
        Bill b = bd.getByBid(billID);
        b.setTotal(editPrice(b.getTotal()));
        
        request.setAttribute("b", b);
        request.setAttribute("lbo", lbo);
        request.setAttribute("lbp", lbp);
        request.getRequestDispatcher("viewbill.jsp").forward(request, response);
    } 
    
    public String editPrice(String p){
        int count = 0;
        for(int i = p.length()-1;i>=0;i--){
            count++;
            if(count==3){
                p = p.substring(0, i) + '.' + p.substring(i);
                count=0;
            }
        }
        if(p.charAt(0)=='.') p = p.substring(1);
        return p;
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
