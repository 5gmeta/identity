package com.gmeta.gmetausersservice.wrapper;

import com.gmeta.gmetausersservice.POJO.Address;
import com.gmeta.gmetausersservice.POJO.PreferredLicense;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWrapper {
    private String user_id;
    private Address address;
    private PreferredLicense preferredLicense;
}
