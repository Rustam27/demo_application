package ru.test.app.app.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.room.Room
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.test.app.app.data.database.NewsDao
import ru.test.app.app.data.database.NewsDatabase
import ru.test.app.app.domain.interactor.MainInteractor
import ru.test.app.app.presentation.mapper.NewItemUiModelMapper
import ru.test.app.app.presentation.viewmodel.MainViewModel
import ru.test.app.data.MeduzaApi
import ru.test.app.di.ActivityScope
import ru.test.app.utils.helpers.ViewModelFactory

@Module
object MainModule {

    @Provides
    @ActivityScope
    fun provideMainViewModel(
        viewModelStore: ViewModelStore,
        mainInteractor: MainInteractor,
        newItemUiModelMapper: NewItemUiModelMapper,
    ): MainViewModel {
        val factory: ViewModelFactory<*> = ViewModelFactory<ViewModel> {
            MainViewModel(
                mainInteractor,
                newItemUiModelMapper,
            )
        }
        return ViewModelProvider(viewModelStore, factory)
            .get(MainViewModel::class.java)
    }

    @Provides
    @ActivityScope
    fun provideMeduzaApi(retrofit: Retrofit): MeduzaApi {
        return retrofit.create(MeduzaApi::class.java)
    }

    @Provides
    @ActivityScope
    fun provideNewsDatabase(context: Context): NewsDatabase {
        return Room.databaseBuilder(context, NewsDatabase::class.java, NewsDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideNewsDao(database: NewsDatabase): NewsDao {
        return database.newsDao
    }
}
