package ru.test.app.di

import dagger.BindsInstance
import dagger.Component
import ru.test.app.AppApplication

@ApplicationScope
@Component(
    modules = [
        ApplicationModule::class
    ]
)
interface ApplicationComponent : ApplicationDependency {

    fun inject(app: AppApplication)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: AppApplication,
        ): ApplicationComponent
    }
}
