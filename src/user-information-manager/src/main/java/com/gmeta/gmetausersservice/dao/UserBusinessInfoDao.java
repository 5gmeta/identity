package com.gmeta.gmetausersservice.dao;

import com.gmeta.gmetausersservice.POJO.UserBusinessInfo;
import com.gmeta.gmetausersservice.wrapper.UserWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserBusinessInfoDao extends JpaRepository<UserBusinessInfo, String> {

    Optional<UserBusinessInfo> findById(@Param("id") String id);

    List<UserWrapper> getAllUser();
}
