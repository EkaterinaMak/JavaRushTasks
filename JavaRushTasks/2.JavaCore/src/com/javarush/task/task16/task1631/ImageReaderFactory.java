package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Alexander on 05.10.2017.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {

try {


        if (type.equals(ImageTypes.JPG)) {
            return new JpgReader();
        } else if (type.equals(ImageTypes.BMP)) {
            return new BmpReader();
        } else if (type.equals(ImageTypes.PNG)) {
            return new PngReader();
        } else {
            throw new IllegalArgumentException();
        }
} catch (Exception e) {
    throw new IllegalArgumentException();
}
}
}
