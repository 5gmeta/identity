package com.gmeta.gmetausersservice.rest;

import com.gmeta.gmetausersservice.POJO.Address;
import com.gmeta.gmetausersservice.POJO.PreferredLicense;
import com.gmeta.gmetausersservice.POJO.UserBusinessInfo;
import com.gmeta.gmetausersservice.wrapper.UserWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping(path = "/user-business-info")
public interface UserBusinessInfoRest {
    @PostMapping(path = "/signup")
    public ResponseEntity<String> signUp(@RequestBody(required=true) UserBusinessInfo requestObj) throws IOException;
    @GetMapping(path = "/address/{addressId}")
    public Optional<Address> getAddressById(@PathVariable("addressId") String id);

    @GetMapping(path = "/preferredLicense/{preferredLicenseId}")
    public Optional<PreferredLicense> getPreferredLicenseById(@PathVariable("preferredLicenseId") String id);

    @GetMapping(path = "/{userId}")
    public Optional<UserBusinessInfo> getUserBusinessInfoById(@PathVariable("userId") String id);

    @GetMapping(path = "/get")
    public ResponseEntity<List<UserWrapper>> getAllUser();
    @PostMapping(path = "/address/save")
    public ResponseEntity<String> saveAddress(@RequestBody(required=true) Address requestObj);

    @PostMapping(path = "/address/update")
    public ResponseEntity<String> updateAddress(@RequestBody(required=true) Address requestObj);

    @PostMapping(path = "/preferred-license/save")
    public ResponseEntity<String> savePreferredLicense(@RequestBody(required=true) PreferredLicense requestObj);

    @PostMapping(path = "/preferred-license/update")
    public ResponseEntity<String> updatePreferredLicense(@RequestBody(required=true) PreferredLicense requestObj);
}
