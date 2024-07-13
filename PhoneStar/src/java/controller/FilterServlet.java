/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Product;

/**
 *
 * @author PC
 */
public class FilterServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String brand = "0";
        String ram = "0";
        String rom = "0";
        String pbegin = "0", pend = "100000000";
        
        ProductDAO pd = new ProductDAO();
        List<Product> lp = pd.getProductsByFilter(pbegin, pend, ram, rom, brand);
        for(Product p:lp){
            p.setPrice(editPrice(p.getPrice()));
        }
        
        request.setAttribute("listproduct", lp);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
        String brand = (String) request.getParameter("brand");
        if(brand==null) brand = "0";
        String ram = "0";
        String rom = "0";
        String pbegin = "0", pend = "100000000";
        
        ProductDAO pd = new ProductDAO();
        List<Product> lp = pd.getProductsByFilter(pbegin, pend, ram, rom, brand);
        for(Product p:lp){
            p.setPrice(editPrice(p.getPrice()));
        }
        
        request.setAttribute("listproduct", lp);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
        String brand = (String) request.getParameter("brand");
        String ram = (String) request.getParameter("ram");
        String rom = (String) request.getParameter("rom");
        String price = (String) request.getParameter("price");
        String pbegin = "0", pend = "100000000";
        
        if(price.compareTo("0-1")==0){
            pend="1000000";
        }
        if(price.compareTo("1-5")==0){
            pbegin="1000000";
            pend="5000000";
        }
        if(price.compareTo("5-15")==0){
            pbegin="5000000";
            pend="15000000";
        }
        if(price.compareTo("15-30")==0){
            pbegin="15000000";
            pend="30000000";
        }
        if(price.compareTo("30")==0){
            pbegin="30000000";
        }
        
        ProductDAO pd = new ProductDAO();
        List<Product> lp = pd.getProductsByFilter(pbegin, pend, ram, rom, brand);
        for(Product p:lp){
            p.setPrice(editPrice(p.getPrice()));
        }
        
        request.setAttribute("listproduct", lp);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
