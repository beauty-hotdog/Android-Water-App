package renen.project.waterapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import renen.project.waterapp.R

class HomeAdapter() : RecyclerView.Adapter<HomeViewHolder>() {

    val list = ArrayList<DrinkBottomEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.element_drink_bottom, parent, false)
        return HomeViewHolder(v)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(list[position],position == list.size - 1)
    }

    fun setList(newList: List<DrinkBottomEntity>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}