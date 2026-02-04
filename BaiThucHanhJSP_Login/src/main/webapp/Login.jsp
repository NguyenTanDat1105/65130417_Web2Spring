<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    String tenDangNhap = request.getParameter("username");
    String matKhau = request.getParameter("password");

    if (tenDangNhap == null) tenDangNhap = "";
    if (matKhau == null) matKhau = "";

    if (tenDangNhap.equals("NguyenTanDat") && matKhau.equals("11052005")) {
        
        response.sendRedirect("UserProfile.html");
        
    } else {
        response.sendRedirect("Login.html");
        
    }
%>