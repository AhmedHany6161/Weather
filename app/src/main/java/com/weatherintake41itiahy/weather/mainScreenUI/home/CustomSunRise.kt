package com.weatherintake41itiahy.weather.mainScreenUI.home

import android.R
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import java.security.AccessController.getContext


class CustomSunRise : View {
    var mPathPaint: Paint? = null
    private var mWidth = 0
    private var mHeight = 0
    var mainColor = 0
    var trackColor = 0
    private var mPathPath: Path? = null
    private var mMotionPaint: Paint? = null
    private var mMotionPath: Path? = null
    var controlX = 0
    var controlY = 0
    var startX = 0f
    var startY = 0f
    var endX = 0f
    var endY = 0f
    private var rX = 0.0
    private var rY = 0.0
    private val mSunrise = IntArray(2)
    private val mSunset = IntArray(2)
    private var mSunPaint: Paint? = null
    private var valueAnimator: ValueAnimator? = null
    private var mProgress = 0f
    private var mShadePaint: Paint? = null
    private var mPathShader: Shader? = null
    private var mCurrentProgress = 0f
    private var isDraw = false
    private var mDashPathEffect: DashPathEffect? = null
    private var mTextPaint: Paint? = null
    private val mBackgroundShader: LinearGradient? = null
    private var sunColor = 0
    private var mSunStrokePaint: Paint? = null
    private var svSunSize = 0f
    private var svTextSize = 0f
    private var textOffset = 0f
    private var svPadding = 0f
    private var svTrackWidth = 0f

    constructor(context: Context?) : super(context) {
        init(null)
    }

    constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(attrs)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        @Nullable attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {

        //Initialize properties
        val context: Context = getContext()
        // In this place, if the xml attribute does not give a value, you cannot get the default value
        mainColor = 0x67B2FD
        trackColor = 0x67B2FD
        sunColor = 0x00D3FE
        svSunSize = 10f
        svTextSize = 18f
        textOffset = 10f
        svPadding = 10f
        svTrackWidth = 3f

        val pathPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        pathPaint.setColor(mainColor)
        pathPaint.setStyle(Paint.Style.FILL)
        mPathPaint = pathPaint
        // gradient path
        mPathPath = Path()
        // Brush with gradient mask
        val shadePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        shadePaint.setColor(Color.parseColor("#B3FFFFFF"))
        shadePaint.setStyle(Paint.Style.FILL)
        mShadePaint = shadePaint
        // Motion track brush
        val motionPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        motionPaint.setColor(trackColor)
        motionPaint.setStrokeCap(Paint.Cap.ROUND)
        motionPaint.setStrokeWidth(svTrackWidth)
        motionPaint.setStyle(Paint.Style.STROKE)
        mMotionPaint = motionPaint
        // Motion track
        mMotionPath = Path()
        // sun brush
        val sunPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        sunPaint.setColor(sunColor)
        sunPaint.setStyle(Paint.Style.FILL)
        mSunPaint = sunPaint
        // sun border brush
        val sunStrokePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        sunStrokePaint.setColor(Color.WHITE)
        sunStrokePaint.setStyle(Paint.Style.FILL)
        mSunStrokePaint = sunStrokePaint
        // Sunrise and sunset time brush
        val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint.setColor(trackColor)
        textPaint.setStyle(Paint.Style.FILL)
        textPaint.setTextSize(svTextSize)
        mTextPaint = textPaint
        mDashPathEffect = DashPathEffect(floatArrayOf(6f, 12f), 0f)
    }

    protected override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        if (!isDraw) {
            mWidth = getWidth()
            mHeight = getHeight()
            controlX = mWidth / 2
            controlY = 0 - mHeight / 2
            startX = svPadding
            startY = mHeight - svPadding
            endX = mWidth - svPadding
            endY = mHeight - svPadding
            rX = svPadding.toDouble()
            rY = (mHeight - svPadding).toDouble()
            // gradient path
            mPathShader = LinearGradient(
                (mWidth / 2).toFloat(), svPadding.toFloat(), (mWidth / 2).toFloat(), endY.toFloat(),
                mainColor, Color.WHITE, Shader.TileMode.CLAMP
            )
            mPathPaint!!.setShader(mPathShader)
            mPathPath!!.moveTo(startX, startY)
            mPathPath!!.quadTo(controlX.toFloat(), controlY.toFloat(), endX, endY)
            // Motion track
            mMotionPath?.moveTo(startX, startY)
            mMotionPath?.quadTo(controlX.toFloat(), controlY.toFloat(), endX, endY)
            isDraw = true
        }

        // Draw according to the occlusion relationship
        // draw gradient
        canvas.drawPath(mPathPath!!, mPathPaint!!)
        // Draw a track that has moved in the past
        mMotionPaint?.setStyle(Paint.Style.STROKE)
        mMotionPaint?.setPathEffect(null)
        canvas.drawPath(mMotionPath!!, mMotionPaint!!)
        // Draw a rectangle to cover the gradient and track that have not been moved
        mShadePaint?.setShader(mBackgroundShader)
        canvas.drawRect(rX.toFloat(), 0f, mWidth.toFloat(), mHeight.toFloat(), mShadePaint!!)
        // Draw a dotted line to indicate the unmoved track
        mMotionPaint?.setPathEffect(mDashPathEffect)
        canvas.drawPath(mMotionPath!!, mMotionPaint!!)

        // Draw sunrise and sunset text
        if (mSunrise.size != 0 || mSunset.size != 0) {
            mTextPaint?.setTextAlign(Paint.Align.LEFT)
            canvas.drawText(
                "Sunrise" + (if (mSunrise[0] < 10) "0" + mSunrise[0] else mSunrise[0])
                        + ":" + if (mSunrise[1] < 10) "0" + mSunrise[1] else mSunrise[1],
                startX + textOffset,
                startY,
                mTextPaint!!
            )
            mTextPaint?.setTextAlign(Paint.Align.RIGHT)
            canvas.drawText(
                ("Sunset" + (if (mSunset[0] < 10) "0" + mSunset[0] else mSunset[0])
                        + ":" + (if (mSunset[1] < 10) "0" + mSunset[1] else mSunset[1])),
                endX - textOffset,
                endY,
                mTextPaint!!
            )
        }

        // draw endpoint
        mMotionPaint?.setStyle(Paint.Style.FILL)
        canvas.drawCircle(startX, startY, svTrackWidth * 2, mMotionPaint!!)
        canvas.drawCircle(endX, endY, svTrackWidth * 2, mMotionPaint!!)
        // draw the sun
        canvas.drawCircle(rX.toFloat(), rY.toFloat(), svSunSize * 6 / 5, mSunStrokePaint!!)
        canvas.drawCircle(rX.toFloat(), rY.toFloat(), svSunSize, mSunPaint!!)
        canvas.restore()
    }

    /**
     * Set the current progress and update the position of the sun center
     * @param t range: [0~1]
     */
    private fun setProgress(t: Float) {
        mProgress = t
        rX = (startX * Math.pow(
            (1 - t).toDouble(),
            2.0
        )) + (2 * controlX * t * (1 - t)) + (endX * Math.pow(t.toDouble(), 2.0))
        rY = (startY * Math.pow(
            (1 - t).toDouble(),
            2.0
        )) + (2 * controlY * t * (1 - t)) + (endY * Math.pow(t.toDouble(), 2.0))
        // Only update the area to be painted
        invalidate(rX.toInt(), 0, (mWidth - svPadding).toInt(), (mHeight - svPadding).toInt())
    }

    /**
     * Set the current time (please set the sunrise and sunset time first)
     */
    fun setCurrentTime(hour: Int, minute: Int) {
        if (mSunrise.size != 0 || mSunset.size != 0) {
            val p0 = (mSunrise[0] * 60 + mSunrise[1]).toFloat() //Starting minutes
            val p1 = hour * 60 + minute - p0 //Total minutes in current time
            val p2 =
                mSunset[0] * 60 + mSunset[1] - p0 //Total number of minutes from sunset to sunrise
            val progress = p1 / p2
            mProgress = progress
            motionAnimation()
        }
    }

    /**
     * Set sunrise time
     */
    fun setSunrise(hour: Int, minute: Int) {
        mSunrise[0] = hour
        mSunrise[1] = minute
    }


    fun setSunset(hour: Int, minute: Int) {
        mSunset[0] = hour
        mSunset[1] = minute
    }

    /**
     * Sun track animation
     */
    fun motionAnimation() {
        if (valueAnimator == null) {
            mCurrentProgress = 0f
            // Make sure the sun will not go out of bounds
            if (mProgress < 0) {
                mProgress = 0f
            }
            if (mProgress > 1) {
                mProgress = 1f
            }
            val animator = ValueAnimator.ofFloat(mCurrentProgress, mProgress)
            animator.duration = (2500 * (mProgress - mCurrentProgress)).toLong()
            animator.addUpdateListener {
                val `val` = animator.animatedValue
                if (`val` is Float) {
                    setProgress(`val`)
                }
            }
            valueAnimator = animator
        } else {
            valueAnimator!!.cancel()
            valueAnimator!!.setFloatValues(mCurrentProgress, mProgress)
        }
        valueAnimator!!.start()
        // Save the current progress, the next call to setCurrentTime() can move from the last progress to the current progress (Xiaomi effect)
        mCurrentProgress = mProgress
    }
}