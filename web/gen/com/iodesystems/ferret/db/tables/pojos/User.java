/**
 * This class is generated by jOOQ
 */
package com.iodesystems.ferret.db.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User implements Serializable {

    private static final long serialVersionUID = 1990265216;

    private Integer id;
    private String  email;
    private String  passwordHash;

    public User() {}

    public User(User value) {
        this.id = value.id;
        this.email = value.email;
        this.passwordHash = value.passwordHash;
    }

    public User(
        Integer id,
        String  email,
        String  passwordHash
    ) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("User (");

        sb.append(id);
        sb.append(", ").append(email);
        sb.append(", ").append(passwordHash);

        sb.append(")");
        return sb.toString();
    }
}
