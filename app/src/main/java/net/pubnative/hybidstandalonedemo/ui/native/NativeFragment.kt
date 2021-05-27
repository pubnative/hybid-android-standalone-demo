package net.pubnative.hybidstandalonedemo.ui.native

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import net.pubnative.hybidstandalonedemo.R
import net.pubnative.lite.sdk.models.NativeAd
import net.pubnative.lite.sdk.request.HyBidNativeAdRequest


class NativeFragment : Fragment(), HyBidNativeAdRequest.RequestListener, NativeAd.Listener{
    val TAG = NativeFragment::class.java.simpleName

    private lateinit var loadButton: Button

    private lateinit var adContainer: ViewGroup
    private lateinit var adIcon: ImageView
    private lateinit var adBanner: ImageView
    private lateinit var adTitle: TextView
    private lateinit var adDescription: TextView
    private lateinit var adChoices: FrameLayout
    private lateinit var adCallToAction: Button
    private lateinit var adRating: RatingBar

    private var nativeAd: NativeAd? = null
    private var nativeAdRequest: HyBidNativeAdRequest? = null

    private val zoneId: String = "7"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_native, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadButton = view.findViewById(R.id.button_load)

        adContainer = view.findViewById(R.id.ad_container)
        adIcon = view.findViewById(R.id.ad_icon)
        adBanner = view.findViewById(R.id.ad_banner)
        adTitle = view.findViewById(R.id.ad_title)
        adDescription = view.findViewById(R.id.ad_description)
        adChoices = view.findViewById(R.id.ad_choices)
        adCallToAction = view.findViewById(R.id.ad_call_to_action)
        adRating = view.findViewById(R.id.ad_rating)

        loadButton.setOnClickListener {
            loadNativeAd()
        }

    }

    override fun onDestroy() {
        if (nativeAd != null) {
            nativeAd!!.stopTracking()
        }
        super.onDestroy()
    }

    private fun loadNativeAd() {
        val nativeAdRequest = HyBidNativeAdRequest()
        nativeAdRequest.load(zoneId, this)
    }

    fun renderAd(ad: NativeAd?) {
        nativeAd = ad
        adTitle.text = ad?.title
        adDescription.text = ad?.description
        adCallToAction.text = ad?.callToActionText
        adChoices.addView(ad?.getContentInfo(context))

        val rating = ad?.rating?.toFloat()
        adRating.rating = rating!!

        Picasso.get().load(ad.bannerUrl).into(adBanner)
        Picasso.get().load(ad.iconUrl).into(adIcon)

        ad.startTracking(adContainer, this)
    }

    override fun onRequestSuccess(ad: NativeAd?) {
        Log.d(TAG, "onRequestSuccess")
        renderAd(ad)
    }

    override fun onRequestFail(throwable: Throwable?) {
        Log.d(TAG, "onRequestFail")
    }

    override fun onAdImpression(ad: NativeAd?, view: View?) {
        Log.d(TAG, "onAdImpression")
    }

    override fun onAdClick(ad: NativeAd?, view: View?) {
        Log.d(TAG, "onAdClick")
    }

}