package Notices;

import java.time.LocalDateTime;

public class Notice {
    private int notificationId;
    private String title;
    private String message;
    private LocalDateTime timestamp;

    // Getters and Setters
    public int getNotificationId() { return notificationId; }
    public void setNotificationId(int notificationId) { this.notificationId = notificationId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    
	@Override
	public String toString() {
		return "Notice [notificationId=" + notificationId + ", title=" + title + ", message=" + message + ", timestamp="
				+ timestamp + "]";
	}
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notice(int notificationId, String title, String message, LocalDateTime timestamp) {
		super();
		this.notificationId = notificationId;
		this.title = title;
		this.message = message;
		this.timestamp = timestamp;
	}
    
    
}
