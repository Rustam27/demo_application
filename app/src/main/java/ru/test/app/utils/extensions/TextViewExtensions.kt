package ru.test.app.utils.extensions

import android.widget.TextView

fun TextView.setTextOrGoneIfEmpty(value: CharSequence?) {
    if (value.isNullOrEmpty()) {
        makeGone()
    } else {
        makeVisible()
        text = value
    }
}

