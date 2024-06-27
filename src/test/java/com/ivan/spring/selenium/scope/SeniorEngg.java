package com.ivan.spring.selenium.scope;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SeniorEngg {

    @Autowired
    private Salary salary;

    public void setAmount(int amount){
        this.salary.setAmount(amount);
    }


}
