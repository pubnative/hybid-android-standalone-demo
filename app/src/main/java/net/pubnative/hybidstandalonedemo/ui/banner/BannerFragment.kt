package net.pubnative.hybidstandalonedemo.ui.banner

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import net.pubnative.hybidstandalonedemo.R
import net.pubnative.lite.sdk.views.HyBidAdView
import net.pubnative.lite.sdk.views.PNAdView


class BannerFragment : Fragment() {
    val TAG = BannerFragment::class.java.simpleName

    private lateinit var hybidBanner: HyBidAdView
    private lateinit var loadButton: Button

    private val zoneId: String = "2"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_banner, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hybidBanner = view.findViewById(R.id.hybid_banner)
        loadButton = view.findViewById(R.id.button_load)

        loadButton.setOnClickListener {
            loadBanner()
        }

    }

    override fun onDestroy() {
        hybidBanner.destroy()
        super.onDestroy()
    }


    private fun loadBanner() {
        hybidBanner.load(zoneId, object : PNAdView.Listener {

            override fun onAdLoaded() {
                Log.d(TAG, "onAdLoaded")
            }

            override fun onAdLoadFailed(error: Throwable) {
                Log.d(TAG, "onAdLoadFailed")
            }

            override fun onAdImpression() {
                Log.d(TAG, "onAdImpression")
            }

            override fun onAdClick() {
                Log.d(TAG, "onAdClick")
            }
        })
    }
}