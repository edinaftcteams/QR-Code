package qr.code;

import java.io.IOException;
import java.nio.file.Paths;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class GenerateQRCode {
    // static function that creates QR Code
    public void generateCode(String data, String path, String charset, int h, int w)
            throws WriterException, IOException {
        // the BitMatrix class represents the 2D matrix of bits
        // MultiFormatWriter is a factory class that finds the appropriate Writer
        // subclass for the BarcodeFormat requested and encodes the barcode with the
        // supplied contents.
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, w, h);
        try {
            MatrixToImageWriter.writeToPath(matrix, "png", Paths.get(path));
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
    }
}