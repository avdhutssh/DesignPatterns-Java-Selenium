package company.utils;

public class NotificationService {
    public static void sendSmsNotification(String phoneNumber, String message) {
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}
