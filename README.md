#  <h1 align="center">🎨 Circular Image With Colorful Ring Library [![](https://jitpack.io/v/betulnecanli/CircularImageWithColorfulRing.svg)](https://jitpack.io/#betulnecanli/CircularImageWithColorfulRing)
  </h1>  
<p align="center">  An Android library with a custom ImageView that crops the image into a circular shape with a colorful ring.</p>


 #  <h1 align="center">🖼 Preview </h1>
 
 <p align="center">
 <img src="https://github.com/betulnecanli/CircularImageWithColorfulRing/blob/master/screenshot/img.jpg?raw=true"/>
 
 </p>

 
 
  #  <h1 align="center">🪧 About </h1>
This is a custom Android library that allows you to crop images into circular shape with the added feature of an adjustable colored ring around the circumference. The ring color can also be set to display a rainbow gradient. The library provides an easy-to-use and customizable solution for circular image cropping and ring decoration.
 
- The Paint class is used to set up various options for how the image and ring will be drawn on the canvas.
- Path and RectF are used to define the circular shape of the image.
- BitmapShader is used to set the image as a shader to the paint object.
- LinearGradient is used to create a rainbow effect for the ring color.
- Canvas is used to draw the image and ring.
- Bitmap is used to store the drawable as a bitmap for drawing on the canvas.
- Drawable is used to get the drawable from the ImageView.
 
 
   #  <h1 align="center">📌 Usage </h1>
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
	        implementation 'com.github.betulnecanli:CircularImageWithColorfulRing:v1.0.0'
	}
```
 

   #  <h1 align="center">📖 XML Properties </h1>

|  Properties          |  Description               |
|----------------------|----------------------------|
|  ringColor    |  set the color of the ring |
|  ringWidth   | the width of the ring  |
|  rainbow   | enable or disable a rainbow effect on the ring  |
|  scaleType   |  the image is centered and scaled according to the scaleType attribute  |

 
 #  <h1 align="center">📎 Example </h1>
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


# License
```xml
Designed and developed by 2023 Betül Necanlı 

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
