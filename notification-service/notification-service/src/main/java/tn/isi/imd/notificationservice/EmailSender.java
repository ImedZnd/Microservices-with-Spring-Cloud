package tn.isi.imd.notificationservice;

import org.springframework.stereotype.Service;


@Service
public class EmailSender {
    public void sendEmail(String message) {
        System.out.println("Sendin Email For order number "+ message);
        System.out.println("Email sent");
    }
}
