package sample.model;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import sample.control.SalesWindow;
import sample.modelDAO.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;

public class Control {
    ClientDAO clientDAO = new ClientDAOimpl();
    MerchandiseDAO merchandiseDAO = new MerchandiseDAOimpl();
    ProviderDAO providerDAO = new ProviderDAOimpl();
    PurchaseDAO purchaseDAO = new PurchaseDAOimpl();
    SalesDAO salesDAO = new SalesDAOimpl();
    SalesmanDAO salesmanDAO = new SalesmanDAOimpl();

    private ObservableList<Client> clients;
    private ObservableList<Merchandise> merchandises;
    private ObservableList<Provider> providers;
    private ObservableList<Purchase> purchases;
    private ObservableList<Sales> sales;
    private ObservableList<Salesman> salesman;
    private Salesman LogedSalesman;

    private Control(){
        clients = FXCollections.observableArrayList();
        merchandises = FXCollections.observableArrayList();
        providers = FXCollections.observableArrayList();
        purchases = FXCollections.observableArrayList();
        sales = FXCollections.observableArrayList();
        salesman = FXCollections.observableArrayList();
    }

    private static Control instance = new Control();

    public static Control getInstance(){
        return instance;
    }

    public Salesman login(String name, String password) throws SQLException{
        LogedSalesman = salesmanDAO.login(name, password);
        return LogedSalesman;
    }

    public Salesman logado() {

        return LogedSalesman;
    }

    public void deslogar(){
        LogedSalesman = null;
    }

    public Salesman getLogedSalesman() {
        return LogedSalesman;
    }

    public Salesman register(String name, String address, String telephone, String cpf, String email, String password) throws SQLException {
        Salesman s = null;

        s = salesmanDAO.insert(name, (float) 0,address,telephone,cpf,password,email,false);

        return s;
    }

    public void clientRegister(Client c) throws SQLException {
        clientDAO.insert(c.getName(),c.getAddress(),c.getCpf(),c.getTelephone(),c.getEmail());
    }

    public boolean validCpf(String cpf){

        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || (cpf.length() != 11)){
            return false;
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }

            sm = 0;
            peso = 11;

            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))){
                return true;
            } else{
                return false;
            }

        }catch (InputMismatchException erro) {
            return false;
        }

    }

    public ObservableList<Merchandise> merchandiseList() throws SQLException {

        merchandises.clear();

        merchandises.addAll(merchandiseDAO.list());


        return merchandises;
    }

    public ObservableList<Client> clientList() throws SQLException {

        clients.clear();

        clients.addAll(clientDAO.list());

        return clients;
    }

    public ObservableList<Salesman> salesmenList() throws SQLException {

        salesman.clear();

        salesman. addAll(salesmanDAO.list());

        return salesman;
    }

    public ObservableList<Merchandise> merchandiseSearch(String text) throws SQLException{
        merchandises.clear();
        merchandises.addAll(merchandiseDAO.searchList(text));

        return merchandises;
    }

    public ObservableList<Sales> salesSearch(String text) throws SQLException{
        sales.clear();
        sales.addAll(salesDAO.searchList(text));

        return sales;

    }

    public void updateMerchandise(Merchandise m) throws SQLException{
        merchandiseDAO.update(m);

    }

    public void updateSalesman(Salesman s) throws SQLException{
        salesmanDAO.update(s);
    }

    public void updateClient(Client c) throws SQLException{
        clientDAO.update(c);
    }

    public void updateSoldMerchandise(SoldMerchandise s) throws SQLException{

    }

    public ObservableList<Sales> salesList() throws SQLException {
        sales.clear();

        sales.addAll(salesDAO.list());

        return sales;
    }

    public void merchandiseRegister(Merchandise m) throws SQLException{
        merchandiseDAO.insert(m.getName(), m.getAmount(), m.getPrice());

    }

    private Document abreDocumento(String arq) throws IOException{
        PdfWriter writer = new PdfWriter(arq);
        PdfDocument pdf  = new PdfDocument(writer);
        Document document = new Document(pdf);

        return  document;
    }

    public void generateReportMerchandise(){
        try{
            String text;
            String arq = null;
            FileChooser fc = new FileChooser();
            File f = fc.showSaveDialog(null);


            if(f != null) {
                arq = f.getAbsolutePath();
                List<Merchandise> lista;

                //utilizado para buscar a lista de pessoas
                MerchandiseDAO merchandiseDAO = new MerchandiseDAOimpl();

                text = "";
                lista = Control.getInstance().merchandiseList();

                //cria o documento
                Document document = abreDocumento(arq);

                //coloca um parágrafo de cabeçalho, com alinhamento centralizado

                Paragraph paragrafo = new Paragraph("Produtos Cadastrados");
                Paragraph paragrafo2 = new Paragraph(text);

                //alinha contéudo do parágrafo no centro da página
                paragrafo.setTextAlignment(TextAlignment.CENTER);
                paragrafo2.setTextAlignment(TextAlignment.CENTER);

                //indica que o parágrafo é negrito
                paragrafo.setBold();
                paragrafo2.setBold();

                //inclui o paragrafo no documento
                document.add(paragrafo);
                document.add(paragrafo2);

                //cria a tabela
                Table table = criaTableMerchandise();

                //percorre a lista e inclui as células. Cada atributo da pessoa
                //vai em uma célula separada
                for (Merchandise merchandise : lista) {
                    table.addCell("" + merchandise.getId());
                    table.addCell("" + merchandise.getName());
                    table.addCell("" + merchandise.getPrice());
                    table.addCell("" + merchandise.getAmount());
                }

                //adiciona a tabela ao documento
                document.add(table);

                document.close();
            }else{
                System.out.println("Error");
            }
        }catch (IOException | SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteMerchandise(Merchandise m) throws SQLException{
        merchandiseDAO.delete(m);
        merchandises.remove(m);
    }

    private Table criaTableMerchandise() throws IOException {
        Table table = new Table(UnitValue.createPercentArray(new float[]{5, 20, 10, 5}))
                .useAllAvailableWidth();


        //utilizado para criar o cabeçalho da tabela
        String[] cabecalho = {"Id", "Nome", "Preço", "Quantidade"};

        //percore o vetor colocando cada elemento dentro de uma célula
        for (String s : cabecalho) {
            //cria uma célula ue irá conter o conteúdo
            Cell cell = new Cell();
            //o conteúdo é coloca em um parágrafo
            cell.add(new Paragraph(s));
            //ajusta a cor de fundo da célula
            cell.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            //ajusta a linha de borda da célula
            //https://api.itextpdf.com/iText7/7.1.7/com/itextpdf/layout/borders/SolidBorder.html
            cell.setBorder(new SolidBorder(ColorConstants.BLACK, 2));
            //inclui a célula como cabeçalho, que irá se repetir por todas páginas em que a tabela aparecer (caso a quantidade
            //de dados for muito grande e precise de várias páginas)
            table.addHeaderCell(cell);

        }

        //cria uma fonte
        //https://api.itextpdf.com/iText7/7.1.7/com/itextpdf/io/font/constants/StandardFonts.html
        PdfFont font = PdfFontFactory.createFont(StandardFonts.COURIER);
        //ajusta a fonte da tabela, será utilizada por todas as células
        table.setFont(font);
        //ajusta o tamanho da fonte
        table.setFontSize(12);

        return table;
    }

    public void generateReportSalesman(){
        try{
            String text;
            String arq = null;
            FileChooser fc = new FileChooser();
            File f = fc.showSaveDialog(null);


            if(f != null) {
                arq = f.getAbsolutePath();
                List<Salesman> lista;

                //utilizado para buscar a lista de pessoas
                SalesmanDAO salesmanDAO = new SalesmanDAOimpl();

                text = "";
                lista = Control.getInstance().salesmenList();

                //cria o documento
                Document document = abreDocumento(arq);

                //coloca um parágrafo de cabeçalho, com alinhamento centralizado

                Paragraph paragrafo = new Paragraph("Funcionarios Cadastrados");
                Paragraph paragrafo2 = new Paragraph(text);

                //alinha contéudo do parágrafo no centro da página
                paragrafo.setTextAlignment(TextAlignment.CENTER);
                paragrafo2.setTextAlignment(TextAlignment.CENTER);

                //indica que o parágrafo é negrito
                paragrafo.setBold();
                paragrafo2.setBold();

                //inclui o paragrafo no documento
                document.add(paragrafo);
                document.add(paragrafo2);

                //cria a tabela
                Table table = criaTableSalesman();

                //percorre a lista e inclui as células. Cada atributo da pessoa
                //vai em uma célula separada
                for (Salesman salesman : lista) {
                    table.addCell("" + salesman.getId());
                    table.addCell("" + salesman.getName());
                    table.addCell("" + salesman.getAddress());
                    table.addCell("" + salesman.getCpf());
                    table.addCell("" + salesman.getEmail());
                    table.addCell("" + salesman.getTelephone());
                }

                //adiciona a tabela ao documento
                document.add(table);

                document.close();
            }else{
                System.out.println("Error");
            }
        }catch (IOException | SQLException e){
            e.printStackTrace();
        }
    }

    private Table criaTableSalesman() throws IOException {
        Table table = new Table(UnitValue.createPercentArray(new float[]{3, 27, 30, 15,15,10}))
                .useAllAvailableWidth();


        //utilizado para criar o cabeçalho da tabela
        String[] cabecalho = {"Id", "Nome", "Endereço", "CPF", "Email", "Telefone"};

        //percore o vetor colocando cada elemento dentro de uma célula
        for (String s : cabecalho) {
            //cria uma célula ue irá conter o conteúdo
            Cell cell = new Cell();
            //o conteúdo é coloca em um parágrafo
            cell.add(new Paragraph(s));
            //ajusta a cor de fundo da célula
            cell.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            //ajusta a linha de borda da célula
            //https://api.itextpdf.com/iText7/7.1.7/com/itextpdf/layout/borders/SolidBorder.html
            cell.setBorder(new SolidBorder(ColorConstants.BLACK, 2));
            //inclui a célula como cabeçalho, que irá se repetir por todas páginas em que a tabela aparecer (caso a quantidade
            //de dados for muito grande e precise de várias páginas)
            table.addHeaderCell(cell);

        }

        //cria uma fonte
        //https://api.itextpdf.com/iText7/7.1.7/com/itextpdf/io/font/constants/StandardFonts.html
        PdfFont font = PdfFontFactory.createFont(StandardFonts.COURIER);
        //ajusta a fonte da tabela, será utilizada por todas as células
        table.setFont(font);
        //ajusta o tamanho da fonte
        table.setFontSize(12);

        return table;
    }
}
