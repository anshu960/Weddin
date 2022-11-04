package com.example.weddin.Adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weddin.Model.User
import com.example.weddin.R
import kotlinx.android.synthetic.main.wedding_item.view.*


open class HappyPlacesAdapter (
    private val context: Context,
    private var list: ArrayList<User>
        ): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var onClickListener: OnclickListener ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.wedding_item,
                parent,
                false
            )
        )
    }

    fun setOnClickListener(onclickListener: OnclickListener){
        this.onClickListener = onclickListener
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]

        if (holder is MyViewHolder){
            holder.itemView.iv_place_image.setImageURI(Uri.parse(model.image))
            holder.itemView.tvDescription.text = model.description
            holder.itemView.Title.text = model.title
            holder.itemView.tvAddress.text = model.location
            holder.itemView.tvDate.text = model.date

            holder.itemView.setOnClickListener {
                if (onClickListener != null){
                    onClickListener!!.onClick(position, model)
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnclickListener{
        fun onClick(position: Int, model: User)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}