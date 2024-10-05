package com.erp.zkteco.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "personnel_employee")
public class PersonnelEmployee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "change_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changeTime;

    @Column(name = "change_user")
    private String changeUser;

    @Column(name = "status")
    private Integer status;

    @Column(name = "emp_code")
    private String empCode;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "passport")
    private String passport;

    @Column(name = "driver_license_automobile")
    private String driverLicenseAutomobile;

    @Column(name = "driver_license_motorcycle")
    private String driverLicenseMotorcycle;

    @Column(name = "photo")
    private String photo;

    @Column(name = "self_password")
    private String selfPassword;

    @Column(name = "device_password")
    private String devicePassword;

    // CAMBIO: Ajustar devPrivilege a Integer
    @Column(name = "dev_privilege")
    private Integer devPrivilege;

    @Column(name = "card_no")
    private String cardNo;

    @Column(name = "acc_group")
    private String accGroup;

    @Column(name = "acc_timezone")
    private String accTimezone;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "office_tel")
    private String officeTel;

    @Column(name = "contact_tel")
    private String contactTel;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "national")
    private String national;

    @Column(name = "religion")
    private String religion;

    @Column(name = "title")
    private String title;

    @Column(name = "enroll_sn")
    private String enrollSn;

    @Column(name = "ssn")
    private String ssn;

    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Column(name = "verify_mode")
    private Integer verifyMode;

    @Column(name = "city")
    private String city;

    @Column(name = "emp_type")
    private Short empType;

    @Column(name = "enable_payroll")
    private Boolean enablePayroll;

    // CAMBIO: Ajustar appStatus a Short
    @Column(name = "app_status")
    private Short appStatus;

    // CAMBIO: Ajustar appRole a Short
    @Column(name = "app_role")
    private Short appRole;

    @Column(name = "email")
    private String email;

    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "session_key")
    private String sessionKey;

    @Column(name = "login_ip")
    private String loginIp;

    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "leave_group")
    private Integer leaveGroup;

    @Column(name = "emp_code_digit")
    private Long  empCodeDigit;

    @Column(name = "superior_id")
    private Long superiorId;

    @Column(name = "company_id")
    private Long companyId;

    public PersonnelEmployee() {
    }

    public PersonnelEmployee(Long id, Date createTime, String createUser, Date changeTime, String changeUser, Integer status, String empCode, String firstName, String lastName, String nickname, String passport, String driverLicenseAutomobile, String driverLicenseMotorcycle, String photo, String selfPassword, String devicePassword, Integer devPrivilege, String cardNo, String accGroup, String accTimezone, String gender, Date birthday, String address, String postcode, String officeTel, String contactTel, String mobile, String national, String religion, String title, String enrollSn, String ssn, Date updateTime, Date hireDate, Integer verifyMode, String city, Short empType, Boolean enablePayroll, Short appStatus, Short appRole, String email, Date lastLogin, Boolean isActive, String sessionKey, String loginIp, Long departmentId, Long positionId, Integer leaveGroup, Long empCodeDigit, Long superiorId, Long companyId) {
        this.id = id;
        this.createTime = createTime;
        this.createUser = createUser;
        this.changeTime = changeTime;
        this.changeUser = changeUser;
        this.status = status;
        this.empCode = empCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.passport = passport;
        this.driverLicenseAutomobile = driverLicenseAutomobile;
        this.driverLicenseMotorcycle = driverLicenseMotorcycle;
        this.photo = photo;
        this.selfPassword = selfPassword;
        this.devicePassword = devicePassword;
        this.devPrivilege = devPrivilege;
        this.cardNo = cardNo;
        this.accGroup = accGroup;
        this.accTimezone = accTimezone;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.postcode = postcode;
        this.officeTel = officeTel;
        this.contactTel = contactTel;
        this.mobile = mobile;
        this.national = national;
        this.religion = religion;
        this.title = title;
        this.enrollSn = enrollSn;
        this.ssn = ssn;
        this.updateTime = updateTime;
        this.hireDate = hireDate;
        this.verifyMode = verifyMode;
        this.city = city;
        this.empType = empType;
        this.enablePayroll = enablePayroll;
        this.appStatus = appStatus;
        this.appRole = appRole;
        this.email = email;
        this.lastLogin = lastLogin;
        this.isActive = isActive;
        this.sessionKey = sessionKey;
        this.loginIp = loginIp;
        this.departmentId = departmentId;
        this.positionId = positionId;
        this.leaveGroup = leaveGroup;
        this.empCodeDigit = empCodeDigit;
        this.superiorId = superiorId;
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public String getChangeUser() {
        return changeUser;
    }

    public void setChangeUser(String changeUser) {
        this.changeUser = changeUser;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDriverLicenseAutomobile() {
        return driverLicenseAutomobile;
    }

    public void setDriverLicenseAutomobile(String driverLicenseAutomobile) {
        this.driverLicenseAutomobile = driverLicenseAutomobile;
    }

    public String getDriverLicenseMotorcycle() {
        return driverLicenseMotorcycle;
    }

    public void setDriverLicenseMotorcycle(String driverLicenseMotorcycle) {
        this.driverLicenseMotorcycle = driverLicenseMotorcycle;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSelfPassword() {
        return selfPassword;
    }

    public void setSelfPassword(String selfPassword) {
        this.selfPassword = selfPassword;
    }

    public String getDevicePassword() {
        return devicePassword;
    }

    public void setDevicePassword(String devicePassword) {
        this.devicePassword = devicePassword;
    }

    public Integer getDevPrivilege() {
        return devPrivilege;
    }

    public void setDevPrivilege(Integer devPrivilege) {
        this.devPrivilege = devPrivilege;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAccGroup() {
        return accGroup;
    }

    public void setAccGroup(String accGroup) {
        this.accGroup = accGroup;
    }

    public String getAccTimezone() {
        return accTimezone;
    }

    public void setAccTimezone(String accTimezone) {
        this.accTimezone = accTimezone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getOfficeTel() {
        return officeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnrollSn() {
        return enrollSn;
    }

    public void setEnrollSn(String enrollSn) {
        this.enrollSn = enrollSn;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getVerifyMode() {
        return verifyMode;
    }

    public void setVerifyMode(Integer verifyMode) {
        this.verifyMode = verifyMode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Short getEmpType() {
        return empType;
    }

    public void setEmpType(Short empType) {
        this.empType = empType;
    }

    public Boolean getEnablePayroll() {
        return enablePayroll;
    }

    public void setEnablePayroll(Boolean enablePayroll) {
        this.enablePayroll = enablePayroll;
    }

    public Short getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(Short appStatus) {
        this.appStatus = appStatus;
    }

    public Short getAppRole() {
        return appRole;
    }

    public void setAppRole(Short appRole) {
        this.appRole = appRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Integer getLeaveGroup() {
        return leaveGroup;
    }

    public void setLeaveGroup(Integer leaveGroup) {
        this.leaveGroup = leaveGroup;
    }

    public Long getEmpCodeDigit() {
        return empCodeDigit;
    }

    public void setEmpCodeDigit(Long empCodeDigit) {
        this.empCodeDigit = empCodeDigit;
    }

    public Long getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(Long superiorId) {
        this.superiorId = superiorId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
