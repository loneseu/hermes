package cn.edu.seu.lone.hermes.fiance.controller;

import cn.edu.seu.lone.entity.finance.TransactionRecord;
import cn.edu.seu.lone.entity.finance.repository.TransactionRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/finances")
@Slf4j
public class TransactionRecordController {

    private final TransactionRecordRepository transactionRecordRepository;

    @RequestMapping("/transaction-records/{id}")
    public TransactionRecord getTransactionRecordById(@PathVariable long id) {
        return transactionRecordRepository.getById(id);
    }

    @RequestMapping("/transaction-records")
    public Page<TransactionRecord> getTransactionList(Pageable pageable) {
         return transactionRecordRepository.findAll(pageable);
    }
}
