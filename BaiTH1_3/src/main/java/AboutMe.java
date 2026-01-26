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
        String lop = "65.CNTT-CLC";
        String maSV = "65130417";
        String soThich = "Lập trình Web, Nghe nhạc, Chơi game, Chơi thể thao";
        
        String tenFileAnh = "avata.png"; 

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>About Me - " + hoTen + "</title>");

        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f0f2f5; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
        out.println(".card { background-color: white; padding: 30px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); width: 400px; text-align: center; }");
        

        out.println(".avatar { width: 120px; height: 120px; border-radius: 50%; margin: 0 auto 20px; border: 3px solid #007bff; overflow: hidden; }");
        out.println(".avatar img { width: 100%; height: 100%; object-fit: cover; }");
        
        out.println("h2 { color: #333; margin-bottom: 5px; }");
        out.println("p { color: #666; margin: 5px 0; }");
        out.println(".info-box { text-align: left; margin-top: 20px; border-top: 1px solid #eee; padding-top: 20px; }");
        out.println("b { color: #007bff; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div class='card'>");
        
        out.println("   <div class='avatar'>");
        out.println("       <img src='" + request.getContextPath() + "/" + tenFileAnh + "' alt='Avatar'>");
        out.println("   </div>");
        
        out.println("   <h2>" + hoTen + "</h2>");
        out.println("   <p>Sinh viên CNTT</p>");
        
        out.println("   <div class='info-box'>");
        out.println("       <p><b>Lớp:</b> " + lop + "</p>");
        out.println("       <p><b>Mã SV:</b> " + maSV + "</p>");
        out.println("       <p><b>Sở thích:</b> " + soThich + "</p>");
        out.println("       <p><b>Trường:</b> Đại học Nha Trang</p>");
        out.println("   </div>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}