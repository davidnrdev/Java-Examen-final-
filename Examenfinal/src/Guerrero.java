//Representa una clase hija de Personaje, que es un Guerrero. 
// Esta subclase hereda de Personaje 

public class Guerrero extends Personaje {

    public Guerrero(int id, String nombre, int nivel) {
        super(id, nombre, nivel);
    }

    @Override
    public String realizarAccion() {
        return "ataca con su espada";
    }
}
