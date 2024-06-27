package com.cms.client.common;


import com.cms.client.common.data.DomainEnum;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.MalformedURLException;

@RestController
@RequestMapping("/images/{domain}")
public class ImageController {

    @GetMapping("/{fileName}")
    public Resource image(@PathVariable DomainEnum domain, @PathVariable String fileName) throws MalformedURLException {
        return new UrlResource("file:" + domain.getPath() + File.separator + fileName);
    }
}
