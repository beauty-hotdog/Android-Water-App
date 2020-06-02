package renen.project.waterapp.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import renen.project.waterapp.R
import renen.project.waterapp.ui.home.DrinkBottomEntity
import renen.project.waterapp.ui.home.HomeViewHolder

class HistoryAdapter() : RecyclerView.Adapter<HistoryViewHolder>() {

    val list = ArrayList<HistoryAdapterEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_history, parent, false)
        return HistoryViewHolder(v)
    }

    override fun getItemCount(): Int = list.size



    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {

        holder.bind(list[position])
    }

    fun setList(newList: List<HistoryAdapterEntity>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}


