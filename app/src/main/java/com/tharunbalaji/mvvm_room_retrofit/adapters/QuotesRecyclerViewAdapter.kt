package com.tharunbalaji.mvvm_room_retrofit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tharunbalaji.mvvm_room_retrofit.R
import com.tharunbalaji.mvvm_room_retrofit.models.Result

class QuotesRecyclerViewAdapter(private val quotes: List<Result>): RecyclerView.Adapter<QuotesRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val quoteDesc: TextView = itemView.findViewById(R.id.tv_quote_desc)
        private val quoteAuthor: TextView = itemView.findViewById(R.id.tv_quote_author)

        fun bind(quote: Result) {
            quoteDesc.text = quote.content
            quoteAuthor.text = quote.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quote_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quotes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = quotes[position]
        holder.bind(data)
    }

}