package com.gmeta.gmetausersservice.POJO;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@NamedQuery(name = "UserBusinessInfo.findById", query = "select u from UserBusinessInfo u where u.id=:id")

@NamedQuery(name="UserBusinessInfo.getAllUser", query = "select new  com.gmeta.gmetausersservice.wrapper.UserWrapper(u.user_id, u.address, u.preferredLicense) from UserBusinessInfo u")

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "userBusinessInfo")
@Data
public class UserBusinessInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private String user_id;
    @OneToOne
    @JoinColumn(name = "fk_user_address")
    private Address address;
    @OneToOne
    @JoinColumn(name = "fk_user_preferred_license")
    private PreferredLicense preferredLicense;
}
