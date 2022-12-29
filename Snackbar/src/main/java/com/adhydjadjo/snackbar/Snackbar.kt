package com.adhydjadjo.snackbar

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

object Snackbar {
    enum class PositionSnackBar {
        TOP,
        BOTTOM
    }

    enum class Type {
        INFO,
        WARNING,
        ERROR
    }

    fun showSnackbar(
        context: Context,
        view: View,
        message: String,
        pos: PositionSnackBar = PositionSnackBar.BOTTOM,
        margin: Int = 147,
        type: Type = Type.INFO
    ) {

        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        var color = when (type) {
            Type.INFO -> {
                R.color.colorInfo
            }
            Type.WARNING -> {
                R.color.colorWarning
            }
            Type.ERROR -> {
                R.color.colorError
            }
        }

        snackbar.view.setBackgroundColor(
            ContextCompat.getColor(context, color)
        )
        if (pos == PositionSnackBar.TOP) {
            try {
                val params = snackbar.view.layoutParams as CoordinatorLayout.LayoutParams
                params.gravity = Gravity.TOP
                params.topMargin = margin
                snackbar.view.layoutParams = params
            } catch (e: Exception) {
                val params = snackbar.view.layoutParams as FrameLayout.LayoutParams
                params.gravity = Gravity.TOP
                params.topMargin = margin
                snackbar.view.layoutParams = params
            }
        }
        val snackbarTextId: Int = com.google.android.material.R.id.snackbar_text
        snackbar.view.findViewById<TextView>(snackbarTextId)
            .setTextColor(
                ContextCompat.getColor(context, R.color.colorText)
            )
        snackbar.apply {
            show()
        }
    }
}