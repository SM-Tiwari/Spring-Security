package com.gnv.vnm.selfcare.core.utils;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.util.FileCopyUtils;

import net.coobird.thumbnailator.Thumbnails;

/**
 * 
 * @author http://blog.netgloo.com/2015/03/03/spring-boot-crop-uploaded-image/
 * @author http://www.mkyong.com/java/how-to-resize-an-image-in-java/
 *
 */
public class ImageUtils {

	public static void cropImageSquare(byte[] image, File output, String format) throws IOException {
		// Get a BufferedImage object from a byte array
		InputStream in = new ByteArrayInputStream(image);
		BufferedImage originalImage = ImageIO.read(in);

		// Get image dimensions
		int height = originalImage.getHeight();
		int width = originalImage.getWidth();

		// The image is already a square
		if (height == width) {
			return;
		}

		// Compute the size of the square
		int squareSize = (height > width ? width : height);

		// Coordinates of the image's middle
		int xc = width / 2;
		int yc = height / 2;

		// Crop
		BufferedImage croppedImage = originalImage.getSubimage(xc - (squareSize / 2), yc - (squareSize / 2), squareSize, squareSize);

		ImageIO.write(croppedImage, format, output);
	}

	public static void resizeImage(InputStream input, int type, File output, String format, int width, int height) throws IOException{
		BufferedImage originalImage = ImageIO.read(input);
		
		int h = originalImage.getHeight();
		int w = originalImage.getWidth();
		if (h == height && w == width) {
			FileCopyUtils.copy(input, new FileOutputStream(output));
			return;
		}
		
		BufferedImage resizeImage = resizeImageWithHint(originalImage, type, width, height);
		ImageIO.write(resizeImage, format, output);
	}
	
	public static void resizeImage(File input, int type, File output, String format, int width, int height) throws IOException{
		resizeImage(new FileInputStream(input), type, output, format, width, height);
	}
	
	private static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type, int width, int height) {
		if (type == 0) type = BufferedImage.TYPE_INT_ARGB;
		
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
		g.setComposite(AlphaComposite.Src);

		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		return resizedImage;
	}
	
	public static void resize(String inputImagePath,
            String outputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
 
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
 
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
 
        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);
 
        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }
 
	/*
	private static BufferedImage resizeImage(BufferedImage originalImage, int type, int width, int height) {
		if (type == 0) type = BufferedImage.TYPE_INT_ARGB;
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();

		return resizedImage;
	}
	*/
	
	public static void main(String[] args){
		String input = "/Users/nandipinto/Temp/Screen Shot 2017-06-15 at 18.21.11.png";
		String result = "/Users/nandipinto/Temp/Screen Shot 2017-06-15 at 18.21.11.resized.png";
		try {
//			ImageUtils.resize(input, result, 200, 200);
			
			Thumbnails.of(new File(input)).scale(0.50).toFile(new File(result));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
