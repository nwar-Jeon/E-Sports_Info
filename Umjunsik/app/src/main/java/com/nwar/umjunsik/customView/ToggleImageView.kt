package com.nwar.umjunsik.customView

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.nwar.umjunsik.R

class ToggleImageView(context : Context, val attrs : AttributeSet?, val defStyle : Int) : AppCompatImageView(context, attrs, defStyle) {
    constructor(context : Context, attrs : AttributeSet?) : this(context, attrs, 0)
    constructor(context : Context) : this(context, null, 0)

    var toggle = false
    val clickedImage by lazy { ContextCompat.getDrawable(context, typedArray.getResourceId(R.styleable.ToggleImageView_clickedImage, R.drawable.ic_favorite_black_24dp)) }
    val unClickedImage by lazy { ContextCompat.getDrawable(context, typedArray.getResourceId(R.styleable.ToggleImageView_unClickedImage, R.drawable.ic_favorite_border_black_24dp)) }
    val typedArray by lazy { context.obtainStyledAttributes(attrs, R.styleable.ToggleImageView) }

    init { setImage() }

    /*override fun performClick(): Boolean {
        toggle()
        setImage()
        return super.performClick()
    }*/

    fun setImage() {
        if(toggle) {
            this.setImageDrawable(clickedImage)
        } else {
            this.setImageDrawable(unClickedImage)
        }
    }

    fun toggle() {
        toggle = !toggle
    }
}