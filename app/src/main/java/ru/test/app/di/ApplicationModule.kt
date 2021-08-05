package ru.test.app.di

import dagger.Module

@Module(
    includes = [
        ApplicationBindsModule::class,
        NetworkModule::class,
    ]
)
object ApplicationModule
