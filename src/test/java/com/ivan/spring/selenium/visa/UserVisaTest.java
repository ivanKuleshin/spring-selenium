package com.ivan.spring.selenium.visa;

import com.ivan.spring.selenium.SpringBaseTestNGTest;
import com.ivan.spring.selenium.entity.Customer;
import com.ivan.spring.selenium.page.visa.VisaRegistrationPage;
import com.ivan.spring.selenium.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;

public class UserVisaTest extends SpringBaseTestNGTest {

    private static final Logger logger = LoggerFactory.getLogger(UserVisaTest.class);

    @Autowired
    private VisaRegistrationPage registrationPage;

    @Autowired
    private UserRepository repository;

    @Test(dataProvider = "getData")
    public void visaTest(Customer u){
        this.registrationPage.goTo();
        this.registrationPage.setNames(u.getFirstName(), u.getLastName());
        this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
        this.registrationPage.setBirthDate(u.getDob().toLocalDate());
        this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
        this.registrationPage.setComments(u.getComments());
        this.registrationPage.submit();

        logger.info("Request confirmation # INFO : " + this.registrationPage.getConfirmationNumber());
        logger.warn("Request confirmation # WARN : " + this.registrationPage.getConfirmationNumber());

    }

    @DataProvider
    public Object[][] getData(ITestContext context){
        return this.repository.findByDobBetween(
                Date.valueOf("2000-01-01"),
                Date.valueOf("2010-01-01")
        )
                .stream()
                .limit(3)
                .map(o -> new Customer[]{o})
                .toArray(Object[][]::new);
    }


}
