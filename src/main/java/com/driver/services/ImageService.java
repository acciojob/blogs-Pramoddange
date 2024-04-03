package com.driver.services;
import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog

        Image obj=new Image(description,dimensions);
        Blog m=blogRepository2.findById(blogId).orElseGet(null);
        if(m==null)
            return null;
        obj.setBlog(m);

        List<Image> arr=m.getImageList();
        arr.add(obj);
        m.setImageList(arr);

        blogRepository2.save(m);

        return obj;
        //add an image to the blog

    }

    public void deleteImage(Integer id){
     imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image x=imageRepository2.findById(id).orElse(null);
        if(x==null)
            return 0;

        String  arr[]=(x.getDimensions().split("X",2));


        String  arr2[]=(screenDimensions.split("X",2));

        int c=(int)(Math.floor((double)Integer.parseInt(arr2[0])/(double)Integer.parseInt(arr[0]))*Math.floor((double)Integer.parseInt(arr2[1])/(double)Integer.parseInt(arr[1])));


        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        return c;
    }
}
