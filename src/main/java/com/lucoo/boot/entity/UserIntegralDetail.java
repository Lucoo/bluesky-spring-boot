package com.lucoo.boot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_integral_detail")
public class UserIntegralDetail {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 积分数量
     */
    @Column(name = "total_count")
    private Integer totalCount;

    /**
     * 已使用积分数量
     */
    @Column(name = "use_count")
    private Integer useCount;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 过期时间
     */
    @Column(name = "overdue_time")
    private Date overdueTime;

    /**
     * 积分状态：0，未使用
1，使用中
2，已使用
3，已过期
     */
    @Column(name = "integral_status")
    private Byte integralStatus;

    /**
     * 修改人员
     */
    @Column(name = "update_user")
    private Long updateUser;

    /**
     * 操作理由
     */
    @Column(name = "operation_reason")
    private String operationReason;

    /**
     * 操作时间
     */
    @Column(name = "operation_time")
    private Date operationTime;

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
     * 获取用户编号
     *
     * @return user_id - 用户编号
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户编号
     *
     * @param userId 用户编号
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取积分数量
     *
     * @return total_count - 积分数量
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 设置积分数量
     *
     * @param totalCount 积分数量
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取已使用积分数量
     *
     * @return use_count - 已使用积分数量
     */
    public Integer getUseCount() {
        return useCount;
    }

    /**
     * 设置已使用积分数量
     *
     * @param useCount 已使用积分数量
     */
    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
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

    /**
     * 获取过期时间
     *
     * @return overdue_time - 过期时间
     */
    public Date getOverdueTime() {
        return overdueTime;
    }

    /**
     * 设置过期时间
     *
     * @param overdueTime 过期时间
     */
    public void setOverdueTime(Date overdueTime) {
        this.overdueTime = overdueTime;
    }

    /**
     * 获取积分状态：0，未使用
1，使用中
2，已使用
3，已过期
     *
     * @return integral_status - 积分状态：0，未使用
1，使用中
2，已使用
3，已过期
     */
    public Byte getIntegralStatus() {
        return integralStatus;
    }

    /**
     * 设置积分状态：0，未使用
1，使用中
2，已使用
3，已过期
     *
     * @param integralStatus 积分状态：0，未使用
1，使用中
2，已使用
3，已过期
     */
    public void setIntegralStatus(Byte integralStatus) {
        this.integralStatus = integralStatus;
    }

    /**
     * 获取修改人员
     *
     * @return update_user - 修改人员
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置修改人员
     *
     * @param updateUser 修改人员
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取操作理由
     *
     * @return operation_reason - 操作理由
     */
    public String getOperationReason() {
        return operationReason;
    }

    /**
     * 设置操作理由
     *
     * @param operationReason 操作理由
     */
    public void setOperationReason(String operationReason) {
        this.operationReason = operationReason;
    }

    /**
     * 获取操作时间
     *
     * @return operation_time - 操作时间
     */
    public Date getOperationTime() {
        return operationTime;
    }

    /**
     * 设置操作时间
     *
     * @param operationTime 操作时间
     */
    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}