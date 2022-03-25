package binar.ganda.challengech3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_third.*




class ThirdFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if  (arguments?.containsKey("PERSON") == true) {
            val person = arguments?.getSerializable("PERSON") as Person
            val name = person.name
            val age = person.age
            val address = person.address
            val job = person.job
            val ganjilGenap = if (age % 2 == 0) {
                "Umur anda Genap"
            } else {
                "Umur anda Ganjil"
            }
            result.text = """
                Selamat Datang, $name
                Anda Berumur $age, $ganjilGenap
                Asal : $address
                Pekerjaan: $job
            """.trimIndent()
        } else {
            val name = arguments?.getString("NAME")
            result.text = """
                Selamat Datang, $name
            """.trimIndent()
        }

        gotoscren4_btn.setOnClickListener {
            val name = if (arguments?.containsKey("PERSON") == true) {
                val person = arguments?.getSerializable("PERSON") as Person
                person.name
            } else {
                arguments?.getString("NAME").toString()
            }
            val datanama = bundleOf("NAME" to name)
            Navigation.findNavController(view).navigate(R.id.action_thirdFragment_to_fourthFragment, datanama)
        }

    }


}