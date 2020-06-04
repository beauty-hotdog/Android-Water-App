package renen.project.waterapp.ui.history

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_history.view.*
import renen.project.waterapp.constant.dpToPx16


class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(historyAdapterEntity: HistoryAdapterEntity, last: Boolean) {
        itemView.imgPic.setImageResource(historyAdapterEntity.resId)
        itemView.txvName.text = historyAdapterEntity.name
        itemView.txvValue.text = historyAdapterEntity.value
        itemView.txvTime.text = historyAdapterEntity.time

//        val lp = itemView.imgPic.layoutParams as ConstraintLayout.LayoutParams
//        var bottomMargin = 0
//        if (last) {
//            bottomMargin = dpToPx16
//        }
//        lp.setMargins(dpToPx16, dpToPx16, 0, bottomMargin)
//        itemView.imgPic.layoutParams = lp
    }
}
