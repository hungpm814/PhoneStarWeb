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

/**
 *
 * @author PC
 */
public class CartServlet extends HttpServlet {
   
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
            out.println("<title>Servlet CartServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartServlet at " + request.getContextPath () + "</h1>");
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
        response.sendRedirect("cart.jsp");
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
        String type = request.getParameter("type");
        String series = request.getParameter("series");
        String quantity = request.getParameter("quantity");
        int q = Integer.parseInt(quantity);
        
        PhoneDAO pd = new PhoneDAO();
        Phone p = pd.getPhoneBySeries(series);
        
        if(sess.getAttribute("acc")==null){
            request.getRequestDispatcher("show?phoneName="+p.getPhoneName()).forward(request, response);
        }
        else 
        {
        int price = takePrice(p.getPrice());
        price = price*q;
        
       
        BillDAO bid = new BillDAO();
        int billID = bid.getBillID();
        
        String paid = (String) sess.getAttribute("paid");
        
        if(paid.compareTo("yes")==0) {
            billID++;
            Bill bTemp = new Bill(billID);
            bid.insert(bTemp);
        }
        sess.setAttribute("paid", "no");
        
        Orders o = new Orders(billID, series, q, String.valueOf(price));
        OrdersDAO od = new OrdersDAO();
        List<Orders> lo = od.getAllByBid(billID);
        
        boolean check=true;
        for(Orders i:lo){
            if(i.getBillID()==billID && i.getSeries().compareTo(series)==0){
                od.update(o);
                check=false;
                break;
            }
        }
        if(check) od.insert(o);
        
        lo = od.getAllByBid(billID);
        
        for(Orders x:lo){
            x.setPrice(editPrice(x.getPrice()));
        }
        
        List<Phone> lop = pd.getAll();
        for(Phone z:lop){
            z.setPrice(editPrice(z.getPrice()));
        }
        
        sess.setAttribute("lo", lo);
        sess.setAttribute("lop", lop);
        
        if(type.compareTo("1")==0){
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }
        
        if(type.compareTo("2")==0){
            String mes = "Thêm vào giỏ hàng thành công.";
            request.setAttribute("mes1", mes);
            request.getRequestDispatcher("show?phoneName="+p.getPhoneName()).forward(request, response);
        }
       
        }
    }
    
    public int takePrice(String p){
        String res = "";
        for(int i=0;i<p.length();i++)
            if(p.charAt(i)>='0' && p.charAt(i)<='9') res = res+p.charAt(i);
        return Integer.parseInt(res);
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
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
