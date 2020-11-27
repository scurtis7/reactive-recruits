package com.scurtis.recruits.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Author: Steve Curtis
 * Date: Oct 24, 2020
 **/

@Data
@Table(value = "colleges")
public class College {

    @Id
    private Integer id;
    private String siteName;
    private String displayName;
    private String conference;
    private String division;

}
