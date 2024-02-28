package com.gmeta.gmetausersservice.restImpl;

import com.gmeta.gmetausersservice.POJO.Address;
import com.gmeta.gmetausersservice.POJO.PreferredLicense;
import com.gmeta.gmetausersservice.POJO.UserBusinessInfo;
import com.gmeta.gmetausersservice.constants.G5metaConstants;
import com.gmeta.gmetausersservice.rest.UserBusinessInfoRest;
import com.gmeta.gmetausersservice.service.UserBusinessInfoService;
import com.gmeta.gmetausersservice.utils.G5metaUtils;
import com.gmeta.gmetausersservice.wrapper.UserWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserBusinessInfoRestImpl implements UserBusinessInfoRest {

    public UserBusinessInfoRestImpl(UserBusinessInfoService userBusinessInfoService) {
        this.userBusinessInfoService = userBusinessInfoService;
    }

    UserBusinessInfoService userBusinessInfoService;
    @Override
    public ResponseEntity<String> signUp(UserBusinessInfo requestObj) throws IOException {
        log.info("Inside RestImpl ==> {}", requestObj);
       try {
            userBusinessInfoService.signUp(requestObj);
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
        return G5metaUtils.getResponseEntity(G5metaConstants.SUCCESSFULL_REGISTRED, HttpStatus.OK);
    }

    @Override
    public Optional<Address> getAddressById(String id) {
        Optional<Address> address = userBusinessInfoService.getAddressById(id);
        return address;
    }

    @Override
    public Optional<PreferredLicense> getPreferredLicenseById(String id) {
        Optional<PreferredLicense> preferredLicense = userBusinessInfoService.getPreferredLicenseById(id);
        return preferredLicense;
    }

    @Override
    public Optional<UserBusinessInfo> getUserBusinessInfoById(String id) {
        return userBusinessInfoService.getUserBusinessInfoById(id);
    }

    @Override
    public ResponseEntity<List<UserWrapper>> getAllUser() {
    try {
         return userBusinessInfoService.getAllUser();
    }catch (Exception ex) {
        ex.printStackTrace();
    }
     return new ResponseEntity<List<UserWrapper>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> saveAddress(Address requestObj) {
        try {
            userBusinessInfoService.saveAddress(requestObj);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return G5metaUtils.getResponseEntity(G5metaConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updateAddress(Address requestObj) {
        try {
            return userBusinessInfoService.updateAddress(requestObj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return G5metaUtils.getResponseEntity(G5metaConstants.UPDATED_SUCCESSFULLY, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> savePreferredLicense(PreferredLicense requestObj) {
        try {
            userBusinessInfoService.savePreferredLicense(requestObj);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return G5metaUtils.getResponseEntity(G5metaConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updatePreferredLicense(PreferredLicense requestObj) {
        try {
            return userBusinessInfoService.updatePreferredLicense(requestObj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         return G5metaUtils.getResponseEntity(G5metaConstants.UPDATED_SUCCESSFULLY, HttpStatus.OK);
    }
}
