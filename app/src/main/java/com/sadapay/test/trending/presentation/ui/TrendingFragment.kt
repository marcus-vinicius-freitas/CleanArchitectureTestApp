package com.sadapay.test.trending.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sadapay.test.databinding.FragmentTrendingBinding
import com.sadapay.test.trending.domain.models.TrendingModel
import com.sadapay.test.trending.presentation.ui.adapter.TrendingAdapter
import com.sadapay.test.trending.presentation.viewmodel.TrendingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingFragment : Fragment() {

    private var _binding: FragmentTrendingBinding? = null

    private val binding get() = _binding!!

    private val viewModel : TrendingViewModel by viewModels()

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

    private fun processLoading(isLoading: Boolean?) {

    }

    private fun processResult(model: TrendingModel?) {
        model?.let {
            binding.repositoryList.adapter = TrendingAdapter(requireContext(), it.items)
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