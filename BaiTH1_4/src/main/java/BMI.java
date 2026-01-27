import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/BMI")
public class BMI extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BMI() {
        super();
    }

    private String getCommonCSS() {
        return "<style>"
             + "@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap');"
             + "body { font-family: 'Poppins', sans-serif; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }"
             + ".card { background: white; padding: 40px; border-radius: 20px; box-shadow: 0 10px 25px rgba(0,0,0,0.2); width: 380px; text-align: center; animation: fadeIn 0.5s ease-in-out; }"
             + "h2 { color: #333; margin-bottom: 25px; font-weight: 600; }"
             + "label { display: block; text-align: left; margin-bottom: 8px; color: #555; font-weight: 500; font-size: 14px; }"
             + "input[type='text'] { width: 100%; padding: 12px 15px; margin-bottom: 20px; border: 2px solid #eee; border-radius: 10px; box-sizing: border-box; font-size: 16px; transition: 0.3s; outline: none; }"
             + "input[type='text']:focus { border-color: #764ba2; }"
             + ".btn-submit { width: 100%; padding: 12px; background: linear-gradient(to right, #667eea, #764ba2); color: white; border: none; border-radius: 10px; font-size: 16px; font-weight: bold; cursor: pointer; transition: transform 0.2s; }"
             + ".btn-submit:hover { transform: scale(1.02); box-shadow: 0 5px 15px rgba(118, 75, 162, 0.4); }"
             + ".btn-back { display: inline-block; margin-top: 20px; text-decoration: none; color: #764ba2; font-weight: 600; }"
             + "@keyframes fadeIn { from { opacity: 0; transform: translateY(-20px); } to { opacity: 1; transform: translateY(0); } }"
             + ".result-box { margin-top: 20px; padding: 20px; border-radius: 15px; }"
             + ".bmi-value { font-size: 48px; font-weight: bold; margin: 0; }"
             + ".status-text { font-size: 18px; font-weight: 500; margin-top: 5px; text-transform: uppercase; letter-spacing: 1px; }"
             + ".normal { color: #2ecc71; background-color: #eafaf1; }"
             + ".warning { color: #f1c40f; background-color: #fef9e7; }" 
             + ".danger { color: #e74c3c; background-color: #fdedec; }" 
             + "</style>";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>BMI Calculator</title>" + getCommonCSS() + "</head>");
        out.println("<body>");

        out.println("<div class='card'>");
        out.println("  <h2>Kiểm tra sức khỏe</h2>");
        out.println("  <form method='POST' action='" + request.getContextPath() + "/BMI'>");
        
        out.println("    <label>Chiều cao (m)</label>");
        out.println("    <input type='text' name='height' placeholder='Ví dụ: 1.75' required>");
        
        out.println("    <label>Cân nặng (kg)</label>");
        out.println("    <input type='text' name='weight' placeholder='Ví dụ: 70' required>");
        
        out.println("    <button type='submit' class='btn-submit'>Xem kết quả ngay</button>");
        out.println("  </form>");
        out.println("</div>");

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String heightStr = request.getParameter("height");
        String weightStr = request.getParameter("weight");
        
        float bmi = 0;
        String ketQua = "";
        String cssClass = "";

        try {
            float height = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);
            bmi = weight / (height * height);

            if (bmi < 18.5) {
                ketQua = "Gầy (Thiếu cân)";
                cssClass = "warning";
            } else if (bmi < 24.9) {
                ketQua = "Cơ thể cân đối";
                cssClass = "normal";
            } else if (bmi < 29.9) {
                ketQua = "Thừa cân";
                cssClass = "warning";
            } else {
                ketQua = "Béo phì";
                cssClass = "danger";
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Kết quả BMI</title>" + getCommonCSS() + "</head>");
            out.println("<body>");

            out.println("<div class='card'>");
            out.println("  <h2>Kết quả phân tích</h2>");
            
            out.println("  <div class='result-box " + cssClass + "'>");
            out.printf("    <div class='bmi-value'>%.2f</div>", bmi);
            out.println("    <div class='status-text'>" + ketQua + "</div>");
            out.println("  </div>");

            out.println("  <p style='color: #666; margin-top: 20px; font-size: 13px;'>Chỉ số BMI chỉ mang tính chất tham khảo. Hãy duy trì chế độ ăn uống và luyện tập hợp lý nhé!</p>");
            
            out.println("  <a href='" + request.getContextPath() + "/BMI' class='btn-back'>← Kiểm tra lại</a>");
            out.println("</div>");

            out.println("</body></html>");

        } catch (NumberFormatException e) {
            out.println("<!DOCTYPE html><html><head><title>Lỗi</title>" + getCommonCSS() + "</head><body>");
            out.println("<div class='card'>");
            out.println("  <h2 style='color: #e74c3c;'>Lỗi nhập liệu!</h2>");
            out.println("  <p>Vui lòng nhập đúng định dạng số (dùng dấu chấm '.' cho số thập phân).</p>");
            out.println("  <a href='" + request.getContextPath() + "/BMI' class='btn-back'>Thử lại</a>");
            out.println("</div></body></html>");
        }
    }
}