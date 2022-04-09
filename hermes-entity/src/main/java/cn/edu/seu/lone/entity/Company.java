package cn.edu.seu.lone.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_company")
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "company_name")
    private Long companyName;

    @Column(name = "institution_type_id")
    private String institutionTypeId;

    @Column(name = "institution_id")
    private Long institutionId;

    @Column(name = "contract_user")
    private String contractUser;

    @Column(name = "contract_phone")
    private String contractPhone;

    @Column(name = "admin_user")
    private String adminUser;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "last_update_user")
    private String lastUpdateUser;

    @Column(name = "last_update_time")
    private Date lastUpdateTIme;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    private Date cratedAt;

    @Column(name = "updated_at")
    private Date updatedAt;

}
