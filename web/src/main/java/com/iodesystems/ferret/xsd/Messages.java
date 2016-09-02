package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Messages {

    private List<Message> message;

    public List<Message> getMessage() {
        return message;
    }

    @XmlElement(name = "message")
    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
