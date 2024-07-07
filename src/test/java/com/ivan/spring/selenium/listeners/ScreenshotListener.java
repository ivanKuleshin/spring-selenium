package com.ivan.spring.selenium.listeners;

import com.ivan.spring.selenium.kelvin.service.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Optional;

/**
 * The {@code ScreenshotListener} class implements {@link org.testng.ITestListener} to capture screenshots on test failures.
 * However, it faces a specific challenge with dependency injection due to the way TestNG listeners are instantiated.
 *
 * <p>Problem:</p>
 * Spring-managed beans, such as {@code ScreenshotService}, cannot be directly injected into TestNG listeners like {@code ScreenshotListener}.
 * This is because TestNG listeners are instantiated by the TestNG framework itself, which occurs before Spring has a chance to perform its dependency injection.
 * As a result, attempting to autowire Spring-managed beans into TestNG listeners using field injection or constructor injection will not work, leading to {@code null} references.
 *
 * <p>Solution:</p>
 * To overcome this limitation, {@code ScreenshotListener} utilizes a setter method for dependency injection. The {@code setScreenshotService} method is annotated with {@code @Autowired},
 * allowing Spring to inject the {@code ScreenshotService} bean after the instantiation of {@code ScreenshotListener}. This approach ensures that the {@code ScreenshotService} is properly
 * initialized and available for use within the listener, even though the listener itself is not directly managed by Spring.
 *
 * <p>Usage:</p>
 * Ensure that the {@code ScreenshotListener} is declared as a bean within the Spring application context, typically using the {@code @Component} annotation.
 * This makes it possible for Spring to recognize the {@code setScreenshotService} method as a target for autowired injection.
 */
@Component
public class ScreenshotListener implements ITestListener {

    private static ScreenshotService screenshotService;

    @Autowired
    public void setScreenshotService(ScreenshotService screenshotService) {
        ScreenshotListener.screenshotService = screenshotService;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Optional.ofNullable(screenshotService)
                .ifPresentOrElse(ScreenshotService::takeScreenShot, () -> {
                    throw new RuntimeException("ScreenshotService is not initialized!");
                });
    }
}
