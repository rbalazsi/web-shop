package com.webshop.catalogservice.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "media", description = "Operations on product media (photos, etc.)")
public class MediaResource {

    @Autowired
    ServletContext context;

    @ApiOperation(
            value = "Returns the product's photo on a given path.", httpMethod = "GET", response = byte[].class)
    @RequestMapping(value = "/media/{file:.+}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getProductPhoto(@PathVariable("file") String imagePath) throws IOException {
        InputStream in = context.getClassLoader().getResourceAsStream("media/" + imagePath);
        return IOUtils.toByteArray(in);
    }
}
