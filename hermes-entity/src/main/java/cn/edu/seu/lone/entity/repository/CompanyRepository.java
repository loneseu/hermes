package cn.edu.seu.lone.entity.repository;

import cn.edu.seu.lone.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company getById(Long id);
}
