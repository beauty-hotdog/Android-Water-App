package renen.project.waterapp.util

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import renen.project.waterapp.MainActivity
import renen.project.waterapp.viewmodel.TranslationViewModel

open class BaseFragment : Fragment() {
    lateinit var translationViewModel: TranslationViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        translationViewModel = (activity as MainActivity).translationViewModel
    }
}