package renen.project.waterapp.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.element_drink_bottom.view.*
import renen.project.waterapp.constant.dpToPx16

class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { //конструктор
    fun bind(drinkBottomEntity: DrinkBottomEntity, last: Boolean) {
        itemView.imgPic.setImageResource(drinkBottomEntity.resId)
        val lp = itemView.clBackground.layoutParams as RecyclerView.LayoutParams
        var rightMargin = 0
        if (last) {
            rightMargin = dpToPx16
        }
        lp.setMargins(dpToPx16, 0, rightMargin, 0)
        itemView.clBackground.layoutParams = lp
    }
}