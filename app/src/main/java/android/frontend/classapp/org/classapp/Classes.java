package android.frontend.classapp.org.classapp;

/**
 * Created by PORTATIL20 on 13/10/2016.
 */
public class Classes {

    private String titulo;
    private String descripion;
    private int imagen;

    public Classes(String titulo, int imagen, String descripion) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.descripion = descripion;
    }

    public Classes(String titulo, String descripion) {
        this.titulo = titulo;
        this.descripion = descripion;
    }



    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
