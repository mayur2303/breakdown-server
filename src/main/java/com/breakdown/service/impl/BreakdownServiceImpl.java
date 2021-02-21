package com.breakdown.service.impl;

import com.breakdown.dao.BreakdownDao;
import com.breakdown.entity.BreakDownSlip;
import com.breakdown.model.BreakdownslipModel;
import com.breakdown.service.BreakdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "breakdownService")
public class BreakdownServiceImpl implements BreakdownService {

    @Autowired
    private BreakdownDao breakdownDao;
    
    @Override
    public List<BreakDownSlip> findAll() {
        return null;
    }

    @Override
    public BreakDownSlip create(BreakdownslipModel bdDto) {
        BreakDownSlip slip = new BreakDownSlip();
        slip.setLineName(bdDto.getLineName());
        slip.setMachineName(bdDto.getMachineName());
        slip.setMaintenanceName(bdDto.getMaintenanceName());
        slip.setMicroCategory(bdDto.getMicroCategory());
        slip.setOperatorName(bdDto.getOperatorName());
        slip.setProblemDescription(bdDto.getProblemDescription());
        slip.setNote(bdDto.getNote());
        slip.setReceivedTime(bdDto.getReceivedTime());
        slip.setShift(bdDto.getShift());
        slip.setStartTime(bdDto.getStartTime());
        slip.setEndTime(bdDto.getEndTime());
        slip.setDateCreated(bdDto.getDateCreated());
        slip.setRequiredPart(bdDto.getRequiredPart());
        slip.setUsedPart(bdDto.getUsedPart());
        return breakdownDao.save(slip);
    }

    @Override
    public BreakDownSlip update(BreakdownslipModel breakdownslipModel) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public BreakDownSlip findById(Long id) {
        return null;
    }
}
