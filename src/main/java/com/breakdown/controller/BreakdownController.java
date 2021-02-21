package com.breakdown.controller;


import com.breakdown.entity.BreakDownSlip;
import com.breakdown.model.BreakdownslipModel;
import com.breakdown.service.BreakdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "breakdown")
public class BreakdownController {

    @Autowired
    private BreakdownService breakdownService;

    @RequestMapping(value = "/createSlip", method = RequestMethod.POST)
    public ResponseEntity<?> createSlip(@RequestBody BreakdownslipModel bdDto) {

        BreakDownSlip slip = breakdownService.create(bdDto);;
        return ResponseEntity.ok(slip);
    }
}
