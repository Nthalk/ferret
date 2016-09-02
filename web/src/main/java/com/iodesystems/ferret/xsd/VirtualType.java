package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class VirtualType extends HasId {

    private List<VirtualTypeField> virtualTypeFields;

    public List<VirtualTypeField> getVirtualTypeFields() {
        return virtualTypeFields;
    }

    @XmlElement(name = "field")
    public void setVirtualTypeFields(List<VirtualTypeField> virtualTypeFields) {
        this.virtualTypeFields = virtualTypeFields;
    }
}
