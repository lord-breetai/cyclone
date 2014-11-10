package org.alfac.cyclone.model;

import org.alfac.cyclone.common.persistence.JPAEntity;

import javax.persistence.*;
import java.util.Date;

import static org.alfac.cyclone.model.Constants.CountryTable;

/**
 * @author Ivan
 */

@TableGenerator(
        name = CountryTable.ID_GENERATOR_NAME,
        pkColumnValue = CountryTable.TABLE_NAME,
        table = Constants.Sequence.TABLE_NAME,
        pkColumnName = Constants.Sequence.PK_COLUMN_NAME,
        valueColumnName = Constants.Sequence.VALUE_COLUMN_NAME,
        allocationSize = Constants.Sequence.ALLOCATION_SIZE)
@Entity
@Table(
        name = CountryTable.TABLE_NAME,
        uniqueConstraints = @UniqueConstraint(columnNames = {CountryTable.ColumnName.NAME}))
public class Country implements JPAEntity<Long> {

    @Id
    @Column(name = CountryTable.ColumnName.COUNTRY_ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = CountryTable.ID_GENERATOR_NAME)
    private Long id;

    @Column(name = CountryTable.ColumnName.NAME, length = CountryTable.ColumnLength.NAME, nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = CountryTable.ColumnName.CREATE_DATE, nullable = false, insertable = true, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = CountryTable.ColumnName.UPDATE_DATE)
    private Date updateDate;

    @Version
    @Column(name = CountryTable.ColumnName.VERSION, nullable = false)
    private Long version;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
