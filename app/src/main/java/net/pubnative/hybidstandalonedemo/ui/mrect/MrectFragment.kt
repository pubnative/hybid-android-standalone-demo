package net.pubnative.hybidstandalonedemo.ui.mrect

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import net.pubnative.hybidstandalonedemo.R
import net.pubnative.lite.sdk.models.AdSize
import net.pubnative.lite.sdk.views.HyBidAdView
import net.pubnative.lite.sdk.views.PNAdView

class MrectFragment : Fragment() {
    val TAG = MrectFragment::class.java.simpleName

    private lateinit var hybidMrect: HyBidAdView
    private lateinit var loadButton: Button

    private val zoneId: String = "5"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_mrect, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hybidMrect = view.findViewById(R.id.hybid_mrect)
        loadButton = view.findViewById(R.id.button_load)

        hybidMrect.setAdSize(AdSize.SIZE_300x250)

        loadButton.setOnClickListener {
            loadBanner()
        }

    }

    override fun onDestroy() {
        hybidMrect.destroy()
        super.onDestroy()
    }

    private fun loadBanner() {
        hybidMrect.load(zoneId, object : PNAdView.Listener {

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