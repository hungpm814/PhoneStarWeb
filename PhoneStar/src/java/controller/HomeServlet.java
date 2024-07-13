/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.ProductDAO;
import dal.VersionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.Version;

/**
 *
 * @author PC
 */
public class HomeServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        VersionDAO vd = new VersionDAO();
        ProductDAO pd = new ProductDAO();
            
        List<Version> lv = vd.getAll();
        List<Version> lnv = vd.getNewVersion();
        List<Product> lp = new ArrayList<>();
        List<Product> lnp = new ArrayList<>();
        String phoneName="";
        Product p = new Product();
        for(Version v:lv){
            phoneName = v.getPhoneName();
            p = pd.getProductByPhoneName(phoneName);
            if(p!=null) {
                p.setPrice(editPrice(p.getPrice()));
                lp.add(p);
            }
        }
        for(Version v:lnv){
            phoneName = v.getPhoneName();
            p = pd.getProductByPhoneName(phoneName);
            if(p!=null) {
                p.setPrice(editPrice(p.getPrice()));
                lnp.add(p);
            }
        }
        
        String mess = (String) request.getAttribute("checkbuy");
        request.setAttribute("checkbuy", mess);
        request.setAttribute("listnew", lnp);
        request.setAttribute("listproduct", lp);
        request.getRequestDispatcher("home.jsp").forward(request, response);
        
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
        processRequest(request, response);
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
