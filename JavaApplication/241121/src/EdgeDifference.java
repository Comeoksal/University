import java.io.File; // 파일 추가를 위함
import java.io.IOException; // 입출력 예외 고려
import java.awt.Color; // 컬러형태의 이미지를 색상으로 표현하기 위한 자료형(Color to RGB & RGB to Color)
import java.awt.image.BufferedImage; // 이미지 불러오기와 저장하기 위한 자료형
import javax.imageio.ImageIO; // 이미지 입출력

public class EdgeDifference{
    private BufferedImage SourceImage = null; // BufferedImage 자료형에 null값 부여
    private BufferedImage TargetImage = null;

    private int width, height; // 이미지의 가로, 세로 길이 값
    private int row, column; // 이미지는 수 많은 픽셀의 2차원 배열로 이루어짐
    private int red, green, blue; // RGB 값 (0~255)
    
    private Color color, new_color; // color = 이미지 색상 불러온 값, new_color = 변형된 색상 값
    private int average; //RGB (8비트), +투명도 (8비트)

    private File U_InputFile = null; // 불러올 파일 이름과 경로를 저장할 변수
    private File U_OutputFile = null;

    public EdgeDifference(String U_InputFile_Path, String U_OutputFile_Path, int _edge){
        //Read in the input image
        U_InputFile = new File(U_InputFile_Path);
        U_OutputFile = new File(U_OutputFile_Path);

        try{ // 이미지를 지정된 경로로 불러오고 예외 처리
            SourceImage = ImageIO.read(U_InputFile);
            TargetImage = ImageIO.read(U_InputFile);
        }
        catch(IOException e){ //에러 발생시 출력
            System.out.println(e);
        }

        //Get image width & height
        width = SourceImage.getWidth();
        height = SourceImage.getHeight();

        //Make TargetImage white image
        new_color = new Color(255, 255, 255);   
        for(column = 0; column<=height-1; column++){ //위에서부터 아래로 내려오는 각 줄에 대해서
            for(row =0; row<=width-1; row++){       //왼쪽부터 오른쪽으로 가는 각 행의 픽셀에 대해
                TargetImage.setRGB(row, column, new_color.getRGB()); //new_color(흰색) 값 부여
            }
        }
        
        //Color Change
        for(column = 0; column<=height-1; column++){
            for(row = 0; row<=width-1; row++){
                //픽셀 하나를 읽어온다
                color = new Color(SourceImage.getRGB(row, column)); // 입력된 이미지에서 row, column 위치에 한 픽셀을 불러옴
                red = (int) (color.getRed());
                green = (int) (color.getGreen());
                blue = (int) (color.getBlue());
                int gray = (int)((red + green + blue)/3);

                if(column!=height-1&&row!=width-1){
                    Color color_right = new Color(SourceImage.getRGB(row+1, column));
                        red = (int) (color_right.getRed());
                        green = (int) (color_right.getGreen());
                        blue = (int) (color_right.getBlue());
            
                        int gray_right = (int)((red + green+ blue)/3);
                        int difference1 = Math.abs(gray-gray_right);
                        if(difference1>_edge){
                            color_right = new Color(difference1, difference1, difference1);
                            TargetImage.setRGB(row, column, color_right.getRGB());
                        }

                        Color color_down = new Color(SourceImage.getRGB(row, column+1));
                        red = (int) (color_down.getRed());
                        green = (int) (color_down.getGreen());
                        blue = (int) (color_down.getBlue());
                        int gray_down = (int)((red + green+ blue)/3);
                        int difference2 = Math.abs(gray-gray_down);
                        if(difference2>_edge){
                            color_down = new Color(difference2, difference2,difference2);
                            TargetImage.setRGB(row, column, color_down.getRGB());
                        }
                }
            }
        }
        
        //Write out the result image
        try{ //이미지를 지정된 경로로 저장하고 예외 처리
            ImageIO.write(TargetImage, "png", U_OutputFile); 
        }
        catch(IOException e){ //에러 발생시 출력
            System.out.println(e);
        }
    }
}

