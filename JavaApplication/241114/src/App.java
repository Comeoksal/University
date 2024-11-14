import java.util.*;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        String U_InputFile = "C:\\Users\\금시언\\Desktop\\2-2\\자바어플리케이션\\red.jpg";
        
        String U_OutputFile1 = "C:\\Users\\금시언\\Desktop\\2-2\\자바어플리케이션\\red(Gray1).jpg";
        String U_OutputFile2 = "C:\\Users\\금시언\\Desktop\\2-2\\자바어플리케이션\\red(Gray2).jpg";
        String U_OutputFile3 = "C:\\Users\\금시언\\Desktop\\2-2\\자바어플리케이션\\red(Gray3).jpg";

        Gray1 GI1 = new Gray1(U_InputFile, U_OutputFile1);
        Gray2 GI2 = new Gray2(U_InputFile, U_OutputFile2);
        Gray3 GI3 = new Gray3(U_InputFile, U_OutputFile3);
    }
}
