package org.alfac.cyclone.model;

import org.alfac.cyclone.common.persistence.JPAEntity;

import javax.persistence.*;
import java.util.Date;

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
public class User implements JPAEntity<Long> {

    @Id
    @Column(name = UserTable.ColumnName.USER_ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = UserTable.ID_GENERATOR_NAME)
    private Long id;

    @Column(name = UserTable.ColumnName.USER_NAME, length = UserTable.ColumnLength.USER_NAME, nullable = false)
    private String userName;

    @Column(name = UserTable.ColumnName.PASSWORD, length = UserTable.ColumnLength.PASSWORD, nullable = false)
    private String password;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = UserTable.ColumnName.PERSON_ID, nullable = false)
    private Person person;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = UserTable.ColumnName.CREATE_DATE, nullable = false, insertable = true, updatable = false)
    private Date createDate;

    @Version
    @Column(name = UserTable.ColumnName.VERSION, nullable = false)
    private Long version;

    @Override
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @PrePersist
    public void prePersist() {
        if (null == createDate) {
            createDate = new Date();
        }
    }
}
