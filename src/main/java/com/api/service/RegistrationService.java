package com.api.service;

import com.api.entity.Registration;
import com.api.entity.RegistrationDto;
import com.api.exception.ResourceNotFoundExeption;
import com.api.repository.KycRepository;
import com.api.repository.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    private RegistrationRepository registrationRepository;
    //private KycRepository kycRepository;
    private ModelMapper modelMapper;

    public RegistrationService(RegistrationRepository registrationRepository,KycRepository kycRepository,ModelMapper modelMapper) {
        this.registrationRepository = registrationRepository;
        //this.kycRepository=kycRepository;
        this.modelMapper=modelMapper;
    }



//    public List<Registration> getRegistrations(){
//        List<Registration> registrations = registrationRepository.findAll();
//return registrations;
//    }


    //saving data
//    public Registration createRegistration(Registration registration) {
//        Registration savedEntity = registrationRepository.save(registration);
//
//        return savedEntity;
//
//    }


    public void deleteRegistration(long id) {
        registrationRepository.deleteById(id);
        
    }

    public Registration updateRegistration(long id, Registration registration) {

        Registration r = registrationRepository.findById(id).get();

        r.setName(registration.getName());
        r.setEmail(registration.getEmail());
        r.setMobile(registration.getMobile());
        Registration savedEntity = registrationRepository.save(r);

        return savedEntity;
        
    }


    //saving data by entity ,getting by dto not having id

//    public RegistrationDto createRegistration(Registration registration) {
//
//        Registration savedEntity = registrationRepository.save(registration);
//
//        RegistrationDto dto =new RegistrationDto();
//
//        dto.setEmail(savedEntity.getEmail());
//        dto.setName(savedEntity.getName());
//        dto.setMobile(savedEntity.getMobile());
//
//       return dto;
//
//
//    }


    //taking data by dto , giving response  by dto (saving in db by entity)

   //taking data by dto , giving response  by dto (saving in db by entity in diff table)

//    public RegistrationDto createRegistration(RegistrationDto registrationDto) {
//
//        //copy Dto to Entity & save

//        Registration registration=new Registration();
//
//        registration.setMobile(registrationDto.getMobile());
//        registration.setName(registrationDto.getName());
//        registration.setEmail(registrationDto.getEmail());
//
//        Registration savedEntity = registrationRepository.save(registration);
//
//
//        Kyc kyc=new Kyc();
//        kyc.setPanNum(registrationDto.getPanNum());
//        Kyc savedKyc = kycRepository.save(kyc);

    // copy entity to dto(getting from db to dto )
//        RegistrationDto dto=new RegistrationDto();
//
//          dto.setEmail(savedEntity.getEmail());
//          dto.setName(savedEntity.getName());
//          dto.setMobile(savedEntity.getMobile());
//          dto.setPanNum(savedKyc.getPanNum());
//
//        return dto;
//  }


    public RegistrationDto createRegistration(RegistrationDto registrationDto) {

        Registration registration=mapToEntity(registrationDto);
        Registration savedEntity = registrationRepository.save(registration);


        RegistrationDto dto = mapToDto(registration);
        return dto;
    }


   Registration mapToEntity(RegistrationDto registrationDto) {

       Registration registration = modelMapper.map(registrationDto, Registration.class);

//       Registration registration = new Registration();
//
//       registration.setMobile(registrationDto.getMobile());
//       registration.setName(registrationDto.getName());
//       registration.setEmail(registrationDto.getEmail());

       return registration;


   }


    RegistrationDto  mapToDto(Registration registration) {

        RegistrationDto dto = modelMapper.map(registration,RegistrationDto.class);

//        RegistrationDto dto=new RegistrationDto();
//
//          dto.setEmail(registration.getEmail());
//          dto.setName(registration.getName());
//          dto.setMobile(registration.getMobile());

        return dto;

    }


    public List<RegistrationDto> getRegistrations(){
        List<Registration> registrations = registrationRepository.findAll();
        List<RegistrationDto> dtos=registrations.stream().map(r->mapToDto(r)).collect(Collectors.toList());

        return dtos;
    }


    public RegistrationDto getRegistrationById(long id){

        Registration registration= registrationRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundExeption("Record not found"));

        return mapToDto(registration);
    }


 
}
