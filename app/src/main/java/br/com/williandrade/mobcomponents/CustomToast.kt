package br.com.williandrade.mobcomponents

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

object CustomToast {
    private fun showToast(
        activit : Activity,
        backgroundToast : Drawable?,
        icon : Drawable?,
        message : String,
        duration : Int = Toast.LENGTH_SHORT
    ){
        val toastLayout = activit.layoutInflater.inflate(R.layout.custom_toast, null)
        toastLayout.background = backgroundToast
        toastLayout.findViewById<TextView>(R.id.tvMessageToast).text = message
        val ivIconToast = toastLayout.findViewById<ImageView>(R.id.ivIconToast)
        if (icon == null){
            ivIconToast.visibility = View.GONE
        } else {
            ivIconToast.visibility = View.VISIBLE
            ivIconToast.setImageDrawable(icon)
        }
        val toast = Toast(activit)
        toast.view = toastLayout
        toast.duration = duration
        toast.show()
    }

    fun success(activit: Activity,message: String){
        showToast(
            activit,
            ContextCompat.getDrawable(activit, R.drawable.toast_bg_success),
            ContextCompat.getDrawable(activit, R.drawable.ic_success),
            message
        )
    }
    fun error(activit: Activity,message: String){
        showToast(
            activit,
            ContextCompat.getDrawable(activit, R.drawable.toast_bg_error),
            ContextCompat.getDrawable(activit, R.drawable.ic_error),
            message
        )
    }
    fun info(activit: Activity,message: String){
        showToast(
            activit,
            ContextCompat.getDrawable(activit, R.drawable.toast_bg_info),
            ContextCompat.getDrawable(activit, R.drawable.ic_info),
            message
        )
    }
    fun warning(activit: Activity,message: String){
        showToast(
            activit,
            ContextCompat.getDrawable(activit, R.drawable.toast_bg_warning),
            ContextCompat.getDrawable(activit, R.drawable.ic_warning),
            message
        )
    }
    fun default(activit: Activity,message: String){
        showToast(
            activit,
            ContextCompat.getDrawable(activit, R.drawable.toast_bg_default),
            null,
            message
        )
    }
}