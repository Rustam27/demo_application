package ru.test.app

import android.app.Application
import ru.test.app.di.ApplicationDependency
import ru.test.app.di.DaggerApplicationComponent
import ru.test.app.utils.ComponentProvider

class AppApplication : Application(), ComponentProvider<ApplicationDependency> {

    private var component: ApplicationDependency? = null

    override fun onCreate() {
        super.onCreate()

        initDependencies()
    }

    override fun provide(): ApplicationDependency = component ?: error("ApplicationComponent not initialized")

    private fun initDependencies() {
        component = DaggerApplicationComponent.factory()
            .create(this)
            .also { component ->
                component.inject(this)
            }
    }
}
