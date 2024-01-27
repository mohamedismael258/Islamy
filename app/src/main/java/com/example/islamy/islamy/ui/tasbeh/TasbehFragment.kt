package com.example.islamy.islamy.ui.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.islamy.R
import com.example.islamy.databinding.FragmentTasbehBinding


class TasbehFragment: Fragment() {
    lateinit var binding: FragmentTasbehBinding
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentTasbehBinding.inflate(layoutInflater)
        return binding.root


    }
    private val azkarName= listOf<String>("سبحان الله","الحمد لله","الله اكبر")
    var azkarCount:Int=0
    var numberOfTasbeh  :Int=0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       Tasbeh()
    }

    private fun Tasbeh() {
        binding.azkarTxt.setText(azkarName[azkarCount])
        binding.azkarBackground.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                rotate()
                numberOfTasbeh += 1
                binding.tasbehCountNum.text = ""+numberOfTasbeh
                if(numberOfTasbeh>33)
                {
                    editAzkar()
                }
            }
        })
    }
            private fun editAzkar() {
                numberOfTasbeh=0
                azkarCount+=1
                if(azkarCount>2)
                {
                    azkarCount=0
                }
                binding.azkarTxt.setText(azkarName[azkarCount])
                binding.tasbehCountNum.text=""+0
            }
    private fun rotate()
    {
        val aniRotate: Animation =
            AnimationUtils.loadAnimation(context, R.anim.rotate)
        binding.bodyOfSeb.startAnimation(aniRotate)
    }


}
