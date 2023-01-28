package vn.mindx.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gkemon.XMLtoPDF.PdfGenerator
import com.gkemon.XMLtoPDF.PdfGeneratorListener
import vn.mindx.myapplication.databinding.FragmentResumeBinding

class ResumeFragment : Fragment() {
    private var _binding: FragmentResumeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResumeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        val bundle = arguments
        with(binding) {
            txtName.text = bundle?.getString("full_name")
            txtAddress.text = bundle?.getString("address")
            txtCity.text =
                "${bundle?.getString("city")} ${bundle?.getString("state")} ${bundle?.getString("zip_code")}"
            txtPhone.text = bundle?.getString("phone")
            txtEmail.text = bundle?.getString("email")
            txtAdditionalInfo.text = bundle?.getString("summary")

            txtCompany.text = "${bundle?.getString("company")} ${bundle?.getString("city_state")}"
            txtPosition.text = "${bundle?.getString("position")} ${bundle?.getString("start")} ${
                bundle?.getString("end")
            }"
            txtDescription.text = bundle?.getString("description")

            txtInstitution.text =
                "${bundle?.getString("institution")} ${bundle?.getString("edu_city_state")}"
            txtMajor.text = "${bundle?.getString("major")} ${bundle?.getString("graduation_year")}"
            txtAdditionalInfoEdu.text = bundle?.getString("addition")

            txtAdditionalSkill.text =
                "${bundle?.getString("skill1")}\n${bundle?.getString("skill2")}\n${
                    bundle?.getString("skill3")
                }\n${bundle?.getString("skill4")}\n${bundle?.getString("skill5")}"
        }
        binding.btnSave.setOnClickListener {
            PdfGenerator.getBuilder().setContext(requireActivity())
                .fromViewIDSource()
                .fromViewID(requireActivity(),R.id.sv_resume)
                .setFileName("Test-PDF")
                .actionAfterPDFGeneration(PdfGenerator.ActionAfterPDFGeneration.OPEN)
                .build(object: PdfGeneratorListener(){
                    override fun onStartPDFGeneration() {

                    }

                    override fun onFinishPDFGeneration() {
                        Toast.makeText(requireContext(),"Saved!", Toast.LENGTH_SHORT).show()
                    }

                })

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}