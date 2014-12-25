package org.alfac.cyclone.model;

import org.alfac.cyclone.framework.persistence.JPAEntity;
import org.alfac.cyclone.model.Constants.DegreeTable;
import org.alfac.cyclone.model.Constants.PromotionEntryTable;
import org.alfac.cyclone.model.Constants.PromotionPlanTable;
import org.apache.deltaspike.data.api.audit.CreatedOn;
import org.apache.deltaspike.data.api.audit.ModifiedOn;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Ivan
 */
@TableGenerator(
        name = PromotionEntryTable.ID_GENERATOR_NAME,
        pkColumnValue = PromotionEntryTable.TABLE_NAME,
        table = Constants.Sequence.TABLE_NAME,
        pkColumnName = Constants.Sequence.PK_COLUMN_NAME,
        valueColumnName = Constants.Sequence.VALUE_COLUMN_NAME,
        allocationSize = Constants.Sequence.ALLOCATION_SIZE)
@Entity
@Table(
        name = PromotionEntryTable.TABLE_NAME,
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {PromotionEntryTable.ColumnName.PROMOTION_PLAN_ID, PromotionEntryTable.ColumnName.POSITION}),
                @UniqueConstraint(columnNames = {PromotionEntryTable.ColumnName.PROMOTION_PLAN_ID, PromotionEntryTable.ColumnName.SOURCE_DEGREE_ID})
        }
)
public class PromotionEntry implements JPAEntity<Long> {

    @Id
    @Column(name = PromotionEntryTable.ColumnName.PROMOTION_ENTRY_ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = PromotionEntryTable.ID_GENERATOR_NAME)
    private Long id;

    @Column(name = PromotionEntryTable.ColumnName.POSITION, nullable = false)
    private Integer position;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = PromotionEntryTable.ColumnName.SOURCE_DEGREE_ID, referencedColumnName = DegreeTable.ColumnName.DEGREE_ID, nullable = false)
    private Degree sourceDegree;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = PromotionEntryTable.ColumnName.TARGET_DEGREE_ID, referencedColumnName = DegreeTable.ColumnName.DEGREE_ID, nullable = false)
    private Degree targetDegree;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = PromotionEntryTable.ColumnName.PROMOTION_PLAN_ID, referencedColumnName = PromotionPlanTable.ColumnName.PROMOTION_PLAN_ID, nullable = false)
    private PromotionPlan promotionPlan;

    @Column(name = PromotionEntryTable.ColumnName.LEAD_TIME, nullable = false)
    private Integer leadTime;

    @Enumerated(EnumType.STRING)
    @Column(name = PromotionEntryTable.ColumnName.LEAD_TIME_TYPE, length = PromotionEntryTable.ColumnLength.LEAD_TIME_TYPE, nullable = false)
    private LeadTimeType leadTimeType;

    @CreatedOn
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = PromotionEntryTable.ColumnName.CREATE_DATE, nullable = false, insertable = true, updatable = false)
    private Date createDate;

    @ModifiedOn
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = PromotionEntryTable.ColumnName.UPDATE_DATE)
    private Date updateDate;

    @Version
    @Column(name = PromotionEntryTable.ColumnName.VERSION, nullable = false)
    private Long version;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Degree getSourceDegree() {
        return sourceDegree;
    }

    public void setSourceDegree(Degree sourceDegree) {
        this.sourceDegree = sourceDegree;
    }

    public Degree getTargetDegree() {
        return targetDegree;
    }

    public void setTargetDegree(Degree targetDegree) {
        this.targetDegree = targetDegree;
    }

    public Integer getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Integer leadTime) {
        this.leadTime = leadTime;
    }

    public LeadTimeType getLeadTimeType() {
        return leadTimeType;
    }

    public void setLeadTimeType(LeadTimeType leadTimeType) {
        this.leadTimeType = leadTimeType;
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

    public PromotionPlan getPromotionPlan() {
        return promotionPlan;
    }

    public void setPromotionPlan(PromotionPlan promotionPlan) {
        this.promotionPlan = promotionPlan;
    }
}
