<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="models.TuVung, models.FileHandler, java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách từ điển</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: #f4f7f6; padding: 40px; }
        .container { max-width: 900px; margin: auto; background: white; padding: 20px; border-radius: 12px; box-shadow: 0 5px 15px rgba(0,0,0,0.1); }
        h2 { text-align: center; color: #2c3e50; border-bottom: 2px solid #3498db; padding-bottom: 10px; }
        
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #eee; }
        th { background-color: #3498db; color: white; text-transform: uppercase; font-size: 14px; }
        tr:hover { background-color: #f9f9f9; }
        
        .btn-back { display: inline-block; margin-bottom: 20px; text-decoration: none; color: #3498db; font-weight: bold; border: 1px solid #3498db; padding: 8px 15px; border-radius: 5px; transition: 0.3s; }
        .btn-back:hover { background: #3498db; color: white; }
        
        .badge { background: #e8f4fd; color: #2980b9; padding: 3px 8px; border-radius: 4px; font-size: 12px; font-weight: bold; }
    </style>
</head>
<body>

<div class="container">
    <a href="tudien.jsp" class="btn-back">← Quay lại trang tra cứu</a>
    <h2>TẤT CẢ TỪ VỰNG TRONG TỪ ĐIỂN</h2>

    <table>
        <thead>
            <tr>
                <th style="width: 50px;">STT</th>
                <th style="width: 150px;">Tiếng Anh</th>
                <th style="width: 200px;">Tiếng Việt</th>
                <th>Ví dụ sử dụng</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Sử dụng đường dẫn tuyệt đối như bạn đã sửa ở bước trước
                String path = "D:/WEB 2/65130417_Web2Spring/TuDienAnhViet/src/main/webapp/WEB-INF/vocabulary.txt"; 
                FileHandler handler = new FileHandler(path);
                ArrayList<TuVung> list = handler.readData();

                if (list != null && !list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        TuVung tv = list.get(i);
            %>
                <tr>
                    <td><%= i + 1 %></td>
                    <td><span class="badge"><%= tv.getTiengAnh() %></span></td>
                    <td><strong><%= tv.getTiengViet() %></strong></td>
                    <td style="font-style: italic; color: #666;"><%= tv.getViDu() %></td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr><td colspan="4" style="text-align:center;">Từ điển hiện đang trống!</td></tr>
            <% } %>
        </tbody>
    </table>
</div>

</body>
</html>