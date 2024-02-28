package com.gmeta.gmetausersservice.POJO;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "commercial")
public class Commercial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String commercialId;

    private com.gmeta.gmetausersservice.enums.Commercial profit;


}
