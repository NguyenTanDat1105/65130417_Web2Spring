<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    String hoTen = "Nguyễn Tấn Đạt";
    String viTri = "Sinh viên Công nghệ thông tin";
    String ngaySinh = "11/05/2005";
    String soDienThoai = "0325 706 974";
    String email = "dat.nt.65cntt@gmail.com";
    String diaChi = "659/10 đường Lương Định Của, phường Tây Nha Trang, Khánh Hòa";
    
    String tenFileAnh = "avata.png"; 

    String truong = "Đại học Nha Trang (NTU)";
    String chuyenNganh = "Công nghệ thông tin (Chất lượng cao)";
    String lop = "65.CNTT-CLC";
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>CV - <%= hoTen %></title>
    
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #e9ecef; margin: 0; padding: 20px; }
        
        .cv-container { max-width: 900px; margin: 0 auto; background-color: white; display: flex; box-shadow: 0 0 20px rgba(0,0,0,0.1); }
        
        .left-column { width: 35%; background-color: #2c3e50; color: white; padding: 30px; text-align: center; }
        .avatar-box { width: 150px; height: 150px; margin: 0 auto 20px; border-radius: 50%; border: 5px solid #34495e; overflow: hidden; background-color: white; }
        .avatar-box img { width: 100%; height: 100%; object-fit: cover; }
        
        .contact-info { text-align: left; margin-top: 30px; font-size: 14px; }
        .contact-item { margin-bottom: 15px; word-break: break-all; }
        
        .skill-list { text-align: left; margin-top: 30px; }
        .skill-item { background-color: #34495e; padding: 5px 10px; margin-bottom: 5px; border-radius: 4px; font-size: 14px; }

        .right-column { width: 65%; padding: 40px; }
        h1 { margin: 0; color: #2c3e50; text-transform: uppercase; font-size: 32px; }
        .job-title { color: #7f8c8d; font-size: 18px; margin-bottom: 30px; font-weight: bold; }
        .section-title { color: #2980b9; border-bottom: 2px solid #2980b9; padding-bottom: 5px; margin-top: 30px; margin-bottom: 15px; text-transform: uppercase; letter-spacing: 1px; }
        
        .content-block { margin-bottom: 20px; }
        .school-name { font-weight: bold; font-size: 16px; }
        .time-period { color: #7f8c8d; font-size: 13px; font-style: italic; }
    </style>
</head>
<body>

    <div class="cv-container">

        <div class="left-column">
            <div class="avatar-box">
                <img src="<%= request.getContextPath() %>/<%= tenFileAnh %>" alt="Avatar">
            </div>
            
            <div class="contact-info">
                <h3>LIÊN HỆ</h3>
                <div class="contact-item">📞 <%= soDienThoai %></div>
                <div class="contact-item">📧 <%= email %></div>
                <div class="contact-item">🏠 <%= diaChi %></div>
                <div class="contact-item">🎂 <%= ngaySinh %></div>
            </div>

            <div class="skill-list">
                <h3>KỸ NĂNG</h3>
                <div class="skill-item">HTML / CSS Basic</div>
                <div class="skill-item">Tiếng Anh (Cơ bản)</div>
                <div class="skill-item">Làm việc nhóm</div>
            </div>
        </div>

        <div class="right-column">
            <h1><%= hoTen %></h1>
            <div class="job-title"><%= viTri %></div>

            <h3 class="section-title">Mục tiêu nghề nghiệp</h3>
            <p>Mong muốn trở thành một Lập trình viên Fullstack chuyên nghiệp. Hiện tại đang tập trung rèn luyện tư duy lập trình Java và xây dựng các ứng dụng Web cơ bản.</p>

            <h3 class="section-title">Học vấn</h3>
            <div class="content-block">
                <div class="school-name"><%= truong %></div>
                <div class="time-period">2023 - Hiện tại</div>
                <p>Chuyên ngành: <%= chuyenNganh %></p>
                <p>Lớp: <%= lop %></p>
            </div>

            <h3 class="section-title">Dự án cá nhân</h3>
            
            <div class="content-block">
                <div class="school-name">Web Bán Hàng (JSP/Servlet)</div>
                <p>Xây dựng trang web bán hàng đơn giản áp dụng mô hình MVC.</p>
                <ul>
                    <li>Chức năng: Đăng nhập, Xem sản phẩm, Giỏ hàng.</li>
                    <li>Công nghệ: Java Servlet, HTML, CSS.</li>
                </ul>
            </div>
        </div>

    </div>

</body>
</html>