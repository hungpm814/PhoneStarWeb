/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.BrandDAO;
import dal.PhoneDAO;
import dal.ProductDAO;
import dal.VersionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Brand;
import model.Phone;
import model.Product;
import model.Version;

/**
 *
 * @author PC
 */
public class ShowServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ShowServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShowServlet at " + request.getContextPath () + "</h1>");
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
        String phoneName = request.getParameter("phoneName");
        String color = request.getParameter("color");
        String rom = request.getParameter("rom");
        ProductDAO pd = new ProductDAO();
        VersionDAO vd = new VersionDAO();
        PhoneDAO phd = new PhoneDAO();
        BrandDAO bd = new BrandDAO();
        
        List<Phone> ltest = phd.getAll();
        //for(Phone i:ltest){
            //if(i.getQuantity()<=0) phd.delete(i.getSeries());
        //}
        
        Product p = pd.getProductByPhoneName(phoneName);
        p.setPrice(editPrice(p.getPrice()));
        if(color==null || color.length()==0){
            color=p.getColor().get(0);
        }
        
        if(rom==null || rom.length()==0){
            rom=p.getRom().get(0);
        }
        
        Version v = vd.getVersionByPhoneName(phoneName);
        Phone ph = phd.getPhoneByColorAndROMAndName(color, rom, phoneName);
        Brand b = bd.getBrandByID(v.getBrandID());
        if(ph==null || ph.getQuantity()<=0){
            ph = new Phone("Hết hàng");
        }
        else ph.setPrice(editPrice(ph.getPrice()));
        
        String mes1 = (String) request.getAttribute("mes1");
        
        request.setAttribute("mes1", mes1);
        request.setAttribute("mes", "Hết hàng");
        request.setAttribute("romm", rom);
        request.setAttribute("colorr", color);
        request.setAttribute("version", v);
        request.setAttribute("product", p);
        request.setAttribute("phone", ph);
        request.setAttribute("brand", b);
        request.getRequestDispatcher("show.jsp").forward(request, response);
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
        String phoneName = request.getParameter("phoneName");
        String color = request.getParameter("color");
        String rom = request.getParameter("rom");
        ProductDAO pd = new ProductDAO();
        VersionDAO vd = new VersionDAO();
        PhoneDAO phd = new PhoneDAO();
        BrandDAO bd = new BrandDAO();
        
        Product p = pd.getProductByPhoneName(phoneName);
        p.setPrice(editPrice(p.getPrice()));
        if(color==null || color.length()==0){
            color=p.getColor().get(0);
        }
        
        if(rom==null || rom.length()==0){
            rom=p.getRom().get(0);
        }
        
        Version v = vd.getVersionByPhoneName(phoneName);
        Phone ph = phd.getPhoneByColorAndROMAndName(color, rom, phoneName);
        Brand b = bd.getBrandByID(v.getBrandID());
        if(ph==null){
            ph = new Phone("Hết hàng");
        }
        else ph.setPrice(editPrice(ph.getPrice()));
        
        String mes1 = (String) request.getAttribute("mes1");
        
        request.setAttribute("mes1", mes1);
        request.setAttribute("mes", "Hết hàng");
        request.setAttribute("romm", rom);
        request.setAttribute("colorr", color);
        request.setAttribute("version", v);
        request.setAttribute("product", p);
        request.setAttribute("phone", ph);
        request.setAttribute("brand", b);
        request.getRequestDispatcher("show.jsp").forward(request, response);
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
