package qr.code;

import java.io.File;
import java.io.IOException;
import com.google.zxing.WriterException;

public class QRCode {
  // main() method
  public static void main(String[] args) throws IOException {
    // data that we want to store in the QR code
    String str = "Edina FTC robots QR Codes.";
    // path where we want to get QR Code
    String path = "qr.png";
    // Encoding charset to be used
    String charset = "UTF-8";
    // invoking the user-defined method that creates the QR code
    try {
      GenerateQRCode generateQRcode = new GenerateQRCode();
      generateQRcode.generateCode(str, path, charset, 200, 200);// increase or decrease height and width accordingly
      // prints if the QR code is generated
      System.out.println("QR Code created successfully.");
    } catch (WriterException ex) {
      System.out.println(ex.getMessage());
    }

    File file = new File(path);

    QRCodeReader qrCodeReader = new QRCodeReader();
    String encodedContent = qrCodeReader.readQRCode(file);

    System.out.println("QR Code: " + encodedContent);
  }

}
