package com.android.MLvision.CameraXFaceDetect.fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import com.android.MLvision.CameraXFaceDetect.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class SettingsFragment : Fragment() {


    private lateinit var landmarkswitch: Switch
    private lateinit var contourswitch: Switch
    private lateinit var performancetoggle: ToggleButton
    private lateinit var backbutton: FloatingActionButton
    private lateinit var classification: Switch
    private lateinit var infobtn: FloatingActionButton
    private val model: PreferenceModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)

    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        backbutton = requireView().findViewById(R.id.floatingActionButton2)
        landmarkswitch = requireView().findViewById(R.id.landmark)
        contourswitch = requireView().findViewById(R.id.contour)
        performancetoggle = requireView().findViewById(R.id.toggleButton)
        classification = requireView().findViewById(R.id.classification)
        infobtn = requireView().findViewById(R.id.info)
        contourswitch.isChecked = model.contour.value != 1
        landmarkswitch.isChecked = model.landmark.value != 1
        classification.isChecked = model.classification.value != 1


        landmarkswitch.setOnCheckedChangeListener { button, b ->

            if (b) {
                model.landmark.value = 2
                model.contour.value = 1
                contourswitch.isChecked = false
            } else {
                model.landmark.value = 1

            }
        }

        contourswitch.setOnCheckedChangeListener { button, b ->
            if (b) {
                model.contour.value = 2
                model.landmark.value = 1
                landmarkswitch.isChecked = false
            } else {
                model.contour.value = 1
            }
        }

        performancetoggle.setOnCheckedChangeListener { compoundButton, b ->
            if (b)
                model.performance.value = 2
            else
                model.performance.value = 1
        }

        classification.setOnCheckedChangeListener { button, b ->
            if (b) {
                model.classification.value = 2
                model.contour.value = 1
                contourswitch.isChecked = false
            } else {
                model.classification.value = 1
            }
        }

        infobtn.setOnClickListener {

            val builder = AlertDialog.Builder(context)
            val inflater = requireActivity().layoutInflater
            builder.setView(inflater.inflate(R.layout.about, null))
            builder.setTitle("About")
            builder.setNegativeButton("Cancel"
            ) { dialog, which -> }
            builder.show()
        }

        backbutton.setOnClickListener {
            Log.i(TAG, "back")
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.fragment_container, CameraFragment())
            transaction.commit()
        }
    }


}

