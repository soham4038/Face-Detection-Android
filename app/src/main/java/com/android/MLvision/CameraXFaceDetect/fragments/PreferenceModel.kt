package com.android.MLvision.CameraXFaceDetect.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class PreferenceModel : ViewModel() {

    val landmark: MutableLiveData<Int> = MutableLiveData(2)
    val contour: MutableLiveData<Int> = MutableLiveData(1)
    val performance: MutableLiveData<Int> = MutableLiveData(1)
    val classification: MutableLiveData<Int> = MutableLiveData(2)

}