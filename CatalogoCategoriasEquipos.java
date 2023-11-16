package proyectointroprogra;


import javax.swing.JOptionPane;

public class CatalogoCategoriasEquipos {

    private String categoryName;
    private String categoryFealure;
    private String hardwareStatus;


    public CatalogoCategoriasEquipos() {

        this.categoryName = "";
        this.categoryFealure = "";
        this.hardwareStatus = "";

    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
   
    public void setCategoryFeature(String categoryFeature) {
        this.categoryFeature = categoryFeature;
    }


    public void setHardwareStatus(String hardwareStatus) {
        this.hardwareStatus = hardwareStatus;
    }


    public String getCategoryName() {
        return categoryName;
    }


    public String getCategoryFeature() {
        return categoryFeature;
    }

    public String getHardwareStatus() {
        return hardwareStatus;
    }
  


}
