package com.practice.question_service.entitiesModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class Response {
    private Integer id;
    private String response;
}
