package renen.project.waterapp.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*
import renen.project.waterapp.R

class HistoryFragment : Fragment() {

    val adapter = HistoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imgBack.setOnClickListener {
            findNavController().popBackStack()
        }

        rvHistory.layoutManager = LinearLayoutManager(requireContext())

        val list = arrayListOf<HistoryAdapterEntity>(
            HistoryAdapterEntity(R.drawable.ic_cup_water, "Вода", "250 мл", "14:30"),
            HistoryAdapterEntity(R.drawable.ic_cup_coffee, "Кофе", "300 мл", "14:30"),
            HistoryAdapterEntity(R.drawable.ic_cup_water, "Вода", "250 мл", "14:30"),
            HistoryAdapterEntity(R.drawable.ic_cup_coffee, "Кофе", "350 мл", "14:30")
        )
        adapter.setList(list)
        rvHistory.adapter = adapter
    }
}