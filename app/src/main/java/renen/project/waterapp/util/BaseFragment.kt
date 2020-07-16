package renen.project.waterapp.util

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import renen.project.waterapp.MainActivity
import renen.project.waterapp.viewmodel.DrinkViewModel
import renen.project.waterapp.viewmodel.TranslationViewModel

open class BaseFragment : Fragment() {
    lateinit var translationViewModel: TranslationViewModel
    lateinit var drinkViewModel: DrinkViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        translationViewModel = (activity as MainActivity).translationViewModel
        drinkViewModel = (activity as MainActivity).drinkViewModel
    }
}