import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Convolution {

	public static BufferedImage getImg(String path) throws IOException{
		BufferedImage res = null;
		File f = new File(path);
		res = ImageIO.read(f);
		return res;
	}
	
	public static int[][] get2DVectorFromImage(int w, int h, BufferedImage img){
		int [][] grayMat = new int[h][w]; 
    	for(int i = 0; i < h; i++)
    	{
    		for(int j = 0; j < w; j++)
    		{
    			Color cc = new Color(img.getRGB(j, i));
    			grayMat[i][j] = (cc.getBlue()+cc.getGreen()+cc.getRed())/3;
    		}
    	}
		return grayMat;
	}
	
	public static int convolutionProduct(int[][] img, float[][] mask, int x, int y){
		int res = 0;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				res += (int) img[x-1+i][y-1+j]*mask[i][j];
			}
		}
		if(res < 0)
			return 0;
		if(res > 255)
			return 255;
		return res;
	}
	
	public static void applyInFilter(int[][] img, float [][] mask, int[][] output, int w, int h){
		for(int i = 1; i < h-1; i++){
			for(int j = 1; j < w-1; j++){
				output[i][j] = convolutionProduct(img, mask, i,j);
			}
		}
	}
	
//	public static void applyCornerFilter(int[][] img, float [][] mask, int[][] output, int w, int h){
//		//angolo in alto a sinistra, pixel in pos (0,0)
//		int res = 0;
//		for(int i = 0; i < 2; i++){
//			for(int j = 0; j < 2; j++){
//				res += img[i][j]*mask[i+1][j+1];
//			}
//		}
//		output[0][0] = res;
//		//angolo in alto a destra, pixel in pos(0,w-1)
//		res = 0;
//		for(int i = 0; i < 2; i++){
//			for(int j = 0; j < 2; j++){
//				res += img[i][w-1-j]*mask[i+1][1-j];
//			}
//		}
//		output[0][w-1] = res;
//		//angolo in basso a sinistra, pixel in pos(h-1,0)
//		res = 0;
//		for(int i = 0; i < 2; i++){
//			for(int j = 0; j < 2; j++){
//				res += img[h-1-i][j]*mask[1-i][j+1];
//			}
//		}
//		output[h-1][0] = res;
//		//angolo in basso a destra, pixel in pos(h-1,w-1)
//		res = 0;
//		for(int i = 0; i < 2; i++){
//			for(int j = 0; j < 2; j++){
//				res += img[h-1-i][w-1-i]*mask[1-i][1-j];
//			}
//		}
//		output[h-1][w-1] = res;
//	}
//	
	

	public static void convert2DVectorToImg(int[][] output, String path, int w, int h) throws IOException{
		BufferedImage grayFrame = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				Color cn = new Color(output[i][j], output[i][j], output[i][j]);
				grayFrame.setRGB(j, i, cn.getRGB());
			}
		}
		File f = new File(path);
		ImageIO.write(grayFrame, "jpg", f);
	}
	
	public static void convertFunction(String input, String output, float mask[][]) throws IOException{
		BufferedImage img = getImg(input);
		int height = img.getHeight();
		int width = img.getWidth();
		int[][] mat = get2DVectorFromImage(width, height, img);
		int[][] res = new int[height][width];
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				res[i][j] = 0;
			}
		}
		applyInFilter(mat, mask, res, width, height);
		convert2DVectorToImg(res, output, width, height);
		
	}
	

}
