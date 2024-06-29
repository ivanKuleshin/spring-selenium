package com.ivan.spring.selenium.kelvin.config;

import com.ivan.spring.selenium.kelvin.annotation.LazyConfiguration;
import com.ivan.spring.selenium.kelvin.annotation.ThreadLocalBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

/**
 * Configuration class for setting up WebDriver instances for different browsers.
 * This configuration is used when the application is not running in the "remote" profile.
 * The beans defined in this class are lazily initialized.
 *
 * @author ivanKuleshin
 */
@Profile("!remote")
@LazyConfiguration
public class WebDriverConfig {

    /**
     * Creates a FirefoxDriver instance.
     * This bean is only created when the "browser" property in the application's configuration is set to "firefox".
     *
     * @return a new FirefoxDriver instance
     */
    @ThreadLocalBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    /**
     * Creates a SafariDriver instance.
     * This bean is only created when the "browser" property in the application's configuration is set to "safari".
     *
     * @return a new SafariDriver instance
     */
    @ThreadLocalBean
    @ConditionalOnProperty(name = "browser", havingValue = "safari")
    public WebDriver safariDriver() {
        WebDriverManager.safaridriver().setup();
        return new SafariDriver();
    }

    /**
     * Creates a ChromeDriver instance.
     * This bean is created only if there is no other bean of the same type already defined in the Spring context.
     * This makes Chrome the default browser if no specific browser is set in the application's configuration.
     * You can also use @ConditionalOnMissingBean annotation to achieve the same effect.
     *
     * @return a new ChromeDriver instance
     */
    @ThreadLocalBean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome", matchIfMissing = true)
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }


}