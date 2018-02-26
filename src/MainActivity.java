import java.io.File;

import javax.jws.WebParam.Mode;

public class MainActivity {

	public static void main(String[] args) {
		
		Model model=Model.getModelObject();
		View view=View.getViewObject();
		Controller controller=Controller.getControllerObject(model, view);
	}
	
	
}
