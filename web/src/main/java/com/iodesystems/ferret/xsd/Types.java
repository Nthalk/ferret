package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Types {

    private List<Type> types;

    private List<TypeExtension> typeExtensions;

    private List<ReferenceType> referenceTypes;

    private List<VirtualType> virtualTypes;

    public List<VirtualType> getVirtualTypes() {
        return virtualTypes;
    }

    @XmlElement(name = "virtualType")
    public void setVirtualTypes(List<VirtualType> virtualTypes) {
        this.virtualTypes = virtualTypes;
    }

    public List<ReferenceType> getReferenceTypes() {
        return referenceTypes;
    }

    @XmlElement(name = "referenceType")
    public void setReferenceTypes(List<ReferenceType> referenceTypes) {
        this.referenceTypes = referenceTypes;
    }

    public List<Type> getTypes() {
        return types;
    }

    @XmlElement(name = "type")
    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public List<TypeExtension> getTypeExtensions() {
        return typeExtensions;
    }

    @XmlElement(name = "typeExtension")
    public void setTypeExtensions(List<TypeExtension> typeExtensions) {
        this.typeExtensions = typeExtensions;
    }
}
