package com.example.eventplannerapp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class  EventAdapter(private val context: home, private val chatlist: List<Event>) :
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.event_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(chatlist[position])
    }

    override fun getItemCount(): Int {
        return chatlist.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var id = itemView.findViewById<TextView>(androidx.core.R.id.edit_text_id)
        var title = itemView.findViewById<TextView>(R.id.titleTextView)
        var desciption = itemView.findViewById<TextView>(R.id.descriptionTextView)
        var date = itemView.findViewById<TextView>(R.id.dateTextView)
        var time = itemView.findViewById<TextView>(R.id.timeTextView)
        var imageView = itemView.findViewById<ImageView>(R.id.imageview)

        fun bind(modelChat: Event) {
            title.text = modelChat.title
            desciption.text = modelChat.description
            date.text = modelChat.date
            time.text = modelChat.time


            Glide.with(context)
                .load(modelChat.imageView)

                .placeholder(R.drawable.wedding1)
                .centerCrop()

                .into(imageView)

        }
    }




    companion object {
        fun notifyItemInserted(i: Int) {

        }

        const val VIEW_TYPE_NORMAL = 1
        const val VIEW_TYPE_SPECIAL = 2
    }
    }

