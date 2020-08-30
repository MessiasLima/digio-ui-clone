package com.messiasjunior.digiointerfaceclone.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.messiasjunior.digiointerfaceclone.R
import com.messiasjunior.digiointerfaceclone.databinding.FragmentHomeBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
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
    }

    private fun setupSpotlightViewPager() {
        val spotlightAdapter = SpotlightAdapter()

        binding.homeSpotlightViewPager.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = spotlightAdapter
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            val viewpagerOffset = resources.getDimensionPixelOffset(R.dimen.view_pager_offset)
            setPageTransformer(SpotlightPageTransformer(viewpagerOffset))
        }

        viewModel.productsApiResponse.observe(viewLifecycleOwner) {
            spotlightAdapter.setItems(it.spotlight)
        }
    }
}
