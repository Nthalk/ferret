package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Types {
    @XmlElement(name = "type")
    private List<Type> types;
    @XmlElement(name = "typeExtension")
    private List<TypeExtension> typeExtensions;
    @XmlElement(name = "referenceType")
    private List<ReferenceType> referenceTypes;
    @XmlElement(name = "virtualType")
    private List<VirtualType> virtualTypes;

    public List<VirtualType> getVirtualTypes() {
        return virtualTypes;
    }

    public void setVirtualTypes(List<VirtualType> virtualTypes) {
        this.virtualTypes = virtualTypes;
    }

    public List<ReferenceType> getReferenceTypes() {
        return referenceTypes;
    }

    public void setReferenceTypes(List<ReferenceType> referenceTypes) {
        this.referenceTypes = referenceTypes;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public List<TypeExtension> getTypeExtensions() {
        return typeExtensions;
    }

    public void setTypeExtensions(List<TypeExtension> typeExtensions) {
        this.typeExtensions = typeExtensions;
    }
}
