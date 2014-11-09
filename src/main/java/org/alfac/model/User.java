package org.alfac.model;

import javax.persistence.*;

@TableGenerator(name = "Project.tableGenerator",
        table = "sequence",
        pkColumnName = "tablename",
        valueColumnName = "value",
        allocationSize = 10,
        pkColumnValue = "user")

/**
 * @author Ivan
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "userid", nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Project.tableGenerator")
    private Long id;

    @Column(name = "email", length = 250, nullable = false)
    private String email;

    @Column(name = "password", length = 250, nullable = false)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
