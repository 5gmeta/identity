package com.gmeta.gmetausersservice.service;

import com.gmeta.gmetausersservice.POJO.Address;
import com.gmeta.gmetausersservice.POJO.PreferredLicense;
import com.gmeta.gmetausersservice.POJO.UserBusinessInfo;
import com.gmeta.gmetausersservice.wrapper.UserWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserBusinessInfoService {
    ResponseEntity<String> signUp(UserBusinessInfo requestObj);
    ResponseEntity<String> saveAddress(Address requestObj);
    ResponseEntity<String> updateAddress(Address requestObj);

    Optional<Address> getAddressById(String id);
    Optional<PreferredLicense> getPreferredLicenseById(String id);

    Optional<UserBusinessInfo> getUserBusinessInfoById(String id);
    ResponseEntity<List<UserWrapper>> getAllUser();

    ResponseEntity<String> savePreferredLicense(PreferredLicense requestObj);

    ResponseEntity<String> updatePreferredLicense(PreferredLicense requestObj);

}
