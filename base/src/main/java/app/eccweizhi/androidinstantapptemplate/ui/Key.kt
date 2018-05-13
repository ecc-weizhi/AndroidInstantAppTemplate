package app.eccweizhi.androidinstantapptemplate.ui

import android.os.Parcelable
import android.support.v4.app.Fragment


interface Key : Parcelable {
    fun newFragment(): Fragment

    val fragmentTag: String
}