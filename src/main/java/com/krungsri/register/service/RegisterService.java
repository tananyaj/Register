package com.krungsri.register.service;

import com.krungsri.register.entity.Register;
import com.krungsri.register.exception.ClientException;
import com.krungsri.register.model.AddUserRequest;
import com.krungsri.register.model.GetUserRequest;
import com.krungsri.register.model.GetUserResponse;
import com.krungsri.register.repository.RegisterRepository;
import com.krungsri.register.repository.RegisterRepositoryCustom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
@Transactional
public class RegisterService {

    private final RegisterRepository registerRepository;
    private final RegisterRepositoryCustom registerRepositoryCustom;

    @Autowired
    public RegisterService(RegisterRepository registerRepository, RegisterRepositoryCustom registerRepositoryCustom) {
        this.registerRepository = registerRepository;
        this.registerRepositoryCustom = registerRepositoryCustom;
    }

    public void addUser(AddUserRequest request, String username) throws ClientException,ParseException {
        if (request.getSalary() < 15000) {
            throw new ClientException("401-KS-0000001", "เงินเดือนน้อยเกินไป", "เงินเดือนน้อยเกินไป");
        }
        try {
            LocalDate nowDate = LocalDate.now();
            DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String updateDate = customFormat.format(nowDate);

            DateTimeFormatter referenceFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
            String referenceDate = referenceFormat.format(nowDate);

            Register model = new Register();
            model.setCitizenId(request.getCid());
            model.setTitle(request.getTitle());
            model.setFirstName(request.getFirstName());
            model.setLastName(request.getLastName());
            model.setMobile(request.getMobile());
            model.setGender(request.getGender());
            model.setBirthDate(request.getBirthDate());
            model.setSalary(request.getSalary());
            if(request.getSalary() > 50000){
                model.setMemberType("Platinum");
            } else if(request.getSalary() > 30000  && request.getSalary() < 50000){
                model.setMemberType("Gold");
            } else if (request.getSalary() < 30000) {
                model.setMemberType("Silver");
            }
            model.setReferenceCode(referenceDate + request.getMobile().substring(6,10));
            model.setIsDeleted("N");
            model.setCreatedDate(updateDate);
            model.setCreatedBy(username);
            registerRepository.save(model);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<GetUserResponse> getUser(GetUserRequest request, String username) throws ParseException {
        try {
            return registerRepositoryCustom.getUser(request);
        } catch (Exception e) {
            throw e;
        }
    }
}
