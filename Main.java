import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        FormaGeometrica[] formas = new FormaGeometrica[100];
        int quantidade = 0;
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n1 - Inserir e calcular área");
            System.out.println("2 - Mostrar todas as formas inseridas");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(tec.nextLine());

            switch (opcao) {
                case 1:
                    if (quantidade == formas.length) {
                        System.out.println("O array está cheio.");
                        break;
                    }

                    System.out.println("1 - Retângulo");
                    System.out.println("2 - Círculo");
                    System.out.print("Tipo da forma: ");
                    int tipo = Integer.parseInt(tec.nextLine());
                    FormaGeometrica forma;

                    if (tipo == 1) {
                        System.out.print("Largura: ");
                        double largura = Double.parseDouble(tec.nextLine().replace(",", "."));
                        System.out.print("Altura: ");
                        double altura = Double.parseDouble(tec.nextLine().replace(",", "."));

                        if (largura <= 0 || altura <= 0) {
                            System.out.println("As medidas devem ser maiores que zero.");
                            break;
                        }

                        forma = new Retangulo(largura, altura);
                    } else if (tipo == 2) {
                        System.out.print("Raio: ");
                        double raio = Double.parseDouble(tec.nextLine().replace(",", "."));

                        if (raio <= 0) {
                            System.out.println("O raio deve ser maior que zero.");
                            break;
                        }

                        forma = new Circulo(raio);
                    } else {
                        System.out.println("Tipo inválido.");
                        break;
                    }

                    System.out.println("Área: " + forma.calcularArea());
                    formas[quantidade] = forma;
                    quantidade++;
                    System.out.println("Forma cadastrada.");
                    break;

                case 2:
                    if (quantidade == 0) {
                        System.out.println("Nenhuma forma cadastrada.");
                    } else {
                        for (int i = 0; i < quantidade; i++) {
                            System.out.println("\nForma " + (i + 1) + ":");
                            System.out.println(formas[i].toString());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        tec.close();
    }
}
