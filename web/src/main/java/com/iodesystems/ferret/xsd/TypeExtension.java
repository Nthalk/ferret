package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;

public class TypeExtension extends HasId {

    private String extensionTypeId;

    private SearchType search;

    public SearchType getSearch() {
        return search;
    }

    @XmlAttribute
    public void setSearch(SearchType search) {
        this.search = search;
    }

    public String getExtensionTypeId() {
        return extensionTypeId;
    }

    @XmlAttribute(required = true, name = "extends")
    @XmlSchemaType(name = "IDREF")
    public void setExtensionTypeId(String extensionTypeId) {
        this.extensionTypeId = extensionTypeId;
    }

}
