package renen.project.waterapp.ui.history

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.element_drink_bottom.view.*
import kotlinx.android.synthetic.main.element_drink_bottom.view.imgPic
import kotlinx.android.synthetic.main.viewholder_history.view.*


class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(historyAdapterEntity: HistoryAdapterEntity) {
        itemView.imgPic.setImageResource(historyAdapterEntity.resId)
        itemView.txvName.text = historyAdapterEntity.name
        itemView.txvValue.text = historyAdapterEntity.value
        itemView.txvTime.text = historyAdapterEntity.time
    }
}
