package com.lucoo.boot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_level_detail")
public class UserLevelDetail {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 原等级编号
     */
    @Column(name = "old_level_id")
    private Long oldLevelId;

    /**
     * 当前等级编号
     */
    @Column(name = "current_level_id")
    private Long currentLevelId;

    /**
     * 原贡献值
     */
    @Column(name = "old_contribution")
    private Long oldContribution;

    /**
     * 当前贡献值
     */
    @Column(name = "current_contribution")
    private Long currentContribution;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取原等级编号
     *
     * @return old_level_id - 原等级编号
     */
    public Long getOldLevelId() {
        return oldLevelId;
    }

    /**
     * 设置原等级编号
     *
     * @param oldLevelId 原等级编号
     */
    public void setOldLevelId(Long oldLevelId) {
        this.oldLevelId = oldLevelId;
    }

    /**
     * 获取当前等级编号
     *
     * @return current_level_id - 当前等级编号
     */
    public Long getCurrentLevelId() {
        return currentLevelId;
    }

    /**
     * 设置当前等级编号
     *
     * @param currentLevelId 当前等级编号
     */
    public void setCurrentLevelId(Long currentLevelId) {
        this.currentLevelId = currentLevelId;
    }

    /**
     * 获取原贡献值
     *
     * @return old_contribution - 原贡献值
     */
    public Long getOldContribution() {
        return oldContribution;
    }

    /**
     * 设置原贡献值
     *
     * @param oldContribution 原贡献值
     */
    public void setOldContribution(Long oldContribution) {
        this.oldContribution = oldContribution;
    }

    /**
     * 获取当前贡献值
     *
     * @return current_contribution - 当前贡献值
     */
    public Long getCurrentContribution() {
        return currentContribution;
    }

    /**
     * 设置当前贡献值
     *
     * @param currentContribution 当前贡献值
     */
    public void setCurrentContribution(Long currentContribution) {
        this.currentContribution = currentContribution;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}