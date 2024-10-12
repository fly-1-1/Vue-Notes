package com.jy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
@AllArgsConstructor
public class Result {
    private Boolean status = true;
    private String msg;
}
