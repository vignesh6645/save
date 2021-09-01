package com.example.Emp.employee;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
public class BaseResponse<T> {
    String StatusCode;
    String StatusMsg;
    private T Data;
}
