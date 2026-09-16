package model;

public class Campeao {
    private final int identificadorCampeao;
    private final String nomeCampeao;
    private int vida;
    private final int ataque;
    private final int defesa;

    public Campeao(int identificadorCampeao, String nomeCampeao, int vida, int ataque, int defesa) {
        this.identificadorCampeao = identificadorCampeao;
        this.nomeCampeao = nomeCampeao;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | %s | Vida: %d | Ataque: %d | Defesa: %d", identificadorCampeao, nomeCampeao, vida, ataque, defesa);
    }

    public int getIdentificadorCampeao() {
        return identificadorCampeao;
    }

    public String getNomeCampeao() {
        return nomeCampeao;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(double ganhoVida) {
        vida = (int) (vida + (vida * ganhoVida));
    }

    public int getAtaque() {
        return ataque;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void defender(int ataqueInimigo) {
        int dano = ataqueInimigo - defesa;
        if (dano < 1) {
            dano = 1;
        }
        vida -= dano;
    }
}
