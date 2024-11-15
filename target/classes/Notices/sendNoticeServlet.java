package Notices;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NotificationServlet")
public class sendNoticeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private NoticeDao noticeDao = new NoticeDao();

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String title = request.getParameter("title");
            String message = request.getParameter("message");
            Notice notice = new Notice();
            notice.setTitle(title);
            notice.setMessage(message);
            notice.setTimestamp(LocalDateTime.now());

            noticeDao.addNotification(notice);
            response.sendRedirect("settings.jsp");
        }
    }

