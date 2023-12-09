package proyectofixtech;

public class Categorias_Equipos {

    private String categoryName, atributes, categoryStatus;

    public Categorias_Equipos() {
        this.categoryName = "";
        this.atributes = "";
        this.categoryStatus = "";
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAtributes() {
        return atributes;
    }

    public void setAtributes(String atributes) {
        this.atributes = atributes;
    }

    public String getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(String categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

}
