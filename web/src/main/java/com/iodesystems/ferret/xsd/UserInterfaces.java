package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class UserInterfaces {
    @XmlElement(name = "messages")
    private Messages messages;
    @XmlElement(name = "ui")
    private List<UserInterface> userInterfaces;


    public List<UserInterface> getUserInterfaces() {
        return userInterfaces;
    }

    public void setUserInterfaces(List<UserInterface> userInterfaces) {
        this.userInterfaces = userInterfaces;
    }

    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }
}
