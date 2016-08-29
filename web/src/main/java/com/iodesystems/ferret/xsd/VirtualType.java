package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class VirtualType extends HasId {
    @XmlElement(name = "field")
    private List<VirtualTypeField> virtualTypeFields;

    public List<VirtualTypeField> getVirtualTypeFields() {
        return virtualTypeFields;
    }

    public void setVirtualTypeFields(List<VirtualTypeField> virtualTypeFields) {
        this.virtualTypeFields = virtualTypeFields;
    }
}
