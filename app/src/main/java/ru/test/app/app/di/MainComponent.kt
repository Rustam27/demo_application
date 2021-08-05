package ru.test.app.app.di

import androidx.lifecycle.ViewModelStore
import dagger.BindsInstance
import dagger.Component
import ru.test.app.app.presentation.view.MainActivity
import ru.test.app.di.ActivityScope
import ru.test.app.di.ApplicationDependency

@ActivityScope
@Component(
    dependencies = [
        ApplicationDependency::class,
    ],
    modules = [
        MainModule::class,
    ]
)
interface MainComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(
            applicationDependency: ApplicationDependency,
            @BindsInstance viewModelStore: ViewModelStore,
        ): MainComponent
    }
}
