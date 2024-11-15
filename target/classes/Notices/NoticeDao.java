package Notices;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeDao {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void addNotification(Notice notification) {
        String sql = "INSERT INTO notifications (title, message, timestamp) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "yash", "yash1234");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, notification.getTitle());
            stmt.setString(2, notification.getMessage());
            stmt.setTimestamp(3, Timestamp.valueOf(notification.getTimestamp()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Notice> getAllNotifications() {
        String sql = "SELECT * FROM notifications ORDER BY timestamp DESC";
        List<Notice> info = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "yash", "yash1234");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Notice notice = new Notice();
                notice.setNotificationId(rs.getInt("notificationId"));
                notice.setTitle(rs.getString("title"));
                notice.setMessage(rs.getString("message"));
                notice.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime());

                info.add(notice);
            }

            System.out.println("Notifications fetched from DB: " + info.size());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return info;
    }


}
