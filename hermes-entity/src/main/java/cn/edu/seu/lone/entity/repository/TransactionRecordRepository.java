package cn.edu.seu.lone.entity.repository;

import cn.edu.seu.lone.entity.TransactionRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransactionRecordRepository extends PagingAndSortingRepository<TransactionRecord, Long> {

    TransactionRecord getById(long id);

    Page<TransactionRecord> findAll(Pageable pageable);
}
