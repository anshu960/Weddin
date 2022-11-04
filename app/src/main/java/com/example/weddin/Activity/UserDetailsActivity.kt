package com.example.weddin.Activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weddin.Model.User
import com.example.weddin.R
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        var happyPlaceDetailModel : User ?= null
        if (intent.hasExtra(ProfileActivity.EXTRA_PLACE_DETAILS)){
            happyPlaceDetailModel =
                intent.getSerializableExtra(
                    ProfileActivity.EXTRA_PLACE_DETAILS) as User
        }
        if (happyPlaceDetailModel!= null){
            setSupportActionBar(toolbar_happy_place_detail)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = happyPlaceDetailModel.title

            toolbar_happy_place_detail.setNavigationOnClickListener {
                onBackPressed()
            }
            iv_image.setImageURI(Uri.parse(happyPlaceDetailModel.image))
            tv_name.text = happyPlaceDetailModel.description
            tv_description.text = happyPlaceDetailModel.title
            tv_address.text = happyPlaceDetailModel.location
            tv_date.text = happyPlaceDetailModel.date
        }
    }
}