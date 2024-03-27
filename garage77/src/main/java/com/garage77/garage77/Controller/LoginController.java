package com.garage77.garage77.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.garage77.garage77.Model.Admin;
import com.garage77.garage77.Repository.UserRepository;

//SYSTEM.OUT.PRINT ES PARA CADENA
//BOTAR LA ENTIDA ADMIN EN BASE AL USUARIO Y CONTRASEÑA
@Controller
@RequestMapping("/login")
public class LoginController
{

	@Autowired
	private UserRepository repoUse;

	@PostMapping("/valida")
	public String logeoAdmin(@ModelAttribute Admin admin,
			@RequestParam(value = "action", required = false) String action, Model model) {

		if ("logear".equals(action)) {

			if (admin != null) {
				Admin nuevoadmin = repoUse.findByAdminUsu(admin.getAdminUsu(), admin.getAdminContra());
				if (nuevoadmin != null)
					return "Index";
			}    {
				model.addAttribute("mensaje", "No se encontro Usuario");
				return "Login";
			}
		} else {
			System.out.print("No hay nada");
		}
		return "Login";
	}

}
