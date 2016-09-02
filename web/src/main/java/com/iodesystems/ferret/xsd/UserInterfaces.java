package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class UserInterfaces {

    private Messages messages;

    private List<UserInterface> userInterfaces;


    public List<UserInterface> getUserInterfaces() {
        return userInterfaces;
    }

    @XmlElement(name = "ui")
    public void setUserInterfaces(List<UserInterface> userInterfaces) {
        this.userInterfaces = userInterfaces;
    }

    public Messages getMessages() {
        return messages;
    }

    @XmlElement(name = "messages")
    public void setMessages(Messages messages) {
        this.messages = messages;
    }
}
