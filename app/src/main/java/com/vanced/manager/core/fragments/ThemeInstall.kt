package com.vanced.manager.core.fragments

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.navigation.findNavController
import com.vanced.manager.R
import com.vanced.manager.core.base.BaseFragment

open class ThemeInstall : BaseFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextButton = view.findViewById<Button>(R.id.vanced_next_to_variant)
        val themeGroup = view.findViewById<RadioGroup>(R.id.theme_radiogroup)

        nextButton.setOnClickListener {
            val selectedThemeId = themeGroup.checkedRadioButtonId
            val selectedButton = view.findViewById<RadioButton>(selectedThemeId)
            prefs?.edit()?.putString("theme", selectedButton.tag.toString())?.apply()
            view.findNavController().navigate(R.id.toInstallLanguageFragment)
        }
    }

}