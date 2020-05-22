package com.vanced.manager.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dezlum.codelabs.getjson.GetJson
import com.vanced.manager.R

/**
 * A simple [Fragment] subclass.
 */
class ManagerChangelogFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_manager_changelog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val changelogTxt = view.findViewById<TextView>(R.id.manager_changelog)

        val checkUrl = GetJson().AsJSONObject("https://x1nto.github.io/VancedFiles/manager.json")
        val changelog = checkUrl.get("versionCode").asString

        if (GetJson().isConnected(requireContext()))
            changelogTxt.text = changelog
    }
}