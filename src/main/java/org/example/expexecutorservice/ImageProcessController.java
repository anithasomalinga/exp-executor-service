package org.example.expexecutorservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageProcessController {

    @Autowired
    private ImageProcessingSvc imageProcessingSvc;

    @PostMapping("/processNormally")
    public String imageProcessor1(@RequestBody List<String> imagePaths) {
        imageProcessingSvc.processImagesWithoutExecSvc(imagePaths);
        return "Images processed successfully";
    }

    @PostMapping("/processUsingExecutorService")
    public String imageProcessor2(@RequestBody List<String> imagePaths) {
        imageProcessingSvc.processImages(imagePaths);
        return "Images processed successfully";
    }
}
