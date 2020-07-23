package com.nwar.umjunsik.bindingAdapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nwar.umjunsik.customView.CheckingButton
import com.nwar.umjunsik.customView.ToggleImageView
import com.nwar.umjunsik.ui.base.BaseAdapter
import kr.co.prnd.YouTubePlayerView

@BindingAdapter(value = ["checked"], requireAll = true)
fun checkingButtonBackground(view: CheckingButton, check: Boolean?) {
    val color = if (check == null) {
        "#3E3D40"
    } else if (check) {
        "#00FF9D"
    } else {
        "#FF4343"
    }
    view.setBackgroundColor(color)
    view.checkingImgVisible(check)
}

@BindingAdapter(value = ["bindItem"])
fun bindingItem(recyclerView: RecyclerView, list : List<Any>?) {
    if(list!=null)(recyclerView.adapter as BaseAdapter).changeItemList(list)
}

@BindingAdapter(value = ["imageUrl"])
fun imageUrl(imageView : AppCompatImageView, url : String) {
    Glide.with(imageView.context).load(url).into(imageView)
}

@BindingAdapter(value =["toggle"])
fun toggle(view : ToggleImageView, checked : Boolean) {
    view.toggle = checked
    view.setImage()
}

@BindingAdapter(value = ["videoId"])
fun videoId(player : YouTubePlayerView, uri : String?) {
    if(uri!=null) player.play(uri)
}