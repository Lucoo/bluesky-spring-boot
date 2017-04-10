package com.lucoo.boot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_integral_log")
public class UserIntegralLog {
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
     * 0:获得 1：删除
     */
    @Column(name = "operation_type")
    private Byte operationType;

    /**
     * 积分数量
     */
    @Column(name = "integral_count")
    private Integer integralCount;

    /**
     * 操作原因

     */
    @Column(name = "operation_reason")
    private String operationReason;

    /**
     * 创建人员
     */
    @Column(name = "create_user")
    private Long createUser;

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
     * 获取0:获得 1：删除
     *
     * @return operation_type - 0:获得 1：删除
     */
    public Byte getOperationType() {
        return operationType;
    }

    /**
     * 设置0:获得 1：删除
     *
     * @param operationType 0:获得 1：删除
     */
    public void setOperationType(Byte operationType) {
        this.operationType = operationType;
    }

    /**
     * 获取积分数量
     *
     * @return integral_count - 积分数量
     */
    public Integer getIntegralCount() {
        return integralCount;
    }

    /**
     * 设置积分数量
     *
     * @param integralCount 积分数量
     */
    public void setIntegralCount(Integer integralCount) {
        this.integralCount = integralCount;
    }

    /**
     * 获取操作原因

     *
     * @return operation_reason - 操作原因

     */
    public String getOperationReason() {
        return operationReason;
    }

    /**
     * 设置操作原因

     *
     * @param operationReason 操作原因

     */
    public void setOperationReason(String operationReason) {
        this.operationReason = operationReason;
    }

    /**
     * 获取创建人员
     *
     * @return create_user - 创建人员
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人员
     *
     * @param createUser 创建人员
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
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