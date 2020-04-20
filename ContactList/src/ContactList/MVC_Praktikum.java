package ContactList;

public class MVC_Praktikum {
    ViewPraktikum viewPraktikum = new ViewPraktikum();
    ModelPraktikum modelPraktikum = new ModelPraktikum();
    ControllerPraktikum controllerPraktikum = new ControllerPraktikum(modelPraktikum,viewPraktikum);
}
