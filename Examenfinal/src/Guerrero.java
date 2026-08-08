

public class Guerrero extends Personaje {

    public Guerrero(int id, String nombre, int nivel) {
        super(id, nombre, nivel);
    }

    @Override
    public String realizarAccion() {
        return "ataca con su espada";
    }
}
