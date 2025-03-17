package com.api.controller;

import com.api.entity.Registration;
import com.api.entity.RegistrationDto;
import com.api.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
//http://localhost:8080/api/v1/registration
//    @GetMapping
//    public ResponseEntity<List<Registration>> getAllRegistrations(){
//        List<Registration> registrations = registrationService.getRegistrations();
//
//        return new ResponseEntity<>(registrations, HttpStatus.OK);
//    }

    //saving data
 @PostMapping
    public ResponseEntity<?> createRegistration(@Valid  @RequestBody Registration registration,BindingResult bindingResult){

        //only validations
        if(bindingResult.hasErrors()) {

            List<String> errorMessages = bindingResult.getFieldErrors().stream().map(er -> er.getDefaultMessage()).collect(Collectors.toList());
            return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
        }
            Registration reg = registrationService.createRegistration(registration);

            return new ResponseEntity<>(reg, HttpStatus.CREATED);


    }





    @DeleteMapping
    public ResponseEntity<String> deleteRegistration( @RequestParam long id){

         registrationService.deleteRegistration(id);


     return new ResponseEntity<>("Delete",HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRegistration(
                                    @PathVariable long id,
                                   @Valid @RequestBody Registration registration,BindingResult bindingResult){
        if(bindingResult.hasErrors()) {

            List<String> errorMessages = bindingResult.getFieldErrors().stream().map(er -> er.getDefaultMessage()).collect(Collectors.toList());
            return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
        }
        Registration updateReg=registrationService.updateRegistration(id,registration);
        return new ResponseEntity<>(updateReg, HttpStatus.OK);



    }

    //saving data by entity getting by dto not having id

//    @PostMapping
//    public ResponseEntity<RegistrationDto> createRegistration(@RequestBody Registration registration){
//        RegistrationDto dto = registrationService.createRegistration(registration);
//        return new ResponseEntity<>(dto,HttpStatus.CREATED);
//
//    }

    //taking data by dto , giving response  by dto (saving in db by entity)


//   @PostMapping
//    public ResponseEntity<RegistrationDto> createRegistration(@RequestBody RegistrationDto registrationDto){
//       RegistrationDto dto = registrationService.createRegistration(registrationDto);
//     return new ResponseEntity<>(dto,HttpStatus.CREATED);
//
//   }

    //http://localhost:8080/api/v1/registration
    @GetMapping
    public ResponseEntity<List<RegistrationDto>> getAllRegistrations(){
        List<RegistrationDto> dtos = registrationService.getRegistrations();

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/registration
    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDto> getRegistartionById(@PathVariable long id){
        RegistrationDto dto = registrationService.getRegistrationById(id);

       return new ResponseEntity<>(dto,HttpStatus.OK);

    }


//validation

 /*   @PostMapping
    public ResponseEntity<?> createRegistration(


                  @Valid @RequestBody RegistrationDto registrationDto,BindingResult result){

        if(result.hasErrors()){

            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST));

        }

        Object dto = registrationService.createRegistration(registrationDto);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);

    }*/


}
