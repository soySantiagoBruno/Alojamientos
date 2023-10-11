package com.Alojamientos.alojamientos.Controller;


import com.Alojamientos.alojamientos.Entity.Alojamiento;
import com.Alojamientos.alojamientos.Service.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AlojamientoController {
    //services
    @Autowired
    AlojamientoService alojamientoService;



    @ResponseBody
    @GetMapping("/hola")
    public String hola(){
        return "hola mundo!";
    }

    @GetMapping("/")
    public String home(Model model){
        List<Alojamiento> list = alojamientoService.getAlojamientos();

        //inserto en el model la lista de alojamientos
        model.addAttribute("alojamiento",list);

        return "home";
    }

        /*@GetMapping("/buscar/{name}")
        public String searchById(Model model, @PathVariable String nombreAlojamiento){

            Alojamiento alojamiento= alojamientoService.getAlojamientoByName(nombreAlojamiento);

            //inserto en el model la lista de alojamientos
            model.addAttribute("alojamiento",alojamiento);

            return "home";
        }*/

    //este endopoint trae un alojamiento a partir de un input que se le pase en el front
    @GetMapping("/buscar")
    public String buscar(Model model, @RequestParam(value = "nombreAlojamiento") String nombreAlojamiento){
        //para que este método funcione, tuve que especificar th:name="nombreAlojamiento en el input del form"

        Alojamiento alojamiento= alojamientoService.getAlojamientoByName(nombreAlojamiento);

        //inserto en el model la lista de alojamientos
        model.addAttribute("alojamiento",alojamiento);

        return "home";
    }

    @GetMapping("/registrar_alojamiento")
    public String agregarAlojamiento(){
        return "registrarAlojamiento";
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Alojamiento alojamiento){
        alojamientoService.save(alojamiento);
        return "redirect:/";
    }

    @GetMapping("/modificar_alojamiento")
    public String modificarAlojamiento(Model model){
        List<Alojamiento> list = alojamientoService.getAlojamientos();

        //inserto en el model la lista de alojamientos
        model.addAttribute("alojamiento",list);

        return "modificarAlojamiento";
    }



    @GetMapping("/modificar")
    public String modificar(){
        return "modificar";
    }


    @RequestMapping("/modificar/{idAlojamiento}")
    public String modificar(@PathVariable("idAlojamiento") Long idAlojamiento, Model model){

        /* Me traigo el alojamiento (a partir del id) y lo cargo en el model para que lo use el formulario en "modificar"  */
        Alojamiento alojamientoOriginal= alojamientoService.getAlojamientoById(idAlojamiento);
        model.addAttribute("alojamiento",alojamientoOriginal);
        return "modificar";

    }

    @RequestMapping("/eliminar/{idAlojamiento}")
    public String eliminar(@PathVariable("idAlojamiento") Long idAlojamiento){
        alojamientoService.deleteAlojamientoById(idAlojamiento);
        return "redirect:/";
    }
}
