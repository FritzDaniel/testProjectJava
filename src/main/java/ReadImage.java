import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;

public class ReadImage {

    public static void main(String[] args) {
        String hasil_en = "";
        String hasil_cn = "";
        Tesseract english = new Tesseract();
        english.setLanguage("eng");
        Tesseract chinese = new Tesseract();
        chinese.setLanguage("chi_sim");
        try {
            String str = english.doOCR(new File("C:\\Users\\danie\\Downloads\\ImageWithWords1.jpg"));
            //System.out.println("Data From Image: \n" + str);
            hasil_en += str;
        } catch (TesseractException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            String str2 = english.doOCR(new File("C:\\Users\\danie\\Downloads\\ImageWithWords2.png"));
            hasil_en += str2;
        } catch (TesseractException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            String str3 = english.doOCR(new File("C:\\Users\\danie\\Downloads\\ImageWithWords3.jpg"));
            hasil_en += str3;
        } catch (TesseractException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            String str4 = chinese.doOCR(new File("C:\\Users\\danie\\Downloads\\ImageWithWords4.jpg"));
            hasil_cn += str4;
        } catch (TesseractException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            FileUtils.writeStringToFile(new File("en.doc"), hasil_en, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileUtils.writeStringToFile(new File("cn.doc"), hasil_cn, "Big5");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
