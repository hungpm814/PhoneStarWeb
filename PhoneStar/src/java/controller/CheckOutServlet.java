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
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Bill;
import model.Orders;
import model.Phone;
import model.User;

/**
 *
 * @author PC
 */
public class CheckOutServlet extends HttpServlet {
   
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
            out.println("<title>Servlet CheckOutServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOutServlet at " + request.getContextPath () + "</h1>");
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
        BillDAO bid = new BillDAO();
        int billID = bid.getBillID();
        
        HttpSession sess = request.getSession();
        User u = (User) sess.getAttribute("acc");
        String username = u.getUserName();
        
        OrdersDAO od = new OrdersDAO();
        List<Orders> li = od.getAllByBid(billID);
        
        int total = od.getSumPriceByBid(billID);
        
        String tot = String.valueOf(total);
        Bill b = new Bill(billID, username, tot, tot);
        
        bid.update(b);
        request.setAttribute("total", editPrice(tot));
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
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
        HttpSession sess = request.getSession();
        PhoneDAO pd = new PhoneDAO();
        
        List<Orders> tlo = (List<Orders>) sess.getAttribute("lo");
        for(Orders x:tlo){
            Phone p = pd.getPhoneBySeries(x.getSeries());
            p.setQuantity(p.getQuantity()-x.getQuantity());
            //if(p.getQuantity()==0){
                //pd.delete(p.getSeries());
            //}
            //else{
            pd.update(p);
            //}
        }
        
        sess.setAttribute("lo", null);
        sess.setAttribute("lop", null);
        sess.setAttribute("paid", "yes");
        request.setAttribute("checkbuy", "true");
        request.getRequestDispatcher("home").forward(request, response);
        
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
