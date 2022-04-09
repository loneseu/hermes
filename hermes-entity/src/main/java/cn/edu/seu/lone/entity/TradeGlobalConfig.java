package cn.edu.seu.lone.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_trade_global_config")
public class TradeGlobalConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "category")
    private String category;

    @Column(name = "value")
    private String value;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    private Date cratedAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
