package com.devdcruz.pokeapp.ui.common

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.devdcruz.pokeapp.R

class AspectRatioKImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {

    var ratio: Float = 1f

    init {
        val attrs = context.obtainStyledAttributes(attrs, R.styleable.AspectRatioKImageView)
        ratio = attrs.getFloat(R.styleable.AspectRatioKImageView_ratio, 1f)
        attrs.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        var width = measuredWidth
        var height = measuredHeight

        if (width == 0 && height == 0) {
            return
        }

        if (width > 0){
            height = (width * ratio).toInt()
        } else if (height > 0) {
            width = (height * ratio).toInt()
        }

        setMeasuredDimension(width,height)
    }
}