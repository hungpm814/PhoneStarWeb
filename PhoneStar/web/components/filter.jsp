
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="dal.BrandDAO" %>
<%@page import="dal.PhoneDAO" %>
<%@page import="dal.VersionDAO" %>
<%@page import="model.Brand" %>

<div class="filter">
          <h4 style="text-align: center; color: rgb(90, 72, 90);margin: 0; margin-left: 40px;">BỘ LỌC</h4>
          <hr style="color: black;height: 3px;">
</div>

<form action="filter" method="post" class="form-fil">

              <% 
                BrandDAO bd = new BrandDAO();
                PhoneDAO pd = new PhoneDAO();
                VersionDAO vd = new VersionDAO();
                List<Brand> lb = bd.getAll();
                List<Integer> lram = vd.getRAM();
                List<String> lrom = pd.getROM();
              %>
            <select name="brand" id="" class="filter-btn">
              <option value="0">Hãng</option>
              
              <% 
                for(Brand b:lb){
              %>
                <option value="<%= b.getBrandID() %>"><%= b.getBrandName() %></option>
              <% 
                }
              %>
            </select>

            <select name="price" id="" class="filter-btn">
              <option value="0">Giá</option>
              <option value="0-1">Dưới 1 triệu</option>
              <option value="1-5">1 triệu - 5 triệu</option>
              <option value="5-15">5 triệu - 15 triệu</option>
              <option value="15-30">15 triệu - 30 triệu</option>
              <option value="30">Trên 30 triệu</option>
            </select>

            <select name="ram" id="" class="filter-btn">
              <option value="0">RAM</option>
              <% 
                for(int r:lram){
              %>
                <option value="<%= r %>"><%= r %>GB</option>
              <% 
                }
              %>
            </select>

            <select name="rom" id="" class="filter-btn">
              <option value="0">Dung lượng bộ nhớ</option>
              <% 
                for(String r:lrom){
              %>
                <option value="<%= r %>"><%= r %></option>
              <% 
                }
              %>
            </select>

            <input type="submit" value="Lọc" class="submitfilter">

          </form>
