package com.ivan.spring.selenium.kelvin.service;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

@Lazy
@Service
@Log4j2
public class ScreenshotService {

    private static final String PNG_FILE_EXTENSION = ".png";

    @Autowired
    private ApplicationContext ctx;

    @Value("${screenshot.path}")
    private Path path;

    @Autowired
    private Faker faker;

    @PostConstruct
    public void init() {
        clearScreenshotFolder();
    }

    public void takeScreenShot() {
        File sourceFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);

        try {
            Path directoryPath = path.resolve(buildFileName()).getParent();
            if (directoryPath != null) {
                // Create the directory if it does not exist
                Files.createDirectories(directoryPath);
            }
            // Copy the screenshot to the folder
            FileCopyUtils.copy(sourceFile, path.resolve(buildFileName()).toFile());
        } catch (IOException e) {
            throw new RuntimeException("Error while taking screenshot: " + e.getMessage());
        }
    }

    public byte[] getScreenshot() {
        return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }

    public void clearScreenshotFolder() {
        if (Files.exists(path)) {
            try {
                FileUtils.deleteDirectory(new File(path.toString()));
                log.info("Screenshot folder deleted");
            } catch (IOException e) {
                throw new RuntimeException("Error while deleting screenshots: " + e.getMessage());
            }
        } else {
            log.info("Screenshot folder already deleted");
        }
    }

    private String buildFileName() {
        return String.join("_",
                LocalDateTime.now().toString(), faker.name().firstName())
                + PNG_FILE_EXTENSION;
    }

}
