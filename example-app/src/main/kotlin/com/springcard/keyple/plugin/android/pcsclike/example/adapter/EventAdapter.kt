/*
 * Copyright (c)2022 SpringCard - www.springcard.com.com
 * All right reserved
 * This software is covered by the SpringCard SDK License Agreement - see LICENSE.txt
 */
package com.springcard.keyple.plugin.android.pcsclike.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.springcard.keyple.plugin.android.pcsclike.example.databinding.CardActionEventBinding
import com.springcard.keyple.plugin.android.pcsclike.example.databinding.CardHeaderEventBinding
import com.springcard.keyple.plugin.android.pcsclike.example.databinding.CardResultEventBinding
import com.springcard.keyple.plugin.android.pcsclike.example.model.EventModel

class EventAdapter(private val events: ArrayList<EventModel>) :
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    return when (viewType) {
        EventModel.TYPE_ACTION ->
            ActionViewHolder(
                CardActionEventBinding.inflate(inflater, parent, false)
            )

        EventModel.TYPE_RESULT ->
            ResultViewHolder(
                CardResultEventBinding.inflate(inflater, parent, false)
            )

        else ->
            HeaderViewHolder(
                CardHeaderEventBinding.inflate(inflater, parent, false)
            )
    }
  }

  override fun getItemCount(): Int {
    return events.size
  }

  override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
    viewHolder.bind(events[position])
  }

  override fun getItemViewType(position: Int): Int {
    return events[position].type
  }

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        open fun bind(event: EventModel) {
        }
    }
    class ActionViewHolder(
        private val binding: CardActionEventBinding
    ) : ViewHolder(binding.root) {

        override fun bind(event: EventModel) {
            binding.cardActionTextView.text = event.text
        }
    }

    class HeaderViewHolder(
        private val binding: CardHeaderEventBinding
    ) : ViewHolder(binding.root) {

        override fun bind(event: EventModel) {
            binding.cardActionTextView.text = event.text
        }
    }

    class ResultViewHolder(
        private val binding: CardResultEventBinding
    ) : ViewHolder(binding.root) {

        override fun bind(event: EventModel) {
            binding.cardActionTextView.text = event.text
        }
    }
}

