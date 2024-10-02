package com.erp.zkteco.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "iclock_transaction")
public class IclockTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "emp_code", nullable = false)
    private String empCode;

    @Column(name = "punch_time", nullable = false)
    private LocalDateTime punchTime;

    @Column(name = "punch_state", nullable = false)
    private Integer punchState;

    @Column(name = "verify_type", nullable = false)
    private Integer verifyType;

    @Column(name = "work_code")
    private String workCode;

    @Column(name = "terminal_sn")
    private String terminalSn;

    @Column(name = "terminal_alias")
    private String terminalAlias;

    @Column(name = "area_alias")
    private String areaAlias;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "gps_location")
    private String gpsLocation;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "source")
    private String source;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "crc")
    private String crc;

    @Column(name = "is_attendance")
    private Boolean isAttendance;

    @Column(name = "reserved")
    private String reserved;

    @Column(name = "upload_time")
    private LocalDateTime uploadTime;

    @Column(name = "sync_status")
    private String syncStatus;

    @Column(name = "sync_time")
    private LocalDateTime syncTime;

    @Column(name = "is_mask")
    private Boolean isMask;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "terminal_id")
    private Long terminalId;

    @Column(name = "company_code")
    private String companyCode;

    // Constructores
    public IclockTransaction() {}

    public IclockTransaction(Long id, String empCode, LocalDateTime punchTime, Integer punchState, Integer verifyType, String workCode, String terminalSn,
                             String terminalAlias, String areaAlias, Double longitude, Double latitude, String gpsLocation, String mobile, String source,
                             String purpose, String crc, Boolean isAttendance, String reserved, LocalDateTime uploadTime, String syncStatus, LocalDateTime syncTime,
                             Boolean isMask, Double temperature, Long empId, Long terminalId, String companyCode) {
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

    // Métodos equals, hashCode y toString
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof IclockTransaction)) {
            return false;
        }
        IclockTransaction other = (IclockTransaction) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.erp.zkteco.entity.IclockTransaction[ id=" + id + " ]";
    }
}
