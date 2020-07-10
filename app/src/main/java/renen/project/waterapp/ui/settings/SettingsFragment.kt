package renen.project.waterapp.ui.settings

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_settings.*
import renen.project.waterapp.R
import renen.project.waterapp.util.BaseFragment
import renen.project.waterapp.viewmodel.Language
import su.leff.translator.Translator.key


class SettingsFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imgBack.setOnClickListener {
            findNavController().navigateUp()

        }

        clTheme.setOnClickListener {
            rbTheme.isChecked = !rbTheme.isChecked
        }
        clAbout.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_aboutFragment)
        }

        clGooglePlay.setOnClickListener {
            val appPackageName: String =
                requireContext().getPackageName() // getPackageName() from Context or Activity object

            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=$appPackageName")
                    )
                )
            } catch (anfe: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                    )
                )
            }
        }
        txvTitle.key = "settings"
        txvSettingsTitle.key = "main_settings"
        txvDarkTheme.key = "dark_tem"
        txvSettingsHelp.key = "help"
        txvAboutApp.key = "about_app"
        txvGooglePlay.key = "google_play"


        txvTitle.setOnClickListener {
            translationViewModel.postLanguage(Language.ENGLISH, requireActivity())
        }

    }
}