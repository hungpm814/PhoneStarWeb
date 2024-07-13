/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.BrandDAO;
import dal.PhoneDAO;
import dal.VersionDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Brand;
import model.Phone;
import model.Version;

/**
 *
 * @author PC
 */
public class AddServlet extends HttpServlet {
   
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
        BrandDAO bd = new BrandDAO();
        
        HttpSession sess = request.getSession();
        
        List<Version> lv = vd.getAll();
        List<Brand> lb = bd.getAll();
        
        sess.setAttribute("lv", lv);
        sess.setAttribute("lb", lb);
        request.getRequestDispatcher("add.jsp").forward(request, response);
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
        
        String type = request.getParameter("type");
        
        
        
        if (type != null && type.equals("1")) {
            try {
                String phoneName = request.getParameter("phoneName");
                String os = request.getParameter("os");
                int ram = Integer.parseInt(request.getParameter("ram"));
                String detail = request.getParameter("detail");
                int camera = Integer.parseInt(request.getParameter("camera"));
                int year = Integer.parseInt(request.getParameter("year"));
                String chip = request.getParameter("chip");
                String screen = request.getParameter("screen");
                int brandID = Integer.parseInt(request.getParameter("brand"));
                
                VersionDAO vd = new VersionDAO();
                List<Version> li = vd.getAll();
                boolean check = true;
                
                for (Version v : li) {
                    if (v.getPhoneName().equals(phoneName)) {
                        check = false;
                        break;
                    }
                }
                
                Version v = new Version(phoneName, os, ram, detail, camera, year, chip, screen, brandID);
                
                if (check) {
                    vd.insert(v);
                    String mes = "Thêm sản phẩm thành công!";
                    List<Version> lv = vd.getAll();
                    HttpSession sess = request.getSession();
                    sess.setAttribute("lv", lv);
                    request.setAttribute("mes1", mes);
                } else {
                    String mes = "Thêm sản phẩm thất bại!";
                    request.setAttribute("mes1", mes);
                }
                request.getRequestDispatcher("add.jsp").forward(request, response);
                
            } catch (NumberFormatException f) {
                String mes = "Thêm sản phẩm thất bại!";
                request.setAttribute("mes1", mes);
                request.getRequestDispatcher("add.jsp").forward(request, response);
            }
        }
        
        if (type != null && type.equals("2")) {
    try {
        
        String series = request.getParameter("series");
        String phoneName = request.getParameter("phoneName");
        String color = request.getParameter("color");
        String rom = request.getParameter("rom");
        String price = request.getParameter("price");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String date = "";
        String image = request.getParameter("image");
        
        PhoneDAO pd = new PhoneDAO();
        List<Phone> li = pd.getAll();
        boolean check = true;
        
        for (Phone p : li) {
            if (p.getSeries().equals(series)) {
                check = false;
                break;
            }
        }
        
        Phone phone = new Phone(series, phoneName, color, rom, price, quantity, date, image);
        
        if (check) {
            pd.insert(phone);
            String mes = "Thêm sản phẩm thành công!";
            request.setAttribute("mes2", mes);
        } else {
            String mes = "Thêm sản phẩm thất bại! Mã điện thoại đã tồn tại!";
            request.setAttribute("mes2", mes);
        }
        request.getRequestDispatcher("add.jsp").forward(request, response);
    } catch (NumberFormatException f) {
        String mes = "Thêm sản phẩm thất bại!";
        request.setAttribute("mes2", mes);
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }
}

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
