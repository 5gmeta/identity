package com.gmeta.gmetausersservice.POJO;

import com.gmeta.gmetausersservice.enums.Commercial;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Geolimit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String geolimitId;
    private com.gmeta.gmetausersservice.enums.Geolimit positions;
}
