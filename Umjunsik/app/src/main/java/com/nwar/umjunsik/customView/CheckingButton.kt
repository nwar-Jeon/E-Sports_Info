package com.nwar.umjunsik.customView

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.nwar.umjunsik.R
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.layoutInflater

class CheckingButton(val mContext : Context, val attrs : AttributeSet?, val defStyle : Int) : ConstraintLayout(mContext, attrs, defStyle) {
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    val background by lazy {  findViewById<ConstraintLayout>(R.id.view_background_checking_btn) }
    val textView by lazy { findViewById<AppCompatTextView>(R.id.view_text_checking_btn) }
    val checkImg by lazy { findViewById<AppCompatImageView>(R.id.view_img_checking_btn) }
    var defaultText : String
    var failText : String

    init {
        addView(mContext.layoutInflater.inflate(R.layout.view_checking_button, this, false))
        val typedArr = mContext.obtainStyledAttributes(attrs, R.styleable.CheckingButton)
        defaultText = typedArr.getString(R.styleable.CheckingButton_defaultText) ?: "오류"
        failText = typedArr.getString(R.styleable.CheckingButton_failText) ?: "오류"

    }

    fun setBackgroundColor(color : String) {
       background.backgroundColor = Color.parseColor(color)
    }

    fun setText(text : String) {
        textView.text = text
    }

    fun checkingImgVisible(check : Boolean?) {
        if(check==null || !check) {
            checkImg.visibility = INVISIBLE
            textView.visibility = View.VISIBLE
        } else {
            checkImg.visibility = VISIBLE
            textView.visibility = INVISIBLE
        }
        if(check==null) setText(defaultText)
        if(check==false) setText(failText)
    }
}