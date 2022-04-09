package cn.edu.seu.lone.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_trade_account")
@Data
public class TradeAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "account_no")
    private String accountNo;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "trade_group_id")
    private Long tradeGroupId;

    @Column(name = "active_at")
    private Date activeAt;

    @Column(name = "status")
    private Integer status;

    @Column(name = "institution_type_id")
    private String institutionTypeId;

    @Column(name = "institution_id")
    private Long institutionId;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "username")
    private String username;

    @Column(name = "trade_group_name")
    private String tradeGroupName;

    @Column(name = "created_at")
    private Date cratedAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
