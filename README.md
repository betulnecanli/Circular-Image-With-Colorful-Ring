# CircularImageWithColorfulRing
An Android library with a custom ImageView that crops the image into a circular shape with a colorful ring

[![](https://jitpack.io/v/betulnecanli/CircularImageWithColorfulRing.svg)](https://jitpack.io/#betulnecanli/CircularImageWithColorfulRing)

 ###  Preview
 ![](https://github.com/betulnecanli/CircularImageWithColorfulRing/blob/master/screenshot/img.jpg?raw=true) 
 
 ##  About
This is a custom Android library that allows you to crop images into circular shape with the added feature of an adjustable colored ring around the circumference. The ring color can also be set to display a rainbow gradient. The library provides an easy-to-use and customizable solution for circular image cropping and ring decoration.
 
- The Paint class is used to set up various options for how the image and ring will be drawn on the canvas.
- Path and RectF are used to define the circular shape of the image.
- BitmapShader is used to set the image as a shader to the paint object.
- LinearGradient is used to create a rainbow effect for the ring color.
- Canvas is used to draw the image and ring.
- Bitmap is used to store the drawable as a bitmap for drawing on the canvas.
- Drawable is used to get the drawable from the ImageView.
 
 ##  Usage
 Step 1. Add the JitPack repository to your build file
 Add it in your root build.gradle at the end of repositories:
```bash
 dependencyResolutionManagement {
    		repositories {
        		...
        		maven { url 'https://jitpack.io' }
    		}
	   }
```

Step 2. Add the dependency
```bash
 dependencies {
	        implementation 'com.github.betulnecanli:CircularImageWithColorfulRing:-SNAPSHOT'
	}
```
 
# XML Properties

|  Properties          |  Description               |
|----------------------|----------------------------|
|  ringColor    |  set the color of the ring |
|  ringWidth   | the width of the ring  |
|  rainbow   | enable or disable a rainbow effect on the ring  |
|  scaleType   |  the image is centered and scaled according to the scaleType attribute  |

## Example 
```bash
  <com.betulnecanli.circularimagewithring.CircularImageWithRingView
            android:id="@+id/circle_image_view_with_ring2"
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:layout_marginHorizontal="5dp"
            android:src="@drawable/g1"
            android:scaleType="center"
            app:rainbow="true"
            app:ringWidth="5dp" />
```
