//Representa una clase hija dePersonaje, que es un Mago.
// Esta subclase hereda de Personaje
public class Mago extends Personaje {

    public Mago(int id, String nombre, int nivel) {
        super(id, nombre, nivel);
    }

    @Override
    public String realizarAccion() {
        return "lanza un poderoso hechizo";
    }
}