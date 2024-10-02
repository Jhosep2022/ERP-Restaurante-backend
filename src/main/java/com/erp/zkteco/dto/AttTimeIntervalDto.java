package com.erp.zkteco.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.UUID;

public class AttTimeIntervalDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String alias;
    private Short useMode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime inTime;  // Ajustado a LocalTime para coincidir con la base de datos

    private Integer inAheadMargin;
    private Integer inAboveMargin;
    private Integer outAheadMargin;
    private Integer outAboveMargin;
    private Integer duration;
    private Short inRequired;
    private Short outRequired;
    private Integer allowLate;
    private Integer allowLeaveEarly;
    private Double workDay;
    private Short earlyIn;
    private Integer minEarlyIn;
    private Short lateOut;
    private Integer minLateOut;
    private Short overtimeLv;
    private Short overtimeLv1;
    private Short overtimeLv2;
    private Short overtimeLv3;
    private Short multiplePunch;
    private Short availableIntervalType;
    private Integer availableInterval;
    private Integer workTimeDuration;
    private Short funcKey;
    private Short workType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime dayChange;  // Ajustado a LocalTime para coincidir con la base de datos

    private Boolean enableEarlyIn;
    private Boolean enableLateOut;
    private Boolean enableOvertime;
    private UUID otRule;  // Cambiado a UUID
    private String colorSetting;
    private Boolean enableMaxOtLimit;
    private Integer maxOtLimit;
    private Boolean countEarlyInInterval;
    private Boolean countLateOutInterval;
    private Integer otPayCodeId;
    private Short overtimePolicy;
    private Integer companyId;

    // Constructor vacío
    public AttTimeIntervalDto() {}

    // Constructor con todos los campos
    public AttTimeIntervalDto(Long id, String alias, Short useMode, LocalTime inTime, Integer inAheadMargin, Integer inAboveMargin, Integer outAheadMargin, Integer outAboveMargin, Integer duration, Short inRequired, Short outRequired, Integer allowLate, Integer allowLeaveEarly, Double workDay, Short earlyIn, Integer minEarlyIn, Short lateOut, Integer minLateOut, Short overtimeLv, Short overtimeLv1, Short overtimeLv2, Short overtimeLv3, Short multiplePunch, Short availableIntervalType, Integer availableInterval, Integer workTimeDuration, Short funcKey, Short workType, LocalTime dayChange, Boolean enableEarlyIn, Boolean enableLateOut, Boolean enableOvertime, UUID otRule, String colorSetting, Boolean enableMaxOtLimit, Integer maxOtLimit, Boolean countEarlyInInterval, Boolean countLateOutInterval, Integer otPayCodeId, Short overtimePolicy, Integer companyId) {
        this.id = id;
        this.alias = alias;
        this.useMode = useMode;
        this.inTime = inTime;
        this.inAheadMargin = inAheadMargin;
        this.inAboveMargin = inAboveMargin;
        this.outAheadMargin = outAheadMargin;
        this.outAboveMargin = outAboveMargin;
        this.duration = duration;
        this.inRequired = inRequired;
        this.outRequired = outRequired;
        this.allowLate = allowLate;
        this.allowLeaveEarly = allowLeaveEarly;
        this.workDay = workDay;
        this.earlyIn = earlyIn;
        this.minEarlyIn = minEarlyIn;
        this.lateOut = lateOut;
        this.minLateOut = minLateOut;
        this.overtimeLv = overtimeLv;
        this.overtimeLv1 = overtimeLv1;
        this.overtimeLv2 = overtimeLv2;
        this.overtimeLv3 = overtimeLv3;
        this.multiplePunch = multiplePunch;
        this.availableIntervalType = availableIntervalType;
        this.availableInterval = availableInterval;
        this.workTimeDuration = workTimeDuration;
        this.funcKey = funcKey;
        this.workType = workType;
        this.dayChange = dayChange;
        this.enableEarlyIn = enableEarlyIn;
        this.enableLateOut = enableLateOut;
        this.enableOvertime = enableOvertime;
        this.otRule = otRule;
        this.colorSetting = colorSetting;
        this.enableMaxOtLimit = enableMaxOtLimit;
        this.maxOtLimit = maxOtLimit;
        this.countEarlyInInterval = countEarlyInInterval;
        this.countLateOutInterval = countLateOutInterval;
        this.otPayCodeId = otPayCodeId;
        this.overtimePolicy = overtimePolicy;
        this.companyId = companyId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Short getUseMode() {
        return useMode;
    }

    public void setUseMode(Short useMode) {
        this.useMode = useMode;
    }

    public LocalTime getInTime() {
        return inTime;
    }

    public void setInTime(LocalTime inTime) {
        this.inTime = inTime;
    }

    public Integer getInAheadMargin() {
        return inAheadMargin;
    }

    public void setInAheadMargin(Integer inAheadMargin) {
        this.inAheadMargin = inAheadMargin;
    }

    public Integer getInAboveMargin() {
        return inAboveMargin;
    }

    public void setInAboveMargin(Integer inAboveMargin) {
        this.inAboveMargin = inAboveMargin;
    }

    public Integer getOutAheadMargin() {
        return outAheadMargin;
    }

    public void setOutAheadMargin(Integer outAheadMargin) {
        this.outAheadMargin = outAheadMargin;
    }

    public Integer getOutAboveMargin() {
        return outAboveMargin;
    }

    public void setOutAboveMargin(Integer outAboveMargin) {
        this.outAboveMargin = outAboveMargin;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Short getInRequired() {
        return inRequired;
    }

    public void setInRequired(Short inRequired) {
        this.inRequired = inRequired;
    }

    public Short getOutRequired() {
        return outRequired;
    }

    public void setOutRequired(Short outRequired) {
        this.outRequired = outRequired;
    }

    public Integer getAllowLate() {
        return allowLate;
    }

    public void setAllowLate(Integer allowLate) {
        this.allowLate = allowLate;
    }

    public Integer getAllowLeaveEarly() {
        return allowLeaveEarly;
    }

    public void setAllowLeaveEarly(Integer allowLeaveEarly) {
        this.allowLeaveEarly = allowLeaveEarly;
    }

    public Double getWorkDay() {
        return workDay;
    }

    public void setWorkDay(Double workDay) {
        this.workDay = workDay;
    }

    public Short getEarlyIn() {
        return earlyIn;
    }

    public void setEarlyIn(Short earlyIn) {
        this.earlyIn = earlyIn;
    }

    public Integer getMinEarlyIn() {
        return minEarlyIn;
    }

    public void setMinEarlyIn(Integer minEarlyIn) {
        this.minEarlyIn = minEarlyIn;
    }

    public Short getLateOut() {
        return lateOut;
    }

    public void setLateOut(Short lateOut) {
        this.lateOut = lateOut;
    }

    public Integer getMinLateOut() {
        return minLateOut;
    }

    public void setMinLateOut(Integer minLateOut) {
        this.minLateOut = minLateOut;
    }

    public Short getOvertimeLv() {
        return overtimeLv;
    }

    public void setOvertimeLv(Short overtimeLv) {
        this.overtimeLv = overtimeLv;
    }

    public Short getOvertimeLv1() {
        return overtimeLv1;
    }

    public void setOvertimeLv1(Short overtimeLv1) {
        this.overtimeLv1 = overtimeLv1;
    }

    public Short getOvertimeLv2() {
        return overtimeLv2;
    }

    public void setOvertimeLv2(Short overtimeLv2) {
        this.overtimeLv2 = overtimeLv2;
    }

    public Short getOvertimeLv3() {
        return overtimeLv3;
    }

    public void setOvertimeLv3(Short overtimeLv3) {
        this.overtimeLv3 = overtimeLv3;
    }

    public Short getMultiplePunch() {
        return multiplePunch;
    }

    public void setMultiplePunch(Short multiplePunch) {
        this.multiplePunch = multiplePunch;
    }

    public Short getAvailableIntervalType() {
        return availableIntervalType;
    }

    public void setAvailableIntervalType(Short availableIntervalType) {
        this.availableIntervalType = availableIntervalType;
    }

    public Integer getAvailableInterval() {
        return availableInterval;
    }

    public void setAvailableInterval(Integer availableInterval) {
        this.availableInterval = availableInterval;
    }

    public Integer getWorkTimeDuration() {
        return workTimeDuration;
    }

    public void setWorkTimeDuration(Integer workTimeDuration) {
        this.workTimeDuration = workTimeDuration;
    }

    public Short getFuncKey() {
        return funcKey;
    }

    public void setFuncKey(Short funcKey) {
        this.funcKey = funcKey;
    }

    public Short getWorkType() {
        return workType;
    }

    public void setWorkType(Short workType) {
        this.workType = workType;
    }

    public LocalTime getDayChange() {
        return dayChange;
    }

    public void setDayChange(LocalTime dayChange) {
        this.dayChange = dayChange;
    }

    public Boolean getEnableEarlyIn() {
        return enableEarlyIn;
    }

    public void setEnableEarlyIn(Boolean enableEarlyIn) {
        this.enableEarlyIn = enableEarlyIn;
    }

    public Boolean getEnableLateOut() {
        return enableLateOut;
    }

    public void setEnableLateOut(Boolean enableLateOut) {
        this.enableLateOut = enableLateOut;
    }

    public Boolean getEnableOvertime() {
        return enableOvertime;
    }

    public void setEnableOvertime(Boolean enableOvertime) {
        this.enableOvertime = enableOvertime;
    }

    public UUID getOtRule() {
        return otRule;
    }

    public void setOtRule(UUID otRule) {
        this.otRule = otRule;
    }

    public String getColorSetting() {
        return colorSetting;
    }

    public void setColorSetting(String colorSetting) {
        this.colorSetting = colorSetting;
    }

    public Boolean getEnableMaxOtLimit() {
        return enableMaxOtLimit;
    }

    public void setEnableMaxOtLimit(Boolean enableMaxOtLimit) {
        this.enableMaxOtLimit = enableMaxOtLimit;
    }

    public Integer getMaxOtLimit() {
        return maxOtLimit;
    }

    public void setMaxOtLimit(Integer maxOtLimit) {
        this.maxOtLimit = maxOtLimit;
    }

    public Boolean getCountEarlyInInterval() {
        return countEarlyInInterval;
    }

    public void setCountEarlyInInterval(Boolean countEarlyInInterval) {
        this.countEarlyInInterval = countEarlyInInterval;
    }

    public Boolean getCountLateOutInterval() {
        return countLateOutInterval;
    }

    public void setCountLateOutInterval(Boolean countLateOutInterval) {
        this.countLateOutInterval = countLateOutInterval;
    }

    public Integer getOtPayCodeId() {
        return otPayCodeId;
    }

    public void setOtPayCodeId(Integer otPayCodeId) {
        this.otPayCodeId = otPayCodeId;
    }

    public Short getOvertimePolicy() {
        return overtimePolicy;
    }

    public void setOvertimePolicy(Short overtimePolicy) {
        this.overtimePolicy = overtimePolicy;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
