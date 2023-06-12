package br.com.api.aula.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.aula.models.Parametros;

@RestController //anotação de start do controller
@RequestMapping ("/aula") //anotação utilizada para mapear a requisição
public class AulaController {
	
	//usando @PathVariable
	@GetMapping ("/somaPV/{valor}/{valor1}")
	public Integer somarPv(@PathVariable Integer valor, @PathVariable Integer valor1) {
		return valor+valor1;
	}
	
	@GetMapping ("/subPV/{valor}/{valor1}")
	public Integer subtrairPv(@PathVariable Integer valor, @PathVariable Integer valor1) {
		return valor-valor1;
	}
	
	@GetMapping ("/multPV/{valor}/{valor1}")
	public Integer multiplicarPv(@PathVariable Integer valor, @PathVariable Integer valor1) {
		return valor*valor1;
	}
	
	@GetMapping ("/divPV/{valor}/{valor1}")
	public Integer dividirPv(@PathVariable Integer valor, @PathVariable Integer valor1) {
		return valor/valor1;
	}
	
	//usando @RequestParam
	@GetMapping ("/somaRP")
	public Integer somar(@RequestParam(required=false) Integer valor, @RequestParam(required=false) Integer valor1) {
		return valor+valor1;
	}
	
	@GetMapping ("/subRP")
	public Integer subtrair(@RequestParam(required=false) Integer valor, @RequestParam(required=false) Integer valor1) {
		return valor-valor1;
	}
	
	@GetMapping ("/multRP")
	public Integer multiplicar(@RequestParam(required=false) Integer valor, @RequestParam(required=false) Integer valor1) {
		return valor*valor1;
	}
	
	@GetMapping ("/divRP")
	public Integer dividir(@RequestParam(required=false) Integer valor, @RequestParam(required=false) Integer valor1) {
		return valor/valor1;
	}
	
	//usando @RequestBody
	@GetMapping ("/somaRB")
	public Integer somar(@RequestBody Parametros valores ) { 
		return valores.getValor()+valores.getValor1();
	}
	
	@GetMapping ("/subRB")
	public Integer subtrair(@RequestBody Parametros valores) {
		return valores.getValor()-valores.getValor1();
	}
	
	@GetMapping ("/multRB")
	public Integer multiplicar(@RequestBody Parametros valores) {
		return valores.getValor()*valores.getValor1();
	}
	
	@GetMapping ("/divRB")
	public Integer dividir(@RequestBody Parametros valores) {
		return valores.getValor()/valores.getValor1();
	}
	
//	//http://localhost:8080/aula/soma
//	@GetMapping ("/soma") //anotação que indica o verbo HTTP da requisição
//	public String somar() {
//		return "2+2=4";
//	}
//	
//	//http://localhost:8080/aula/sub
//	@GetMapping ("/sub") //anotação que indica o verbo HTTP da requisição
//	public String subtrair() {
//		return "2-2=0";
//	}
//		
//	//http://localhost:8080/aula/mult
//	@GetMapping ("/mult") //anotação que indica o verbo HTTP da requisição
//	public String multiplicar() {
//		return "2*2=4";
//	}
//		
//	//http://localhost:8080/aula/div
//	@GetMapping ("/div") //anotação que indica o verbo HTTP da requisição
//	public String dividir() {
//		return "2/2=1";
//	}
}
