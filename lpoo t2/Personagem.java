public abstract class Personagem {
    protected String nomeTipo;
    protected double saude;
    protected double forca;
    protected double destreza;
    protected Arma arma;

    public Personagem(String nomeTipo, double saude, double forca, double destreza, Arma arma) {
        this.nomeTipo = nomeTipo;
        this.saude = saude;
        this.forca = forca;
        this.destreza = destreza;
        this.arma = arma;
    }

    public void printStatus() {
        if (!estaMorto()) {
            System.out.println(nomeTipo + " [Saúde: " + saude + ", Força: " + forca + ", Destreza: " + destreza + ", " + arma.getNome() + "]");
        } else {
            System.out.println(nomeTipo + " [Morreu, Força: " + forca + ", Destreza: " + destreza + ", " + arma.getNome() + "]");
        }
    }

    public void atacar(Personagem defensor) {
        if (this.estaMorto()) {
            System.out.println("O " + this.nomeTipo + " não consegue atacar, pois está morto.");
            return;
        }

        System.out.println("O " + this.nomeTipo + " ataca o " + defensor.nomeTipo + " com " + this.arma.getNome() + ".");

        if (!defensor.estaMorto()) {
            if (this.destreza > defensor.destreza) { // Ataque bem-sucedido
                double dano = calculaDano(this);
                defensor.recebeDano(dano);
                System.out.println("O ataque foi efetivo com " + dano + " pontos de dano!");
            } else if (this.destreza < defensor.destreza) { // Ataque revidado
                double danoRevidado = calculaDano(defensor);
                this.recebeDano(danoRevidado);
                System.out.println("O ataque foi inefetivo e revidado com " + danoRevidado + " pontos de dano!");
            } else { // Ataque defendido
                System.out.println("O ataque foi defendido, ninguém se machucou!");
            }
        } else {
            System.out.println("Pare! O " + defensor.nomeTipo + " já está morto!");
        }

        // Exibir o status dos personagens após o ataque
        this.printStatus();
        defensor.printStatus();
    }

    public double calculaDano(Personagem personagem){
        return personagem.forca * personagem.arma.getModificadorDano();
    }

    public void recebeDano(double dano) {
        this.saude -= dano;
        if (this.saude < 0.0) {
            this.saude = 0.0;
        }
    }

    public boolean estaMorto() {
        return saude < 1.0;
    }
}
