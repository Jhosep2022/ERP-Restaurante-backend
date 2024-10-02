package com.erp.zkteco.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "att_timeinterval")
public class AttTimeInterval implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "alias", length = 50, nullable = false)
    private String alias;

    @Column(name = "use_mode", nullable = false)
    private Short useMode;

    @Column(name = "in_time", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime inTime;

    @Column(name = "in_ahead_margin", nullable = false)
    private Integer inAheadMargin;

    @Column(name = "in_above_margin", nullable = false)
    private Integer inAboveMargin;

    @Column(name = "out_ahead_margin", nullable = false)
    private Integer outAheadMargin;

    @Column(name = "out_above_margin", nullable = false)
    private Integer outAboveMargin;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "in_required", nullable = false)
    private Short inRequired;

    @Column(name = "out_required", nullable = false)
    private Short outRequired;

    @Column(name = "allow_late", nullable = false)
    private Integer allowLate;

    @Column(name = "allow_leave_early", nullable = false)
    private Integer allowLeaveEarly;

    @Column(name = "work_day", nullable = false)
    private Double workDay;

    @Column(name = "early_in", nullable = false)
    private Short earlyIn;

    @Column(name = "min_early_in", nullable = false)
    private Integer minEarlyIn;

    @Column(name = "late_out", nullable = false)
    private Short lateOut;

    @Column(name = "min_late_out", nullable = false)
    private Integer minLateOut;

    @Column(name = "overtime_lv", nullable = false)
    private Short overtimeLv;

    @Column(name = "overtime_lv1", nullable = false)
    private Short overtimeLv1;

    @Column(name = "overtime_lv2", nullable = false)
    private Short overtimeLv2;

    @Column(name = "overtime_lv3", nullable = false)
    private Short overtimeLv3;

    @Column(name = "multiple_punch", nullable = false)
    private Short multiplePunch;

    @Column(name = "available_interval_type", nullable = false)
    private Short availableIntervalType;

    @Column(name = "available_interval", nullable = false)
    private Integer availableInterval;

    @Column(name = "work_time_duration", nullable = false)
    private Integer workTimeDuration;

    @Column(name = "func_key", nullable = false)
    private Short funcKey;

    @Column(name = "work_type", nullable = false)
    private Short workType;

    @Column(name = "day_change", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime dayChange;

    @Column(name = "enable_early_in", nullable = false)
    private Boolean enableEarlyIn;

    @Column(name = "enable_late_out", nullable = false)
    private Boolean enableLateOut;

    @Column(name = "enable_overtime", nullable = false)
    private Boolean enableOvertime;

    @Column(name = "ot_rule")
    private UUID otRule;  // Cambiado a UUID

    @Column(name = "color_setting", length = 30)
    private String colorSetting;

    @Column(name = "enable_max_ot_limit", nullable = false)
    private Boolean enableMaxOtLimit;

    @Column(name = "max_ot_limit", nullable = false)
    private Integer maxOtLimit;

    @Column(name = "count_early_in_interval", nullable = false)
    private Boolean countEarlyInInterval;

    @Column(name = "count_late_out_interval", nullable = false)
    private Boolean countLateOutInterval;

    @Column(name = "ot_pay_code_id")
    private Integer otPayCodeId;

    @Column(name = "overtime_policy", nullable = false)
    private Short overtimePolicy;

    @Column(name = "company_id", nullable = false)
    private Integer companyId;

    // Constructores
    public AttTimeInterval() {}

    public AttTimeInterval(Long id, String alias, Short useMode, LocalTime inTime, Integer inAheadMargin, Integer inAboveMargin, Integer outAheadMargin, Integer outAboveMargin, Integer duration, Short inRequired, Short outRequired, Integer allowLate, Integer allowLeaveEarly, Double workDay, Short earlyIn, Integer minEarlyIn, Short lateOut, Integer minLateOut, Short overtimeLv, Short overtimeLv1, Short overtimeLv2, Short overtimeLv3, Short multiplePunch, Short availableIntervalType, Integer availableInterval, Integer workTimeDuration, Short funcKey, Short workType, LocalTime dayChange, Boolean enableEarlyIn, Boolean enableLateOut, Boolean enableOvertime, UUID otRule, String colorSetting, Boolean enableMaxOtLimit, Integer maxOtLimit, Boolean countEarlyInInterval, Boolean countLateOutInterval, Integer otPayCodeId, Short overtimePolicy, Integer companyId) {
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
