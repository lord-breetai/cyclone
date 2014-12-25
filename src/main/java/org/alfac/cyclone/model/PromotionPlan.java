package org.alfac.cyclone.model;

import org.alfac.cyclone.framework.persistence.JPAEntity;
import org.alfac.cyclone.model.Constants.PromotionPlanTable;
import org.apache.deltaspike.data.api.audit.CreatedOn;
import org.apache.deltaspike.data.api.audit.ModifiedOn;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Ivan
 */
@TableGenerator(
        name = PromotionPlanTable.ID_GENERATOR_NAME,
        pkColumnValue = PromotionPlanTable.TABLE_NAME,
        table = Constants.Sequence.TABLE_NAME,
        pkColumnName = Constants.Sequence.PK_COLUMN_NAME,
        valueColumnName = Constants.Sequence.VALUE_COLUMN_NAME,
        allocationSize = Constants.Sequence.ALLOCATION_SIZE)
@Entity
@Table(
        name = PromotionPlanTable.TABLE_NAME,
        uniqueConstraints = @UniqueConstraint(columnNames = {PromotionPlanTable.ColumnName.CODE})
)
public class PromotionPlan implements JPAEntity<Long> {

    @Id
    @Column(name = PromotionPlanTable.ColumnName.PROMOTION_PLAN_ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = PromotionPlanTable.ID_GENERATOR_NAME)
    private Long id;

    @Column(name = PromotionPlanTable.ColumnName.CODE, length = PromotionPlanTable.ColumnLength.CODE, nullable = false)
    private String code;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "promotionPlan")
    private List<PromotionEntry> promotionTable;

    @CreatedOn
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = PromotionPlanTable.ColumnName.CREATE_DATE, nullable = false, insertable = true, updatable = false)
    private Date createDate;

    @ModifiedOn
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = PromotionPlanTable.ColumnName.UPDATE_DATE)
    private Date updateDate;

    @Version
    @Column(name = PromotionPlanTable.ColumnName.VERSION, nullable = false)
    private Long version;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public List<PromotionEntry> getPromotionTable() {
        return promotionTable;
    }

    public void setPromotionTable(List<PromotionEntry> promotionTable) {
        this.promotionTable = promotionTable;
    }
}
