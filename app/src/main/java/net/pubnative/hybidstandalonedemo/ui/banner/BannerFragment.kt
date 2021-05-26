package net.pubnative.hybidstandalonedemo.ui.banner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import net.pubnative.hybidstandalonedemo.databinding.FragmentBannerBinding

class BannerFragment : Fragment() {

    private lateinit var bannerViewModel: BannerViewModel
    private var _binding: FragmentBannerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        bannerViewModel =
                ViewModelProvider(this).get(BannerViewModel::class.java)

        _binding = FragmentBannerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val loadButton: Button = binding.buttonLoad

        loadButton.setOnClickListener{

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}