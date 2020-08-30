package com.messiasjunior.digiointerfaceclone.presentation.home

import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.messiasjunior.digiointerfaceclone.R
import com.messiasjunior.digiointerfaceclone.databinding.FragmentHomeBinding
import com.messiasjunior.digiointerfaceclone.util.event.EventObserver
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private lateinit var productAdapter: ProductAdapter
    private lateinit var spotlightAdapter: SpotlightAdapter
    private val viewModel by viewModel<HomeViewModel>()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSpotlightViewPager()
        setupProductsRecyclerView()
        setupProductClickedEventHandling()

        viewModel.productsApiResponse.observe(viewLifecycleOwner) {
            spotlightAdapter.setItems(it.spotlight)
            productAdapter.setProducts(it.products)
            setupDigioCashTitle(it.cash.title)
        }
    }

    private fun setupSpotlightViewPager() {
        spotlightAdapter = SpotlightAdapter(viewModel)

        binding.homeSpotlightViewPager.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = spotlightAdapter
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            val viewpagerOffset = resources.getDimensionPixelOffset(R.dimen.view_pager_offset)
            setPageTransformer(SpotlightPageTransformer(viewpagerOffset))
        }
    }

    private fun setupDigioCashTitle(title: String) {
        val lastWord = title.split(" ").last()
        val spannableString = SpannableString(title)

        spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.grey)),
            title.length - lastWord.length,
            spannableString.length,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.homeDigioCashSectionTitle.setText(spannableString, TextView.BufferType.SPANNABLE)
        binding.homeDigioCashSectionCard.setOnClickListener {
            viewModel.cashClicked()
        }
    }

    private fun setupProductsRecyclerView() {
        productAdapter = ProductAdapter(viewModel)
        with(binding.homeProductsSectionRecyclerView) {
            adapter = productAdapter
            itemAnimator = DefaultItemAnimator()
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }

    private fun setupProductClickedEventHandling() {
        viewModel.productClickedEvent.observe(
            viewLifecycleOwner,
            EventObserver {
                findNavController().navigate(HomeFragmentDirections.showProduct(it))
            }
        )
    }
}
