package jp.narr.tensorflowmnist;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Region;

public class ImageBuffer {
	private int[] pixels;
	private int width;
	private int height;

	public void init(int width, int height) {
		this.width = width;
		this.height = height;

		pixels = new int[width * height];
	}

	public void init(Bitmap bitmap) {
		width = bitmap.getWidth();
		height = bitmap.getHeight();

		pixels = new int[width * height];

		bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
	}

	public int[] getPixels() {
		return pixels;
	}
	
	public int getPixel(int x, int y) {
		return pixels[width*y+x];
	}
	
	public void setPixel(int x, int y, int color) {
		pixels[width*y+x] = color;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void copyToBitmap(Bitmap bitmap) {
		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
	}
	
	public void reset() {
		int bgColor = Color.WHITE;
		int length = pixels.length;
		for (int i = 0; i < length; ++i) {
			pixels[i] = bgColor;
		}
	}
}
