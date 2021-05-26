package net.pubnative.hybidstandalonedemo.ui.interstitial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import net.pubnative.hybidstandalonedemo.databinding.FragmentInterstitialBinding

class InterstitialFragment : Fragment() {

    private lateinit var interstitialViewModel: InterstitialViewModel
    private var _binding: FragmentInterstitialBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        interstitialViewModel =
                ViewModelProvider(this).get(InterstitialViewModel::class.java)

        _binding = FragmentInterstitialBinding.inflate(inflater, container, false)
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