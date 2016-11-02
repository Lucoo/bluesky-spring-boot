package com.lucoo.boot.entity;

import javax.persistence.*;

@Table(name = "t_member_account")
public class TMemberAccount {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 账户编号
     */
    @Column(name = "account_id")
    private String accountId;

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
     * 获取账户编号
     *
     * @return account_id - 账户编号
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 设置账户编号
     *
     * @param accountId 账户编号
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}