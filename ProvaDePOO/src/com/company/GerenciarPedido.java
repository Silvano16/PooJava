package com.company;

import java.util.Scanner;

public class GerenciarPedido {


    int prod = 0;
    int func = 0;
    public Funcionario funcionarios[] = new Funcionario[20];
    public Produto produtos[] = new Produto[100];
    Cesta cesta = new Cesta();

    public static void main(String[] args) {


        GerenciarPedido gp = new GerenciarPedido();
        Scanner leia = new Scanner(System.in);
        gp.inicializarEstoque();

        int op;
        do {
            System.out.println("//------------------------------------------------------\\");
            System.out.println("||        SEJA MUITO BEM VINDO AO SCOOBY LANCHES        ||");
            System.out.println("\\------------------------------------------------------//");
            System.out.println();
            System.out.println("            |----------------------------|");
            System.out.println("            |       MENU PRINCIPAL       |");
            System.out.println("            |----------------------------|");
            System.out.println("            | 1. Cadastro de Cliente     |");
            System.out.println("            | 2. Cadastrar Funcionario   |");
            System.out.println("            | 3. Registrar Produto       |");
            System.out.println("            | 4. Comprar Produto         |");
            System.out.println("            | 5. Visualizar Estoque      |");
            System.out.println("            | 6. Fazer Pedido            |");
            System.out.println("            | 7. Montar Pedido           |");
            System.out.println("            | 8. Fechar Pedido           |");
            System.out.println("            |----------------------------|");
            System.out.println("            | 9. Sair                    |");
            System.out.println("            |----------------------------|");

            System.out.println();
            System.out.println("Digite a opção desejada: ");
            op = Integer.parseInt(leia.nextLine());

            switch (op) {
                case 1:
                    break;
                case 2:
                    gp.cadastroFuncionario();
                    break;
                case 3:
                    gp.cadastrarProduto();
                    break;
                case 4:
                    gp.comprarProduto();
                    break;
                case 5:
                    gp.visualizarEstoque();
                    break;
                case 6:
                    gp.fazerPedido();
                    break;
                case 7:
                    gp.abrirCarrinho();
                    break;
                case 8:
                    gp.fecharCarrinho();
                    break;
                case 9:
                    System.out.println("Volte Sempre");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }while (op != 9);

    }

    private void cadastrarProduto() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Quantos produtos deseja cadastrar?: ");
        int qtdProdCadastro = Integer.parseInt(leia.nextLine());
        if(prod <= 100){
            produtos[prod] = new Produto();
            produtos[prod].setIdProd(prod+1);
            System.out.println("Digite a descricao do Item");
            produtos[prod].setDescProd(leia.nextLine());
            System.out.println("Digite o valor unitario do Produto");
            produtos[prod].setVlUnitProd(Double.parseDouble(leia.nextLine()));
            System.out.println("Item registrado com sucesso");
            prod++;
            // Listar

        }else{
            System.out.println("O estoque esta lotado");
        }
    }

    public void comprarProduto() {
        Scanner leia = new Scanner(System.in);
        System.out.println("Digite o codigo do produto a ser comprado: ");
        int idProcurado = Integer.parseInt(leia.nextLine());
        boolean comprarItem;
        for (Produto produto: produtos) {
            if (produto != null) {
                if(idProcurado == produto.getIdProd()){
                    System.out.println("Digite a quantidade de " + produto.getDescProd().toUpperCase() + " que deseja comprar: ");
                    int qtd = Integer.parseInt(leia.nextLine());
                    comprarItem = produto.comprar(qtd);
                    if(comprarItem){
                        System.out.println("Produto comprado com sucesso");
                        return;
                    }else{
                        System.out.println("A quantidade não pode ser zero ou negativa");
                        return;
                    }
                }
            }
        }
        System.out.println("Produto nao encontrado");
    }

    public  void visualizarEstoque(){
        System.out.println("Produtos em Estoque");
        for (Produto produto : produtos) {
            if (produto != null) {
                produto.imprimirEtiqueta();
            }
        }
    }

    public void fazerPedido() {
        GerenciarPedido gp = new GerenciarPedido();
        Scanner leia = new Scanner(System.in);
        int idItem;
        int qtdItem;
        int idBebida;
        boolean possuiEstoque;
        do {
            System.out.println("|----------------------------|----------------------------|");
            System.out.println("|         LANCHES            |         BEBIDAS            |");
            System.out.println("|----------------------------|----------------------------|");
            System.out.println("| 101. X-EGG                 | 111. COCA COLA 350ml       |");
            System.out.println("| 102. X-SALADA              | 112. FANTA LARANJA 350ml   |");
            System.out.println("| 103. X-BACON               | 113. SPRITE 350ml          |");
            System.out.println("| 104. X-FRANGO              | 114. COCA COLA 2 litros    |");
            System.out.println("| 105. X-TUDO                | 115. FANTA LARANJA 2 litros|");
            System.out.println("|----------------------------|----------------------------|");
            System.out.println("| 109. SAIR                                               |");
            System.out.println("|----------------------------|----------------------------|");
            System.out.println("Digite o codigo do que deseja comprar: ");
            idItem = Integer.parseInt(leia.nextLine());
            System.out.println("Digite a quantidade que deseja comprar: ");
            qtdItem = Integer.parseInt(leia.nextLine());
            while (qtdItem == 0 || qtdItem <= 0) {
                if (qtdItem == 0) {
                    System.out.println("Não é possivel comprar 0 (zero) unidade");
                } else {
                    System.out.println("Não é possivel comprar menos que 0 (zero) unidade");
                }
                System.out.println("Digite novamente a quantidade que dezeja comprar: ");
                qtdItem = Integer.parseInt(leia.nextLine());
            }

            switch (idItem){
                case 101: // X-Egg
                    /*int vtIdIng101[] = {1, 2, 4, 5, 6, 7, 8, 9, 13, 14, 15};
                    int vtQtdIng101[] = {1, 1, 2, 1, 2, 2, 1, 1, 2, 2, 2};
                    gp.montarPedido(vtIdIng101, vtQtdIng101);*/
                    for (Produto produto: produtos) {
                        if (produto != null) {
                            int vtIdIng[] = {1, 2, 4, 5, 6, 7, 8, 9, 13, 14, 15};
                            int vtQtdIng[] = {1, 1, 2, 1, 2, 2, 1, 1, 5, 5, 5};
                            for (int i = 0; i < vtIdIng.length; i++){
                                if(vtIdIng[i] == produto.getIdProd()){
                                    possuiEstoque = produto.vender(vtQtdIng[i], qtdItem);
                                    if (possuiEstoque == false){
                                        System.out.println("No momento esse lanche não esta disponivel");
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("Aqui esta seu lanche");
                    return;
                case 102: // X-Salada
                    /*int vtIdIng102[] = {1, 2, 8, 9, 10, 11, 12, 13, 14, 15};
                    int vtQtdIng102[] = {1, 1, 4, 4, 1, 1, 4, 2, 2, 2};
                    gp.montarPedido(vtIdIng102, vtQtdIng102);*/

                    /*System.out.println("Digite a quantidade que deseja comprar: ");
                    qtdItem = Integer.parseInt(leia.nextLine());
                    while (qtdItem == 0 || qtdItem <= 0) {
                        if (qtdItem == 0) {
                            System.out.println("Não é possivel comprar 0 (zero) unidade");
                        } else {
                            System.out.println("Não é possivel comprar menos que 0 (zero) unidade");
                        }
                        System.out.println("Digite novamente a quantidade que dezeja comprar: ");
                        qtdItem = Integer.parseInt(leia.nextLine());
                    }*/
                    for (Produto item: produtos) {
                        if (item != null) {
                            int vtIdIng[] = {1, 2, 8, 9, 10, 11, 12, 13, 14, 15};
                            int vtQtdIng[] = {1, 1, 4, 4, 1, 1, 4, 5, 5, 5};
                            for (int i = 0; i < vtIdIng.length; i++){
                                if(vtIdIng[i] == item.getIdProd()){
                                    possuiEstoque = item.vender(vtQtdIng[i], qtdItem);
                                    if (possuiEstoque == false){
                                        System.out.println("No momento esse lanche não esta disponivel");
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("Aqui esta seu lanche");
                    return;
                case 103: // X-Bacon
                    /*int vtIdIng103[] = {1, 2, 4, 6, 7};
                    int vtQtdIng103[] = {1, 1, 1, 1, 2};
                    gp.montarPedido(vtIdIng103, vtQtdIng103);*/

                    /*System.out.println("Digite a quantidade que deseja comprar: ");
                    qtdItem = Integer.parseInt(leia.nextLine());
                    while (qtdItem == 0 || qtdItem <= 0) {
                        if (qtdItem == 0) {
                            System.out.println("Não é possivel comprar 0 (zero) unidade");
                        } else {
                            System.out.println("Não é possivel comprar menos que 0 (zero) unidade");
                        }
                        System.out.println("Digite novamente a quantidade que dezeja comprar: ");
                        qtdItem = Integer.parseInt(leia.nextLine());
                    }*/
                    for (Produto item: produtos) {
                        if (item != null) {
                            int vtIdIng[] = {1, 2, 4, 6, 7, 13, 14, 15};
                            int vtQtdIng[] = {1, 1, 1, 1, 2, 5, 5, 5};
                            for (int i = 0; i < vtIdIng.length; i++){
                                if(vtIdIng[i] == item.getIdProd()){
                                    possuiEstoque = item.vender(vtQtdIng[i], qtdItem);
                                    if (possuiEstoque == false){
                                        System.out.println("No momento esse lanche não esta disponivel");
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("Aqui esta seu lanche");
                    return;
                case 104: // X-Frango
                    /*int vtIdIng104[] = {1,  13, 14, 15};
                    int vtQtdIng104[] = {1,  2, 2, 2};
                    gp.montarPedido(vtIdIng104, vtQtdIng104);*/

                    /*System.out.println("Digite a quantidade que deseja comprar: ");
                    qtdItem = Integer.parseInt(leia.nextLine());
                    while (qtdItem == 0 || qtdItem <= 0) {
                        if (qtdItem == 0) {
                            System.out.println("Não é possivel comprar 0 (zero) unidade");
                        } else {
                            System.out.println("Não é possivel comprar menos que 0 (zero) unidade");
                        }
                        System.out.println("Digite novamente a quantidade que dezeja comprar: ");
                        qtdItem = Integer.parseInt(leia.nextLine());
                    }*/
                    for (Produto item: produtos) {
                        if (item != null) {
                            int vtIdIng[] = {1, 3, 5, 7, 8, 10, 13, 14, 15};
                            int vtQtdIng[] = {1, 2, 1, 2, 2, 1, 5, 5, 5};
                            for (int i = 0; i < vtIdIng.length; i++){
                                if(vtIdIng[i] == item.getIdProd()){
                                    possuiEstoque = item.vender(vtQtdIng[i], qtdItem);
                                    if (possuiEstoque == false){
                                        System.out.println("No momento esse lanche não esta disponivel");
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("Aqui esta seu lanche");
                    return;
                case 105: // X-Tudo
                    /*int vtIdIng105[] = {1, 2, 12, 13, 14};
                    int vtQtdIng105[] = {1, 1, 2, 2, 2};
                    gp.montarPedido(vtIdIng105, vtQtdIng105);*/

                    /*System.out.println("Digite a quantidade que deseja comprar: ");
                    qtdItem = Integer.parseInt(leia.nextLine());
                    while (qtdItem == 0 || qtdItem <= 0) {
                        if (qtdItem == 0) {
                            System.out.println("Não é possivel comprar 0 (zero) unidade");
                        } else {
                            System.out.println("Não é possivel comprar menos que 0 (zero) unidade");
                        }
                        System.out.println("Digite novamente a quantidade que dezeja comprar: ");
                        qtdItem = Integer.parseInt(leia.nextLine());
                    }*/
                    for (Produto item: produtos) {
                        if (item != null) {
                            int vtIdIng[] = {1, 2, 3, 4, 2, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
                            int vtQtdIng[] = {1, 2, 1, 2, 2, 2, 2, 4, 2, 2, 1, 2, 6, 6, 6};
                            for (int i = 0; i < vtIdIng.length; i++){
                                if(vtIdIng[i] == item.getIdProd()){
                                    possuiEstoque = item.vender(vtQtdIng[i], qtdItem);
                                    if (possuiEstoque == false){
                                        System.out.println("No momento esse lanche não esta disponivel");
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("Aqui esta seu lanche");
                    return;
                case 111:
                    idBebida = 16;
                    for (Produto item: produtos) {
                        if (item != null) {
                            if(idBebida == item.getIdProd()){
                                possuiEstoque = item.vender(qtdItem, qtdItem);
                                if (possuiEstoque == false){
                                    System.out.println("No momento esse lanche não esta disponivel");
                                    return;
                                }
                            }
                        }
                    }
                    System.out.println("Aqui esta seu lanche");
                    return;
                case 112:
                    idBebida = 17;
                    for (Produto item: produtos) {
                        if (item != null) {
                            if(idBebida == item.getIdProd()){
                                possuiEstoque = item.vender(qtdItem, qtdItem);
                                if (possuiEstoque == false){
                                    System.out.println("No momento esse lanche não esta disponivel");
                                    return;
                                }
                            }
                        }
                    }
                    System.out.println("Aqui esta seu lanche");
                    return;
                case 113:
                    idBebida = 18;
                    for (Produto item: produtos) {
                        if (item != null) {
                            if(idBebida == item.getIdProd()){
                                possuiEstoque = item.vender(qtdItem, qtdItem);
                                if (possuiEstoque == false){
                                    System.out.println("No momento esse lanche não esta disponivel");
                                    return;
                                }
                            }
                        }
                    }
                    System.out.println("Aqui esta seu lanche");
                    return;
                case 114:
                    idBebida = 19;
                    for (Produto item: produtos) {
                        if (item != null) {
                            if(idBebida == item.getIdProd()){
                                possuiEstoque = item.vender(qtdItem, qtdItem);
                                if (possuiEstoque == false){
                                    System.out.println("No momento esse lanche não esta disponivel");
                                    return;
                                }
                            }
                        }
                    }
                    System.out.println("Aqui esta seu lanche");
                    return;
                case 115:
                    idBebida = 20;
                    for (Produto item: produtos) {
                        if (item != null) {
                            if(idBebida == item.getIdProd()){
                                possuiEstoque = item.vender(qtdItem, qtdItem);
                                if (possuiEstoque == false){
                                    System.out.println("No momento esse lanche não esta disponivel");
                                    return;
                                }
                            }
                        }
                    }
                    System.out.println("Aqui esta seu lanche");
                    return;

                case 109:
                    System.out.println("Volte Sempre");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }while(idItem!=109);
    }

    /*public void montarPedido(int vtIdIng[], int vtQtdIng[]){
        Scanner leia = new Scanner(System.in);
        boolean possuiEstoque;
        int qtdItem;

        qtdItem = Integer.parseInt(leia.nextLine());
        while (qtdItem == 0 || qtdItem <= 0) {
            if (qtdItem == 0) {
                System.out.println("Não é possivel comprar 0 (zero) unidade");
            } else {
                System.out.println("Não é possivel comprar menos que 0 (zero) unidade");
            }
            System.out.println("Digite novamente a quantidade que dezeja comprar: ");
            qtdItem = Integer.parseInt(leia.nextLine());
        }
        for (Produto produto: produtos) {
            if (produto != null) {
                for (int i = 0; i < 5; i++){
                    if(vtIdIng[i] == produto.getIdProd()){
                        possuiEstoque = produto.vender(vtQtdIng[i], qtdItem);
                        if (possuiEstoque == false){
                            System.out.println("No momento esse lanche não esta disponivel");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Aqui esta seu lanche");

    }*/

    public void cadastroFuncionario() {

        Scanner leia = new Scanner(System.in);
        System.out.println("Quantos funcionarioss deseja cadastrar?: ");
        int qtdFunCadastro = Integer.parseInt(leia.nextLine());
        if (func <= 20) {
            for (int i = 0; i < qtdFunCadastro; i++) {
                funcionarios[func] = new Funcionario();
                System.out.println("Digite o ID do fornecedor: ");
                funcionarios[func].setIdFunc(Integer.parseInt(leia.nextLine()));
                System.out.println("Digite o nome do fornecedor: ");
                funcionarios[func].setNome(leia.nextLine());
                System.out.println("Digite o contato: ");
                funcionarios[func].setContato(leia.nextLine());
                System.out.println("Digite o telefone: ");
                funcionarios[func].setFone(leia.nextLine());
                System.out.println("Digite o email: ");
                funcionarios[func].setEmail(leia.nextLine());
                System.out.println("Digite o cargo: ");
                funcionarios[func].setCargo(leia.nextLine());
                func++;
                System.out.println("Funcionario cadastrado com sucesso!");
            }
        }
    }




    private void abrirCarrinho() {
        GerenciarPedido gp = new GerenciarPedido();

        System.out.println("Produtos cadastrados");
        for (Produto produto : produtos) {
            if (produto != null) {
                if (produto.getIdProd() == 1) {
                    System.out.println();
                    continue;
                }
                produto.imprimirEtiqueta();
            }
        }
        Scanner sc = new Scanner(System.in);
        int codigo;
        System.out.println("Digite o codigo do produto a ser adicionado no carrinho: ");
        codigo = Integer.parseInt(sc.nextLine());
        for (Produto produto : produtos) {
            if (produto != null) {
                if (produto.getIdProd() == codigo) {
                    cesta.adicionarItem(produto);
                    System.out.println(produto.getDescProd() + " Adicionado com sucesso!");
                    return;
                }
            }
        }
    }







    private void fecharCarrinho() {
        int entrega = 0;
        Double soma;

        Scanner E = new Scanner(System.in);
        System.out.println("Seu carrinho");
        cesta.exibeLista();
        System.out.println("Total da compra: R$" + cesta.calcularTotal());
        System.out.println("Entrega Opção 1 ou Retirada Opção 2");
        entrega = E.nextInt();

        if (entrega == 1) {
            soma = cesta.calcularTotal() + 2;

            System.out.println("O Total  " + soma);

        }else{
            System.out.println("Retirada em 45 minutos");
        }

        System.out.println("Compra Finaliza");

    }
    public void inicializarEstoque(){
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("pao");
        produtos[prod].setVlUnitProd(4.68);
        produtos[prod].setQtdProd(100);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("hambúrguer");
        produtos[prod].setVlUnitProd(1.72);
        produtos[prod].setQtdProd(100);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("filé de frango");
        produtos[prod].setVlUnitProd(1.50);
        produtos[prod].setQtdProd(100);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("bacon");
        produtos[prod].setVlUnitProd(4.35);
        produtos[prod].setQtdProd(100);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("ovo");
        produtos[prod].setVlUnitProd(0.90);
        produtos[prod].setQtdProd(100);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("presunto");
        produtos[prod].setVlUnitProd(0.99);
        produtos[prod].setQtdProd(100);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("mussarela");
        produtos[prod].setVlUnitProd(0.80);
        produtos[prod].setQtdProd(100);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("tomate");
        produtos[prod].setVlUnitProd(1.07);
        produtos[prod].setQtdProd(100);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("alface");
        produtos[prod].setVlUnitProd(0.25);
        produtos[prod].setQtdProd(100);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("milho");
        produtos[prod].setVlUnitProd(0.40);
        produtos[prod].setQtdProd(100);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("ervilha");
        produtos[prod].setVlUnitProd(0.40);
        produtos[prod].setQtdProd(100);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("cebola roxa");
        produtos[prod].setVlUnitProd(0.15);
        produtos[prod].setQtdProd(100);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("ketchup heinz");
        produtos[prod].setVlUnitProd(0.15);
        produtos[prod].setQtdProd(100);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("mostarda heinz");
        produtos[prod].setVlUnitProd(0.15);
        produtos[prod].setQtdProd(100);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("maionese heinz");
        produtos[prod].setVlUnitProd(0.15);
        produtos[prod].setQtdProd(100);
        prod++;
        // BEBIDAS
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("COCA COLA 350ml");
        produtos[prod].setVlUnitProd(3.50);
        produtos[prod].setQtdProd(50);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("FANTA LARANJA 350ml");
        produtos[prod].setVlUnitProd(2.99);
        produtos[prod].setQtdProd(50);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("SPRITE 350ml");
        produtos[prod].setVlUnitProd(3.11);
        produtos[prod].setQtdProd(50);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("COCA COLA 2 litros");
        produtos[prod].setVlUnitProd(8.00);
        produtos[prod].setQtdProd(50);
        prod++;
        produtos[prod] = new Produto();
        produtos[prod].setIdProd(prod+1);
        produtos[prod].setDescProd("FANTA LARANJA 2 litros");
        produtos[prod].setVlUnitProd(7.50);
        produtos[prod].setQtdProd(50);
        prod++;

    }
}