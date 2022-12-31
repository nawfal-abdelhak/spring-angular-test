package lu.atozdigital.api.Utils;

import org.apache.commons.io.FilenameUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Random;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ImageHandler {

    private  static String ImageDirectory ="src/main/webapp/images/";

    public  static String  uploadFile(MultipartFile image) throws IOException {
        Path imageStorage=null;
        String imagename = StringUtils.cleanPath(image.getOriginalFilename());
        String ext = FilenameUtils.getExtension(imagename);
        imagename = getRadmomString()+"."+ext;

        imageStorage = get(ImageDirectory, imagename).toAbsolutePath().normalize();

            copy(image.getInputStream(), imageStorage, REPLACE_EXISTING);

        return imagename;
    }

    public  static String getRadmomString() {
        String SALTCHARS = "abcdefghijklmnopqrstuvyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 9) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
