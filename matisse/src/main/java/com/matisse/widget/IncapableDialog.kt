package com.matisse.widget

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import com.matisse.R

class IncapableDialog : DialogFragment() {

    companion object {
        val EXTRA_TITLE = "extra_title"
        val EXTRA_MESSAGE = "extra_message"

        fun newInstance(title: String?, message: String?): IncapableDialog {
            val dialog = IncapableDialog()
            val bundle = Bundle()
            bundle.putString(EXTRA_TITLE, title)
            bundle.putString(EXTRA_MESSAGE, message)
            dialog.arguments = bundle
            return dialog
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {
        val title = arguments?.getString(EXTRA_TITLE) ?: ""
        val message = arguments?.getString(EXTRA_MESSAGE) ?: ""

        val builder = activity?.let { AlertDialog.Builder(it) }
        if (!title.isEmpty()) {
            builder?.setTitle(title)
        }

        if (!message.isEmpty()) {
            builder?.setMessage(message)
        }

        builder?.setPositiveButton(R.string.button_ok) { dialog, _ -> dialog?.dismiss() }

        return builder?.create()!!
    }
}