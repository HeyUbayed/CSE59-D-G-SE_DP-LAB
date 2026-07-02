interface MessageSender{
    void sendMessage(String message);
}
class EmailSender implements MessageSender{
    @Override 
    public void sendMessage(String message)
    {
        System.out.println("Sending email: " + message);
    }
}

class NotificationService{
    private MessageSender messgeSender;

    public NotificationService(MessageSender messageSender)
    {
        this.messgeSender = messageSender;
    }

    public void alertUser(String msg)
    {
        messgeSender.sendMessage(msg);
    }
}

class SMSSender implements MessageSender{
    @Override
    public void sendMessage(String message)
    {
        System.out.println("Sending SMS: " + message);
    }
}

public class Main3 {
    public static void main(String[] args)
    {
        MessageSender email = new EmailSender();
        NotificationService emailNotification = new NotificationService(email);

        emailNotification.alertUser("Your order has been shipped.");

        MessageSender sms = new SMSSender();
        NotificationService smsNotification = new NotificationService(sms);
        smsNotification.alertUser("Your OTP is 123456.");
    }
}
