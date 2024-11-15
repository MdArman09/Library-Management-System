<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notifications</title>
    <link rel="stylesheet" href="Notice.css">
</head>
<body>
    <div class="admin-header">
        <h1>Notice/Alertments</h1>
        <button class="back-btn" onclick="history.back()">Back</button>
    </div>

    <div class="admin-form-container">
        <h1>My Notifications</h1>
        <table class="notifications-table">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Message</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="notice" items="${notifications}">
                    <tr>
                        <td>${notice.title}</td>
                        <td>${notice.message}</td>
                        <td>${notice.timestamp}</td>
                        <td>${notice.status ? "Read" : "Unread"}</td>
                        <td>
                            <form action="markAsReadServlet" method="post">
                                <input type="hidden" name="notificationId" value="${notice.notificationId}">
                                <button type="submit" class="mark-read-btn" ${notice.status ? "disabled" : ""}>
                                    Mark as Read
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
