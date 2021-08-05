package ru.test.app.di

import android.content.Context
import retrofit2.Retrofit

interface ApplicationDependency {

    fun getContext(): Context

    fun getRetrofit(): Retrofit
}
