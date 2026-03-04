<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="models.TuVung, models.FileHandler, java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Từ điển Anh-Việt Mini</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600;700&display=swap" rel="stylesheet">
    
    <style>
        :root {
            --primary-color: #3498db;
            --success-color: #27ae60;
            --danger-color: #e74c3c;
            --bg-color: #f0f2f5;
            --text-dark: #2c3e50;
        }

        body {
            font-family: 'Inter', sans-serif;
            background-color: var(--bg-color);
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            color: var(--text-dark);
        }

        .dictionary-card {
		    background: white;
		    width: 90%;          
		    max-width: 450px;
		    padding: 30px;       
		    border-radius: 20px;
		    box-shadow: 0 15px 35px rgba(0,0,0,0.1);
		    text-align: center;
		    box-sizing: border-box; 
		    margin: 20px;
		}

        h1 {
            font-size: 24px;
            margin-bottom: 5px;
            color: var(--primary-color);
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        .subtitle {
            font-size: 14px;
            color: #7f8c8d;
            margin-bottom: 30px;
        }

        /* Form Tra Cứu */
        .search-group {
		    display: flex;
		    gap: 10px;
		    margin-bottom: 15px;
		    width: 100%;
		}

        input[type="text"] {
            flex: 1;
            padding: 12px 15px;
            border: 2px solid #e0e0e0;
            border-radius: 10px;
            font-size: 16px;
            transition: all 0.3s ease;
        }

        input[type="text"]:focus {
            border-color: var(--primary-color);
            outline: none;
            box-shadow: 0 0 8px rgba(52, 152, 219, 0.2);
        }

        .btn {
            padding: 12px 20px;
            border: none;
            border-radius: 10px;
            font-weight: 600;
            cursor: pointer;
            transition: 0.3s;
            text-decoration: none;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            font-size: 15px;
        }

        .btn-search {
            background-color: var(--primary-color);
            color: white;
        }

        .btn-search:hover { background-color: #2980b9; }

        .btn-list {
		    background-color: var(--success-color);
		    color: white;
		    display: block;       
		    width: 100%;           
		    margin: 15px 0;       
		    box-sizing: border-box; 
		    text-align: center;
		}

        .btn-list:hover { background-color: #219150; }

        /* Vùng hiển thị kết quả */
        .result-box {
            margin-top: 30px;
            padding: 20px;
            background: #f8fbff;
            border-radius: 12px;
            border-left: 6px solid var(--primary-color);
            text-align: left;
            animation: fadeIn 0.5s ease;
        }

        .result-word {
            font-size: 22px;
            font-weight: 700;
            color: var(--primary-color);
            margin: 0 0 10px 0;
        }

        .result-mean {
            font-size: 18px;
            font-weight: 600;
            color: #34495e;
            margin-bottom: 10px;
        }

        .result-ex {
            font-size: 14px;
            font-style: italic;
            color: #7f8c8d;
            line-height: 1.5;
        }

        /* Thông báo không tìm thấy */
        .not-found-box {
            margin-top: 20px;
            padding: 15px;
            background: #fff5f5;
            border: 1px dashed var(--danger-color);
            border-radius: 12px;
        }

        .add-new-form {
            margin-top: 15px;
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        .add-new-form input {
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(10px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>

<div class="dictionary-card">
    <h1>Smart Dictionary</h1>

    <form action="handleTuDien.jsp" method="get">
        <div class="search-group">
            <input type="text" name="keyword" placeholder="Nhập từ tiếng Anh..." required autocomplete="off">
            <button type="submit" name="action" value="search" class="btn btn-search">Tra từ</button>
        </div>
    </form>

    <a href="danhsach.jsp" class="btn btn-list">
        📖 Xem tất cả từ vựng
    </a>

    <hr style="margin: 30px 0; border: 0; border-top: 1px solid #eee;">

    <%
        // Lấy kết quả từ session sau khi handleTuDien.jsp xử lý
        TuVung res = (TuVung) session.getAttribute("searchResult");
        String lastKey = (String) session.getAttribute("lastKeyword");

        if (res != null) {
    %>
        <div class="result-box">
            <p class="result-word"><%= res.getTiengAnh() %></p>
            <div class="result-mean"><%= res.getTiengViet() %></div>
            <div class="result-ex">
                <strong>Ví dụ:</strong> <%= res.getViDu() %>
            </div>
        </div>
    <%
        } else if (lastKey != null && !lastKey.isEmpty()) {
    %>
        <div class="not-found-box">
            <p style="color: var(--danger-color); font-weight: 600;">
                Không tìm thấy từ: "<%= lastKey %>"
            </p>
            <p style="font-size: 13px;">Bạn có muốn đóng góp từ này vào từ điển?</p>
            
            <form action="handleTuDien.jsp" method="post" class="add-new-form">
                <input type="hidden" name="eng" value="<%= lastKey %>">
                <input type="text" name="vie" placeholder="Nghĩa tiếng Việt..." required>
                <input type="text" name="ex" placeholder="Ví dụ minh họa..." required>
                <button type="submit" name="action" value="add" class="btn btn-search" style="background-color: var(--success-color);">
                    Lưu vào từ điển
                </button>
            </form>
        </div>
    <%
        }
    %>
</div>

</body>
</html>