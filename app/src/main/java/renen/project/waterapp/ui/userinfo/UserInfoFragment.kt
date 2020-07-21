package renen.project.waterapp.ui.userinfo

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.element_user_info_activity.*
import kotlinx.android.synthetic.main.element_user_info_activity.view.*
import kotlinx.android.synthetic.main.fragment_settings.imgBack
import kotlinx.android.synthetic.main.fragment_user_info.*
import renen.project.waterapp.R
import renen.project.waterapp.util.BaseFragment
import renen.project.waterapp.viewmodel.Language
import su.leff.translator.Translator.key

class UserInfoFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imgBack.setOnClickListener {
            findNavController().navigateUp()

        }


        cvLowActivity.setOnClickListener {
            cvLowActivity.rbLow.isChecked = true
            cvMediumActivity.rbLow.isChecked = false
            cvHighActivity.rbLow.isChecked = false
        }

        cvMediumActivity.setOnClickListener {
            cvLowActivity.rbLow.isChecked = false
            cvMediumActivity.rbLow.isChecked = true
            cvHighActivity.rbLow.isChecked = false
        }

        cvHighActivity.setOnClickListener {
            cvLowActivity.rbLow.isChecked = false
            cvMediumActivity.rbLow.isChecked = false
            cvHighActivity.rbLow.isChecked = true
        }


        txvTitleUserInfo.key = "user_activity"
        cvLowActivity.txvLow.key = "low"
        cvLowActivity.txvLowLife.key = "low_life"

        cvMediumActivity.txvLow.key = "medium"
        cvMediumActivity.txvLowLife.key = "medium_life"

        cvHighActivity.txvLow.key = "high"
        cvHighActivity.txvLowLife.key = "high_life"



        txvTitleUserInfo.setOnClickListener {
            translationViewModel.postLanguage(Language.RUSSIAN, requireActivity())
        }

    }
}