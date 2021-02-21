package com.breakdown.dao;

import com.breakdown.entity.BreakDownSlip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreakdownDao extends CrudRepository<BreakDownSlip, Long> {

}
