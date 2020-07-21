package renen.project.waterapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_home.*
import renen.project.database.entity.DrinkType
import renen.project.waterapp.App
import renen.project.waterapp.MainActivity
import renen.project.waterapp.R
import renen.project.waterapp.logic.NewsController
import renen.project.waterapp.util.BaseFragment

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : BaseFragment() {


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
        btnHistory.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_historyFragment)
        }
        btnSettings.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }
        btnTheme.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_userInfoFragment)
        }
        txvNews.text = NewsController.getType(listOf(), requireContext())

        drinkViewModel.allDrinkTypes.observe(viewLifecycleOwner,
            Observer { list ->
                println(list)
                setupAdapter(list)
            })
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
            (requireActivity().application as App).notificator.debugNotification(requireContext())
        }
    }

    fun setupAdapter(entityList: List<DrinkType>) {
        rvDrinkBottom.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvDrinkBottom.adapter = adapter
        val list = ArrayList<DrinkBottomEntity>()
        for (x in entityList) {
            list.add(DrinkBottomEntity(x.resId, x.waterPercentage, x.influence, x.text))
        }
        adapter.setList(list)

    }
}