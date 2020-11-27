package com.scurtis.recruits.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Author: Steve Curtis
 * Date: Apr 26, 2020
 **/

@Data
@Table(value = "recruits_two47")
public class Two47 {

    @Id
    private Integer id;
    private Integer siteId;
    private String name;
    private String position;
    private String height;
    private String weight;
    private String homeTown;
    private String highSchool;
    private Integer year;
    private String compositeRank;
    private Integer rankNational;
    private Integer rankPosition;
    private Integer rankState;
    private Integer stars;
    private String link;
    private String college;

}
