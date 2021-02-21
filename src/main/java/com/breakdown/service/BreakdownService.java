package com.breakdown.service;

import com.breakdown.entity.BreakDownSlip;
import com.breakdown.model.BreakdownslipModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BreakdownService {

    List<BreakDownSlip> findAll();

    BreakDownSlip create(BreakdownslipModel breakdownslipModel);

    BreakDownSlip update(BreakdownslipModel breakdownslipModel);

    void delete(long id);

    BreakDownSlip findById(Long id);
}
