package com.erp.zkteco.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class IclockTransactionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String empCode;
    private LocalDateTime punchTime;
    private Integer punchState;
    private Integer verifyType;
    private String workCode;
    private String terminalSn;
    private String terminalAlias;
    private String areaAlias;
    private Double longitude;
    private Double latitude;
    private String gpsLocation;
    private String mobile;
    private String source;
    private String purpose;
    private String crc;
    private Boolean isAttendance;
    private String reserved;
    private LocalDateTime uploadTime;
    private String syncStatus;
    private LocalDateTime syncTime;
    private Boolean isMask;
    private Double temperature;
    private Long empId;
    private Long terminalId;
    private String companyCode;

    // Constructor sin argumentos
    public IclockTransactionDto() {}

    // Constructor con todos los campos
    public IclockTransactionDto(Long id, String empCode, LocalDateTime punchTime, Integer punchState, Integer verifyType, String workCode,
                                String terminalSn, String terminalAlias, String areaAlias, Double longitude, Double latitude, String gpsLocation,
                                String mobile, String source, String purpose, String crc, Boolean isAttendance, String reserved, LocalDateTime uploadTime,
                                String syncStatus, LocalDateTime syncTime, Boolean isMask, Double temperature, Long empId, Long terminalId, String companyCode) {
        this.id = id;
        this.empCode = empCode;
        this.punchTime = punchTime;
        this.punchState = punchState;
        this.verifyType = verifyType;
        this.workCode = workCode;
        this.terminalSn = terminalSn;
        this.terminalAlias = terminalAlias;
        this.areaAlias = areaAlias;
        this.longitude = longitude;
        this.latitude = latitude;
        this.gpsLocation = gpsLocation;
        this.mobile = mobile;
        this.source = source;
        this.purpose = purpose;
        this.crc = crc;
        this.isAttendance = isAttendance;
        this.reserved = reserved;
        this.uploadTime = uploadTime;
        this.syncStatus = syncStatus;
        this.syncTime = syncTime;
        this.isMask = isMask;
        this.temperature = temperature;
        this.empId = empId;
        this.terminalId = terminalId;
        this.companyCode = companyCode;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public LocalDateTime getPunchTime() {
        return punchTime;
    }

    public void setPunchTime(LocalDateTime punchTime) {
        this.punchTime = punchTime;
    }

    public Integer getPunchState() {
        return punchState;
    }

    public void setPunchState(Integer punchState) {
        this.punchState = punchState;
    }

    public Integer getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(Integer verifyType) {
        this.verifyType = verifyType;
    }

    public String getWorkCode() {
        return workCode;
    }

    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    public String getTerminalSn() {
        return terminalSn;
    }

    public void setTerminalSn(String terminalSn) {
        this.terminalSn = terminalSn;
    }

    public String getTerminalAlias() {
        return terminalAlias;
    }

    public void setTerminalAlias(String terminalAlias) {
        this.terminalAlias = terminalAlias;
    }

    public String getAreaAlias() {
        return areaAlias;
    }

    public void setAreaAlias(String areaAlias) {
        this.areaAlias = areaAlias;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getGpsLocation() {
        return gpsLocation;
    }

    public void setGpsLocation(String gpsLocation) {
        this.gpsLocation = gpsLocation;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }

    public Boolean getIsAttendance() {
        return isAttendance;
    }

    public void setIsAttendance(Boolean isAttendance) {
        this.isAttendance = isAttendance;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public LocalDateTime getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(LocalDateTime syncTime) {
        this.syncTime = syncTime;
    }

    public Boolean getIsMask() {
        return isMask;
    }

    public void setIsMask(Boolean isMask) {
        this.isMask = isMask;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
