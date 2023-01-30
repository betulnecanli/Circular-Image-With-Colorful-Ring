# CircularImageWithColorfulRing
An Android library with a custom ImageView that crops the image into a circular shape with a colorful ring
 ###  Preview
 ![](https://github.com/betulnecanli/CircularImageWithColorfulRing/blob/master/screenshot/img.jpg?raw=true) 
 
 ##  About
 The custom view has several attributes that can be set such as ringColor to set the color of the ring, ringWidth to set the width of the ring, and rainbow to enable or disable a rainbow effect on the ring. The custom view uses BitmapShader and LinearGradient to apply the image and ring color respectively. The image is centered and scaled according to the scaleType attribute.
 
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
 
