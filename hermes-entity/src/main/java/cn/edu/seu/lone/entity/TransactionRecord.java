package cn.edu.seu.lone.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "tb_transaction_record")
@Data
public class TransactionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private Integer type;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "created_at")
    private Date cratedTime;

    @Column(name = "updated_at")
    private Date updatedTime;
}
