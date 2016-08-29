package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;

public class Type extends HasId {
    @XmlAttribute(required = true)
    private SqlType sqlType;

    public SqlType getSqlType() {
        return sqlType;
    }

    public void setSqlType(SqlType sqlType) {
        this.sqlType = sqlType;
    }
}
