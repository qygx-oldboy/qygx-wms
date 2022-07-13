import com.ruoyi.common.core.utils.barcode.BarcodeUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class test {

    public static void main(String[] args) throws IOException {
        BufferedImage image = BarcodeUtils.insertWords(BarcodeUtils.getBarCode("34101020100000112340"), "34101020100000112340");
        ImageIO.write(image, "jpg", new File("F:/barcode.png"));
    }


}
