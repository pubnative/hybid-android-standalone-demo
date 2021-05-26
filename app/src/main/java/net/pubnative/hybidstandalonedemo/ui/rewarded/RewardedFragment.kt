package net.pubnative.hybidstandalonedemo.ui.rewarded

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import net.pubnative.hybidstandalonedemo.databinding.FragmentRewardedBinding

class RewardedFragment : Fragment() {

    private lateinit var rewardedViewModel: RewardedViewModel
    private var _binding: FragmentRewardedBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        rewardedViewModel =
                ViewModelProvider(this).get(RewardedViewModel::class.java)

        _binding = FragmentRewardedBinding.inflate(inflater, container, false)
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