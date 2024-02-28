package com.gmeta.gmetausersservice.POJO;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

// @NamedQuery(name = "PreferredLicense.updateCommercials", query = "update PreferredLicense p set p.commercials=:requestObj.commercials where p.id=:id")
@Entity
@Access( AccessType.FIELD )
@Data
@Table(name = "preferred_license")
public class PreferredLicense {
    @Id
    private String preferredLicenseId;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> commercials;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> geolimits;

    public PreferredLicense() {}
    public PreferredLicense(PreferredLicense preferredLicense) {
    }
}
