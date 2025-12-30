package org.example.expexecutorservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Service
public class ImageProcessingSvc {

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    // Without Executor Service
    public void processImagesWithoutExecSvc(List<String> imagePaths) {
        for (String imagePath : imagePaths) {
            compressImg(imagePath);
        }
    }

    // With Executor Service
    public void processImages(List<String> imagePaths) {
        for (String imagePath : imagePaths) {
            executorService.submit(() -> compressImg(imagePath));
        }
    }

    private static void compressImg(String imagePath) {
        try {
            log.debug("Processing {} with Thread {}", imagePath, Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
