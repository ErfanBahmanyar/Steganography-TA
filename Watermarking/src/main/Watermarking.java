package main;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Watermarking {

    public static void main(String[] args) {
        String imagePath = "path/to/image.jpg"; // Path to the image file
        String watermarkPath = "path/to/watermark.png"; // Path to the watermark logo file
        String outputImagePath = "path/to/output.jpg"; // Path to the output file (image with watermark)

        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            BufferedImage watermark = ImageIO.read(new File(watermarkPath));

            // Adjust the size of the watermark logo according to the original image
            int watermarkWidth = image.getWidth() / 4;
            int watermarkHeight = watermarkWidth * watermark.getHeight() / watermark.getWidth();

            // Create an image with the watermark
            BufferedImage outputImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = outputImage.createGraphics();
            graphics.drawImage(image, 0, 0, null);

            // Set the opacity of the watermark logo
            float opacity = 0.5f; // You can change the opacity as desired
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

            // Apply the watermark on the image
            graphics.drawImage(watermark, image.getWidth() - watermarkWidth, image.getHeight() - watermarkHeight, watermarkWidth, watermarkHeight, null);

            // Dispose of the graphics resources
            graphics.dispose();

            // Save the image with the watermark
            ImageIO.write(outputImage, "jpg", new File(outputImagePath));

            System.out.println("Watermark added successfully to the image.");
        } catch (IOException e) {
            System.out.println("Error adding watermark to the image: " + e.getMessage());
        }
    }
}
