<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="models.TuVung, models.FileHandler, java.util.ArrayList" %>

<%
    // Lấy đường dẫn thực tế của file trong WEB-INF
	String path = "D:/WEB 2/65130417_Web2Spring/TuDienAnhViet/src/main/webapp/WEB-INF/vocabulary.txt";    
	FileHandler handler = new FileHandler(path);
    
    // 1. Đọc dữ liệu từ file lên
    ArrayList<TuVung> dictionary = handler.readData();

    String action = request.getParameter("action");

    if ("search".equals(action)) {
        String keyword = request.getParameter("keyword").trim();
        TuVung found = null;
        for (TuVung tv : dictionary) {
            if (tv.getTiengAnh().toLowerCase().contains(keyword.toLowerCase())) {
                found = tv;
                break;
            }
        }
        session.setAttribute("searchResult", found);
        session.setAttribute("lastKeyword", keyword);
    } 
    else if ("add".equals(action)) {
        String eng = request.getParameter("eng").trim();
        String vie = request.getParameter("vie").trim();
        String ex = request.getParameter("ex").trim();
        
        // Thêm vào danh sách tạm
        dictionary.add(new TuVung(eng, vie, ex));
        
        // Ghi đè danh sách mới vào file .txt
        handler.writeData(dictionary);
        
        session.setAttribute("searchResult", null);
        session.setAttribute("lastKeyword", null);
    }

    response.sendRedirect("tudien.jsp");
%>