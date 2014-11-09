package org.alfac.cyclone.model;

import javax.persistence.*;

import static org.alfac.cyclone.model.Constants.UserTable;

/**
 * @author Ivan
 */
@TableGenerator(
        name = UserTable.ID_GENERATOR_NAME,
        pkColumnValue = UserTable.TABLE_NAME,
        table = Constants.Sequence.TABLE_NAME,
        pkColumnName = Constants.Sequence.PK_COLUMN_NAME,
        valueColumnName = Constants.Sequence.VALUE_COLUMN_NAME,
        allocationSize = Constants.Sequence.ALLOCATION_SIZE)

@Entity
@Table(name = UserTable.TABLE_NAME)
public class User {

    @Id
    @Column(name = UserTable.ColumnName.USER_ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = UserTable.ID_GENERATOR_NAME)
    private Long id;

    @Column(name = UserTable.ColumnName.USER_NAME, length = UserTable.ColumnLength.USER_NAME, nullable = false)
    private String userName;

    @Column(name = UserTable.ColumnName.PASSWORD, length = UserTable.ColumnLength.PASSWORD, nullable = false)
    private String password;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
