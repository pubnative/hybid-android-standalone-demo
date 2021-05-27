package net.pubnative.hybidstandalonedemo.ui.rewarded

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import net.pubnative.hybidstandalonedemo.R
import net.pubnative.lite.sdk.rewarded.HyBidRewardedAd

class RewardedFragment : Fragment() {
    val TAG = RewardedFragment::class.java.simpleName

    private lateinit var loadButton: Button
    private lateinit var showButton: Button

    private var rewardedAd: HyBidRewardedAd? = null

    private val zoneId: String = "4"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_rewarded, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadButton = view.findViewById(R.id.button_load)
        showButton = view.findViewById(R.id.button_show)

        loadButton.setOnClickListener {
            loadRewardedVideo()
        }

        showButton.setOnClickListener {
            rewardedAd?.show()
        }

    }

    override fun onDestroy() {
        rewardedAd?.destroy()
        super.onDestroy()
    }

    private fun loadRewardedVideo() {
        rewardedAd = HyBidRewardedAd(activity, zoneId, object : HyBidRewardedAd.Listener {
            override fun onRewardedLoaded() {
                Log.d(TAG, "onRewardedLoaded")
                showButton.isEnabled = true
            }

            override fun onRewardedLoadFailed(error: Throwable) {
                Log.d(TAG, "onRewardedLoadFailed", error)
            }

            override fun onRewardedOpened() {
                Log.d(TAG, "onRewardedOpened")
            }

            override fun onRewardedClosed() {
                Log.d(TAG, "onRewardedClosed")
            }

            override fun onRewardedClick() {
                Log.d(TAG, "onRewardedClick")
            }

            override fun onReward() {
                Log.d(TAG, "onReward")
            }
        })
        rewardedAd!!.load()
    }
}