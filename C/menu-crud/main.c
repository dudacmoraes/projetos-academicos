#include <stdio.h>
#include <stdbool.h>

int main() {

    int escolha_menu;
    float notas_inseridas[5];
    int total_notas = 0;
    int indice;
    float nova_nota = 0;

    while (true) {
        printf("-------------");
        printf("\nMENU DE NOTAS\n");
        printf("-------------");

        printf("\n[1] Inserir nota\n[2] Alterar nota\n[3] Exluir nota\n[4] Listar nota\n[5] Mostrar nota por indice\n[6] Sair");
        printf("\n\nSua escolha: ");
        scanf("%d", &escolha_menu);

        if (escolha_menu == 1){
            if (total_notas < 5) {
                printf("Insira a nota: ");
                scanf("%f", &notas_inseridas[total_notas]);
                total_notas ++;
                printf("Nota inserida com sucesso!\n");
            } else {
                printf("Limite de notas atingido.\n");
            }
        } else if (escolha_menu == 2) {
            printf("Digite o indice: ");
            scanf("%d", &indice);
            indice = indice - 1;

            if (indice < 0 || indice >= total_notas) {
                printf("Indice invalido.\n");
            } else {
                printf("Escolha a nova nota: ");
                scanf("%f", &nova_nota);

                notas_inseridas[indice] = nova_nota;
                printf("Nota alterada com sucesso!\n");
            }
        } else if (escolha_menu == 3) {
            if (total_notas == 0) {
                printf("Nenhuma nota para excluir.\n");
            } else {
                printf("Escolha a nota a ser excluida pelo indice (1 a %d): ", total_notas);
                scanf("%d", &indice);
                indice = indice - 1;

                if (indice < 0 || indice >= total_notas) {
                    printf("Indice invalido.\n");
                } else {
                    for (int contagem = indice; contagem < total_notas - 1; contagem++) {
                        notas_inseridas[contagem] = notas_inseridas[contagem + 1];
                    }
                    total_notas--;
                    printf("Nota excluida com sucesso!\n");
                }

            }
        } else if (escolha_menu == 4) {
            printf("==============");
            printf("\nLISTA DE NOTAS\n");
            printf("==============\n");

            if (total_notas == 0) {
                printf("Nenhuma nota cadastrada.\n");
            } else {
                for (int contagem = 0; contagem < total_notas; contagem ++) {
                    printf("%d- %.1f\n", contagem + 1, notas_inseridas[contagem]);
                }
            }
        } else if (escolha_menu == 5) {
            if (total_notas == 0) {
                printf("Nenhuma nota cadastrada.\n");
            } else {
                printf("Escolha o indice da nota (1 a %d): ", total_notas);
                scanf("%d", &indice);
                indice = indice - 1;

                if (indice < 0 || indice >= total_notas) {
                    printf("Indice invalido.\n");
                } else {
                    printf("%d- %.1f\n", indice + 1, notas_inseridas[indice]);
                }
            }
        } else if (escolha_menu == 6) {
            printf("Encerrando o programa.");
            break;
        } else {
            printf("Escolha invalida!\n");
        }
    }
    return 0;
}