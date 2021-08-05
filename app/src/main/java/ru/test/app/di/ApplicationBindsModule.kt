package ru.test.app.di

import android.content.Context
import dagger.Binds
import dagger.Module
import ru.test.app.AppApplication

@Module
interface ApplicationBindsModule {

    @Binds
    @ApplicationScope
    fun bindContext(appApplication: AppApplication): Context
}
