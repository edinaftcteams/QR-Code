package qr.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class GenerateQRCode {
    // static function that creates QR Code
    public static void generateQRcode(String data, String path, String charset, int h, int w)
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

    // main() method
    public static void main(String args[]) throws WriterException, IOException {
        // data that we want to store in the QR code
        String str = "Edina FTC robots QR Codes.";
        // path where we want to get QR Code
        String path = "G:\\Windows Folders\\Documents\\github\\rhsftc\\QR Code\\codes\\qr.png";
        // Encoding charset to be used
        String charset = "UTF-8";
        // generates QR code with Low level(L) error correction capability
        // invoking the user-defined method that creates the QR code
        generateQRcode(str, path, charset, 200, 200);// increase or decrease height and width accodingly
        // prints if the QR code is generated
        System.out.println("QR Code created successfully.");

        File file = new File(path);

        QRCodeReader qrCodeReader = new QRCodeReader();
        String encodedContent = qrCodeReader.readQRCode(file);

        System.out.println(encodedContent);
    }
}