/*
Programme is written by Mikhail Molotkov, first year Software Engineer
Date of birth: 14/11/2014
Last update: 15/11/2014
*/

/*
"SIZE" represents the length of the pixels array.
"MIN_WINDOW_SIZE_X" represents 200 pixels on x-axis( width of the window )
"MIN_WINDOW_SIZE_Y" represents 200 pixels on y-axis( heigth of the window )
"MAX_WINDOW_SIZE_X" represents 600 pixels on x-axis( width of the window )
"MAX_WINDOW_SIZE_Y" represents 600 pixels on y-axis( heigth of the window )
"pixels" represents an array with digits.
*/
import sheffield.*;
public class Picture {
	public static void main(String[] args) {
		
/* ~~~~~~~~~~~~~~~~~~~~ Declaration of constants and array ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */	
		final int SIZE = 40000;
		final short MIN_WINDOW_SIZE_X = 200;
		final short MAX_WINDOW_SIZE_X = 600;
		final short MIN_WINDOW_SIZE_Y = 200;
		final short MAX_WINDOW_SIZE_Y = 600;
		char[] pixels = new char[SIZE];
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/*~~~~~~~~~~~~~~~~~~~~~ Initialization of EasyReader and reading from the file ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
		EasyReader fileInput = new EasyReader("picture.txt");
		
		for(int i=0 ; i<SIZE ; ++i) {			// Storing data into array
			pixels[i] = fileInput.readChar();
		}
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/* ~~~~~~~~~~~~~~~~~~~~ Initialization of EasyGraphics and drawing the 600*600 picture ~~~~~~~~~~~~~~~~~~~~~ */		
		EasyGraphics drawPixelLarge = new EasyGraphics(MAX_WINDOW_SIZE_X, MAX_WINDOW_SIZE_Y);
		
		int i = 0;
		for(short y=MAX_WINDOW_SIZE_Y-1; y>-1; y -= 3) { 	// Y-axis. From top to bottom
			for(short x=0; x<MAX_WINDOW_SIZE_X; x += 3) { 	// X-axis. From left to right
				for (byte difY=0; difY < 3; ++difY) { 	// Enlarge each pixel by 3*3 matrix
					for(byte difX=0; difX < 3; ++difX) {
						if (pixels[i] <= 51) {
							drawPixelLarge.setColor(101, 153, 255); //Blue color
							drawPixelLarge.plot(x+difX,y-difY);
						}
						else if (pixels[i] <= 53) {
							drawPixelLarge.setColor(146, 205, 0);   //Light green
							drawPixelLarge.plot(x+difX,y-difY);
						}
						else if (pixels[i] <= 55) {
							drawPixelLarge.setColor(44, 103, 0);    //Dark green
							drawPixelLarge.plot(x+difX,y-difY);
						}
						else if (pixels[i] > 55) {
							drawPixelLarge.setColor(102, 51, 0);    //Brown color
							drawPixelLarge.plot(x+difX,y-difY);
						}
					}
				}
				++i;
			}
		}	
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/* ~~~~~~~~~~~~~~~~~~~~ Initialization of EasyGraphics and drawing the 200*200 sketch ~~~~~~~~~~~~~~~~~~~~~~ */
		EasyGraphics drawPixelSketch = new EasyGraphics(MIN_WINDOW_SIZE_X, MIN_WINDOW_SIZE_Y);
		
		i = 200;
		for(int y=MIN_WINDOW_SIZE_Y-2; y>0; --y) {
			for(int x=0; x<MIN_WINDOW_SIZE_X; ++x) {
				if (pixels[i] <= 51) {
					if ( (pixels[i+1] | pixels[i-1] | pixels[i+MIN_WINDOW_SIZE_Y] 
						| pixels[i-MIN_WINDOW_SIZE_Y] )  <= 51) { // Check if the pixels to the right, left, bottom and above are the same color with current pixel
						drawPixelSketch.setColor(255, 255, 255); 
						drawPixelSketch.plot(x,y);
					}
					else {
						drawPixelSketch.setColor(0, 0, 0);
						drawPixelSketch.plot(x,y);
					}
				}
				else if (pixels[i] <= 53) {
					if ((pixels[i+1] | pixels[i-1] | pixels[i+MIN_WINDOW_SIZE_Y]
						| pixels[i-MIN_WINDOW_SIZE_Y] ) <= 53) { // Check if the pixels to the right, left, bottom and above are the same color with current pixel
						drawPixelSketch.setColor(255, 255, 255); 
						drawPixelSketch.plot(x,y);
					}
					else {
						drawPixelSketch.setColor(0, 0, 0);
						drawPixelSketch.plot(x,y);
					}
				}
				else if (pixels[i] <= 55) {
					if ((pixels[i+1] | pixels[i-1] | pixels[i+MIN_WINDOW_SIZE_Y]
						| pixels[i-MIN_WINDOW_SIZE_Y] ) <= 55) { // Check if the pixels to the right, left, bottom and above are the same color with current pixel
						drawPixelSketch.setColor(255, 255, 255); 
						drawPixelSketch.plot(x,y);
					}
					else {
						drawPixelSketch.setColor(0, 0, 0);
						drawPixelSketch.plot(x,y);
					}
				}
				else if (pixels[i] > 55) {
					if ((pixels[i+1] | pixels[i-1] | pixels[i+MIN_WINDOW_SIZE_Y]
						| pixels[i-MIN_WINDOW_SIZE_Y] ) > 55) { // Check if the pixels to the right, left, bottom and above are the same color with current pixel
						drawPixelSketch.setColor(255, 255, 255); 
						drawPixelSketch.plot(x,y);
					}
					else {
						drawPixelSketch.setColor(0, 0, 0);
						drawPixelSketch.plot(x,y);
					}
				}
				++i;
			}
		}
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */	
	}
}