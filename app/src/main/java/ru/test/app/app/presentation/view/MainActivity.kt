package ru.test.app.app.presentation.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.flow.collect
import ru.test.app.R
import ru.test.app.app.di.DaggerMainComponent
import ru.test.app.app.presentation.adapter.NewsAdapter
import ru.test.app.app.presentation.adapter.NewsDividerDecorator
import ru.test.app.app.presentation.model.NewsItem
import ru.test.app.app.presentation.viewmodel.MainViewModel
import ru.test.app.base.Status
import ru.test.app.databinding.ActivityMainBinding
import ru.test.app.utils.extensions.makeGone
import ru.test.app.utils.extensions.makeVisible
import ru.test.app.utils.extensions.provideApplicationComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var viewModel: MainViewModel

    private val applicationDependency by lazy { provideApplicationComponent() }
    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    private val adapter: NewsAdapter
        get() = binding.mainRecyclerView.adapter as NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDependencies()

        setTitle(R.string.main_title)

        initList()
        initListeners()
        observeData()
    }

    private fun initDependencies() {
        DaggerMainComponent.factory()
            .create(
                applicationDependency,
                viewModelStore,
            ).inject(this)
    }

    private fun initList() {
        binding.mainRecyclerView.addItemDecoration(NewsDividerDecorator(this))
        binding.mainRecyclerView.adapter = NewsAdapter()
    }

    private fun initListeners() {
        binding.emptyRepeatButton.setOnClickListener {
            viewModel.loadNews()
        }
    }

    private fun observeData() {
        lifecycleScope.launchWhenStarted {
            viewModel.newsStatusFlow.collect(::handleNewsStatus)
        }
        lifecycleScope.launchWhenStarted {
            viewModel.newsUiModelFlow.collect(::handleNews)
        }
    }

    private fun handleNews(items: List<NewsItem>) {
        adapter.items = items

        binding.emptyGroup.isVisible = items.isEmpty()
    }

    private fun handleNewsStatus(status: Status) {
        when (status) {
            Status.Loading -> binding.mainProgressView.makeVisible()
            Status.Success -> binding.mainProgressView.makeGone()
            is Status.Error -> {
                binding.mainProgressView.makeGone()
                Toast.makeText(this, R.string.main_loading_news_error, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
