package com.marcusfreitas.test.trending.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.marcusfreitas.test.databinding.FragmentTrendingBinding
import com.marcusfreitas.test.trending.data.mappers.TrendingMapper
import com.marcusfreitas.test.trending.data.repositories.TrendingRepository
import com.marcusfreitas.test.trending.data.service.ApiService
import com.marcusfreitas.test.trending.domain.models.TrendingModel
import com.marcusfreitas.test.trending.presentation.ui.adapter.TrendingAdapter
import com.marcusfreitas.test.trending.presentation.viewmodel.TrendingViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * A fragment that is responsible to show the list of the trending github projects
 */
@AndroidEntryPoint
class TrendingFragment : Fragment() {

    private var _binding: FragmentTrendingBinding? = null

    private val binding get() = _binding!!

    private val viewModel : TrendingViewModel by viewModels()

    @Inject
    lateinit var adapter: TrendingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrendingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.trendingReposState.observe(viewLifecycleOwner) {
            processResult(it)
        }

        viewModel.loadingState.observe(viewLifecycleOwner) {
            processLoading(it)
        }

        viewModel.getTrendingRepos()
    }

    /**
     * This method handles when the [TrendingViewModel.loadingState] changes its value
     *
     * @param[isLoading] A boolean parameter to inform the loading state
     */
    private fun processLoading(isLoading: Boolean?) {
        binding.loadingPanel.visibility = if (isLoading == true) View.VISIBLE else View.INVISIBLE
    }

    /**
     * This method handles when the [TrendingViewModel.trendingReposState] changes its value
     *
     * @param[model] The [TrendingModel] object that is going to be used to populate the view
     */
    private fun processResult(model: TrendingModel?) {
        model?.let {
            binding.repositoryList.adapter = adapter
            adapter.setRepositories(model.items)
            binding.errorPanel.visibility = View.INVISIBLE
        } ?: run {
            binding.errorPanel.visibility = View.VISIBLE
            binding.retryButton.setOnClickListener {
                viewModel.getTrendingRepos()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}