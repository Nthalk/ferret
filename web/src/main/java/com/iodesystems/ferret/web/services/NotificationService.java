package com.iodesystems.ferret.web.services;

import com.iodesystems.ferret.web.models.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Component
public class NotificationService {

    @Autowired
    HttpSession httpSession;

    public void message(String type, String message) {
        ArrayList<Notification> messages = (ArrayList<Notification>) httpSession.getAttribute("notifications");
        if (messages == null) {
            messages = new ArrayList<>();
        }
        messages.add(new Notification(type, message));
        httpSession.setAttribute("notifications", messages);
    }

    public void success(String message) {
        message("success", message);
    }
}
