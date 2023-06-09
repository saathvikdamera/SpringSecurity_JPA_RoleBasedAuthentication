package in.sta.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	@GetMapping("/all")
	public String getMsg() {
		return "Hi,Everyone...";
	}
	
	@GetMapping("/admin")
	public String getAdminMsg() {
		return "Hello,Admin...";
	}
	
	@GetMapping("/user")
	public String getUserMsg() {
		return "Hi,saathvik...";
	}
}
