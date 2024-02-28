package com.gmeta.gmetausersservice.dao;


import com.gmeta.gmetausersservice.POJO.PreferredLicense;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PreferredLicenseDao extends JpaRepository<PreferredLicense, String> {

    Optional<PreferredLicense> findById(@Param("id") String id);

    @Transactional
    @Modifying
    Integer commercials(@RequestBody() PreferredLicense requestObj);
}
