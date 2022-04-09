package cn.edu.seu.lone.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_user")
@Data
public class TradeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_no")
    private String userNo;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name")
    private Long companyName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "institution_type_id")
    private String institutionTypeId;

    @Column(name = "institution_id")
    private Long institutionId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    private Date cratedAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
