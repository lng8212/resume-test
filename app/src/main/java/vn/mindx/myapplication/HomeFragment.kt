package vn.mindx.myapplication

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import vn.mindx.myapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val resumeFragment = ResumeFragment()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnPreview.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("full_name", binding.edtFullName.text.toString())
            bundle.putString("address", binding.edtAddress.text.toString())
            bundle.putString("city", binding.edtCity.text.toString())
            bundle.putString("state", binding.edtState.text.toString())
            bundle.putString("zip_code", binding.edtZipCode.text.toString())
            bundle.putString("phone", binding.edtPhone.text.toString())
            bundle.putString("email", binding.edtEmail.text.toString())
            bundle.putString("summary", binding.edtSummary.text.toString())

            bundle.putString("company", binding.edtCompany.text.toString())
            bundle.putString("city_state", binding.edtCityState.text.toString())
            bundle.putString("position", binding.edtPosition.text.toString())
            bundle.putString("start", binding.edtStartDate.text.toString())
            bundle.putString("end", binding.edtEndDate.text.toString())
            bundle.putString("description", binding.edtDescription.text.toString())

            bundle.putString("institution", binding.edtInstitution.text.toString())
            bundle.putString("edu_city_state", binding.edtEduCityState.text.toString())
            bundle.putString("major", binding.edtMajor.text.toString())
            bundle.putString("graduation_year", binding.edtGraduateYear.text.toString())
            bundle.putString("addition", binding.edtAddition.text.toString())

            bundle.putString("skill1", binding.edtSkill1.text.toString())
            bundle.putString("skill2", binding.edtSkill2.text.toString())
            bundle.putString("skill3", binding.edtSkill3.text.toString())
            bundle.putString("skill4", binding.edtSkill4.text.toString())
            bundle.putString("skill5", binding.edtSkill5.text.toString())
            val fragmentTransaction: FragmentTransaction =
                requireActivity().supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(binding.root.id, resumeFragment)
            resumeFragment.arguments = bundle
            fragmentTransaction.addToBackStack(ResumeFragment::class.java.simpleName)
            fragmentTransaction.commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}