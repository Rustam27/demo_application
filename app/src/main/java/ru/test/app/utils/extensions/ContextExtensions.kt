package ru.test.app.utils.extensions

import android.content.Context
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import ru.test.app.di.ApplicationDependency
import ru.test.app.utils.ComponentProvider

fun Context.provideApplicationComponent(): ApplicationDependency {
    return (applicationContext as ComponentProvider<*>).provide() as ApplicationDependency
}

fun Context.getColorCompat(@ColorRes colorRes: Int): Int {
    return ContextCompat.getColor(this, colorRes)
}
