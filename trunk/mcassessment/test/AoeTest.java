
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import th.co.imake.missconsult.assessment.service.McDegreeService;



public class AoeTest {
	private static Character mdName;

	public static void main(String[] args) {
		System.out.println("************** BEGINNING PROGRAM **************");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-data-test.xml");
		McDegreeService personService = (McDegreeService) context
				.getBean("mcDegreeService");
				//.getBean("userServiceJdbcImp");
	
	System.out.println(personService.findMcDegreeById(180));
		//personService.insert(person);
		/*System.out.println("Person : " + person + " added successfully");
		List<Aoe> persons = personService.fetchAllUsers();
		*/
	System.out.println(personService.findMcDegreeM("mdName"));
	}
}