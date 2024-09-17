package com.erp.zkteco.service;

import com.erp.zkteco.dto.PersonnelEmployeeDto;
import com.erp.zkteco.entity.PersonnelEmployee;
import com.erp.zkteco.repository.PersonnelEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonnelEmployeeService {

    @Autowired
    private PersonnelEmployeeRepository personnelEmployeeRepository;

    // Método para obtener todos los empleados
    public List<PersonnelEmployeeDto> getAllEmployees() {
        List<PersonnelEmployee> employees = personnelEmployeeRepository.findAll();
        return employees.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Convertir la entidad a DTO
    private PersonnelEmployeeDto convertToDto(PersonnelEmployee employee) {
        return new PersonnelEmployeeDto(
                employee.getId(),
                employee.getCreateTime(),
                employee.getCreateUser(),
                employee.getChangeTime(),
                employee.getChangeUser(),
                employee.getStatus(),
                employee.getEmpCode(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getNickname(),
                employee.getPassport(),
                employee.getDriverLicenseAutomobile(),
                employee.getDriverLicenseMotorcycle(),
                employee.getPhoto(),
                employee.getSelfPassword(),
                employee.getDevicePassword(),
                employee.getDevPrivilege(),
                employee.getCardNo(),
                employee.getAccGroup(),
                employee.getAccTimezone(),
                employee.getGender(),
                employee.getBirthday(),
                employee.getAddress(),
                employee.getPostcode(),
                employee.getOfficeTel(),
                employee.getContactTel(),
                employee.getMobile(),
                employee.getNational(),
                employee.getReligion(),
                employee.getTitle(),
                employee.getEnrollSn(),
                employee.getSsn(),
                employee.getUpdateTime(),
                employee.getHireDate(),
                employee.getVerifyMode(),
                employee.getCity(),
                employee.getEmpType(),
                employee.getEnablePayroll(),
                employee.getAppStatus(),
                employee.getAppRole(),
                employee.getEmail(),
                employee.getLastLogin(),
                employee.getActive(),
                employee.getSessionKey(),
                employee.getLoginIp(),
                employee.getDepartmentId(),
                employee.getPositionId(),
                employee.getLeaveGroup(),
                employee.getEmpCodeDigit(),
                employee.getSuperiorId(),
                employee.getCompanyId()
        );
    }
}
