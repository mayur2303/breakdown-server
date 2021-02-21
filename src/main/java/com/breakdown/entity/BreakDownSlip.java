package com.breakdown.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BREAK_DOWN_SLIP")
public class BreakDownSlip {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "lineName")
    private String lineName;
    @Basic
    @Column(name = "machineName")
    private String machineName;

    @Basic
    @Column(name = "shift")
    private String shift;

    @Basic
    @Column(name = "operatorName")
    private String operatorName;

    @Basic
    @Column(name = "maintenanceName")
    private String maintenanceName;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedTime;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Basic
    @Column(name = "problemDescription")
    private String problemDescription;

    @Basic
    @Column(name = "note")
    private String note;

    @Basic
    @Column(name = "microCategory")
    private String microCategory;

    @Basic
    @Column(name = "usedPart")
    private String usedPart;

    @Basic
    @Column(name = "requiredPart")
    private String requiredPart;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getMaintenanceName() {
        return maintenanceName;
    }

    public void setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Date receivedTime) {
        this.receivedTime = receivedTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMicroCategory() {
        return microCategory;
    }

    public void setMicroCategory(String microCategory) {
        this.microCategory = microCategory;
    }

    public String getUsedPart() {
        return usedPart;
    }

    public void setUsedPart(String usedPart) {
        this.usedPart = usedPart;
    }

    public String getRequiredPart() {
        return requiredPart;
    }

    public void setRequiredPart(String requiredPart) {
        this.requiredPart = requiredPart;
    }
}
