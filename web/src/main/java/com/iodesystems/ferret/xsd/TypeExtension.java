package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;

public class TypeExtension extends HasId {
    @XmlAttribute(required = true, name = "extends")
    @XmlSchemaType(name = "IDREF")
    private String extensionTypeId;
    @XmlAttribute
    private SearchType search;

    public SearchType getSearch() {
        return search;
    }

    public void setSearch(SearchType search) {
        this.search = search;
    }

    public String getExtensionTypeId() {
        return extensionTypeId;
    }

    public void setExtensionTypeId(String extensionTypeId) {
        this.extensionTypeId = extensionTypeId;
    }

}
