package org.alfac.cyclone.model;

import org.alfac.cyclone.common.persistence.JPAEntity;

import javax.persistence.*;
import java.util.Date;

import static org.alfac.cyclone.model.Constants.CountryTable;
import static org.alfac.cyclone.model.Constants.PersonTable;

/**
 * @author Ivan
 */
@TableGenerator(
        name = PersonTable.ID_GENERATOR_NAME,
        pkColumnValue = PersonTable.TABLE_NAME,
        table = Constants.Sequence.TABLE_NAME,
        pkColumnName = Constants.Sequence.PK_COLUMN_NAME,
        valueColumnName = Constants.Sequence.VALUE_COLUMN_NAME,
        allocationSize = Constants.Sequence.ALLOCATION_SIZE)
@Entity
@Table(name = PersonTable.TABLE_NAME)
public class Person implements JPAEntity<Long> {

    @Id
    @Column(name = PersonTable.ColumnName.PERSON_ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = PersonTable.ID_GENERATOR_NAME)
    private Long id;

    @Column(name = PersonTable.ColumnName.FIRST_NAME, length = PersonTable.ColumnLength.FIRST_NAME, nullable = false)
    private String firstName;

    @Column(name = PersonTable.ColumnName.MIDDLE_NAME, length = PersonTable.ColumnLength.MIDDLE_NAME)
    private String middleName;

    @Column(name = PersonTable.ColumnName.LAST_NAME, length = PersonTable.ColumnLength.LAST_NAME, nullable = false)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = PersonTable.ColumnName.BIRTHDAY)
    private Date birthday;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = PersonTable.ColumnName.BIRTH_COUNTRY_ID, referencedColumnName = CountryTable.ColumnName.COUNTRY_ID, nullable = false)
    private Country birthCountry;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = PersonTable.ColumnName.CREATE_DATE, nullable = false, insertable = true, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = PersonTable.ColumnName.UPDATE_DATE)
    private Date updateDate;

    @Version
    @Column(name = PersonTable.ColumnName.VERSION, nullable = false)
    private Long version;


    public Country getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(Country birthCountry) {
        this.birthCountry = birthCountry;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

    @PreUpdate
    public void preUpdate() {
        updateDate = new Date();
    }
}

