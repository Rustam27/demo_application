package ru.test.app.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.test.app.app.domain.interactor.MainInteractor
import ru.test.app.app.presentation.mapper.NewItemUiModelMapper
import ru.test.app.base.Status

class MainViewModel(
    private val mainInteractor: MainInteractor,
    private val newItemUiModelMapper: NewItemUiModelMapper,
) : ViewModel() {

    private var loadingNewsJob: Job? = null
    private val _newsStatusFlow = MutableStateFlow<Status>(Status.Loading)

    val newsStatusFlow = _newsStatusFlow.asStateFlow()
    val newsUiModelFlow = mainInteractor.getNews().map(newItemUiModelMapper::map)

    init {
        loadNews()
    }

    fun loadNews() {
        if (loadingNewsJob?.isActive == true) {
            return
        }

        loadingNewsJob = viewModelScope.launch {
            _newsStatusFlow.emit(mainInteractor.loadNewsFormApi())
        }
    }
}
