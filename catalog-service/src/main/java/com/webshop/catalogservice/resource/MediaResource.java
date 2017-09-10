package com.webshop.catalogservice.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class MediaResource {

    @Autowired
    ServletContext context;

    @RequestMapping(value = "/media/{file:.+}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getProductPhoto(@PathVariable("file") String imagePath) throws IOException {
        InputStream in = context.getClassLoader().getResourceAsStream("media/" + imagePath);
        return IOUtils.toByteArray(in);
    }
}
