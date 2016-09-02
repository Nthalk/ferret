package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;

public class Type extends HasId {

    private SqlType sqlType;

    public SqlType getSqlType() {
        return sqlType;
    }

    @XmlAttribute(required = true)
    public void setSqlType(SqlType sqlType) {
        this.sqlType = sqlType;
    }
}
