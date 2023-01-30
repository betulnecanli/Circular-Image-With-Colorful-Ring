package com.betulnecanli.circularimagewithring

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet

import android.widget.ImageView



@SuppressLint("AppCompatCustomView")
class CircularImageWithRingView  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {



    // Paint object for the circular image
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    // Default values for the ring color, width and rainbow effect
    private var ringColor = Color.BLACK
    private var ringWidth = 5f
    private var rainbow = false

    // Initialization block to retrieve custom attributes if provided
    init {
        // Set scale type to center crop
        scaleType = ScaleType.CENTER_CROP
        // Retrieve custom attributes if provided
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircularImageWithRingView, 0, 0)
        try {
            ringColor = typedArray.getColor(R.styleable.CircularImageWithRingView_ringColor, ringColor)
            ringWidth = typedArray.getDimension(R.styleable.CircularImageWithRingView_ringWidth, ringWidth)
            rainbow = typedArray.getBoolean(R.styleable.CircularImageWithRingView_rainbow, rainbow)
            scaleType = ScaleType.values()[typedArray.getInt(R.styleable.CircularImageWithRingView_android_scaleType, 0)]
        } finally {
            typedArray.recycle()
        }
    }

    // Paint object for the ring
    private val ringPaint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.STROKE
        strokeWidth = ringWidth
        color=ringColor
        isFilterBitmap = true
        isDither = true
    }

    // Path object for clipping the image to a circular shape
    private val path = Path()
    private val rectF = RectF()

    override fun onDraw(canvas: Canvas?) {
        // Get the drawable object
        val drawable = drawable
        // Convert drawable to bitmap
        val bitmap = getBitmapFromDrawable(drawable)
        // If a bitmap is obtained
        bitmap?.let {
            // Create a BitmapShader object
            val shader = BitmapShader(it, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
            paint.shader = shader
            // Calculate the radius of the circular image
            val radius = (width.coerceAtMost(height) / 2 - ringPaint.strokeWidth / 2).toFloat()
            // set the bounds of the rectangle to be drawn
            rectF.set(0f, 0f, width.toFloat(), height.toFloat())
            // add a circular path to the canvas
            path.addCircle(
                rectF.centerX(),
                rectF.centerY(),
                Math.min(rectF.width() / 2, rectF.height() / 2),
                Path.Direction.CCW
            )
            canvas?.clipPath(path)
            // draw the Bitmap on the canvas within the bounds of the rectangle
            canvas?.drawBitmap(bitmap, null, rectF, paint)


            // if the rainbow flag is set, create a LinearGradient for the ring
            if(rainbow){
                ringPaint.shader = LinearGradient(
                    0f,
                    0f,
                    width.toFloat(),
                    height.toFloat(),
                    intArrayOf(
                        Color.RED,
                        Color.YELLOW,
                        Color.GREEN,
                        Color.CYAN,
                        Color.BLUE,
                        Color.MAGENTA,
                        Color.RED
                    ),
                    null,
                    Shader.TileMode.MIRROR)
            }

            //// draw the ring on the canvas
            canvas?.drawCircle(width / 2f, height / 2f, radius + ringPaint.strokeWidth / 2, ringPaint)
        }
    }


    // The function takes a Drawable object as input
    private fun getBitmapFromDrawable(drawable: Drawable): Bitmap? {
        // If the drawable object is already a BitmapDrawable object,
        // it returns the underlying bitmap object.
        if (drawable is BitmapDrawable) {
            return drawable.bitmap
        }

        // If the drawable object is not a BitmapDrawable, a new Bitmap object is created with the dimensions
        // of the Drawable object. The bitmap is configured to have 8888 ARGB color format.
        val bitmap = Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        // A Canvas object is created on the newly created Bitmap.
        val canvas = Canvas(bitmap)
        // The bounds of the Drawable object are set to match its intrinsic dimensions.
        drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
        // The Drawable object is drawn onto the canvas.
        drawable.draw(canvas)
        // The resulting Bitmap object is returned.
        return bitmap
    }
}