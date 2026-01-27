import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AboutMe")
public class AboutMe extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AboutMe() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();

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
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>CV - " + hoTen + "</title>");
        
        out.println("<style>");
        out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #e9ecef; margin: 0; padding: 20px; }");
        
        out.println(".cv-container { max-width: 900px; margin: 0 auto; background-color: white; display: flex; box-shadow: 0 0 20px rgba(0,0,0,0.1); }");
        
        out.println(".left-column { width: 35%; background-color: #2c3e50; color: white; padding: 30px; text-align: center; }");
        out.println(".avatar-box { width: 150px; height: 150px; margin: 0 auto 20px; border-radius: 50%; border: 5px solid #34495e; overflow: hidden; }");
        out.println(".avatar-box img { width: 100%; height: 100%; object-fit: cover; }");
        out.println(".contact-info { text-align: left; margin-top: 30px; font-size: 14px; }");
        out.println(".contact-item { margin-bottom: 15px; word-break: break-all; }");
        out.println(".skill-list { text-align: left; margin-top: 30px; }");
        out.println(".skill-item { background-color: #34495e; padding: 5px 10px; margin-bottom: 5px; border-radius: 4px; font-size: 14px; }");

        out.println(".right-column { width: 65%; padding: 40px; }");
        out.println("h1 { margin: 0; color: #2c3e50; text-transform: uppercase; font-size: 32px; }");
        out.println(".job-title { color: #7f8c8d; font-size: 18px; margin-bottom: 30px; font-weight: bold; }");
        out.println(".section-title { color: #2980b9; border-bottom: 2px solid #2980b9; padding-bottom: 5px; margin-top: 30px; margin-bottom: 15px; text-transform: uppercase; letter-spacing: 1px; }");
        out.println(".content-block { margin-bottom: 20px; }");
        out.println(".school-name { font-weight: bold; font-size: 16px; }");
        out.println(".time-period { color: #7f8c8d; font-size: 13px; font-style: italic; }");
        
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div class='cv-container'>");


        out.println("  <div class='left-column'>");

        out.println("    <div class='avatar-box'>");
        out.println("      <img src='" + request.getContextPath() + "/" + tenFileAnh + "' alt='Avatar'>");
        out.println("    </div>");
        

        out.println("    <div class='contact-info'>");
        out.println("       <h3>LIÊN HỆ</h3>");
        out.println("       <div class='contact-item'>📞 " + soDienThoai + "</div>");
        out.println("       <div class='contact-item'>📧 " + email + "</div>");
        out.println("       <div class='contact-item'>🏠 " + diaChi + "</div>");
        out.println("       <div class='contact-item'>🎂 " + ngaySinh + "</div>");
        out.println("    </div>");

        out.println("    <div class='skill-list'>");
        out.println("       <h3>KỸ NĂNG</h3>");
        out.println("       <div class='skill-item'>Java Core / Servlet</div>");
        out.println("       <div class='skill-item'>HTML / CSS Basic</div>");
        out.println("       <div class='skill-item'>Tiếng Anh (Cơ bản)</div>");
        out.println("       <div class='skill-item'>Làm việc nhóm</div>");
        out.println("    </div>");
        out.println("  </div>");

        out.println("  <div class='right-column'>");
        out.println("    <h1>" + hoTen + "</h1>");
        out.println("    <div class='job-title'>" + viTri + "</div>");

        out.println("    <h3 class='section-title'>Mục tiêu nghề nghiệp</h3>");
        out.println("    <p>Mong muốn trở thành một Lập trình viên Fullstack chuyên nghiệp. Hiện tại đang tập trung rèn luyện tư duy lập trình Java và xây dựng các ứng dụng Web cơ bản.</p>");

        out.println("    <h3 class='section-title'>Học vấn</h3>");
        out.println("    <div class='content-block'>");
        out.println("       <div class='school-name'>" + truong + "</div>");
        out.println("       <div class='time-period'>2023 - Hiện tại</div>");
        out.println("       <p>Chuyên ngành: " + chuyenNganh + "</p>");
        out.println("       <p>Lớp: " + lop + "</p>");
        out.println("    </div>");

        out.println("    <h3 class='section-title'>Dự án cá nhân</h3>");
        
        out.println("    <div class='content-block'>");
        out.println("       <div class='school-name'>Web Bán Hàng (JSP/Servlet)</div>");
        out.println("       <p>Xây dựng trang web bán hàng đơn giản áp dụng mô hình MVC.</p>");
        out.println("       <ul>");
        out.println("           <li>Chức năng: Đăng nhập, Xem sản phẩm, Giỏ hàng.</li>");
        out.println("           <li>Công nghệ: Java Servlet, HTML, CSS.</li>");
        out.println("       </ul>");
        out.println("    </div>");

        out.println("  </div>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}