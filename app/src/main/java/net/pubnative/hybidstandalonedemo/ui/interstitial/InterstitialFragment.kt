package net.pubnative.hybidstandalonedemo.ui.interstitial

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import net.pubnative.hybidstandalonedemo.R
import net.pubnative.lite.sdk.interstitial.HyBidInterstitialAd

class InterstitialFragment : Fragment() {
    val TAG = InterstitialFragment::class.java.simpleName

    private lateinit var loadButton: Button
    private lateinit var showButton: Button

    private var interstitial: HyBidInterstitialAd? = null
    private val zoneId: String = "3"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_interstitial, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadButton = view.findViewById(R.id.button_load)
        showButton = view.findViewById(R.id.button_show)

        loadButton.setOnClickListener {
            loadInterstitial()
        }

        showButton.setOnClickListener {
            interstitial?.show()
        }

    }

    override fun onDestroy() {
        interstitial?.destroy()
        super.onDestroy()
    }

    private fun loadInterstitial() {
        interstitial = HyBidInterstitialAd(activity, zoneId, object : HyBidInterstitialAd.Listener {
            override fun onInterstitialLoaded() {
                Log.d(TAG,"onInterstitialLoaded")
                showButton.isEnabled = true
            }

            override fun onInterstitialLoadFailed(error: Throwable) {
                Log.d(TAG,"onInterstitialLoadFailed")
            }

            override fun onInterstitialImpression() {
                Log.d(TAG,"onInterstitialImpression")
            }

            override fun onInterstitialDismissed() {
                Log.d(TAG,"onInterstitialDismissed")
                showButton.isEnabled = false
            }

            override fun onInterstitialClick() {
                Log.d(TAG,"onInterstitialClick")
            }
        })
        interstitial?.setSkipOffset(3)
        interstitial!!.load()
    }
}