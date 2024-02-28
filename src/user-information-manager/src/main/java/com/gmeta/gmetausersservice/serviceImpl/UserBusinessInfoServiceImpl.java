package com.gmeta.gmetausersservice.serviceImpl;

import com.gmeta.gmetausersservice.POJO.Address;
import com.gmeta.gmetausersservice.POJO.PreferredLicense;
import com.gmeta.gmetausersservice.POJO.UserBusinessInfo;
import com.gmeta.gmetausersservice.constants.G5metaConstants;
import com.gmeta.gmetausersservice.dao.AddressDao;
import com.gmeta.gmetausersservice.dao.PreferredLicenseDao;
import com.gmeta.gmetausersservice.dao.UserBusinessInfoDao;
import com.gmeta.gmetausersservice.service.UserBusinessInfoService;
import com.gmeta.gmetausersservice.utils.G5metaUtils;
import com.gmeta.gmetausersservice.wrapper.UserWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class UserBusinessInfoServiceImpl implements UserBusinessInfoService {
    @Autowired
    UserBusinessInfoDao userBusinessInfoDao;
    @Autowired
    AddressDao addressDao;
    @Autowired
    PreferredLicenseDao preferredLicenseDao;
    @Override
    public ResponseEntity<String> signUp(UserBusinessInfo requestObj) {
        log.info("Inside signup {}", requestObj);
        try {
            if (validateSignUpObj(requestObj)) {
                Optional<UserBusinessInfo> userBusinessInfo = userBusinessInfoDao.findById(requestObj.getUser_id());

                if (userBusinessInfo.equals(Optional.empty())) {
                    Address address = new Address(requestObj.getAddress());
                    address.setAddressID(requestObj.getUser_id());
                    address.setCity(requestObj.getAddress().getCity());
                    address.setStreet(requestObj.getAddress().getStreet());
                    address.setStreetNumber(requestObj.getAddress().getStreetNumber());
                    address.setPostalCode(requestObj.getAddress().getPostalCode());
                    addressDao.saveAndFlush(address);

                    PreferredLicense preferredLicense = new PreferredLicense(requestObj.getPreferredLicense());
                    preferredLicense.setPreferredLicenseId(requestObj.getUser_id());
                    preferredLicense.setCommercials(requestObj.getPreferredLicense().getCommercials());
                    preferredLicense.setGeolimits(requestObj.getPreferredLicense().getGeolimits());
                    preferredLicenseDao.saveAndFlush(preferredLicense);
                    userBusinessInfoDao.saveAndFlush(getUserBusinessInfoFromObj(requestObj));
                    return G5metaUtils.getResponseEntity("Successfully Register.", HttpStatus.OK);
                } else {
                    Address address = new Address(requestObj.getAddress());
                    address.setAddressID(requestObj.getUser_id());
                    address.setCity(requestObj.getAddress().getCity());
                    address.setStreet(requestObj.getAddress().getStreet());
                    address.setStreetNumber(requestObj.getAddress().getStreetNumber());
                    address.setPostalCode(requestObj.getAddress().getPostalCode());
                    log.info("What is in address here {}",requestObj.getAddress());
                    addressDao.saveAndFlush(address);

                    PreferredLicense preferredLicense = new PreferredLicense(requestObj.getPreferredLicense());
                    preferredLicense.setPreferredLicenseId(requestObj.getUser_id());
                    preferredLicense.setCommercials(requestObj.getPreferredLicense().getCommercials());
                    preferredLicense.setGeolimits(requestObj.getPreferredLicense().getGeolimits());
                    log.info("What is in preferredLicense when update now ==>{}",preferredLicense);
                    preferredLicenseDao.saveAndFlush(preferredLicense);
                    userBusinessInfoDao.saveAndFlush(getUserBusinessInfoFromObj(requestObj));
                    return G5metaUtils.getResponseEntity("Successfully Updated.", HttpStatus.OK);
                }

            } else {
                return G5metaUtils.getResponseEntity(G5metaConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return G5metaUtils.getResponseEntity(G5metaConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> saveAddress(Address requestObj) {

        try {
            if (validateAddressObj(requestObj)) {
                Optional<Address> address = addressDao.findById(requestObj.getAddressID());
                if (address.equals(Optional.empty())) {
                    addressDao.save(getAddressFromObj(requestObj));
                    return G5metaUtils.getResponseEntity("Successfully Register.", HttpStatus.OK);
                } else {
                    return G5metaUtils.getResponseEntity("UserId already exist.", HttpStatus.BAD_REQUEST);
                }
            } else {
                return G5metaUtils.getResponseEntity(G5metaConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return G5metaUtils.getResponseEntity(G5metaConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updateAddress(Address requestObj) {
        log.info("What is in requestMap in serviceImpl==> {}",requestObj);
        try {
            Optional<Address> optional =  addressDao.findById(requestObj.getAddressID());
            if(!optional.isEmpty()) {
                addressDao.saveAndFlush(requestObj);
                return G5metaUtils.getResponseEntity(G5metaConstants.UPDATED_SUCCESSFULLY, HttpStatus.OK);
            } else {
                return   G5metaUtils.getResponseEntity("Address Id, not exist, {id}",HttpStatus.OK);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return G5metaUtils.getResponseEntity(G5metaConstants.UPDATED_SUCCESSFULLY, HttpStatus.OK);
    }

    @Override
    public Optional<Address> getAddressById(String id) {
        return addressDao.findById(id);
    }

    @Override
    public Optional<PreferredLicense> getPreferredLicenseById(String id) {
        return preferredLicenseDao.findById(id);
    }
    @Override
    public Optional<UserBusinessInfo> getUserBusinessInfoById(String id) {
        Optional<UserBusinessInfo> userBusinessInfo=userBusinessInfoDao.findById(id);
        if(userBusinessInfo.isPresent()) {
           return  userBusinessInfo;
        } else {
            return  userBusinessInfo;
        }
    }

    @Override
    public ResponseEntity<List<UserWrapper>> getAllUser() {
        try {
            log.info("is code come intil here ??");
         return new ResponseEntity<>(userBusinessInfoDao.getAllUser(), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> savePreferredLicense(PreferredLicense requestObj) {
        return null;
    }

    @Override
    public ResponseEntity<String> updatePreferredLicense(PreferredLicense requestObj) {
        log.info("What is in requestMap in serviceImpl==> {}",requestObj);
        try {
         Optional<PreferredLicense> optional =  preferredLicenseDao.findById(requestObj.getPreferredLicenseId());
         if(!optional.isEmpty()) {
             preferredLicenseDao.saveAndFlush(requestObj);
             return G5metaUtils.getResponseEntity(G5metaConstants.UPDATED_SUCCESSFULLY, HttpStatus.OK);
         } else {
           return   G5metaUtils.getResponseEntity("Preferred Id, not exist, {id}",HttpStatus.OK);
         }
        }catch (Exception ex) {
           ex.printStackTrace();
        }
        return G5metaUtils.getResponseEntity(G5metaConstants.UPDATED_SUCCESSFULLY, HttpStatus.OK);
    }
    private boolean validateSignUpObj(UserBusinessInfo requestObj){
          return true;
    }

    private boolean validateAddressObj(Address requestObj){
        return true;
    }

    private UserBusinessInfo getUserBusinessInfoFromObj(UserBusinessInfo responseObj) {
        UserBusinessInfo userBusinessInfo = new UserBusinessInfo();
        userBusinessInfo.setUser_id(responseObj.getUser_id());
        userBusinessInfo.setAddress(responseObj.getAddress());
        userBusinessInfo.setPreferredLicense(responseObj.getPreferredLicense());
        return userBusinessInfo;
    }

    private Address getAddressFromObj(Address responseObj) {
        Address address = new Address();
        address.setAddressID(responseObj.getAddressID());
        address.setCity(responseObj.getCity());
        address.setStreet(responseObj.getStreet());
        address.setStreetNumber(responseObj.getStreetNumber());
        address.setPostalCode(responseObj.getPostalCode());
        return address;
    }
}
