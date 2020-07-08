package renen.project.waterapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_home.*
import renen.project.waterapp.R
import renen.project.waterapp.logic.NewsController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    val adapter = HomeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupGraph()
        setupAdapter()
        btnHistory.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_historyFragment)
        }
        btnSettings.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }

        txvNews.text = NewsController.getType(listOf(), requireContext())
    }

    var waterPercentage = 0f

    fun setupGraph() {
        val color = IntArray(1)
        color[0] = ContextCompat.getColor(
            requireContext(),
            R.color.green
        )
        slimChart.colors = color

        fun setupStats() {
            val stats = FloatArray(1)
            stats[0] = waterPercentage
            slimChart.stats = stats
        }
        setupStats()

        slimChart.setOnClickListener {
            waterPercentage += 10f
            setupStats()
            slimChart.playStartAnimation()
        }
    }

    fun setupAdapter() {
        rvDrinkBottom.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvDrinkBottom.adapter = adapter
        val list = ArrayList<DrinkBottomEntity>()
        list.add(DrinkBottomEntity(R.drawable.ic_cup_water))
        list.add(DrinkBottomEntity(R.drawable.ic_cup_coffee))
        list.add(DrinkBottomEntity(R.drawable.ic_cup_water))
        list.add(DrinkBottomEntity(R.drawable.ic_cup_coffee))
        list.add(DrinkBottomEntity(R.drawable.ic_cup_water))
        list.add(DrinkBottomEntity(R.drawable.ic_cup_coffee))
        list.add(DrinkBottomEntity(R.drawable.ic_cup_water))
        list.add(DrinkBottomEntity(R.drawable.ic_cup_coffee))
        list.add(DrinkBottomEntity(R.drawable.ic_cup_water))
        list.add(DrinkBottomEntity(R.drawable.ic_cup_coffee))
        list.add(DrinkBottomEntity(R.drawable.ic_cup_water))
        list.add(DrinkBottomEntity(R.drawable.ic_cup_coffee))
        list.add(DrinkBottomEntity(R.drawable.ic_cup_water))
        list.add(DrinkBottomEntity(R.drawable.ic_cup_coffee))
        adapter.setList(list)

    }
}