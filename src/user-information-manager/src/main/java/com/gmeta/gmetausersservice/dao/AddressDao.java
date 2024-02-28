package com.gmeta.gmetausersservice.dao;

import com.gmeta.gmetausersservice.POJO.Address;
import com.gmeta.gmetausersservice.POJO.UserBusinessInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AddressDao extends JpaRepository<Address, String> {

    Optional<Address> findById(@Param("id") String id);
}
