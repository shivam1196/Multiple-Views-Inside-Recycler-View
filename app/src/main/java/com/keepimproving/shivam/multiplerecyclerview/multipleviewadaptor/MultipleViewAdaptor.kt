package com.keepimproving.shivam.multiplerecyclerview.multipleviewadaptor

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.keepimproving.shivam.multiplerecyclerview.R
import com.keepimproving.shivam.multiplerecyclerview.multipleviewadaptor.model.DataList
import kotlinx.android.synthetic.main.fragment_image_view.view.*

class MultipleViewAdaptor(var dataList:List<DataList>): RecyclerView.Adapter<RecyclerView.ViewHolder?>() {


    companion object {
    val TEXT_VIEW_TYPE=1
    val IMAGE_VIEW_TYPE=2
}


    override fun getItemCount(): Int {
        return dataList.size
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
       var viewHolder= when(p1){
            TEXT_VIEW_TYPE ->{
              var layoutView = LayoutInflater.from(p0.context).inflate(R.layout.fragment_text_view,p0,false)
                return TextViewType(layoutView)
            }

            else ->{
                var imageViewLayout=LayoutInflater.from(p0.context).inflate(R.layout.fragment_image_view,p0,false)
                return ImageViewType(imageViewLayout)
            }

        }

        return viewHolder
    }


    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        when (p0) {
            is ImageViewType ->{
                p0.imageViewId?.setBackgroundResource(dataList.get(p1).images!!)
        }
            is TextViewType ->{
                p0.fragmentTextViewId?.setText(dataList.get(p1).messageText)
            }
        }

    }


    override fun getItemViewType(position: Int): Int {
        if(dataList.get(position).images==null){
            return TEXT_VIEW_TYPE
        }
        else{
            return IMAGE_VIEW_TYPE

        }
    }


   class ImageViewType(view:View) :RecyclerView.ViewHolder(view){
       var imageViewId:ImageView?=null
                init {
                 imageViewId=   view.findViewById<ImageView>(R.id.fragmentImageViewId)
                }

    }

 class TextViewType(view: View):RecyclerView.ViewHolder(view){
     var fragmentTextViewId:TextView?=null
        init {
           fragmentTextViewId=  view.findViewById<TextView>(R.id.fragmentTextViewId)
        }
    }


}