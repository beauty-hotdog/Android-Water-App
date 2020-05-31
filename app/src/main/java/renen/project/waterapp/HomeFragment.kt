package renen.project.waterapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

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

    }

    fun setupGraph(){
        val color = IntArray(1)
        color[0] = ContextCompat.getColor(requireContext(), R.color.green)
        slimChart.colors = color
        val stats = FloatArray(1)
        stats[0] = 75f
        slimChart.stats = stats
        slimChart.setOnClickListener {
            slimChart.playStartAnimation()
        }
    }
}