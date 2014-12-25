package org.alfac.cyclone.model;

import org.alfac.cyclone.framework.persistence.JPAEntity;
import org.alfac.cyclone.model.Constants.DegreeTable;
import org.apache.deltaspike.data.api.audit.CreatedOn;
import org.apache.deltaspike.data.api.audit.ModifiedOn;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Ivan
 */
@TableGenerator(
        name = DegreeTable.ID_GENERATOR_NAME,
        pkColumnValue = DegreeTable.TABLE_NAME,
        table = Constants.Sequence.TABLE_NAME,
        pkColumnName = Constants.Sequence.PK_COLUMN_NAME,
        valueColumnName = Constants.Sequence.VALUE_COLUMN_NAME,
        allocationSize = Constants.Sequence.ALLOCATION_SIZE)
@Entity
@Table(
        name = DegreeTable.TABLE_NAME,
        uniqueConstraints = @UniqueConstraint(columnNames = {DegreeTable.ColumnName.NAME})
)
public class Degree implements JPAEntity<Long> {

    @Id
    @Column(name = DegreeTable.ColumnName.DEGREE_ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = DegreeTable.ID_GENERATOR_NAME)
    private Long id;

    @Column(name = DegreeTable.ColumnName.NAME, length = DegreeTable.ColumnLength.NAME, nullable = false)
    private String name;

    @CreatedOn
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = DegreeTable.ColumnName.CREATE_DATE, nullable = false, insertable = true, updatable = false)
    private Date createDate;

    @ModifiedOn
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = DegreeTable.ColumnName.UPDATE_DATE)
    private Date updateDate;

    @Version
    @Column(name = DegreeTable.ColumnName.VERSION, nullable = false)
    private Long version;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
}
