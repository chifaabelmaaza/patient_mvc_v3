package ma.enset.patient_mvc.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.patient_mvc.entites.Patient;
import ma.enset.patient_mvc.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping(path="/index")
    public  String patients(Model model,@RequestParam(name="page",defaultValue = "0")int page
                                ,@RequestParam(name="size",defaultValue = "5")int size,
                            @RequestParam(name="keyword",defaultValue = "")String keyword){
        Page<Patient> pagePatients=patientRepository.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "patient";
    }
    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/form")
    public String form(Model model ){
        model.addAttribute("patient",new Patient());
        return "form";
    }
    @PostMapping("/save")
    public String save(@Valid Patient patient, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "form";
        patientRepository.save(patient);
        return "redirect:/index";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model){
        Patient patient=patientRepository.findById(id).get();
        model.addAttribute("patient",patient);
        return "edit";
    }
    @GetMapping("/")
    public String home(){

        return "redirect:/index";
    }
    @GetMapping("/patients")
    @ResponseBody
    public List<Patient> listpatients(){
        return patientRepository.findAll();
    }
}